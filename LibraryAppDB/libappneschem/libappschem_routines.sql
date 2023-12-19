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
-- Temporary view structure for view `user_rented`
--

DROP TABLE IF EXISTS `user_rented`;
/*!50001 DROP VIEW IF EXISTS `user_rented`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `user_rented` AS SELECT 
 1 AS `userId`,
 1 AS `Count(DISTINCT book.ISBN)`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `available_instock_rented_book`
--

DROP TABLE IF EXISTS `available_instock_rented_book`;
/*!50001 DROP VIEW IF EXISTS `available_instock_rented_book`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `available_instock_rented_book` AS SELECT 
 1 AS `ISBN`,
 1 AS `title`,
 1 AS `inStock`,
 1 AS `available`,
 1 AS `inRent`*/;
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
-- Temporary view structure for view `user_book_view`
--

DROP TABLE IF EXISTS `user_book_view`;
/*!50001 DROP VIEW IF EXISTS `user_book_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `user_book_view` AS SELECT 
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
-- Temporary view structure for view `staffuser_transacts`
--

DROP TABLE IF EXISTS `staffuser_transacts`;
/*!50001 DROP VIEW IF EXISTS `staffuser_transacts`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `staffuser_transacts` AS SELECT 
 1 AS `userId`,
 1 AS `clientFirstName`,
 1 AS `clientLastName`,
 1 AS `staffId`,
 1 AS `copyNo`,
 1 AS `ISBN`,
 1 AS `title`,
 1 AS `transactionType`,
 1 AS `transactionDate`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `currently_in_rent_user_copynumber`
--

DROP TABLE IF EXISTS `currently_in_rent_user_copynumber`;
/*!50001 DROP VIEW IF EXISTS `currently_in_rent_user_copynumber`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `currently_in_rent_user_copynumber` AS SELECT 
 1 AS `email`,
 1 AS `userid`,
 1 AS `ISBN`,
 1 AS `title`,
 1 AS `copyNumber`,
 1 AS `rentDate`*/;
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
 1 AS `userId`*/;
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
-- Temporary view structure for view `staff_book_bookcopy_author`
--

DROP TABLE IF EXISTS `staff_book_bookcopy_author`;
/*!50001 DROP VIEW IF EXISTS `staff_book_bookcopy_author`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `staff_book_bookcopy_author` AS SELECT 
 1 AS `copyNo`,
 1 AS `ISBN`,
 1 AS `title`,
 1 AS `FullName`*/;
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
 1 AS `FullName`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `staffbook_author`
--

DROP TABLE IF EXISTS `staffbook_author`;
/*!50001 DROP VIEW IF EXISTS `staffbook_author`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `staffbook_author` AS SELECT 
 1 AS `ISBN`,
 1 AS `title`,
 1 AS `edition`,
 1 AS `genre`,
 1 AS `numOfPages`,
 1 AS `publisher`,
 1 AS `datePublished`,
 1 AS `bookDescription`,
 1 AS `bookImage`,
 1 AS `authorId`,
 1 AS `firstname`,
 1 AS `lastname`,
 1 AS `email`,
 1 AS `gender`*/;
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
-- Final view structure for view `user_rented`
--

