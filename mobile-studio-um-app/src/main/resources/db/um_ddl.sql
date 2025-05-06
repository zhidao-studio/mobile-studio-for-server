/*
 Navicat Premium Data Transfer

 Source Server         : local-mysql
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : um

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 28/03/2023 23:18:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for template
-- ----------------------------
DROP TABLE IF EXISTS `template`;
CREATE TABLE `template` (
  `id` varchar(32)  NOT NULL COMMENT 'ID',
  `create_user` varchar(32)  NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32)  NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1)  NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1)  NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin;

-- ----------------------------
-- Table structure for um_company
-- ----------------------------
DROP TABLE IF EXISTS `um_company`;
CREATE TABLE `um_company` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `create_user` varchar(32)   NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32)   NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1)   NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1)   NOT NULL DEFAULT '0' COMMENT '是否删除',
  `company_id` varchar(32)  NOT NULL COMMENT '企业ID',
  `company_name` varchar(100)  NOT NULL COMMENT '企业名称',
  `company_type` varchar(1)   DEFAULT NULL COMMENT '企业类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='公司企业表';

-- ----------------------------
-- Table structure for um_org
-- ----------------------------
DROP TABLE IF EXISTS `um_org`;
CREATE TABLE `um_org` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `create_user` varchar(32)   NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32)   NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1)   NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1)   NOT NULL DEFAULT '0' COMMENT '是否删除',
  `org_id` varchar(32)  NOT NULL COMMENT '组织ID',
  `org_name` varchar(255)  NOT NULL COMMENT '组织名称',
  `parent_org_id` varchar(32)   NOT NULL COMMENT '父级组织ID',
  `company_id` varchar(32)  NOT NULL COMMENT '企业ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='组织表';

-- ----------------------------
-- Table structure for um_org_role
-- ----------------------------
DROP TABLE IF EXISTS `um_org_role`;
CREATE TABLE `um_org_role` (
  `id` varchar(32)   NOT NULL COMMENT 'ID',
  `create_user` varchar(32)   NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32)   NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1)   NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1)   NOT NULL DEFAULT '0' COMMENT '是否删除',
  `org_id` varchar(32)  NOT NULL COMMENT '组织ID',
  `role_id` varchar(32)  NOT NULL COMMENT '角色ID',
  `company_id` varchar(32)  NOT NULL COMMENT '企业ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='组织角色关联表';

-- ----------------------------
-- Table structure for um_permission
-- ----------------------------
DROP TABLE IF EXISTS `um_permission`;
CREATE TABLE `um_permission` (
  `id` varchar(32)   NOT NULL COMMENT 'ID',
  `create_user` varchar(32)   NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32)   NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1)   NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1)   NOT NULL DEFAULT '0' COMMENT '是否删除',
  `permission_id` varchar(32)  NOT NULL COMMENT '权限ID',
  `permission_name` varchar(32)  NOT NULL COMMENT '权限名称',
  `type` varchar(2)  NOT NULL COMMENT '权限类型',
  `parent_permission_id` varchar(32)  NOT NULL COMMENT '父权限ID',
  `company_id` varchar(32)  NOT NULL COMMENT '企业ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='权限表';

-- ----------------------------
-- Table structure for um_post
-- ----------------------------
DROP TABLE IF EXISTS `um_post`;
CREATE TABLE `um_post` (
  `id` varchar(32)   NOT NULL COMMENT 'ID',
  `create_user` varchar(32)   NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32)   NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1)   NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1)   NOT NULL DEFAULT '0' COMMENT '是否删除',
  `post_id` varchar(32)  NOT NULL COMMENT '岗位ID',
  `post_name` varchar(32)  NOT NULL COMMENT '岗位名称',
  `parent_post_id` varchar(32)   NOT NULL COMMENT '上级岗位ID',
  `company_id` varchar(32)  NOT NULL COMMENT '企业ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='岗位表';

-- ----------------------------
-- Table structure for um_post_role
-- ----------------------------
DROP TABLE IF EXISTS `um_post_role`;
CREATE TABLE `um_post_role` (
  `id` varchar(32)   NOT NULL COMMENT 'ID',
  `create_user` varchar(32)   NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32)   NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1)   NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1)   NOT NULL DEFAULT '0' COMMENT '是否删除',
  `post_id` varchar(32)   NOT NULL COMMENT '岗位ID',
  `role_id` varchar(32)   NOT NULL COMMENT '角色ID',
  `company_id` varchar(32)  NOT NULL COMMENT '企业ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='岗位角色关联表';

-- ----------------------------
-- Table structure for um_role
-- ----------------------------
DROP TABLE IF EXISTS `um_role`;
CREATE TABLE `um_role` (
  `id` varchar(32)   NOT NULL COMMENT 'ID',
  `create_user` varchar(32)   NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32)   NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1)   NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1)   NOT NULL DEFAULT '0' COMMENT '是否删除',
  `role_id` varchar(32)  NOT NULL COMMENT '角色ID',
  `role_name` varchar(32)  NOT NULL COMMENT '角色名称',
  `parent_role_id` varchar(32)   NOT NULL COMMENT '父级角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='角色表';

-- ----------------------------
-- Table structure for um_role_exclusion
-- ----------------------------
DROP TABLE IF EXISTS `um_role_exclusion`;
CREATE TABLE `um_role_exclusion` (
  `id` varchar(32)   NOT NULL COMMENT 'ID',
  `create_user` varchar(32)   NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32)   NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1)   NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1)   NOT NULL DEFAULT '0' COMMENT '是否删除',
  `role_id` varchar(32)  NOT NULL COMMENT '角色ID',
  `exclusion_role_id` varchar(32)  NOT NULL COMMENT '互斥角色ID',
  `exclusion_desc` varchar(100)  NOT NULL COMMENT '互斥说明',
  `company_id` varchar(32)  NOT NULL COMMENT '企业ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='角色互斥表';

-- ----------------------------
-- Table structure for um_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `um_role_permission`;
CREATE TABLE `um_role_permission` (
  `id` varchar(32)   NOT NULL COMMENT 'ID',
  `create_user` varchar(32)   NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32)   NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1)   NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1)   NOT NULL DEFAULT '0' COMMENT '是否删除',
  `role_id` varchar(32)  NOT NULL COMMENT '角色ID',
  `permission_id` varchar(32)  NOT NULL COMMENT '权限ID',
  `company_id` varchar(32)  NOT NULL COMMENT '企业ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='角色权限表';

-- ----------------------------
-- Table structure for um_tenant
-- ----------------------------
DROP TABLE IF EXISTS `um_tenant`;
CREATE TABLE `um_tenant` (
  `id` varchar(32)   NOT NULL COMMENT 'ID',
  `create_user` varchar(32)   NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32)   NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1)   NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1)   NOT NULL DEFAULT '0' COMMENT '是否删除',
  `tenant_id` varchar(32)  NOT NULL COMMENT '租户ID',
  `tenant_name` varchar(100)  NOT NULL COMMENT '租户名称',
  `company_id` varchar(32)  DEFAULT NULL COMMENT '公司ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='租户表（废弃）';

-- ----------------------------
-- Table structure for um_user
-- ----------------------------
DROP TABLE IF EXISTS `um_user`;
CREATE TABLE `um_user` (
  `id` varchar(32)   NOT NULL COMMENT 'ID',
  `create_user` varchar(32)   NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32)   NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1)   NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1)   NOT NULL DEFAULT '0' COMMENT '是否删除',
  `user_id` varchar(32)  NOT NULL COMMENT '用户ID',
  `user_name` varchar(32)  NOT NULL COMMENT '用户名',
  `company_id` varchar(32)  NOT NULL COMMENT '企业ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='用户表';

-- ----------------------------
-- Table structure for um_user_group
-- ----------------------------
DROP TABLE IF EXISTS `um_user_group`;
CREATE TABLE `um_user_group` (
  `id` varchar(32)   NOT NULL COMMENT 'ID',
  `create_user` varchar(32)   NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32)   NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1)   NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1)   NOT NULL DEFAULT '0' COMMENT '是否删除',
  `user_group_id` varchar(32)  NOT NULL COMMENT '用户组ID',
  `user_group_name` varchar(32)  NOT NULL COMMENT '用户组名称',
  `company_id` varchar(32)  NOT NULL COMMENT '企业ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='用户组表';

-- ----------------------------
-- Table structure for um_user_group_role
-- ----------------------------
DROP TABLE IF EXISTS `um_user_group_role`;
CREATE TABLE `um_user_group_role` (
  `id` varchar(32)   NOT NULL COMMENT 'ID',
  `create_user` varchar(32)   NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32)   NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1)   NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1)   NOT NULL DEFAULT '0' COMMENT '是否删除',
  `user_group_id` varchar(32)   NOT NULL COMMENT '用户组ID',
  `role_id` varchar(32)   NOT NULL COMMENT '角色ID',
  `company_id` varchar(32)  NOT NULL COMMENT '企业ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='用户组角色关联表';

-- ----------------------------
-- Table structure for um_user_org
-- ----------------------------
DROP TABLE IF EXISTS `um_user_org`;
CREATE TABLE `um_user_org` (
  `id` varchar(32)   NOT NULL COMMENT 'ID',
  `create_user` varchar(32)   NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32)   NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1)   NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1)   NOT NULL DEFAULT '0' COMMENT '是否删除',
  `user_id` varchar(32)   NOT NULL COMMENT '用户ID',
  `org_id` varchar(32)   NOT NULL COMMENT '组织ID',
  `company_id` varchar(32)  NOT NULL COMMENT '企业ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='用户组织关联表';

-- ----------------------------
-- Table structure for um_user_post
-- ----------------------------
DROP TABLE IF EXISTS `um_user_post`;
CREATE TABLE `um_user_post` (
  `id` varchar(32)   NOT NULL COMMENT 'ID',
  `create_user` varchar(32)   NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32)   NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1)   NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1)   NOT NULL DEFAULT '0' COMMENT '是否删除',
  `user_id` varchar(32)   NOT NULL COMMENT '用户ID',
  `post_id` varchar(32)   NOT NULL COMMENT '岗位ID',
  `company_id` varchar(32)  NOT NULL COMMENT '企业ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='用户岗位关联表';

-- ----------------------------
-- Table structure for um_user_role
-- ----------------------------
DROP TABLE IF EXISTS `um_user_role`;
CREATE TABLE `um_user_role` (
  `id` varchar(32)   NOT NULL COMMENT 'ID',
  `create_user` varchar(32)   NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32)   NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1)   NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1)   NOT NULL DEFAULT '0' COMMENT '是否删除',
  `user_id` varchar(32)   NOT NULL COMMENT '用户ID',
  `role_id` varchar(32)   NOT NULL COMMENT '角色ID',
  `company_id` varchar(32)  NOT NULL COMMENT '企业ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='用户角色关联表';

-- ----------------------------
-- Table structure for um_user_to_group
-- ----------------------------
DROP TABLE IF EXISTS `um_user_to_group`;
CREATE TABLE `um_user_to_group` (
  `id` varchar(32)   NOT NULL COMMENT 'ID',
  `create_user` varchar(32)   NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32)   NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1)   NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1)   NOT NULL DEFAULT '0' COMMENT '是否删除',
  `user_id` varchar(32)   NOT NULL COMMENT '用户ID',
  `user_group_id` varchar(32)   NOT NULL COMMENT '用户组ID',
  `company_id` varchar(32)  NOT NULL COMMENT '企业ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='用户用户组关联表';

SET FOREIGN_KEY_CHECKS = 1;
