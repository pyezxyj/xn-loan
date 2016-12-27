/*
-- Query: SELECT * FROM tstd_user where login_name = 'admin' and system_code  = 'CD-CCD000003'
-- Date: 2016-12-26 22:02
*/
INSERT INTO `tstd_user` (`user_id`,`login_name`,`nickname`,`login_pwd`,`login_pwd_strength`,`kind`,`level`,`user_referee`,`mobile`,`id_kind`,`id_no`,`real_name`,`trade_pwd`,`trade_pwd_strength`,`role_code`,`status`,`pdf`,`amount`,`lj_amount`,`company_code`,`open_id`,`jpush_id`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CSHU201600000000000001','admin',NULL,'21218cca77804d2ba1922c33e0151105','1','01','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CCDSM201600000000000000','0',NULL,NULL,NULL,NULL,NULL,NULL,'admin',NULL,'管理端系统方','CD-CCD000003');

/*
-- Query: SELECT code,name,type,url,order_no,updater, now() as update_datetime,remark,parent_code,system_code FROM tsys_menu where system_code = 'CD-CCD000003'
-- Date: 2016-12-26 22:03
*/
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM201600000000000000','根目录','1','#','1','admin',now(),'','','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM201600001000000000','系统根目录','1','#','1','admin',now(),'','CCDSM201600000000000000','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM201600001000000001','系统管理','1','#','1','admin',now(),'','CCDSM201600001000000000','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM201600001000000002','运维管理','1','#','2','admin',now(),NULL,'CCDSM201600001000000001','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM201600001000000003','菜单管理','1','/security/menu.htm','1','admin',now(),NULL,'CCDSM201600001000000002','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM201600001000000004','修改','2','/edit','1','admin',now(),NULL,'CCDSM201600001000000003','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM2016101716241339082','运营管理','1','#','1','admin',now(),'','CCDSM201600001000000001','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM2016101716253866426','角色管理','1','/security/role.htm','1','admin',now(),'','CCDSM2016101716241339082','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM2016101716261754674','用户管理','1','/security/user.htm','2','admin',now(),'','CCDSM2016101716241339082','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM2016101716271123590','公司管理','1','/general/company.htm','1','admin',now(),'','CCDSM2016102516555766535','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM2016101716290657836','系统参数管理','1','/general/param.htm','2','admin',now(),'','CCDSM201600001000000002','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM2016101716295904680','数据字典管理','1','/general/dict.htm','3','admin',now(),'','CCDSM201600001000000002','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM2016101716450533995','分配菜单','2','/change','4','admin',now(),'','CCDSM2016101716253866426','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM2016101717551955993','新增','2','/add','1','admin',now(),'','CCDSM2016101716253866426','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM2016101717560118734','修改','2','/edit','2','admin',now(),'','CCDSM2016101716253866426','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM2016101717563661357','删除','2','/delete','3','admin',now(),'','CCDSM2016101716253866426','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM2016101719082391126','新增','2','/add','1','admin',now(),'','CCDSM2016101716261754674','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM2016101719094151894','重置密码','2','/reset','3','admin',now(),'','CCDSM2016101716261754674','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM2016101719100760088','注销','2','/rock','4','admin',now(),'','CCDSM2016101716261754674','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM2016101719110981215','设置角色','2','/assign','5','admin',now(),'','CCDSM2016101716261754674','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM2016101719120926719','新增','2','/add','1','admin',now(),'','CCDSM2016101716271123590','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM2016101719123215692','注销/取消','2','/rock','2','admin',now(),'','CCDSM2016101716271123590','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM2016101719125359852','修改','2','/edit','3','admin',now(),'','CCDSM2016101716271123590','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM2016101719132278227','详情','2','/detail','4','admin',now(),'','CCDSM2016101716271123590','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM2016101719140087629','修改','2','/edit','1','admin',now(),'','CCDSM2016101716290657836','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('CCDSM2016101719143965297','修改','2','/edit','1','admin',now(),'','CCDSM2016101716295904680','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201612231757239863','业务管理','1','#','2','admin',now(),'','CCDSM201600001000000000','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122318155417298','查询分析','1','#','2','admin',now(),'','CCDSM201600001000000000','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122320154950550','放款管理','1','#','1','admin',now(),'','SM201612231757239863','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122320244732812','客户资信调查','1','/biz/credit.htm','1','admin',now(),'','SM2016122320154950550','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122320395399595','分配调查岗','1','/biz/distribution.htm','2','admin',now(),'','SM2016122320154950550','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122320415190759','收款管理','1','#','2','admin',now(),'','SM201612231757239863','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122320431568896','放贷资料管理','1','/biz/lending.htm','4','admin',now(),'','SM2016122320154950550','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122320441711460','电话回访','1','/biz/return.htm','4','admin',now(),'','SM2016122320154950550','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122320451524229','请款资料补充','1','/biz/add.htm','5','admin',now(),'','SM2016122320154950550','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122320481649317','垫款复核','1','/biz/review.htm','6','admin',now(),'','SM2016122320154950550','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201612232056188508','发保合管理','1','/biz/manage.htm','1','admin',now(),'','SM2016122320415190759','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122320571551279','收款回录','1','/biz/back.htm','2','admin',now(),'','SM2016122320415190759','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122321024303854','分配','2','/edit','1','admin',now(),'','SM2016122320395399595','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122321033432155','回录','2','/back','2','admin',now(),'','SM2016122320395399595','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201612232111159968','新增','2','/add','3','admin',now(),'','SM2016122320244732812','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122321121540124','删除','2','/delete','4','admin',now(),'','SM2016122320244732812','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122321130298038','修改','2','/edit','5','admin',now(),'','SM2016122320244732812','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122321152632018','征信调查','2','/research','6','admin',now(),'','SM2016122320244732812','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122321163580618','详情','2','/detail','7','admin',now(),'','SM2016122320244732812','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122321380968149','资料录入','2','/edit','1','admin',now(),'','SM2016122320431568896','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122321385985134','合规审查','2','/check','2','admin',now(),'','SM2016122320431568896','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122321401084458','额度审批','2','/approval','3','admin',now(),'','SM2016122320431568896','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122321413915839','补充附件','2','/options','4','admin',now(),'','SM2016122320431568896','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122321433885399','回访','2','/return','1','admin',now(),'','SM2016122320441711460','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201612232145245613','补充','2','/add1','1','admin',now(),'','SM2016122320451524229','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122321465445038','复核','2','/add1','1','admin',now(),'','SM2016122320481649317','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122321482735223','打款回录','2','/transfer','2','admin',now(),'','SM2016122320481649317','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122321491344083','导出','2','/export','3','admin',now(),'','SM2016122320481649317','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122321524137292','上传','2','/add1','1','admin',now(),'','SM201612232056188508','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122321532257027','修改','2','/edit','2','admin',now(),'','SM201612232056188508','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201612232154073513','下载','2','/export','3','admin',now(),'','SM201612232056188508','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122321545700250','详情','2','/detail','4','admin',now(),'','SM201612232056188508','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122321582844177','回录','2','/add1','1','admin',now(),'','SM2016122320571551279','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122321594981257','导出','2','/export','2','admin',now(),'','SM2016122320571551279','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201612232203124916','贷后管理','1','#','3','admin',now(),'','SM201612231757239863','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122322045170356','还款管理','1','#','4','admin',now(),'','SM201612231757239863','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122322052682143','资料传递','1','#','5','admin',now(),'','SM201612231757239863','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122322080486119','汽车登记','1','/biz/record.htm','1','admin',now(),'','SM201612232203124916','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122322093598324','保单登记','1','/biz/insurance.htm','2','admin',now(),'','SM201612232203124916','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122322112704319','登记','2','/registration','1','admin',now(),'','SM2016122322080486119','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122322124365499','释放','2','/release','2','admin',now(),'','SM2016122322080486119','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122322131682615','详情','2','/detail','3','admin',now(),'','SM2016122322080486119','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122322135989377','导出','2','/export','4','admin',now(),'','SM2016122322080486119','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201612232218495520','导入还款信息','1','/biz/import.htm','1','admin',now(),'','SM2016122322045170356','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122322211196684',' 当期逾期客户查询','1','/biz/select.htm','2','admin',now(),'','SM2016122322045170356','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122322221604352','提前还款','1','/biz/preback.htm','3','admin',now(),'','SM2016122322045170356','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122322232413621','还款卡管理','1','/biz/card.htm','4','admin',now(),'','SM2016122322045170356','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122322324612281','导入','2','/input','1','admin',now(),'','SM201612232218495520','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122322333731386','新增','2','/add','2','admin',now(),'','SM201612232218495520','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122322341253267','删除','2','/delete','3','admin',now(),'','SM201612232218495520','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122322352985334','修改','2','/edit','4','admin',now(),'','SM201612232218495520','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122322362403344','详情','2','/detail','5','admin',now(),'','SM201612232218495520','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122322371445519','开始对比','2','/compare','6','admin',now(),'','SM201612232218495520','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122322381043222','详情','2','/detail','1','admin',now(),'','SM2016122322211196684','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122322393016412','短信催款','2','/message','2','admin',now(),'','SM2016122322211196684','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122322405020917','我要起诉','2','/warn','3','admin',now(),'','SM2016122322211196684','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122409263125711','提前还款','2','/before','1','admin',now(),'','SM2016122322221604352','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122409273750251','更换','2','/change','1','admin',now(),'','SM2016122322232413621','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122409293205742','货前移交','1','/biz/submit.htm','1','admin',now(),'','SM2016122322052682143','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122409305866692','复核','1','/biz/check.htm','2','admin',now(),'','SM2016122322052682143','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122409315975128','货后移交','1','/biz/after.htm','3','admin',now(),'','SM2016122322052682143','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122409335989554','移交','2','/change','1','admin',now(),'','SM2016122409293205742','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM201612240935167060','复核','2','/check','1','admin',now(),'','SM2016122409305866692','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122409360627164','提交银行','2','/submit','2','admin',now(),'','SM2016122409305866692','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122409371014096','复核','2','/check','1','admin',now(),'','SM2016122409315975128','CD-CCD000003');
INSERT INTO `tsys_menu` (`code`,`name`,`type`,`url`,`order_no`,`updater`,`update_datetime`,`remark`,`parent_code`,`system_code`) VALUES ('SM2016122409375287819','提交银行','2','/bank','2','admin',now(),'','SM2016122409315975128','CD-CCD000003');

/*
-- Query: SELECT `code`,`name`,`level`,'admin' as `updater`,now() as 'update_datetime',`remark`,`system_code` FROM tsys_role where name = '超级管理员' and system_code = 'CD-CCD000003'
-- Date: 2016-12-26 22:04
*/
INSERT INTO `tsys_role` (`code`,`name`,`level`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','超级管理员','1','admin',now(),NULL,'CD-CCD000003');


/*
-- Query: SELECT `role_code`,`menu_code`,`updater`,now() as `update_datetime`,`remark`,`system_code` FROM tsys_menu_role
-- Date: 2016-12-26 22:06
*/
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','CCDSM201600000000000000','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','CCDSM201600001000000000','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','CCDSM201600001000000001','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','CCDSM201600001000000002','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','CCDSM201600001000000003','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','CCDSM201600001000000004','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','CCDSM2016101716290657836','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','CCDSM2016101719140087629','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','CCDSM2016101716295904680','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','CCDSM2016101719143965297','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','CCDSM2016101716241339082','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','CCDSM2016101716253866426','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','CCDSM2016101716450533995','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','CCDSM2016101717551955993','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','CCDSM2016101717560118734','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','CCDSM2016101717563661357','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','CCDSM2016101716261754674','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','CCDSM2016101719082391126','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','CCDSM2016101719094151894','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','CCDSM2016101719100760088','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','CCDSM2016101719110981215','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM201612231757239863','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122320154950550','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122320244732812','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM201612232111159968','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122321121540124','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122321130298038','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122321152632018','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122321163580618','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122320395399595','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122321024303854','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122321033432155','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122320431568896','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122321380968149','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122321385985134','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122321401084458','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122321413915839','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122320441711460','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122321433885399','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122320451524229','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM201612232145245613','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122320481649317','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122321465445038','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122321482735223','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122321491344083','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122320415190759','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM201612232056188508','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122321524137292','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122321532257027','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM201612232154073513','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122321545700250','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122320571551279','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122321582844177','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('CCDSM201600000000000000','SM2016122321594981257','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('SR2016122515012575166','CCDSM201600000000000000','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('SR2016122515012575166','CCDSM201600001000000000','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('SR2016122515012575166','SM201612231757239863','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('SR2016122515012575166','SM2016122320154950550','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('SR2016122515012575166','SM2016122320244732812','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('SR2016122515012575166','SM201612232111159968','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('SR2016122515012575166','SM2016122321121540124','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('SR2016122515012575166','SM2016122321130298038','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('SR2016122515012575166','SM2016122321152632018','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('SR2016122515012575166','SM2016122321163580618','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('SR2016122515014423585','CCDSM201600000000000000','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('SR2016122515014423585','CCDSM201600001000000000','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('SR2016122515014423585','SM201612231757239863','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('SR2016122515014423585','SM2016122320154950550','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('SR2016122515014423585','SM2016122320395399595','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('SR2016122515014423585','SM2016122321024303854','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_menu_role` (`role_code`,`menu_code`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('SR2016122515014423585','SM2016122321033432155','admin',now(),NULL,'CD-CCD000003');

/*
-- Query: select `type`,`parent_key`,`dkey`,`dvalue`,`updater`,now() as update_datetime,`remark`,`system_code` from tsys_dict where system_code = 'CD-CCD000003'
-- Date: 2016-12-26 22:07
*/
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'user_status','用户状态','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','user_status','0','正常','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','user_status','1','程序锁定','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','user_status','2','人工锁定','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'id_kind','证件类型','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','id_kind','1','身份证','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'role_level','角色等级','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','role_level','1','运维','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','role_level','2','运营','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','role_level','3','客户','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'res_type','资源类型','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','res_type','1','菜单','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','res_type','2','按钮','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'lock_direction','锁定方向','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','lock_direction','1','用锁','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','lock_direction','2','解锁','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'loan_type','贷款类型','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','loan_type','1','车贷','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'relation','关系','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','relation','0','本人','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','relation','1','妻子','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','relation','2','担保人','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'audit_status','资信状态','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','audit_status','0','待审核','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','audit_status','1','审核通过','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','audit_status','2','审核不通过','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'car_type','车行','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','car_type','1','温州车行','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'jb_bank','经办银行','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','jb_bank','1','温州银行','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'saleman','业务员','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','saleman','1','aa','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'credit_result','征信结果','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','credit_result','0','不通过','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','credit_result','1','通过','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'court_result','法院结果','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','court_result','0','不通过','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','court_result','1','通过','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'urgency','紧急度','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','urgency','0','一般','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'loan_term','贷款期限','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','loan_term','0','1年','admin',now(),'','CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'credit_status','订单状态','admin',now(),NULL,'CD-CCD000003');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','credit_status','1','垫款复核不通过/财务复核不通过/财务待补充资料','admin',now(),NULL,'CD-CCD000003');
