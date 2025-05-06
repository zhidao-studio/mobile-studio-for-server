package io.github.zhidao.ms.um.service.impl;

import cn.hutool.core.convert.Convert;
import io.github.zhidao.ms.common.service.BaseCurdService;
import io.github.zhidao.ms.um.dto.RoleDTO;
import io.github.zhidao.ms.um.entity.Role;
import io.github.zhidao.ms.um.mapper.RoleMapper;
import io.github.zhidao.ms.um.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色表（支持角色层次）业务逻辑实现
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Service
@Slf4j
public class RoleServiceImpl extends BaseCurdService<Role> implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	/**
     * 新增角色表（支持角色层次）
     *
     * @param roleDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer insert(RoleDTO roleDTO) {
		return baseInsert(Convert.convert(Role.class,roleDTO));
	}

	/**
     * 新增或修改角色表（支持角色层次）
     *
     * @param roleDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer insertOrUpdate(RoleDTO roleDTO) {
		return insertOrUpdate(Convert.convert(Role.class,roleDTO), roleDTO.getId());
	}

	/**
     * 删除角色表（支持角色层次）,实际是置is_delete 为1
     *
     * @param id
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer deleteById(String id) {
		return baseDeleteByPK(new Role(id));
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
		return baseDisableByPK(new Role(id));
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
		return baseEnableByPK(new Role(id));
	}

	/**
     * 修改角色表（支持角色层次）
     *
     * @param roleDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer updateById(RoleDTO roleDTO) {
		return baseUpdateByPK(Convert.convert(Role.class,roleDTO));
	}

	/**
     * 按参数roleDTO的非空属性查询列表
     *
     * @param roleDTO
     * @return List<RoleDTO>
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public List<RoleDTO> selectListByObject(RoleDTO roleDTO){
		List<Role> roleList = baseSelectListByObject(Convert.convert(Role.class,roleDTO));
		List<RoleDTO> roleDtoList = new ArrayList<>();
		roleList.forEach(roleEntity -> {
			roleDtoList.add(Convert.convert(RoleDTO.class,roleEntity));
		});
		return roleDtoList;
	}

	/**
     * 按参数roleDTO的非空属性查询单条记录
     *
     * @param roleDTO
     * @return List<RoleDTO>
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public RoleDTO selectOneByObject(RoleDTO roleDTO) {
		Role roleEntity = baseSelectOneByObject(Convert.convert(Role.class,roleDTO));
		return Convert.convert(RoleDTO.class,roleEntity);
	}

	/**
     * 主键查询角色表（支持角色层次）
     *
     * @param id
     * @return RoleDTO
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public RoleDTO selectById(String id) {
		Role roleEntity = baseSelectByPK(new Role(id));
		return Convert.convert(RoleDTO.class,roleEntity);
	}
}
