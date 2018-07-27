# Host: localhost  (Version 5.5.27)
# Date: 2018-07-26 20:31:40
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "depts"
#

DROP TABLE IF EXISTS `depts`;
CREATE TABLE `depts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `create_date` date DEFAULT '0000-00-00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

#
# Data for table "depts"
#

INSERT INTO `depts` VALUES (1,'人事部','2011-08-11'),(2,'市场部','2012-12-11'),(3,'研发部','2015-11-11');

#
# Structure for table "jobs"
#

DROP TABLE IF EXISTS `jobs`;
CREATE TABLE `jobs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `dept_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `dept_id` (`dept_id`),
  CONSTRAINT `jobs_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `depts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

#
# Data for table "jobs"
#

INSERT INTO `jobs` VALUES (1,'java开发工程师',1),(2,'测试员',2),(3,'大数据开发',3),(4,'会计',2),(5,'技术总监',2),(8,'主管',1),(9,'主管',2),(12,'主管',3);

#
# Structure for table "employees"
#

DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEPT_ID` int(11) NOT NULL,
  `JOB_ID` int(11) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `ADDRESS` varchar(50) NOT NULL,
  `PHONE` varchar(11) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `SEX` char(2) NOT NULL DEFAULT '',
  `BIRTHDAY` datetime DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL,
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `salary` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `DEPT_ID` (`DEPT_ID`),
  KEY `JOB_ID` (`JOB_ID`),
  CONSTRAINT `employees_ibfk_2` FOREIGN KEY (`JOB_ID`) REFERENCES `jobs` (`id`),
  CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`DEPT_ID`) REFERENCES `depts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "employees"
#

INSERT INTO `employees` VALUES (1,1,8,'爱丽丝','广州天河','13902001111','251425887@qq.com','0','1980-01-01 00:00:00','四大天王','2016-03-14 11:35:18',4400),(2,1,1,'杰克','43234','4247242','251425887@qq.com','1',NULL,NULL,'2016-03-14 11:35:18',4400),(5,1,1,'晏攀林','江西上海','15779500016','824623676@qq.com','1','2016-12-07 00:00:00','哈哈哈','2017-10-12 10:46:21',4400),(23,1,1,'ypl2','12','12','12','1','2014-12-06 00:00:00','12','2017-10-24 19:38:09',6000);

#
# Structure for table "recruits"
#

DROP TABLE IF EXISTS `recruits`;
CREATE TABLE `recruits` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `salary` double DEFAULT NULL,
  `job_id` int(11) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `demand` varchar(100) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `job_id` (`job_id`),
  KEY `dept_id` (`dept_id`),
  CONSTRAINT `recruits_ibfk_1` FOREIGN KEY (`job_id`) REFERENCES `jobs` (`id`),
  CONSTRAINT `recruits_ibfk_2` FOREIGN KEY (`dept_id`) REFERENCES `depts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

#
# Data for table "recruits"
#

INSERT INTO `recruits` VALUES (1,'2018-07-25 11:27:02',2000,2,2,2,'大学本科，计算机专业，较强的逻辑能力','招聘测试员'),(2,'2018-07-25 11:28:16',5000,1,1,6,'大学本科，计算机专业，较强的逻辑能力','招聘系统架构师'),(3,'2018-07-25 11:27:55',10000,5,2,4,'大学本科，计算机专业，较强的逻辑能力','技术总监'),(4,'2018-07-25 11:28:24',8000,3,3,4,'大学本科，计算机专业，较强的逻辑能力','前端工程师'),(5,'2018-07-26 16:00:50',6000,2,2,10,'啦啦啦','Java程序员');

#
# Structure for table "roles"
#

DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

#
# Data for table "roles"
#

INSERT INTO `roles` VALUES (1,'游客'),(2,'员工'),(3,'管理员');

#
# Structure for table "users"
#

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(100) NOT NULL DEFAULT '',
  `role_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

#
# Data for table "users"
#

INSERT INTO `users` VALUES (1,'admin','123',3),(2,'yyt','123',1),(3,'yyt1','123',1),(4,'123','321',1),(5,'qwer','123',1);

#
# Structure for table "resumes"
#

DROP TABLE IF EXISTS `resumes`;
CREATE TABLE `resumes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL DEFAULT '',
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  `job_id` int(11) NOT NULL DEFAULT '0',
  `current_job` varchar(20) DEFAULT NULL,
  `resumepage` varchar(255) NOT NULL DEFAULT '',
  `user_id` int(11) NOT NULL DEFAULT '0',
  `status` int(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `job_id` (`job_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `resumes_ibfk_1` FOREIGN KEY (`job_id`) REFERENCES `jobs` (`id`),
  CONSTRAINT `resumes_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

#
# Data for table "resumes"
#

INSERT INTO `resumes` VALUES (2,'杨玉涛','cc@163.com','17317231595','女',3,'尚未工作','',1,0),(3,'yyt','12@qq.com','17317231595','男',1,'学生','',2,0);

#
# Structure for table "interview"
#

DROP TABLE IF EXISTS `interview`;
CREATE TABLE `interview` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT 'name',
  `deliver_date` datetime NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'deliverDate',
  `look_status` int(12) NOT NULL DEFAULT '-1' COMMENT 'lookStatus',
  `interview_status` int(12) NOT NULL DEFAULT '-1' COMMENT 'interviewStatus',
  `resume_id` int(11) DEFAULT NULL,
  `recruit_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `resume_id` (`resume_id`),
  KEY `recruit_id` (`recruit_id`),
  CONSTRAINT `interview_ibfk_1` FOREIGN KEY (`resume_id`) REFERENCES `resumes` (`id`),
  CONSTRAINT `interview_ibfk_2` FOREIGN KEY (`recruit_id`) REFERENCES `recruits` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='interview';

#
# Data for table "interview"
#

INSERT INTO `interview` VALUES (1,'yyt','2018-07-26 17:46:08',1,1,3,3);

#
# Structure for table "interview_info"
#

DROP TABLE IF EXISTS `interview_info`;
CREATE TABLE `interview_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `resume_id` int(11) NOT NULL DEFAULT '0',
  `view_time` datetime DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `interview_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`),
  KEY `resume_id` (`resume_id`),
  KEY `interview_id` (`interview_id`),
  CONSTRAINT `interview_info_ibfk_2` FOREIGN KEY (`interview_id`) REFERENCES `interview` (`id`),
  CONSTRAINT `interview_info_ibfk_1` FOREIGN KEY (`resume_id`) REFERENCES `resumes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "interview_info"
#

INSERT INTO `interview_info` VALUES (1,3,'2018-07-26 17:46:16','江场',1);
