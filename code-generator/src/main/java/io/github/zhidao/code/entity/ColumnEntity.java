package io.github.zhidao.code.entity;

/**
 * 列的属性
 *
 * @author update by zhanls 2018年6月26日
 * @version 1.0
 */
public class ColumnEntity {

	//列名
    private String columnName;
    //列名类型
    private String dataType;

    //列JDBC类型(按oralce来)
    private String jdbcType;

    //列名备注
    private String comments;

    //属性名称(第一个字母大写)，如：user_name => UserName
    private String attrName;
    //属性名称(第一个字母小写)，如：user_name => userName
    private String attrname;
    //常量名称
    private String ATTR_NAME;

	//属性类型
    private String attrType;
    //auto_increment
    private String extra;

	public ColumnEntity() {
	}

	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getAttrname() {
		return attrname;
	}
	public void setAttrname(String attrname) {
		this.attrname = attrname;
	}
	public String getAttrName() {
		return attrName;
	}
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
	public String getATTR_NAME() {
		return ATTR_NAME;
	}
	public void setATTR_NAME(String ATTR_NAME) {
		this.ATTR_NAME = ATTR_NAME;
	}

	public String getAttrType() {
		return attrType;
	}
	public void setAttrType(String attrType) {
		this.attrType = attrType;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public String getJdbcType() {
		return jdbcType;
	}
	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}
}
