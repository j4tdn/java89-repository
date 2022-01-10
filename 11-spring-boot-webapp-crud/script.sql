
USE web_customer_tracker;
DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;


INSERT INTO `employee`(first_name, last_name, email)
VALUES ('David','Rana','davidrana@gmail.com'),('Mary','Public','marypublic@yahoo.com'),('Maxwell','Dixon','max@tpbank.com'),
('Tony','Dan','danm-tp@gmail.com'),('Quyen','Phan','quyen.ngoc.phan@mgm-tp.com'),('Vu','Nguyen','vunguyen-cpm@gmail.com'),
('Clark','Berg','quyen.ngoc.phan@mgm-tp.com'),('Nata','Warachip','natawa@gmail.com'),('Keiko','Walker','qoci@mailinator.com'),
('Elmo','Mccray','fisi@mailinator.com'),('Hilary','Pugh','sowyfeledi@mailinator.com'),('Colton','Horne','zahasecit@mailinator.com'),
('Tobias','Cardenas','qojy@mailinator.com'),('Sheila','Bartlett','dufe@mailinator.com'),('Linus','Chambers','fabuvypabi@mailinator.com'),
('Kevyn','Bates','pobe@mailinator.com'),('Garth','Hurst','cinug@mailinator.com'),('Leila','Rocha','kozakovyj@mailinator.com'),
('Yvonne','Benjamin','pirapyta@mailinator.com'),('Lucy','Clayton','xifisid@mailinator.com');
