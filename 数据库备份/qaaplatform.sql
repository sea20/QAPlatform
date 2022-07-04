/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : 47.108.190.196:3306
 Source Schema         : qaaplatform

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 28/03/2022 10:43:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for care
-- ----------------------------
DROP TABLE IF EXISTS `care`;
CREATE TABLE `care`  (
  `u_id` int(0) NOT NULL COMMENT '关注者id',
  `ud_id` int(0) NOT NULL COMMENT '被关注者id',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`u_id`, `ud_id`) USING BTREE,
  INDEX `ud_id`(`ud_id`) USING BTREE,
  CONSTRAINT `care_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `care_ibfk_2` FOREIGN KEY (`ud_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `u_id` int(0) NOT NULL COMMENT '属于哪个用户',
  `q_id` int(0) NOT NULL COMMENT '收藏的帖子id',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '收藏时间',
  `state` int(0) NOT NULL DEFAULT 1 COMMENT '收藏状态（1：正常 2：删除）默认为1',
  PRIMARY KEY (`u_id`, `q_id`) USING BTREE,
  INDEX `q_id`(`q_id`) USING BTREE,
  CONSTRAINT `collection_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `collection_ibfk_2` FOREIGN KEY (`q_id`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for comment_lv1
-- ----------------------------
DROP TABLE IF EXISTS `comment_lv1`;
CREATE TABLE `comment_lv1`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '一级评论主键id',
  `q_id` int(0) NOT NULL COMMENT '帖子的id',
  `u_id` int(0) NOT NULL COMMENT '回复人的id',
  `comment` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论内容',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '评论时间',
  `comment_num` int(0) NOT NULL DEFAULT 0 COMMENT '该一级评论的二级评论数量 默认0',
  `like_num` int(0) NOT NULL DEFAULT 0 COMMENT '点赞数 默认0',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `q_id`(`q_id`) USING BTREE,
  INDEX `u_id`(`u_id`) USING BTREE,
  CONSTRAINT `comment_lv1_ibfk_1` FOREIGN KEY (`q_id`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_lv1_ibfk_2` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for comment_lv2
-- ----------------------------
DROP TABLE IF EXISTS `comment_lv2`;
CREATE TABLE `comment_lv2`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '二级评论主键id',
  `c1_id` int(0) NOT NULL COMMENT '该二级评论属于的一级评论id',
  `u_id` int(0) NOT NULL COMMENT '评论者的id',
  `comment` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论内容',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '评论时间',
  `ud_id` int(0) NOT NULL COMMENT '被评论者的id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `c1_id`(`c1_id`) USING BTREE,
  INDEX `u_id`(`u_id`) USING BTREE,
  INDEX `ud_id`(`ud_id`) USING BTREE,
  CONSTRAINT `comment_lv2_ibfk_1` FOREIGN KEY (`c1_id`) REFERENCES `comment_lv1` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_lv2_ibfk_2` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_lv2_ibfk_3` FOREIGN KEY (`ud_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for head_picture
-- ----------------------------
DROP TABLE IF EXISTS `head_picture`;
CREATE TABLE `head_picture`  (
  `u_id` int(0) NOT NULL COMMENT '头像表主键，同时也是引用user表id的外键',
  `p_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像文件的文件名',
  PRIMARY KEY (`u_id`) USING BTREE,
  CONSTRAINT `uid_FK` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for little_question
-- ----------------------------
DROP TABLE IF EXISTS `little_question`;
CREATE TABLE `little_question`  (
  `q_id` int(0) NOT NULL,
  `content` int(0) NULL DEFAULT NULL COMMENT '帖子内容',
  PRIMARY KEY (`q_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for post_tag
-- ----------------------------
DROP TABLE IF EXISTS `post_tag`;
CREATE TABLE `post_tag`  (
  `q_id` int(0) NOT NULL COMMENT '帖子ID',
  `tag_id` int(0) NOT NULL COMMENT '标签ID'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '帖子表id',
  `title` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `state` tinyint(0) NOT NULL DEFAULT 1 COMMENT '帖子状态（1：正常 2：删除）默认为1',
  `like_num` int(0) NOT NULL DEFAULT 0 COMMENT '点赞数 默认0',
  `comment_num` int(0) NOT NULL DEFAULT 0 COMMENT '评论数 默认0',
  `scan` int(0) NULL DEFAULT 0 COMMENT '浏览量 默认0',
  `u_id` int(0) NOT NULL COMMENT '该帖子属于的用户id',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建的时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`u_id`) USING BTREE,
  CONSTRAINT `question_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tags
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags`  (
  `id` int(0) NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'tag名字',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户表主键',
  `username` varchar(26) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户登录名',
  `password` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户登录密码',
  `pet_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `pet_name_Unique`(`pet_name`) USING BTREE COMMENT '昵称唯一约束',
  UNIQUE INDEX `username_Unique`(`username`) USING BTREE COMMENT '登录名唯一约束',
  INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
