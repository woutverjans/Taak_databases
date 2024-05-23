-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Gegenereerd op: 21 mei 2024 om 14:23
-- Serverversie: 10.4.32-MariaDB
-- PHP-versie: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `verjans_dabdeel2_database`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `clubs`
--

CREATE TABLE `clubs` (
  `Naam` varchar(100) NOT NULL COMMENT 'Naam van de club',
  `Adres` text NOT NULL COMMENT 'Adres van de club'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `matchen`
--

CREATE TABLE `matchen` (
  `match id` varchar(100) NOT NULL COMMENT 'id van de match opgebouwd volgens de structuur: speler-tegenstander-datum-tijd\r\n\r\nGeeft een error bij text dus is een lange varchar gebruikt',
  `Plein` text NOT NULL COMMENT 'De nummer of naam van het plein',
  `Tijdstip` varchar(5) NOT NULL COMMENT 'Tijdstip in formaat UUR:MINUTEN',
  `Datum` date NOT NULL COMMENT 'Datum van de wedstrijd (jaar-maand-dag)',
  `Soort` text DEFAULT NULL COMMENT 'Finale, halve finale, ... in geval van NULL gewone wedstrijd',
  `Speler 1` varchar(10) NOT NULL COMMENT 'ID van de eerste speler',
  `Speler 2` varchar(10) NOT NULL COMMENT 'ID van Speler 2',
  `Score speler 1` int(11) NOT NULL,
  `Score speler 2` int(11) NOT NULL,
  `id scheidsrechter` varchar(10) DEFAULT NULL COMMENT 'id van de speler die scheidsrechter is voor deze wedstrijd (als er iemand is aangeduid)',
  `Reeks` text NOT NULL COMMENT 'Reeks waar de match toe behoort'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `reeksen`
--

CREATE TABLE `reeksen` (
  `Naam` int(11) NOT NULL,
  `Geslacht` varchar(1) NOT NULL COMMENT 'M voor mannen, V voor vrouwen',
  `Max aantal punten` int(11) NOT NULL,
  `Toernooi` varchar(100) NOT NULL COMMENT 'ID van het toernooi waar de reeks tot behoort'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `spelers`
--

CREATE TABLE `spelers` (
  `Naam` text NOT NULL,
  `Id` varchar(10) NOT NULL COMMENT 'Id is een alfanumerieke string van 10 tekens lang (10^36 mogelijkheden) met als opbouw: voornaam+naam+hoeveelste met die voornaam en naam',
  `Ranking` int(11) NOT NULL COMMENT 'Ranking is een int omdat dit alleen getallen kunnen zijn',
  `Leeftijd` int(11) NOT NULL COMMENT 'Leeftijd kan alleen een getal zijn',
  `Hoogste positie` int(11) NOT NULL COMMENT 'Hoogste positie kan alleen een getal zijn',
  `Gewicht` int(11) NOT NULL COMMENT 'Gewicht (in kg) kan alleen een getal zijn',
  `Lengte` int(11) NOT NULL COMMENT 'Lengte (in cm) is een integer om te voorkomen dat er iets anders dan getallen gebruikt wordt',
  `Geslacht` varchar(1) NOT NULL COMMENT 'Geslacht is een VARCHAR van 1 karakter waar M voor man staat en V voor vrouw',
  `Toernooi` text DEFAULT NULL COMMENT 'Toernooi waar de speler voor ingeschreven is',
  `Wedstrijdleider bij` text DEFAULT NULL COMMENT 'Toernooi waar de speler wedstrijdleider bij is',
  `Club` text DEFAULT NULL COMMENT 'Club waar deze speler lid bij is, NULL wanneer niet lid bij een club'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Spelers houdt alle gegevens rond een speler bij';

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `toernooien`
--

CREATE TABLE `toernooien` (
  `ID` varchar(100) NOT NULL COMMENT 'ID van het toernooi opgebouwd volgens structuur NAAM CLUB + datum van het toernooi',
  `Naam` int(11) NOT NULL,
  `Locatie` text NOT NULL COMMENT 'Naam van de club waar het toernooi gespeeld wordt'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `clubs`
--
ALTER TABLE `clubs`
  ADD PRIMARY KEY (`Naam`);

--
-- Indexen voor tabel `matchen`
--
ALTER TABLE `matchen`
  ADD PRIMARY KEY (`match id`);

--
-- Indexen voor tabel `reeksen`
--
ALTER TABLE `reeksen`
  ADD PRIMARY KEY (`Naam`);

--
-- Indexen voor tabel `spelers`
--
ALTER TABLE `spelers`
  ADD PRIMARY KEY (`Id`);

--
-- Indexen voor tabel `toernooien`
--
ALTER TABLE `toernooien`
  ADD PRIMARY KEY (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
