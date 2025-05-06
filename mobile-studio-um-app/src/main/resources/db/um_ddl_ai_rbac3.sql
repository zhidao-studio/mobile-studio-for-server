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
 Date: 2025/05/06 15:00:00
*/

SET NAMES utf8mb4 COLLATE utf8mb4_0900_ai_ci;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for template (保留原表，非RBAC核心表)
-- ----------------------------

# DROP TABLE IF EXISTS `template`;
# CREATE TABLE `template` (
#   `id` varchar(32) NOT NULL COMMENT 'ID',
#   `create_user` varchar(32) NOT NULL COMMENT '创建人',
#   `create_time` datetime NOT NULL COMMENT '创建时间',
#   `update_user` varchar(32) NOT NULL COMMENT '更新人',
#   `update_time` datetime NOT NULL COMMENT '更新时间',
#   `valid` varchar(1) NOT NULL DEFAULT '1' COMMENT '是否有效',
#   `deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
#   PRIMARY KEY (`id`)
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='模板表';

-- ----------------------------
-- Table structure for um_company (企业表)
-- ----------------------------
DROP TABLE IF EXISTS `um_company`;
CREATE TABLE `um_company` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `company_id` varchar(32) NOT NULL COMMENT '企业ID',
  `company_name` varchar(100) NOT NULL COMMENT '企业名称',
  `company_type` varchar(1) DEFAULT NULL COMMENT '企业类型',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32) NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1) NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_company_id` (`company_id`) COMMENT '企业ID唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='公司企业表';

-- ----------------------------
-- Table structure for um_org (组织表)
-- ----------------------------
DROP TABLE IF EXISTS `um_org`;
CREATE TABLE `um_org` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `org_id` varchar(32) NOT NULL COMMENT '组织ID',
  `org_name` varchar(255) NOT NULL COMMENT '组织名称',
  `parent_org_id` varchar(32) NOT NULL COMMENT '父级组织ID',
  `company_id` varchar(32) NOT NULL COMMENT '企业ID',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32) NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1) NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_org_company_id` (`org_id`, `company_id`) COMMENT '组织ID+企业ID唯一',
  KEY `idx_company_id` (`company_id`) COMMENT '企业ID索引',
  CONSTRAINT `fk_org_company_id` FOREIGN KEY (`company_id`) REFERENCES `um_company` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='组织表';

-- ----------------------------
-- Table structure for um_role (核心：角色层次结构)
-- ----------------------------
DROP TABLE IF EXISTS `um_role`;
CREATE TABLE `um_role` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `role_id` varchar(32) NOT NULL COMMENT '角色ID',
  `role_name` varchar(32) NOT NULL COMMENT '角色名称',
  `parent_role_id` varchar(32) DEFAULT NULL COMMENT '父级角色ID（根角色为NULL）',
  `role_level` tinyint UNSIGNED DEFAULT '0' COMMENT '角色层级（根角色0，子角色逐层+1）',
  `company_id` varchar(32) NOT NULL COMMENT '企业ID',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32) NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1) NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_role_company_id` (`role_id`, `company_id`) COMMENT '角色ID+企业ID唯一',
  KEY `idx_parent_role_id` (`parent_role_id`) COMMENT '父角色索引',
  KEY `idx_company_id` (`company_id`) COMMENT '企业ID索引',
  CONSTRAINT `fk_role_company_id` FOREIGN KEY (`company_id`) REFERENCES `um_company` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='角色表（支持角色层次）';

-- ----------------------------
-- Table structure for um_permission (权限表，支持权限层次)
-- ----------------------------
DROP TABLE IF EXISTS `um_permission`;
CREATE TABLE `um_permission` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `permission_id` varchar(32) NOT NULL COMMENT '权限ID',
  `permission_name` varchar(32) NOT NULL COMMENT '权限名称',
  `type` varchar(2) NOT NULL COMMENT '权限类型（0:菜单 1:操作 2:数据）',
  `parent_permission_id` varchar(32) DEFAULT NULL COMMENT '父权限ID（顶级权限为NULL）',
  `company_id` varchar(32) NOT NULL COMMENT '企业ID',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32) NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1) NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_permission_company_id` (`permission_id`, `company_id`) COMMENT '权限ID+企业ID唯一',
  KEY `idx_parent_permission_id` (`parent_permission_id`) COMMENT '父权限索引',
  KEY `idx_company_id` (`company_id`) COMMENT '企业ID索引',
  CONSTRAINT `fk_permission_company_id` FOREIGN KEY (`company_id`) REFERENCES `um_company` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='权限表（支持权限层次）';

