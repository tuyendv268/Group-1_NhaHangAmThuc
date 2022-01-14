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
) ENGINE=MyISAM AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `_table`
--

LOCK TABLES `_table` WRITE;
/*!40000 ALTER TABLE `_table` DISABLE KEYS */;
INSERT INTO `_table` VALUES (1,'occupied','Bàn số 01',2,'Phạm Bá Chinh','0999999999','21:56:16','21:26:16'),(2,'occupied','Bàn số 02',2,'Phạm Bá Chinh','0999999999','21:56:16','21:26:16'),(3,'occupied','Bàn số 03',2,'Phạm Bá Chinh','0999999999','21:56:16','21:26:16'),(4,'occupied','Bàn số 04',2,'Phạm Bá Chinh','0999999999','00:31:05','00:01:05'),(5,'occupied','Bàn số 05',8,'Lê Văn Đức','0999999999',NULL,NULL),(6,'occupied','Bàn số 06',8,'Lê Văn Đức','0999999999',NULL,NULL),(7,'occupied','Bàn số 07',8,'Lê Văn Đức','0999999999',NULL,NULL),(8,'occupied','Bàn số 08',13,'Dương Văn Tuyển','0999999999','23:27:16','22:57:16'),(9,'occupied','Bàn số 09',NULL,'Nguyễn Văn A','0999999999','23:22:43','22:52:43'),(10,'occupied','Bàn số 10',1,'Dương Văn Tuyển','0999999999','23:34:53','23:04:53'),(12,'occupied','Bàn số 11',13,'Dương Văn Tuyển','0999999999','23:27:22','22:57:22'),(13,'occupied','Bàn số 12',15,'Nguyễn Văn B','0999999999','23:27:27','22:57:27'),(14,'occupied','Bàn số 13',15,'Nguyễn Văn B','0999999999','23:27:39','22:57:39'),(15,'occupied','Bàn số 14',14,'Dương Văn Tuyển','0999999999',NULL,NULL),(16,'occupied','Bàn số 15',16,'Dương Văn Tuyển','0999999991','23:46:33','23:16:33'),(34,'occupied','Bàn Số 16',13,'Dương Văn Tuyển','0999999999',NULL,NULL),(35,'occupied','Bàn số 17',13,'Dương Văn Tuyển','0999999999',NULL,NULL),(37,'occupied','Bàn số 18',19,'1','1',NULL,NULL),(38,'occupied','Bàn số 19',19,'1','1',NULL,NULL),(39,'available','Bàn số 20',NULL,NULL,NULL,NULL,NULL),(40,'available','Bàn số 21',NULL,NULL,NULL,NULL,NULL),(41,'occupied','Bàn số 22',21,'Lê Văn Đức','0999999999',NULL,NULL),(42,'occupied','Bàn số 23',18,'Chủ tịch Tung Của','Số điện thoại của Quần Ngọc Các',NULL,NULL),(43,'available','Bàn số 24',NULL,NULL,NULL,NULL,NULL),(44,'available','Bàn số 25',NULL,NULL,NULL,NULL,NULL),(45,'available','Bàn số 26',NULL,NULL,NULL,NULL,NULL),(46,'occupied','Bàn số 27',17,'Anh bán đồ chơi tóc cam đầu ngõ','Số điện thoại của người Nga',NULL,NULL),(47,'available','Bàn số 28',NULL,NULL,NULL,NULL,NULL);
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

-- Dump completed on 2022-01-14  0:33:34
