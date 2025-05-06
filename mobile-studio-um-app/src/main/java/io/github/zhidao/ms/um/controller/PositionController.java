package io.github.zhidao.ms.um.controller;

import io.github.zhidao.ms.common.dto.PageDTO;
import io.github.zhidao.ms.common.webapi.ApiResult;
import io.github.zhidao.ms.um.dto.PositionDTO;
import io.github.zhidao.ms.um.service.PositionService;
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
 * 岗位表（支持岗位层次） API
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@RestController
@Tag(name = "岗位表（支持岗位层次）")
@RequestMapping(value = "v1/position")
@Slf4j
public class PositionController {

	@Autowired
	private PositionService positionService;

	/**
     * 新增或修改岗位表（支持岗位层次）功能
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "新增或修改岗位表（支持岗位层次）功能")
	public ApiResult<PositionDTO> insertPosition(@RequestBody @Validated PositionDTO positionDTO) {
		Integer result = positionService.insertOrUpdate(positionDTO);
		return result > 0 ? ApiResult.ok() : ApiResult.err("失败");
	}


	/**
     * 按主键删除 岗位表（支持岗位层次）
	 * @author ZHANLS 2025年05月06日
     */
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "按主键删除岗位表（支持岗位层次）")
	public ApiResult<PositionDTO> deletePositionById(@PathVariable String id) {
		Integer result = positionService.deleteById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("删除失败");
	}

	/**
     * 按主键更新岗位表（支持岗位层次）
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "按主键更新岗位表（支持岗位层次）")
	public ApiResult<PositionDTO> updatePositionById(@RequestBody @Validated PositionDTO positionDTO) {
		Integer result = positionService.updateById(positionDTO);
		return result > 0 ? ApiResult.ok() : ApiResult.err("更新失败");
	}

	/**
     * 按主键置为无效
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "/disable/{id}")
	@Operation(summary = "按主键置为无效")
	public ApiResult<PositionDTO> disablePositionById(@PathVariable String id) {
		Integer result = positionService.updateToInValidateById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("操作失败");
	}

	/**
     * 按主键置为有效
	 * @author ZHANLS 2025年05月06日
     */
	@PutMapping(value = "/enable/{id}")
	@Operation(summary = "按主键置为有效")
	public ApiResult<PositionDTO> enablePositionById(@PathVariable String id) {
		Integer result = positionService.updateToValidateById(id);
		return result > 0 ? ApiResult.ok() : ApiResult.err("操作失败");
	}

	/**
     * 按主键查询岗位表（支持岗位层次）
	 * @author ZHANLS 2025年05月06日
     */
	@GetMapping(value = "/select/{id}")
	@Operation(summary = "按主键查询岗位表（支持岗位层次）")
	public ApiResult<PositionDTO> selectPositionById(@PathVariable String id) {
		return ApiResult.ok(positionService.selectById(id));
	}

	/**
     * 根据非空属性查询全部岗位表（支持岗位层次）
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "/list",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "查询全部岗位表（支持岗位层次）")
	public ApiResult<List<PositionDTO>> listPosition(@RequestBody PositionDTO positionDTO) throws IllegalAccessException {
		List<PositionDTO> positionDtoList = positionService.selectListByObject(positionDTO);
		return ApiResult.ok(positionDtoList);
	}

	/**
     * 根据条件分页查询全部岗位表（支持岗位层次）
	 * @author ZHANLS 2025年05月06日
     */
	@PostMapping(value = "/pageList",consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	@Operation(summary = "根据条件分页查询全部岗位表（支持岗位层次）")
	public ApiResult<PageDTO<PositionDTO>> pageList(@RequestBody @Validated PageDTO<PositionDTO> pageDTO) throws IllegalAccessException {
		Page<PositionDTO> page = PageHelper.startPage(pageDTO.getPageNum(), pageDTO.getPageSize());
		List<PositionDTO> positionDtoList = positionService.selectListByObject(pageDTO.getCondition());
		return ApiResult.ok(new PageDTO<>(page, positionDtoList));
	}
}
