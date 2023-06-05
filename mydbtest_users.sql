-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: mydbtest
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `FIO` text NOT NULL,
  `dateOfBirth` date NOT NULL,
  `test1` varchar(1) NOT NULL,
  `dateTest1` date NOT NULL,
  `test2` varchar(1) NOT NULL,
  `dateTest2` date NOT NULL,
  `test3` varchar(1) NOT NULL,
  `dateTest3` date NOT NULL,
  `test4` varchar(1) NOT NULL,
  `dateTest4` date NOT NULL,
  `test5` varchar(1) NOT NULL,
  `dateTest5` date NOT NULL,
  `test6` varchar(1) NOT NULL,
  `dateTest6` date NOT NULL,
  `test7` varchar(1) NOT NULL,
  `dateTest7` date NOT NULL,
  `test8` varchar(1) NOT NULL,
  `dateTest8` date NOT NULL,
  `test9` varchar(1) NOT NULL,
  `dateTest9` date NOT NULL,
  `test10` varchar(1) NOT NULL,
  `dateTest10` date NOT NULL,
  `exam1` int NOT NULL,
  `dateExam1` date NOT NULL,
  `exam2` int NOT NULL,
  `dateExam2` date NOT NULL,
  `exam3` int NOT NULL,
  `dateExam3` date NOT NULL,
  `exam4` int NOT NULL,
  `dateExam4` date NOT NULL,
  `exam5` int NOT NULL,
  `dateExam5` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (6,'Алекса Илья Павлович','2005-10-09','+','2022-09-12','+','2022-09-12','+','2022-09-12','+','2022-09-12','+','2022-09-12','+','2022-09-12','+','2017-09-20','+','2022-09-12','+','2022-09-12','+','2022-09-12',5,'2022-09-12',3,'2022-09-12',5,'2022-09-12',5,'2022-09-12',5,'2022-09-12'),(8,'Зебров Петр Николаевич','2005-10-09','+','2022-09-12','+','2022-09-12','+','2022-09-12','+','2022-09-12','+','2022-09-12','+','2022-09-12','+','2017-09-20','+','2022-09-12','+','2022-09-12','+','2022-09-12',5,'2022-09-12',5,'2022-09-12',5,'2022-09-12',5,'2022-09-12',5,'2022-09-12'),(9,'Зебров Петр Николаевич','2005-10-09','+','2022-09-12','+','2022-09-12','+','2022-09-12','+','2022-09-12','+','2022-09-12','+','2022-09-12','+','2017-09-20','+','2022-09-12','+','2022-09-12','+','2022-09-12',5,'2022-09-12',5,'2022-09-12',5,'2022-09-12',5,'2022-09-12',5,'2022-09-12'),(10,'Воронин Николай Петрович','2002-12-01','+','2022-11-10','+','2022-01-22','_','2022-01-22','+','2022-01-22','-','2022-01-22','+','2022-01-22','-','2022-01-22','+','2022-01-22','-','2022-01-22','+','2022-01-22',5,'2022-01-22',4,'2022-01-22',5,'2022-01-22',2,'2022-01-22',5,'2022-01-22'),(11,'Алебров Петр Николаевич','2005-10-09','+','2022-09-12','+','2022-09-12','+','2022-09-12','+','2022-09-12','+','2022-09-12','+','2022-09-12','+','2017-09-20','+','2022-09-12','+','2022-09-12','+','2022-09-12',5,'2022-09-12',5,'2022-09-12',5,'2022-09-12',5,'2022-09-12',5,'2022-09-12');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-15 11:11:35
