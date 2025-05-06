package io.github.zhidao.ms.um.service;

import io.github.zhidao.ms.um.entity.OrgRole;
import io.github.zhidao.ms.um.dto.OrgRoleDTO;

import java.util.List;

/**
 * 组织角色关联表业务逻辑接口
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 **/
public interface OrgRoleService {

	/**
	 * 新增组织角色关联表
	 *
	 * @param orgRoleDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	Integer insert(OrgRoleDTO orgRoleDTO);

    /**
     * 新增或修改组织角色关联表
     *
     * @param orgRoleDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     **/
    Integer insertOrUpdate(OrgRoleDTO orgRoleDTO);


	/**
	 * 删除组织角色关联表，实际上是修改字段is_delete 0未删除 1已删除
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
	 * 修改组织角色关联表
	 *
	 * @param orgRoleDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	Integer updateById(OrgRoleDTO orgRoleDTO);

	/**
	 * 按参数orgRoleDTO的非空属性查询列表
	 *
	 * @param orgRoleDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	List<OrgRoleDTO> selectListByObject(OrgRoleDTO orgRoleDTO);

	/**
	 * 按参数orgRoleDTO的非空属性查询单条记录
	 *
	 * @param orgRoleDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	OrgRoleDTO selectOneByObject(OrgRoleDTO orgRoleDTO);

	/**
	 * 主键查询组织角色关联表
	 *
	 * @param id
	 * @return OrgRoleDTO
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	OrgRoleDTO selectById(String id);

}
