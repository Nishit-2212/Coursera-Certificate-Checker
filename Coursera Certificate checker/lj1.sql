-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 01, 2024 at 05:13 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lj1`
--

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `course` varchar(255) DEFAULT NULL,
  `sem_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`id`, `course`, `sem_id`) VALUES
(2, 'Java Basic Structures: Arrays, Strings, and Files', 2),
(3, 'Data Visualization and Communication with\n Tableau', 3),
(4, 'Interactivity with JavaScript', 2),
(5, 'Networking Fundamentals', 3);

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `id` int(20) NOT NULL,
  `department` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`id`, `department`) VALUES
(1, 'IMCA'),
(2, 'IMBAA');

-- --------------------------------------------------------

--
-- Table structure for table `division`
--

CREATE TABLE `division` (
  `id` int(11) NOT NULL,
  `division` varchar(50) DEFAULT NULL,
  `sem_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `division`
--

INSERT INTO `division` (`id`, `division`, `sem_id`) VALUES
(1, 'A', 1),
(2, 'B', 2),
(3, 'B', 1),
(4, 'C', 1),
(5, 'F', 2),
(7, 'A', 2),
(8, 'C', 2),
(9, 'D', 2),
(10, 'E', 2),
(16, NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`id`, `name`, `email`, `password`) VALUES
(1, 'abc', 'abc@gmail.com', '123'),
(2, 'defg', 'def@gmail.com', '123');

-- --------------------------------------------------------

--
-- Table structure for table `query`
--

CREATE TABLE `query` (
  `id` int(20) NOT NULL,
  `query` varchar(35) NOT NULL,
  `stu_id` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `query`
--

INSERT INTO `query` (`id`, `query`, `stu_id`) VALUES
(2, 'hiiiiiii', 1);

-- --------------------------------------------------------

--
-- Table structure for table `semester`
--

CREATE TABLE `semester` (
  `id` int(11) NOT NULL,
  `semester` varchar(50) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `semester`
--

INSERT INTO `semester` (`id`, `semester`, `dept_id`) VALUES
(1, 'sem-1', 1),
(2, 'sem-2', 1),
(3, 'sem-3', 1),
(4, 'sem-4', 1),
(5, 'sem-5', 1),
(6, 'sem-6', 1);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  `sem_id` int(11) DEFAULT NULL,
  `div_id` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `enrollment_no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `name`, `dept_id`, `sem_id`, `div_id`, `email`, `password`, `enrollment_no`) VALUES
(1, 'NISHIT DHARMESHBHAI NAGAR', 1, 2, 2, 'nachiket224@gmail.com', '123', '21003501210020'),
(2, 'Harsh Pankajbhai Thakkar', 1, 2, 8, 'ramthak2003@gmail.com', '1234', '21003501210058'),
(3, 'Jaydip Ravindrabhai Prajapati', 1, 3, 5, 'jaydip@gmail.com', '123', '21003501210038'),
(4, 'Mithil Deven Bhatt', 1, 3, 5, 'mithildbhatt@gmail.com', '12345', '21003501210005'),
(5, 'patel divya', 1, 3, 4, 'divyapatel7559@gmail.com', '1234', '21003501210027'),
(6, 'soni sahil', 1, 2, 4, 'sonisahil405@gmail.com', '1234', '21003501210054'),
(7, 'shah kathan ', 1, 3, 4, 'kathan063@gmail.com', '123', '21003500046'),
(8, 'shah hitanshi', 1, 2, 3, 'hitanshishah45@gmail.com', '1234', '21003501210045'),
(9, 'jankit12', 1, 2, 2, 'jankit@gmail.com', '1234', '2147483647'),
(10, 'kathan', 1, 2, 2, 'kathan', '123', '2147483647'),
(13, 'deval desai', 1, 2, 2, 'desaideval76@gmail.com', '1234', '2100350121004'),
(14, 'jain sid', 1, 3, 3, 'jainsiddharth548@gmail.com', '1234', '2100'),
(15, 'jankit', 1, 2, 2, 'jankit@gmail.com', '123', '2147483647'),
(16, 'kathan', 1, 2, 2, 'kathan', '123', '2147483647'),
(17, 'abc', 1, 2, 2, 'jankit@gmail.com', '123', '2147483647'),
(18, 'xyz', 1, 2, 2, 'kathan', '123', '2147483647'),
(19, 'Nagar Karan Mahesh Bhai', 1, 2, 8, 'nagarkmn@gmail.com', '123', '21003501210019');

