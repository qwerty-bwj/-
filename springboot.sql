/*
 Navicat Premium Data Transfer

 Source Server         : Javaweb
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : springboot

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 28/03/2022 09:22:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `c_id` int unsigned NOT NULL,
  `grade` tinyint unsigned NOT NULL,
  `classes` tinyint unsigned NOT NULL,
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (101, 1, 1);
INSERT INTO `course` VALUES (102, 1, 2);
INSERT INTO `course` VALUES (103, 1, 3);
INSERT INTO `course` VALUES (104, 1, 4);
INSERT INTO `course` VALUES (105, 1, 5);
INSERT INTO `course` VALUES (601, 6, 1);
INSERT INTO `course` VALUES (602, 6, 2);
INSERT INTO `course` VALUES (603, 6, 3);
INSERT INTO `course` VALUES (604, 6, 4);
INSERT INTO `course` VALUES (605, 6, 5);

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `r_num` int unsigned NOT NULL,
  `s_id` int unsigned NOT NULL,
  `t_id` int unsigned NOT NULL,
  `t_num` int unsigned NOT NULL,
  `time` datetime(0) NOT NULL,
  PRIMARY KEY (`r_num`) USING BTREE,
  INDEX `s_id`(`s_id`) USING BTREE,
  INDEX `t_id`(`t_id`) USING BTREE,
  INDEX `t_num`(`t_num`) USING BTREE,
  CONSTRAINT `record_ibfk_1` FOREIGN KEY (`s_id`) REFERENCES `student` (`s_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `record_ibfk_2` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`t_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `record_ibfk_3` FOREIGN KEY (`t_num`) REFERENCES `template` (`t_num`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES (19, 1005, 9101, 3, '2022-03-25 15:26:59');
INSERT INTO `record` VALUES (24, 1003, 9101, 1, '2022-03-25 21:14:23');
INSERT INTO `record` VALUES (25, 1003, 9101, 2, '2022-03-25 21:14:23');
INSERT INTO `record` VALUES (26, 1004, 9101, 1, '2022-03-25 21:14:23');
INSERT INTO `record` VALUES (28, 1003, 9101, 13, '2022-03-27 16:25:05');
INSERT INTO `record` VALUES (29, 1001, 9101, 1, '2022-03-27 20:54:43');
INSERT INTO `record` VALUES (30, 1001, 9101, 2, '2022-03-27 20:54:43');
INSERT INTO `record` VALUES (31, 1001, 9101, 3, '2022-03-27 20:54:43');
INSERT INTO `record` VALUES (32, 1001, 9101, 4, '2022-03-27 20:54:43');
INSERT INTO `record` VALUES (33, 1001, 9101, 5, '2022-03-27 20:54:44');
INSERT INTO `record` VALUES (34, 1001, 9101, 6, '2022-03-27 20:54:44');
INSERT INTO `record` VALUES (35, 1001, 9101, 7, '2022-03-27 20:54:44');
INSERT INTO `record` VALUES (36, 1001, 9101, 8, '2022-03-27 20:54:44');
INSERT INTO `record` VALUES (37, 1001, 9101, 9, '2022-03-27 20:54:44');
INSERT INTO `record` VALUES (38, 1001, 9101, 10, '2022-03-27 20:54:44');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `s_id` int unsigned NOT NULL,
  `s_password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `s_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `c_id` int unsigned NOT NULL,
  `score` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`s_id`) USING BTREE,
  INDEX `c_id`(`c_id`) USING BTREE,
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `course` (`c_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1008 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1001, '830b929d0e46e7e4579d70a794b6a079', '学生01', 101, -44);
INSERT INTO `student` VALUES (1002, '830b929d0e46e7e4579d70a794b6a079', '学生02', 101, 0);
INSERT INTO `student` VALUES (1003, '830b929d0e46e7e4579d70a794b6a079', '学生03', 101, -95);
INSERT INTO `student` VALUES (1004, '830b929d0e46e7e4579d70a794b6a079', '学生04', 101, 10);
INSERT INTO `student` VALUES (1005, '830b929d0e46e7e4579d70a794b6a079', '学生05', 101, -15);
INSERT INTO `student` VALUES (1006, '830b929d0e46e7e4579d70a794b6a079', '学生06', 101, 0);
INSERT INTO `student` VALUES (1007, '830b929d0e46e7e4579d70a794b6a079', '学生07', 101, 0);
INSERT INTO `student` VALUES (1008, '830b929d0e46e7e4579d70a794b6a079', '学生08', 101, 0);
INSERT INTO `student` VALUES (1009, '830b929d0e46e7e4579d70a794b6a079', '张三', 101, 0);
INSERT INTO `student` VALUES (1010, '830b929d0e46e7e4579d70a794b6a079', '李四', 101, 0);
INSERT INTO `student` VALUES (1011, '830b929d0e46e7e4579d70a794b6a079', '王五', 101, 0);
INSERT INTO `student` VALUES (1012, '830b929d0e46e7e4579d70a794b6a079', '赵六', 101, 0);
INSERT INTO `student` VALUES (1013, '830b929d0e46e7e4579d70a794b6a079', '路人甲', 601, 0);
INSERT INTO `student` VALUES (1014, '830b929d0e46e7e4579d70a794b6a079', '路人乙', 601, 0);
INSERT INTO `student` VALUES (1015, '830b929d0e46e7e4579d70a794b6a079', '路人丙', 601, 0);
INSERT INTO `student` VALUES (1016, '830b929d0e46e7e4579d70a794b6a079', '路人丁', 601, 0);

-- ----------------------------
-- Table structure for t_c_relationship
-- ----------------------------
DROP TABLE IF EXISTS `t_c_relationship`;
CREATE TABLE `t_c_relationship`  (
  `t_id` int unsigned NOT NULL,
  `c_id` int unsigned NOT NULL,
  `course_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`t_id`, `c_id`) USING BTREE,
  INDEX `c_id`(`c_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_c_relationship
-- ----------------------------
INSERT INTO `t_c_relationship` VALUES (9101, 101, '语文');
INSERT INTO `t_c_relationship` VALUES (9101, 102, '语文');
INSERT INTO `t_c_relationship` VALUES (9101, 103, '语文');
INSERT INTO `t_c_relationship` VALUES (9102, 601, '数学');
INSERT INTO `t_c_relationship` VALUES (9102, 602, '数学');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `t_id` int unsigned NOT NULL,
  `t_password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `t_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9106 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (9101, '14d710260227756c0d753b735a2aad12', '老师01');
INSERT INTO `teacher` VALUES (9102, '14d710260227756c0d753b735a2aad12', '老师02');

-- ----------------------------
-- Table structure for template
-- ----------------------------
DROP TABLE IF EXISTS `template`;
CREATE TABLE `template`  (
  `t_num` int unsigned NOT NULL,
  `detail` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `score` tinyint(0) NOT NULL,
  PRIMARY KEY (`t_num`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of template
-- ----------------------------
INSERT INTO `template` VALUES (1, '上课认真听讲，能基本完成本科的学习任务', 10);
INSERT INTO `template` VALUES (2, '上课没带书', -5);
INSERT INTO `template` VALUES (3, '玩游戏', -10);
INSERT INTO `template` VALUES (4, '抄笔记', 5);
INSERT INTO `template` VALUES (5, '睡觉', -5);
INSERT INTO `template` VALUES (6, '发呆', -2);
INSERT INTO `template` VALUES (7, '吃东西', -15);
INSERT INTO `template` VALUES (8, '逃课', -20);
INSERT INTO `template` VALUES (9, '迟到', -1);
INSERT INTO `template` VALUES (10, '早退', -1);
INSERT INTO `template` VALUES (11, '按时交作业', 5);
INSERT INTO `template` VALUES (12, '上课积极回答问题', 15);
INSERT INTO `template` VALUES (13, '考试作弊', -100);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `age` int(0) DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `headerimg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, 'abc', 33, '456@456.com', 'bao', '123', NULL);
INSERT INTO `user` VALUES (3, 'lxx', 25, '789@789.com', 'qq', '234', NULL);
INSERT INTO `user` VALUES (4, 'bwj', 20, '852@852.com', 'admin', '666', NULL);

SET FOREIGN_KEY_CHECKS = 1;
