package io.github.zhidao.ms.um.service;

import io.github.zhidao.ms.um.entity.Permission;
import io.github.zhidao.ms.um.dto.PermissionDTO;

import java.util.List;

/**
 * 权限表（支持权限层次）业务逻辑接口
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 **/
public interface PermissionService {

	/**
	 * 新增权限表（支持权限层次）
	 *
	 * @param permissionDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	Integer insert(PermissionDTO permissionDTO);

    /**
     * 新增或修改权限表（支持权限层次）
     *
     * @param permissionDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     **/
    Integer insertOrUpdate(PermissionDTO permissionDTO);


	/**
	 * 删除权限表（支持权限层次），实际上是修改字段is_delete 0未删除 1已删除
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
	 * 修改权限表（支持权限层次）
	 *
	 * @param permissionDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	Integer updateById(PermissionDTO permissionDTO);

	/**
	 * 按参数permissionDTO的非空属性查询列表
	 *
	 * @param permissionDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	List<PermissionDTO> selectListByObject(PermissionDTO permissionDTO);

	/**
	 * 按参数permissionDTO的非空属性查询单条记录
	 *
	 * @param permissionDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	PermissionDTO selectOneByObject(PermissionDTO permissionDTO);

	/**
	 * 主键查询权限表（支持权限层次）
	 *
	 * @param id
	 * @return PermissionDTO
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	PermissionDTO selectById(String id);

}
