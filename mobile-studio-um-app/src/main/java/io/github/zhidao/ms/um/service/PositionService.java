package io.github.zhidao.ms.um.service;

import io.github.zhidao.ms.um.entity.Position;
import io.github.zhidao.ms.um.dto.PositionDTO;

import java.util.List;

/**
 * 岗位表（支持岗位层次）业务逻辑接口
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 **/
public interface PositionService {

	/**
	 * 新增岗位表（支持岗位层次）
	 *
	 * @param positionDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	Integer insert(PositionDTO positionDTO);

    /**
     * 新增或修改岗位表（支持岗位层次）
     *
     * @param positionDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     **/
    Integer insertOrUpdate(PositionDTO positionDTO);


	/**
	 * 删除岗位表（支持岗位层次），实际上是修改字段is_delete 0未删除 1已删除
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
	 * 修改岗位表（支持岗位层次）
	 *
	 * @param positionDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	Integer updateById(PositionDTO positionDTO);

	/**
	 * 按参数positionDTO的非空属性查询列表
	 *
	 * @param positionDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	List<PositionDTO> selectListByObject(PositionDTO positionDTO);

	/**
	 * 按参数positionDTO的非空属性查询单条记录
	 *
	 * @param positionDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	PositionDTO selectOneByObject(PositionDTO positionDTO);

	/**
	 * 主键查询岗位表（支持岗位层次）
	 *
	 * @param id
	 * @return PositionDTO
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	PositionDTO selectById(String id);

}
