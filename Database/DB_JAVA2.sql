-- --------------------------------------------------------
-- Host:                         103.169.35.190
-- Server version:               10.6.19-MariaDB - MariaDB Server
-- Server OS:                    Linux
-- HeidiSQL Version:             12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for DB_JAVA2
CREATE DATABASE IF NOT EXISTS `DB_JAVA2` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `DB_JAVA2`;

-- Dumping structure for table DB_JAVA2.ADMIN
CREATE TABLE IF NOT EXISTS `ADMIN` (
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL DEFAULT 'ethernet@mail.com',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table DB_JAVA2.ADMIN: ~3 rows (approximately)
DELETE FROM `ADMIN`;
INSERT INTO `ADMIN` (`username`, `password`, `admin_id`, `email`) VALUES
	('Admin', 'admin@123', 1, 'ethernet@mail.com'),
	('chezis', 'chezis@123', 2, 'ethernet@mail.com'),
	('a', 'a', 3, 'ethernet@mail.com');

-- Dumping structure for table DB_JAVA2.DEPARTMENT
CREATE TABLE IF NOT EXISTS `DEPARTMENT` (
  `DEPARTMENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEPARTMENT_NAME` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `DESCRIPTION` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  PRIMARY KEY (`DEPARTMENT_ID`),
  UNIQUE KEY `UNIQUE_NAME` (`DEPARTMENT_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table DB_JAVA2.DEPARTMENT: ~8 rows (approximately)
DELETE FROM `DEPARTMENT`;
INSERT INTO `DEPARTMENT` (`DEPARTMENT_ID`, `DEPARTMENT_NAME`, `DESCRIPTION`) VALUES
	(1, 'IT', 'Information Technology'),
	(2, 'BA', 'Business Analyst'),
	(3, 'R&D', 'Research & Development'),
	(4, 'WD', 'Website Designer'),
	(5, 'DM', 'Digital Marketing'),
	(6, 'GD', 'Graphic Designer'),
	(7, 'FD', 'FrontEnd Developer'),
	(8, 'BD', 'BackEnd Developer');

-- Dumping structure for table DB_JAVA2.EMPLOYEE
CREATE TABLE IF NOT EXISTS `EMPLOYEE` (
  `EMPLOYEE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMPLOYEE_NAME` varchar(50) DEFAULT NULL,
  `AGE` int(11) DEFAULT NULL,
  `DESCRIPTION` varchar(200) DEFAULT NULL,
  `DEPARTMENT_ID` int(11) DEFAULT NULL,
  `Email` varchar(65) DEFAULT NULL,
  PRIMARY KEY (`EMPLOYEE_ID`),
  KEY `DEPARTMENT_ID` (`DEPARTMENT_ID`),
  CONSTRAINT `EMPLOYEE_ibfk_1` FOREIGN KEY (`DEPARTMENT_ID`) REFERENCES `DEPARTMENT` (`DEPARTMENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table DB_JAVA2.EMPLOYEE: ~12 rows (approximately)
DELETE FROM `EMPLOYEE`;
INSERT INTO `EMPLOYEE` (`EMPLOYEE_ID`, `EMPLOYEE_NAME`, `AGE`, `DESCRIPTION`, `DEPARTMENT_ID`, `Email`) VALUES
	(1, 'Bùi Đức Trí', 20, 'FullStack Developer - Senior', 1, 'buiductri@cz.com'),
	(2, 'Trương Quốc Thiện', 30, 'Data Analyst - Senior', 2, 'truongquocthien@cz.com'),
	(4, 'Nguyễn Vủ Hậu', 17, 'BackEnd Developer - Fresher', 1, 'nguyenvuhau@cz.com'),
	(5, 'Bùi Quốc Đạt', 23, 'FullStack Developer - Senior', 3, 'buiquocdat@cz.com'),
	(6, 'Nguyễn Hoàng Minh Hiếu', 19, 'FrontEnd Developer - Junior', 4, 'nguyenhoangminhhieu@cz.com'),
	(7, 'Nguyễn Hải Đăng', 18, 'FrontEnd Developer - Middle', 4, 'nguyenhaidang@cz.com'),
	(8, 'Nguyễn Huỳnh Khánh Nguyên', 16, 'Graphic Designer', 6, 'nguyenhuynhkhanhnguyen@cz.com'),
	(9, 'Nguyễn Cát Nhã Đình', 19, 'PHP Developer - Newbie', 8, 'nguyencatnhadinh@cz.com'),
	(10, 'Nguyễn Công Danh', 19, 'PHP Developer - Newbie', 8, 'nguyencongdanh@cz.com'),
	(11, 'Hồ Hải Nam', 18, 'Web Deisgner - Intern', 4, 'hohainam@cz.com'),
	(12, 'Vũ Gia Hảo', 16, 'Spring Boot Dev - Intern', 7, 'vugiahao@cz.com'),
	(13, 'Huỳnh Gia Khôi', 16, 'FrontEnd Developer - Middle', 7, 'huynhgiakhoi@cz.com'),
	(14, 'Nguyễn Vủ Hậu', 27, 'SD1801 - Giảng Viên', 1, 'nguyenvuhau@cz.com');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
