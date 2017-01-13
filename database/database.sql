CREATE DATABASE  IF NOT EXISTS `autoconcessionaria` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `autoconcessionaria`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: autoconcessionaria
-- ------------------------------------------------------
-- Server version	5.7.10-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accessorio`
--

DROP TABLE IF EXISTS `accessorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accessorio` (
  `id_accessorio` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `prezzo` int(11) NOT NULL,
  PRIMARY KEY (`id_accessorio`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accessorio`
--

LOCK TABLES `accessorio` WRITE;
/*!40000 ALTER TABLE `accessorio` DISABLE KEYS */;
INSERT INTO `accessorio` VALUES (1,'Vetri Oscurati',300),(2,'Cerchi in lega',250),(3,'Climatizzatore',300),(4,'Vetri Elettrici',200);
/*!40000 ALTER TABLE `accessorio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auto`
--

DROP TABLE IF EXISTS `auto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auto` (
  `id_auto` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `costo` varchar(45) NOT NULL,
  `descrizione` varchar(1000) NOT NULL,
  `foto` varchar(45) NOT NULL,
  PRIMARY KEY (`id_auto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auto`
--

LOCK TABLES `auto` WRITE;
/*!40000 ALTER TABLE `auto` DISABLE KEYS */;
INSERT INTO `auto` VALUES (0,'Punto','3500','Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.','car.jpg'),(1,'Panda','7021','Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.','car.jpg');
/*!40000 ALTER TABLE `auto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `newsletter`
--

DROP TABLE IF EXISTS `newsletter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `newsletter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `email` varchar(50) NOT NULL,
  `id_auto` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_auto2_idx` (`id_auto`),
  CONSTRAINT `id_auto2` FOREIGN KEY (`id_auto`) REFERENCES `auto` (`id_auto`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 DELAY_KEY_WRITE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `newsletter`
--

LOCK TABLES `newsletter` WRITE;
/*!40000 ALTER TABLE `newsletter` DISABLE KEYS */;
/*!40000 ALTER TABLE `newsletter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `noleggio`
--

DROP TABLE IF EXISTS `noleggio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `noleggio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `codice_fiscale` varchar(45) NOT NULL,
  `data_inizio` date NOT NULL,
  `data_fine` date NOT NULL,
  `id_auto` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_auto_idx` (`id_auto`),
  CONSTRAINT `id_auto1` FOREIGN KEY (`id_auto`) REFERENCES `auto` (`id_auto`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `noleggio`
--

LOCK TABLES `noleggio` WRITE;
/*!40000 ALTER TABLE `noleggio` DISABLE KEYS */;
/*!40000 ALTER TABLE `noleggio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `possiede`
--

DROP TABLE IF EXISTS `possiede`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `possiede` (
  `id_auto` int(11) NOT NULL,
  `id_accessorio` int(11) NOT NULL,
  `tipo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_auto`,`id_accessorio`),
  KEY `optional_idx` (`id_accessorio`),
  CONSTRAINT `auto` FOREIGN KEY (`id_auto`) REFERENCES `auto` (`id_auto`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `optional` FOREIGN KEY (`id_accessorio`) REFERENCES `accessorio` (`id_accessorio`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `possiede`
--

LOCK TABLES `possiede` WRITE;
/*!40000 ALTER TABLE `possiede` DISABLE KEYS */;
INSERT INTO `possiede` VALUES (0,1,0),(0,2,0),(0,3,1),(0,4,1);
/*!40000 ALTER TABLE `possiede` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preventivo`
--

DROP TABLE IF EXISTS `preventivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preventivo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `costo` varchar(45) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `codice_fiscale` varchar(45) NOT NULL,
  `id_auto` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_auto3_idx` (`id_auto`),
  CONSTRAINT `id_auto3` FOREIGN KEY (`id_auto`) REFERENCES `auto` (`id_auto`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preventivo`
--

LOCK TABLES `preventivo` WRITE;
/*!40000 ALTER TABLE `preventivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `preventivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testdrive`
--

DROP TABLE IF EXISTS `testdrive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `testdrive` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `codice_fiscale` varchar(45) NOT NULL,
  `id_auto` int(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_auto_idx` (`id_auto`),
  CONSTRAINT `id_auto` FOREIGN KEY (`id_auto`) REFERENCES `auto` (`id_auto`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 DELAY_KEY_WRITE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testdrive`
--

LOCK TABLES `testdrive` WRITE;
/*!40000 ALTER TABLE `testdrive` DISABLE KEYS */;
/*!40000 ALTER TABLE `testdrive` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-13 16:42:48
