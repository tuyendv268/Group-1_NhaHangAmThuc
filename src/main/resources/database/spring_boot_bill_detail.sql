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
-- Table structure for table `bill_detail`
--

DROP TABLE IF EXISTS `bill_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `modify_time` datetime DEFAULT NULL,
  `quatity` int DEFAULT NULL,
  `total` int DEFAULT NULL,
  `bill_id` bigint DEFAULT NULL,
  `combo_id` bigint DEFAULT NULL,
  `dish_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeolgwyayei3o80bb7rj7t207q` (`bill_id`),
  KEY `FKint78u367s0ppc8vn417g650h` (`combo_id`),
  KEY `FKkbqn4keh7b6awxc6jbmnbor7w` (`dish_id`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_detail`
--

LOCK TABLES `bill_detail` WRITE;
/*!40000 ALTER TABLE `bill_detail` DISABLE KEYS */;
INSERT INTO `bill_detail` VALUES (1,'2021-11-20 00:00:00',1,5000000,1,NULL,1),(2,'2021-12-24 00:00:00',1,2350000,2,NULL,2),(3,'2022-01-01 00:00:00',2,4000000,3,2,NULL),(4,'2022-01-01 00:00:00',3,5000000,4,NULL,4),(5,'2022-01-01 00:00:00',1,800000,4,4,NULL),(6,'2022-01-14 00:00:00',4,NULL,5,NULL,1),(7,'2022-01-14 00:00:00',2,NULL,5,NULL,2),(8,'2022-01-14 00:00:00',1,NULL,5,NULL,3),(9,'2022-01-14 00:00:00',1,NULL,5,1,NULL),(10,'2022-01-15 00:00:00',2,NULL,6,2,NULL),(11,'2022-01-15 00:00:00',2,NULL,6,NULL,2),(12,'2022-01-16 00:00:00',4,NULL,7,NULL,3),(13,'2022-01-16 00:00:00',2,NULL,7,NULL,2),(14,'2022-01-16 00:00:00',1,NULL,7,1,NULL),(15,'2022-01-16 00:00:00',1,NULL,8,2,NULL),(16,'2022-01-16 00:00:00',2,NULL,9,NULL,2),(17,'2022-01-16 00:00:00',4,NULL,10,NULL,1),(18,'2022-01-16 00:00:00',2,NULL,10,NULL,2),(19,'2022-01-16 00:00:00',3,NULL,10,NULL,3),(20,'2022-01-17 00:00:00',2,NULL,11,NULL,2),(21,'2022-01-17 00:00:00',1,NULL,11,1,NULL),(22,'2022-01-17 00:00:00',2,NULL,12,2,NULL),(23,'2022-01-17 00:00:00',1,NULL,12,NULL,3),(24,'2022-01-17 00:00:00',2,NULL,13,NULL,2),(25,'2022-01-17 00:00:00',2,NULL,13,NULL,3);
/*!40000 ALTER TABLE `bill_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-14 21:38:34
