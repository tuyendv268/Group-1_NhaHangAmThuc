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
  `expired_time` time DEFAULT NULL,
  `ordered_time` time DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2ecuoq82wttgauvgi97yi42t3` (`bill_id`)
) ENGINE=MyISAM AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `_table`
--

LOCK TABLES `_table` WRITE;
/*!40000 ALTER TABLE `_table` DISABLE KEYS */;
INSERT INTO `_table` VALUES (1,'occupied','Bàn số 01',2,'Phạm Bá Chinh','0999999999','21:56:16','21:26:16'),(2,'occupied','Bàn số 02',2,'Phạm Bá Chinh','0999999999','21:56:16','21:26:16'),(3,'occupied','Bàn số 03',2,'Phạm Bá Chinh','0999999999','21:56:16','21:26:16'),(4,'occupied','Bàn số 04',2,'Phạm Bá Chinh','0999999999','00:31:05','00:01:05'),(5,'available','Bàn số 05',NULL,'Lê Văn Đức','0999999999',NULL,NULL),(6,'available','Bàn số 06',NULL,'Lê Văn Đức','0999999999',NULL,NULL),(7,'available','Bàn số 07',NULL,'Lê Văn Đức','0999999999',NULL,NULL),(9,'occupied','Bàn số 09',NULL,'Nguyễn Văn A','0999999999','23:22:43','22:52:43'),(10,'occupied','Bàn số 10',1,'Dương Văn Tuyển','0999999999','23:34:53','23:04:53'),(49,'available','Bàn số 12',NULL,NULL,NULL,NULL,NULL),(50,'available','Bàn số 13',NULL,NULL,NULL,NULL,NULL),(51,'available','Bàn số 14',NULL,NULL,NULL,NULL,NULL),(52,'available','Bàn số 15',NULL,NULL,NULL,NULL,NULL),(53,'available','Bàn Số 16',NULL,NULL,NULL,NULL,NULL),(54,'available','Bàn số 17',NULL,NULL,NULL,NULL,NULL),(55,'available','Bàn số 18',NULL,NULL,NULL,NULL,NULL),(56,'available','Bàn số 19',NULL,NULL,NULL,NULL,NULL),(57,'available','Bàn số 20',NULL,NULL,NULL,'22:35:46','22:05:46'),(58,'available','Bàn số 21',NULL,NULL,NULL,NULL,NULL),(59,'available','Bàn số 22',NULL,NULL,NULL,NULL,NULL),(60,'available','Bàn số 23',NULL,NULL,NULL,NULL,NULL),(61,'available','Bàn số 24',NULL,NULL,NULL,'00:12:21','23:42:21'),(62,'available','Bàn số 25',NULL,NULL,NULL,NULL,NULL),(63,'available','Bàn số 26',NULL,NULL,NULL,NULL,NULL),(64,'available','Bàn số 27',NULL,NULL,NULL,NULL,NULL),(65,'available','Bàn số 28',NULL,NULL,NULL,NULL,NULL),(66,'available','Bàn số 29',NULL,NULL,NULL,NULL,NULL),(67,'available','Bàn số 30',NULL,NULL,NULL,NULL,NULL),(68,'available','Bàn số 31',NULL,NULL,NULL,NULL,NULL),(69,'available','Bàn số 32',NULL,NULL,NULL,NULL,NULL),(70,'available','Bàn số 33',NULL,NULL,NULL,NULL,NULL),(71,'available','Bàn số 34',NULL,NULL,NULL,NULL,NULL),(72,'available','Bàn số 35',NULL,NULL,NULL,NULL,NULL),(73,'available','Bàn số 36',NULL,NULL,NULL,NULL,NULL),(74,'available','Bàn số 37',NULL,NULL,NULL,NULL,NULL),(75,'available','Bàn số 38',NULL,NULL,NULL,NULL,NULL),(76,'available','Bàn số 39',NULL,NULL,NULL,NULL,NULL),(77,'available','Bàn số 40',NULL,NULL,NULL,'00:17:07','23:47:07'),(78,'available','Bàn số 41',NULL,NULL,NULL,NULL,NULL);
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

-- Dump completed on 2022-01-16 23:25:58
