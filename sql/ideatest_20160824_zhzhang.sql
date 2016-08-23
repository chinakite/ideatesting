/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.7.13 : Database - ideatest
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ideatest` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ideatest`;

/*Table structure for table `t_case` */

DROP TABLE IF EXISTS `t_case`;

CREATE TABLE `t_case` (
  `C_ID` varchar(32) NOT NULL,
  `C_NAME` varchar(300) DEFAULT NULL,
  `C_SCRIPT_ID` varchar(32) DEFAULT NULL,
  `C_PROJECT_ID` varchar(32) DEFAULT NULL,
  `C_START_LINE` int(11) DEFAULT NULL,
  `C_END_LINE` int(11) DEFAULT NULL,
  `C_CREATOR_ID` varchar(32) DEFAULT NULL,
  `C_CREATETIME` datetime DEFAULT NULL,
  `C_MODIFIER_ID` varchar(32) DEFAULT NULL,
  `C_MODIFYTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_case` */

insert  into `t_case`(`C_ID`,`C_NAME`,`C_SCRIPT_ID`,`C_PROJECT_ID`,`C_START_LINE`,`C_END_LINE`,`C_CREATOR_ID`,`C_CREATETIME`,`C_MODIFIER_ID`,`C_MODIFYTIME`) values ('40282e8155efb8890155efb8899a0000','login','1','1',5,14,'1','2016-07-16 02:01:34','1','2016-07-16 02:01:34');

/*Table structure for table `t_case_depend` */

DROP TABLE IF EXISTS `t_case_depend`;

CREATE TABLE `t_case_depend` (
  `C_ID` varchar(32) NOT NULL,
  `C_CASE_ID` varchar(32) DEFAULT NULL,
  `C_DEPENDENCY_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_case_depend` */

/*Table structure for table `t_case_group` */

DROP TABLE IF EXISTS `t_case_group`;

CREATE TABLE `t_case_group` (
  `C_ID` varchar(32) NOT NULL,
  `C_NAME` varchar(300) DEFAULT NULL,
  `C_SCRIPT_ID` varchar(32) DEFAULT NULL,
  `C_PROJECT_ID` varchar(32) DEFAULT NULL,
  `C_START_LINE` int(11) DEFAULT NULL,
  `C_END_LINE` int(11) DEFAULT NULL,
  `C_CREATOR_ID` varchar(32) DEFAULT NULL,
  `C_CREATETIME` datetime DEFAULT NULL,
  `C_MODIFIER_ID` varchar(32) DEFAULT NULL,
  `C_MODIFYTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_case_group` */

insert  into `t_case_group`(`C_ID`,`C_NAME`,`C_SCRIPT_ID`,`C_PROJECT_ID`,`C_START_LINE`,`C_END_LINE`,`C_CREATOR_ID`,`C_CREATETIME`,`C_MODIFIER_ID`,`C_MODIFYTIME`) values ('40282e8155efb8890155efb889aa0001','sinamail','1','1',1,3,'1','2016-07-16 02:01:34','1','2016-07-16 02:01:34');

/*Table structure for table `t_case_group_map` */

DROP TABLE IF EXISTS `t_case_group_map`;

CREATE TABLE `t_case_group_map` (
  `C_ID` varchar(32) NOT NULL,
  `C_GROUP_NAME` varchar(300) DEFAULT NULL,
  `C_CASE_NAME` varchar(300) DEFAULT NULL,
  `C_PROJECT_ID` varchar(32) DEFAULT NULL,
  `C_CREATOR_ID` varchar(32) DEFAULT NULL,
  `C_CREATETIME` datetime DEFAULT NULL,
  `C_MODIFIER_ID` varchar(32) DEFAULT NULL,
  `C_MODIFYTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_case_group_map` */

insert  into `t_case_group_map`(`C_ID`,`C_GROUP_NAME`,`C_CASE_NAME`,`C_PROJECT_ID`,`C_CREATOR_ID`,`C_CREATETIME`,`C_MODIFIER_ID`,`C_MODIFYTIME`) values ('40282e8155efb8890155efb889ba0002','sinamail','login','1','1','2016-07-16 02:01:34','1','2016-07-16 02:01:34');

/*Table structure for table `t_case_result` */

DROP TABLE IF EXISTS `t_case_result`;

CREATE TABLE `t_case_result` (
  `C_ID` varchar(32) NOT NULL,
  `C_CASE_NAME` varchar(300) DEFAULT NULL,
  `C_SCRIPT_ID` varchar(32) DEFAULT NULL,
  `C_SCHEMA_ID` varchar(32) DEFAULT NULL,
  `C_SCHEMA_EXECUTION_ID` varchar(32) DEFAULT NULL,
  `C_RESULT` varchar(2) DEFAULT NULL,
  `C_CREATOR_ID` varchar(32) DEFAULT NULL,
  `C_CREATETIME` datetime DEFAULT NULL,
  `C_MODIFIER_ID` varchar(32) DEFAULT NULL,
  `C_MODIFYTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_case_result` */

insert  into `t_case_result`(`C_ID`,`C_CASE_NAME`,`C_SCRIPT_ID`,`C_SCHEMA_ID`,`C_SCHEMA_EXECUTION_ID`,`C_RESULT`,`C_CREATOR_ID`,`C_CREATETIME`,`C_MODIFIER_ID`,`C_MODIFYTIME`) values ('402881f2569f115801569f11586e0000','login','1','2c8a81b85699cd9c015699ceb0160004',NULL,'1','1','2016-08-19 03:12:09',NULL,NULL),('402881f256a8dac60156a8dae59f0001','login','1','2c8a81b85699cd9c015699ceb0160004','402881f256a8dac60156a8dac6b70000','1','1','2016-08-21 00:48:53',NULL,NULL);

/*Table structure for table `t_command_result` */

DROP TABLE IF EXISTS `t_command_result`;

CREATE TABLE `t_command_result` (
  `C_ID` varchar(32) NOT NULL,
  `C_CASE_RESULT_ID` varchar(32) DEFAULT NULL,
  `C_RESULT` varchar(2) DEFAULT NULL,
  `C_START_LINE` int(11) DEFAULT NULL,
  `C_END_LINE` int(11) DEFAULT NULL,
  `C_COMMAND_TEXT` varchar(3000) DEFAULT NULL,
  `C_MESSAGE` varchar(3000) DEFAULT NULL,
  `C_CREATOR_ID` varchar(32) DEFAULT NULL,
  `C_CREATETIME` datetime DEFAULT NULL,
  `C_MODIFIER_ID` varchar(32) DEFAULT NULL,
  `C_MODIFYTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_command_result` */

insert  into `t_command_result`(`C_ID`,`C_CASE_RESULT_ID`,`C_RESULT`,`C_START_LINE`,`C_END_LINE`,`C_COMMAND_TEXT`,`C_MESSAGE`,`C_CREATOR_ID`,`C_CREATETIME`,`C_MODIFIER_ID`,`C_MODIFYTIME`) values ('402881f2569f115801569f1158740001','402881f2569f115801569f11586e0000','1',6,6,'get\"http://mail.sina.com.cn\";',NULL,'1','2016-08-19 03:12:09',NULL,NULL),('402881f2569f115801569f11587b0002','402881f2569f115801569f11586e0000','1',7,7,'wait2000;',NULL,'1','2016-08-19 03:12:09',NULL,NULL),('402881f2569f115801569f11587d0003','402881f2569f115801569f11586e0000','1',8,8,'assert\"#freename\"exists;',NULL,'1','2016-08-19 03:12:09',NULL,NULL),('402881f2569f115801569f11587e0004','402881f2569f115801569f11586e0000','1',9,9,'assert\"#freepassword\"exists;',NULL,'1','2016-08-19 03:12:09',NULL,NULL),('402881f2569f115801569f1158800005','402881f2569f115801569f11586e0000','1',10,10,'input\"ideacaserunner@sina.com\"to\"#freename\";',NULL,'1','2016-08-19 03:12:09',NULL,NULL),('402881f2569f115801569f1158820006','402881f2569f115801569f11586e0000','1',11,11,'input\"IdeaCaseRunner1\"to\"#freepassword\";',NULL,'1','2016-08-19 03:12:09',NULL,NULL),('402881f2569f115801569f1158860007','402881f2569f115801569f11586e0000','1',12,12,'click\".loginBtn\";',NULL,'1','2016-08-19 03:12:09',NULL,NULL),('402881f2569f115801569f1158880008','402881f2569f115801569f11586e0000','1',13,13,'click\".wrWriteBtn a\"when\".wrWriteBtn a\"existstimeout5000;',NULL,'1','2016-08-19 03:12:09',NULL,NULL),('402881f256a8dac60156a8dae5a90002','402881f256a8dac60156a8dae59f0001','1',6,6,'get\"http://mail.sina.com.cn\";',NULL,'1','2016-08-21 00:48:53',NULL,NULL),('402881f256a8dac60156a8dae5ae0003','402881f256a8dac60156a8dae59f0001','1',7,7,'wait2000;',NULL,'1','2016-08-21 00:48:53',NULL,NULL),('402881f256a8dac60156a8dae5b00004','402881f256a8dac60156a8dae59f0001','1',8,8,'assert\"#freename\"exists;',NULL,'1','2016-08-21 00:48:53',NULL,NULL),('402881f256a8dac60156a8dae5b10005','402881f256a8dac60156a8dae59f0001','1',9,9,'assert\"#freepassword\"exists;',NULL,'1','2016-08-21 00:48:53',NULL,NULL),('402881f256a8dac60156a8dae5b40006','402881f256a8dac60156a8dae59f0001','1',10,10,'input\"ideacaserunner@sina.com\"to\"#freename\";',NULL,'1','2016-08-21 00:48:53',NULL,NULL),('402881f256a8dac60156a8dae5b50007','402881f256a8dac60156a8dae59f0001','1',11,11,'input\"IdeaCaseRunner1\"to\"#freepassword\";',NULL,'1','2016-08-21 00:48:53',NULL,NULL),('402881f256a8dac60156a8dae5b70008','402881f256a8dac60156a8dae59f0001','1',12,12,'click\".loginBtn\";',NULL,'1','2016-08-21 00:48:53',NULL,NULL),('402881f256a8dac60156a8dae5b90009','402881f256a8dac60156a8dae59f0001','1',13,13,'click\".wrWriteBtn a\"when\".wrWriteBtn a\"existstimeout5000;',NULL,'1','2016-08-21 00:48:53',NULL,NULL);

/*Table structure for table `t_node` */

DROP TABLE IF EXISTS `t_node`;

CREATE TABLE `t_node` (
  `C_ID` varchar(32) NOT NULL,
  `C_NAME` varchar(300) DEFAULT NULL,
  `C_ADDRESS` varchar(30) DEFAULT NULL,
  `C_PORT` varchar(5) DEFAULT NULL,
  `C_DESC` varchar(420) DEFAULT NULL,
  `C_STATE` varchar(2) DEFAULT NULL,
  `C_TYPE` varchar(2) DEFAULT NULL,
  `C_OWNER_ID` varchar(32) DEFAULT NULL,
  `C_CREATOR_ID` varchar(32) DEFAULT NULL,
  `C_CREATETIME` datetime DEFAULT NULL,
  `C_MODIFIER_ID` varchar(32) DEFAULT NULL,
  `C_MODIFYTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_node` */

insert  into `t_node`(`C_ID`,`C_NAME`,`C_ADDRESS`,`C_PORT`,`C_DESC`,`C_STATE`,`C_TYPE`,`C_OWNER_ID`,`C_CREATOR_ID`,`C_CREATETIME`,`C_MODIFIER_ID`,`C_MODIFYTIME`) values ('1','Hub 1','127.0.0.1','4444','Hub 1','1','1','1','1','2016-07-04 07:38:18','1','2016-07-04 07:38:21'),('2','Node 1','127.0.0.1','5555','Node 1','1','0','1','1','2016-07-04 07:38:45','1','2016-07-04 07:39:53'),('3','Node 2','127.0.0.1','6666','Node 2','1','0','1','1','2016-07-04 07:40:30','1','2016-07-04 07:40:32'),('40282e8155e021e90155e02ae55a0001','Hub2','127.0.0.1','7001','Hub 2','1','1','1','1','2016-07-13 01:32:36','1','2016-07-13 01:32:36');

/*Table structure for table `t_project` */

DROP TABLE IF EXISTS `t_project`;

CREATE TABLE `t_project` (
  `C_ID` varchar(32) NOT NULL,
  `C_NAME` varchar(300) DEFAULT NULL,
  `C_DESC` varchar(420) DEFAULT NULL,
  `C_STATE` varchar(2) DEFAULT NULL,
  `C_CREATOR_ID` varchar(32) DEFAULT NULL,
  `C_CREATETIME` datetime DEFAULT NULL,
  `C_MODIFIER_ID` varchar(32) DEFAULT NULL,
  `C_MODIFYTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_project` */

insert  into `t_project`(`C_ID`,`C_NAME`,`C_DESC`,`C_STATE`,`C_CREATOR_ID`,`C_CREATETIME`,`C_MODIFIER_ID`,`C_MODIFYTIME`) values ('1','新浪邮箱','自动化测试新浪邮箱','1','1','2016-07-02 15:45:37','1','2016-07-02 15:45:40');

/*Table structure for table `t_schema` */

DROP TABLE IF EXISTS `t_schema`;

CREATE TABLE `t_schema` (
  `C_ID` varchar(32) NOT NULL,
  `C_NAME` varchar(300) DEFAULT NULL,
  `C_PROJECT_ID` varchar(32) DEFAULT NULL,
  `C_DESC` varchar(420) DEFAULT NULL,
  `C_RUN_TYPE` varchar(2) DEFAULT NULL,
  `C_CREATOR_ID` varchar(32) DEFAULT NULL,
  `C_CREATETIME` datetime DEFAULT NULL,
  `C_MODIFIER_ID` varchar(32) DEFAULT NULL,
  `C_MODIFYTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_schema` */

insert  into `t_schema`(`C_ID`,`C_NAME`,`C_PROJECT_ID`,`C_DESC`,`C_RUN_TYPE`,`C_CREATOR_ID`,`C_CREATETIME`,`C_MODIFIER_ID`,`C_MODIFYTIME`) values ('1','测试登录','1','只测新浪邮箱的登录模块','0','1','2016-07-14 02:21:04','1','2016-07-14 02:21:07'),('2c8a81b85699b9af015699c9971d000c','再次测试登录','1','https://github.com/chinakite/ideajdbc.git','0','1','2016-08-18 02:35:41','1','2016-08-18 02:35:41'),('2c8a81b85699cd9c015699cd9c350000','还是得测试登录啊','1','schemaRunType','0','1','2016-08-18 02:40:04','1','2016-08-18 02:40:04'),('2c8a81b85699cd9c015699ceb0160004','再来一次','1','1234','0','1','2016-08-18 02:41:15','1','2016-08-18 02:41:15');

/*Table structure for table `t_schema_case` */

DROP TABLE IF EXISTS `t_schema_case`;

CREATE TABLE `t_schema_case` (
  `C_ID` varchar(32) NOT NULL,
  `C_SCHEMA_ID` varchar(32) DEFAULT NULL,
  `C_CASE_NAME` varchar(300) DEFAULT NULL,
  `C_CREATOR_ID` varchar(32) DEFAULT NULL,
  `C_CREATETIME` datetime DEFAULT NULL,
  `C_MODIFIER_ID` varchar(32) DEFAULT NULL,
  `C_MODIFYTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_schema_case` */

insert  into `t_schema_case`(`C_ID`,`C_SCHEMA_ID`,`C_CASE_NAME`,`C_CREATOR_ID`,`C_CREATETIME`,`C_MODIFIER_ID`,`C_MODIFYTIME`) values ('1','1','login','1','2016-07-16 17:21:38','1','2016-07-16 17:21:42');

/*Table structure for table `t_schema_case_group` */

DROP TABLE IF EXISTS `t_schema_case_group`;

CREATE TABLE `t_schema_case_group` (
  `C_ID` varchar(32) NOT NULL,
  `C_SCHEMA_ID` varchar(32) DEFAULT NULL,
  `C_CASE_GROUP_NAME` varchar(300) DEFAULT NULL,
  `C_CREATOR_ID` varchar(32) DEFAULT NULL,
  `C_CREATETIME` datetime DEFAULT NULL,
  `C_MODIFIER_ID` varchar(32) DEFAULT NULL,
  `C_MODIFYTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_schema_case_group` */

/*Table structure for table `t_schema_execution` */

DROP TABLE IF EXISTS `t_schema_execution`;

CREATE TABLE `t_schema_execution` (
  `C_ID` varchar(32) NOT NULL,
  `C_SCHEMA_ID` varchar(32) DEFAULT NULL,
  `C_PROJECT_ID` varchar(32) DEFAULT NULL,
  `C_START_TIME` datetime DEFAULT NULL,
  `C_END_TIME` datetime DEFAULT NULL,
  `C_STATE` varchar(2) DEFAULT NULL,
  `C_CREATOR_ID` varchar(32) DEFAULT NULL,
  `C_CREATETIME` datetime DEFAULT NULL,
  `C_MODIFIER_ID` varchar(32) DEFAULT NULL,
  `C_MODIFYTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_schema_execution` */

insert  into `t_schema_execution`(`C_ID`,`C_SCHEMA_ID`,`C_PROJECT_ID`,`C_START_TIME`,`C_END_TIME`,`C_STATE`,`C_CREATOR_ID`,`C_CREATETIME`,`C_MODIFIER_ID`,`C_MODIFYTIME`) values ('402881f256a8d9bc0156a8d9bc4a0000','2c8a81b85699cd9c015699ceb0160004','1','2016-08-21 00:47:37','2016-08-21 00:47:37','2','1','2016-08-21 00:47:37',NULL,NULL),('402881f256a8dac60156a8dac6b70000','2c8a81b85699cd9c015699ceb0160004','1','2016-08-21 00:48:45','2016-08-21 00:48:53','1','1','2016-08-21 00:48:45',NULL,NULL);

/*Table structure for table `t_schema_hub` */

DROP TABLE IF EXISTS `t_schema_hub`;

CREATE TABLE `t_schema_hub` (
  `C_ID` varchar(32) NOT NULL,
  `C_SCHEMA_ID` varchar(32) NOT NULL,
  `C_NODE_ID` varchar(32) NOT NULL,
  `C_CREATOR_ID` varchar(32) NOT NULL,
  `C_CREATETIME` datetime NOT NULL,
  `C_MODIFIER_ID` varchar(32) DEFAULT NULL,
  `C_MODIFYTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_schema_hub` */

insert  into `t_schema_hub`(`C_ID`,`C_SCHEMA_ID`,`C_NODE_ID`,`C_CREATOR_ID`,`C_CREATETIME`,`C_MODIFIER_ID`,`C_MODIFYTIME`) values ('1','1','1','1','2016-07-14 02:45:05','1','2016-07-14 02:45:08'),('2c8a81b85699b9af015699c99725000e','2c8a81b85699b9af015699c9971d000c','1','1','2016-08-18 02:35:41','1','2016-08-18 02:35:41'),('2c8a81b85699cd9c015699cd9c880002','2c8a81b85699cd9c015699cd9c350000','1','1','2016-08-18 02:40:04','1','2016-08-18 02:40:04'),('2c8a81b85699cd9c015699ceb0190006','2c8a81b85699cd9c015699ceb0160004','1','1','2016-08-18 02:41:15','1','2016-08-18 02:41:15');

/*Table structure for table `t_schema_node` */

DROP TABLE IF EXISTS `t_schema_node`;

CREATE TABLE `t_schema_node` (
  `C_ID` varchar(32) NOT NULL,
  `C_SCHEMA_ID` varchar(32) NOT NULL,
  `C_NODE_ID` varchar(32) NOT NULL,
  `C_CREATOR_ID` varchar(32) NOT NULL,
  `C_CREATETIME` datetime NOT NULL,
  `C_MODIFIER_ID` varchar(32) DEFAULT NULL,
  `C_MODIFYTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_schema_node` */

insert  into `t_schema_node`(`C_ID`,`C_SCHEMA_ID`,`C_NODE_ID`,`C_CREATOR_ID`,`C_CREATETIME`,`C_MODIFIER_ID`,`C_MODIFYTIME`) values ('1','1','2','1','2016-07-14 02:45:28','1','2016-07-14 02:45:33'),('2c8a81b85699b9af015699c99728000f','2c8a81b85699b9af015699c9971d000c','2','1','2016-08-18 02:35:41','1','2016-08-18 02:35:41'),('2c8a81b85699cd9c015699cd9c8d0003','2c8a81b85699cd9c015699cd9c350000','2','1','2016-08-18 02:40:04','1','2016-08-18 02:40:04'),('2c8a81b85699cd9c015699ceb01a0007','2c8a81b85699cd9c015699ceb0160004','2','1','2016-08-18 02:41:15','1','2016-08-18 02:41:15');

/*Table structure for table `t_schema_script` */

DROP TABLE IF EXISTS `t_schema_script`;

CREATE TABLE `t_schema_script` (
  `C_ID` varchar(32) NOT NULL,
  `C_SCHEMA_ID` varchar(32) DEFAULT NULL,
  `C_SCRIPT_ID` varchar(32) DEFAULT NULL,
  `C_CREATOR_ID` varchar(32) DEFAULT NULL,
  `C_CREATETIME` datetime DEFAULT NULL,
  `C_MODIFIER_ID` varchar(32) DEFAULT NULL,
  `C_MODIFYTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_schema_script` */

insert  into `t_schema_script`(`C_ID`,`C_SCHEMA_ID`,`C_SCRIPT_ID`,`C_CREATOR_ID`,`C_CREATETIME`,`C_MODIFIER_ID`,`C_MODIFYTIME`) values ('2c8a81b85699b9af015699c99721000d','2c8a81b85699b9af015699c9971d000c','1','1','2016-08-18 02:35:41','1','2016-08-18 02:35:41'),('2c8a81b85699cd9c015699cd9c3a0001','2c8a81b85699cd9c015699cd9c350000','1','1','2016-08-18 02:40:04','1','2016-08-18 02:40:04'),('2c8a81b85699cd9c015699ceb0180005','2c8a81b85699cd9c015699ceb0160004','1','1','2016-08-18 02:41:15','1','2016-08-18 02:41:15');

/*Table structure for table `t_script` */

DROP TABLE IF EXISTS `t_script`;

CREATE TABLE `t_script` (
  `C_ID` varchar(32) NOT NULL,
  `C_PROJECT_ID` varchar(32) DEFAULT NULL,
  `C_FILE_URL` varchar(2000) DEFAULT NULL,
  `C_VERSION` varchar(10) DEFAULT NULL,
  `C_FILE_NAME` varchar(300) DEFAULT NULL,
  `C_CREATOR_ID` varchar(32) DEFAULT NULL,
  `C_CREATETIME` datetime DEFAULT NULL,
  `C_MODIFIER_ID` varchar(32) DEFAULT NULL,
  `C_MODIFYTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_script` */

insert  into `t_script`(`C_ID`,`C_PROJECT_ID`,`C_FILE_URL`,`C_VERSION`,`C_FILE_NAME`,`C_CREATOR_ID`,`C_CREATETIME`,`C_MODIFIER_ID`,`C_MODIFYTIME`) values ('1','1','/uploads/scripts/20160703/testcase2.icr','v1.0','testcase2.icr','1','2016-07-03 03:37:32','1','2016-07-03 03:37:34');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `C_ID` varchar(32) NOT NULL,
  `C_NAME` varchar(60) DEFAULT NULL,
  `C_ACCOUNT` varchar(60) DEFAULT NULL,
  `C_EMAIL` varchar(60) DEFAULT NULL,
  `C_PASSWORD` varchar(40) DEFAULT NULL,
  `C_MOBILE` varchar(20) DEFAULT NULL,
  `C_GENDER` varchar(1) DEFAULT NULL,
  `C_LOGOURL` varchar(500) DEFAULT NULL,
  `C_STATUS` varchar(1) DEFAULT NULL,
  `C_CREATOR_ID` varchar(32) DEFAULT NULL,
  `C_CREATETIME` datetime DEFAULT NULL,
  `C_MODIFIER_ID` varchar(32) DEFAULT NULL,
  `C_MODIFYTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`C_ID`,`C_NAME`,`C_ACCOUNT`,`C_EMAIL`,`C_PASSWORD`,`C_MOBILE`,`C_GENDER`,`C_LOGOURL`,`C_STATUS`,`C_CREATOR_ID`,`C_CREATETIME`,`C_MODIFIER_ID`,`C_MODIFYTIME`) values ('1','中华风筝','chinakite','9654589@qq.com',NULL,'13212345678','1',NULL,'1','1','2016-07-02 15:45:50','1','2016-07-02 15:45:54');

/*Table structure for table `t_user_logininfo` */

DROP TABLE IF EXISTS `t_user_logininfo`;

CREATE TABLE `t_user_logininfo` (
  `C_ID` varchar(32) NOT NULL,
  `C_USER_ID` varchar(32) DEFAULT NULL,
  `C_FIRST_LOGIN_TIME` datetime DEFAULT NULL,
  `C_FIRST_LOGIN_IP` varchar(32) DEFAULT NULL,
  `C_LAST_LOGIN_TIME` datetime DEFAULT NULL,
  `C_LAST_LOGIN_IP` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user_logininfo` */

/*Table structure for table `t_user_project` */

DROP TABLE IF EXISTS `t_user_project`;

CREATE TABLE `t_user_project` (
  `C_ID` varchar(32) NOT NULL,
  `C_USER_ID` varchar(32) DEFAULT NULL,
  `C_PROJECT_ID` varchar(32) DEFAULT NULL,
  `C_CREATOR_ID` varchar(32) DEFAULT NULL,
  `C_CREATETIME` datetime DEFAULT NULL,
  `C_MODIFIER_ID` varchar(32) DEFAULT NULL,
  `C_MODIFYTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user_project` */

insert  into `t_user_project`(`C_ID`,`C_USER_ID`,`C_PROJECT_ID`,`C_CREATOR_ID`,`C_CREATETIME`,`C_MODIFIER_ID`,`C_MODIFYTIME`) values ('1','1','1','1','2016-07-02 15:46:31','1','2016-07-02 15:46:34');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
