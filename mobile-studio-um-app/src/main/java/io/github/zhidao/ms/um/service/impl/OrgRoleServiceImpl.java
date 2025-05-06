package io.github.zhidao.ms.um.service.impl;

import cn.hutool.core.convert.Convert;
import io.github.zhidao.ms.common.service.BaseCurdService;
import io.github.zhidao.ms.um.dto.OrgRoleDTO;
import io.github.zhidao.ms.um.entity.OrgRole;
import io.github.zhidao.ms.um.mapper.OrgRoleMapper;
import io.github.zhidao.ms.um.service.OrgRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 组织角色关联表业务逻辑实现
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Service
@Slf4j
public class OrgRoleServiceImpl extends BaseCurdService<OrgRole> implements OrgRoleService {

	@Autowired
	private OrgRoleMapper orgRoleMapper;

	/**
     * 新增组织角色关联表
     *
     * @param orgRoleDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer insert(OrgRoleDTO orgRoleDTO) {
		return baseInsert(Convert.convert(OrgRole.class,orgRoleDTO));
	}

	/**
     * 新增或修改组织角色关联表
     *
     * @param orgRoleDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer insertOrUpdate(OrgRoleDTO orgRoleDTO) {
		return insertOrUpdate(Convert.convert(OrgRole.class,orgRoleDTO), orgRoleDTO.getId());
	}

	/**
     * 删除组织角色关联表,实际是置is_delete 为1
     *
     * @param id
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer deleteById(String id) {
		return baseDeleteByPK(new OrgRole(id));
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
		return baseDisableByPK(new OrgRole(id));
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
		return baseEnableByPK(new OrgRole(id));
	}

	/**
     * 修改组织角色关联表
     *
     * @param orgRoleDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer updateById(OrgRoleDTO orgRoleDTO) {
		return baseUpdateByPK(Convert.convert(OrgRole.class,orgRoleDTO));
	}

	/**
     * 按参数orgRoleDTO的非空属性查询列表
     *
     * @param orgRoleDTO
     * @return List<OrgRoleDTO>
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public List<OrgRoleDTO> selectListByObject(OrgRoleDTO orgRoleDTO){
		List<OrgRole> orgRoleList = baseSelectListByObject(Convert.convert(OrgRole.class,orgRoleDTO));
		List<OrgRoleDTO> orgRoleDtoList = new ArrayList<>();
		orgRoleList.forEach(orgRoleEntity -> {
			orgRoleDtoList.add(Convert.convert(OrgRoleDTO.class,orgRoleEntity));
		});
		return orgRoleDtoList;
	}

	/**
     * 按参数orgRoleDTO的非空属性查询单条记录
     *
     * @param orgRoleDTO
     * @return List<OrgRoleDTO>
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public OrgRoleDTO selectOneByObject(OrgRoleDTO orgRoleDTO) {
		OrgRole orgRoleEntity = baseSelectOneByObject(Convert.convert(OrgRole.class,orgRoleDTO));
		return Convert.convert(OrgRoleDTO.class,orgRoleEntity);
	}

	/**
     * 主键查询组织角色关联表
     *
     * @param id
     * @return OrgRoleDTO
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public OrgRoleDTO selectById(String id) {
		OrgRole orgRoleEntity = baseSelectByPK(new OrgRole(id));
		return Convert.convert(OrgRoleDTO.class,orgRoleEntity);
	}
}
