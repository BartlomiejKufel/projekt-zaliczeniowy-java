-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Maj 12, 2025 at 12:50 PM
-- Wersja serwera: 10.4.32-MariaDB
-- Wersja PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `crowdle`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `gamedifficulty`
--

CREATE TABLE `gamedifficulty` (
  `gameDifficultyId` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `gamedifficulty`
--

INSERT INTO `gamedifficulty` (`gameDifficultyId`, `name`) VALUES
(1, 'Łatwy'),
(2, 'Średni'),
(3, 'Trudny'),
(4, 'Trening');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `gamehistory`
--

CREATE TABLE `gamehistory` (
  `gameId` int(11) NOT NULL,
  `playerId` int(11) DEFAULT NULL,
  `gameDate` date DEFAULT NULL,
  `scorepoint` int(11) DEFAULT NULL,
  `questionScore` int(11) DEFAULT NULL,
  `playerAnswers` int(11) DEFAULT NULL,
  `gameDifficultyId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `notifications`
--

CREATE TABLE `notifications` (
  `notificationId` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `message` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `playeranswers`
--

CREATE TABLE `playeranswers` (
  `playerAnswersId` int(11) NOT NULL,
  `playerAnswers` varchar(50) NOT NULL,
  `answersCheck` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `questions`
--

CREATE TABLE `questions` (
  `questionId` int(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  `answerA` varchar(50) DEFAULT NULL,
  `answerB` varchar(50) DEFAULT NULL,
  `answerC` varchar(50) DEFAULT NULL,
  `answerD` varchar(50) DEFAULT NULL,
  `correctAnswer` enum('A','B','C','D') DEFAULT NULL,
  `topicId` int(11) NOT NULL,
  `difficultyId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `ranking`
--

CREATE TABLE `ranking` (
  `playerId` int(11) NOT NULL,
  `points` int(11) NOT NULL,
  `rankId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ranking`
--

INSERT INTO `ranking` (`playerId`, `points`, `rankId`) VALUES
(1, 1300, 7),
(2, 0, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `ranks`
--

CREATE TABLE `ranks` (
  `rankId` int(11) NOT NULL,
  `requirement` int(11) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `lossPoints` int(11) DEFAULT NULL,
  `winPoints` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ranks`
--

INSERT INTO `ranks` (`rankId`, `requirement`, `name`, `lossPoints`, `winPoints`) VALUES
(1, 0, 'Pisklę Cienia', 0, 10),
(2, 100, 'Młody Kruk', 2, 12),
(3, 250, 'Obserwator Gałęzi', 4, 14),
(4, 400, 'Szept Lasu', 6, 16),
(5, 600, 'Strażnik Ksiąg', 8, 18),
(6, 850, 'Kruk Zagadek', 10, 20),
(7, 1100, 'Cień Proroctwa', 12, 22),
(8, 1400, 'Wiedzący Kruk', 14, 24),
(9, 1750, 'Mistrz Czarnych Piór', 16, 26),
(10, 2150, 'Król Kruków', 18, 28);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `topics`
--

CREATE TABLE `topics` (
  `topicId` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `topics`
--

INSERT INTO `topics` (`topicId`, `name`) VALUES
(1, 'Historia'),
(2, 'Nauka i Technika'),
(3, 'Kultura i Sztuka'),
(4, 'Mitologia i Legendy'),
(5, 'Geografia'),
(6, 'Popkultura');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `userId` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(30) NOT NULL,
  `createdAt` datetime DEFAULT NULL,
  `isAdmin` tinyint(1) NOT NULL,
  `selectedTheme` enum('light','dark') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userId`, `username`, `email`, `password`, `createdAt`, `isAdmin`, `selectedTheme`) VALUES
(1, 'admin', 'admin@test.pl', 'admin', '2025-05-12 12:15:29', 1, 'dark'),
(2, 'user', 'user@test.pl', 'user', '2025-05-12 12:16:52', 0, 'dark');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `gamedifficulty`
--
ALTER TABLE `gamedifficulty`
  ADD PRIMARY KEY (`gameDifficultyId`);

--
-- Indeksy dla tabeli `gamehistory`
--
ALTER TABLE `gamehistory`
  ADD PRIMARY KEY (`gameId`),
  ADD KEY `playerId` (`playerId`),
  ADD KEY `gameDifficultyId` (`gameDifficultyId`),
  ADD KEY `playerAnswers` (`playerAnswers`);

--
-- Indeksy dla tabeli `notifications`
--
ALTER TABLE `notifications`
  ADD PRIMARY KEY (`notificationId`),
  ADD KEY `userId` (`userId`);

--
-- Indeksy dla tabeli `playeranswers`
--
ALTER TABLE `playeranswers`
  ADD PRIMARY KEY (`playerAnswersId`);

--
-- Indeksy dla tabeli `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`questionId`),
  ADD KEY `topicId` (`topicId`),
  ADD KEY `difficultyId` (`difficultyId`);

--
-- Indeksy dla tabeli `ranking`
--
ALTER TABLE `ranking`
  ADD UNIQUE KEY `playerId` (`playerId`),
  ADD KEY `rankId` (`rankId`);

--
-- Indeksy dla tabeli `ranks`
--
ALTER TABLE `ranks`
  ADD PRIMARY KEY (`rankId`);

--
-- Indeksy dla tabeli `topics`
--
ALTER TABLE `topics`
  ADD PRIMARY KEY (`topicId`);

--
-- Indeksy dla tabeli `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `gamedifficulty`
--
ALTER TABLE `gamedifficulty`
  MODIFY `gameDifficultyId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `gamehistory`
--
ALTER TABLE `gamehistory`
  MODIFY `gameId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `notifications`
--
ALTER TABLE `notifications`
  MODIFY `notificationId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `playeranswers`
--
ALTER TABLE `playeranswers`
  MODIFY `playerAnswersId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `questionId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ranks`
--
ALTER TABLE `ranks`
  MODIFY `rankId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `topics`
--
ALTER TABLE `topics`
  MODIFY `topicId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `gamehistory`
--
ALTER TABLE `gamehistory`
  ADD CONSTRAINT `gamehistory_ibfk_1` FOREIGN KEY (`playerId`) REFERENCES `users` (`userId`),
  ADD CONSTRAINT `gamehistory_ibfk_2` FOREIGN KEY (`gameDifficultyId`) REFERENCES `gamedifficulty` (`gameDifficultyId`),
  ADD CONSTRAINT `gamehistory_ibfk_3` FOREIGN KEY (`playerAnswers`) REFERENCES `playeranswers` (`playerAnswersId`);

--
-- Constraints for table `notifications`
--
ALTER TABLE `notifications`
  ADD CONSTRAINT `notifications_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`);

--
-- Constraints for table `questions`
--
ALTER TABLE `questions`
  ADD CONSTRAINT `questions_ibfk_1` FOREIGN KEY (`topicId`) REFERENCES `topics` (`topicId`),
  ADD CONSTRAINT `questions_ibfk_2` FOREIGN KEY (`difficultyId`) REFERENCES `gamedifficulty` (`gameDifficultyId`);

--
-- Constraints for table `ranking`
--
ALTER TABLE `ranking`
  ADD CONSTRAINT `ranking_ibfk_1` FOREIGN KEY (`playerId`) REFERENCES `users` (`userId`),
  ADD CONSTRAINT `ranking_ibfk_2` FOREIGN KEY (`rankId`) REFERENCES `ranks` (`rankId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
