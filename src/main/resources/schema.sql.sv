/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : dbhomework3

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2016-11-10 15:03:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for coach
-- ----------------------------
CREATE TABLE IF NOT EXISTS  `coach` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` enum('b','f','s') DEFAULT 's',
  `capacity` int(11) DEFAULT '50',
  `trainId` int(11) DEFAULT NULL,
  `order` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `coach_train_id_fk` (`trainId`),
  CONSTRAINT `coach_train_id_fk` FOREIGN KEY (`trainId`) REFERENCES `train` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coach
-- ----------------------------

-- ----------------------------
-- Table structure for reserveseat
-- ----------------------------
CREATE TABLE IF NOT EXISTS  `reserveseat` (
  `scheduleId` int(11) NOT NULL DEFAULT '0',
  `station` varchar(20) NOT NULL DEFAULT '0',
  `order` int(11) DEFAULT NULL,
  `reserve` int(11) DEFAULT '0' COMMENT '本站预留座位',
  PRIMARY KEY (`scheduleId`,`station`),
  KEY `station_fk` (`station`),
  CONSTRAINT `remainseat_schedule_id_fk` FOREIGN KEY (`scheduleId`) REFERENCES `schedule` (`id`),
  CONSTRAINT `station_fk` FOREIGN KEY (`station`) REFERENCES `station` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reserveseat
-- ----------------------------

-- ----------------------------
-- Table structure for route
-- ----------------------------
CREATE TABLE IF NOT EXISTS  `route` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of route
-- ----------------------------

-- ----------------------------
-- Table structure for routestation
-- ----------------------------
CREATE TABLE IF NOT EXISTS  `routestation` (
  `routeId` int(11) NOT NULL,
  `order` int(11) NOT NULL,
  `day` int(11) NOT NULL DEFAULT '0',
  `departTime` datetime NOT NULL,
  `station` varchar(20) NOT NULL,
  PRIMARY KEY (`routeId`,`order`),
  KEY `routestation_station_name_fk` (`station`),
  CONSTRAINT `routeStation_route_id_fk` FOREIGN KEY (`routeId`) REFERENCES `route` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `routestation_station_name_fk` FOREIGN KEY (`station`) REFERENCES `station` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of routestation
-- ----------------------------

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
CREATE TABLE IF NOT EXISTS  `schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trainId` int(11) NOT NULL,
  `routeId` int(11) NOT NULL,
  `trainNum` varchar(20) NOT NULL,
  `departDate` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `schedule_routeId_departDate_pk` (`departDate`,`routeId`),
  UNIQUE KEY `schedule_routeId_departDate_pkkk` (`routeId`,`departDate`),
  KEY `schedule_train_id_fk` (`trainId`),
  CONSTRAINT `schedule_route_id_fk` FOREIGN KEY (`routeId`) REFERENCES `route` (`id`),
  CONSTRAINT `schedule_train_id_fk` FOREIGN KEY (`trainId`) REFERENCES `train` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule
-- ----------------------------

-- ----------------------------
-- Table structure for seat
-- ----------------------------
CREATE TABLE IF NOT EXISTS  `seat` (
  `scheduleId` int(32) NOT NULL,
  `coachOrder` int(32) NOT NULL DEFAULT '0',
  `row` int(11) NOT NULL DEFAULT '0',
  `column` enum('A','B','C','D','E','F') NOT NULL DEFAULT 'A',
  ` occupation` bit(32) NOT NULL DEFAULT b'0' COMMENT '座位占用情况,一个二进制串.假定一趟车站数不会超过32',
  UNIQUE KEY `seat_scheduleId_coachOrder_row_column_ occupation_uindex` (`scheduleId`,`coachOrder`,`row`,`column`,` occupation`),
  CONSTRAINT `seat_schedule_id_fk` FOREIGN KEY (`scheduleId`) REFERENCES `schedule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='这里的座位指的是每趟车次的座位,而不是实际的座位';

-- ----------------------------
-- Records of seat
-- ----------------------------

-- ----------------------------
-- Table structure for standingticketremain
-- ----------------------------
CREATE TABLE IF NOT EXISTS  `standingticketremain` (
  `scheduleId` int(11) NOT NULL,
  `coachId` int(11) NOT NULL,
  `remain` varchar(255) NOT NULL,
  PRIMARY KEY (`scheduleId`,`coachId`,`remain`),
  UNIQUE KEY `standingticketremain_scheduleId_coachId_remain_uindex` (`scheduleId`,`coachId`,`remain`),
  UNIQUE KEY `standingticketremain_scheduleId_coachId_aaaaaremain_uindex` (`scheduleId`,`coachId`,`remain`),
  KEY `standingticketremain_coach_id_fk` (`coachId`),
  CONSTRAINT `standingticketremain_coach_id_fk` FOREIGN KEY (`coachId`) REFERENCES `coach` (`id`),
  CONSTRAINT `standingticketremain_schedule_id_fk` FOREIGN KEY (`scheduleId`) REFERENCES `schedule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='剩余站票';

-- ----------------------------
-- Records of standingticketremain
-- ----------------------------

-- ----------------------------
-- Table structure for station
-- ----------------------------
CREATE TABLE IF NOT EXISTS  `station` (
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of station
-- ----------------------------

-- ----------------------------
-- Table structure for ticket
-- ----------------------------
CREATE TABLE IF NOT EXISTS  `ticket` (
  `userId` varchar(20) NOT NULL COMMENT '身份证号',
  `id` int(11) NOT NULL,
  `departDate` datetime NOT NULL,
  `seat` varchar(255) DEFAULT NULL,
  `startStation` varchar(255) NOT NULL,
  `endStation` varchar(255) DEFAULT NULL,
  `trainNum` varchar(255) DEFAULT NULL,
  `seatType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ticket
-- ----------------------------

-- ----------------------------
-- Table structure for train
-- ----------------------------
CREATE TABLE IF NOT EXISTS `train` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `train_name_uindex` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of train
-- ----------------------------
