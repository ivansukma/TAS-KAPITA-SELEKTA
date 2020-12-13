-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 13, 2020 at 08:52 AM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cek_suhu`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_temperatur`
--

DROP TABLE IF EXISTS `data_temperatur`;
CREATE TABLE IF NOT EXISTS `data_temperatur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_form` int(11) NOT NULL,
  `tanggal_periksa` date NOT NULL,
  `suhu_tubuh` double NOT NULL,
  `konfirmasi_suhu` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_form` (`id_form`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_temperatur`
--

INSERT INTO `data_temperatur` (`id`, `id_form`, `tanggal_periksa`, `suhu_tubuh`, `konfirmasi_suhu`) VALUES
(1, 8, '2020-12-08', 35, 0),
(2, 8, '2020-12-11', 36, 1),
(3, 17, '2020-12-11', 35, 1),
(4, 18, '2020-12-26', 23, 1);

-- --------------------------------------------------------

--
-- Table structure for table `form_kepentingan`
--

DROP TABLE IF EXISTS `form_kepentingan`;
CREATE TABLE IF NOT EXISTS `form_kepentingan` (
  `id_form` int(11) NOT NULL AUTO_INCREMENT,
  `id_mahasiswa` varchar(20) DEFAULT NULL,
  `id_admin` varchar(20) DEFAULT NULL,
  `kepentingan` text NOT NULL,
  `riwayat_penyakit` varchar(200) NOT NULL,
  `fakultas_kunjungan` varchar(50) NOT NULL,
  `status` enum('menunggu','diterima','ditolak') DEFAULT NULL,
  PRIMARY KEY (`id_form`),
  KEY `id_admin` (`id_admin`),
  KEY `id_mahasiswa` (`id_mahasiswa`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `form_kepentingan`
--

INSERT INTO `form_kepentingan` (`id_form`, `id_mahasiswa`, `id_admin`, `kepentingan`, `riwayat_penyakit`, `fakultas_kunjungan`, `status`) VALUES
(2, 'USER-00034', NULL, 'Kunjungan Pendaftaran', 'Sehat Kok', 'FTI', 'diterima'),
(8, 'USER-00034', NULL, 'Ke kampus', 'Tidak ada', 'FTI', 'diterima'),
(9, 'USER-00034', NULL, 'Ke kampus', 'Tidak ada', 'FTI', 'ditolak'),
(13, 'USER-00015', NULL, 'Tes', 'Gk Papa', 'FTI', 'diterima'),
(17, 'USER-00017', NULL, 'Ke kampus', 'Tidak ada', 'FTI', 'ditolak'),
(18, 'USER-00017', NULL, 'Ke kampus', 'Tidak ada', 'FTI', 'diterima'),
(26, 'USER-00017', 'USER-00016', 'Ke kampus', 'Tidak ada', 'FTI', 'diterima');

-- --------------------------------------------------------

--
-- Table structure for table `kuesioner`
--

DROP TABLE IF EXISTS `kuesioner`;
CREATE TABLE IF NOT EXISTS `kuesioner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_form` int(11) NOT NULL,
  `gejala_umum` varchar(200) DEFAULT NULL,
  `kunjungan_RS` varchar(50) NOT NULL,
  `kunjungan_luarkota` varchar(50) NOT NULL,
  `status_pernahdirawat_covid19` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_form` (`id_form`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kuesioner`
--

INSERT INTO `kuesioner` (`id`, `id_form`, `gejala_umum`, `kunjungan_RS`, `kunjungan_luarkota`, `status_pernahdirawat_covid19`) VALUES
(1, 8, 'Batuk', 'Ya', 'Ya', 'Ya'),
(2, 9, 'Batuk,Radang', 'Ya', 'Ya', 'Ya'),
(5, 8, 'Batuk', 'Ya', 'Ya', 'Ya'),
(6, 26, 'Batuk', 'Ya', 'Ya', 'Ya');

-- --------------------------------------------------------

--
-- Table structure for table `macam_gejala`
--

DROP TABLE IF EXISTS `macam_gejala`;
CREATE TABLE IF NOT EXISTS `macam_gejala` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ragam_gejala` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

DROP TABLE IF EXISTS `pengguna`;
CREATE TABLE IF NOT EXISTS `pengguna` (
  `ID_Pengguna` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_Pengguna`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`ID_Pengguna`, `email`, `nama`) VALUES
('USER-00015', 'hartonomatthew0@gmail.com', 'Matthew Adian Hartono'),
('USER-00016', '672018048@student.uksw.edu', 'Ivan Sukma Hanindria'),
('USER-00017', 'robertusbagaskara@gmail.com', 'Robertus Bagaskara Radite Putra'),
('USER-00034', 'matthewadian@yahoo.com', 'Matthew Adian');

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
