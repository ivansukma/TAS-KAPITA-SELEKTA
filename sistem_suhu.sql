-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 27, 2020 at 02:58 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sistem_suhu`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_temperatur`
--

CREATE TABLE `data_temperatur` (
  `id_form` varchar(10) NOT NULL,
  `tanggal_periksa` date NOT NULL,
  `suhu_tubuh` double NOT NULL,
  `konfirmasi_suhu` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `form_kepentingan`
--

CREATE TABLE `form_kepentingan` (
  `id_form` varchar(10) NOT NULL,
  `id_mahasiswa` varchar(10) NOT NULL,
  `id_admin` varchar(10) NOT NULL,
  `kepentingan` text NOT NULL,
  `riwayat_penyakit` varchar(200) NOT NULL,
  `fakultas_kunjungan` varchar(50) NOT NULL,
  `status` enum('"menunggu"','"diterima"','"ditolak"') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `kuesioner`
--

CREATE TABLE `kuesioner` (
  `id_kuesioner` varchar(10) NOT NULL,
  `id_form` varchar(10) NOT NULL,
  `gejala_umum` tinyint(1) NOT NULL,
  `kunjungan_RS` varchar(50) NOT NULL,
  `kunjungan_luarkota` varchar(50) NOT NULL,
  `status_pernahdirawat_covid19` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `macam_gejala`
--

CREATE TABLE `macam_gejala` (
  `id_kuesioner` varchar(10) NOT NULL,
  `ragam_gejala` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `ID_Pengguna` varchar(10) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `telefon` varchar(20) NOT NULL,
  `status_daftarulang` tinyint(1) NOT NULL,
  `tanggal_boleh_daftarulang` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_temperatur`
--
ALTER TABLE `data_temperatur`
  ADD PRIMARY KEY (`id_form`);

--
-- Indexes for table `form_kepentingan`
--
ALTER TABLE `form_kepentingan`
  ADD PRIMARY KEY (`id_form`),
  ADD KEY `id_admin` (`id_admin`),
  ADD KEY `id_mahasiswa` (`id_mahasiswa`);

--
-- Indexes for table `kuesioner`
--
ALTER TABLE `kuesioner`
  ADD PRIMARY KEY (`id_kuesioner`),
  ADD KEY `id_form` (`id_form`);

--
-- Indexes for table `macam_gejala`
--
ALTER TABLE `macam_gejala`
  ADD PRIMARY KEY (`id_kuesioner`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`ID_Pengguna`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `data_temperatur`
--
ALTER TABLE `data_temperatur`
  ADD CONSTRAINT `data_temperatur_ibfk_1` FOREIGN KEY (`id_form`) REFERENCES `form_kepentingan` (`id_form`);

--
-- Constraints for table `form_kepentingan`
--
ALTER TABLE `form_kepentingan`
  ADD CONSTRAINT `form_kepentingan_ibfk_1` FOREIGN KEY (`id_admin`) REFERENCES `pengguna` (`ID_Pengguna`),
  ADD CONSTRAINT `form_kepentingan_ibfk_2` FOREIGN KEY (`id_mahasiswa`) REFERENCES `pengguna` (`ID_Pengguna`);

--
-- Constraints for table `kuesioner`
--
ALTER TABLE `kuesioner`
  ADD CONSTRAINT `kuesioner_ibfk_1` FOREIGN KEY (`id_form`) REFERENCES `form_kepentingan` (`id_form`);

--
-- Constraints for table `macam_gejala`
--
ALTER TABLE `macam_gejala`
  ADD CONSTRAINT `macam_gejala_ibfk_1` FOREIGN KEY (`id_kuesioner`) REFERENCES `kuesioner` (`id_kuesioner`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
