-- MariaDB dump 10.19  Distrib 10.5.15-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: hoteliers
-- ------------------------------------------------------
-- Server version	10.5.15-MariaDB-0+deb11u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP DATABASE IF EXISTS `hoteliers`;
CREATE DATABASE `hoteliers`;
USE `hoteliers`;

--
-- Table structure for table `addresses`
--

DROP TABLE IF EXISTS `addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `addresses` (
  `addressId` int(11) NOT NULL,
  `addressBuilding` varchar(255) NOT NULL,
  `addressCity` varchar(255) NOT NULL,
  `addressCode` varchar(255) DEFAULT NULL,
  `addressFlat` varchar(255) DEFAULT NULL,
  `addressStreet` varchar(255) NOT NULL,
  PRIMARY KEY (`addressId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` VALUES (21,'13b','Rotten Hole','123',NULL,'Sad Lane'),(22,'17','Rotten Hole','443',NULL,'Sad Lane'),(23,'81','Houndsditch','707',NULL,'Zombie Street'),(24,'115','Houndsditch','238',NULL,'Crude Street'),(25,'3','Houndsditch','456',NULL,'Hells Corner'),(26,'73','Neverville','506',NULL,'Lost Avenue'),(27,'25','Neverville','777',NULL,'Lost Avenue'),(28,'11d','Neverville','745',NULL,'Sad Square'),(29,'79','Neverville','687',NULL,'Sad Square'),(30,'11','Faketown','903',NULL,'Narrow Lane'),(31,'2','Faketown','345',NULL,'Karl Marx Corner'),(32,'12','Faketown',NULL,NULL,'Karl Marx Corner'),(33,'172','Faketown','122',NULL,'Dead Crow Street'),(34,'2','Faketown',NULL,NULL,'Dead Crow Street'),(35,'65a','Faketown','988',NULL,'Dead Crow Street'),(36,'6','Dry Creek',NULL,NULL,'Alfred Hitchcock Lane'),(37,'90','Dry Creek','105',NULL,'Alfred Hitchcock Lane'),(38,'77','Dry Creek','552',NULL,'Negroes Place'),(39,'7','Dry Creek','656',NULL,'Feminism Street');
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `branches`
--

DROP TABLE IF EXISTS `branches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `branches` (
  `branchId` int(11) NOT NULL,
  `branchName` varchar(255) NOT NULL,
  `addressId` int(11) DEFAULT NULL,
  `branchCompany_companyId` int(11) NOT NULL,
  PRIMARY KEY (`branchId`),
  KEY `FK8i62eib7ty36r7vu6pjre052l` (`addressId`),
  KEY `FK475h2w8v9e6qkh6anenp7fd3u` (`branchCompany_companyId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branches`
--

LOCK TABLES `branches` WRITE;
/*!40000 ALTER TABLE `branches` DISABLE KEYS */;
INSERT INTO `branches` VALUES (8,'Special Store',27,1),(9,'Special Store',28,1),(10,'Underground Store',29,1),(11,'Rubbish Store',30,1),(12,'Suspicious Shop',31,2),(13,'Stale Cookies',32,2),(14,'Smuggled Thingies',33,2),(15,'Whatever Branch',34,3),(16,'Unusual Branch',35,3),(17,'Black Branch',36,3),(18,'Horrendous Branch',37,3),(19,'Small Tricks',38,5),(20,'Massive Humbugs',39,5);
/*!40000 ALTER TABLE `branches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `companies`
--

DROP TABLE IF EXISTS `companies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `companies` (
  `companyId` int(11) NOT NULL,
  `companyKind` varchar(255) DEFAULT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  `addressId` int(11) DEFAULT NULL,
  PRIMARY KEY (`companyId`),
  KEY `FKiyfj7eobbgbq7o6t517l9ourb` (`addressId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companies`
--

LOCK TABLES `companies` WRITE;
/*!40000 ALTER TABLE `companies` DISABLE KEYS */;
INSERT INTO `companies` VALUES (1,'OOO','Mad Bankrupts',21),(2,'IP','Jolly Whale',22),(3,'OOO','Mad Bankrupts',23),(4,'IP','Lone Toiler',24),(5,'OAO','Cute Crooks Co.',25),(6,'IP','Jolly Whale',26),(7,'OOO','Great Swindlers Ltd.',NULL);
/*!40000 ALTER TABLE `companies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (40),(40),(40);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-26  2:26:55
