-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 31, 2023 at 01:15 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `database_e_surat`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `ID_Pengguna` char(10) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Password` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `aktivitas`
--

CREATE TABLE `aktivitas` (
  `ID_Aktivitas` char(10) NOT NULL,
  `Tanggal` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `Jenis_Aktivitas` varchar(30) NOT NULL,
  `Deskripsi` varchar(30) NOT NULL,
  `Admin_ID_Pengguna` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `data_diri`
--

CREATE TABLE `data_diri` (
  `NIM` char(10) NOT NULL,
  `Nama_Mahasiswa` varchar(30) NOT NULL,
  `Prodi` varchar(30) NOT NULL,
  `Jenjang_Studi` varchar(30) NOT NULL,
  `IPK` double NOT NULL,
  `Kontak` int(11) NOT NULL,
  `Angkatan` int(11) NOT NULL,
  `Semester` int(11) NOT NULL,
  `Alamat` varchar(30) NOT NULL,
  `TTL` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `data_diri`
--

INSERT INTO `data_diri` (`NIM`, `Nama_Mahasiswa`, `Prodi`, `Jenjang_Studi`, `IPK`, `Kontak`, `Angkatan`, `Semester`, `Alamat`, `TTL`) VALUES
('2209116045', 'Abdul Rahman', 'Sistem Informasi', 'S1', 3.65, 22, 2022, 3, 'Jln.Poros Lempake, Samarinda U', '2013-10-14 18:51:40');

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `ID_Pengguna` char(10) NOT NULL,
  `Data_Diri_NIM` char(10) NOT NULL,
  `Password` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pengajuan`
--

CREATE TABLE `pengajuan` (
  `ID_Pengajuan` char(10) NOT NULL,
  `Peruntukan` varchar(30) NOT NULL,
  `Lampiran` varchar(30) NOT NULL,
  `Mahasiswa_NIM1` char(10) NOT NULL,
  `Aktivitas_ID_Aktivitas` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `ID_Pengguna` char(10) NOT NULL,
  `Password` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`ID_Pengguna`, `Password`) VALUES
('2209116045', 123);

-- --------------------------------------------------------

--
-- Table structure for table `riwayat_surat`
--

CREATE TABLE `riwayat_surat` (
  `ID_Surat` varchar(30) NOT NULL,
  `Jenis_Surat` varchar(30) NOT NULL,
  `Status` varchar(20) NOT NULL,
  `Posisi_Surat` varchar(30) NOT NULL,
  `Action` varchar(20) NOT NULL,
  `Pengajuan_ID_Pengajuan` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`ID_Pengguna`);

--
-- Indexes for table `aktivitas`
--
ALTER TABLE `aktivitas`
  ADD PRIMARY KEY (`ID_Aktivitas`),
  ADD KEY `Aktivitas_Admin_FK` (`Admin_ID_Pengguna`);

--
-- Indexes for table `data_diri`
--
ALTER TABLE `data_diri`
  ADD PRIMARY KEY (`NIM`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`ID_Pengguna`),
  ADD UNIQUE KEY `Mahasiswa_PKv1` (`Data_Diri_NIM`);

--
-- Indexes for table `pengajuan`
--
ALTER TABLE `pengajuan`
  ADD PRIMARY KEY (`ID_Pengajuan`),
  ADD KEY `Pengajuan_Aktivitas_FK` (`Aktivitas_ID_Aktivitas`),
  ADD KEY `Pengajuan_Mahasiswa_FK` (`Mahasiswa_NIM1`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`ID_Pengguna`);

--
-- Indexes for table `riwayat_surat`
--
ALTER TABLE `riwayat_surat`
  ADD PRIMARY KEY (`ID_Surat`),
  ADD KEY `Riwayat_Surat_Pengajuan_FK` (`Pengajuan_ID_Pengajuan`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `Admin_Pengguna_FK` FOREIGN KEY (`ID_Pengguna`) REFERENCES `pengguna` (`ID_Pengguna`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `aktivitas`
--
ALTER TABLE `aktivitas`
  ADD CONSTRAINT `Aktivitas_Admin_FK` FOREIGN KEY (`Admin_ID_Pengguna`) REFERENCES `admin` (`ID_Pengguna`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD CONSTRAINT `Mahasiswa_Data_Diri_FK` FOREIGN KEY (`Data_Diri_NIM`) REFERENCES `data_diri` (`NIM`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `Mahasiswa_Pengguna_FK` FOREIGN KEY (`ID_Pengguna`) REFERENCES `pengguna` (`ID_Pengguna`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `pengajuan`
--
ALTER TABLE `pengajuan`
  ADD CONSTRAINT `Pengajuan_Aktivitas_FK` FOREIGN KEY (`Aktivitas_ID_Aktivitas`) REFERENCES `aktivitas` (`ID_Aktivitas`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `Pengajuan_Mahasiswa_FK` FOREIGN KEY (`Mahasiswa_NIM1`) REFERENCES `mahasiswa` (`Data_Diri_NIM`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `riwayat_surat`
--
ALTER TABLE `riwayat_surat`
  ADD CONSTRAINT `Riwayat_Surat_Pengajuan_FK` FOREIGN KEY (`Pengajuan_ID_Pengajuan`) REFERENCES `pengajuan` (`ID_Pengajuan`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
