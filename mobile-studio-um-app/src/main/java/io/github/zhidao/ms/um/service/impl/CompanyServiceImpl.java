package io.github.zhidao.ms.um.service.impl;

import cn.hutool.core.convert.Convert;
import io.github.zhidao.ms.common.service.BaseCurdService;
import io.github.zhidao.ms.um.dto.CompanyDTO;
import io.github.zhidao.ms.um.entity.Company;
import io.github.zhidao.ms.um.mapper.CompanyMapper;
import io.github.zhidao.ms.um.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 公司企业表业务逻辑实现
 *
 * @author zhanls 2025年04月25日
 * @version 1.0
 */
@Service
@Slf4j
public class CompanyServiceImpl extends BaseCurdService<Company> implements CompanyService {

	@Autowired
	private CompanyMapper companyMapper;

	/**
     * 新增公司企业表
     *
     * @param companyDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年04月25日)
     * @author zhanls
     */
	@Override
	public Integer insert(CompanyDTO companyDTO) {
		return baseInsert(Convert.convert(Company.class,companyDTO));
	}

	/**
     * 新增或修改公司企业表
     *
     * @param companyDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年04月25日)
     * @author zhanls
     */
	@Override
	public Integer insertOrUpdate(CompanyDTO companyDTO) {
		return insertOrUpdate(Convert.convert(Company.class,companyDTO), companyDTO.getId());
	}

	/**
     * 删除公司企业表,实际是置is_delete 为1
     *
     * @param id
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年04月25日)
     * @author zhanls
     */
	@Override
	public Integer deleteById(String id) {
		return baseDeleteByPK(new Company(id));
	}

	/**
     * 置为失效
     *
     * @param id
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年04月25日)
     * @author zhanls
     */
	@Override
	public Integer updateToInValidateById(String id) {
		return baseDisableByPK(new Company(id));
	}

	/**
     * 置为生效
     *
     * @param id
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年04月25日)
     * @author zhanls
     */
	@Override
	public Integer updateToValidateById(String id) {
		return baseEnableByPK(new Company(id));
	}

	/**
     * 修改公司企业表
     *
     * @param companyDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年04月25日)
     * @author zhanls
     */
	@Override
	public Integer updateById(CompanyDTO companyDTO) {
		return baseUpdateByPK(Convert.convert(Company.class,companyDTO));
	}

	/**
     * 按参数companyDTO的非空属性查询列表
     *
     * @param companyDTO
     * @return List<CompanyDTO>
     * @updateRecord - 初次创建
     * @version 1.0 (2025年04月25日)
     * @author zhanls
     */
	@Override
	public List<CompanyDTO> selectListByObject(CompanyDTO companyDTO){
		List<Company> companyList = baseSelectListByObject(Convert.convert(Company.class,companyDTO));
		List<CompanyDTO> companyDtoList = new ArrayList<>();
		companyList.forEach(companyEntity -> {
			companyDtoList.add(Convert.convert(CompanyDTO.class,companyEntity));
		});
		return companyDtoList;
	}

	/**
     * 按参数companyDTO的非空属性查询单条记录
     *
     * @param companyDTO
     * @return List<CompanyDTO>
     * @updateRecord - 初次创建
     * @version 1.0 (2025年04月25日)
     * @author zhanls
     */
	@Override
	public CompanyDTO selectOneByObject(CompanyDTO companyDTO) {
		Company companyEntity = baseSelectOneByObject(Convert.convert(Company.class,companyDTO));
		return Convert.convert(CompanyDTO.class,companyEntity);
	}

	/**
     * 主键查询公司企业表
     *
     * @param id
     * @return CompanyDTO
     * @updateRecord - 初次创建
     * @version 1.0 (2025年04月25日)
     * @author zhanls
     */
	@Override
	public CompanyDTO selectById(String id) {
		Company companyEntity = baseSelectByPK(new Company(id));
		return Convert.convert(CompanyDTO.class,companyEntity);
	}
}
