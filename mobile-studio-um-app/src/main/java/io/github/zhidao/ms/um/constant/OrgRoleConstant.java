package io.github.zhidao.ms.um.constant;


/**
 * 组织角色关联表Constant 数据库表字段对应的实体类属性名常量类,
 * 					在编写自定义impl层tk.mybatis方法需要指定属性名时使用
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
public class OrgRoleConstant{

	/** ID */
	public static final String ID = "id";
	/** 组织ID */
	public static final String ORG_ID = "orgId";
	/** 角色ID */
	public static final String ROLE_ID = "roleId";
	/** 企业ID */
	public static final String COMPANY_ID = "companyId";
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

	private OrgRoleConstant() {}
}
