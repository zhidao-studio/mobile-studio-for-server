package io.github.zhidao.ms.um.mapper;

import io.github.zhidao.ms.um.entity.Role;

import org.springframework.stereotype.Repository;

import tk.mybatis.mapper.common.Mapper;

/**
 * 角色表（支持角色层次）Mapper接口
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Repository
public interface RoleMapper extends Mapper<Role> {

    /****************** 自定义Mapper方法 ********************/




}
