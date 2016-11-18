/*
-- Query: select `type`,`parent_key`,`dkey`,`dvalue`,'admin' as updater,now() as update_datetime,`remark` from tsys_dict  where id  >=54
LIMIT 0, 50000

-- Date: 2016-11-18 13:35
*/
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`remark`) VALUES ('0',NULL,'product_status','产品状态',NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`remark`) VALUES ('1','product_status','0','待发布',NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`remark`) VALUES ('1','product_status','1','已上架',NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`remark`) VALUES ('1','product_status','2','已下架',NULL);

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`remark`) VALUES ('0',NULL,'receipt_type','发票类型',NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`remark`) VALUES ('1','receipt_type','1','个人',NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`remark`) VALUES ('1','receipt_type','2','企业',NULL);

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`remark`) VALUES ('0',NULL,'wl_company','物流公司',NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`remark`) VALUES ('1','wl_company','EMS','邮政EMS',NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`remark`) VALUES ('1','wl_company','STO','申通快递',NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`remark`) VALUES ('1','wl_company','ZTO','中通快递',NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`remark`) VALUES ('1','wl_company','YTO','圆通快递',NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`remark`) VALUES ('1','wl_company','HTKY','汇通快递',NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`remark`) VALUES ('1','wl_company','ZJS','宅急送',NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`remark`) VALUES ('1','wl_company','SF','顺丰快递',NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`remark`) VALUES ('1','wl_company','TTKD','天天快递',NULL);

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`remark`) VALUES ('0',NULL,'order_status','订单状态',NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`remark`) VALUES ('1','order_status','1','待支付',NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`remark`) VALUES ('1','order_status','2','已支付待发货',NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`remark`) VALUES ('1','order_status','3','已发货待收货',NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`remark`) VALUES ('1','order_status','4','已收货',NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`remark`) VALUES ('1','order_status','91','用户取消',NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`remark`) VALUES ('1','order_status','92','商户取消',NULL);
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`remark`) VALUES ('1','order_status','93','快递异常',NULL);

/*
-- Query: SELECT * FROM std_mall.tsys_config
LIMIT 0, 50000

-- Date: 2016-11-18 13:38
*/
INSERT INTO `tsys_config` (`id`,`cname`,`ckey`,`cvalue`,`remark`,`company_code`) VALUES (1,'包邮订单金额','byje','9000','订单金额大于等于该配置，包邮',NULL);
INSERT INTO `tsys_config` (`id`,`cname`,`ckey`,`cvalue`,`remark`,`company_code`) VALUES (2,'运费','yunfei','12000','默认订单运费',NULL);

