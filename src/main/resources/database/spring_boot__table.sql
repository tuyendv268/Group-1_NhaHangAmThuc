-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: spring_boot
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `_table`
--

DROP TABLE IF EXISTS `_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `_table` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` varchar(255) DEFAULT NULL,
  `table_name` varchar(255) DEFAULT NULL,
  `bill_id` bigint(20) DEFAULT NULL,
  `guest_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2ecuoq82wttgauvgi97yi42t3` (`bill_id`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `_table`
--

LOCK TABLES `_table` WRITE;
/*!40000 ALTER TABLE `_table` DISABLE KEYS */;
INSERT INTO `_table` VALUES (1,'occupied','Bàn số 01',1,'Dương Văn Tuyển','099999999'),(3,'occupied','Bàn số 02',1,'Dương Văn Tuyển','099999999'),(5,'reserved','Bàn số 03',1,'Dương Văn Tuyển','099999999'),(6,'reserved','Bàn số 04',NULL,'Nguyễn Văn A','0192947231'),(7,'reserved','Bàn số 05',NULL,'Nguyễn Văn B','012345678'),(9,'available','Bàn số 06',NULL,NULL,NULL),(11,'available','Bàn số 07',NULL,NULL,NULL),(13,'available','Bàn số 08',NULL,NULL,NULL),(14,'available','Bàn số 09',NULL,NULL,NULL),(15,'occupied','Bàn số 10',1,'Dương Văn Tuyển','099999999'),(16,'occupied','Bàn số 11',1,'Dương Văn Tuyển','099999999'),(17,'available','Bàn số 12',NULL,NULL,NULL),(18,'reserved','Bàn số 13',NULL,'Dương Văn Tuyển','0999999999'),(24,'available','Bàn số 14',NULL,NULL,NULL),(29,'available','Bàn số 15',NULL,NULL,NULL),(31,'reserved','Bàn số 16',NULL,'Dương Văn Tuyển','099999999');
/*!40000 ALTER TABLE `_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-28 11:27:31
