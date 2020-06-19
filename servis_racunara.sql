-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 04, 2020 at 07:47 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `servis_racunara`
--

-- --------------------------------------------------------

--
-- Table structure for table `klijent`
--

CREATE TABLE `klijent` (
  `klijentID` int(30) UNSIGNED NOT NULL,
  `klijentIme` varchar(255) NOT NULL,
  `klijentPrezime` varchar(255) NOT NULL,
  `klijentBrTel` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `klijent`
--

INSERT INTO `klijent` (`klijentID`, `klijentIme`, `klijentPrezime`, `klijentBrTel`) VALUES
(1, 'Miloshke be', 'Mirkovic', '065/1020301'),
(2, 'Milos', 'Nikic', '065/1050101');

-- --------------------------------------------------------

--
-- Table structure for table `komponenta`
--

CREATE TABLE `komponenta` (
  `model` varchar(255) DEFAULT NULL,
  `proizvodjac` varchar(255) DEFAULT NULL,
  `cena` double DEFAULT NULL,
  `opis` varchar(255) DEFAULT NULL,
  `konfiguracijaID` int(30) UNSIGNED NOT NULL,
  `tipKomponente` int(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `konfiguracija`
--

CREATE TABLE `konfiguracija` (
  `konfiguracijaID` int(30) UNSIGNED NOT NULL,
  `klijentID` int(10) UNSIGNED NOT NULL,
  `ukupnaCena` double UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `konfiguracija`
--

INSERT INTO `konfiguracija` (`konfiguracijaID`, `klijentID`, `ukupnaCena`) VALUES
(1, 1, 34000),
(2, 2, 91000);

-- --------------------------------------------------------

--
-- Table structure for table `servis`
--

CREATE TABLE `servis` (
  `servisID` int(30) UNSIGNED NOT NULL,
  `datumServisa` date DEFAULT NULL,
  `opis` varchar(255) DEFAULT NULL,
  `konfiguracijaID` int(30) UNSIGNED NOT NULL,
  `serviserID` int(30) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `servis`
--

INSERT INTO `servis` (`servisID`, `datumServisa`, `opis`, `konfiguracijaID`, `serviserID`) VALUES
(0, '2020-05-31', 'Crklo napajanje, zamenjeno', 1, 1),
(1, '2020-05-22', 'Kompjuter nije prosao POST, stavljen novi ram i sve radi dobro', 1, 1),
(2, '2020-06-18', 'Zamenjen kuler na ', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `serviser`
--

CREATE TABLE `serviser` (
  `serviserID` int(30) UNSIGNED NOT NULL,
  `serviserIme` varchar(255) DEFAULT NULL,
  `serviserPrezime` varchar(255) DEFAULT NULL,
  `korisnickoIme` varchar(255) DEFAULT NULL,
  `lozinka` varchar(255) DEFAULT NULL,
  `serviserBrTel` varchar(255) DEFAULT NULL,
  `poljeStrucnosti` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `serviser`
--

INSERT INTO `serviser` (`serviserID`, `serviserIme`, `serviserPrezime`, `korisnickoIme`, `lozinka`, `serviserBrTel`, `poljeStrucnosti`) VALUES
(1, 'Petar', 'Petrovic', 'pera', 'pera', '064/1234567', 'Zamena hladnjaka'),
(2, 'Zivorad', 'Zivanovic', 'zika', 'zika', '065/1234567', 'Dijagnostika softverskih kvarova');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `klijent`
--
ALTER TABLE `klijent`
  ADD PRIMARY KEY (`klijentID`);

--
-- Indexes for table `konfiguracija`
--
ALTER TABLE `konfiguracija`
  ADD PRIMARY KEY (`konfiguracijaID`),
  ADD KEY `konfiguracija_ibfk_1` (`klijentID`);

--
-- Indexes for table `servis`
--
ALTER TABLE `servis`
  ADD PRIMARY KEY (`servisID`),
  ADD KEY `konfiguracijaID` (`konfiguracijaID`),
  ADD KEY `serviserID` (`serviserID`);

--
-- Indexes for table `serviser`
--
ALTER TABLE `serviser`
  ADD PRIMARY KEY (`serviserID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `serviser`
--
ALTER TABLE `serviser`
  MODIFY `serviserID` int(30) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `konfiguracija`
--
ALTER TABLE `konfiguracija`
  ADD CONSTRAINT `konfiguracija_ibfk_1` FOREIGN KEY (`klijentID`) REFERENCES `klijent` (`klijentID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `servis`
--
ALTER TABLE `servis`
  ADD CONSTRAINT `servis_ibfk_1` FOREIGN KEY (`konfiguracijaID`) REFERENCES `konfiguracija` (`konfiguracijaID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `servis_ibfk_2` FOREIGN KEY (`serviserID`) REFERENCES `serviser` (`serviserID`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
