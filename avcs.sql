-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 11, 2024 at 12:57 AM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `avcs`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `id` int(11) NOT NULL,
  `Name` varchar(250) NOT NULL,
  `Date` date NOT NULL,
  `vet` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`id`, `Name`, `Date`, `vet`) VALUES
(2, 'Bilal', '2024-01-18', 'abc');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `Name` varchar(150) NOT NULL,
  `Age` int(11) NOT NULL,
  `Number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `Name`, `Age`, `Number`) VALUES
(0, 'Farzan', 18, 12345678);

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE `manager` (
  `User Name` varchar(255) NOT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`User Name`, `Password`, `Name`, `id`) VALUES
('admin', 'admin', 'admin', 0);

-- --------------------------------------------------------

--
-- Table structure for table `pet`
--

CREATE TABLE `pet` (
  `id` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `diagnosis` varchar(200) DEFAULT NULL,
  `prognosis` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pet`
--

INSERT INTO `pet` (`id`, `Name`, `diagnosis`, `prognosis`) VALUES
(1, 'Dog', 'Bawaseer', 'Teeka');

-- --------------------------------------------------------

--
-- Table structure for table `receptionists registration`
--

CREATE TABLE `receptionists registration` (
  `id` int(11) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `User Name` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `Status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receptionists registration`
--

INSERT INTO `receptionists registration` (`id`, `Name`, `User Name`, `Password`, `Status`) VALUES
(1, 'sdfs', 'sdfs', '1234', NULL),
(6, 'check', 'check', '1234', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `vets registration`
--

CREATE TABLE `vets registration` (
  `id` int(11) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `User Name` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `Status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vets registration`
--

INSERT INTO `vets registration` (`id`, `Name`, `User Name`, `Password`, `Status`) VALUES
(4, 'xyz', 'xyz', '1234', NULL),
(5, 'abc', 'abc', '1234', NULL),
(10, 'Vet1', 'Vet1', '54321', NULL),
(90, 'asss', 'asss', '123', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `week_working_rota`
--

CREATE TABLE `week_working_rota` (
  `User Name` varchar(250) NOT NULL,
  `Days` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `week_working_rota`
--

INSERT INTO `week_working_rota` (`User Name`, `Days`) VALUES
('abc', 'Monday'),
('abc', 'Monday,Tuesday,Wednesday');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`User Name`);

--
-- Indexes for table `receptionists registration`
--
ALTER TABLE `receptionists registration`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vets registration`
--
ALTER TABLE `vets registration`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
