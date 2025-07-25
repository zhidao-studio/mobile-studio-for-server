package io.github.zhidao.ms.um.service;

import io.github.zhidao.ms.um.entity.Company;
import io.github.zhidao.ms.um.dto.CompanyDTO;

import java.util.List;

/**
 * 公司企业表业务逻辑接口
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 **/
public interface CompanyService {

	/**
	 * 新增公司企业表
	 *
	 * @param companyDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	Integer insert(CompanyDTO companyDTO);

    /**
     * 新增或修改公司企业表
     *
     * @param companyDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     **/
    Integer insertOrUpdate(CompanyDTO companyDTO);


	/**
	 * 删除公司企业表，实际上是修改字段is_delete 0未删除 1已删除
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
	 * 修改公司企业表
	 *
	 * @param companyDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	Integer updateById(CompanyDTO companyDTO);

	/**
	 * 按参数companyDTO的非空属性查询列表
	 *
	 * @param companyDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	List<CompanyDTO> selectListByObject(CompanyDTO companyDTO);

	/**
	 * 按参数companyDTO的非空属性查询单条记录
	 *
	 * @param companyDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	CompanyDTO selectOneByObject(CompanyDTO companyDTO);

	/**
	 * 主键查询公司企业表
	 *
	 * @param id
	 * @return CompanyDTO
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	CompanyDTO selectById(String id);

}
