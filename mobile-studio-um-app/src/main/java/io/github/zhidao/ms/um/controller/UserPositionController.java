package io.github.zhidao.ms.um.controller;

import io.github.zhidao.ms.common.dto.PageDTO;
import io.github.zhidao.ms.common.webapi.ApiResult;
import io.github.zhidao.ms.um.dto.UserPositionDTO;
import io.github.zhidao.ms.um.service.UserPositionService;
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
 * 用户与岗位关联表 API
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@RestController
@Tag(name = "用户与岗位关联表")
@RequestMapping(value = "v1/userPosition")
@Slf4j
public class UserPositionController {

	@Autowired
	private UserPositionService userPositionService;

	/**
     * 新增或修改用户与岗位关联表功能
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "新增或修改用户与岗位关联表功能")
	public ApiResult<UserPositionDTO> insertUserPosition(@RequestBody @Validated UserPositionDTO userPositionDTO) {
		Integer result = userPositionService.insertOrUpdate(userPositionDTO);
		return result > 0 ? ApiResult.ok() : ApiResult.err("失败");
	}


	/**
     * 按主键删除 用户与岗位关联表
	 * @author ZHANLS 2025年05月06日
     */
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "按主键删除用户与岗位关联表")
	public ApiResult<UserPositionDTO> deleteUserPositionById(@PathVariable String id) {
		Integer result = userPositionService.deleteById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("删除失败");
	}

	/**
     * 按主键更新用户与岗位关联表
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "按主键更新用户与岗位关联表")
	public ApiResult<UserPositionDTO> updateUserPositionById(@RequestBody @Validated UserPositionDTO userPositionDTO) {
		Integer result = userPositionService.updateById(userPositionDTO);
		return result > 0 ? ApiResult.ok() : ApiResult.err("更新失败");
	}

	/**
     * 按主键置为无效
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "/disable/{id}")
	@Operation(summary = "按主键置为无效")
	public ApiResult<UserPositionDTO> disableUserPositionById(@PathVariable String id) {
		Integer result = userPositionService.updateToInValidateById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("操作失败");
	}

	/**
     * 按主键置为有效
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "/enable/{id}")
	@Operation(summary = "按主键置为有效")
	public ApiResult<UserPositionDTO> enableUserPositionById(@PathVariable String id) {
		Integer result = userPositionService.updateToValidateById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("操作失败");
	}

	/**
     * 按主键查询用户与岗位关联表
	 * @author ZHANLS 2025年05月06日
     */
	@GetMapping(value = "/select/{id}")
	@Operation(summary = "按主键查询用户与岗位关联表")
	public ApiResult<UserPositionDTO> selectUserPositionById(@PathVariable String id) {
		return ApiResult.ok(userPositionService.selectById(id));
	}

	/**
     * 根据非空属性查询全部用户与岗位关联表
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "/list",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "查询全部用户与岗位关联表")
	public ApiResult<List<UserPositionDTO>> listUserPosition(@RequestBody UserPositionDTO userPositionDTO) throws IllegalAccessException {
		List<UserPositionDTO> userPositionDtoList = userPositionService.selectListByObject(userPositionDTO);
		return ApiResult.ok(userPositionDtoList);
	}

	/**
     * 根据条件分页查询全部用户与岗位关联表
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "/pageList",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "根据条件分页查询全部用户与岗位关联表")
	public ApiResult<PageDTO<UserPositionDTO>> pageList(@RequestBody @Validated PageDTO<UserPositionDTO> pageDTO) throws IllegalAccessException {
		Page<UserPositionDTO> page = PageHelper.startPage(pageDTO.getPageNum(), pageDTO.getPageSize());
		List<UserPositionDTO> userPositionDtoList = userPositionService.selectListByObject(pageDTO.getCondition());
		return ApiResult.ok(new PageDTO<>(page, userPositionDtoList));
	}
}
