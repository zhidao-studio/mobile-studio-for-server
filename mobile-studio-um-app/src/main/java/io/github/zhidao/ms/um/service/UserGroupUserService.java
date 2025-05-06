package io.github.zhidao.ms.um.service;

import io.github.zhidao.ms.um.entity.UserGroupUser;
import io.github.zhidao.ms.um.dto.UserGroupUserDTO;

import java.util.List;

/**
 * 用户与用户组关联表业务逻辑接口
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 **/
public interface UserGroupUserService {

	/**
	 * 新增用户与用户组关联表
	 *
	 * @param userGroupUserDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	Integer insert(UserGroupUserDTO userGroupUserDTO);

    /**
     * 新增或修改用户与用户组关联表
     *
     * @param userGroupUserDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     **/
    Integer insertOrUpdate(UserGroupUserDTO userGroupUserDTO);


	/**
	 * 删除用户与用户组关联表，实际上是修改字段is_delete 0未删除 1已删除
	 *
	 * @param id
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	Integer deleteById(String id);

	/**
	 * 置单条记录为失效
	 *
	 * @param id
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	Integer updateToInValidateById(String id);

	/**
	 * 置单条记录为有效
	 *
	 * @param id
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	Integer updateToValidateById(String id);

	/**
	 * 修改用户与用户组关联表
	 *
	 * @param userGroupUserDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	Integer updateById(UserGroupUserDTO userGroupUserDTO);

	/**
	 * 按参数userGroupUserDTO的非空属性查询列表
	 *
	 * @param userGroupUserDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	List<UserGroupUserDTO> selectListByObject(UserGroupUserDTO userGroupUserDTO);

	/**
	 * 按参数userGroupUserDTO的非空属性查询单条记录
	 *
	 * @param userGroupUserDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	UserGroupUserDTO selectOneByObject(UserGroupUserDTO userGroupUserDTO);

	/**
	 * 主键查询用户与用户组关联表
	 *
	 * @param id
	 * @return UserGroupUserDTO
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	UserGroupUserDTO selectById(String id);

}
