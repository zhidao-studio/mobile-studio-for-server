package io.github.zhidao.ms.um.service.impl;

import cn.hutool.core.convert.Convert;
import io.github.zhidao.ms.common.service.BaseCurdService;
import io.github.zhidao.ms.um.dto.RoleExclusionDTO;
import io.github.zhidao.ms.um.entity.RoleExclusion;
import io.github.zhidao.ms.um.mapper.RoleExclusionMapper;
import io.github.zhidao.ms.um.service.RoleExclusionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色互斥表（支持静态/动态互斥）业务逻辑实现
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Service
@Slf4j
public class RoleExclusionServiceImpl extends BaseCurdService<RoleExclusion> implements RoleExclusionService {

	@Autowired
	private RoleExclusionMapper roleExclusionMapper;

	/**
     * 新增角色互斥表（支持静态/动态互斥）
     *
     * @param roleExclusionDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer insert(RoleExclusionDTO roleExclusionDTO) {
		return baseInsert(Convert.convert(RoleExclusion.class,roleExclusionDTO));
	}

	/**
     * 新增或修改角色互斥表（支持静态/动态互斥）
     *
     * @param roleExclusionDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer insertOrUpdate(RoleExclusionDTO roleExclusionDTO) {
		return insertOrUpdate(Convert.convert(RoleExclusion.class,roleExclusionDTO), roleExclusionDTO.getId());
	}

	/**
     * 删除角色互斥表（支持静态/动态互斥）,实际是置is_delete 为1
     *
     * @param id
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer deleteById(String id) {
		return baseDeleteByPK(new RoleExclusion(id));
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
		return baseDisableByPK(new RoleExclusion(id));
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
		return baseEnableByPK(new RoleExclusion(id));
	}

	/**
     * 修改角色互斥表（支持静态/动态互斥）
     *
     * @param roleExclusionDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer updateById(RoleExclusionDTO roleExclusionDTO) {
		return baseUpdateByPK(Convert.convert(RoleExclusion.class,roleExclusionDTO));
	}

	/**
     * 按参数roleExclusionDTO的非空属性查询列表
     *
     * @param roleExclusionDTO
     * @return List<RoleExclusionDTO>
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public List<RoleExclusionDTO> selectListByObject(RoleExclusionDTO roleExclusionDTO){
		List<RoleExclusion> roleExclusionList = baseSelectListByObject(Convert.convert(RoleExclusion.class,roleExclusionDTO));
		List<RoleExclusionDTO> roleExclusionDtoList = new ArrayList<>();
		roleExclusionList.forEach(roleExclusionEntity -> {
			roleExclusionDtoList.add(Convert.convert(RoleExclusionDTO.class,roleExclusionEntity));
		});
		return roleExclusionDtoList;
	}

	/**
     * 按参数roleExclusionDTO的非空属性查询单条记录
     *
     * @param roleExclusionDTO
     * @return List<RoleExclusionDTO>
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public RoleExclusionDTO selectOneByObject(RoleExclusionDTO roleExclusionDTO) {
		RoleExclusion roleExclusionEntity = baseSelectOneByObject(Convert.convert(RoleExclusion.class,roleExclusionDTO));
		return Convert.convert(RoleExclusionDTO.class,roleExclusionEntity);
	}

	/**
     * 主键查询角色互斥表（支持静态/动态互斥）
     *
     * @param id
     * @return RoleExclusionDTO
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public RoleExclusionDTO selectById(String id) {
		RoleExclusion roleExclusionEntity = baseSelectByPK(new RoleExclusion(id));
		return Convert.convert(RoleExclusionDTO.class,roleExclusionEntity);
	}
}
