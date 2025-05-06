package io.github.zhidao.ms.um.service.impl;

import cn.hutool.core.convert.Convert;
import io.github.zhidao.ms.common.service.BaseCurdService;
import io.github.zhidao.ms.um.dto.OrgDTO;
import io.github.zhidao.ms.um.entity.Org;
import io.github.zhidao.ms.um.mapper.OrgMapper;
import io.github.zhidao.ms.um.service.OrgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 组织表业务逻辑实现
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Service
@Slf4j
public class OrgServiceImpl extends BaseCurdService<Org> implements OrgService {

	@Autowired
	private OrgMapper orgMapper;

	/**
     * 新增组织表
     *
     * @param orgDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer insert(OrgDTO orgDTO) {
		return baseInsert(Convert.convert(Org.class,orgDTO));
	}

	/**
     * 新增或修改组织表
     *
     * @param orgDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer insertOrUpdate(OrgDTO orgDTO) {
		return insertOrUpdate(Convert.convert(Org.class,orgDTO), orgDTO.getId());
	}

	/**
     * 删除组织表,实际是置is_delete 为1
     *
     * @param id
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer deleteById(String id) {
		return baseDeleteByPK(new Org(id));
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
		return baseDisableByPK(new Org(id));
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
		return baseEnableByPK(new Org(id));
	}

	/**
     * 修改组织表
     *
     * @param orgDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer updateById(OrgDTO orgDTO) {
		return baseUpdateByPK(Convert.convert(Org.class,orgDTO));
	}

	/**
     * 按参数orgDTO的非空属性查询列表
     *
     * @param orgDTO
     * @return List<OrgDTO>
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public List<OrgDTO> selectListByObject(OrgDTO orgDTO){
		List<Org> orgList = baseSelectListByObject(Convert.convert(Org.class,orgDTO));
		List<OrgDTO> orgDtoList = new ArrayList<>();
		orgList.forEach(orgEntity -> {
			orgDtoList.add(Convert.convert(OrgDTO.class,orgEntity));
		});
		return orgDtoList;
	}

	/**
     * 按参数orgDTO的非空属性查询单条记录
     *
     * @param orgDTO
     * @return List<OrgDTO>
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public OrgDTO selectOneByObject(OrgDTO orgDTO) {
		Org orgEntity = baseSelectOneByObject(Convert.convert(Org.class,orgDTO));
		return Convert.convert(OrgDTO.class,orgEntity);
	}

	/**
     * 主键查询组织表
     *
     * @param id
     * @return OrgDTO
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public OrgDTO selectById(String id) {
		Org orgEntity = baseSelectByPK(new Org(id));
		return Convert.convert(OrgDTO.class,orgEntity);
	}
}
