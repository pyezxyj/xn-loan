/*
SQLyog Ultimate v11.24 (64 bit)
MySQL - 5.5.45-log : Database - xn_loan
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xn_loan` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `xn_loan`;

/*Table structure for table `tloan_area` */

CREATE TABLE `tloan_area` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `county` varchar(32) DEFAULT NULL COMMENT '县市名称',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `updater_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tloan_bank_card` */

CREATE TABLE `tloan_bank_card` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `car_store_code` varchar(32) DEFAULT NULL COMMENT '所属车行',
  `bank` varchar(32) DEFAULT NULL COMMENT '银行',
  `branch` varchar(32) DEFAULT NULL COMMENT '开户行',
  `account_name` varchar(32) DEFAULT NULL COMMENT '户名',
  `account` varchar(32) DEFAULT NULL COMMENT '账号',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `remark` varchar(32) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tloan_car` */

CREATE TABLE `tloan_car` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `credit_order_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `real_name` varchar(32) DEFAULT NULL COMMENT '车主',
  `brand` varchar(32) DEFAULT NULL COMMENT '车辆品牌',
  `model` varchar(32) DEFAULT NULL COMMENT '车辆类型',
  `area` varchar(32) DEFAULT NULL COMMENT '上牌地',
  `price` bigint(20) DEFAULT NULL COMMENT '车价',
  `first_amount` bigint(20) DEFAULT NULL COMMENT '首付',
  `license_no` varchar(32) DEFAULT NULL COMMENT '车牌号码',
  `chassis_no` varchar(32) DEFAULT NULL COMMENT '车架号',
  `engine_no` varchar(32) DEFAULT NULL COMMENT '发动机号',
  `seat_num` varchar(32) DEFAULT NULL COMMENT '车座位数',
  `invoice` varchar(255) DEFAULT NULL COMMENT '发票',
  `policy` varchar(255) DEFAULT NULL COMMENT '保单',
  `certification` varchar(255) DEFAULT NULL COMMENT '合格证',
  `invoice_no` varchar(32) DEFAULT NULL COMMENT '发票号码',
  `buy_datetime` date DEFAULT NULL COMMENT '购车日期',
  `buy_tax` bigint(20) DEFAULT NULL COMMENT '购置税金额',
  `gps_vendor` varchar(32) DEFAULT NULL COMMENT 'GPS厂商',
  `gps_no` varchar(32) DEFAULT NULL COMMENT 'GPS编号',
  `dy_start_datetime` date DEFAULT NULL COMMENT '抵押时间',
  `dy_end_datetime` date DEFAULT NULL COMMENT '抵押到期时间',
  `agent` varchar(32) DEFAULT NULL COMMENT '经办人',
  `tax_pdf` varchar(255) DEFAULT NULL COMMENT '完税材料',
  `guaranty_pdf` varchar(255) DEFAULT NULL COMMENT '抵押登记证',
  `regist_pdf` varchar(255) DEFAULT NULL COMMENT '车辆登记证',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `loan_settle_datetime` date DEFAULT NULL COMMENT '贷款结清日期',
  `property_out_datetime` date DEFAULT NULL COMMENT '产权取出日期',
  `approver` varchar(32) DEFAULT NULL COMMENT '审核人',
  `approve_datetime` datetime DEFAULT NULL COMMENT '审核时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tloan_car_store_detail` */

CREATE TABLE `tloan_car_store_detail` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `benelux` varchar(32) DEFAULT NULL COMMENT '全称',
  `abbreviation` varchar(32) DEFAULT NULL COMMENT '简称',
  `corporation` varchar(32) DEFAULT NULL COMMENT '法人',
  `province` varchar(32) DEFAULT NULL COMMENT '省',
  `city` varchar(32) DEFAULT NULL COMMENT '市',
  `area` varchar(32) DEFAULT NULL COMMENT '区',
  `address` varchar(32) DEFAULT NULL COMMENT '详细地址',
  `name` varchar(32) DEFAULT NULL COMMENT '联系人',
  `contacts` varchar(32) DEFAULT NULL COMMENT '联系方式',
  `district` varchar(32) DEFAULT NULL COMMENT '所属地区',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `updater` varchar(32) DEFAULT NULL COMMENT '操作人',
  `update_datetime` datetime DEFAULT NULL COMMENT '操作时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tloan_credit_order` */

