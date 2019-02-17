
-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 23, 2017 at 01:54 PM
-- Server version: 10.1.20-MariaDB
-- PHP Version: 5.2.17

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `u173800516_ivv`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`u173800516_mouni`@`localhost` PROCEDURE `prcDeleteRoute`(
_sessionID VARCHAR(50))
BEGIN
  DELETE FROM gpslocations
  WHERE sessionID = _sessionID;
END$$

CREATE DEFINER=`u173800516_mouni`@`localhost` PROCEDURE `prcGetAllRoutesForMap`()
BEGIN
SELECT sessionId, gpsTime, CONCAT('{ "latitude":"', CAST(latitude AS CHAR),'", "longitude":"', CAST(longitude AS CHAR), '", "speed":"', CAST(speed AS CHAR), '", "direction":"', CAST(direction AS CHAR), '", "distance":"', CAST(distance AS CHAR), '", "locationMethod":"', locationMethod, '", "gpsTime":"', DATE_FORMAT(gpsTime, '%b %e %Y %h:%i%p'), '", "userName":"', userName, '", "phoneNumber":"', phoneNumber, '", "sessionID":"', CAST(sessionID AS CHAR), '", "accuracy":"', CAST(accuracy AS CHAR), '", "extraInfo":"', extraInfo, '" }') json
FROM (SELECT MAX(GPSLocationID) ID
      FROM gpslocations
      WHERE sessionID != '0' && CHAR_LENGTH(sessionID) != 0 && gpstime != '0000-00-00 00:00:00'
      GROUP BY sessionID) AS MaxID
JOIN gpslocations ON gpslocations.GPSLocationID = MaxID.ID
ORDER BY gpsTime;
END$$

CREATE DEFINER=`u173800516_mouni`@`localhost` PROCEDURE `prcGetRouteForMap`(
_sessionID VARCHAR(50)CHARACTER SET utf8)
BEGIN
  SELECT CONCAT('{ "latitude":"', CAST(latitude AS CHAR),'", "longitude":"', CAST(longitude AS CHAR), '", "speed":"', CAST(speed AS CHAR), '", "direction":"', CAST(direction AS CHAR), '", "distance":"', CAST(distance AS CHAR), '", "locationMethod":"', locationMethod, '", "gpsTime":"', DATE_FORMAT(gpsTime, '%b %e %Y %h:%i%p'), '", "userName":"', userName, '", "phoneNumber":"', phoneNumber, '", "sessionID":"', CAST(sessionID AS CHAR), '", "accuracy":"', CAST(accuracy AS CHAR), '", "extraInfo":"', extraInfo, '" }') json
  FROM gpslocations
  WHERE sessionID = _sessionID
  ORDER BY lastupdate;
END$$

CREATE DEFINER=`u173800516_mouni`@`localhost` PROCEDURE `prcGetRoutes`()
BEGIN
  CREATE TEMPORARY TABLE tempRoutes (
    sessionID VARCHAR(50) CHARACTER SET utf8 NOT NULL,
    userName VARCHAR(50) CHARACTER SET utf8 NOT NULL,
    startTime DATETIME,
    endTime DATETIME)
  ENGINE = MEMORY;

  INSERT INTO tempRoutes (sessionID, userName)
  SELECT DISTINCT sessionID, userName
  FROM gpslocations;

  UPDATE tempRoutes tr
  SET startTime = (SELECT MIN(gpsTime) FROM gpslocations gl
  WHERE gl.sessionID = tr.sessionID
  AND gl.userName = tr.userName);

  UPDATE tempRoutes tr
  SET endTime = (SELECT MAX(gpsTime) FROM gpslocations gl
  WHERE gl.sessionID = tr.sessionID
  AND gl.userName = tr.userName);

  SELECT

  CONCAT('{ "sessionID": "', CAST(sessionID AS CHAR),  '", "userName": "', userName, '", "times": "(', DATE_FORMAT(startTime, '%b %e %Y %h:%i%p'), ' - ', DATE_FORMAT(endTime, '%b %e %Y %h:%i%p'), ')" }') json
  FROM tempRoutes
  ORDER BY startTime DESC;

  DROP TABLE tempRoutes;
END$$

CREATE DEFINER=`u173800516_mouni`@`localhost` PROCEDURE `prcSaveGPSLocation`(
_latitude DECIMAL(10,7),
_longitude DECIMAL(10,7),
_speed INT(10),
_direction INT(10),
_distance DECIMAL(10,1),
_date TIMESTAMP,
_locationMethod VARCHAR(50) CHARACTER SET utf8,
_userName VARCHAR(50) CHARACTER SET utf8,
_phoneNumber VARCHAR(50) CHARACTER SET utf8,
_sessionID VARCHAR(50) CHARACTER SET utf8,
_accuracy INT(10),
_extraInfo VARCHAR(255) CHARACTER SET utf8,
_eventType VARCHAR(50) CHARACTER SET utf8
)
BEGIN
   INSERT INTO gpslocations (latitude, longitude, speed, direction, distance, gpsTime, locationMethod, userName, phoneNumber,  sessionID, accuracy, extraInfo, eventType)
   VALUES (_latitude, _longitude, _speed, _direction, _distance, _date, _locationMethod, _userName, _phoneNumber, _sessionID, _accuracy, _extraInfo, _eventType);
   SELECT NOW();
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `gpslocations`
--

