package io.github.zhidao.ms.um.mapper;

import io.github.zhidao.ms.um.entity.RoleExclusion;

import org.springframework.stereotype.Repository;

import tk.mybatis.mapper.common.Mapper;

/**
 * 角色互斥表（支持静态/动态互斥）Mapper接口
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Repository
public interface RoleExclusionMapper extends Mapper<RoleExclusion> {

    /****************** 自定义Mapper方法 ********************/




}
