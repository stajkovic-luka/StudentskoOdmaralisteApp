/*
SQLyog Community v13.3.0 (64 bit)
MySQL - 10.4.32-MariaDB : Database - studentsko_odmaraliste
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`studentsko_odmaraliste` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `studentsko_odmaraliste`;

/*Table structure for table `fakturaodmora` */

DROP TABLE IF EXISTS `fakturaodmora`;

CREATE TABLE `fakturaodmora` (
  `idFakturaOdmora` bigint(20) NOT NULL AUTO_INCREMENT,
  `datumIzdavanja` date NOT NULL,
  `popust` double NOT NULL,
  `iznosNakonPopusta` double NOT NULL,
  `ukupanIznos` double NOT NULL,
  `napomena` varchar(200) DEFAULT NULL,
  `idSluzbenik` bigint(20) NOT NULL,
  `idStudent` bigint(20) NOT NULL,
  PRIMARY KEY (`idFakturaOdmora`),
  KEY `idSluzbenik` (`idSluzbenik`),
  KEY `idStudent` (`idStudent`),
  CONSTRAINT `fakturaodmora_ibfk_1` FOREIGN KEY (`idSluzbenik`) REFERENCES `sluzbenik` (`idSluzbenik`),
  CONSTRAINT `fakturaodmora_ibfk_2` FOREIGN KEY (`idStudent`) REFERENCES `student` (`idStudent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `fakturaodmora` */

/*Table structure for table `fakultet` */

DROP TABLE IF EXISTS `fakultet`;

CREATE TABLE `fakultet` (
  `idFakultet` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) NOT NULL,
  `mesto` varchar(100) NOT NULL,
  PRIMARY KEY (`idFakultet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `fakultet` */

/*Table structure for table `nocenje` */

DROP TABLE IF EXISTS `nocenje`;

CREATE TABLE `nocenje` (
  `idNocenje` bigint(20) NOT NULL AUTO_INCREMENT,
  `cena` double NOT NULL,
  `opis` varchar(100) NOT NULL,
  PRIMARY KEY (`idNocenje`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `nocenje` */

/*Table structure for table `sluzbenik` */

DROP TABLE IF EXISTS `sluzbenik`;

CREATE TABLE `sluzbenik` (
  `idSluzbenik` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(50) NOT NULL,
  `korisnickoIme` varchar(50) NOT NULL,
  `lozinka` varchar(100) NOT NULL,
  PRIMARY KEY (`idSluzbenik`),
  UNIQUE KEY `korisnickoIme` (`korisnickoIme`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `sluzbenik` */

/*Table structure for table `sluzbeniksmena` */

DROP TABLE IF EXISTS `sluzbeniksmena`;

CREATE TABLE `sluzbeniksmena` (
  `idSluzbenik` bigint(20) NOT NULL,
  `idSmena` bigint(20) NOT NULL,
  `datumSmene` date NOT NULL,
  PRIMARY KEY (`idSluzbenik`,`idSmena`,`datumSmene`),
  KEY `idSmena` (`idSmena`),
  CONSTRAINT `sluzbeniksmena_ibfk_1` FOREIGN KEY (`idSluzbenik`) REFERENCES `sluzbenik` (`idSluzbenik`),
  CONSTRAINT `sluzbeniksmena_ibfk_2` FOREIGN KEY (`idSmena`) REFERENCES `smena` (`idSmena`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `sluzbeniksmena` */

/*Table structure for table `smena` */

DROP TABLE IF EXISTS `smena`;

CREATE TABLE `smena` (
  `idSmena` bigint(20) NOT NULL AUTO_INCREMENT,
  `prostorija` varchar(50) NOT NULL,
  `komentar` varchar(200) DEFAULT NULL,
  `tipSmene` enum('JUTARNJA','POPODNEVNA') NOT NULL,
  PRIMARY KEY (`idSmena`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `smena` */

/*Table structure for table `stavkafakture` */

DROP TABLE IF EXISTS `stavkafakture`;

CREATE TABLE `stavkafakture` (
  `idFakturaOdmora` bigint(20) NOT NULL,
  `rb` int(11) NOT NULL,
  `idNocenje` bigint(20) NOT NULL,
  `datumOd` date NOT NULL,
  `datumDo` date NOT NULL,
  `brojDana` int(11) NOT NULL,
  `dorucakUkljucen` tinyint(1) NOT NULL DEFAULT 0,
  `cena` double NOT NULL,
  `iznos` double NOT NULL,
  PRIMARY KEY (`idFakturaOdmora`,`rb`),
  KEY `idNocenje` (`idNocenje`),
  CONSTRAINT `stavkafakture_ibfk_1` FOREIGN KEY (`idFakturaOdmora`) REFERENCES `fakturaodmora` (`idFakturaOdmora`) ON DELETE CASCADE,
  CONSTRAINT `stavkafakture_ibfk_2` FOREIGN KEY (`idNocenje`) REFERENCES `nocenje` (`idNocenje`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `stavkafakture` */

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `idStudent` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(50) NOT NULL,
  `brTelefona` varchar(20) NOT NULL,
  `idFakultet` bigint(20) NOT NULL,
  PRIMARY KEY (`idStudent`),
  KEY `idFakultet` (`idFakultet`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`idFakultet`) REFERENCES `fakultet` (`idFakultet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `student` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
