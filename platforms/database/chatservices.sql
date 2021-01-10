create database chatservices;

create TABLE IF NOT EXISTS `chatservices`.`chat_types` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(255), 
  `is_active` bit(1) DEFAULT b'0',
  `created_at` datetime NOT NULL DEFAULT current_timestamp() ON update current_timestamp(),
  `updated_at` datetime NOT NULL DEFAULT current_timestamp() ON update current_timestamp(),  
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_chat_types_type` (`type`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;
