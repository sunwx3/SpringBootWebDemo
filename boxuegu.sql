/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : localhost:3306
 Source Schema         : boxuegu

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 30/07/2019 14:21:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for music
-- ----------------------------
DROP TABLE IF EXISTS `music`;
CREATE TABLE `music`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `singer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '歌手',
  `album` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专辑',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '路径',
  `time` datetime NOT NULL COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of music
-- ----------------------------
INSERT INTO `music` VALUES (1, '生僻字', '陈科宇', '生僻字', './music/生僻字.mp3', '2019-07-19 10:44:12');
INSERT INTO `music` VALUES (2, '有何不可', '许嵩', '自定义', './music/有何不可.mp3', '2019-07-19 10:46:31');
INSERT INTO `music` VALUES (3, '狂狼', '花姐', '狂狼', './music/狂狼.mp3', '2019-07-19 10:46:31');
INSERT INTO `music` VALUES (4, '可惜没有如果', '林俊杰', '新地球', './music/可惜没有如果.mp3', '2019-07-19 10:46:31');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `imgUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', './upload/1.jpg');
INSERT INTO `user` VALUES (2, 'user', 'user', './upload/2.jpg');
INSERT INTO `user` VALUES (3, 'user1', 'user1', './upload/3,jpg');
INSERT INTO `user` VALUES (4, 'user2', 'user2', './uoload/4.jpg');

SET FOREIGN_KEY_CHECKS = 1;
