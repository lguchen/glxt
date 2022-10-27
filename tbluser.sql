/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2022-10-22 20:51:54
*/

SET FOREIGN_KEY_CHECKS=0;


-- ----------------------------
-- Table structure for tbluser
-- ----------------------------
DROP TABLE IF EXISTS `tbluser`;
CREATE TABLE `tbluser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `userPass` varchar(255) NOT NULL,
  `userRole` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userName` (`userName`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbluser
-- ----------------------------
INSERT INTO `tbluser` VALUES ('1', 'a', '123', '普通用户');
INSERT INTO `tbluser` VALUES ('2', 'admin', 'admin', '管理员');
INSERT INTO `tbluser` VALUES ('3', 'b', '123', '普通用户');
INSERT INTO `tbluser` VALUES ('4', 'c', '123', '管理员');
INSERT INTO `tbluser` VALUES ('5', 'd', 'd', '普通用户');
INSERT INTO `tbluser` VALUES ('6', 'luo', 'luo', '普通用户');
