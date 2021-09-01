-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 31. Aug 2021 um 16:45
-- Server-Version: 10.4.20-MariaDB
-- PHP-Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `unternehmen`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `bestellung`
--

CREATE TABLE `bestellung` (
  `ID` int(10) UNSIGNED NOT NULL,
  `KundenNummer` int(10) UNSIGNED NOT NULL DEFAULT 0,
  `ProduktID` int(10) UNSIGNED NOT NULL DEFAULT 0,
  `Bestelldatum` date DEFAULT NULL,
  `Lieferdatum` date DEFAULT NULL,
  `Anzahl` int(10) UNSIGNED NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `bestellung`
--

INSERT INTO `bestellung` (`ID`, `KundenNummer`, `ProduktID`, `Bestelldatum`, `Lieferdatum`, `Anzahl`) VALUES
(4, 1, 1, '2008-03-12', NULL, 2),
(5, 1, 2, '2008-03-15', '2008-03-18', 4),
(6, 1, 1, NULL, NULL, 1),
(7, 4, 4, NULL, NULL, 14),
(8, 1, 6, '2010-01-11', NULL, 6);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `kunde`
--

CREATE TABLE `kunde` (
  `Nummer` int(10) UNSIGNED NOT NULL,
  `Name` varchar(80) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `kunde`
--

INSERT INTO `kunde` (`Nummer`, `Name`) VALUES
(1, 'Hansi GmbH'),
(2, 'Scotty Mechanics AG'),
(3, 'Tesla Germany GmbH'),
(4, 'BMW AG'),
(5, 'Audi AG');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `produkt`
--

CREATE TABLE `produkt` (
  `ID` int(10) UNSIGNED NOT NULL,
  `ProduktKategorieID` int(10) UNSIGNED NOT NULL DEFAULT 0,
  `Name` varchar(80) NOT NULL DEFAULT '',
  `Preis` double UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `produkt`
--

INSERT INTO `produkt` (`ID`, `ProduktKategorieID`, `Name`, `Preis`) VALUES
(1, 1, 'RoomClean Pro', 459),
(2, 1, 'Fastomat Air', 299),
(3, 2, 'Lackierroboter 2000', 47300),
(4, 2, 'Lackierroboter 3000', 95600),
(5, 3, 'Autotrans L', 1700),
(6, 3, 'Autotrans XL', 5200);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `produktkategorie`
--

CREATE TABLE `produktkategorie` (
  `ID` int(10) UNSIGNED NOT NULL,
  `Name` varchar(45) NOT NULL DEFAULT '',
  `Code` char(2) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `produktkategorie`
--

INSERT INTO `produktkategorie` (`ID`, `Name`, `Code`) VALUES
(1, 'Reinigungsroboter', 'RR'),
(2, 'Freiarmroboter', 'FA'),
(3, 'Transportroboter', 'TR');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `bestellung`
--
ALTER TABLE `bestellung`
  ADD PRIMARY KEY (`ID`);

--
-- Indizes für die Tabelle `kunde`
--
ALTER TABLE `kunde`
  ADD PRIMARY KEY (`Nummer`);

--
-- Indizes für die Tabelle `produkt`
--
ALTER TABLE `produkt`
  ADD PRIMARY KEY (`ID`);

--
-- Indizes für die Tabelle `produktkategorie`
--
ALTER TABLE `produktkategorie`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `bestellung`
--
ALTER TABLE `bestellung`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT für Tabelle `kunde`
--
ALTER TABLE `kunde`
  MODIFY `Nummer` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT für Tabelle `produkt`
--
ALTER TABLE `produkt`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT für Tabelle `produktkategorie`
--
ALTER TABLE `produktkategorie`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
