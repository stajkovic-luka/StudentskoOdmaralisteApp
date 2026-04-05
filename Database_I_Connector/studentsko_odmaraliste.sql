-- Baza podataka za Studentsko odmaralište
-- Autor: Luka Stajkovic
-- Datum: 27.12.2025.

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- =============================================
-- DROP TABLE IF EXISTS
-- =============================================
DROP TABLE IF EXISTS `sluzbeniksmena`;
DROP TABLE IF EXISTS `stavkafakture`;
DROP TABLE IF EXISTS `fakturaodmora`;
DROP TABLE IF EXISTS `smena`;
DROP TABLE IF EXISTS `nocenje`;
DROP TABLE IF EXISTS `student`;
DROP TABLE IF EXISTS `sluzbenik`;
DROP TABLE IF EXISTS `fakultet`;

-- =============================================
-- Kreiranje tabela
-- =============================================

CREATE TABLE `fakultet` (
  `idFakultet` bigint NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `mesto` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `akreditovan` tinyint(1) NOT NULL,
  PRIMARY KEY (`idFakultet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `student` (
  `idStudent` bigint NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `prezime` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `brTelefona` bigint NOT NULL,
  `budzet` tinyint(1) NOT NULL,
  `idFakultet` bigint NOT NULL,
  PRIMARY KEY (`idStudent`),
  KEY `idFakultet` (`idFakultet`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`idFakultet`) REFERENCES `fakultet` (`idFakultet`)
    ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `sluzbenik` (
  `idSluzbenik` bigint NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `prezime` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `korisnickoIme` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `lozinka` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idSluzbenik`),
  UNIQUE KEY `korisnickoIme` (`korisnickoIme`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `nocenje` (
  `idNocenje` bigint NOT NULL AUTO_INCREMENT,
  `cena` double NOT NULL,
  `opis` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idNocenje`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `smena` (
  `idSmena` bigint NOT NULL AUTO_INCREMENT,
  `prostorija` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `komentar` varchar(200) COLLATE utf8mb4_general_ci NOT NULL,
  `tipSmene` enum('JUTARNJA','POPODNEVNA') COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idSmena`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `fakturaodmora` (
  `idFaktura` bigint NOT NULL AUTO_INCREMENT,
  `popust` double NOT NULL,
  `iznosNakonPopusta` double NOT NULL,
  `ukupanIznos` double NOT NULL,
  `napomena` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `idSluzbenik` bigint NOT NULL,
  `idStudent` bigint NOT NULL,
  PRIMARY KEY (`idFaktura`),
  KEY `idSluzbenik` (`idSluzbenik`),
  KEY `idStudent` (`idStudent`),
  CONSTRAINT `fakturaodmora_ibfk_1` FOREIGN KEY (`idSluzbenik`) REFERENCES `sluzbenik` (`idSluzbenik`)
    ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fakturaodmora_ibfk_2` FOREIGN KEY (`idStudent`) REFERENCES `student` (`idStudent`)
    ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  `dodatniTroskovi` double NOT NULL DEFAULT 0,
  PRIMARY KEY (`idFaktura`,`rb`),
  KEY `idNocenje` (`idNocenje`),
  CONSTRAINT `stavkafakture_ibfk_1` FOREIGN KEY (`idFaktura`) REFERENCES `fakturaodmora` (`idFaktura`)
    ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `stavkafakture_ibfk_2` FOREIGN KEY (`idNocenje`) REFERENCES `nocenje` (`idNocenje`)
    ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `sluzbeniksmena` (
  `idSluzbenik` bigint NOT NULL,
  `idSmena` bigint NOT NULL,
  `datumSmene` date NOT NULL,
  PRIMARY KEY (`idSluzbenik`,`idSmena`,`datumSmene`),
  KEY `idSmena` (`idSmena`),
  CONSTRAINT `sluzbeniksmena_ibfk_1` FOREIGN KEY (`idSluzbenik`) REFERENCES `sluzbenik` (`idSluzbenik`)
    ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `sluzbeniksmena_ibfk_2` FOREIGN KEY (`idSmena`) REFERENCES `smena` (`idSmena`)
    ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- =============================================
-- Popunjavanje podacima
-- =============================================

-- Fakulteti
INSERT INTO `fakultet` (`idFakultet`, `naziv`, `mesto`, `akreditovan`) VALUES
(1,  'Fakultet Organizacionih Nauka',        'Beograd',       1),
(2,  'Elektrotehnicki fakultet',              'Beograd',       1),
(3,  'Elektronski fakultet',                  'Nis',           1),
(4,  'Pravni fakultet',                       'Beograd',       1),
(5,  'Pravni fakultet',                       'Nis',           1),
(6,  'Ekonomski fakultet',                    'Kragujevac',    1),
(7,  'Singidunum',                            'Beograd',       0),
(8,  'Medicinski fakultet',                   'Beograd',       1),
(9,  'Mašinski fakultet',                     'Beograd',       1),
(10, 'Građevinski fakultet',                  'Niš',           1),
(11, 'Poljoprivredni fakultet',               'Novi Sad',      1),
(12, 'Filozofski fakultet',                   'Beograd',       1),
(13, 'Fakultet dramskih umetnosti',           'Beograd',       1),
(14, 'Arhitektonski fakultet',                'Beograd',       1),
(15, 'Fakultet za menadžment',               'Beograd',       0),
(16, 'Fakultet tehničkih nauka',             'Novi Sad',      1),
(17, 'Fakultet za informacione tehnologije', 'Beograd',       1),
(18, 'Fakultet za sport',                    'Beograd',       1),
(19, 'Fakultet za turizam',                  'Vrnjačka Banja', 0),
(20, 'Fakultet bezbednosti',                 'Beograd',       1);

-- Studenti
INSERT INTO `student` (`idStudent`, `ime`, `prezime`, `brTelefona`, `budzet`, `idFakultet`) VALUES
(1,  'Luka',       'Markovic',      602732834, 1, 5),
(2,  'Lazar',      'Stefanovic',    647282937, 1, 3),
(3,  'Katarina',   'Kostic',        668282934, 0, 2),
(4,  'Ana',        'Jovanović',     612345678, 1, 1),
(5,  'Marko',      'Petrović',      623456789, 1, 2),
(6,  'Jovana',     'Nikolić',       634567890, 0, 3),
(7,  'Stefan',     'Đorđević',      645678901, 1, 4),
(8,  'Milica',     'Stojanović',    656789012, 1, 5),
(9,  'Nikola',     'Ilić',          667890123, 0, 6),
(10, 'Sara',       'Mihajlović',    678901234, 0, 7),
(11, 'Filip',      'Milovanović',   689012345, 1, 8),
(12, 'Marija',     'Pavlović',      690123456, 1, 9),
(13, 'Aleksandar', 'Stanković',     601234567, 0, 10),
(14, 'Ivana',      'Todorović',     619876543, 1, 11),
(15, 'Nemanja',    'Ristić',        628765432, 1, 12),
(16, 'Tamara',     'Gavrilović',    637654321, 0, 13),
(17, 'Luka',       'Vasić',         646543210, 1, 14),
(18, 'Elena',      'Milosavljević', 655432109, 0, 15),
(19, 'Dejan',      'Živković',      664321098, 1, 16),
(20, 'Jelena',     'Milanović',     673210987, 1, 17),
(21, 'Viktor',     'Popović',       682109876, 0, 18),
(22, 'Kristina',   'Janković',      691098765, 0, 19),
(23, 'Bojan',      'Lukić',         609876543, 1, 20);

-- Službenici
INSERT INTO `sluzbenik` (`idSluzbenik`, `ime`, `prezime`, `korisnickoIme`, `lozinka`) VALUES
(1, 'Luka',   'Stajkovic',  'lule',  'lule123'),
(2, 'Marko',  'Markovic',   'marko', 'marko123'),
(3, 'Stefan', 'Stefanovic', 'stef',  'stef123'),
(4, 'Admin',  'Admin',      'admin', 'admin');

SET FOREIGN_KEY_CHECKS = 1;

-- KRAJ --
