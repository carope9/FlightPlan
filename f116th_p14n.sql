CREATE USER 'administrator'@'%' IDENTIFIED BY '515t3m4501*';
GRANT ALL PRIVILEGES ON * . * TO 'administrator'@'%';
FLUSH PRIVILEGES;
CREATE DATABASE F116TH_P14N;
USE F116TH_P14N;
CREATE TABLE users(
	usr_id INT AUTO_INCREMENT PRIMARY KEY,
	usr_username VARCHAR(20) NOT NULL,
	usr_fname VARCHAR(45) NOT NULL,
	usr_lname VARCHAR(90) NOT NULL,
	usr_password VARCHAR(50) NOT NULL
	usr_status BOOLEAN DEFAULT 1 NOT NULL
) ENGINE = INNODB;
INSERT INTO users(
	usr_username,
	usr_fname,
	usr_lname,
	usr_password,
	usr_status
) VALUES (
	'administrator',
	'Administrador',
	'APD',
	'515t3m4501*'
);
CREATE TABLE aircraft(
	ac_id VARCHAR(7) PRIMARY KEY,
	ac_type VARCHAR(4) NOT NULL,
	ac_cat CHAR(1) NOT NULL,
	ac_radiocomunication VARCHAR(64) NOT NULL,
	ac_surveillance VARCHAR(20) NOT NULL,
	ac_radioU BOOLEAN NOT NULL,
	ac_radioV BOOLEAN NOT NULL,
	ac_radioE BOOLEAN NOT NULL,
	ac_superS BOOLEAN NOT NULL,
	ac_superP BOOLEAN NOT NULL,
	ac_superD BOOLEAN NOT NULL,
	ac_superM BOOLEAN NOT NULL,
	ac_superJ BOOLEAN NOT NULL,
	jacketsJ BOOLEAN NOT NULL,
	jacketsL BOOLEAN NOT NULL,
	jacketsF BOOLEAN NOT NULL,
	jacketsU BOOLEAN NOT NULL,
	jacketsV BOOLEAN NOT NULL,
	ac_dinghels BOOLEAN NOT NULL,
	ac_din_num INT(2),
	ac_din_cap INT(3),
	ac_din_cov BOOLEAN NOT NULL,
	ac_din_col VARCHAR(45),
	ac_marks VARCHAR(50) NOT NULL,
	observN BOOLEAN NOT NULL,
	observ VARCHAR(45)
) ENGINE = INNODB;
CREATE TABLE pilots(
	pil_lisence VARCHAR(15) PRIMARY KEY,
	pil_name VARCHAR(50) NOT NULL,
	pil_address VARCHAR(50)
) ENGINE = INNODB;
CREATE TABLE flight_plan(
	fp_id INT AUTO_INCREMENT PRIMARY KEY,
	ac_id VARCHAR(7) NOT NULL,
	pil_licence VARCHAR(15) NOT NULL,
	cop_license VARCHAR(15),
	flight_rules VARCHAR(15) NOT NULL,
	flight_type VARCHAR(15) NOT NULL,
	hour TIME,
	speed  VARCHAR(5) NOT NULL,
	flight_level  VARCHAR(5) NOT NULL,
	route  VARCHAR(100) NOT NULL,
	destiny  VARCHAR(4) NOT NULL,
	eet TIME NOT NULL,
	alt1 VARCHAR(4) NOT NULL,
	alt2 VARCHAR(4),
	other VARCHAR(100) NOT NULL,
	endurance TIME NOT NULL,
	on_board CHAR(3) NOT NULL,
	fp_date DATE NOT NULL,
	fp_time TIME NOT NULL,
	usr_username VARCHAR(20) NOT NULL,
	fp_pdf_name VARCHAR(45) NOT NULL
) ENGINE = INNODB;

CREATE TABLE aduana(
	adu_id INT AUTO_INCREMENT PRIMARY KEY
) ENGINE = INNODB;

CREATE TABLE closing(
	clo_id INT AUTO_INCREMENT PRIMARY KEY,
	ac_id VARCHAR(7) NOT NULL,
	pil_licence VARCHAR(15) NOT NULL,
	cop_license VARCHAR(15),
	flight_type VARCHAR(15) NOT NULL,
	departure VARCHAR(4) NOT NULL,
	arrival_date DATE NOT NULL,
	arrival_time TIME NOT NULL,
	passengers TEXT,
	observ VARCHAR(100),
	usr_username VARCHAR(20) NOT NULL,
	fc_pdf_name VARCHAR(45) NOT NULL
) ENGINE = INNODB;
CREATE TABLE files(
	fil_name VARCHAR(45) PRIMARY KEY,
	fil_pdf MEDIUMBLOB NOT NULL,
	fil_type VARCHAR(20) NOT NULL
) ENGINE = INNODB;
CREATE VIEW files_view AS SELECT fil_name, CONCAT('File size: ', LENGTH(fil_pdf), ' bytes') AS fil_pdf, fil_type FROM files;
CREATE TABLE bitacora(
	bit_id INT AUTO_INCREMENT PRIMARY KEY,
	bit_usr VARCHAR(20) NOT NULL,
	bit_host VARCHAR(20) NOT NULL,
	bit_fecha DATE NOT NULL,
	bit_time TIME NOT NULL,
	bit_table VARCHAR(15) NOT NULL
) ENGINE = INNODB;
