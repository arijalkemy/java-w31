-- MySQL dump 10.13  Distrib 9.3.0, for macos15.2 (arm64)
--
-- Host: localhost    Database: ejercicioAlumnos
-- ------------------------------------------------------
-- Server version	9.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `ejercicioAlumnos`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `ejercicioAlumnos` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `ejercicioAlumnos`;

--
-- Table structure for table `AUTOR`
--

DROP TABLE IF EXISTS `AUTOR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `AUTOR` (
  `idAutor` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Nacionalidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idAutor`),
  UNIQUE KEY `idAutor_UNIQUE` (`idAutor`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AUTOR`
--

LOCK TABLES `AUTOR` WRITE;
/*!40000 ALTER TABLE `AUTOR` DISABLE KEYS */;
INSERT INTO `AUTOR` VALUES (1,'J.K. Rowling','Británica'),(2,'Isaac Asimov','Estadounidense'),(3,'Albert Camus','Francesa'),(4,'Umberto Eco','Italiana'),(5,'Margaret Atwood','Canadiense');
/*!40000 ALTER TABLE `AUTOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ESTUDIANTE`
--

DROP TABLE IF EXISTS `ESTUDIANTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ESTUDIANTE` (
  `idLector` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Apellido` varchar(45) DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `Carrera` varchar(45) DEFAULT NULL,
  `Edad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idLector`),
  UNIQUE KEY `idLector_UNIQUE` (`idLector`)
) ENGINE=InnoDB AUTO_INCREMENT=206 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ESTUDIANTE`
--

LOCK TABLES `ESTUDIANTE` WRITE;
/*!40000 ALTER TABLE `ESTUDIANTE` DISABLE KEYS */;
INSERT INTO `ESTUDIANTE` VALUES (201,'Filippo','Galli','Calle 1','Informática','22'),(202,'Laura','González','Calle 2','Informática','24'),(203,'Marcos','Pérez','Calle 3','Biología','21'),(204,'Juliana','García','Calle 4','Historia','20'),(205,'Luis','Ramírez','Calle 5','Informática','25');
/*!40000 ALTER TABLE `ESTUDIANTE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LIBRO`
--

DROP TABLE IF EXISTS `LIBRO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `LIBRO` (
  `idLibro` int NOT NULL AUTO_INCREMENT,
  `Titulo` varchar(45) DEFAULT NULL,
  `Editorial` varchar(45) DEFAULT NULL,
  `Area` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idLibro`),
  UNIQUE KEY `idLibro_UNIQUE` (`idLibro`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LIBRO`
--

LOCK TABLES `LIBRO` WRITE;
/*!40000 ALTER TABLE `LIBRO` DISABLE KEYS */;
INSERT INTO `LIBRO` VALUES (101,'El Universo: Guía de viaje','Planeta','Astronomía'),(102,'El Código Da Vinci','Salamandra','Ficción'),(103,'Harry Potter y la piedra filosofal','Salamandra','Fantasía'),(104,'La Peste','Gallimard','Filosofía'),(105,'Fundación','Minotauro','Ciencia Ficción');
/*!40000 ALTER TABLE `LIBRO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LIBROAUTOR`
--

DROP TABLE IF EXISTS `LIBROAUTOR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `LIBROAUTOR` (
  `idLibro` int NOT NULL,
  `idAutor` int NOT NULL,
  PRIMARY KEY (`idLibro`,`idAutor`),
  KEY `fk_autor` (`idAutor`),
  CONSTRAINT `fk_autor` FOREIGN KEY (`idAutor`) REFERENCES `AUTOR` (`idAutor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_libro` FOREIGN KEY (`idLibro`) REFERENCES `LIBRO` (`idLibro`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LIBROAUTOR`
--

LOCK TABLES `LIBROAUTOR` WRITE;
/*!40000 ALTER TABLE `LIBROAUTOR` DISABLE KEYS */;
INSERT INTO `LIBROAUTOR` VALUES (103,1),(101,2),(105,2),(104,3),(102,4);
/*!40000 ALTER TABLE `LIBROAUTOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRESTAMO`
--

DROP TABLE IF EXISTS `PRESTAMO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PRESTAMO` (
  `idPrestamo` int NOT NULL AUTO_INCREMENT,
  `idLector` int DEFAULT NULL,
  `idLibro` int DEFAULT NULL,
  `FechaPrestamo` datetime DEFAULT NULL,
  `FechaDevolucion` datetime DEFAULT NULL,
  `Devuelto` tinyint DEFAULT NULL,
  PRIMARY KEY (`idPrestamo`),
  UNIQUE KEY `idPrestamo_UNIQUE` (`idPrestamo`),
  KEY `idLibro_idx` (`idLibro`),
  KEY `idLector_idx` (`idLector`),
  CONSTRAINT `idLector` FOREIGN KEY (`idLector`) REFERENCES `ESTUDIANTE` (`idLector`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idLibro` FOREIGN KEY (`idLibro`) REFERENCES `LIBRO` (`idLibro`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRESTAMO`
--

LOCK TABLES `PRESTAMO` WRITE;
/*!40000 ALTER TABLE `PRESTAMO` DISABLE KEYS */;
INSERT INTO `PRESTAMO` VALUES (1,201,103,'2021-07-10 00:00:00','2021-07-16 00:00:00',1),(2,202,105,'2021-06-15 00:00:00','2021-06-22 00:00:00',1),(3,203,104,'2021-07-12 00:00:00','2021-07-20 00:00:00',0),(4,204,101,'2021-07-01 00:00:00','2021-07-16 00:00:00',1),(5,205,105,'2021-08-01 00:00:00','2021-08-08 00:00:00',0);
/*!40000 ALTER TABLE `PRESTAMO` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-12 20:47:30
