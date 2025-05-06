package io.github.zhidao.ms.um.service.impl;

import cn.hutool.core.convert.Convert;
import io.github.zhidao.ms.common.service.BaseCurdService;
import io.github.zhidao.ms.um.dto.PermissionDTO;
import io.github.zhidao.ms.um.entity.Permission;
import io.github.zhidao.ms.um.mapper.PermissionMapper;
import io.github.zhidao.ms.um.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限表（支持权限层次）业务逻辑实现
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Service
@Slf4j
public class PermissionServiceImpl extends BaseCurdService<Permission> implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;

	/**
     * 新增权限表（支持权限层次）
     *
     * @param permissionDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer insert(PermissionDTO permissionDTO) {
		return baseInsert(Convert.convert(Permission.class,permissionDTO));
	}

	/**
     * 新增或修改权限表（支持权限层次）
     *
     * @param permissionDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer insertOrUpdate(PermissionDTO permissionDTO) {
		return insertOrUpdate(Convert.convert(Permission.class,permissionDTO), permissionDTO.getId());
	}

	/**
     * 删除权限表（支持权限层次）,实际是置is_delete 为1
     *
     * @param id
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer deleteById(String id) {
		return baseDeleteByPK(new Permission(id));
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
		return baseDisableByPK(new Permission(id));
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
		return baseEnableByPK(new Permission(id));
	}

	/**
     * 修改权限表（支持权限层次）
     *
     * @param permissionDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer updateById(PermissionDTO permissionDTO) {
		return baseUpdateByPK(Convert.convert(Permission.class,permissionDTO));
	}

	/**
     * 按参数permissionDTO的非空属性查询列表
     *
     * @param permissionDTO
     * @return List<PermissionDTO>
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public List<PermissionDTO> selectListByObject(PermissionDTO permissionDTO){
		List<Permission> permissionList = baseSelectListByObject(Convert.convert(Permission.class,permissionDTO));
		List<PermissionDTO> permissionDtoList = new ArrayList<>();
		permissionList.forEach(permissionEntity -> {
			permissionDtoList.add(Convert.convert(PermissionDTO.class,permissionEntity));
		});
		return permissionDtoList;
	}

	/**
     * 按参数permissionDTO的非空属性查询单条记录
     *
     * @param permissionDTO
     * @return List<PermissionDTO>
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public PermissionDTO selectOneByObject(PermissionDTO permissionDTO) {
		Permission permissionEntity = baseSelectOneByObject(Convert.convert(Permission.class,permissionDTO));
		return Convert.convert(PermissionDTO.class,permissionEntity);
	}

	/**
     * 主键查询权限表（支持权限层次）
     *
     * @param id
     * @return PermissionDTO
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public PermissionDTO selectById(String id) {
		Permission permissionEntity = baseSelectByPK(new Permission(id));
		return Convert.convert(PermissionDTO.class,permissionEntity);
	}
}
