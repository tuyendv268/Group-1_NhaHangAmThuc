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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) DEFAULT NULL,
  `point` bigint DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `membership_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnfl9gus1w7pr4didc4cxorh1t` (`membership_id`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Dương Văn Tuyển',10000,'0123654987',4),(2,'Phạm Bá Chinh',670,'0143567982',1),(3,'Đào Minh Tiến',700,'0987654312',1),(4,'Lê Văn Đức',4454,'0968754123',3),(5,'Nguyễn Mạnh Luynh',7900,'0129873645',4),(6,'Lê Văn Đức',0,'0999999999',1),(7,'Lê Văn Đức',0,'0999999999',1),(8,'Lê Văn Đức',0,'0999999999',1),(9,'Lê Văn Đức',0,'0999999999',1),(10,'Lê Văn Đức',0,'0999999999',1),(14,'Dương Văn Tuyển',0,'0999999999',1),(15,'Dương Văn Tuyển',0,'0999999999',1),(16,'Nguyễn Văn B',0,'0999999999',1),(17,'Dương Văn Tuyển',0,'0999999991',1),(18,'Pagani',0,'Imola',1),(19,'Anh bán đồ chơi tóc cam đầu ngõ',0,'Số điện thoại của người Nga',1),(20,'Chủ tịch Tung Của',0,'Số điện thoại của Quần Ngọc Các',1),(21,'1',-1,'1',6),(23,'Lê Văn Đức',-1,'0999999999',6),(13,'Lê Văn Đức',0,'099999999',6),(22,'Lê Văn Đức',0,'0999999999',6);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-14 21:38:33
