-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: libappschem
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `makereservation`
--

DROP TABLE IF EXISTS `makereservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `makereservation` (
  `reservationId` int NOT NULL AUTO_INCREMENT,
  `studyRoomId` int NOT NULL,
  `userId` int NOT NULL,
  `reservationDateTime` datetime NOT NULL,
  `duration` int NOT NULL,
  PRIMARY KEY (`reservationId`),
  UNIQUE KEY `makereservation_pk` (`reservationDateTime`),
  KEY `MakeReservation_studyroom_null_fk` (`studyRoomId`),
  KEY `MakeReservation_user_null_fk` (`userId`),
  CONSTRAINT `MakeReservation_studyroom_null_fk` FOREIGN KEY (`studyRoomId`) REFERENCES `studyroom` (`studyRoomId`),
  CONSTRAINT `MakeReservation_user_null_fk` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`),
  CONSTRAINT `DurationTimes` CHECK ((`duration` >= 30))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `makereservation`
--

LOCK TABLES `makereservation` WRITE;
/*!40000 ALTER TABLE `makereservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `makereservation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-11  1:08:49
