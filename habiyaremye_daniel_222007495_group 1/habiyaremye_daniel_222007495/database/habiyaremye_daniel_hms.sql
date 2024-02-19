-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 09:48 AM
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
-- Database: `habiyaremye_daniel_hms`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteBanksByContact` (IN `contact_to_delete` VARCHAR(255))   BEGIN
    DELETE FROM bank WHERE contact_number = contact_to_delete;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteStudentsByCourse` (IN `course_to_delete` VARCHAR(255))   BEGIN
    DELETE FROM student WHERE course = course_to_delete;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DisplayAdmins` ()   BEGIN
    SELECT * FROM admin;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DisplayBanks` ()   BEGIN
    SELECT * FROM bank;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DisplayHostelManagers` ()   BEGIN
    SELECT * FROM hostel_manager;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DisplayStudents` ()   BEGIN
    SELECT * FROM student;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertAdmin` (IN `admin_name` VARCHAR(255), IN `admin_email` VARCHAR(255), IN `admin_password` VARCHAR(255), IN `admin_phone` VARCHAR(255), IN `admin_role` VARCHAR(255), IN `admin_bank_id` INT)   BEGIN
    INSERT INTO admin (name, email, password, phone_number, role, bank_id)
    VALUES (admin_name, admin_email, admin_password, admin_phone, admin_role, admin_bank_id);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertBank` (IN `bank_name` VARCHAR(255), IN `bank_address` VARCHAR(255), IN `bank_contact_number` VARCHAR(255), IN `bank_account_number` VARCHAR(255))   BEGIN
    INSERT INTO bank (name, address, contact_number, account_number)
    VALUES (bank_name, bank_address, bank_contact_number, bank_account_number);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertHostelManager` (IN `manager_name` VARCHAR(255), IN `manager_email` VARCHAR(255), IN `manager_password` VARCHAR(255), IN `manager_phone` VARCHAR(255), IN `manager_role` VARCHAR(255), IN `manager_bank_id` INT)   BEGIN
    INSERT INTO hostel_manager (name, email, password, phone_number, role, bank_id)
    VALUES (manager_name, manager_email, manager_password, manager_phone, manager_role, manager_bank_id);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertMaintenanceStaff` (IN `staff_name` VARCHAR(50), IN `staff_contact` VARCHAR(15), IN `staff_specialization` VARCHAR(50), IN `staff_schedule` VARCHAR(100), IN `staff_date` DATE, IN `staff_emergency_contact` VARCHAR(15))   BEGIN
    INSERT INTO MaintenanceStaff (Name, ContactNumber, Specialization, WorkSchedule, DateOfEmployment, EmergencyContact)
    VALUES (staff_name, staff_contact, staff_specialization, staff_schedule, staff_date, staff_emergency_contact);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertRoom` (IN `room_number` INT, IN `capacity` INT, IN `room_type` VARCHAR(255), IN `room_rent` FLOAT, IN `room_facilities` VARCHAR(255))   BEGIN
    INSERT INTO room (room_number, capacity, type, rent, facilities)
    VALUES (room_number, capacity, room_type, room_rent, room_facilities);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertStudent` (IN `student_name` VARCHAR(255), IN `student_email` VARCHAR(255), IN `student_password` VARCHAR(255), IN `student_phone` VARCHAR(255), IN `student_gender` VARCHAR(255), IN `student_dob` DATE, IN `student_course` VARCHAR(255), IN `student_year_of_study` INT, IN `student_room_number` INT, IN `student_bank_id` INT)   BEGIN
    INSERT INTO student (name, email, password, phone_number, gender, date_of_birth, course, year_of_study, room_number, bank_id)
    VALUES (student_name, student_email, student_password, student_phone, student_gender, student_dob, student_course, student_year_of_study, student_room_number, student_bank_id);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateRoom` (IN `room_id_param` INT, IN `new_room_number` INT, IN `new_capacity` INT, IN `new_type` VARCHAR(255), IN `new_rent` FLOAT, IN `new_facilities` VARCHAR(255))   BEGIN
    UPDATE room
    SET room_number = new_room_number,
        capacity = new_capacity,
        type = new_type,
        rent = new_rent,
        facilities = new_facilities
    WHERE room_id = room_id_param;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateStudent` (IN `student_id_param` INT, IN `new_name` VARCHAR(255), IN `new_email` VARCHAR(255), IN `new_phone` VARCHAR(255), IN `new_gender` VARCHAR(255), IN `new_dob` DATE, IN `new_course` VARCHAR(255), IN `new_year_of_study` INT, IN `new_room_number` INT, IN `new_bank_id` INT)   BEGIN
    UPDATE student
    SET name = new_name,
        email = new_email,
        phone_number = new_phone,
        gender = new_gender,
        date_of_birth = new_dob,
        course = new_course,
        year_of_study = new_year_of_study,
        room_number = new_room_number,
        bank_id = new_bank_id
    WHERE student_id = student_id_param;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `bank_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `name`, `email`, `password`, `phone_number`, `role`, `bank_id`) VALUES
(7, 'peter', 'peter@gmail.com', 'password124', '+250783940473', 'Admin', 2),
(9, 'PRINCE', 'prince@gmail.com', 'password123', '+250783240473', 'Admin', 1),
(10, 'PRINCE', 'prince@gmail.com', 'password123', '+250783240473', 'Admin', 1),
(11, 'PRINCILLE', 'princille@gmail.com', 'password125', '+250783640403', 'Admin', 3),
(12, 'PRINCILLE', 'princille@gmail.com', 'password125', '+250783640403', 'Admin', 3);

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE `bank` (
  `bank_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `contact_number` varchar(255) NOT NULL,
  `account_number` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bank`
--

INSERT INTO `bank` (`bank_id`, `name`, `address`, `contact_number`, `account_number`) VALUES
(1, 'bank of kigali', 'huye', '+250729554144', '1234567890'),
(2, 'Bank of kigali', 'kigali', '+250791291384', '1234567890'),
(3, 'Bank of kigali', 'rulindo', '+250791298384', '1234567890'),
(19, 'bank of kigali', 'huye', '+250729554144', '1234567890'),
(20, 'bank of kigali', 'huye', '+250729554144', '1234567890'),
(21, 'Bank of kigali', 'kigali', '+250791291384', '1234567890'),
(22, 'bank of kigali', 'huye', '+250729554144', '1234567890'),
(24, 'bank of kigali', 'huye', '+250729554144', '1234567890'),
(25, 'bank of kigali', 'RANGO', '+250729554144', '1234567890');

--
-- Triggers `bank`
--
DELIMITER $$
CREATE TRIGGER `AfterInsertBank` AFTER INSERT ON `bank` FOR EACH ROW BEGIN
    INSERT INTO bank_audit (bank_id, action, action_date)
    VALUES (NEW.bank_id, 'INSERT', NOW());
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `AfterUpdateBank` AFTER UPDATE ON `bank` FOR EACH ROW BEGIN
    INSERT INTO bank_audit (bank_id, action, action_date)
    VALUES (NEW.bank_id, 'UPDATE', NOW());
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `bank_audit`
--

CREATE TABLE `bank_audit` (
  `id` int(11) NOT NULL,
  `bank_id` int(11) DEFAULT NULL,
  `action` varchar(50) DEFAULT NULL,
  `action_date` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bank_audit`
