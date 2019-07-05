-- =============================================================================
-- Diagram Name: 2019-6-16
-- Created on: 2019/7/5 15:30:17
-- Diagram Version: 
-- =============================================================================
SET FOREIGN_KEY_CHECKS=0;

-- Drop table t_question
DROP TABLE IF EXISTS `t_question`;

CREATE TABLE `t_question` (
  `question_id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `question_detail` varchar(200) NOT NULL,
  PRIMARY KEY(`question_id`)
)
ENGINE=INNODB;

-- Drop table t_activity_group
DROP TABLE IF EXISTS `t_activity_group`;

CREATE TABLE `t_activity_group` (
  `group_id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `gourp_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `group_show` tinyint(1) UNSIGNED ZEROFILL NOT NULL,
  `group_icon` varchar(2083) NOT NULL,
  `group_sort` tinyint(4) UNSIGNED NOT NULL,
  `group_add_time` datetime NOT NULL,
  PRIMARY KEY(`group_id`),
  UNIQUE INDEX `sort_unique`(`group_sort`)
)
ENGINE=INNODB;

-- Drop table t_admin_user
DROP TABLE IF EXISTS `t_admin_user`;

CREATE TABLE `t_admin_user` (
  `admin_id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `admin_real_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_login_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_login_password` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY(`admin_id`),
  UNIQUE INDEX `id_unique`(`admin_login_name`)
)
ENGINE=INNODB;

-- Drop table t_user
DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `user_id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `stu_id` varchar(10) NOT NULL,
  `open_id` binary(28) NOT NULL,
  `tell_num` varchar(11) NOT NULL,
  `class_name` varchar(50) NOT NULL,
  `gender` tinyint(1) ZEROFILL NOT NULL,
  `stu_name` varchar(25) NOT NULL,
  `sign_up_time` datetime NOT NULL,
  PRIMARY KEY(`user_id`),
  UNIQUE INDEX `stu_unique`(`stu_id`),
  UNIQUE INDEX `open_id_unique`(`open_id`)
)
ENGINE=INNODB;

-- Drop table t_aspect
DROP TABLE IF EXISTS `t_aspect`;

CREATE TABLE `t_aspect` (
  `aspect_id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `aspect_name` varchar(50) NOT NULL,
  `aspect_show` tinyint(1) UNSIGNED ZEROFILL NOT NULL,
  PRIMARY KEY(`aspect_id`)
)
ENGINE=INNODB;

-- Drop table t_tag
DROP TABLE IF EXISTS `t_tag`;