CREATE TABLE IF NOT EXISTS `gpslocations` (
  `GPSLocationID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `lastUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `latitude` decimal(10,7) NOT NULL DEFAULT '0.0000000',
  `longitude` decimal(10,7) NOT NULL DEFAULT '0.0000000',
  `phoneNumber` varchar(50) NOT NULL DEFAULT '',
  `userName` varchar(50) NOT NULL DEFAULT '',
  `sessionID` varchar(50) NOT NULL DEFAULT '',
  `speed` int(10) unsigned NOT NULL DEFAULT '0',
  `direction` int(10) unsigned NOT NULL DEFAULT '0',
  `distance` decimal(10,1) NOT NULL DEFAULT '0.0',
  `gpsTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `locationMethod` varchar(50) NOT NULL DEFAULT '',
  `accuracy` int(10) unsigned NOT NULL DEFAULT '0',
  `extraInfo` varchar(255) NOT NULL DEFAULT '',
  `eventType` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`GPSLocationID`),
  KEY `sessionIDIndex` (`sessionID`),
  KEY `phoneNumberIndex` (`phoneNumber`),
  KEY `userNameIndex` (`userName`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1003 ;

--
-- Dumping data for table `gpslocations`
--

INSERT INTO `gpslocations` (`GPSLocationID`, `lastUpdate`, `latitude`, `longitude`, `phoneNumber`, `userName`, `sessionID`, `speed`, `direction`, `distance`, `gpsTime`, `locationMethod`, `accuracy`, `extraInfo`, `eventType`) VALUES
(990, '2017-03-06 03:21:25', '13.0131904', '80.2389843', '', 'Omr-7845639909', '38168974-0b31-4b4f-878a-d1cf6fcce18f', 0, 0, '0.0', '2017-03-06 13:49:47', 'fused', 65, '0', 'android'),
(991, '2017-03-06 03:22:22', '13.0132970', '80.2390621', '', 'Adyar-9176477581', '04cc8e54-80c8-49e1-8a33-b7e4ec7f03da', 0, 0, '0.0', '2017-03-06 13:50:54', 'fused', 13, '-131', 'android'),
(992, '2017-03-06 03:23:03', '13.0131835', '80.2389712', '', 'Adyar-9176477581', '8aedec7f-b301-4275-b442-37c22c1067c4', 0, 0, '0.0', '2017-03-06 13:51:31', 'fused', 77, '0', 'android'),
(993, '2017-03-06 03:23:33', '13.0131835', '80.2389712', '', 'Vadapalani-9841805656', 'bc6c4993-5327-47f4-a20e-94ef4722da02', 0, 0, '0.0', '2017-03-06 13:52:01', 'fused', 76, '0', 'android'),
(994, '2017-03-06 03:24:31', '13.0131835', '80.2389712', '', 'Vadapalani-9841805656', 'bc6c4993-5327-47f4-a20e-94ef4722da02', 0, 0, '0.0', '2017-03-06 13:53:00', 'fused', 76, '0', 'android'),
(995, '2017-03-16 02:55:37', '12.8407956', '79.9466553', '', 'Oragadam-9176477581', '9e5c43e4-6c1e-4087-959c-673eec93ec93', 0, 0, '0.0', '2017-03-16 12:24:00', 'fused', 121, '0', 'android'),
(996, '2017-03-17 12:29:19', '12.9464479', '80.2395972', '', 'Oragadam-9176477581', '9e5c43e4-6c1e-4087-959c-673eec93ec93', 0, 0, '21.1', '2017-03-17 21:57:28', 'fused', 22, '-259', 'android'),
(997, '2017-03-17 12:29:42', '12.9464334', '80.2395751', '', 'Oragadam-9176477581', '9e5c43e4-6c1e-4087-959c-673eec93ec93', 0, 0, '21.1', '2017-03-17 21:58:02', 'fused', 13, '-291', 'android'),
(998, '2017-03-17 12:30:44', '12.9464301', '80.2395432', '', 'Oragadam-9176477581', '9e5c43e4-6c1e-4087-959c-673eec93ec93', 0, 0, '21.1', '2017-03-17 21:59:06', 'fused', 9, '-272', 'android'),
(999, '2017-03-17 13:32:28', '13.0073130', '80.2583701', '', 'Oragadam-9176477581', '9e5c43e4-6c1e-4087-959c-673eec93ec93', 12, 53, '25.8', '2017-03-17 23:00:50', 'fused', 16, '-298', 'android'),
(1000, '2017-03-17 13:33:24', '13.0113323', '80.2590814', '', 'Oragadam-9176477581', '9e5c43e4-6c1e-4087-959c-673eec93ec93', 23, 0, '26.1', '2017-03-17 23:01:46', 'fused', 9, '-285', 'android'),
(1001, '2017-03-17 13:34:26', '13.0132642', '80.2590862', '', 'Oragadam-9176477581', '9e5c43e4-6c1e-4087-959c-673eec93ec93', 0, 0, '26.3', '2017-03-17 23:02:48', 'fused', 19, '-298', 'android'),
(1002, '2017-03-17 14:02:24', '13.0343036', '80.2736189', '', 'Oragadam-9176477581', '9e5c43e4-6c1e-4087-959c-673eec93ec93', 0, 36, '28.8', '2017-03-17 23:30:46', 'fused', 29, '-216', 'android');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
