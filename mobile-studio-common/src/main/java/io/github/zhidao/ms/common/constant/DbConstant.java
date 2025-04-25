package io.github.zhidao.ms.common.constant;

/**
 * - DB常量
 *
 * @author zhanls 2023/1/24 15:58
 **/
public class DbConstant {

    /******************************* DB FIELD *************************/
    /**
     * DB字段名常量 ID
     */
    public static final String FIELD_ID = "id";
    /**
     * DB字段名常量 创建人
     */
    public static final String FIELD_CREATE_USER = "create_user";
    /**
     * DB字段名常量 创建时间
     */
    public static final String FIELD_CREATE_TIME = "create_time";
    /**
     * DB字段名常量 更新人
     */
    public static final String FIELD_UPDATE_USER = "update_user";

    /**
     * DB字段名常量 更新时间
     */
    public static final String FIELD_UPDATE_TIME = "update_time";
    /**
     * DB字段名常量 是否有效
     */
    public static final String FIELD_VALID = "valid";
    /**
     * DB字段名常量 是否删除
     */
    public static final String FIELD_DELETED = "deleted";

    /******************************* DB VALUE *************************/
    /**
     * DB字段值常量 生效
     */
    public static final String VALUE_VALID = "1";

    /**
     * DB字段值常量 失效
     */
    public static final String VALUE_INVALID = "0";

    /**
     * DB字段值常量 删除
     */
    public static final String VALUE_DELETED = "1";

    /**
     * DB字段值常量 未删除
     */
    public static final String VALUE_NOT_DELETED = "0";

    /******************************* Entity *************************/
    /**
     * Entity属性名常量 id
     */
    public static final String PROPERTIES_ID = "id";
    /**
     * Entity属性名常量 valid
     */
    public static final String PROPERTIES_VALID = "valid";
    /**
     * Entity属性名常量 deleted
     */
    public static final String PROPERTIES_DELETED = "deleted";

    /**
     * Entity属性名常量 createUser
     */
    public static final String PROPERTIES_CREATE_USER = "createUser";
    /**
     * Entity属性名常量 createTime
     */
    public static final String PROPERTIES_CREATE_TIME = "createTime";
    /**
     * Entity属性名常量 deleted
     */
    public static final String PROPERTIES_UPDATE_USER = "updateUser";
    /**
     * Entity属性名常量 deleted
     */
    public static final String PROPERTIES_UPDATE_TIME = "updateTime";

    /**
     * 会话失效或未登陆情况操作人
     */
    public static final String NO_LOGIN = "noLogin";


    /**
     * 排序顺序 倒序
     */
    public static final String ORDER_DESC = "desc";

    /**
     * 排序顺序 正序
     */
    public static final String ORDER_ASC = "asc";

    /**
     * 排序顺序 创建时间正序排序
     */
    public static final String ORDER_BY_CREATE_TIME_ASC = FIELD_CREATE_TIME + " " + ORDER_ASC;
    /**
     * 排序顺序 更新时间正序排序
     */
    public static final String ORDER_BY_UPDATE_TIME_ASC = FIELD_UPDATE_TIME + " " + ORDER_ASC;

}
