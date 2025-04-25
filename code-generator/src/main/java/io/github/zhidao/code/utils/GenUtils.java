package io.github.zhidao.code.utils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;

import cn.hutool.core.lang.Dict;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import io.github.zhidao.code.entity.TableEntity;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import io.github.zhidao.code.constant.GenConstant;
import io.github.zhidao.code.entity.ColumnEntity;

/**
 * 代码生成器   工具类
 *
 * @author  update by  zhanls 2018年6月26日
 * @version 1.0
 */
public class GenUtils {
    //模板路径
    public static final String
            SRC_MAIN_RESOURCES_TEMPLATE = "src"+File.separator+"main"+File.separator+"resources"+File.separator+"template"+File.separator;

    public static List<String> getRetrieveTemplates(){
    	 //在此添加每个实体都需要渲染一次的模板
        List<String> templates = new ArrayList<String>();
        templates.add("template/Entity.java.vm");
        templates.add("template/DTO.java.vm");
        templates.add("template/Mapper.java.vm");
        templates.add("template/Service.java.vm");
        templates.add("template/ServiceImpl.java.vm");
        templates.add("template/Controller.java.vm");
        templates.add("template/Mapper.xml.vm");
        templates.add("template/Constant.java.vm");
        templates.add("template/reqJson.txt.vm");
        templates.add("template/SimplePage.vue");
        return templates;
    }

    public static List<String> getPublicTemplates(){
    	//在此添加只渲染一次的公共模板
        List<String> templates = new ArrayList<>();
        return templates;
    }




    /**
     * 生成公共模块代码
     */
    public static void generateCommonPart(ZipOutputStream zip){
    	ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    	HttpServletRequest request = requestAttributes.getRequest();
		String moduleName = request.getParameter("moduleName");
		String author = request.getParameter("author");
    	//配置信息
        Configuration config = getConfig();

        //设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" );
        Velocity.init(prop);
        String mainPath = config.getString("mainPath" );
        mainPath = StringUtils.isBlank(mainPath) ? "io.renren" : mainPath;
        //在此添加模板数据
        Map<String, Object> map = new HashMap<>();
        VelocityContext context = new VelocityContext(map);

        //获取模板列表
        List<String> templates = getPublicTemplates();
        for (String template : templates) {
            //渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8" );
            tpl.merge(context, sw);

            try {
                //添加到zip
                zip.putNextEntry(new ZipEntry(getFileName(template, "", config.getString("package" ), moduleName)));
                IOUtils.write(sw.toString(), zip, "UTF-8" );
                IOUtils.closeQuietly(sw);
                zip.closeEntry();
            } catch (IOException e) {
                throw new RRException("渲染模板失败：" + template, e);
            }
        }
    }