-- --------------------------------------------------------

--
-- Table structure for table `student_course`
--

CREATE TABLE `student_course` (
  `id` int(11) NOT NULL,
  `stu_id` int(11) DEFAULT NULL,
  `co_id` int(11) DEFAULT NULL,
  `certificate_path` varchar(255) DEFAULT NULL,
  `submit_date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_course`
--

INSERT INTO `student_course` (`id`, `stu_id`, `co_id`, `certificate_path`, `submit_date`) VALUES
(23, 19, 2, 'C:\\Users\\Nishit\\eclipse-workspace\\Coursera_Certificate _checker\\certficates\\IMCA\\sem-2\\C', '2024-03-13'),
(28, 19, 4, 'C:\\Users\\Nishit\\eclipse-workspace\\Coursera_Certificate _checker\\certficates\\IMCA\\sem-2\\C\\karan javascript.pdf', '2024-03-13'),
(29, 2, 2, 'C:\\Users\\Nishit\\eclipse-workspace\\Coursera_Certificate _checker\\certficates\\IMCA\\sem-2\\C\\harsh thakkar java.pdf', '2024-03-17'),
(30, 1, 2, 'C:\\Users\\Nishit\\eclipse-workspace\\Coursera_Certificate _checker\\certficates\\IMCA\\sem-2\\B', '2024-03-30');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sem_id` (`sem_id`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `division`
--
ALTER TABLE `division`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sem_id` (`sem_id`);

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `query`
--
ALTER TABLE `query`
  ADD PRIMARY KEY (`id`),
  ADD KEY `stu_id` (`stu_id`);

--
-- Indexes for table `semester`
--
ALTER TABLE `semester`
  ADD PRIMARY KEY (`id`),
  ADD KEY `dept_id` (`dept_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`),
  ADD KEY `dept_id` (`dept_id`),
  ADD KEY `sem_id` (`sem_id`),
  ADD KEY `div_id` (`div_id`);

--
-- Indexes for table `student_course`
--
ALTER TABLE `student_course`
  ADD PRIMARY KEY (`id`),
  ADD KEY `stu_id` (`stu_id`),
  ADD KEY `co_id` (`co_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `division`
--
ALTER TABLE `division`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `faculty`
--
ALTER TABLE `faculty`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `query`
--
ALTER TABLE `query`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `semester`
--
ALTER TABLE `semester`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `student_course`
--
ALTER TABLE `student_course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `course_ibfk_1` FOREIGN KEY (`sem_id`) REFERENCES `semester` (`id`);

--
-- Constraints for table `query`
--
ALTER TABLE `query`
  ADD CONSTRAINT `query_ibfk_1` FOREIGN KEY (`stu_id`) REFERENCES `student` (`id`);

--
-- Constraints for table `semester`
--
ALTER TABLE `semester`
  ADD CONSTRAINT `semester_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`id`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`id`),
  ADD CONSTRAINT `student_ibfk_2` FOREIGN KEY (`sem_id`) REFERENCES `semester` (`id`),
  ADD CONSTRAINT `student_ibfk_3` FOREIGN KEY (`div_id`) REFERENCES `division` (`id`);

--
-- Constraints for table `student_course`
--
ALTER TABLE `student_course`
  ADD CONSTRAINT `student_course_ibfk_1` FOREIGN KEY (`stu_id`) REFERENCES `student` (`id`),
  ADD CONSTRAINT `student_course_ibfk_2` FOREIGN KEY (`co_id`) REFERENCES `course` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
