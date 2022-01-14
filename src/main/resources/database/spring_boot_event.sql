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
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `discount_rate` int(11) DEFAULT NULL,
  `event_name` varchar(255) DEFAULT NULL,
  `time_end` datetime DEFAULT NULL,
  `time_start` datetime DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `is_displayed` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'ông công ông táo ',50,'Ngày Ông Công Ông Táo','2022-01-26 22:35:00','2022-01-23 00:35:00','ong_cong_ong_tao.jpg',_binary '\0'),(2,'kỉ niệm ngày thương binh liệt sĩ',50,'Kỉ Niệm Ngày Thương Binh Liệt Sĩ','2022-07-28 22:37:00','2022-07-27 22:37:00','27-7.jpg',_binary '\0'),(3,'free tất',50,'Kỉ Niệm Ngày Thành Lập Trường BKHN','2022-10-15 12:34:00','2022-10-15 00:00:00','bka.jpg',_binary '\0'),(4,'Kỉ Niệm Ngày Lễ Valentine',50,'Kỉ Niệm Ngày Lễ Valentine','2022-02-15 22:38:00','2022-02-14 22:38:00','valentine.png',_binary '\0'),(5,'Kỉ Niệm Ngày Lễ Valentine Trắng',50,'Kỉ Niệm Ngày Lễ Valentine Trắng','2022-03-15 22:39:00','2022-03-14 22:39:00','white-valentine.jpg',_binary '\0'),(6,'Tất Niên',50,'Tất Niên','2022-01-21 22:40:00','2022-01-20 22:40:00','tat-nien.jpg',_binary '\0');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-14 22:43:47