--

INSERT INTO `bank_audit` (`id`, `bank_id`, `action`, `action_date`) VALUES
(1, 1, 'UPDATE', '2024-02-16 08:30:46'),
(2, 2, 'UPDATE', '2024-02-16 08:32:33'),
(3, 1, 'UPDATE', '2024-02-16 08:34:22'),
(4, 19, 'INSERT', '2024-02-16 08:37:16'),
(5, 1, 'UPDATE', '2024-02-16 08:37:27'),
(6, 1, 'UPDATE', '2024-02-16 08:37:27'),
(7, 20, 'INSERT', '2024-02-16 08:54:25'),
(8, 1, 'UPDATE', '2024-02-16 08:54:30'),
(9, 21, 'INSERT', '2024-02-16 11:22:22'),
(10, 2, 'UPDATE', '2024-02-16 11:22:36'),
(11, 22, 'INSERT', '2024-02-16 11:24:14'),
(12, 1, 'UPDATE', '2024-02-16 11:24:20'),
(13, 23, 'INSERT', '2024-02-16 11:27:09'),
(14, 24, 'INSERT', '2024-02-18 14:14:53'),
(15, 1, 'UPDATE', '2024-02-18 14:14:58'),
(16, 25, 'INSERT', '2024-02-18 14:15:12');

-- --------------------------------------------------------

