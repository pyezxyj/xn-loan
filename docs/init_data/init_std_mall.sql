/*
-- Query: SELECT * FROM std_mall.tmall_category where parent_code = '0'
LIMIT 0, 5000

-- Date: 2016-12-17 17:23
*/
INSERT INTO `tmall_category` (`code`,`parent_code`,`type`,`name`,`pic`,`order_no`,`belong`,`company_code`,`system_code`) VALUES ('FL201600000000000001','0','1','剁手合集','',1,NULL,NULL,'CD-CZH000001');
INSERT INTO `tmall_category` (`code`,`parent_code`,`type`,`name`,`pic`,`order_no`,`belong`,`company_code`,`system_code`) VALUES ('FL201600000000000002','0','1','一元夺宝',NULL,2,NULL,NULL,'CD-CZH000001');
INSERT INTO `tmall_category` (`code`,`parent_code`,`type`,`name`,`pic`,`order_no`,`belong`,`company_code`,`system_code`) VALUES ('FL201600000000000003','0','1','0元试购','',3,NULL,NULL,'CD-CZH000001');


INSERT INTO `tmall_category` (`code`,`parent_code`,`type`,`name`,`pic`,`order_no`,`belong`,`company_code`,`system_code`) VALUES ('FL201600000000000004','FL201600000000000001','1','小类1','',1,NULL,NULL,'CD-CZH000001');
INSERT INTO `tmall_category` (`code`,`parent_code`,`type`,`name`,`pic`,`order_no`,`belong`,`company_code`,`system_code`) VALUES ('FL201600000000000005','FL201600000000000001','1','小类2','',1,NULL,NULL,'CD-CZH000001');
INSERT INTO `tmall_category` (`code`,`parent_code`,`type`,`name`,`pic`,`order_no`,`belong`,`company_code`,`system_code`) VALUES ('FL201600000000000006','FL201600000000000001','1','小类3','',1,NULL,NULL,'CD-CZH000001');
INSERT INTO `tmall_category` (`code`,`parent_code`,`type`,`name`,`pic`,`order_no`,`belong`,`company_code`,`system_code`) VALUES ('FL201600000000000007','FL201600000000000001','1','小类4','',1,NULL,NULL,'CD-CZH000001');

INSERT INTO `tmall_category` (`code`,`parent_code`,`type`,`name`,`pic`,`order_no`,`belong`,`company_code`,`system_code`) VALUES ('FL201600000000000008','FL201600000000000003','1','小类1','',1,NULL,NULL,'CD-CZH000001');
INSERT INTO `tmall_category` (`code`,`parent_code`,`type`,`name`,`pic`,`order_no`,`belong`,`company_code`,`system_code`) VALUES ('FL201600000000000009','FL201600000000000003','1','小类2','',1,NULL,NULL,'CD-CZH000001');
INSERT INTO `tmall_category` (`code`,`parent_code`,`type`,`name`,`pic`,`order_no`,`belong`,`company_code`,`system_code`) VALUES ('FL201600000000000010','FL201600000000000003','1','小类3','',1,NULL,NULL,'CD-CZH000001');
INSERT INTO `tmall_category` (`code`,`parent_code`,`type`,`name`,`pic`,`order_no`,`belong`,`company_code`,`system_code`) VALUES ('FL201600000000000011','FL201600000000000003','1','小类4','',1,NULL,NULL,'CD-CZH000001');


