<<<<<<< HEAD
/*
Navicat MySQL Data Transfer

Source Server         : funintestlocal
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : thermodetector

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-01-10 18:38:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'admin');
INSERT INTO `sys_user` VALUES ('2', '111', '111');
=======
# Host: 127.0.0.1  (Version: 5.0.18-nt)
# Date: 2018-01-14 22:39:40
# Generator: MySQL-Front 5.3  (Build 4.214)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "sys_height"
#

DROP TABLE IF EXISTS `sys_height`;
CREATE TABLE `sys_height` (
  `Id` int(11) NOT NULL auto_increment,
  `height` varchar(11) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sys_height"
#

INSERT INTO `sys_height` VALUES (1,'005'),(2,'025'),(3,'045'),(4,'065'),(5,'085'),(6,'105'),(7,'125'),(8,'145'),(9,'165');

#
# Structure for table "sys_therinf"
#

DROP TABLE IF EXISTS `sys_therinf`;
CREATE TABLE `sys_therinf` (
  `Id` int(11) NOT NULL auto_increment,
  `time_id` int(11) default NULL,
  `height_id` int(11) default NULL,
  `south3` varchar(255) default NULL,
  `south2` varchar(255) default NULL,
  `south1` varchar(255) default NULL,
  `core` varchar(255) default NULL,
  `north1` varchar(255) default NULL,
  `north2` varchar(255) default NULL,
  `north3` varchar(255) default NULL,
  `east3` varchar(255) default NULL,
  `east2` varchar(255) default NULL,
  `east1` varchar(255) default NULL,
  `west1` varchar(255) default NULL,
  `west2` varchar(255) default NULL,
  `west3` varchar(255) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sys_therinf"
#

INSERT INTO `sys_therinf` VALUES (1,1,1,'99.9','113.7','126.8','127.4','126.6','105.6','121.0','101.5','114.1','124.0','123.5','116.0','103.1'),(2,1,2,'101.6','135.5','159.9','154.0','148.0','128.6','101.4','105.2','136.2','156.2','151.8','130.7','101.9'),(3,1,3,'100.9','118.2','128.7','126.1','117.6','110.7','100.9','101.1','115.9','124.1','121.8','114.6','101.4');

#
# Structure for table "sys_time"
#

DROP TABLE IF EXISTS `sys_time`;
CREATE TABLE `sys_time` (
  `Id` int(11) NOT NULL auto_increment,
  `time` varchar(255) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sys_time"
#

INSERT INTO `sys_time` VALUES (1,'20120807071941'),(2,'20130807071941'),(3,'20140807071941');

#
# Structure for table "sys_user"
#

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "sys_user"
#

INSERT INTO `sys_user` VALUES (1,'admin','admin'),(2,'111','111');

>>>>>>> remotes/origin/master
