/*
 Navicat Premium Data Transfer

 Source Server         : Emma
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : myschool

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 09/10/2019 22:05:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for qqlogin
-- ----------------------------
DROP TABLE IF EXISTS `qqlogin`;
CREATE TABLE `qqlogin`  (
  `QQ号` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `密码` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`QQ号`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qqlogin
-- ----------------------------
INSERT INTO `qqlogin` VALUES ('1', '123456');
INSERT INTO `qqlogin` VALUES ('2', '123456');
INSERT INTO `qqlogin` VALUES ('3', '123456');
INSERT INTO `qqlogin` VALUES ('4', '123456');
INSERT INTO `qqlogin` VALUES ('5', '123456');
INSERT INTO `qqlogin` VALUES ('6', '123456');
INSERT INTO `qqlogin` VALUES ('7', '123');
INSERT INTO `qqlogin` VALUES ('8', '123456');

SET FOREIGN_KEY_CHECKS = 1;
