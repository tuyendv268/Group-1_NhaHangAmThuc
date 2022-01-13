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
-- Table structure for table `dish`
--

DROP TABLE IF EXISTS `dish`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dish` (
  `id` bigint(20) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `dish_name` varchar(255) DEFAULT NULL,
  `feature_dish` int(11) DEFAULT NULL,
  `ingredient` varchar(255) DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dish`
--

LOCK TABLES `dish` WRITE;
/*!40000 ALTER TABLE `dish` DISABLE KEYS */;
INSERT INTO `dish` VALUES (1,'Khai vị','2021-10-01 00:00:00','Salad rau củ tươi','Salad',1,'Xà lách, dưa chuột, cà chua, sốt mayone',NULL,200000,1,'dish01.jpg'),(2,'Món Chính','2021-10-01 00:00:00','Sashimi cá ngừ Nhật tươi mới','Sashimi',1,'Cá ngừ, Cá tầm, Rong biển,...',NULL,800000,1,'dish02.jpg'),(3,'Món tráng miệng','2021-10-01 00:00:00','Kem tươi + dâu tây tươi','Kem',1,'Kem tươi, cốm màu, dâu tây,...',NULL,300000,1,'dish03.jpg'),(4,'Món Chính','2021-10-01 00:00:00','Cá basa tươi, trứng cuộn, canh rong biển','Bento',1,'Gạo tám thơm, Cá basa, Trứng gà, Rong biển,...',NULL,1200000,1,'dish04.jpg'),(5,'Món tráng','2021-10-01 00:00:00','Hoa quả cắt','Fruit',1,'Dưa hấu, Kiwi, Việt Quất,...',NULL,400000,1,'dish05.jpg');
/*!40000 ALTER TABLE `dish` ENABLE KEYS */;
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
