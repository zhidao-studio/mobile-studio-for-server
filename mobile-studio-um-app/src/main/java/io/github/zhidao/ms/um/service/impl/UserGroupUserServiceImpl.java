package io.github.zhidao.ms.um.service.impl;

import cn.hutool.core.convert.Convert;
import io.github.zhidao.ms.common.service.BaseCurdService;
import io.github.zhidao.ms.um.dto.UserGroupUserDTO;
import io.github.zhidao.ms.um.entity.UserGroupUser;
import io.github.zhidao.ms.um.mapper.UserGroupUserMapper;
import io.github.zhidao.ms.um.service.UserGroupUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户与用户组关联表业务逻辑实现
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Service
@Slf4j
public class UserGroupUserServiceImpl extends BaseCurdService<UserGroupUser> implements UserGroupUserService {

	@Autowired
	private UserGroupUserMapper userGroupUserMapper;

	/**
     * 新增用户与用户组关联表
     *
     * @param userGroupUserDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer insert(UserGroupUserDTO userGroupUserDTO) {
		return baseInsert(Convert.convert(UserGroupUser.class,userGroupUserDTO));
	}

	/**
     * 新增或修改用户与用户组关联表
     *
     * @param userGroupUserDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer insertOrUpdate(UserGroupUserDTO userGroupUserDTO) {
		return insertOrUpdate(Convert.convert(UserGroupUser.class,userGroupUserDTO), userGroupUserDTO.getId());
	}

	/**
     * 删除用户与用户组关联表,实际是置is_delete 为1
     *
     * @param id
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer deleteById(String id) {
		return baseDeleteByPK(new UserGroupUser(id));
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
		return baseDisableByPK(new UserGroupUser(id));
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
		return baseEnableByPK(new UserGroupUser(id));
	}

	/**
     * 修改用户与用户组关联表
     *
     * @param userGroupUserDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer updateById(UserGroupUserDTO userGroupUserDTO) {
		return baseUpdateByPK(Convert.convert(UserGroupUser.class,userGroupUserDTO));
	}

	/**
     * 按参数userGroupUserDTO的非空属性查询列表
     *
     * @param userGroupUserDTO
     * @return List<UserGroupUserDTO>
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public List<UserGroupUserDTO> selectListByObject(UserGroupUserDTO userGroupUserDTO){
		List<UserGroupUser> userGroupUserList = baseSelectListByObject(Convert.convert(UserGroupUser.class,userGroupUserDTO));
		List<UserGroupUserDTO> userGroupUserDtoList = new ArrayList<>();
		userGroupUserList.forEach(userGroupUserEntity -> {
			userGroupUserDtoList.add(Convert.convert(UserGroupUserDTO.class,userGroupUserEntity));
		});
		return userGroupUserDtoList;
	}

	/**
     * 按参数userGroupUserDTO的非空属性查询单条记录
     *
     * @param userGroupUserDTO
     * @return List<UserGroupUserDTO>
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public UserGroupUserDTO selectOneByObject(UserGroupUserDTO userGroupUserDTO) {
		UserGroupUser userGroupUserEntity = baseSelectOneByObject(Convert.convert(UserGroupUser.class,userGroupUserDTO));
		return Convert.convert(UserGroupUserDTO.class,userGroupUserEntity);
	}

	/**
     * 主键查询用户与用户组关联表
     *
     * @param id
     * @return UserGroupUserDTO
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public UserGroupUserDTO selectById(String id) {
		UserGroupUser userGroupUserEntity = baseSelectByPK(new UserGroupUser(id));
		return Convert.convert(UserGroupUserDTO.class,userGroupUserEntity);
	}
}
