/*
-- Query: SELECT * FROM reservationposition.user
LIMIT 0, 1000

-- Date: 2024-07-24 10:26
*/
/*
Changer la taille de password
*/
ALTER TABLE `reservationposition`.`user` MODIFY `password` VARCHAR(255);

/*
 Hached Password
*/

INSERT INTO `user` (`id`,`matricule`,`first_name`,`last_name`,`role`,`email`,`password`,`Superior_id`) VALUES (1,'MA-001','Anas','Senhaji','RC','anassenhaji@gmail.com','$2a$10$oj2qH9TAik35n9jdWzDBAuR4fAuJdsvw0rbaAh1XVHoACXdVHRw8K',1);
INSERT INTO `user` (`id`,`matricule`,`first_name`,`last_name`,`role`,`email`,`password`,`Superior_id`) VALUES (2,'MA-002','Hafssa','Raoui','Consultant','hafssaraoui@gmail.com','$2a$10$oj2qH9TAik35n9jdWzDBAuR4fAuJdsvw0rbaAh1XVHoACXdVHRw8K',1);
INSERT INTO `user` (`id`,`matricule`,`first_name`,`last_name`,`role`,`email`,`password`,`Superior_id`) VALUES (3,'MA-003','Yasmine','Salhi','Consultant','yasminesalhi@gmail.com','$2a$10$oj2qH9TAik35n9jdWzDBAuR4fAuJdsvw0rbaAh1XVHoACXdVHRw8K',1);
INSERT INTO `user` (`id`,`matricule`,`first_name`,`last_name`,`role`,`email`,`password`,`Superior_id`) VALUES (4,'MA-004','Mariam','Lkhssassi','Consultant','mariamlakhssassi@gmail.com','$2a$10$oj2qH9TAik35n9jdWzDBAuR4fAuJdsvw0rbaAh1XVHoACXdVHRw8K',1);
INSERT INTO `user` (`id`,`matricule`,`first_name`,`last_name`,`role`,`email`,`password`,`Superior_id`) VALUES (5,'MA-005','Mohamed','ahmadi','Consultant','mohamedahmadi@gmail.com','$2a$10$oj2qH9TAik35n9jdWzDBAuR4fAuJdsvw0rbaAh1XVHoACXdVHRw8K',1);