CREATE TABLE `tloan_credit_order` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `province` varchar(32) DEFAULT NULL COMMENT '省份',
  `city` varchar(32) DEFAULT NULL COMMENT '城市',
  `area` varchar(32) DEFAULT NULL COMMENT '地区',
  `salesman` varchar(32) DEFAULT NULL COMMENT '业务员',
  `car_store` varchar(32) DEFAULT NULL COMMENT '车行',
  `jb_bank` varchar(32) DEFAULT NULL COMMENT '经办银行',
  `loan_type` varchar(32) DEFAULT NULL COMMENT '贷款品种',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款金额',
  `loan_term` varchar(32) DEFAULT NULL COMMENT '贷款期限',
  `real_name` varchar(32) DEFAULT NULL COMMENT '贷款人',
  `id_kind` varchar(32) DEFAULT NULL COMMENT '证件类型',
  `id_no` varchar(32) DEFAULT NULL COMMENT '证件号',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `dc_user` varchar(32) DEFAULT NULL COMMENT '调查员',
  `sign_pic` varchar(255) DEFAULT NULL COMMENT '签名照',
  `home_pic` varchar(255) DEFAULT NULL COMMENT '家访照',
  `id_info` varchar(255) DEFAULT NULL COMMENT '身份资料',
  `video` varchar(255) DEFAULT NULL COMMENT '视频',
  `dc_report` varchar(255) DEFAULT NULL COMMENT '调查报告',
  `dc_data` varchar(255) DEFAULT NULL COMMENT '其他调查补充资料',
  `address` varchar(255) DEFAULT NULL COMMENT '家庭地址',
  `rate` bigint(32) DEFAULT NULL COMMENT '综合费率',
  `fee` varchar(32) DEFAULT NULL COMMENT '服务费',
  `urgent` varchar(4) DEFAULT NULL COMMENT '紧急度',
  `bank` varchar(64) DEFAULT NULL COMMENT '代扣卡开户行',
  `branch` varchar(32) DEFAULT NULL COMMENT '支行',
  `bankcard_no` varchar(32) DEFAULT NULL COMMENT '代扣卡号码',
  `last_node` varchar(32) DEFAULT NULL COMMENT '最新节点',
  `fk_pdf` varchar(255) DEFAULT NULL COMMENT '放款其他资料',
  `qk_pdf` varchar(255) DEFAULT NULL COMMENT '请款附件',
  `dk_pdf` varchar(255) DEFAULT NULL COMMENT '打款水单',
  `sk_pdf` varchar(255) DEFAULT NULL COMMENT '收款水单',
  `sk_amount` bigint(20) DEFAULT NULL COMMENT '收款金额',
  `sk_datetime` datetime DEFAULT NULL COMMENT '收款时间',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `create_datetime` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `access_level` varchar(4) DEFAULT NULL COMMENT '权限等级',
  `consume` varchar(32) DEFAULT NULL COMMENT '耗时',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tloan_credit_people` */

CREATE TABLE `tloan_credit_people` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `credit_order_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `loan_type` varchar(32) DEFAULT NULL COMMENT '贷款类型',
  `loan_amount` bigint(20) DEFAULT NULL COMMENT '贷款金额',
  `real_name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `relation` varchar(32) DEFAULT NULL COMMENT '关系',
  `id_kind` varchar(32) DEFAULT NULL COMMENT '证件类型',
  `id_no` varchar(32) DEFAULT NULL COMMENT '证件号',
  `accredit_pdf` varchar(255) DEFAULT NULL COMMENT '授权书',
  `credit_result` varchar(4) DEFAULT NULL COMMENT '资信结果',
  `credit_descript` varchar(255) DEFAULT NULL COMMENT '资信描述',
  `court_result` varchar(4) DEFAULT NULL COMMENT '法院结果',
  `court_descript` varchar(255) DEFAULT NULL COMMENT '法院描述',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `work_unit` varchar(32) DEFAULT NULL COMMENT '工作单位',
  `work_phone` varchar(32) DEFAULT NULL COMMENT '单位电话',
  `address` varchar(64) DEFAULT NULL COMMENT '单位地址',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tloan_express` */

CREATE TABLE `tloan_express` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `credit_order_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `type` varchar(4) DEFAULT NULL COMMENT '移交事项',
  `type_note` varchar(255) DEFAULT NULL COMMENT '移交说明',
  `deliver_company` varchar(32) DEFAULT NULL COMMENT '发件公司',
  `deliverer` varchar(32) DEFAULT NULL COMMENT '发件人',
  `deliver_datetime` date DEFAULT NULL COMMENT '发件时间',
  `receive_company` varchar(32) DEFAULT NULL COMMENT '收件公司',
  `receiver` varchar(32) DEFAULT NULL COMMENT '发件人',
  `receive_datetime` datetime DEFAULT NULL COMMENT '发件时间',
  `logi_company` varchar(32) DEFAULT NULL COMMENT '快递公司',
  `logi_code` varchar(32) DEFAULT NULL COMMENT '快递单号',
  `deliver_pdf` varchar(255) DEFAULT NULL COMMENT '快递单',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `check_user` varchar(32) DEFAULT NULL COMMENT '复核人',
  `check_datetime` datetime DEFAULT NULL COMMENT '复核时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tloan_insure` */

