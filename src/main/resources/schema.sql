CREATE TABLE IF NOT EXISTS coach
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    type ENUM('b', 'f', 's') DEFAULT 's',
    `column` INT(11) NOT NULL,
    row INT(11) NOT NULL,
    trainId INT(11),
    `order` INT(11) DEFAULT '0'
);
CREATE TABLE IF NOT EXISTS reserveseat
(
    scheduleId INT(11) DEFAULT '0' NOT NULL,
    station VARCHAR(20) DEFAULT '0' NOT NULL,
    `order` INT(11),
    reserve INT(11) DEFAULT '0' COMMENT '本站预留座位',
    CONSTRAINT `PRIMARY` PRIMARY KEY (scheduleId, station)
);
CREATE TABLE IF NOT EXISTS route
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT
);
CREATE TABLE IF NOT EXISTS routestation
(
    id INT(32) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    routeId INT(11) DEFAULT '0' NOT NULL,
    `order` INT(11) NOT NULL,
    day INT(11) DEFAULT '0' NOT NULL,
    departTime TIME NOT NULL,
    station VARCHAR(20) NOT NULL
);
CREATE TABLE IF NOT EXISTS schedule
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    trainId INT(11) NOT NULL,
    routeId INT(11) NOT NULL,
    trainNum VARCHAR(20) NOT NULL,
    departDate DATETIME NOT NULL
);
CREATE TABLE IF NOT EXISTS seat
(
    scheduleId INT(32) NOT NULL,
    coachOrder INT(32) DEFAULT '0' NOT NULL,
    row INT(11) DEFAULT '0' NOT NULL,
    `column` ENUM('A', 'B', 'C', 'D', 'E', 'F') DEFAULT 'A' NOT NULL,
    `occupation` BIT(32) DEFAULT b'0' NOT NULL COMMENT '座位占用情况,一个二进制串.假定一趟车站数不会超过32',
    CONSTRAINT `PRIMARY` PRIMARY KEY (scheduleId, coachOrder, row, `column`, occupation)
);
CREATE TABLE IF NOT EXISTS standingticketremain
(
    scheduleId INT(11) NOT NULL,
    coachId INT(11) NOT NULL,
    remain VARCHAR(255) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (scheduleId, coachId, remain)
);
CREATE TABLE IF NOT EXISTS station
(
    name VARCHAR(20) PRIMARY KEY NOT NULL
);
CREATE TABLE IF NOT EXISTS train
(
    id INT(32) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS ticket
(
    userId VARCHAR(20) NOT NULL COMMENT '身份证号',
    id INT(11) PRIMARY KEY NOT NULL,
    departDate DATETIME NOT NULL,
    seat VARCHAR(255),
    startStation VARCHAR(255) NOT NULL,
    endStation VARCHAR(255),
    trainNum VARCHAR(255),
    seatType VARCHAR(255)
);
# ALTER TABLE coach ADD FOREIGN KEY (trainId) REFERENCES train (id) ON DELETE SET NULL ON UPDATE CASCADE;
# CREATE INDEX coach_train_id_fk ON coach (trainId);
# ALTER TABLE reserveseat ADD FOREIGN KEY (scheduleId) REFERENCES schedule (id);
# ALTER TABLE reserveseat ADD FOREIGN KEY (station) REFERENCES station (name);
# CREATE INDEX station_fk ON reserveseat (station);
# ALTER TABLE routestation ADD FOREIGN KEY (routeId) REFERENCES route (id) ON DELETE CASCADE ON UPDATE CASCADE;
# ALTER TABLE routestation ADD FOREIGN KEY (station) REFERENCES station (name);
# CREATE INDEX routeStation_route_id_fk ON routestation (routeId);
# CREATE INDEX routestation_station_name_fk ON routestation (station);
# ALTER TABLE schedule ADD FOREIGN KEY (trainId) REFERENCES train (id);
# ALTER TABLE schedule ADD FOREIGN KEY (routeId) REFERENCES route (id);
# CREATE UNIQUE INDEX schedule_routeId_departDate_pk ON schedule (departDate, routeId);
# CREATE UNIQUE INDEX schedule_routeId_departDate_pkkk ON schedule (routeId, departDate);
# CREATE INDEX schedule_train_id_fk ON schedule (trainId);
# ALTER TABLE standingticketremain ADD FOREIGN KEY (scheduleId) REFERENCES schedule (id);
# ALTER TABLE standingticketremain ADD FOREIGN KEY (coachId) REFERENCES coach (id);
# CREATE INDEX standingticketremain_coach_id_fk ON standingticketremain (coachId);
# CREATE UNIQUE INDEX standingticketremain_scheduleId_coachId_remain_uindex ON standingticketremain (scheduleId, coachId, remain);
# CREATE UNIQUE INDEX train_name_uindex ON train (name);