package io.github.zhidao.ms.um.service.impl;

import cn.hutool.core.convert.Convert;
import io.github.zhidao.ms.common.service.BaseCurdService;
import io.github.zhidao.ms.um.dto.RolePermissionDTO;
import io.github.zhidao.ms.um.entity.RolePermission;
import io.github.zhidao.ms.um.mapper.RolePermissionMapper;
import io.github.zhidao.ms.um.service.RolePermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色权限关联表业务逻辑实现
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Service
@Slf4j
public class RolePermissionServiceImpl extends BaseCurdService<RolePermission> implements RolePermissionService {

	@Autowired
	private RolePermissionMapper rolePermissionMapper;

	/**
     * 新增角色权限关联表
     *
     * @param rolePermissionDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer insert(RolePermissionDTO rolePermissionDTO) {
		return baseInsert(Convert.convert(RolePermission.class,rolePermissionDTO));
	}

	/**
     * 新增或修改角色权限关联表
     *
     * @param rolePermissionDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer insertOrUpdate(RolePermissionDTO rolePermissionDTO) {
		return insertOrUpdate(Convert.convert(RolePermission.class,rolePermissionDTO), rolePermissionDTO.getId());
	}

	/**
     * 删除角色权限关联表,实际是置is_delete 为1
     *
     * @param id
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer deleteById(String id) {
		return baseDeleteByPK(new RolePermission(id));
	}

	/**
     * 置为失效
     *
     * @param id
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer updateToInValidateById(String id) {
		return baseDisableByPK(new RolePermission(id));
	}

	/**
     * 置为生效
     *
     * @param id
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer updateToValidateById(String id) {
		return baseEnableByPK(new RolePermission(id));
	}

	/**
     * 修改角色权限关联表
     *
     * @param rolePermissionDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer updateById(RolePermissionDTO rolePermissionDTO) {
		return baseUpdateByPK(Convert.convert(RolePermission.class,rolePermissionDTO));
	}

	/**
     * 按参数rolePermissionDTO的非空属性查询列表
     *
     * @param rolePermissionDTO
     * @return List<RolePermissionDTO>
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public List<RolePermissionDTO> selectListByObject(RolePermissionDTO rolePermissionDTO){
		List<RolePermission> rolePermissionList = baseSelectListByObject(Convert.convert(RolePermission.class,rolePermissionDTO));
		List<RolePermissionDTO> rolePermissionDtoList = new ArrayList<>();
		rolePermissionList.forEach(rolePermissionEntity -> {
			rolePermissionDtoList.add(Convert.convert(RolePermissionDTO.class,rolePermissionEntity));
		});
		return rolePermissionDtoList;
	}

	/**
     * 按参数rolePermissionDTO的非空属性查询单条记录
     *
     * @param rolePermissionDTO
     * @return List<RolePermissionDTO>
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public RolePermissionDTO selectOneByObject(RolePermissionDTO rolePermissionDTO) {
		RolePermission rolePermissionEntity = baseSelectOneByObject(Convert.convert(RolePermission.class,rolePermissionDTO));
		return Convert.convert(RolePermissionDTO.class,rolePermissionEntity);
	}

	/**
     * 主键查询角色权限关联表
     *
     * @param id
     * @return RolePermissionDTO
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public RolePermissionDTO selectById(String id) {
		RolePermission rolePermissionEntity = baseSelectByPK(new RolePermission(id));
		return Convert.convert(RolePermissionDTO.class,rolePermissionEntity);
	}
}
