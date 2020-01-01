/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50096
 Source Host           : localhost:3306
 Source Schema         : ljw

 Target Server Type    : MySQL
 Target Server Version : 50096
 File Encoding         : 65001

 Date: 11/12/2019 16:15:18
*/
CREATE DATABASE JSTX;
USE JSTX;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for friend
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend`  (
  `id` int(11) NOT NULL,
  `m_id` int(11) NULL DEFAULT NULL,
  `f_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`),
  INDEX `fk1` USING BTREE(`m_id`),
  INDEX `fk2` USING BTREE(`f_id`),
  CONSTRAINT `fk1` FOREIGN KEY (`m_id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk2` FOREIGN KEY (`f_id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'InnoDB free: 3072 kB; (`m_id`) REFER `ljw/user`(`id`) ON UPDATE CASCADE; (`f_id`' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of friend
-- ----------------------------
INSERT INTO `friend` VALUES (0, 0, 1);
INSERT INTO `friend` VALUES (1, 0, 2);
INSERT INTO `friend` VALUES (2, 1, 2);

-- ----------------------------
-- Table structure for lt
-- ----------------------------
DROP TABLE IF EXISTS `lt`;
CREATE TABLE `lt`  (
  `id` int(11) NOT NULL,
  `m_id` int(11) NULL DEFAULT NULL,
  `f_id` int(11) NULL DEFAULT NULL,
  `jilu` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`),
  INDEX `fk3` USING BTREE(`m_id`),
  INDEX `fk4` USING BTREE(`f_id`),
  CONSTRAINT `fk3` FOREIGN KEY (`m_id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk4` FOREIGN KEY (`f_id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'InnoDB free: 3072 kB; (`m_id`) REFER `ljw/user`(`id`) ON UPDATE CASCADE; (`f_id`' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL,
  `password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (0, '0', '0');
INSERT INTO `user` VALUES (1, '1', '1');
INSERT INTO `user` VALUES (2, '2', '2');
INSERT INTO `user` VALUES (3, '3', '3');
INSERT INTO `user` VALUES (4, '4', '4');
INSERT INTO `user` VALUES (5, '5', '5');
INSERT INTO `user` VALUES (6, '6', '6');
INSERT INTO `user` VALUES (7, '7', '7');
INSERT INTO `user` VALUES (8, '8', '8');
INSERT INTO `user` VALUES (9, '9', '9');
INSERT INTO `user` VALUES (10, '10', '10');

SET FOREIGN_KEY_CHECKS = 1;
