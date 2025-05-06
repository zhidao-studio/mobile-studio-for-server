package io.github.zhidao.ms.um.service;

import io.github.zhidao.ms.um.entity.UserPosition;
import io.github.zhidao.ms.um.dto.UserPositionDTO;

import java.util.List;

/**
 * 用户与岗位关联表业务逻辑接口
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 **/
public interface UserPositionService {

	/**
	 * 新增用户与岗位关联表
	 *
	 * @param userPositionDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	Integer insert(UserPositionDTO userPositionDTO);

    /**
     * 新增或修改用户与岗位关联表
     *
     * @param userPositionDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     **/
    Integer insertOrUpdate(UserPositionDTO userPositionDTO);


	/**
	 * 删除用户与岗位关联表，实际上是修改字段is_delete 0未删除 1已删除
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
	 * 修改用户与岗位关联表
	 *
	 * @param userPositionDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	Integer updateById(UserPositionDTO userPositionDTO);

	/**
	 * 按参数userPositionDTO的非空属性查询列表
	 *
	 * @param userPositionDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	List<UserPositionDTO> selectListByObject(UserPositionDTO userPositionDTO);

	/**
	 * 按参数userPositionDTO的非空属性查询单条记录
	 *
	 * @param userPositionDTO
	 * @return Integer
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	UserPositionDTO selectOneByObject(UserPositionDTO userPositionDTO);

	/**
	 * 主键查询用户与岗位关联表
	 *
	 * @param id
	 * @return UserPositionDTO
	 * @updateRecord - 初次创建
	 * @version 1.0 (2025年05月06日)
	 * @author ZHANLS
	 **/
	UserPositionDTO selectById(String id);

}