-- ----------------------------
-- Table structure for um_role_exclusion (核心：角色互斥约束)
-- ----------------------------
DROP TABLE IF EXISTS `um_role_exclusion`;
CREATE TABLE `um_role_exclusion` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `exclusion_role_id` varchar(32) NOT NULL COMMENT '互斥角色ID',
  `role_id` varchar(32) NOT NULL COMMENT '角色ID',
  `exclusion_type` tinyint NOT NULL DEFAULT '0' COMMENT '互斥类型（0:静态互斥 1:动态互斥）',
  `exclusion_desc` varchar(100) NOT NULL COMMENT '互斥说明',
  `company_id` varchar(32) NOT NULL COMMENT '企业ID',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32) NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1) NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_role_exclusion` (`role_id`, `exclusion_role_id`, `company_id`) COMMENT '唯一互斥关系（角色+互斥角色+企业）',
  KEY `idx_company_id` (`company_id`) COMMENT '企业ID索引',
  CONSTRAINT `fk_exclusion_role_id` FOREIGN KEY (`role_id`, `company_id`) REFERENCES `um_role` (`role_id`, `company_id`),
  CONSTRAINT `fk_exclusion_exclusion_role_id` FOREIGN KEY (`exclusion_role_id`, `company_id`) REFERENCES `um_role` (`role_id`, `company_id`),
  CONSTRAINT `fk_exclusion_company_id` FOREIGN KEY (`company_id`) REFERENCES `um_company` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='角色互斥表（支持静态/动态互斥）';

-- ----------------------------
-- Table structure for um_role_permission (角色权限关联)
-- ----------------------------
DROP TABLE IF EXISTS `um_role_permission`;
CREATE TABLE `um_role_permission` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `role_id` varchar(32) NOT NULL COMMENT '角色ID',
  `permission_id` varchar(32) NOT NULL COMMENT '权限ID',
  `company_id` varchar(32) NOT NULL COMMENT '企业ID',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32) NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1) NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_role_permission` (`role_id`, `permission_id`, `company_id`) COMMENT '角色+权限+企业唯一',
  KEY `idx_role_id` (`role_id`) COMMENT '角色ID索引',
  KEY `idx_permission_id` (`permission_id`) COMMENT '权限ID索引',
  CONSTRAINT `fk_rp_role_id` FOREIGN KEY (`role_id`, `company_id`) REFERENCES `um_role` (`role_id`, `company_id`),
  CONSTRAINT `fk_rp_permission_id` FOREIGN KEY (`permission_id`, `company_id`) REFERENCES `um_permission` (`permission_id`, `company_id`),
  CONSTRAINT `fk_rp_company_id` FOREIGN KEY (`company_id`) REFERENCES `um_company` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='角色权限关联表';

-- ----------------------------
-- Table structure for um_user (用户表)
-- ----------------------------
DROP TABLE IF EXISTS `um_user`;
CREATE TABLE `um_user` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `user_name` varchar(32) NOT NULL COMMENT '用户名',
  `company_id` varchar(32) NOT NULL COMMENT '企业ID',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32) NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1) NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_user_company_id` (`user_id`, `company_id`) COMMENT '用户ID+企业ID唯一',
  KEY `idx_company_id` (`company_id`) COMMENT '企业ID索引',
  CONSTRAINT `fk_user_company_id` FOREIGN KEY (`company_id`) REFERENCES `um_company` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='用户表';

-- ----------------------------
-- Table structure for um_user_role (用户角色关联)
-- ----------------------------
DROP TABLE IF EXISTS `um_user_role`;
CREATE TABLE `um_user_role` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `role_id` varchar(32) NOT NULL COMMENT '角色ID',
  `company_id` varchar(32) NOT NULL COMMENT '企业ID',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32) NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1) NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_user_role` (`user_id`, `role_id`, `company_id`) COMMENT '用户+角色+企业唯一',
  KEY `idx_user_id` (`user_id`) COMMENT '用户ID索引',
  KEY `idx_role_id` (`role_id`) COMMENT '角色ID索引',
  CONSTRAINT `fk_ur_user_id` FOREIGN KEY (`user_id`, `company_id`) REFERENCES `um_user` (`user_id`, `company_id`),
  CONSTRAINT `fk_ur_role_id` FOREIGN KEY (`role_id`, `company_id`) REFERENCES `um_role` (`role_id`, `company_id`),
  CONSTRAINT `fk_ur_company_id` FOREIGN KEY (`company_id`) REFERENCES `um_company` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='用户角色关联表';

