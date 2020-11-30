-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 30, 2020 at 02:13 PM
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
-- Database: `cek_suhu`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_temperatur`
--

CREATE TABLE `data_temperatur` (
  `id` int(11) NOT NULL,
  `id_form` int(11) NOT NULL,
  `tanggal_periksa` date NOT NULL,
  `suhu_tubuh` double NOT NULL,
  `konfirmasi_suhu` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `form_kepentingan`
--

CREATE TABLE `form_kepentingan` (
  `id_form` int(11) NOT NULL,
  `id_mahasiswa` varchar(10) DEFAULT NULL,
  `id_admin` varchar(10) DEFAULT NULL,
  `kepentingan` text NOT NULL,
  `riwayat_penyakit` varchar(200) NOT NULL,
  `fakultas_kunjungan` varchar(50) NOT NULL,
  `status` enum('menunggu','diterima','ditolak') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `form_kepentingan`
--

INSERT INTO `form_kepentingan` (`id_form`, `id_mahasiswa`, `id_admin`, `kepentingan`, `riwayat_penyakit`, `fakultas_kunjungan`, `status`) VALUES
(2, 'USER-00034', NULL, 'Kunjungan Pendaftaran', 'Sehat Kok', 'FTI', NULL),
(3, NULL, NULL, 'Cek Kampus', 'Sehat KOK', 'FTI', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `kuesioner`
--

CREATE TABLE `kuesioner` (
  `id` int(11) NOT NULL,
  `id_form` int(11) NOT NULL,
  `gejala_umum` varchar(200) NOT NULL,
  `kunjungan_RS` varchar(50) NOT NULL,
  `kunjungan_luarkota` varchar(50) NOT NULL,
  `status_pernahdirawat_covid19` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `macam_gejala`
--

CREATE TABLE `macam_gejala` (
  `id` int(11) NOT NULL,
  `ragam_gejala` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `ID_Pengguna` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `telefon` varchar(20) NOT NULL,
  `status_daftarulang` tinyint(1) DEFAULT NULL,
  `tanggal_boleh_daftarulang` date DEFAULT NULL
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

CREATE TABLE `persetujuan_user` (
  `tanggal_isiform` date NOT NULL,
  `id_kuesioner` int(11) DEFAULT NULL,
  `id_gejala` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_temperatur`
--
ALTER TABLE `data_temperatur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_form` (`id_form`);

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
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_form` (`id_form`);

--
-- Indexes for table `macam_gejala`
--
ALTER TABLE `macam_gejala`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`ID_Pengguna`);

--
-- Indexes for table `persetujuan_user`
--
ALTER TABLE `persetujuan_user`
  ADD KEY `id_kuesioner` (`id_kuesioner`),
  ADD KEY `id_gejala` (`id_gejala`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `data_temperatur`
--
ALTER TABLE `data_temperatur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `form_kepentingan`
--
ALTER TABLE `form_kepentingan`
  MODIFY `id_form` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `kuesioner`
--
ALTER TABLE `kuesioner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `macam_gejala`
--
ALTER TABLE `macam_gejala`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

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
