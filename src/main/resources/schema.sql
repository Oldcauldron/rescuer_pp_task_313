
DROP TABLE IF EXISTS `users_roles`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `roles`;

CREATE TABLE IF NOT EXISTS `users` (
                         `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                         `login` varchar(250) ,
                         `age` integer DEFAULT NULL,
                         `password` varchar(250),
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `id` (`id`),
                         UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `roles` (
                         `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                         `role` varchar(250) DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `id` (`id`),
                         UNIQUE KEY `role` (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `users_roles` (
                         `user_id` bigint(20) unsigned DEFAULT NULL,
                         `role_id` bigint(20) unsigned DEFAULT 2,
                         KEY `hasuser` (`user_id`),
                         KEY `hasrole` (`role_id`),
                         CONSTRAINT `hasrole` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                         CONSTRAINT `hasuser` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;