/*
-- Query: SELECT * FROM std_mall.tsys_config
LIMIT 0, 50000

-- Date: 2016-11-18 13:38
*/
INSERT INTO `tsys_config` (`id`,`cname`,`ckey`,`cvalue`,`remark`,`belong`,`company_code`) VALUES (1,'包邮订单金额','byje','88','订单金额大于等于该配置，包邮',0,NULL);
INSERT INTO `tsys_config` (`id`,`cname`,`ckey`,`cvalue`,`remark`,`belong`,`company_code`) VALUES (2,'运费','yunfei','10','默认订单运费',0,NULL);

INSERT INTO `tmall_category` (`code`,`parent_code`,`type`,`name`,`pic`,`order_no`,`belong`,`company_code`) VALUES ('FL2016000000000000001','0','2','热门','http://121.43.101.148:8901/M201600000/huo.png',1,'1','0');
INSERT INTO `tmall_category` (`code`,`parent_code`,`type`,`name`,`pic`,`order_no`,`belong`,`company_code`) VALUES ('FL2016000000000000002','0','2','新品','http://121.43.101.148:8901/M201600000/xin.png',2,'1','0');