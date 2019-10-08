/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2019-10-08 22:41:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ums_admin
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin`;
CREATE TABLE `ums_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL COMMENT '头像',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `nick_name` varchar(200) DEFAULT NULL COMMENT '昵称',
  `note` varchar(500) DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` int(1) DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='后台用户表';

-- ----------------------------
-- Records of ums_admin
-- ----------------------------
INSERT INTO `ums_admin` VALUES ('5', 'admin', '123456', '1', '1163271592@qq.com', 'jack', '1', '2019-10-07 16:51:01', '2019-10-07 16:50:51', '1');

-- ----------------------------
-- Table structure for ums_menu
-- ----------------------------
DROP TABLE IF EXISTS `ums_menu`;
CREATE TABLE `ums_menu` (
  `func_id` varchar(100) NOT NULL DEFAULT '' COMMENT '菜单ID',
  `func_code` varchar(100) DEFAULT NULL COMMENT '菜单编码',
  `name` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `parent_id` varchar(100) DEFAULT NULL COMMENT '父菜单ID',
  `viewname` varchar(100) DEFAULT NULL COMMENT 'js跳转地址',
  `func_seq` int(10) DEFAULT NULL COMMENT '菜单排序seq',
  `func_img` varchar(100) DEFAULT NULL COMMENT '菜单图表地址',
  `create_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` varchar(100) DEFAULT NULL COMMENT '菜单状态，0,正常;1,隐藏',
  PRIMARY KEY (`func_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of ums_menu
-- ----------------------------

-- ----------------------------
-- Table structure for ums_role
-- ----------------------------
DROP TABLE IF EXISTS `ums_role`;
CREATE TABLE `ums_role` (
  `role_id` varchar(100) NOT NULL DEFAULT '' COMMENT '角色ID',
  `role_code` varchar(100) DEFAULT NULL COMMENT '角色编码',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `create_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `role_img` varchar(100) DEFAULT NULL COMMENT '角色图片',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of ums_role
-- ----------------------------
INSERT INTO `ums_role` VALUES ('427634696977911808', 'admin', '系统管理员', 'sunwx', '2019-10-08 21:12:11', null, '2019-10-08 21:12:15', null);
INSERT INTO `ums_role` VALUES ('526552648938786816', 'customer', '客户', 'sunwx', '2019-10-08 21:15:20', null, '2019-10-08 21:15:25', null);
INSERT INTO `ums_role` VALUES ('526555240817332224', 'product', '商家', 'sunwx', '2019-10-08 21:15:56', null, '2019-10-08 21:16:20', null);

-- ----------------------------
-- Table structure for ums_role_ref_menu
-- ----------------------------
DROP TABLE IF EXISTS `ums_role_ref_menu`;
CREATE TABLE `ums_role_ref_menu` (
  `role_id` varchar(100) DEFAULT NULL COMMENT '角色ID',
  `func_id` varchar(100) DEFAULT NULL COMMENT '菜单ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单关联表';

-- ----------------------------
-- Records of ums_role_ref_menu
-- ----------------------------

-- ----------------------------
-- Table structure for ums_user
-- ----------------------------
DROP TABLE IF EXISTS `ums_user`;
CREATE TABLE `ums_user` (
  `user_id` varchar(100) NOT NULL DEFAULT '' COMMENT '用户ID',
  `user_code` varchar(100) DEFAULT NULL COMMENT '用户编码',
  `administrator` varchar(100) DEFAULT NULL COMMENT '是否是管理员 Y是 N否',
  `user_name` varchar(100) DEFAULT NULL COMMENT '用户名称',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `token` varchar(100) DEFAULT NULL COMMENT 'token',
  `phone` varchar(100) DEFAULT NULL COMMENT '手机号',
  `email` varchar(100) DEFAULT NULL COMMENT 'email',
  `status` varchar(100) DEFAULT NULL COMMENT '状态 0 禁用 1 启用',
  `create_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `center_id` varchar(100) DEFAULT NULL COMMENT '创建人ID',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of ums_user
-- ----------------------------
INSERT INTO `ums_user` VALUES ('551554877936611328', 'sunwx', 'Y', '孙文贤', '!Q@W3e4r', null, '13732208353', '1163271592@qq.com', '1', 'sunwx', '2019-10-08 21:21:02', null, '2019-10-08 21:21:06', '551554877936611328');

-- ----------------------------
-- Table structure for ums_user_ref_role
-- ----------------------------
DROP TABLE IF EXISTS `ums_user_ref_role`;
CREATE TABLE `ums_user_ref_role` (
  `user_id` varchar(100) DEFAULT NULL COMMENT '用户ID',
  `role_id` varchar(100) DEFAULT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色关联表';

-- ----------------------------
-- Records of ums_user_ref_role
-- ----------------------------
INSERT INTO `ums_user_ref_role` VALUES ('551554877936611328', '427634696977911808');
