/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : seata-order

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-02-06 14:07:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键Id',
  `user_id` int(20) DEFAULT NULL COMMENT '用户Id',
  `pay_money` decimal(11,0) DEFAULT NULL COMMENT '付款金额',
  `product_id` int(20) DEFAULT NULL COMMENT '商品Id',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `count` int(11) DEFAULT NULL COMMENT '商品数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=291 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC COMMENT='订单表';

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('274', '1', '50', '1', '1', '1');
INSERT INTO `order` VALUES ('277', '1', '50', '1', '0', '1');
INSERT INTO `order` VALUES ('279', '1', '50', '1', '1', '1');
INSERT INTO `order` VALUES ('284', '1', '50', '1', '1', '1');
INSERT INTO `order` VALUES ('285', '1', '50', '1', '1', '1');
INSERT INTO `order` VALUES ('289', '1', '50', '1', '1', '1');
INSERT INTO `order` VALUES ('290', '1', '50', '1', '1', '1');

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of undo_log
-- ----------------------------