    /**
     * 采用Beetl新一代模板引擎生成代码，主入口
     *
     * @param
     * @return
     * @updateRecord - 初次创建
     * @version 1.0 (2019年07月22日) zhanls
     **/
    public static void beetlGeneratorCode(Map<String, String> table,
                                     List<Map<String, String>> columns, ZipOutputStream zip) throws Exception {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String moduleName = request.getParameter("moduleName");
        String author = request.getParameter("author");
        //配置信息
        Configuration config = getConfig();
        moduleName = StringUtils.isBlank(moduleName)?config.getString("moduleName"):moduleName;
        author=  StringUtils.isBlank(author)?config.getString("author"):author;

        boolean hasBigDecimal = false;
        //表信息
        TableEntity tableEntity = new TableEntity();
        tableEntity.setTableName(table.get("tableName" ));
        tableEntity.setComments(table.get("tableComment" ));
        //表名转换成Java类名
        String className = tableToJava(tableEntity.getTableName(), config.getString("tablePrefix" ));
        tableEntity.setClassName(className);
        tableEntity.setClassname(StringUtils.uncapitalize(className));

        //列信息
        List<ColumnEntity> columsList = new ArrayList<>();
        for(Map<String, String> column : columns){
            ColumnEntity columnEntity = new ColumnEntity();
            columnEntity.setColumnName(column.get("columnName" ));
            columnEntity.setDataType(column.get("dataType"));
            //这里做一个数据类型适配（Oralce/Mysql）
            columnEntity.setJdbcType(JDBCTypeUtils.dataType2JdbcTypeMysql(column.get("dataType").toUpperCase()));
            columnEntity.setComments(column.get("columnComment" ));
            columnEntity.setExtra(column.get("extra" ));

            //列名转换成Java属性名
            String attrName = columnToJava(columnEntity.getColumnName());
            columnEntity.setAttrName(attrName);
            columnEntity.setAttrname(StringUtils.uncapitalize(attrName));
            columnEntity.setATTR_NAME(columnToJavaForConstant(columnEntity.getColumnName()));

            //列的数据类型，转换成Java类型
            System.out.println("columnEntity.getDataType()" + columnEntity.getDataType());
            String attrType = config.getString(columnEntity.getDataType(), "unknowType" );
            columnEntity.setAttrType(attrType);
            if (!hasBigDecimal && attrType.equals("BigDecimal" )) {
                hasBigDecimal = true;
            }
            //是否主键
            if (GenConstant.PRIMARY_KEY_DIC_MYSQL.equalsIgnoreCase(column.get("columnKey" )) && tableEntity.getPk() == null) {
                System.out.println("pkkkk columnEntity" +  JSON.toJSONString(columnEntity));
                tableEntity.setPk(columnEntity);
            }

            columsList.add(columnEntity);
        }
        tableEntity.setColumns(columsList);

        //没主键，则第一个字段为主键
        if (tableEntity.getPk() == null) {
            tableEntity.setPk(tableEntity.getColumns().get(0));
        }

        //设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" );
        Velocity.init(prop);
        String mainPath = config.getString("mainPath" );
        mainPath = StringUtils.isBlank(mainPath) ? "io.renren" : mainPath;
        //封装模板数据
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", tableEntity.getTableName());
        map.put("comments", tableEntity.getComments());
        map.put("pk", tableEntity.getPk());
        map.put("className", tableEntity.getClassName());
        map.put("classname", tableEntity.getClassname());
        map.put("pathName", tableEntity.getClassname());
        map.put("columns", tableEntity.getColumns());
        map.put("hasBigDecimal", hasBigDecimal);
        map.put("mainPath", mainPath);
        map.put("package", config.getString("package" ));
        map.put("moduleName", moduleName);
        map.put("author", author);
        map.put("email", config.getString("email" ));
        map.put("datetime", DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
        VelocityContext context = new VelocityContext(map);

        //获取模板列表
        List<String> templates = getRetrieveTemplates();
        for (String template : templates) {
            if("template/SimplePage.vue".equals(template)){
                TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig(SRC_MAIN_RESOURCES_TEMPLATE, TemplateConfig.ResourceMode.WEB_ROOT));
                cn.hutool.extra.template.Template hutoollTemplate = engine.getTemplate("SimplePage.vue");
                String result = hutoollTemplate.render(Dict.create().set("dataMap", map));
                try {
                    //添加到zip
                    zip.putNextEntry(new ZipEntry(getFileName(template, tableEntity.getClassName(), config.getString("package"), moduleName)));
                    IOUtils.write(result, zip, "UTF-8" );
                    zip.closeEntry();
                } catch (IOException e) {
                    throw new RRException("渲染模板失败，表名：" + tableEntity.getTableName(), e);
                }
            }else{
                //渲染模板
                StringWriter sw = new StringWriter();
                Template tpl = Velocity.getTemplate(template, "UTF-8" );
                tpl.merge(context, sw);
                try {
                    //添加到zip
                    zip.putNextEntry(new ZipEntry(getFileName(template, tableEntity.getClassName(), config.getString("package"), moduleName)));
                    IOUtils.write(sw.toString(), zip, "UTF-8" );
                    IOUtils.closeQuietly(sw);
                    zip.closeEntry();
                } catch (IOException e) {
                    throw new RRException("渲染模板失败，表名：" + tableEntity.getTableName(), e);
                }
            }

        }
    }

