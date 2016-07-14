/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.21 : Database - ideatest
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `t_case` */

DROP TABLE IF EXISTS `t_case`;

CREATE TABLE `t_case` (
  `C_ID` varchar(32) NOT NULL,
  `C_NAME` varchar(300) DEFAULT NULL,
  `C_SCRIPT_ID` varchar(32) DEFAULT NULL,
  `C_START_LINE` int(11) DEFAULT NULL,
  `C_END_LINE` int(11) DEFAULT NULL,
  `C_CREATOR_ID` varchar(32) DEFAULT NULL,
  `C_CREATETIME` datetime DEFAULT NULL,
  `C_MODIFIER_ID` varchar(32) DEFAULT NULL,
  `C_MODIFYTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_case` */

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
  `C_START_LINE` int(11) DEFAULT NULL,
  `C_END_LINE` int(11) DEFAULT NULL,
  `C_CREATOR_ID` varchar(32) DEFAULT NULL,
  `C_CREATETIME` datetime DEFAULT NULL,
  `C_MODIFIER_ID` varchar(32) DEFAULT NULL,
  `C_MODIFYTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_case_group` */

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

insert  into `t_schema`(`C_ID`,`C_NAME`,`C_PROJECT_ID`,`C_DESC`,`C_RUN_TYPE`,`C_CREATOR_ID`,`C_CREATETIME`,`C_MODIFIER_ID`,`C_MODIFYTIME`) values ('1','测试登录','1','只测新浪邮箱的登录模块','0','1','2016-07-14 02:21:04','1','2016-07-14 02:21:07');

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

insert  into `t_schema_hub`(`C_ID`,`C_SCHEMA_ID`,`C_NODE_ID`,`C_CREATOR_ID`,`C_CREATETIME`,`C_MODIFIER_ID`,`C_MODIFYTIME`) values ('1','1','1','1','2016-07-14 02:45:05','1','2016-07-14 02:45:08');

/*Table structure for table `t_schema_node` */

DROP TABLE IF EXISTS `t_schema_node`;

CREATE TABLE `t_schema_node` (
  `C_ID` varchar(32) NOT NULL,
  `C_SCHEMA_ID` varchar(32) NOT NULL,
  `C_NODE_ID` varchar(32) NOT NULL,
  `C_CREATOR_ID` varchar(32) NOT NULL,
  `C_CREATE_TIME` datetime NOT NULL,
  `C_MODIFIER_ID` varchar(32) DEFAULT NULL,
  `C_MODIFY_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_schema_node` */

insert  into `t_schema_node`(`C_ID`,`C_SCHEMA_ID`,`C_NODE_ID`,`C_CREATOR_ID`,`C_CREATE_TIME`,`C_MODIFIER_ID`,`C_MODIFY_TIME`) values ('1','1','2','1','2016-07-14 02:45:28','1','2016-07-14 02:45:33');

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
