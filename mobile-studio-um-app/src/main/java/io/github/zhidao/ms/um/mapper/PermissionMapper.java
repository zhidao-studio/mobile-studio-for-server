package io.github.zhidao.ms.um.mapper;

import io.github.zhidao.ms.um.entity.Permission;

import org.springframework.stereotype.Repository;

import tk.mybatis.mapper.common.Mapper;

/**
 * 权限表（支持权限层次）Mapper接口
 *
 * @author ZHANLS 2025年05月06日
 * @version 1.0
 */
@Repository
public interface PermissionMapper extends Mapper<Permission> {

    /****************** 自定义Mapper方法 ********************/




}
