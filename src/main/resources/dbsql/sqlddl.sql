CREATE DATABASE  IF NOT EXISTS `intelliclientui` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `intelliclientui`;
-- MySQL dump 10.13  Distrib 5.6.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: intelliclientui
-- ------------------------------------------------------
-- Server version	5.6.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `config_address`
--

DROP TABLE IF EXISTS `config_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config_address` (
  `id` bigint(20) NOT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `address_line1` varchar(45) DEFAULT NULL,
  `address_line2` varchar(45) DEFAULT NULL,
  `zipcode` bigint(20) DEFAULT NULL,
  `latitude` decimal(10,2) DEFAULT NULL,
  `longitude` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_address`
--

LOCK TABLES `config_address` WRITE;
/*!40000 ALTER TABLE `config_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `config_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config_parent`
--

DROP TABLE IF EXISTS `config_parent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config_parent` (
  `id` bigint(20) NOT NULL,
  `father_first_name` varchar(45) DEFAULT NULL,
  `father_last_name` varchar(45) DEFAULT NULL,
  `mother_first_name` varchar(45) DEFAULT NULL,
  `mother_last_name` varchar(45) DEFAULT NULL,
  `father_contact_no` bigint(20) DEFAULT NULL,
  `mother_contact_no` bigint(20) DEFAULT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  `father_mail_id` varchar(45) DEFAULT NULL,
  `mother_mail_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_parent_address_idx` (`address_id`),
  CONSTRAINT `fk_parent_address` FOREIGN KEY (`address_id`) REFERENCES `config_address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_parent`
--

LOCK TABLES `config_parent` WRITE;
/*!40000 ALTER TABLE `config_parent` DISABLE KEYS */;
/*!40000 ALTER TABLE `config_parent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config_pickup_point`
--

DROP TABLE IF EXISTS `config_pickup_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config_pickup_point` (
  `id` bigint(20) NOT NULL,
  `latitude` decimal(10,2) DEFAULT NULL,
  `longitude` decimal(10,2) DEFAULT NULL,
  `vehicle_id` bigint(20) DEFAULT NULL,
  `student_id` bigint(20) DEFAULT NULL,
  `pickup_point_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pickup_point_vehicle_idx` (`vehicle_id`),
  KEY `fk_pickup_pont_student_idx` (`student_id`),
  CONSTRAINT `fk_pickup_point_vehicle` FOREIGN KEY (`vehicle_id`) REFERENCES `config_vehicle` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pickup_pont_student` FOREIGN KEY (`student_id`) REFERENCES `config_student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_pickup_point`
--

LOCK TABLES `config_pickup_point` WRITE;
/*!40000 ALTER TABLE `config_pickup_point` DISABLE KEYS */;
/*!40000 ALTER TABLE `config_pickup_point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config_route`
--

DROP TABLE IF EXISTS `config_route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config_route` (
  `id` bigint(20) NOT NULL,
  `route_type` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `start_latitude` decimal(10,2) DEFAULT NULL,
  `start_longitude` decimal(10,2) DEFAULT NULL,
  `end_latitude` decimal(10,2) DEFAULT NULL,
  `end_longitude` decimal(10,2) DEFAULT NULL,
 -- `vehicle_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
 --  KEY `fk_route_vehicle_idx` (`vehicle_id`)
  -- CONSTRAINT `fk_route_vehicle` FOREIGN KEY (`vehicle_id`) REFERENCES `config_vehicle` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_route`
--

LOCK TABLES `config_route` WRITE;
/*!40000 ALTER TABLE `config_route` DISABLE KEYS */;
/*!40000 ALTER TABLE `config_route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config_student`
--

DROP TABLE IF EXISTS `config_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config_student` (
  `id` bigint(20) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `enrollment_no` bigint(20) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `observation` varchar(45) DEFAULT NULL,
  `class` int(11) DEFAULT NULL,
  `section` varchar(45) DEFAULT NULL,
  `contact_no` bigint(20) DEFAULT NULL,
  `pickup_point_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_student_parent_idx` (`parent_id`),
  KEY `fk_student_pickup_point_idx` (`pickup_point_id`),
  CONSTRAINT `fk_student_parent` FOREIGN KEY (`parent_id`) REFERENCES `config_parent` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_pickup_point` FOREIGN KEY (`pickup_point_id`) REFERENCES `config_pickup_point` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_student`
--

LOCK TABLES `config_student` WRITE;
/*!40000 ALTER TABLE `config_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `config_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config_vehicle`
--

DROP TABLE IF EXISTS `config_vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config_vehicle` (
  `id` bigint(20) NOT NULL,
  `vehicle_type` varchar(45) DEFAULT NULL,
  `vehicle_no` varchar(45) DEFAULT NULL,
  `route_id` bigint(20) DEFAULT NULL,
  `over_speeding` char(1) DEFAULT NULL,
  `on_route` char(1) DEFAULT NULL,
  `is_delay` char(1) DEFAULT NULL,
  `current_latitude` decimal(10,2) DEFAULT NULL,
  `current_longitude` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_vehicle_route_idx` (`route_id`),
  CONSTRAINT `fk_vehicle_route` FOREIGN KEY (`route_id`) REFERENCES `config_route` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_vehicle`
--

LOCK TABLES `config_vehicle` WRITE;
/*!40000 ALTER TABLE `config_vehicle` DISABLE KEYS */;
/*!40000 ALTER TABLE `config_vehicle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-09 21:26:18