CREATE TABLE `tloan_insure` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `real_name` varchar(32) DEFAULT NULL COMMENT '车主',
  `car_code` varchar(32) DEFAULT NULL COMMENT '汽车编号',
  `company` varchar(32) DEFAULT NULL COMMENT '保险公司',
  `type` varchar(32) DEFAULT NULL COMMENT '保险类型',
  `order_no` varchar(32) DEFAULT NULL COMMENT '保险单号',
  `amount` bigint(20) DEFAULT NULL COMMENT '保费',
  `start_datetime` date DEFAULT NULL COMMENT '保险开始时间',
  `end_datetime` date DEFAULT NULL COMMENT '保险到期时间',
  `sms_count` int(4) DEFAULT NULL COMMENT '续保短信',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tloan_insure_company` */

CREATE TABLE `tloan_insure_company` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `salutation` varchar(32) DEFAULT NULL COMMENT '名称',
  `prefix` varchar(32) DEFAULT NULL COMMENT '保单前缀',
  `province` varchar(32) DEFAULT NULL COMMENT '省',
  `city` varchar(32) DEFAULT NULL COMMENT '市',
  `area` varchar(32) DEFAULT NULL COMMENT '区',
  `address` varchar(32) DEFAULT NULL COMMENT '详细地址',
  `name` varchar(32) DEFAULT NULL COMMENT '联系人',
  `contacts` varchar(32) DEFAULT NULL COMMENT '联系方式',
  `district` varchar(32) DEFAULT NULL COMMENT '所属地区',
  `updater` varchar(32) DEFAULT NULL COMMENT '操作人',
  `update_datetime` datetime DEFAULT NULL COMMENT '操作时间',
  `status` varchar(32) DEFAULT NULL COMMENT '状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tloan_insure_type` */

CREATE TABLE `tloan_insure_type` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `insure_code` varchar(32) DEFAULT NULL COMMENT '保险编号',
  `type` varchar(32) DEFAULT NULL COMMENT '保险类型',
  `amount` bigint(20) DEFAULT NULL COMMENT '保险金额',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tloan_node` */

CREATE TABLE `tloan_node` (
  `code` varchar(32) DEFAULT NULL COMMENT '编号',
  `type` varchar(32) DEFAULT NULL COMMENT '节点编号',
  `credit_order_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `start_datetime` datetime DEFAULT NULL COMMENT '开始时间',
  `end_datetime` datetime DEFAULT NULL COMMENT '结束时间',
  `distance` varchar(32) DEFAULT NULL COMMENT '间隔时间',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tloan_repay` */

CREATE TABLE `tloan_repay` (
  `code` varchar(32) NOT NULL COMMENT '编号',
  `credit_order_code` varchar(32) DEFAULT NULL COMMENT '业务编号',
  `jb_bank` varchar(32) DEFAULT NULL COMMENT '经办银行',
  `real_name` varchar(32) DEFAULT NULL COMMENT '借款人',
  `id_no` varchar(32) DEFAULT NULL COMMENT '身份证',
  `yh_amount` bigint(20) DEFAULT NULL COMMENT '应还金额',
  `yh_datetime` date DEFAULT NULL COMMENT '应还时间',
  `sh_amount` bigint(20) DEFAULT NULL COMMENT '实还金额',
  `sh_datetime` date DEFAULT NULL COMMENT '实还时间',
  `over_amount` bigint(20) DEFAULT NULL COMMENT '逾期金额',
  `over_days` varchar(32) DEFAULT NULL COMMENT '逾期天数',
  `sms_count` int(32) DEFAULT NULL COMMENT '发送催款次数',
  `status` varchar(4) DEFAULT NULL COMMENT '状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tsys_dict` */

CREATE TABLE `tsys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号（自增长）',
  `type` char(1) DEFAULT NULL COMMENT '类型（第一层/第二层）',
  `parent_key` varchar(32) DEFAULT NULL COMMENT '父key',
  `dkey` varchar(32) DEFAULT NULL COMMENT 'key',
  `dvalue` varchar(255) DEFAULT NULL COMMENT '值',
  `updater` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_datetime` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `system_code` varchar(32) DEFAULT NULL COMMENT '系统编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
