package io.github.zhidao.ms.um.service.impl;

import cn.hutool.core.convert.Convert;
import io.github.zhidao.ms.common.service.BaseCurdService;
import io.github.zhidao.ms.um.dto.UserPositionDTO;
import io.github.zhidao.ms.um.entity.UserPosition;
import io.github.zhidao.ms.um.mapper.UserPositionMapper;
import io.github.zhidao.ms.um.service.UserPositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户与岗位关联表业务逻辑实现
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Service
@Slf4j
public class UserPositionServiceImpl extends BaseCurdService<UserPosition> implements UserPositionService {

	@Autowired
	private UserPositionMapper userPositionMapper;

	/**
     * 新增用户与岗位关联表
     *
     * @param userPositionDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer insert(UserPositionDTO userPositionDTO) {
		return baseInsert(Convert.convert(UserPosition.class,userPositionDTO));
	}

	/**
     * 新增或修改用户与岗位关联表
     *
     * @param userPositionDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer insertOrUpdate(UserPositionDTO userPositionDTO) {
		return insertOrUpdate(Convert.convert(UserPosition.class,userPositionDTO), userPositionDTO.getId());
	}

	/**
     * 删除用户与岗位关联表,实际是置is_delete 为1
     *
     * @param id
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer deleteById(String id) {
		return baseDeleteByPK(new UserPosition(id));
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
		return baseDisableByPK(new UserPosition(id));
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
		return baseEnableByPK(new UserPosition(id));
	}

	/**
     * 修改用户与岗位关联表
     *
     * @param userPositionDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer updateById(UserPositionDTO userPositionDTO) {
		return baseUpdateByPK(Convert.convert(UserPosition.class,userPositionDTO));
	}

	/**
     * 按参数userPositionDTO的非空属性查询列表
     *
     * @param userPositionDTO
     * @return List<UserPositionDTO>
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public List<UserPositionDTO> selectListByObject(UserPositionDTO userPositionDTO){
		List<UserPosition> userPositionList = baseSelectListByObject(Convert.convert(UserPosition.class,userPositionDTO));
		List<UserPositionDTO> userPositionDtoList = new ArrayList<>();
		userPositionList.forEach(userPositionEntity -> {
			userPositionDtoList.add(Convert.convert(UserPositionDTO.class,userPositionEntity));
		});
		return userPositionDtoList;
	}

	/**
     * 按参数userPositionDTO的非空属性查询单条记录
     *
     * @param userPositionDTO
     * @return List<UserPositionDTO>
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public UserPositionDTO selectOneByObject(UserPositionDTO userPositionDTO) {
		UserPosition userPositionEntity = baseSelectOneByObject(Convert.convert(UserPosition.class,userPositionDTO));
		return Convert.convert(UserPositionDTO.class,userPositionEntity);
	}

	/**
     * 主键查询用户与岗位关联表
     *
     * @param id
     * @return UserPositionDTO
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public UserPositionDTO selectById(String id) {
		UserPosition userPositionEntity = baseSelectByPK(new UserPosition(id));
		return Convert.convert(UserPositionDTO.class,userPositionEntity);
	}
}