CREATE TABLE `t_tag` (
  `tag_id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(50) NOT NULL,
  `tag_show` tinyint(1) UNSIGNED ZEROFILL NOT NULL,
  PRIMARY KEY(`tag_id`)
)
ENGINE=INNODB;

-- Drop table t_activity
DROP TABLE IF EXISTS `t_activity`;

CREATE TABLE `t_activity` (
  `activity_id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `activity_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `activity_information` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `activity_img` varchar(2038) NOT NULL,
  `activity_person_num` int(11) UNSIGNED ZEROFILL NOT NULL,
  `activity_start` datetime NOT NULL,
  `activity_end` datetime NOT NULL,
  `activity_start_sign_up` datetime NOT NULL,
  `activity_end_sign_up` datetime NOT NULL,
  `activity_show` tinyint(1) UNSIGNED ZEROFILL NOT NULL,
  `group_id` int(20) UNSIGNED NOT NULL DEFAULT '0',
  PRIMARY KEY(`activity_id`),
  CONSTRAINT `activity_group_to_activity` FOREIGN KEY (`group_id`)
    REFERENCES `t_activity_group`(`group_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE=INNODB;

-- Drop table t_admin_login_log
DROP TABLE IF EXISTS `t_admin_login_log`;

CREATE TABLE `t_admin_login_log` (
  `id` int(20) ZEROFILL NOT NULL AUTO_INCREMENT,
  `login_time` datetime NOT NULL,
  `login_ip` int(8) UNSIGNED NOT NULL,
  `admin_id` int(20) UNSIGNED NOT NULL DEFAULT '0',
  PRIMARY KEY(`id`),
  CONSTRAINT `login_log_to_admin` FOREIGN KEY (`admin_id`)
    REFERENCES `t_admin_user`(`admin_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE=INNODB;

-- Drop table t_aspect_detail
DROP TABLE IF EXISTS `t_aspect_detail`;

CREATE TABLE `t_aspect_detail` (
  `detail_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `detail_name` varchar(50) NOT NULL,
  `detail_show` tinyint(1) UNSIGNED ZEROFILL NOT NULL,
  `aspect_id` int(20) UNSIGNED NOT NULL DEFAULT '0',
  PRIMARY KEY(`detail_id`),
  CONSTRAINT `aspect_to_aspect_detail` FOREIGN KEY (`aspect_id`)
    REFERENCES `t_aspect`(`aspect_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE=INNODB;

-- Drop table t_message
DROP TABLE IF EXISTS `t_message`;

CREATE TABLE `t_message` (
  `message_id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `message_time` datetime NOT NULL,
  `message_detail` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `message_like` int(11) UNSIGNED ZEROFILL NOT NULL,
  `message_show` tinyint(1) UNSIGNED ZEROFILL NOT NULL,
  `user_id` int(20) UNSIGNED NOT NULL DEFAULT '0',
  PRIMARY KEY(`message_id`),
  CONSTRAINT `message_to_user` FOREIGN KEY (`user_id`)
    REFERENCES `t_user`(`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE=INNODB;

-- Drop table t_activity_tag
DROP TABLE IF EXISTS `t_activity_tag`;

CREATE TABLE `t_activity_tag` (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `tag_id` int(20) UNSIGNED NOT NULL DEFAULT '0',
  `activity_id_FK` int(20) UNSIGNED NOT NULL DEFAULT '0',
  PRIMARY KEY(`id`),
  UNIQUE INDEX `id_unique`(`tag_id`),
  CONSTRAINT `ref_activity_tag_to_tag` FOREIGN KEY (`activity_id_FK`)
    REFERENCES `t_activity`(`activity_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `activity_tag_to_tag` FOREIGN KEY (`tag_id`)
    REFERENCES `t_tag`(`tag_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE=INNODB;

-- Drop table t_user_aspect_detail
DROP TABLE IF EXISTS `t_user_aspect_detail`;

CREATE TABLE `t_user_aspect_detail` (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `detail_score` int(11) NOT NULL,
  `user_id` int(20) UNSIGNED NOT NULL DEFAULT '0',
  `detail_id` int(11) UNSIGNED NOT NULL DEFAULT '0',
  PRIMARY KEY(`id`),
  UNIQUE INDEX `id_unique`(`user_id`, `detail_id`),
  CONSTRAINT `user_aspect_detail_to_user` FOREIGN KEY (`user_id`)
    REFERENCES `t_user`(`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_aspect_detail_to_aspect_detail` FOREIGN KEY (`detail_id`)
    REFERENCES `t_aspect_detail`(`detail_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE=INNODB;

-- Drop table t_answer
DROP TABLE IF EXISTS `t_answer`;

CREATE TABLE `t_answer` (
  `answer_id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `answer_rank` tinyint(4) NOT NULL,
  `user_id` int(20) UNSIGNED NOT NULL DEFAULT '0',
  `question_id` int(20) UNSIGNED NOT NULL DEFAULT '0',
  PRIMARY KEY(`answer_id`),
  UNIQUE INDEX `id_unique`(`user_id`, `question_id`),
  CONSTRAINT `answer_to_user` FOREIGN KEY (`user_id`)
    REFERENCES `t_user`(`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `answer_to_question` FOREIGN KEY (`question_id`)
    REFERENCES `t_question`(`question_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE=INNODB;

-- Drop table t_user_tag
DROP TABLE IF EXISTS `t_user_tag`;

CREATE TABLE `t_user_tag` (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(20) UNSIGNED NOT NULL DEFAULT '0',
  `tag_id` int(20) UNSIGNED NOT NULL DEFAULT '0',
  PRIMARY KEY(`id`),
  UNIQUE INDEX `id_unique`(`user_id`, `tag_id`),
  CONSTRAINT `user_tag_to_user` FOREIGN KEY (`user_id`)
    REFERENCES `t_user`(`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_tag_to_tag` FOREIGN KEY (`tag_id`)
    REFERENCES `t_tag`(`tag_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE=INNODB;

-- Drop table t_user_activity
DROP TABLE IF EXISTS `t_user_activity`;

CREATE TABLE `t_user_activity` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `join_time` datetime NOT NULL,
  `user_id` int(20) UNSIGNED NOT NULL DEFAULT '0',
  `activity_id` int(20) UNSIGNED NOT NULL DEFAULT '0',
  PRIMARY KEY(`id`),
  UNIQUE INDEX `id_unique`(`user_id`, `activity_id`),
  CONSTRAINT `user_activity_to_user` FOREIGN KEY (`user_id`)
    REFERENCES `t_user`(`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_activity_to_activity` FOREIGN KEY (`activity_id`)
    REFERENCES `t_activity`(`activity_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE=INNODB;

-- Drop table t_aspect_detial_question
DROP TABLE IF EXISTS `t_aspect_detial_question`;

CREATE TABLE `t_aspect_detial_question` (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `is_well` tinyint(1) UNSIGNED ZEROFILL NOT NULL,
  `detail_id` int(11) UNSIGNED NOT NULL DEFAULT '0',
  `question_id` int(20) UNSIGNED NOT NULL DEFAULT '0',
  PRIMARY KEY(`id`),
  CONSTRAINT `aspect_detial_question_to_aspect_detail` FOREIGN KEY (`detail_id`)
    REFERENCES `t_aspect_detail`(`detail_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `aspect_detial_question_to_question` FOREIGN KEY (`question_id`)
    REFERENCES `t_question`(`question_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE=INNODB;

SET FOREIGN_KEY_CHECKS=1;
