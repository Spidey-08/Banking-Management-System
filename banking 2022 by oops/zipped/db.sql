/*
SQLyog - Free MySQL GUI v5.17
Host - 5.1.30-community : Database - myproject
*********************************************************************
Server version : 5.1.30-community
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `myproject`;

USE `myproject`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `accno` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `gender` varchar(30) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `balance` decimal(11,2) DEFAULT NULL,
  PRIMARY KEY (`accno`)
) ENGINE=InnoDB AUTO_INCREMENT=457 DEFAULT CHARSET=latin1;

/*Data for the table `account` */

insert into `account` (`accno`,`name`,`gender`,`address`,`city`,`phone`,`email`,`balance`) values (234,'Amit','Male','sec-34','Chd.','9999999999','aa@google.com','10790.00');
insert into `account` (`accno`,`name`,`gender`,`address`,`city`,`phone`,`email`,`balance`) values (456,'Ramu','Male','sec-21','Chd.','9888888888','rr@google.com','10990.00');

/*Table structure for table `loan` */

DROP TABLE IF EXISTS `loan`;

CREATE TABLE `loan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(30) DEFAULT NULL,
  `loan_amount` decimal(11,2) DEFAULT NULL,
  `start_date` varchar(20) DEFAULT NULL,
  `no_of_month` int(10) DEFAULT NULL,
  `rate_of_interest` int(10) DEFAULT NULL,
  `emi` decimal(12,2) DEFAULT NULL,
  `loan_type` varchar(15) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=latin1;

/*Data for the table `loan` */

insert into `loan` (`id`,`cname`,`loan_amount`,`start_date`,`no_of_month`,`rate_of_interest`,`emi`,`loan_type`,`status`) values (121,'Karan','40000.00','04-07-2013',6,12,'4.50','Cash Loan','Rejected');
insert into `loan` (`id`,`cname`,`loan_amount`,`start_date`,`no_of_month`,`rate_of_interest`,`emi`,`loan_type`,`status`) values (131,'Rohit','25000.00','03-07-2013',7,14,'4.25','Car Loan','Accepted');

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `type` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert into `login` (`username`,`password`,`type`) values ('admin','admin','administrator');
insert into `login` (`username`,`password`,`type`) values ('ramu','ramu','customer');
insert into `login` (`username`,`password`,`type`) values ('kk','kk','guest');
insert into `login` (`username`,`password`,`type`) values ('amit','amit','guest');

/*Table structure for table `transaction` */

DROP TABLE IF EXISTS `transaction`;

CREATE TABLE `transaction` (
  `accno` int(10) DEFAULT NULL,
  `debit` decimal(11,2) DEFAULT NULL,
  `credit` decimal(11,2) DEFAULT NULL,
  `date_t` varchar(40) DEFAULT NULL,
  `amount` decimal(12,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `transaction` */

insert into `transaction` (`accno`,`debit`,`credit`,`date_t`,`amount`) values (456,'0.00','2000.00','Thu Jul 04 11:58:14 IST 2013','11490.00');
insert into `transaction` (`accno`,`debit`,`credit`,`date_t`,`amount`) values (456,'0.00','2000.00','Thu Jul 04 17:38:14 IST 2013','13490.00');
insert into `transaction` (`accno`,`debit`,`credit`,`date_t`,`amount`) values (234,'0.00','2000.00','Thu Jul 04 17:39:42 IST 2013','2224.00');
insert into `transaction` (`accno`,`debit`,`credit`,`date_t`,`amount`) values (234,'0.00','1000.00','Thu Jul 04 17:40:27 IST 2013','3224.00');
insert into `transaction` (`accno`,`debit`,`credit`,`date_t`,`amount`) values (234,'1200.00','0.00','Thu Jul 04 17:52:00 IST 2013','8800.00');
insert into `transaction` (`accno`,`debit`,`credit`,`date_t`,`amount`) values (456,'2000.00','0.00','Thu Jul 04 17:52:18 IST 2013','8490.00');
insert into `transaction` (`accno`,`debit`,`credit`,`date_t`,`amount`) values (234,'0.00','3990.00','Thu Jul 04 17:52:38 IST 2013','12790.00');
insert into `transaction` (`accno`,`debit`,`credit`,`date_t`,`amount`) values (456,'0.00','2500.00','Thu Jul 04 17:52:53 IST 2013','10990.00');
insert into `transaction` (`accno`,`debit`,`credit`,`date_t`,`amount`) values (234,'2000.00','0.00','Fri Jul 05 09:31:31 IST 2013','10790.00');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
