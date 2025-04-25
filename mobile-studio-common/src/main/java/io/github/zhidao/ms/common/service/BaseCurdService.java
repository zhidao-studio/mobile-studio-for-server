package io.github.zhidao.ms.common.service;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import io.github.zhidao.ms.common.constant.DbConstant;
import io.github.zhidao.ms.common.entity.BaseEntity;
import io.github.zhidao.ms.common.enums.CommEnum;
import io.github.zhidao.ms.common.util.DtoUtils;
import io.github.zhidao.ms.common.util.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 基础CURD类
 *
 * zhanls 2023/2/27 21:50
 */
@Slf4j
public class BaseCurdService<T> {

    @Autowired
    public Mapper<T> mapper;

    /**
     * 获取当前用户
     * zhanls 2023/2/27 21:34
     */
    private String currentUser() {
        return UserUtils.getUserInfo();
    }

    /**
     * ID 生成策略
     * zhanls 2023/2/27 21:50
     **/
    public String generateId() {
        return IdUtil.simpleUUID();
    }

    /**
     * 通用新增服务
     *
     * @param t 待保存的业务类
     * @return -1 标识失败 否则标识成功
     * zhanls 2023/2/27 21:50
     **/
    public Integer baseInsert(T t) {
        if (t instanceof BaseEntity) {
            //允许自己生成id
            if (StrUtil.isBlank(((BaseEntity) t).getId())) {
                ((BaseEntity) t).setId(generateId());
            }
            setBaseData((BaseEntity) t);
            return mapper.insertSelective(t);
        }
        return -1;
    }


    /**
     * 通用新增服务,支持自定义ID
     *
     * @param t  待保存的业务类
     * @param id 自定义主键
     * @return -1 标识失败,反之成功
     * zhanls 2023/2/27 21:50
     **/
    public Integer baseInsert(T t, String id) {
        if (t instanceof BaseEntity) {
            if (StrUtil.isNotEmpty(id)) {
                ((BaseEntity) t).setId(id);
            }
            return baseInsert(t);
        }
        return -1;
    }

    /**
     * 新增或者保存baseEntity通用服务
     *
     * @param t    业务类
     * @param uuId 业务主键
     * @return -1 标识失败,反之成功
     * zhanls 2023/2/27 21:50
     */
    public Integer insertOrUpdate(T t, String uuId) {
        if (t instanceof BaseEntity) {
            String id = ((BaseEntity) t).getId();
            if (StrUtil.isNotBlank(id)) {
                return baseUpdateByPK(t);
            } else {
                return baseInsert(t, uuId);
            }
        }
        return -1;
    }

    /**
     * 通用删除服务：根据业务类主键进行删除
     *
     * @param t  业务类
     * @param id 业务主键
     * @return -1 标识失败,反之成功
     * zhanls 2023/2/27 21:50
     **/
    public Integer baseDeleteByPK(String id, T t) {
        if (StrUtil.isNotBlank(id)) {
            ((BaseEntity) t).setId(id);
        }
        return baseDeleteByPK(t);
    }

    /**
     * 通用删除服务：根据业务类主键进行删除
     *
     * @param t 业务类
     * @return -1 标识失败,反之成功
     * zhanls 2023/2/27 21:50
     **/
    public Integer baseDeleteByPK(T t) {
        if (t instanceof BaseEntity) {
            setDeletedData((BaseEntity) t);
            return updateById(t);
        }
        return -1;
    }


    /**
     * 通用更新服务:按传入业务类的主键对业务类进行更新
     *
     * @param t 业务类
     * @return -1 标识失败,反之成功
     * zhanls 2023/2/27 21:50
     **/
    public Integer baseUpdateByPK(T t) {
        if (t instanceof BaseEntity) {
            return updateById(t);
        }
        return -1;
    }


