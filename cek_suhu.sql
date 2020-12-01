-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 01, 2020 at 05:56 AM
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `form_kepentingan`
--

DROP TABLE IF EXISTS `form_kepentingan`;
CREATE TABLE IF NOT EXISTS `form_kepentingan` (
  `id_form` int(11) NOT NULL AUTO_INCREMENT,
  `id_mahasiswa` varchar(10) DEFAULT NULL,
  `id_admin` varchar(10) DEFAULT NULL,
  `kepentingan` text NOT NULL,
  `riwayat_penyakit` varchar(200) NOT NULL,
  `fakultas_kunjungan` varchar(50) NOT NULL,
  `status` enum('menunggu','diterima','ditolak') DEFAULT NULL,
  PRIMARY KEY (`id_form`),
  KEY `id_admin` (`id_admin`),
  KEY `id_mahasiswa` (`id_mahasiswa`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `form_kepentingan`
--

INSERT INTO `form_kepentingan` (`id_form`, `id_mahasiswa`, `id_admin`, `kepentingan`, `riwayat_penyakit`, `fakultas_kunjungan`, `status`) VALUES
(2, 'USER-00034', NULL, 'Kunjungan Pendaftaran', 'Sehat Kok', 'FTI', NULL),
(3, NULL, NULL, 'Cek Kampus', 'Sehat KOK', 'FTI', NULL),
(6, NULL, NULL, 'Ke kampus', 'Tidak ada', 'FTI', NULL),
(7, NULL, NULL, 'Ke kampus', 'Tidak ada', 'FBS', NULL),
(8, NULL, NULL, 'Ke kampus', 'Tidak ada', 'FTI', NULL),
(9, NULL, NULL, 'Ke kampus', 'Tidak ada', 'FTI', NULL),
(10, NULL, NULL, 'Ke kampus', 'Tidak ada', 'FTI', NULL),
(11, NULL, NULL, 'Ke kampus', 'Tidak ada', 'FTI', NULL),
(12, NULL, NULL, 'Ke kampus', 'Tidak ada', 'FTI', NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kuesioner`
--

INSERT INTO `kuesioner` (`id`, `id_form`, `gejala_umum`, `kunjungan_RS`, `kunjungan_luarkota`, `status_pernahdirawat_covid19`) VALUES
(1, 8, 'Batuk', 'Ya', 'Ya', 'Ya'),
(2, 9, 'Batuk,Radang', 'Ya', 'Ya', 'Ya'),
(3, 8, 'Batuk', 'Ya', 'Ya', 'Ya'),
(4, 8, NULL, 'Ya', 'Ya', 'Ya');

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
  `telefon` varchar(20) NOT NULL,
  `status_daftarulang` tinyint(1) DEFAULT NULL,
  `tanggal_boleh_daftarulang` date DEFAULT NULL,
  PRIMARY KEY (`ID_Pengguna`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`ID_Pengguna`, `email`, `nama`, `telefon`, `status_daftarulang`, `tanggal_boleh_daftarulang`) VALUES
('USER-00034', 'matthewadian@yahoo.com', 'Matthew Adian', '0123456789', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `persetujuan_user`
--

DROP TABLE IF EXISTS `persetujuan_user`;
CREATE TABLE IF NOT EXISTS `persetujuan_user` (
  `tanggal_isiform` date NOT NULL,
  `id_kuesioner` int(11) DEFAULT NULL,
  `id_gejala` int(11) DEFAULT NULL,
  KEY `id_kuesioner` (`id_kuesioner`),
  KEY `id_gejala` (`id_gejala`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
-- Constraints for table `persetujuan_user`
--
ALTER TABLE `persetujuan_user`
  ADD CONSTRAINT `persetujuan_user_ibfk_1` FOREIGN KEY (`id_kuesioner`) REFERENCES `kuesioner` (`id`),
  ADD CONSTRAINT `persetujuan_user_ibfk_2` FOREIGN KEY (`id_gejala`) REFERENCES `macam_gejala` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