--
-- Stand-in structure for view `delete_view`
-- (See below for the actual view)
--
CREATE TABLE `delete_view` (
`name` varchar(255)
,`address` varchar(255)
,`contact_number` varchar(255)
);

-- --------------------------------------------------------

--
-- Table structure for table `hostel_manager`
--

CREATE TABLE `hostel_manager` (
  `hostel_manager_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `bank_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hostel_manager`
--

INSERT INTO `hostel_manager` (`hostel_manager_id`, `name`, `email`, `password`, `phone_number`, `role`, `bank_id`) VALUES
(109, 'Mary', 'mary@gmail.com', 'password789', '+250729554184', 'Hostel ManagerI', 1),
(110, 'dad', 'dad@gmail.com', 'password791', '+250729554104', 'Hostel ManagerIII', 3),
(111, 'Maria', 'maria@gmail.com', 'password790', '+250729550144', 'Hostel ManagerII', 2),
(112, 'Maria', 'maria@gmail.com', 'password790', '+250729550144', 'Hostel ManagerII', 2),
(113, 'Mary', 'mary@gmail.com', 'password789', '+250729554184', 'Hostel ManagerI', 1),
(114, 'Mary', 'mary@gmail.com', 'password789', '+250729554184', 'Hostel ManagerI', 1),
(115, 'Mary', 'mary@gmail.com', 'password789', '+250729554184', 'Hostel ManagerI', 1);

-- --------------------------------------------------------

--
-- Table structure for table `maintenancestaff`
--

CREATE TABLE `maintenancestaff` (
  `StaffID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `ContactNumber` varchar(15) DEFAULT NULL,
  `Specialization` varchar(50) DEFAULT NULL,
  `WorkSchedule` varchar(100) DEFAULT NULL,
  `DateOfEmployment` date DEFAULT NULL,
  `EmergencyContact` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `maintenancestaff`
--

INSERT INTO `maintenancestaff` (`StaffID`, `Name`, `ContactNumber`, `Specialization`, `WorkSchedule`, `DateOfEmployment`, `EmergencyContact`) VALUES
(3, 'donatha', '0725050277', 'plumbing', 'mon-Sat 10 AM - 6 PM', '2021-09-10', '555-555-5565'),
(6, 'donatha', '0725050277', 'plumbing', 'mon-Sat 10 AM - 6 PM', '2021-10-10', '555-555-5565'),
(7, 'claire', '0725050364', 'Electrical', 'Tue-Sat 11 AM - 7 PM', '2021-10-11', '555-555-5755'),
(8, 'claire', '0725050000', 'Electrical', 'Tue-Sat 11 AM - 7 PM', '2021-10-11', '555-777-5755'),
(9, 'donatha', '0725050277', 'plumbing', 'mon-Sat 10 AM - 6 PM', '2021-10-10', '555-555-5565'),
(10, 'donatha', '0725050277', 'plumbing', 'mon-Sat 10 AM - 6 PM', '2021-10-11', '555-555-5565');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `room_id` int(11) NOT NULL,
  `room_number` int(11) NOT NULL,
  `capacity` int(11) NOT NULL,
  `type` varchar(255) NOT NULL,
  `rent` float NOT NULL,
  `facilities` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`room_id`, `room_number`, `capacity`, `type`, `rent`, `facilities`) VALUES
(2, 108, 3, 'Single', 5000, 'tv'),
(3, 109, 8, 'Single', 6000, 'Wifi'),
(4, 101, 2, 'Single', 4000, 'Wifi'),
(5, 108, 3, 'Single', 8000, 'tv'),
(6, 108, 3, 'Single', 8000, 'tv');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `student_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `date_of_birth` date NOT NULL,
  `course` varchar(255) NOT NULL,
  `year_of_study` int(11) NOT NULL,
  `room_number` int(11) DEFAULT NULL,
  `bank_id` int(11) NOT NULL,
  `room_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `name`, `email`, `password`, `phone_number`, `gender`, `date_of_birth`, `course`, `year_of_study`, `room_number`, `bank_id`, `room_id`) VALUES