    /**
     * 私有：mapper更新新服务:按传入业务类的主键对业务类进行更新
     *
     * @param t 业务类
     * @return -1 标识失败,反之成功
     * zhanls 2023/2/27 21:50
     **/
    private Integer updateById(T t) {
        setUpdateData((BaseEntity) t);
        Example example = new Example(t.getClass(), true, true);
        example.createCriteria().andEqualTo(DbConstant.PROPERTIES_ID, ((BaseEntity) t).getId());
        return mapper.updateByExampleSelective(t, example);
    }

    /**
     * 通用失效服务:按传入业务类的主键对业务类进行失效操作
     *
     * @param t 业务类
     * @return -1 标识失败,反之成功
     * zhanls 2023/2/27 21:50
     **/
    public Integer baseDisableByPK(T t) {
        if (t instanceof BaseEntity) {
            setInValidData((BaseEntity) t);
            return updateById(t);
        }
        return -1;
    }

    /**
     * 通用失效服务:按传入业务类的主键对业务类进行失效操作
     *
     * @param t  业务类
     * @param id 业务类主键
     * @return -1 标识失败,反之成功
     * zhanls 2023/2/27 21:50
     **/
    public Integer baseDisableByPK(String id, T t) {
        if (StrUtil.isNotBlank(id)) {
            ((BaseEntity) t).setId(id);
        }
        return baseDisableByPK(t);
    }

    /**
     * 通用生效服务:按传入业务类的主键对业务类进行生效操作
     *
     * @param t 业务类
     * @return -1 标识失败,反之成功
     * zhanls 2023/2/27 21:50
     **/
    public Integer baseEnableByPK(T t) {
        if (t instanceof BaseEntity) {
            setValidData((BaseEntity) t);
            return updateById(t);
        }
        return -1;
    }

    /**
     * 通用生效服务:按传入业务类的主键对业务类进行生效操作
     *
     * @param t  业务类
     * @param id 业务主键
     * @return -1 标识失败,反之成功
     * zhanls 2023/2/27 21:50
     **/
    public Integer baseEnableByPK(String id, T t) {
        if (StrUtil.isNotBlank(id)) {
            ((BaseEntity) t).setId(id);
        }
        return baseEnableByPK(t);
    }

    /**
     * 通用查询单体服务:按传入业务类的主键对业务类进行(未删除)单体业务查询操作
     * 注：根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     *
     * @param t 业务类
     * @return -1 标识失败,反之成功
     * zhanls 2023/2/27 21:50
     **/
    public T baseSelectByPK(T t) {
        ((BaseEntity) t).setDeleted(DbConstant.VALUE_NOT_DELETED);
        return baseSelectByPKAndNotCareOthers(t);
    }

    /**
     * 通用查询单体服务:按传入业务类的主键对业务类进行(不care是否有效、删除)单体业务查询操作
     * 注：根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     *
     * @param t 业务类
     * @return -1 标识失败,反之成功
     * zhanls 2023/2/27 21:50
     **/
    public T baseSelectByPKAndNotCareOthers(T t) {
        if (t instanceof BaseEntity) {
            return mapper.selectOne(t);
        }
        return null;
    }


    /**
     * 通用查询列表服务:传入的对象的非空属性为条件查询列表，按创建日期倒序排序
     * 注：允许返回被逻辑删除的数据
     *
     * @param t 业务类
     * @return -1 标识失败,反之成功
     * zhanls 2023/2/27 21:50
     **/
    protected List<T> baseSelectListByObjectAllowDelete(T t) {
        // "" -> null
        T changeT = DtoUtils.setNullValue(t);
        List<T> list = new ArrayList<>();
        if (t instanceof BaseEntity) {
            // null 值不进入查询条件
            Example example = getExample(changeT);
            example.setOrderByClause(DbConstant.ORDER_BY_CREATE_TIME_ASC);
            list = mapper.selectByExample(example);
        }
        return list;
    }

