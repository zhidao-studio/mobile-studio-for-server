package io.github.zhidao.ms.um.constant;


/**
 * 岗位表（支持岗位层次）Constant 数据库表字段对应的实体类属性名常量类,
 * 					在编写自定义impl层tk.mybatis方法需要指定属性名时使用
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
public class PositionConstant{

	/** ID */
	public static final String ID = "id";
	/** 岗位ID */
	public static final String POSITION_ID = "positionId";
	/** 岗位名称 */
	public static final String POSITION_NAME = "positionName";
	/** 上级岗位ID（顶级岗位为NULL） */
	public static final String PARENT_POSITION_ID = "parentPositionId";
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

	private PositionConstant() {}
}
