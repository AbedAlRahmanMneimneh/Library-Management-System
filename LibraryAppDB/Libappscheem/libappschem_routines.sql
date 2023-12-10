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
-- Temporary view structure for view `user_book_view`
--

DROP TABLE IF EXISTS `user_book_view`;
/*!50001 DROP VIEW IF EXISTS `user_book_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `user_book_view` AS SELECT 
 1 AS `row_number() over ()`,
 1 AS `ISBN`,
 1 AS `title`,
 1 AS `edition`,
 1 AS `genre`,
 1 AS `numofpages`,
 1 AS `publisher`,
 1 AS `datepublished`,
 1 AS `bookdescription`,
 1 AS `bookimage`,
 1 AS `firstname`,
 1 AS `lastname`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `book_author`
--

DROP TABLE IF EXISTS `book_author`;
/*!50001 DROP VIEW IF EXISTS `book_author`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `book_author` AS SELECT 
 1 AS `ISBN`,
 1 AS `title`,
 1 AS `edition`,
 1 AS `genre`,
 1 AS `numOfPages`,
 1 AS `publisher`,
 1 AS `datePublished`,
 1 AS `bookDescription`,
 1 AS `bookImage`,
 1 AS `firstname`,
 1 AS `lastname`,
 1 AS `email`,
 1 AS `dateBirth`,
 1 AS `gender`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `user_reservation_view`
--

DROP TABLE IF EXISTS `user_reservation_view`;
/*!50001 DROP VIEW IF EXISTS `user_reservation_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `user_reservation_view` AS SELECT 
 1 AS `reservationId`,
 1 AS `studyRoomId`,
 1 AS `reservationDateTime`,
 1 AS `duration`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `most_read`
--

DROP TABLE IF EXISTS `most_read`;
/*!50001 DROP VIEW IF EXISTS `most_read`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `most_read` AS SELECT 
 1 AS `ISBN`,
 1 AS `title`,
 1 AS `COUNT(DISTINCT userId)`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `user_genre`
--

DROP TABLE IF EXISTS `user_genre`;
/*!50001 DROP VIEW IF EXISTS `user_genre`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `user_genre` AS SELECT 
 1 AS `userId`,
 1 AS `genre`,
 1 AS `COUNT(genre)`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `user_author`
--

DROP TABLE IF EXISTS `user_author`;
/*!50001 DROP VIEW IF EXISTS `user_author`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `user_author` AS SELECT 
 1 AS `userId`,
 1 AS `firstname`,
 1 AS `lastname`,
 1 AS `COUNT(book.authorId)`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `pages_read`
--

DROP TABLE IF EXISTS `pages_read`;
/*!50001 DROP VIEW IF EXISTS `pages_read`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `pages_read` AS SELECT 
 1 AS `userid`,
 1 AS `Sum(book.numOfPages)`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `user_book_view`
--

/*!50001 DROP VIEW IF EXISTS `user_book_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `user_book_view` AS select row_number() OVER ()  AS `row_number() over ()`,`book`.`ISBN` AS `ISBN`,`book`.`title` AS `title`,`book`.`edition` AS `edition`,`book`.`genre` AS `genre`,`book`.`numOfPages` AS `numofpages`,`book`.`publisher` AS `publisher`,`book`.`datePublished` AS `datepublished`,`book`.`bookDescription` AS `bookdescription`,`book`.`bookImage` AS `bookimage`,`author`.`firstname` AS `firstname`,`author`.`lastname` AS `lastname` from (`book` join `author` on((`book`.`authorId` = `author`.`authorId`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `book_author`
--

/*!50001 DROP VIEW IF EXISTS `book_author`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `book_author` AS select `book`.`ISBN` AS `ISBN`,`book`.`title` AS `title`,`book`.`edition` AS `edition`,`book`.`genre` AS `genre`,`book`.`numOfPages` AS `numOfPages`,`book`.`publisher` AS `publisher`,`book`.`datePublished` AS `datePublished`,`book`.`bookDescription` AS `bookDescription`,`book`.`bookImage` AS `bookImage`,`author`.`firstname` AS `firstname`,`author`.`lastname` AS `lastname`,`author`.`email` AS `email`,`author`.`dateBirth` AS `dateBirth`,`author`.`gender` AS `gender` from (`book` join `author`) where (`book`.`authorId` = `book`.`authorId`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `user_reservation_view`
--

/*!50001 DROP VIEW IF EXISTS `user_reservation_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `user_reservation_view` AS select `makereservation`.`reservationId` AS `reservationId`,`makereservation`.`studyRoomId` AS `studyRoomId`,`makereservation`.`reservationDateTime` AS `reservationDateTime`,`makereservation`.`duration` AS `duration` from `makereservation` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `most_read`
--

/*!50001 DROP VIEW IF EXISTS `most_read`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `most_read` AS select `book`.`ISBN` AS `ISBN`,`book`.`title` AS `title`,count(distinct `transacts`.`userId`) AS `COUNT(DISTINCT userId)` from ((`transacts` join `bookcopy`) join `book`) where ((`bookcopy`.`ISBN` = `book`.`ISBN`) and (`bookcopy`.`copyNo` = `transacts`.`copyNumber`) and (`transacts`.`transactionType` = 'Rent')) group by `book`.`ISBN` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `user_genre`
--

/*!50001 DROP VIEW IF EXISTS `user_genre`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `user_genre` AS select `user`.`userId` AS `userId`,`book`.`genre` AS `genre`,count(`book`.`genre`) AS `COUNT(genre)` from (((`user` join `transacts`) join `book`) join `bookcopy`) where ((`transacts`.`userId` = `user`.`userId`) and (`bookcopy`.`copyNo` = `transacts`.`copyNumber`) and (`bookcopy`.`ISBN` = `book`.`ISBN`)) group by `user`.`userId`,`book`.`genre` order by count(`book`.`genre`) desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `user_author`
--

/*!50001 DROP VIEW IF EXISTS `user_author`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `user_author` AS select `user`.`userId` AS `userId`,`author`.`firstname` AS `firstname`,`author`.`lastname` AS `lastname`,count(`book`.`authorId`) AS `COUNT(book.authorId)` from ((((`transacts` join `author`) join `bookcopy`) join `book`) join `user`) where ((`transacts`.`userId` = `user`.`userId`) and (`transacts`.`copyNumber` = `bookcopy`.`copyNo`) and (`bookcopy`.`ISBN` = `book`.`ISBN`) and (`book`.`authorId` = `author`.`authorId`)) group by `user`.`userId`,`author`.`authorId` order by count(`book`.`authorId`) desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `pages_read`
--

/*!50001 DROP VIEW IF EXISTS `pages_read`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `pages_read` AS select `user`.`userId` AS `userid`,sum(`book`.`numOfPages`) AS `Sum(book.numOfPages)` from (((`user` join `transacts`) join `bookcopy`) join `book`) where ((`user`.`userId` = `transacts`.`userId`) and (`bookcopy`.`copyNo` = `transacts`.`copyNumber`) and (`book`.`ISBN` = `bookcopy`.`ISBN`)) group by `user`.`userId` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-11  1:08:50
