package io.github.zhidao.ms.um.service.impl;

import cn.hutool.core.convert.Convert;
import io.github.zhidao.ms.common.service.BaseCurdService;
import io.github.zhidao.ms.um.dto.PositionDTO;
import io.github.zhidao.ms.um.entity.Position;
import io.github.zhidao.ms.um.mapper.PositionMapper;
import io.github.zhidao.ms.um.service.PositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 岗位表（支持岗位层次）业务逻辑实现
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Service
@Slf4j
public class PositionServiceImpl extends BaseCurdService<Position> implements PositionService {

	@Autowired
	private PositionMapper positionMapper;

	/**
     * 新增岗位表（支持岗位层次）
     *
     * @param positionDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer insert(PositionDTO positionDTO) {
		return baseInsert(Convert.convert(Position.class,positionDTO));
	}

	/**
     * 新增或修改岗位表（支持岗位层次）
     *
     * @param positionDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer insertOrUpdate(PositionDTO positionDTO) {
		return insertOrUpdate(Convert.convert(Position.class,positionDTO), positionDTO.getId());
	}

	/**
     * 删除岗位表（支持岗位层次）,实际是置is_delete 为1
     *
     * @param id
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer deleteById(String id) {
		return baseDeleteByPK(new Position(id));
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
		return baseDisableByPK(new Position(id));
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
		return baseEnableByPK(new Position(id));
	}

	/**
     * 修改岗位表（支持岗位层次）
     *
     * @param positionDTO
     * @return Integer
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public Integer updateById(PositionDTO positionDTO) {
		return baseUpdateByPK(Convert.convert(Position.class,positionDTO));
	}

	/**
     * 按参数positionDTO的非空属性查询列表
     *
     * @param positionDTO
     * @return List<PositionDTO>
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public List<PositionDTO> selectListByObject(PositionDTO positionDTO){
		List<Position> positionList = baseSelectListByObject(Convert.convert(Position.class,positionDTO));
		List<PositionDTO> positionDtoList = new ArrayList<>();
		positionList.forEach(positionEntity -> {
			positionDtoList.add(Convert.convert(PositionDTO.class,positionEntity));
		});
		return positionDtoList;
	}

	/**
     * 按参数positionDTO的非空属性查询单条记录
     *
     * @param positionDTO
     * @return List<PositionDTO>
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public PositionDTO selectOneByObject(PositionDTO positionDTO) {
		Position positionEntity = baseSelectOneByObject(Convert.convert(Position.class,positionDTO));
		return Convert.convert(PositionDTO.class,positionEntity);
	}

	/**
     * 主键查询岗位表（支持岗位层次）
     *
     * @param id
     * @return PositionDTO
     * @updateRecord - 初次创建
     * @version 1.0 (2025年05月06日)
     * @author ZHANLS
     */
	@Override
	public PositionDTO selectById(String id) {
		Position positionEntity = baseSelectByPK(new Position(id));
		return Convert.convert(PositionDTO.class,positionEntity);
	}
}
