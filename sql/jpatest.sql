/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : jpatest

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 16/07/2020 09:15:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '张三', '123', 'zhangsan@163.com');
INSERT INTO `tb_user` VALUES ('1001', 'zhangsan', '2222', '123@qq.com');
INSERT INTO `tb_user` VALUES ('2', '李四', '123', 'lisi@163.com');
INSERT INTO `tb_user` VALUES ('3', '王五', '123', 'wangwu@163.com');
INSERT INTO `tb_user` VALUES ('4', '赵六', '123', 'zhaoliu@163.com');
INSERT INTO `tb_user` VALUES ('40289225735040ec01735040f18a0000', 'zhangsan', '2222', '123@qq.com');
INSERT INTO `tb_user` VALUES ('402892257350438b01735043907e0000', 'zhangsan', '2222', '123@qq.com');
INSERT INTO `tb_user` VALUES ('402892257350453401735045395b0000', 'zhangsan', '333', '123@qq.com');
INSERT INTO `tb_user` VALUES ('402892257350468d0173504692fc0000', 'zhangsan', '333', '123@qq.com');
INSERT INTO `tb_user` VALUES ('402892257350510f0173505116120000', 'zhangsan', '333', '123@qq.com');
INSERT INTO `tb_user` VALUES ('40289225735059540173505959920000', 'zhangsan', '333', '123@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
