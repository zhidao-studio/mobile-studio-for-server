package io.github.zhidao.ms.um.service;

import io.github.zhidao.ms.um.entity.RoleExclusion;
import io.github.zhidao.ms.um.dto.RoleExclusionDTO;

import java.util.List;

/**
 * 角色互斥表（支持静态/动态互斥）业务逻辑接口
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 **/
public interface RoleExclusionService {

	/**
	 * 新增角色互斥表（支持静态/动态互斥）
	 *
	 * @param roleExclusionDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	Integer insert(RoleExclusionDTO roleExclusionDTO);

    /**
     * 新增或修改角色互斥表（支持静态/动态互斥）
     *
     * @param roleExclusionDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     **/
    Integer insertOrUpdate(RoleExclusionDTO roleExclusionDTO);


	/**
	 * 删除角色互斥表（支持静态/动态互斥），实际上是修改字段is_delete 0未删除 1已删除
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
	 * 修改角色互斥表（支持静态/动态互斥）
	 *
	 * @param roleExclusionDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	Integer updateById(RoleExclusionDTO roleExclusionDTO);

	/**
	 * 按参数roleExclusionDTO的非空属性查询列表
	 *
	 * @param roleExclusionDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	List<RoleExclusionDTO> selectListByObject(RoleExclusionDTO roleExclusionDTO);

	/**
	 * 按参数roleExclusionDTO的非空属性查询单条记录
	 *
	 * @param roleExclusionDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	RoleExclusionDTO selectOneByObject(RoleExclusionDTO roleExclusionDTO);

	/**
	 * 主键查询角色互斥表（支持静态/动态互斥）
	 *
	 * @param id
	 * @return RoleExclusionDTO
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	RoleExclusionDTO selectById(String id);

}