    /**
     * 通用查询列表服务:传入的对象的非空属性为条件查询列表，按创建日期倒序排序
     * 注：不允许返回被逻辑删除的数据
     *
     * @param t 业务类
     * @return -1 标识失败,反之成功
     * zhanls 2023/2/27 21:50
     **/
    public List<T> baseSelectListByObject(T t) {
        ((BaseEntity) t).setDeleted(DbConstant.VALUE_NOT_DELETED);
        return baseSelectListByObjectAllowDelete(t);
    }

    /**
     * 通用代码，查询单个对象
     *
     * @param t 业务类
     * @return t 业务类
     * zhanls 2023/2/27 21:50
     */
    public T baseSelectOneByObject(T t) {
        if (t instanceof BaseEntity) {
            ((BaseEntity) t).setDeleted(DbConstant.VALUE_NOT_DELETED);
            return mapper.selectOne(t);
        } else {
            /*非法的实例类型是否抛出异常后续考虑*/
            return null;
        }

    }


    /**
     * 以传入的对象的非空属性为条件查询列表，按创建日期正序或到倒序排序
     *
     * @param t             业务类
     * @param orderByClause 升序或者降序
     * @return list 业务列表
     * zhanls 2023/2/27 21:50
     */
    public List<T> baseSelectListByObjectOrderByClause(T t, String orderByClause) {
        List<T> list = new ArrayList<>();
        if (t instanceof BaseEntity) {
            ((BaseEntity) t).setDeleted(DbConstant.VALUE_NOT_DELETED);
            Example example = getExample(t);
            example.setOrderByClause(orderByClause);
            list = mapper.selectByExample(example);
        }
        return list;
    }


    /**
     * 通用代码，获取t内非空属性
     *
     * @param t 业务类
     * @return example 查询对象
     * zhanls 2023/2/27 21:50
     */
    private Example getExample(T t) {
        Example example = new Example(t.getClass(), true, true);
        Criteria criteria = example.createCriteria();
        // 获取t内非null属性
        for (Field field : FieldUtils.getAllFields(t.getClass())) {
            field.setAccessible(true);
            try {
                if (ObjectUtil.isNotNull(field.get(t)) && (!"serialVersionUID".equals(field.getName()))) {
                    criteria.andEqualTo(field.getName(), field.get(t));
                }
            } catch (IllegalAccessException e) {
                log.error("通用代码，获取t内非null属性，发生异常{}", e);
            }
        }
        return example;
    }


    /**
     * 私有 - 设置六要素(除id)
     * zhanls 2023/2/27 21:28
     */
    private void setBaseData(BaseEntity t) {
        t.setCreateUser(currentUser());
        t.setCreateTime(LocalDateTimeUtil.now());
        t.setValid(CommEnum.YES.getCode());
        t.setDeleted(CommEnum.NO.getCode());
        setUpdateData(t);
    }

    /**
     * 私有 - 设置更新信息
     * zhanls 2023/2/27 21:32
     */
    private void setUpdateData(BaseEntity t) {
        t.setUpdateUser(currentUser());
        t.setUpdateTime(LocalDateTimeUtil.now());
    }

    /**
     * 私有 - 设置删除状态(无效 + 删除)
     * zhanls 2023/2/27 21:49
     */
    private void setDeletedData(BaseEntity t) {
        t.setValid(CommEnum.NO.getCode());
        t.setDeleted(CommEnum.YES.getCode());
    }
    /**
     * 私有 - 设置无效状态
     * zhanls 2023/2/27 21:50
     */
    private void setInValidData(BaseEntity t) {
        t.setValid(CommEnum.NO.getCode());
        t.setDeleted(CommEnum.NO.getCode());
    }

    /**
     * 私有 - 无效转有效状态
     * zhanls 2023/2/27 21:50
     */
    private void setValidData(BaseEntity t) {
        t.setValid(CommEnum.YES.getCode());
        t.setDeleted(CommEnum.NO.getCode());
    }
}
