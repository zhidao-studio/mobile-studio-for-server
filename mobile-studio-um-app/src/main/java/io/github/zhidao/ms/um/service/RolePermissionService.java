package io.github.zhidao.ms.um.service;

import io.github.zhidao.ms.um.entity.RolePermission;
import io.github.zhidao.ms.um.dto.RolePermissionDTO;

import java.util.List;

/**
 * 角色权限关联表业务逻辑接口
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 **/
public interface RolePermissionService {

	/**
	 * 新增角色权限关联表
	 *
	 * @param rolePermissionDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	Integer insert(RolePermissionDTO rolePermissionDTO);

    /**
     * 新增或修改角色权限关联表
     *
     * @param rolePermissionDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     **/
    Integer insertOrUpdate(RolePermissionDTO rolePermissionDTO);


	/**
	 * 删除角色权限关联表，实际上是修改字段is_delete 0未删除 1已删除
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
	 * 修改角色权限关联表
	 *
	 * @param rolePermissionDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	Integer updateById(RolePermissionDTO rolePermissionDTO);

	/**
	 * 按参数rolePermissionDTO的非空属性查询列表
	 *
	 * @param rolePermissionDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	List<RolePermissionDTO> selectListByObject(RolePermissionDTO rolePermissionDTO);

	/**
	 * 按参数rolePermissionDTO的非空属性查询单条记录
	 *
	 * @param rolePermissionDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	RolePermissionDTO selectOneByObject(RolePermissionDTO rolePermissionDTO);

	/**
	 * 主键查询角色权限关联表
	 *
	 * @param id
	 * @return RolePermissionDTO
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	RolePermissionDTO selectById(String id);

}