    /**
     * 生成实体代码
     */
    public static void generatorCode(Map<String, String> table,
                                     List<Map<String, String>> columns, ZipOutputStream zip) {
    	ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    	HttpServletRequest request = requestAttributes.getRequest();
		String moduleName = request.getParameter("moduleName");
		String author = request.getParameter("author");
    	//配置信息
        Configuration config = getConfig();
        moduleName = StringUtils.isBlank(moduleName)?config.getString("moduleName"):moduleName;
        author=  StringUtils.isBlank(author)?config.getString("author"):author;

        boolean hasBigDecimal = false;
        //表信息
        TableEntity tableEntity = new TableEntity();
        tableEntity.setTableName(table.get("tableName" ));
        tableEntity.setComments(table.get("tableComment" ));
        //表名转换成Java类名
        String className = tableToJava(tableEntity.getTableName(), config.getString("tablePrefix" ));
        tableEntity.setClassName(className);
        tableEntity.setClassname(StringUtils.uncapitalize(className));

        //列信息
        List<ColumnEntity> columsList = new ArrayList<>();
        for(Map<String, String> column : columns){
            ColumnEntity columnEntity = new ColumnEntity();
            columnEntity.setColumnName(column.get("columnName" ));
            columnEntity.setDataType(column.get("dataType"));
            //这里做一个数据类型适配（Oralce/Mysql）
            columnEntity.setJdbcType(JDBCTypeUtils.dataType2JdbcTypeMysql(column.get("dataType").toUpperCase()));
            columnEntity.setComments(column.get("columnComment" ));
            columnEntity.setExtra(column.get("extra" ));

            //列名转换成Java属性名
            String attrName = columnToJava(columnEntity.getColumnName());
            columnEntity.setAttrName(attrName);
            columnEntity.setAttrname(StringUtils.uncapitalize(attrName));
            columnEntity.setATTR_NAME(columnToJavaForConstant(columnEntity.getColumnName()));

            //列的数据类型，转换成Java类型
            System.out.println("columnEntity.getDataType()" + columnEntity.getDataType());
            String attrType = config.getString(columnEntity.getDataType(), "unknowType" );
            columnEntity.setAttrType(attrType);
            if (!hasBigDecimal && attrType.equals("BigDecimal" )) {
                hasBigDecimal = true;
            }
            //是否主键
            if (GenConstant.PRIMARY_KEY_DIC_MYSQL.equalsIgnoreCase(column.get("columnKey" )) && tableEntity.getPk() == null) {
            	System.out.println("pkkkk columnEntity" +  JSON.toJSONString(columnEntity));
                tableEntity.setPk(columnEntity);
            }

            columsList.add(columnEntity);
        }
        tableEntity.setColumns(columsList);

        //没主键，则第一个字段为主键
        if (tableEntity.getPk() == null) {
            tableEntity.setPk(tableEntity.getColumns().get(0));
        }

        //设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader" );
        Velocity.init(prop);
        String mainPath = config.getString("mainPath" );
        mainPath = StringUtils.isBlank(mainPath) ? "io.renren" : mainPath;
        //封装模板数据
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", tableEntity.getTableName());
        map.put("comments", tableEntity.getComments());
        map.put("pk", tableEntity.getPk());
        map.put("className", tableEntity.getClassName());
        map.put("classname", tableEntity.getClassname());
        map.put("pathName", tableEntity.getClassname());
        map.put("columns", tableEntity.getColumns());
        map.put("hasBigDecimal", hasBigDecimal);
        map.put("mainPath", mainPath);
        map.put("package", config.getString("package" ));
        map.put("moduleName", moduleName);
        map.put("author", author);

        map.put("email", config.getString("email" ));
        map.put("datetime", DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
        VelocityContext context = new VelocityContext(map);

        //获取模板列表
        List<String> templates = getRetrieveTemplates();
        for (String template : templates) {

            //渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8" );
            tpl.merge(context, sw);

            try {
                //添加到zip
                zip.putNextEntry(new ZipEntry(getFileName(template, tableEntity.getClassName(), config.getString("package"), moduleName)));
                IOUtils.write(sw.toString(), zip, "UTF-8" );
                IOUtils.closeQuietly(sw);
                zip.closeEntry();
            } catch (IOException e) {
                throw new RRException("渲染模板失败，表名：" + tableEntity.getTableName(), e);
            }
        }
    }


    /**
     * 列名转换成Java属性名
     */
    public static String columnToJava(String columnName) {
        return WordUtils.capitalizeFully(columnName, new char[]{'_'}).replace("_", "" );
    }

    /**
     * 列名转换成Java常量名
     */
    public static String columnToJavaForConstant(String columnName) {
        return columnName.toUpperCase();
    }

    /**
     * 表名转换成Java类名
     */
    public static String tableToJava(String tableName, String tablePrefix) {
        if (StringUtils.isNotBlank(tablePrefix)) {
            tableName = tableName.replace(tablePrefix, "" );
        }
        return columnToJava(tableName);
    }

    /**
     * 获取配置信息
     */
    public static Configuration getConfig() {
        try {
            return new PropertiesConfiguration("generator-mysql.properties");
        } catch (ConfigurationException e) {
            throw new RRException("获取配置文件失败，", e);
        }
    }

    /**
     * 获取文件名
     */
    public static String getFileName(String template, String className, String packageName, String moduleName) {
        String packagePath = "main" + File.separator + "java" + File.separator;
        String resourcePath = "main" + File.separator + "resources" + File.separator + "mapper" + File.separator;
        String testPath = "test" + File.separator + "reqJson" + File.separator;
        String vuePath = "vue" +File.separator+ "page" + File.separator;
        if (StringUtils.isNotBlank(packageName)) {
            packagePath += packageName.replace(".", File.separator) + File.separator + moduleName + File.separator;
        }
        if (template.contains( "BaseEntity.java.vm" )) {
        	return packagePath + "entity" + File.separator + "BaseEntity.java";
        }

        if (template.contains("DTO.java.vm" )) {
        	return packagePath + "dto" + File.separator + className + "DTO.java";
        }
        if (template.contains("Entity.java.vm" )) {
            return packagePath + "entity" + File.separator + className + ".java";
        }
        if (template.contains("Service.java.vm" )) {
            return packagePath + "service" + File.separator + className + "Service.java";
        }

        if (template.contains("ServiceImpl.java.vm" )) {
            return packagePath + "service" + File.separator + "impl" + File.separator + className + "ServiceImpl.java";
        }

        if (template.contains("Constant.java.vm" )) {
            return packagePath + "constant" + File.separator + className + "Constant.java";
        }

        if (template.contains("Controller.java.vm" )) {
            return packagePath + "controller" + File.separator + className + "Controller.java";
        }
        if (template.contains("Mapper.java.vm" )) {
        	return packagePath + "mapper" + File.separator + className + "Mapper.java";
        }
        //文件生成路径
        if (template.contains( "Mapper.xml.vm" )) {
        	return resourcePath + className + "Mapper.xml";
        }
        //json模拟请求生成路径
        if (template.contains( "reqJson.txt.vm" )) {
        	return testPath + className + "Json.txt";
        }
        //Vue页面生成路径
        if (template.contains( "SimplePage.vue" )) {
            return vuePath + className + ".vue";
        }
        return null;
    }
}
