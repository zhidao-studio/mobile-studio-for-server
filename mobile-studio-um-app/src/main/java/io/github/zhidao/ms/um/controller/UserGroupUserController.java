package io.github.zhidao.ms.um.controller;

import io.github.zhidao.ms.common.dto.PageDTO;
import io.github.zhidao.ms.common.webapi.ApiResult;
import io.github.zhidao.ms.um.dto.UserGroupUserDTO;
import io.github.zhidao.ms.um.service.UserGroupUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * 用户与用户组关联表 API
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@RestController
@Tag(name = "用户与用户组关联表")
@RequestMapping(value = "v1/userGroupUser")
@Slf4j
public class UserGroupUserController {

	@Autowired
	private UserGroupUserService userGroupUserService;

	/**
     * 新增或修改用户与用户组关联表功能
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "新增或修改用户与用户组关联表功能")
	public ApiResult<UserGroupUserDTO> insertUserGroupUser(@RequestBody @Validated UserGroupUserDTO userGroupUserDTO) {
		Integer result = userGroupUserService.insertOrUpdate(userGroupUserDTO);
		return result > 0 ? ApiResult.ok() : ApiResult.err("失败");
	}


	/**
     * 按主键删除 用户与用户组关联表
	 * @author ZHANLS 2025年05月06日
     */
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "按主键删除用户与用户组关联表")
	public ApiResult<UserGroupUserDTO> deleteUserGroupUserById(@PathVariable String id) {
		Integer result = userGroupUserService.deleteById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("删除失败");
	}

	/**
     * 按主键更新用户与用户组关联表
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "按主键更新用户与用户组关联表")
	public ApiResult<UserGroupUserDTO> updateUserGroupUserById(@RequestBody @Validated UserGroupUserDTO userGroupUserDTO) {
		Integer result = userGroupUserService.updateById(userGroupUserDTO);
		return result > 0 ? ApiResult.ok() : ApiResult.err("更新失败");
	}

	/**
     * 按主键置为无效
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "/disable/{id}")
	@Operation(summary = "按主键置为无效")
	public ApiResult<UserGroupUserDTO> disableUserGroupUserById(@PathVariable String id) {
		Integer result = userGroupUserService.updateToInValidateById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("操作失败");
	}

	/**
     * 按主键置为有效
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "/enable/{id}")
	@Operation(summary = "按主键置为有效")
	public ApiResult<UserGroupUserDTO> enableUserGroupUserById(@PathVariable String id) {
		Integer result = userGroupUserService.updateToValidateById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("操作失败");
	}

	/**
     * 按主键查询用户与用户组关联表
	 * @author ZHANLS 2025年05月06日
     */
	@GetMapping(value = "/select/{id}")
	@Operation(summary = "按主键查询用户与用户组关联表")
	public ApiResult<UserGroupUserDTO> selectUserGroupUserById(@PathVariable String id) {
		return ApiResult.ok(userGroupUserService.selectById(id));
	}

	/**
     * 根据非空属性查询全部用户与用户组关联表
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "/list",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "查询全部用户与用户组关联表")
	public ApiResult<List<UserGroupUserDTO>> listUserGroupUser(@RequestBody UserGroupUserDTO userGroupUserDTO) throws IllegalAccessException {
		List<UserGroupUserDTO> userGroupUserDtoList = userGroupUserService.selectListByObject(userGroupUserDTO);
		return ApiResult.ok(userGroupUserDtoList);
	}

	/**
     * 根据条件分页查询全部用户与用户组关联表
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "/pageList",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "根据条件分页查询全部用户与用户组关联表")
	public ApiResult<PageDTO<UserGroupUserDTO>> pageList(@RequestBody @Validated PageDTO<UserGroupUserDTO> pageDTO) throws IllegalAccessException {
		Page<UserGroupUserDTO> page = PageHelper.startPage(pageDTO.getPageNum(), pageDTO.getPageSize());
		List<UserGroupUserDTO> userGroupUserDtoList = userGroupUserService.selectListByObject(pageDTO.getCondition());
		return ApiResult.ok(new PageDTO<>(page, userGroupUserDtoList));
	}
}