/*!50001 DROP VIEW IF EXISTS `user_rented`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `user_rented` AS select `user`.`userId` AS `userId`,count(distinct `book`.`ISBN`) AS `Count(DISTINCT book.ISBN)` from (((`bookcopy` join `transacts`) join `user`) join `book`) where ((`transacts`.`userId` = `user`.`userId`) and (`bookcopy`.`copyNo` = `transacts`.`copyNumber`) and (`book`.`ISBN` = `bookcopy`.`ISBN`) and (`transacts`.`transactionType` = 'rent')) group by `user`.`userId` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `available_instock_rented_book`
--

/*!50001 DROP VIEW IF EXISTS `available_instock_rented_book`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `available_instock_rented_book` AS select `y`.`ISBN` AS `ISBN`,`y`.`title` AS `title`,`y`.`inStock` AS `inStock`,(`y`.`inStock` - count(`transacts`.`copyNumber`)) AS `available`,count(`transacts`.`copyNumber`) AS `inRent` from ((select `book`.`ISBN` AS `ISBN`,`book`.`title` AS `title`,`bookcopy`.`copyNo` AS `copyNo`,count(`bookcopy`.`copyNo`) AS `inStock` from (`book` join `bookcopy` on((`bookcopy`.`ISBN` = `book`.`ISBN`))) group by `book`.`ISBN`,`book`.`title`,`bookcopy`.`copyNo`) `y` left join `transacts` on((`y`.`copyNo` = `transacts`.`copyNumber`))) where (`transacts`.`transactionType` = 'Rent') group by `y`.`ISBN`,`y`.`title`,`y`.`inStock` */;
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
/*!50001 VIEW `user_book_view` AS select `book`.`ISBN` AS `ISBN`,`book`.`title` AS `title`,`book`.`edition` AS `edition`,`book`.`genre` AS `genre`,`book`.`numOfPages` AS `numofpages`,`book`.`publisher` AS `publisher`,`book`.`datePublished` AS `datepublished`,`book`.`bookDescription` AS `bookdescription`,`book`.`bookImage` AS `bookimage`,`author`.`firstname` AS `firstname`,`author`.`lastname` AS `lastname` from (`book` join `author` on((`book`.`authorId` = `author`.`authorId`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `staffuser_transacts`
--

/*!50001 DROP VIEW IF EXISTS `staffuser_transacts`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `staffuser_transacts` AS select `user`.`userId` AS `userId`,`user`.`firstName` AS `clientFirstName`,`user`.`firstName` AS `clientLastName`,`staff`.`staffId` AS `staffId`,`bookcopy`.`copyNo` AS `copyNo`,`book`.`ISBN` AS `ISBN`,`book`.`title` AS `title`,`transacts`.`transactionType` AS `transactionType`,`transacts`.`transactionDate` AS `transactionDate` from ((((`bookcopy` join `transacts`) join `staff`) join `user`) join `book`) where ((`transacts`.`staffId` = `staff`.`staffId`) and (`transacts`.`userId` = `user`.`userId`) and (`bookcopy`.`copyNo` = `transacts`.`copyNumber`) and (`book`.`ISBN` = `bookcopy`.`ISBN`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `currently_in_rent_user_copynumber`
--

/*!50001 DROP VIEW IF EXISTS `currently_in_rent_user_copynumber`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `currently_in_rent_user_copynumber` AS select `user`.`email` AS `email`,`user`.`userId` AS `userid`,`book`.`ISBN` AS `ISBN`,`book`.`title` AS `title`,`t`.`copyNumber` AS `copyNumber`,`t`.`transactionDate` AS `rentDate` from ((((select `transacts`.`userId` AS `userId`,`transacts`.`copyNumber` AS `copyNumber`,(curdate() - max(`transacts`.`transactionDate`)) AS `due`,`transacts`.`transactionDate` AS `transactionDate` from `transacts` where (`transacts`.`transactionType` = 'Rent') group by `transacts`.`copyNumber`,`transacts`.`userId`,`transacts`.`transactionDate`) `t` join `user`) join `book`) join `bookcopy`) where ((`t`.`userId` = `user`.`userId`) and (`t`.`copyNumber` = `bookcopy`.`copyNo`) and (`book`.`ISBN` = `bookcopy`.`ISBN`) and (`t`.`due` >= 14)) */;
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
/*!50001 VIEW `user_reservation_view` AS select `makereservation`.`reservationId` AS `reservationId`,`makereservation`.`studyRoomId` AS `studyRoomId`,`makereservation`.`reservationDateTime` AS `reservationDateTime`,`user`.`userId` AS `userId` from (`makereservation` join `user`) */;
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

--
-- Final view structure for view `staff_book_bookcopy_author`
--

/*!50001 DROP VIEW IF EXISTS `staff_book_bookcopy_author`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `staff_book_bookcopy_author` AS select `bookcopy`.`copyNo` AS `copyNo`,`book`.`ISBN` AS `ISBN`,`book`.`title` AS `title`,concat(`author`.`firstname`,' ',`author`.`lastname`) AS `FullName` from ((`book` join `bookcopy`) join `author`) where ((`book`.`authorId` = `author`.`authorId`) and (`book`.`ISBN` = `bookcopy`.`ISBN`)) */;
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
/*!50001 VIEW `book_author` AS select `book`.`ISBN` AS `ISBN`,`book`.`title` AS `title`,`book`.`edition` AS `edition`,`book`.`genre` AS `genre`,`book`.`numOfPages` AS `numOfPages`,`book`.`publisher` AS `publisher`,`book`.`datePublished` AS `datePublished`,`book`.`bookDescription` AS `bookDescription`,`book`.`bookImage` AS `bookImage`,concat(`author`.`firstname`,' ',`author`.`lastname`) AS `FullName` from (`book` join `author`) where (`book`.`authorId` = `book`.`authorId`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `staffbook_author`
--

/*!50001 DROP VIEW IF EXISTS `staffbook_author`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `staffbook_author` AS select `book`.`ISBN` AS `ISBN`,`book`.`title` AS `title`,`book`.`edition` AS `edition`,`book`.`genre` AS `genre`,`book`.`numOfPages` AS `numOfPages`,`book`.`publisher` AS `publisher`,`book`.`datePublished` AS `datePublished`,`book`.`bookDescription` AS `bookDescription`,`book`.`bookImage` AS `bookImage`,`book`.`authorId` AS `authorId`,`author`.`firstname` AS `firstname`,`author`.`lastname` AS `lastname`,`author`.`email` AS `email`,`author`.`gender` AS `gender` from (`book` join `author`) where (`book`.`authorId` = `author`.`authorId`) */;
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-19 20:08:36