-- ----------------------------
-- um_org_role（组织角色关联）
-- ----------------------------
DROP TABLE IF EXISTS `um_org_role`;
CREATE TABLE `um_org_role` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `org_id` varchar(32) NOT NULL COMMENT '组织ID',
  `role_id` varchar(32) NOT NULL COMMENT '角色ID',
  `company_id` varchar(32) NOT NULL COMMENT '企业ID',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32) NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1) NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_org_role` (`org_id`, `role_id`, `company_id`) COMMENT '组织+角色+企业唯一',
  CONSTRAINT `fk_or_org_id` FOREIGN KEY (`org_id`, `company_id`) REFERENCES `um_org` (`org_id`, `company_id`),
  CONSTRAINT `fk_or_role_id` FOREIGN KEY (`role_id`, `company_id`) REFERENCES `um_role` (`role_id`, `company_id`),
  CONSTRAINT `fk_or_company_id` FOREIGN KEY (`company_id`) REFERENCES `um_company` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='组织角色关联表';

-- ----------------------------
-- um_position（岗位表，支持岗位层次）
-- ----------------------------
DROP TABLE IF EXISTS `um_position`;
CREATE TABLE `um_position` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `position_id` varchar(32) NOT NULL COMMENT '岗位ID',
  `position_name` varchar(32) NOT NULL COMMENT '岗位名称',
  `parent_position_id` varchar(32) DEFAULT NULL COMMENT '上级岗位ID（顶级岗位为NULL）',
  `company_id` varchar(32) NOT NULL COMMENT '企业ID',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32) NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1) NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_position_company_id` (`position_id`, `company_id`) COMMENT '岗位ID+企业ID唯一',
  KEY `idx_parent_position_id` (`parent_position_id`) COMMENT '上级岗位索引',
  CONSTRAINT `fk_position_company_id` FOREIGN KEY (`company_id`) REFERENCES `um_company` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='岗位表（支持岗位层次）';

-- ----------------------------
-- um_user_group（用户组表）
-- ----------------------------
DROP TABLE IF EXISTS `um_user_group`;
CREATE TABLE `um_user_group` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `group_id` varchar(32) NOT NULL COMMENT '用户组ID',
  `group_name` varchar(32) NOT NULL COMMENT '用户组名称',
  `parent_group_id` varchar(32) DEFAULT NULL COMMENT '父级用户组ID（顶级用户组为NULL）',
  `company_id` varchar(32) NOT NULL COMMENT '企业ID',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32) NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1) NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_user_group_company_id` (`group_id`, `company_id`) COMMENT '用户组ID+企业ID唯一',
  KEY `idx_parent_group_id` (`parent_group_id`) COMMENT '父级用户组索引',
  KEY `idx_company_id` (`company_id`) COMMENT '企业ID索引',
  CONSTRAINT `fk_user_group_company_id` FOREIGN KEY (`company_id`) REFERENCES `um_company` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='用户组表（支持用户组层次）';

-- ----------------------------
-- um_user_group_user（用户与用户组关联表）
-- ----------------------------
DROP TABLE IF EXISTS `um_user_group_user`;
CREATE TABLE `um_user_group_user` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `group_id` varchar(32) NOT NULL COMMENT '用户组ID',
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `company_id` varchar(32) NOT NULL COMMENT '企业ID',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32) NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1) NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_user_group_user` (`group_id`, `user_id`, `company_id`) COMMENT '用户组+用户+企业唯一',
  KEY `idx_group_id` (`group_id`) COMMENT '用户组ID索引',
  KEY `idx_user_id` (`user_id`) COMMENT '用户ID索引',
  CONSTRAINT `fk_ugu_group_id` FOREIGN KEY (`group_id`, `company_id`) REFERENCES `um_user_group` (`group_id`, `company_id`),
  CONSTRAINT `fk_ugu_user_id` FOREIGN KEY (`user_id`, `company_id`) REFERENCES `um_user` (`user_id`, `company_id`),
  CONSTRAINT `fk_ugu_company_id` FOREIGN KEY (`company_id`) REFERENCES `um_company` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='用户与用户组关联表';

-- ----------------------------
-- um_user_position（用户与岗位关联表）
-- ----------------------------
DROP TABLE IF EXISTS `um_user_position`;
CREATE TABLE `um_user_position` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `position_id` varchar(32) NOT NULL COMMENT '岗位ID',
  `company_id` varchar(32) NOT NULL COMMENT '企业ID',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_user` varchar(32) NOT NULL COMMENT '更新人',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `valid` varchar(1) NOT NULL DEFAULT '1' COMMENT '是否有效',
  `deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_user_position` (`user_id`, `position_id`, `company_id`) COMMENT '用户+岗位+企业唯一',
  KEY `idx_user_id` (`user_id`) COMMENT '用户ID索引',
  KEY `idx_position_id` (`position_id`) COMMENT '岗位ID索引',
  CONSTRAINT `fk_up_user_id` FOREIGN KEY (`user_id`, `company_id`) REFERENCES `um_user` (`user_id`, `company_id`),
  CONSTRAINT `fk_up_position_id` FOREIGN KEY (`position_id`, `company_id`) REFERENCES `um_position` (`position_id`, `company_id`),
  CONSTRAINT `fk_up_company_id` FOREIGN KEY (`company_id`) REFERENCES `um_company` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin COMMENT='用户与岗位关联表';

SET FOREIGN_KEY_CHECKS = 1;
