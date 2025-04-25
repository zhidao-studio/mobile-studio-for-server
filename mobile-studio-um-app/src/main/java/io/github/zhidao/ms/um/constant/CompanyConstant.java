package io.github.zhidao.ms.um.constant;


/**
 * 公司企业表Constant 数据库表字段对应的实体类属性名常量类,
 * 					在编写自定义impl层tk.mybatis方法需要指定属性名时使用
 * @author zhanls 2025年04月25日
 * @version 1.0
 */
public class CompanyConstant{

	/** ID */
	public static final String ID = "id";
	/** 创建人 */
	public static final String CREATE_USER = "createUser";
	/** 创建时间 */
	public static final String CREATE_TIME = "createTime";
	/** 更新人 */
	public static final String UPDATE_USER = "updateUser";
	/** 更新时间 */
	public static final String UPDATE_TIME = "updateTime";
	/** 是否有效 */
	public static final String VALID = "valid";
	/** 是否删除 */
	public static final String DELETED = "deleted";
	/** 企业ID */
	public static final String COMPANY_ID = "companyId";
	/** 企业名称 */
	public static final String COMPANY_NAME = "companyName";
	/** 企业类型 */
	public static final String COMPANY_TYPE = "companyType";

	private CompanyConstant() {}
}
