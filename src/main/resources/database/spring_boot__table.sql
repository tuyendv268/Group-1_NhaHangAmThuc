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
  `expired_time` time DEFAULT NULL,
  `ordered_time` time DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2ecuoq82wttgauvgi97yi42t3` (`bill_id`)
) ENGINE=MyISAM AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `_table`
--

LOCK TABLES `_table` WRITE;
/*!40000 ALTER TABLE `_table` DISABLE KEYS */;
INSERT INTO `_table` VALUES (1,'occupied','Bàn số 01',2,'Phạm Bá Chinh','0999999999','21:56:16','21:26:16'),(2,'occupied','Bàn số 02',2,'Phạm Bá Chinh','0999999999','21:56:16','21:26:16'),(3,'occupied','Bàn số 03',2,'Phạm Bá Chinh','0999999999','21:56:16','21:26:16'),(4,'occupied','Bàn số 04',2,'Phạm Bá Chinh','0999999999','00:31:05','00:01:05'),(5,'available','Bàn số 05',NULL,NULL,NULL,NULL,NULL),(6,'available','Bàn số 06',NULL,NULL,NULL,'22:28:19','21:58:19'),(7,'available','Bàn số 07',NULL,NULL,NULL,'22:28:27','21:58:27'),(8,'available','Bàn số 08',NULL,NULL,NULL,NULL,NULL),(9,'reserved','Bàn số 09',NULL,'Dương Văn Tuyển','0999999999','13:40:04','13:10:04'),(10,'available','Bàn số 10',1,NULL,NULL,NULL,NULL),(12,'available','Bàn số 11',NULL,NULL,NULL,'00:42:22','00:12:22'),(13,'available','Bàn số 12',NULL,NULL,NULL,'00:46:56','00:16:56'),(14,'available','Bàn số 13',NULL,NULL,NULL,'21:56:16','21:26:16'),(15,'available','Bàn số 14',NULL,NULL,NULL,'00:32:47','00:02:47'),(16,'available','Bàn số 15',NULL,NULL,NULL,'00:42:29','00:12:29'),(34,'occupied','Bàn Số 16',3,'Lê Văn Đức','0999999999','00:46:44','00:16:44'),(35,'reserved','Bàn số 17',NULL,'Lê Văn Đức','0999999999','13:26:23','12:56:23');
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

-- Dump completed on 2022-01-10 14:14:32
