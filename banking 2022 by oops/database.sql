/*
SQLyog - Free MySQL GUI v5.17
Host - 5.1.30-community : Database - bank_customer
*********************************************************************
Server version : 5.1.30-community
*/


SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `bank_customer`;

USE `bank_customer`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `bank` */

DROP TABLE IF EXISTS `bank`;

CREATE TABLE `bank` (
  `accno` int(6) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `balance` decimal(8,2) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `bank` */

insert into `bank` (`accno`,`name`,`balance`,`address`) values (112,'amit','9000.00','hno52');
insert into `bank` (`accno`,`name`,`balance`,`address`) values (106,'sumit','16000.00','hno52');
insert into `bank` (`accno`,`name`,`balance`,`address`) values (107,'kk','18600.00','hno52');
insert into `bank` (`accno`,`name`,`balance`,`address`) values (118,'raman','14600.00','hno52');

/*Table structure for table `loan` */

DROP TABLE IF EXISTS `loan`;

CREATE TABLE `loan` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `accno` int(6) DEFAULT NULL,
  `type_of_loan` varchar(30) DEFAULT NULL,
  `loan_amount` decimal(10,2) DEFAULT NULL,
  `rate_of_interest` decimal(10,2) DEFAULT NULL,
  `duration` int(6) DEFAULT NULL,
  `applied_date` varchar(30) DEFAULT NULL,
  `start_date` varchar(30) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `loan` */

insert into `loan` (`id`,`accno`,`type_of_loan`,`loan_amount`,`rate_of_interest`,`duration`,`applied_date`,`start_date`,`status`) values (1,107,'Car Loan','2.00','12.00',12,'12','12','accepted');
insert into `loan` (`id`,`accno`,`type_of_loan`,`loan_amount`,`rate_of_interest`,`duration`,`applied_date`,`start_date`,`status`) values (2,107,'Car Loan','3.00','123.00',123,'123','123',NULL);

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `type` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert into `login` (`username`,`password`,`type`) values ('admin','123','administrator');
insert into `login` (`username`,`password`,`type`) values ('kk','kk','customer');
insert into `login` (`username`,`password`,`type`) values ('aa','aa','admin');

/*Table structure for table `transaction` */

DROP TABLE IF EXISTS `transaction`;

CREATE TABLE `transaction` (
  `accno` int(6) DEFAULT NULL,
  `debit` decimal(10,2) DEFAULT NULL,
  `credit` decimal(10,2) DEFAULT NULL,
  `m_o_p` varchar(30) DEFAULT NULL,
  `d_of_t` date DEFAULT NULL,
  `balance` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `transaction` */

insert into `transaction` (`accno`,`debit`,`credit`,`m_o_p`,`d_of_t`,`balance`) values (106,'0.00','8000.00','Cash','2012-06-20','0.00');
insert into `transaction` (`accno`,`debit`,`credit`,`m_o_p`,`d_of_t`,`balance`) values (118,'0.00','9000.00','Cash','2012-06-20','14600.00');
insert into `transaction` (`accno`,`debit`,`credit`,`m_o_p`,`d_of_t`,`balance`) values (107,'0.00','7000.00','Cash','2012-06-20','21600.00');
insert into `transaction` (`accno`,`debit`,`credit`,`m_o_p`,`d_of_t`,`balance`) values (107,'0.00','7000.00','Cash','2012-06-20','14600.00');
insert into `transaction` (`accno`,`debit`,`credit`,`m_o_p`,`d_of_t`,`balance`) values (107,'0.00','4000.00','Cash','2012-06-20','18600.00');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