(222005678, 'daniel', 'daniel@gmail.com', 'password455', '0725050334', 'male', '2001-01-01', 'Computer Science', 1, 108, 2, 2),
(222007498, 'daniel', 'fwr@gmail.com', 'password455', '0725050334', 'Male', '2001-01-01', 'Computer Science', 1, 108, 2, 2),
(222007500, 'daniel', 'dani@2024', 'password455', '0725050334', 'Male', '2001-01-01', 'Computer Science', 1, 108, 2, 2),
(222007502, 'daniel', 'fsgfhjjg.gmail.com', 'password455', '0725050334', 'Male', '2001-01-01', 'Computer Science', 1, 108, 2, 2),
(222007506, 'daniel', '', 'password455', '0725050334', 'Male', '2001-01-01', 'Computer Science', 1, 108, 2, 2),
(222007507, 'daniel', '', 'password455', '0725050334', 'Male', '2001-01-01', 'Computer Science', 1, 108, 2, 2),
(222007508, 'daniel', '', 'password455', '0725050334', 'Male', '2001-01-01', 'Computer Science', 1, 108, 2, 2),
(222007509, 'daniel', '', 'password455', '0725050334', 'Male', '2001-01-01', 'Computer Science', 1, 108, 2, 2);

--
-- Triggers `student`
--
DELIMITER $$
CREATE TRIGGER `AfterUpdateStudent` AFTER UPDATE ON `student` FOR EACH ROW BEGIN
    INSERT INTO student_audit (student_id, action, audit_timestamp)
    VALUES (NEW.student_id, 'UPDATE', NOW());
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `studentinformation`
--

CREATE TABLE `studentinformation` (
  `student_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  `year_of_study` int(11) DEFAULT NULL,
  `room_number` int(11) DEFAULT NULL,
  `bank_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `studentroomtypeview`
--

CREATE TABLE `studentroomtypeview` (
  `student_id` int(11) DEFAULT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  `room_type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `studentroomview`
--

CREATE TABLE `studentroomview` (
  `student_id` int(11) DEFAULT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  `student_email` varchar(255) DEFAULT NULL,
  `room_number` int(11) DEFAULT NULL,
  `room_type` varchar(255) DEFAULT NULL,
  `room_rent` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `updatablestudentview`
--

CREATE TABLE `updatablestudentview` (
  `student_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  `year_of_study` int(11) DEFAULT NULL,
  `room_number` int(11) DEFAULT NULL,
  `bank_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure for view `delete_view`
--
DROP TABLE IF EXISTS `delete_view`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `delete_view`  AS SELECT `bank`.`name` AS `name`, `bank`.`address` AS `address`, `bank`.`contact_number` AS `contact_number` FROM `bank` WHERE `bank`.`address` = 'huye'union all select `room`.`capacity` AS `capacity`,`room`.`type` AS `type`,`room`.`rent` AS `rent` from `room` where `room`.`capacity` > 3  ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`),
  ADD KEY `fk_admin_bank` (`bank_id`);

--
-- Indexes for table `bank`
--
ALTER TABLE `bank`
  ADD PRIMARY KEY (`bank_id`);

--
-- Indexes for table `bank_audit`
--
ALTER TABLE `bank_audit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hostel_manager`
--
ALTER TABLE `hostel_manager`
  ADD PRIMARY KEY (`hostel_manager_id`),
  ADD KEY `fk_hostel_manager_bank` (`bank_id`);

--
-- Indexes for table `maintenancestaff`
--
ALTER TABLE `maintenancestaff`
  ADD PRIMARY KEY (`StaffID`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`room_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`),
  ADD KEY `fk_student_bank` (`bank_id`),
  ADD KEY `fk_student_room` (`room_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `bank`
--
ALTER TABLE `bank`
  MODIFY `bank_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `bank_audit`
--
ALTER TABLE `bank_audit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `hostel_manager`
--
ALTER TABLE `hostel_manager`
  MODIFY `hostel_manager_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=116;

--
-- AUTO_INCREMENT for table `maintenancestaff`
--
ALTER TABLE `maintenancestaff`
  MODIFY `StaffID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `room_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=222007510;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `fk_admin_bank` FOREIGN KEY (`bank_id`) REFERENCES `bank` (`bank_id`);

--
-- Constraints for table `hostel_manager`
--
ALTER TABLE `hostel_manager`
  ADD CONSTRAINT `fk_hostel_manager_bank` FOREIGN KEY (`bank_id`) REFERENCES `bank` (`bank_id`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `fk_student_bank` FOREIGN KEY (`bank_id`) REFERENCES `bank` (`bank_id`),
  ADD CONSTRAINT `fk_student_room` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
