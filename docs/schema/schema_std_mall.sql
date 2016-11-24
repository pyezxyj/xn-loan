/*
 Navicat MySQL Data Transfer

 Source Server         : 148
 Source Server Version : 50545
 Source Host           : 121.43.101.148
 Source Database       : std_mall

 Target Server Version : 50545
 File Encoding         : utf-8

 Date: 11/18/2016 13:16:55 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `tmall_cart`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_cart`;
CREATE TABLE `tmall_cart` (
  `code` varchar(32) NOT NULL COMMENT '购物车编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `product_code` varchar(32) DEFAULT NULL COMMENT '产品编号',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tmall_category`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_category`;
CREATE TABLE `tmall_category` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `parent_code` varchar(32) DEFAULT NULL COMMENT '父节点',
  `type` varchar(4) DEFAULT NULL COMMENT '类型',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `order_no` int(11) DEFAULT NULL COMMENT '序号',
  `belong` varchar(32) DEFAULT NULL COMMENT '属于谁',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tmall_order`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_order`;
CREATE TABLE `tmall_order` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `type` varchar(4) DEFAULT NULL COMMENT '类型(散买，批发)',
  `receiver` varchar(255) DEFAULT NULL COMMENT '收件人姓名',
  `re_mobile` varchar(32) DEFAULT NULL COMMENT '收件人电话',
  `re_address` varchar(255) DEFAULT NULL COMMENT '收货地址',
  `receipt_type` varchar(4) DEFAULT NULL COMMENT '发票类型(1 个人，2 企业)',
  `receipt_title` varchar(32) DEFAULT NULL COMMENT '发票抬头',
  `apply_user` varchar(32) DEFAULT NULL COMMENT '下单人',
  `apply_note` varchar(255) DEFAULT NULL COMMENT '下单备注',
  `apply_datetime` datetime DEFAULT NULL COMMENT '下单时间',
  `amount` bigint(20) DEFAULT NULL COMMENT '订单金额',
  `yunfei` bigint(20) DEFAULT NULL COMMENT '运费',
  `pay_amount` bigint(20) DEFAULT NULL COMMENT '实际支付金额',
  `pay_datetime` datetime DEFAULT NULL COMMENT '实际支付时间',
  `prompt_times` int(11) DEFAULT NULL COMMENT '催货次数',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `logistics_code` varchar(32) DEFAULT NULL COMMENT '物流单号',
  `logistics_company` varchar(32) DEFAULT NULL COMMENT '物流公司编号',
  `deliverer` varchar(32) DEFAULT NULL COMMENT '发货人编号',
  `delivery_datetime` datetime DEFAULT NULL COMMENT '发货时间',
  `pdf` varchar(255) DEFAULT NULL COMMENT '物流单',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tmall_product`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_product`;
CREATE TABLE `tmall_product` (
  `code` varchar(32) NOT NULL COMMENT '产品编号',
  `category` varchar(32) DEFAULT NULL COMMENT '大类',
  `type` varchar(32) DEFAULT NULL COMMENT '小类',
  `name` varchar(255) DEFAULT NULL COMMENT '产品名称',
  `adv_title` varchar(255) DEFAULT NULL COMMENT '广告语',
  `adv_pic` varchar(255) DEFAULT NULL COMMENT '广告图',
  `pic1` varchar(255) DEFAULT NULL COMMENT 'pic1',
  `pic2` varchar(255) DEFAULT NULL COMMENT 'pic2',
  `pic3` varchar(255) DEFAULT NULL COMMENT 'pic3',
  `pic4` varchar(255) DEFAULT NULL COMMENT 'pic4',
  `description` text COMMENT '图文描述',
  `cost_price` bigint(20) DEFAULT NULL COMMENT '进货价',
  `quantity` int(11) DEFAULT NULL COMMENT '库存量',
  `status` varchar(4) DEFAULT NULL COMMENT '产品状态(上架，下架)',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `original_price` bigint(20) DEFAULT NULL COMMENT '原价',
  `discount_price` bigint(20) DEFAULT NULL COMMENT '折扣价',
  `location` varchar(32) DEFAULT NULL COMMENT '位置(0 普通 1 热门)',
  `order_no` int(11) DEFAULT NULL COMMENT '相对位置编号',
  `company_code` varchar(32) DEFAULT NULL COMMENT '所属公司',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tmall_product_order`
-- ----------------------------
DROP TABLE IF EXISTS `tmall_product_order`;
CREATE TABLE `tmall_product_order` (
  `code` varchar(32) NOT NULL,
  `order_code` varchar(32) DEFAULT NULL COMMENT '发货单号',
  `product_code` varchar(32) DEFAULT NULL COMMENT '产品编号',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `sale_price` bigint(20) DEFAULT NULL COMMENT '零售价',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tsys_config`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_config`;
CREATE TABLE `tsys_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `cname` varchar(255) DEFAULT NULL COMMENT '配置名',
  `ckey` varchar(32) DEFAULT NULL COMMENT 'key值',
  `cvalue` varchar(255) DEFAULT NULL COMMENT '值',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `belong` int(11) DEFAULT NULL COMMENT '属于谁',
  `company_code` varchar(32) DEFAULT NULL COMMENT '公司编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tsys_dict`
-- ----------------------------
DROP TABLE IF EXISTS `tsys_dict`;
CREATE TABLE `tsys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号（自增长）',
  `type` char(1) DEFAULT NULL COMMENT '类型（第一层/第二层）',
  `parent_key` varchar(32) DEFAULT NULL COMMENT '父key',
  `dkey` varchar(32) DEFAULT NULL COMMENT 'key',
  `dvalue` varchar(255) DEFAULT NULL COMMENT '值',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
