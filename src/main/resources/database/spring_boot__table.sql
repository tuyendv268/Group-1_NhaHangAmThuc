-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: spring_boot
-- ------------------------------------------------------
-- Server version	8.0.27

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
  `id` bigint NOT NULL AUTO_INCREMENT,
  `status` varchar(255) DEFAULT NULL,
  `table_name` varchar(255) DEFAULT NULL,
  `bill_id` bigint DEFAULT NULL,
  `guest_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2ecuoq82wttgauvgi97yi42t3` (`bill_id`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `_table`
--

LOCK TABLES `_table` WRITE;
/*!40000 ALTER TABLE `_table` DISABLE KEYS */;
INSERT INTO `_table` VALUES (1,'occupied','Bàn số 01',1,'Trương Vô Kỵ','0123654987'),(2,'occupied','Bàn số 02',2,'David Villa','0886688668'),(3,'reserved','Bàn số 03',3,'Âu Dương Phong','0123456987'),(4,'reserved','Bàn số 04',NULL,'Nguyễn Văn A','0192947231'),(5,'reserved','Bàn số 05',NULL,'Nguyễn Văn B','0123456789'),(6,'available','Bàn số 06',NULL,NULL,NULL),(7,'available','Bàn số 07',NULL,NULL,NULL),(8,'available','Bàn số 08',NULL,NULL,NULL),(9,'available','Bàn số 09',NULL,NULL,NULL),(10,'occupied','Bàn số 10',4,'Đông Tà','0987456321'),(11,'occupied','Bàn số 11',5,'Lâm Xung','0345657467'),(12,'available','Bàn số 12',NULL,NULL,NULL),(13,'reserved','Bàn số 13',NULL,'Thúy Kiều','0666666666'),(14,'reserved','Bàn số 14',NULL,'Tòng Thị Nữ','0767876479'),(15,'available','Bàn số 15',NULL,NULL,NULL),(16,'reserved','Bàn số 16',NULL,'Trần Đức Dần','0999999998');
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

-- Dump completed on 2022-01-08 20:31:45
