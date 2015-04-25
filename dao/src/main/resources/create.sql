DROP TABLE IF EXISTS `login`;
DROP TABLE IF EXISTS `like_dislikes`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `follows`;

CREATE TABLE `login` (
  `account_number` int(50) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `account_number` (`account_number`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

CREATE TABLE `like_dislikes` (
  `account_id` varchar(150) NOT NULL DEFAULT '',
  `product_id` int(11) NOT NULL,
  PRIMARY KEY (`account_id`,`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `users` (
  `account_id` varchar(50) NOT NULL DEFAULT '',
  `name` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `follows` (
  `followed_by` varchar(50) NOT NULL DEFAULT '',
  `follows` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`followed_by`,`follows`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;