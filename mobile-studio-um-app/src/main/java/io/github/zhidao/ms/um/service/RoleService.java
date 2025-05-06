package io.github.zhidao.ms.um.service;

import io.github.zhidao.ms.um.entity.Role;
import io.github.zhidao.ms.um.dto.RoleDTO;

import java.util.List;

/**
 * 角色表（支持角色层次）业务逻辑接口
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 **/
public interface RoleService {

	/**
	 * 新增角色表（支持角色层次）
	 *
	 * @param roleDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	Integer insert(RoleDTO roleDTO);

    /**
     * 新增或修改角色表（支持角色层次）
     *
     * @param roleDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     **/
    Integer insertOrUpdate(RoleDTO roleDTO);


	/**
	 * 删除角色表（支持角色层次），实际上是修改字段is_delete 0未删除 1已删除
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
	 * 修改角色表（支持角色层次）
	 *
	 * @param roleDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	Integer updateById(RoleDTO roleDTO);

	/**
	 * 按参数roleDTO的非空属性查询列表
	 *
	 * @param roleDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	List<RoleDTO> selectListByObject(RoleDTO roleDTO);

	/**
	 * 按参数roleDTO的非空属性查询单条记录
	 *
	 * @param roleDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	RoleDTO selectOneByObject(RoleDTO roleDTO);

	/**
	 * 主键查询角色表（支持角色层次）
	 *
	 * @param id
	 * @return RoleDTO
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	RoleDTO selectById(String id);

}
