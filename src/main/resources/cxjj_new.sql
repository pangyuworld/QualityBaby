/*
 Navicat MySQL Data Transfer

 Source Server         : 本地连接
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3306
 Source Schema         : cxjj_new

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 14/07/2019 09:24:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_activity
-- ----------------------------
DROP TABLE IF EXISTS `t_activity`;
CREATE TABLE `t_activity`  (
  `activity_id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `activity_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `activity_information` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `activity_img` varchar(2038) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `activity_person_num` int(11) UNSIGNED ZEROFILL NOT NULL,
  `activity_start` datetime NOT NULL,
  `activity_end` datetime NOT NULL,
  `activity_start_sign_up` datetime NOT NULL,
  `activity_end_sign_up` datetime NOT NULL,
  `activity_show` tinyint(1) UNSIGNED ZEROFILL NOT NULL,
  `group_id` int(20) UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`activity_id`) USING BTREE,
  INDEX `activity_group_to_activity`(`group_id`) USING BTREE,
  CONSTRAINT `activity_group_to_activity` FOREIGN KEY (`group_id`) REFERENCES `t_activity_group` (`group_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_activity
-- ----------------------------
INSERT INTO `t_activity` VALUES (3, '活动名', '活动结合少', 'https://pangyuworld.github.io/assets/p4YBAFtjvnOAa7uqAABMXc2dvOk667_n-1557808233634.jpg', 00000000011, '2019-07-05 16:21:35', '2019-07-05 16:21:37', '2019-07-05 16:21:40', '2019-07-05 16:21:42', 0, 1);
INSERT INTO `t_activity` VALUES (4, '活动名1', '活动结合少', 'https://pangyuworld.github.io/assets/p4YBAFtjvnOAa7uqAABMXc2dvOk667_n-1557808233634.jpg', 00000000011, '2019-07-05 16:21:35', '2019-07-05 16:21:37', '2019-07-05 16:21:40', '2019-07-05 16:21:42', 0, 1);
INSERT INTO `t_activity` VALUES (5, '活动名12', '活动结合少', 'https://pangyuworld.github.io/assets/p4YBAFtjvnOAa7uqAABMXc2dvOk667_n-1557808233634.jpg', 00000000012, '2019-07-05 16:21:35', '2019-07-05 16:21:37', '2019-07-05 16:21:40', '2019-07-05 16:21:42', 0, 1);
INSERT INTO `t_activity` VALUES (6, '活动名122', '活动结合少', 'https://pangyuworld.github.io/assets/p4YBAFtjvnOAa7uqAABMXc2dvOk667_n-1557808233634.jpg', 00000000011, '2019-07-05 16:21:35', '2019-07-05 16:21:37', '2019-07-05 16:21:40', '2019-07-05 16:21:42', 0, 1);
INSERT INTO `t_activity` VALUES (7, '活动名1223', '活动结合少', 'https://pangyuworld.github.io/assets/p4YBAFtjvnOAa7uqAABMXc2dvOk667_n-1557808233634.jpg', 00000000011, '2019-07-05 16:21:35', '2019-07-05 16:21:37', '2019-07-05 16:21:40', '2019-07-05 16:21:42', 0, 1);
INSERT INTO `t_activity` VALUES (8, '活动名12234', '活动结合少', 'https://pangyuworld.github.io/assets/p4YBAFtjvnOAa7uqAABMXc2dvOk667_n-1557808233634.jpg', 00000000011, '2019-07-05 16:21:35', '2019-07-05 16:21:37', '2019-07-05 16:21:40', '2019-07-05 16:21:42', 0, 1);
INSERT INTO `t_activity` VALUES (9, '活动名122345', '活动结合少', 'https://pangyuworld.github.io/assets/p4YBAFtjvnOAa7uqAABMXc2dvOk667_n-1557808233634.jpg', 00000000011, '2019-07-05 16:21:35', '2019-07-05 16:21:37', '2019-07-05 16:21:40', '2019-07-05 16:21:42', 0, 1);
INSERT INTO `t_activity` VALUES (10, '活动名1223456', '活动结合少', 'https://pangyuworld.github.io/assets/p4YBAFtjvnOAa7uqAABMXc2dvOk667_n-1557808233634.jpg', 00000000011, '2019-07-05 16:21:35', '2019-07-05 16:21:37', '2019-07-05 16:21:40', '2019-07-05 16:21:42', 1, 1);
INSERT INTO `t_activity` VALUES (11, '活动名12234567', '活动结合少', 'https://pangyuworld.github.io/assets/p4YBAFtjvnOAa7uqAABMXc2dvOk667_n-1557808233634.jpg', 00000000011, '2019-07-05 16:21:35', '2019-07-05 16:21:37', '2019-07-05 16:21:40', '2019-07-05 16:21:42', 1, 1);
INSERT INTO `t_activity` VALUES (12, '活动名122345678', '活动结合少', 'https://pangyuworld.github.io/assets/p4YBAFtjvnOAa7uqAABMXc2dvOk667_n-1557808233634.jpg', 00000000011, '2019-07-05 16:21:35', '2019-07-05 16:21:37', '2019-07-05 16:21:40', '2019-07-05 16:21:42', 1, 1);
INSERT INTO `t_activity` VALUES (13, '活动名1223456781', '活动结合少', 'https://pangyuworld.github.io/assets/p4YBAFtjvnOAa7uqAABMXc2dvOk667_n-1557808233634.jpg', 00000000011, '2019-07-05 16:21:35', '2019-07-05 16:21:37', '2019-07-05 16:21:40', '2019-07-05 16:21:42', 1, 1);
INSERT INTO `t_activity` VALUES (14, '活动名12234567812', '活动结合少', 'https://pangyuworld.github.io/assets/p4YBAFtjvnOAa7uqAABMXc2dvOk667_n-1557808233634.jpg', 00000000011, '2019-07-05 16:21:35', '2019-07-05 16:21:37', '2019-07-05 16:21:40', '2019-07-05 16:21:42', 1, 1);
INSERT INTO `t_activity` VALUES (15, '活动名122345678123', '活动结合少', 'https://pangyuworld.github.io/assets/p4YBAFtjvnOAa7uqAABMXc2dvOk667_n-1557808233634.jpg', 00000000011, '2019-07-05 16:21:35', '2019-07-05 16:21:37', '2019-07-05 16:21:40', '2019-07-05 16:21:42', 1, 1);
INSERT INTO `t_activity` VALUES (16, '活动名1223456781234', '活动结合少', 'https://pangyuworld.github.io/assets/p4YBAFtjvnOAa7uqAABMXc2dvOk667_n-1557808233634.jpg', 00000000011, '2019-07-05 16:21:35', '2019-07-05 16:21:37', '2019-07-05 16:21:40', '2019-07-05 16:21:42', 1, 1);
INSERT INTO `t_activity` VALUES (17, '活动名12234567812345', '活动结合少', 'https://pangyuworld.github.io/assets/p4YBAFtjvnOAa7uqAABMXc2dvOk667_n-1557808233634.jpg', 00000000011, '2019-07-05 16:21:35', '2019-07-05 16:21:37', '2019-07-05 16:21:40', '2019-07-05 16:21:42', 1, 1);

-- ----------------------------
-- Table structure for t_activity_group
-- ----------------------------
DROP TABLE IF EXISTS `t_activity_group`;
CREATE TABLE `t_activity_group`  (
  `group_id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `gourp_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `group_show` tinyint(1) UNSIGNED ZEROFILL NOT NULL,
  `group_icon` varchar(2083) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `group_sort` tinyint(4) UNSIGNED NOT NULL,
  `group_add_time` datetime NOT NULL,
  PRIMARY KEY (`group_id`) USING BTREE,
  UNIQUE INDEX `sort_unique`(`group_sort`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_activity_group
-- ----------------------------
INSERT INTO `t_activity_group` VALUES (1, '修改后的分组名2', 1, 'https://pangyuworld.github.io/assets/tx.jpg', 1, '2019-07-05 16:22:15');
INSERT INTO `t_activity_group` VALUES (2, '修改分组', 1, 'https://cdn.neilren.com/NeilRenV4/img/NeilCat.svg', 2, '2019-07-05 19:39:33');
INSERT INTO `t_activity_group` VALUES (4, 'api创建的分组名', 1, 'https://cdn.neilren.com/NeilRenV4/img/NeilCat.svg', 4, '2019-07-05 19:41:02');
INSERT INTO `t_activity_group` VALUES (5, 'api创建的分组名', 1, 'https://cdn.neilren.com/NeilRenV4/img/NeilCat.svg', 5, '2019-07-05 19:42:20');
INSERT INTO `t_activity_group` VALUES (7, 'api创建的分组名', 1, 'https://cdn.neilren.com/NeilRenV4/img/NeilCat.svg', 6, '2019-07-05 19:46:14');
INSERT INTO `t_activity_group` VALUES (8, 'api创建的分组名', 1, 'https://cdn.neilren.com/NeilRenV4/img/NeilCat.svg', 7, '2019-07-05 19:46:44');
INSERT INTO `t_activity_group` VALUES (9, 'api创建的分组名', 1, 'https://cdn.neilren.com/NeilRenV4/img/NeilCat.svg', 8, '2019-07-05 19:48:34');

-- ----------------------------
-- Table structure for t_activity_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_activity_tag`;
CREATE TABLE `t_activity_tag`  (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `tag_id` int(20) UNSIGNED NOT NULL DEFAULT 0,
  `activity_id` int(20) UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_unique`(`tag_id`) USING BTREE,
  INDEX `ref_activity_tag_to_tag`(`activity_id`) USING BTREE,
  CONSTRAINT `activity_tag_to_tag` FOREIGN KEY (`tag_id`) REFERENCES `t_tag` (`tag_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ref_activity_tag_to_tag` FOREIGN KEY (`activity_id`) REFERENCES `t_activity` (`activity_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_admin_login_log
-- ----------------------------
DROP TABLE IF EXISTS `t_admin_login_log`;
CREATE TABLE `t_admin_login_log`  (
  `id` int(20) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `login_time` datetime NOT NULL,
  `login_ip` int(8) UNSIGNED NOT NULL,
  `admin_id` int(20) UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `login_log_to_admin`(`admin_id`) USING BTREE,
  CONSTRAINT `login_log_to_admin` FOREIGN KEY (`admin_id`) REFERENCES `t_admin_user` (`admin_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_admin_login_log
-- ----------------------------
INSERT INTO `t_admin_login_log` VALUES (00000000000000000001, '2019-07-08 21:18:18', 168880014, 1);

-- ----------------------------
-- Table structure for t_admin_user
-- ----------------------------
DROP TABLE IF EXISTS `t_admin_user`;
CREATE TABLE `t_admin_user`  (
  `admin_id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `admin_real_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_login_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_login_password` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE,
  UNIQUE INDEX `id_unique`(`admin_login_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_admin_user
-- ----------------------------
INSERT INTO `t_admin_user` VALUES (1, '张星宇', 'xiaopang', '9b07c1d2a5f1c1b26763e3b5bcabd70a80bb43357492b59b4447b5d97c1f1f64');

-- ----------------------------
-- Table structure for t_answer
-- ----------------------------
DROP TABLE IF EXISTS `t_answer`;
CREATE TABLE `t_answer`  (
  `answer_id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `answer_rank` tinyint(4) NOT NULL,
  `user_id` int(20) UNSIGNED NOT NULL DEFAULT 0,
  `question_id` int(20) UNSIGNED NOT NULL DEFAULT 0,
  `answer_time` datetime NOT NULL,
  PRIMARY KEY (`answer_id`) USING BTREE,
  UNIQUE INDEX `id_unique`(`user_id`, `question_id`) USING BTREE,
  INDEX `answer_to_question`(`question_id`) USING BTREE,
  CONSTRAINT `answer_to_question` FOREIGN KEY (`question_id`) REFERENCES `t_question` (`question_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `answer_to_user` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_answer
-- ----------------------------
INSERT INTO `t_answer` VALUES (1, 1, 1, 1, '2019-07-11 11:15:26');
INSERT INTO `t_answer` VALUES (2, 2, 1, 3, '2019-07-11 11:15:26');
INSERT INTO `t_answer` VALUES (3, 5, 1, 6, '2019-07-11 11:15:26');
INSERT INTO `t_answer` VALUES (4, 2, 1, 7, '2019-07-11 11:15:26');

-- ----------------------------
-- Table structure for t_aspect
-- ----------------------------
DROP TABLE IF EXISTS `t_aspect`;
CREATE TABLE `t_aspect`  (
  `aspect_id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `aspect_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `aspect_show` tinyint(1) UNSIGNED ZEROFILL NOT NULL,
  PRIMARY KEY (`aspect_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_aspect
-- ----------------------------
INSERT INTO `t_aspect` VALUES (1, '大方向1', 1);
INSERT INTO `t_aspect` VALUES (2, '手动添加大方向', 1);
INSERT INTO `t_aspect` VALUES (3, '手动添加大方向', 1);

-- ----------------------------
-- Table structure for t_aspect_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_aspect_detail`;
CREATE TABLE `t_aspect_detail`  (
  `detail_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `detail_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `detail_show` tinyint(1) UNSIGNED ZEROFILL NOT NULL,
  `aspect_id` int(20) UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`detail_id`) USING BTREE,
  INDEX `aspect_to_aspect_detail`(`aspect_id`) USING BTREE,
  CONSTRAINT `aspect_to_aspect_detail` FOREIGN KEY (`aspect_id`) REFERENCES `t_aspect` (`aspect_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_aspect_detail
-- ----------------------------
INSERT INTO `t_aspect_detail` VALUES (1, '小方向1', 1, 1);
INSERT INTO `t_aspect_detail` VALUES (2, '小方向2', 1, 1);
INSERT INTO `t_aspect_detail` VALUES (3, '手动添加小方向', 1, 2);
INSERT INTO `t_aspect_detail` VALUES (4, '手动添加小方向', 1, 3);

-- ----------------------------
-- Table structure for t_aspect_detial_question
-- ----------------------------
DROP TABLE IF EXISTS `t_aspect_detial_question`;
CREATE TABLE `t_aspect_detial_question`  (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `is_well` tinyint(1) UNSIGNED ZEROFILL NOT NULL,
  `detail_id` int(11) UNSIGNED NOT NULL DEFAULT 0,
  `question_id` int(20) UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `aspect_detial_question_to_aspect_detail`(`detail_id`) USING BTREE,
  INDEX `aspect_detial_question_to_question`(`question_id`) USING BTREE,
  CONSTRAINT `aspect_detial_question_to_aspect_detail` FOREIGN KEY (`detail_id`) REFERENCES `t_aspect_detail` (`detail_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `aspect_detial_question_to_question` FOREIGN KEY (`question_id`) REFERENCES `t_question` (`question_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_aspect_detial_question
-- ----------------------------
INSERT INTO `t_aspect_detial_question` VALUES (1, 0, 1, 1);
INSERT INTO `t_aspect_detial_question` VALUES (2, 1, 2, 1);
INSERT INTO `t_aspect_detial_question` VALUES (3, 1, 1, 3);
INSERT INTO `t_aspect_detial_question` VALUES (5, 1, 1, 14);

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message`  (
  `message_id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `message_time` datetime NOT NULL,
  `message_detail` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `message_like` int(11) UNSIGNED ZEROFILL NOT NULL,
  `message_show` tinyint(1) UNSIGNED ZEROFILL NOT NULL,
  `user_id` int(20) UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`message_id`) USING BTREE,
  INDEX `message_to_user`(`user_id`) USING BTREE,
  CONSTRAINT `message_to_user` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_question
-- ----------------------------
DROP TABLE IF EXISTS `t_question`;
CREATE TABLE `t_question`  (
  `question_id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `question_detail` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `question_add_time` datetime NOT NULL,
  `question_update_time` datetime NOT NULL,
  `question_sort` int(10) NOT NULL,
  PRIMARY KEY (`question_id`) USING BTREE,
  UNIQUE INDEX `sort_unique`(`question_sort`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_question
-- ----------------------------
INSERT INTO `t_question` VALUES (1, '修改后的描述', '2019-07-09 10:19:36', '2019-07-11 09:27:20', 1);
INSERT INTO `t_question` VALUES (3, '问题描述1', '2019-07-09 10:19:36', '2019-07-09 10:19:41', 2);
INSERT INTO `t_question` VALUES (6, 'aaaa', '2019-07-10 10:20:03', '2019-07-10 10:20:03', 4);
INSERT INTO `t_question` VALUES (7, 'aaaa', '2019-07-10 10:22:19', '2019-07-10 10:22:19', 5);
INSERT INTO `t_question` VALUES (8, 'aaaa', '2019-07-10 10:23:41', '2019-07-10 10:23:41', 6);
INSERT INTO `t_question` VALUES (9, 'aaaa', '2019-07-10 10:25:59', '2019-07-10 10:25:59', 7);
INSERT INTO `t_question` VALUES (10, 'asdasda', '2019-02-02 11:11:11', '2019-02-02 11:11:11', 8);
INSERT INTO `t_question` VALUES (11, 'asdasda', '2019-02-02 11:11:11', '2019-02-02 11:11:11', 9);
INSERT INTO `t_question` VALUES (12, 'asdasda', '2019-02-02 11:11:11', '2019-02-02 11:11:11', 10);
INSERT INTO `t_question` VALUES (14, 'asdasda', '2019-02-02 11:11:11', '2019-02-02 11:11:11', 11);

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag`  (
  `tag_id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tag_show` tinyint(1) UNSIGNED ZEROFILL NOT NULL,
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO `t_tag` VALUES (1, '标签1', 1);
INSERT INTO `t_tag` VALUES (2, '标签2', 1);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `stu_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `open_id` binary(28) NOT NULL,
  `tell_num` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `class_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` tinyint(1) UNSIGNED ZEROFILL NOT NULL,
  `stu_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sign_up_time` datetime NOT NULL,
  `user_icon` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `stu_unique`(`stu_id`) USING BTREE,
  UNIQUE INDEX `open_id_unique`(`open_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '5120170586', 0x30783646354134353530364433353533373734333332353335463534, '15681910683', '物联1704', 1, '张星宇', '2019-07-05 16:21:35', 'https://cdn.neilren.com/NeilRenV4/img/NeilCat.svg');

-- ----------------------------
-- Table structure for t_user_activity
-- ----------------------------
DROP TABLE IF EXISTS `t_user_activity`;
CREATE TABLE `t_user_activity`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `join_time` datetime NOT NULL,
  `user_id` int(20) UNSIGNED NOT NULL DEFAULT 0,
  `activity_id` int(20) UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_unique`(`user_id`, `activity_id`) USING BTREE,
  INDEX `user_activity_to_activity`(`activity_id`) USING BTREE,
  CONSTRAINT `user_activity_to_activity` FOREIGN KEY (`activity_id`) REFERENCES `t_activity` (`activity_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_activity_to_user` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user_activity
-- ----------------------------
INSERT INTO `t_user_activity` VALUES (4, '2019-07-06 10:55:54', 1, 5);

-- ----------------------------
-- Table structure for t_user_aspect_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_user_aspect_detail`;
CREATE TABLE `t_user_aspect_detail`  (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `detail_score` int(11) NOT NULL,
  `user_id` int(20) UNSIGNED NOT NULL DEFAULT 0,
  `detail_id` int(11) UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_unique`(`user_id`, `detail_id`) USING BTREE,
  INDEX `user_aspect_detail_to_aspect_detail`(`detail_id`) USING BTREE,
  CONSTRAINT `user_aspect_detail_to_aspect_detail` FOREIGN KEY (`detail_id`) REFERENCES `t_aspect_detail` (`detail_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_aspect_detail_to_user` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user_aspect_detail
-- ----------------------------
INSERT INTO `t_user_aspect_detail` VALUES (9, 1, 1, 1);
INSERT INTO `t_user_aspect_detail` VALUES (10, 1, 1, 2);
INSERT INTO `t_user_aspect_detail` VALUES (11, 2, 1, 4);
INSERT INTO `t_user_aspect_detail` VALUES (13, 5, 1, 3);

-- ----------------------------
-- Table structure for t_user_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_user_tag`;
CREATE TABLE `t_user_tag`  (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(20) UNSIGNED NOT NULL DEFAULT 0,
  `tag_id` int(20) UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_unique`(`user_id`, `tag_id`) USING BTREE,
  INDEX `user_tag_to_tag`(`tag_id`) USING BTREE,
  CONSTRAINT `user_tag_to_tag` FOREIGN KEY (`tag_id`) REFERENCES `t_tag` (`tag_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_tag_to_user` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
