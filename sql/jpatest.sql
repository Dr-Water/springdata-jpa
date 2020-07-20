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

 Date: 20/07/2020 17:40:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '仓库管理员');
INSERT INTO `role` VALUES (2, '大门管理员');
INSERT INTO `role` VALUES (3, '超级管理员');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) NULL DEFAULT NULL,
  `score` int(11) NULL DEFAULT NULL,
  `subject_id` int(11) NULL DEFAULT NULL,
  `score_list_id` int(11) NOT NULL,
  `s_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK56nv285e8l73fru4sw2152y87`(`subject_id`) USING BTREE,
  INDEX `FK4ciedivb6hf5kkx9r333w9o7k`(`sid`) USING BTREE,
  CONSTRAINT `FK56nv285e8l73fru4sw2152y87` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK4ciedivb6hf5kkx9r333w9o7k` FOREIGN KEY (`sid`) REFERENCES `student` (`sid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (1, 1, 88, 1, 0, 0);
INSERT INTO `score` VALUES (2, 1, 66, 2, 0, 0);
INSERT INTO `score` VALUES (3, 1, 99, 3, 0, 0);
INSERT INTO `score` VALUES (4, 2, 55, 1, 0, 0);
INSERT INTO `score` VALUES (5, 2, 88, 2, 0, 0);
INSERT INTO `score` VALUES (6, 2, 77, 3, 0, 0);
INSERT INTO `score` VALUES (7, 3, 78, 2, 0, 0);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sid` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '张三');
INSERT INTO `student` VALUES (2, '李四');
INSERT INTO `student` VALUES (3, '王五');

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject`  (
  `id` int(11) NOT NULL,
  `subject_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES (1, '语文', NULL);
INSERT INTO `subject` VALUES (2, '数学', NULL);
INSERT INTO `subject` VALUES (3, '英语', NULL);

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

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张三');
INSERT INTO `user` VALUES (2, '李四');
INSERT INTO `user` VALUES (3, '王五');
INSERT INTO `user` VALUES (4, '赵六');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` int(11) NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  INDEX `FK859n2jvi8ivhui0rl0esws6o`(`user_id`) USING BTREE,
  INDEX `FKa68196081fvovjhkek5m97n3y`(`role_id`) USING BTREE,
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (1, 2);
INSERT INTO `user_role` VALUES (2, 3);
INSERT INTO `user_role` VALUES (3, 2);
INSERT INTO `user_role` VALUES (3, 3);

SET FOREIGN_KEY_CHECKS = 1;
