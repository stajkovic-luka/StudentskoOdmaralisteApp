
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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;
SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '70a5eac4-d879-11f0-a972-64f3971abc5f:1-1149';
DROP TABLE IF EXISTS `fakturaodmora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fakturaodmora` (
  `idFaktura` bigint NOT NULL AUTO_INCREMENT,
  `popust` double NOT NULL,
  `iznosNakonPopusta` double NOT NULL,
  `ukupanIznos` double NOT NULL,
  `napomena` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `idSluzbenik` bigint NOT NULL,
  `idStudent` bigint NOT NULL,
  PRIMARY KEY (`idFaktura`),
  KEY `idSluzbenik` (`idSluzbenik`),
  KEY `idStudent` (`idStudent`),
  CONSTRAINT `fakturaodmora_ibfk_1` FOREIGN KEY (`idSluzbenik`) REFERENCES `sluzbenik` (`idSluzbenik`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fakturaodmora_ibfk_2` FOREIGN KEY (`idStudent`) REFERENCES `student` (`idStudent`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `fakturaodmora` WRITE;
/*!40000 ALTER TABLE `fakturaodmora` DISABLE KEYS */;
INSERT INTO `fakturaodmora` (`idFaktura`, `popust`, `iznosNakonPopusta`, `ukupanIznos`, `napomena`, `idSluzbenik`, `idStudent`) VALUES (1,0.7,5250,7500,'Studentski popust za budzet',1,1),(2,1,15000,15000,'Redovna cena',2,3),(3,0.7,10500,15000,'Budzet popust',1,4),(4,1,8000,8000,NULL,3,7),(5,0.7,8750,12500,'Popust za budzet studenta',2,5);
/*!40000 ALTER TABLE `fakturaodmora` ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS `fakultet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fakultet` (
  `idFakultet` bigint NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `mesto` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `akreditovan` tinyint(1) NOT NULL,
  PRIMARY KEY (`idFakultet`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `fakultet` WRITE;
/*!40000 ALTER TABLE `fakultet` DISABLE KEYS */;
INSERT INTO `fakultet` (`idFakultet`, `naziv`, `mesto`, `akreditovan`) VALUES (1,'Fakultet Organizacionih Nauka','Beograd',1),(2,'Elektrotehnicki fakultet','Beograd',1),(3,'Elektronski fakultet','Nis',1),(4,'Pravni fakultet','Beograd',1),(5,'Pravni fakultet','Nis',1),(6,'Ekonomski fakultet','Kragujevac',1),(7,'Singidunum','Beograd',0),(8,'Medicinski fakultet','Beograd',1),(9,'Mašinski fakultet','Beograd',1),(10,'Građevinski fakultet','Niš',1),(11,'Poljoprivredni fakultet','Novi Sad',1),(12,'Filozofski fakultet','Beograd',1),(13,'Fakultet dramskih umetnosti','Beograd',1),(14,'Arhitektonski fakultet','Beograd',1),(15,'Fakultet za menadžment','Beograd',0),(16,'Fakultet tehničkih nauka','Novi Sad',1),(17,'Fakultet za informacione tehnologije','Beograd',1),(18,'Fakultet za sport','Beograd',1),(19,'Fakultet za turizam','Vrnjačka Banja',0),(20,'Fakultet bezbednosti','Beograd',1);
/*!40000 ALTER TABLE `fakultet` ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS `nocenje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nocenje` (
  `idNocenje` bigint NOT NULL AUTO_INCREMENT,
  `cena` double NOT NULL,
  `opis` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idNocenje`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `nocenje` WRITE;
/*!40000 ALTER TABLE `nocenje` DISABLE KEYS */;
INSERT INTO `nocenje` (`idNocenje`, `cena`, `opis`) VALUES (1,2500,'Standardna soba - jedan krevet'),(2,3500,'Standardna soba - dva kreveta'),(3,5000,'Apartman - luxury'),(4,4000,'Poluapartman'),(5,3000,'Standardna soba - pogled na vrt');
/*!40000 ALTER TABLE `nocenje` ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS `sluzbenik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sluzbenik` (
  `idSluzbenik` bigint NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `prezime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `korisnickoIme` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `lozinka` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idSluzbenik`),
  UNIQUE KEY `korisnickoIme` (`korisnickoIme`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `sluzbenik` WRITE;
/*!40000 ALTER TABLE `sluzbenik` DISABLE KEYS */;
INSERT INTO `sluzbenik` (`idSluzbenik`, `ime`, `prezime`, `korisnickoIme`, `lozinka`) VALUES (1,'Luka','Stajkovic','lule','lule123'),(2,'Marko','Markovic','marko','marko123'),(3,'Stefan','Stefanovic','stef','stef123'),(4,'Admin','Admin','admin','admin');
/*!40000 ALTER TABLE `sluzbenik` ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS `sluzbeniksmena`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sluzbeniksmena` (
  `idSluzbenik` bigint NOT NULL,
  `idSmena` bigint NOT NULL,
  `datumSmene` date NOT NULL,
  PRIMARY KEY (`idSluzbenik`,`idSmena`,`datumSmene`),
  KEY `idSmena` (`idSmena`),
  CONSTRAINT `sluzbeniksmena_ibfk_1` FOREIGN KEY (`idSluzbenik`) REFERENCES `sluzbenik` (`idSluzbenik`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `sluzbeniksmena_ibfk_2` FOREIGN KEY (`idSmena`) REFERENCES `smena` (`idSmena`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `sluzbeniksmena` WRITE;
/*!40000 ALTER TABLE `sluzbeniksmena` DISABLE KEYS */;
INSERT INTO `sluzbeniksmena` (`idSluzbenik`, `idSmena`, `datumSmene`) VALUES (1,1,'2026-05-10'),(3,1,'2026-05-12'),(2,2,'2026-05-10'),(3,2,'2026-05-13'),(1,3,'2026-05-11'),(4,3,'2026-05-10'),(2,4,'2026-05-11'),(4,4,'2026-05-12');
/*!40000 ALTER TABLE `sluzbeniksmena` ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS `smena`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `smena` (
  `idSmena` bigint NOT NULL AUTO_INCREMENT,
  `prostorija` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `komentar` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `tipSmene` enum('JUTARNJA','POPODNEVNA') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idSmena`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `smena` WRITE;
/*!40000 ALTER TABLE `smena` DISABLE KEYS */;
INSERT INTO `smena` (`idSmena`, `prostorija`, `komentar`, `tipSmene`) VALUES (1,'101','Smena za jutarnji pregled','JUTARNJA'),(2,'202','Popodnevna smena','POPODNEVNA'),(3,'103','Jutarnja smena 2','JUTARNJA'),(4,'505','Test smena','POPODNEVNA');
/*!40000 ALTER TABLE `smena` ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS `stavkafakture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stavkafakture` (
  `idFaktura` bigint NOT NULL,
  `rb` int NOT NULL,
  `idNocenje` bigint NOT NULL,
  `datumOd` date NOT NULL,
  `datumDo` date NOT NULL,
  `brojDana` int NOT NULL,
  `dorucakUkljucen` tinyint(1) NOT NULL DEFAULT '0',
  `cena` double NOT NULL,
  `iznos` double NOT NULL,
  `dodatniTroskovi` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`idFaktura`,`rb`),
  KEY `idNocenje` (`idNocenje`),
  CONSTRAINT `stavkafakture_ibfk_1` FOREIGN KEY (`idFaktura`) REFERENCES `fakturaodmora` (`idFaktura`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `stavkafakture_ibfk_2` FOREIGN KEY (`idNocenje`) REFERENCES `nocenje` (`idNocenje`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `stavkafakture` WRITE;
/*!40000 ALTER TABLE `stavkafakture` DISABLE KEYS */;
INSERT INTO `stavkafakture` (`idFaktura`, `rb`, `idNocenje`, `datumOd`, `datumDo`, `brojDana`, `dorucakUkljucen`, `cena`, `iznos`, `dodatniTroskovi`) VALUES (1,1,1,'2026-06-01','2026-06-04',3,1,2500,7500,0),(2,1,3,'2026-06-10','2026-06-13',3,1,5000,15000,0),(3,1,2,'2026-06-05','2026-06-10',5,1,3000,15000,0),(4,1,1,'2026-06-15','2026-06-18',3,0,2500,7500,500),(4,2,5,'2026-06-15','2026-06-16',1,1,3000,3000,0),(5,1,4,'2026-06-20','2026-06-24',4,1,4000,16000,0),(5,2,1,'2026-06-24','2026-06-25',1,0,2500,2500,200);
/*!40000 ALTER TABLE `stavkafakture` ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `idStudent` bigint NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `prezime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `brTelefona` bigint NOT NULL,
  `budzet` tinyint(1) NOT NULL,
  `idFakultet` bigint NOT NULL,
  PRIMARY KEY (`idStudent`),
  KEY `idFakultet` (`idFakultet`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`idFakultet`) REFERENCES `fakultet` (`idFakultet`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`idStudent`, `ime`, `prezime`, `brTelefona`, `budzet`, `idFakultet`) VALUES (1,'Luka','Markovic',602732834,1,5),(2,'Lazar','Stefanovic',647282937,1,3),(3,'Katarina','Kostic',668282934,0,2),(4,'Ana','Jovanović',612345678,1,1),(5,'Marko','Petrović',623456789,1,2),(6,'Jovana','Nikolić',634567890,0,3),(7,'Stefan','Đorđević',645678901,1,4),(8,'Milica','Stojanović',656789012,1,5),(9,'Nikola','Ilić',667890123,0,6),(10,'Sara','Mihajlović',678901234,0,7),(11,'Filip','Milovanović',689012345,1,8),(12,'Marija','Pavlović',690123456,1,9),(13,'Aleksandar','Stanković',601234567,0,10),(14,'Ivana','Todorović',619876543,1,11),(15,'Nemanja','Ristić',628765432,1,12),(16,'Tamara','Gavrilović',637654321,0,13),(17,'Luka','Vasić',646543210,1,14),(18,'Elena','Milosavljević',655432109,0,15),(19,'Dejan','Živković',664321098,1,16),(20,'Jelena','Milanović',673210987,1,17),(21,'Viktor','Popović',682109876,0,18),(22,'Kristina','Janković',691098765,0,19),(23,'Bojan','Lukić',609876543,1,20),(24,'TEST','TEST',606172273,1,1);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

