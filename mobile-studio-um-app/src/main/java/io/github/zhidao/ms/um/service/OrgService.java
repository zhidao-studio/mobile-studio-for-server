package io.github.zhidao.ms.um.service;

import io.github.zhidao.ms.um.entity.Org;
import io.github.zhidao.ms.um.dto.OrgDTO;

import java.util.List;

/**
 * 组织表业务逻辑接口
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 **/
public interface OrgService {

	/**
	 * 新增组织表
	 *
	 * @param orgDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	Integer insert(OrgDTO orgDTO);

    /**
     * 新增或修改组织表
     *
     * @param orgDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     **/
    Integer insertOrUpdate(OrgDTO orgDTO);


	/**
	 * 删除组织表，实际上是修改字段is_delete 0未删除 1已删除
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
	 * 修改组织表
	 *
	 * @param orgDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	Integer updateById(OrgDTO orgDTO);

	/**
	 * 按参数orgDTO的非空属性查询列表
	 *
	 * @param orgDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	List<OrgDTO> selectListByObject(OrgDTO orgDTO);

	/**
	 * 按参数orgDTO的非空属性查询单条记录
	 *
	 * @param orgDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	OrgDTO selectOneByObject(OrgDTO orgDTO);

	/**
	 * 主键查询组织表
	 *
	 * @param id
	 * @return OrgDTO
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	OrgDTO selectById(String id);

}
