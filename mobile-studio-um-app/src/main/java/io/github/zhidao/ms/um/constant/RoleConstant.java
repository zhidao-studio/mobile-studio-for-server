package io.github.zhidao.ms.um.constant;


/**
 * 角色表（支持角色层次）Constant 数据库表字段对应的实体类属性名常量类,
 * 					在编写自定义impl层tk.mybatis方法需要指定属性名时使用
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
public class RoleConstant{

	/** ID */
	public static final String ID = "id";
	/** 角色ID */
	public static final String ROLE_ID = "roleId";
	/** 角色名称 */
	public static final String ROLE_NAME = "roleName";
	/** 父级角色ID（根角色为NULL） */
	public static final String PARENT_ROLE_ID = "parentRoleId";
	/** 角色层级（根角色0，子角色逐层+1） */
	public static final String ROLE_LEVEL = "roleLevel";
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

	private RoleConstant() {}
}
