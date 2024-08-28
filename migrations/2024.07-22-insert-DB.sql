/*
-- Query: SELECT * FROM reservationposition.position
LIMIT 0, 1000

-- Date: 2024-07-23 13:10
*/
INSERT INTO `position` (`id`,`numero`) VALUES (1,'POS-001');
INSERT INTO `position` (`id`,`numero`) VALUES (2,'POS-002');
INSERT INTO `position` (`id`,`numero`) VALUES (3,'POS-003');
INSERT INTO `position` (`id`,`numero`) VALUES (4,'POS-004');
INSERT INTO `position` (`id`,`numero`) VALUES (5,'POS-005');
INSERT INTO `position` (`id`,`numero`) VALUES (6,'POS-006');
INSERT INTO `position` (`id`,`numero`) VALUES (7,'POS-007');
INSERT INTO `position` (`id`,`numero`) VALUES (8,'POS-008');
INSERT INTO `position` (`id`,`numero`) VALUES (9,'POS-010');
INSERT INTO `position` (`id`,`numero`) VALUES (10,'POS-011');
INSERT INTO `position` (`id`,`numero`) VALUES (11,'POS-011');
INSERT INTO `position` (`id`,`numero`) VALUES (12,'POS-012');
INSERT INTO `position` (`id`,`numero`) VALUES (13,'POS-013');
INSERT INTO `position` (`id`,`numero`) VALUES (14,'POS-014');
INSERT INTO `position` (`id`,`numero`) VALUES (15,'POS-015');



/*
-- Query: SELECT * FROM reservationposition.reservation
LIMIT 0, 1000

-- Date: 2024-07-23 13:14
*/
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (8,'2024-07-16','2024-07-17',2,3);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (7,'2024-07-16','2024-07-17',1,1);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (9,'2024-07-16','2024-07-18',4,5);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (11,'2024-07-18','2024-07-20',3,4);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (12,'2024-07-20','2024-07-21',1,1);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (13,'2024-07-21','2024-07-23',2,3);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (14,'2024-07-17','2024-07-19',5,6);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (15,'2024-07-24','2024-07-26',1,15);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (16,'2024-07-24','2024-07-26',2,14);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (17,'2024-07-24','2024-07-26',3,13);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (18,'2024-07-24','2024-07-25',4,12);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (19,'2024-07-24','2024-07-25',5,11);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (20,'2024-07-24','2024-07-25',6,10);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (21,'2024-07-24','2024-07-25',7,9);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (22,'2024-07-25','2024-07-25',8,8);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (23,'2024-07-25','2024-07-25',9,7);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (24,'2024-07-25','2024-07-25',10,6);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (25,'2024-07-25','2024-07-25',11,5);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (26,'2024-07-29','2024-07-31',12,4);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (27,'2024-07-29','2024-07-31',13,3);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (28,'2024-07-29','2024-07-31',14,2);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (29,'2024-07-29','2024-07-31',15,1);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (30,'2024-07-24','2024-07-24',8,1);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (31,'2024-07-24','2024-07-24',9,2);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (32,'2024-07-24','2024-07-24',10,3);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (33,'2024-07-24','2024-07-24',11,4);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (34,'2024-07-24','2024-07-24',12,5);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (35,'2024-07-24','2024-07-24',13,6);
INSERT INTO `reservation` (`id`,`date_deb`,`date_fin`,`User_id`,`Position_id`) VALUES (36,'2024-07-24','2024-07-24',14,7);



/*
-- Query: SELECT * FROM reservationposition.user
LIMIT 0, 1000

-- Date: 2024-07-23 13:20
*/
INSERT INTO `user` (`id`,`matricule`,`first_name`,`last_name`,`role`,`email`,`password`,`Superior_id`) VALUES (1,'MA-001','Anas','Senhaji','RC','anassenhaji@gmail.com','password',1);
INSERT INTO `user` (`id`,`matricule`,`first_name`,`last_name`,`role`,`email`,`password`,`Superior_id`) VALUES (2,'MA-002','Hafssa','Raoui','Consultant','hafssaraoui@gmail.com','password',1);
INSERT INTO `user` (`id`,`matricule`,`first_name`,`last_name`,`role`,`email`,`password`,`Superior_id`) VALUES (3,'MA-003','Yasmine','Salhi','Consultant','yasminesalhi@gmail.com','password',1);
INSERT INTO `user` (`id`,`matricule`,`first_name`,`last_name`,`role`,`email`,`password`,`Superior_id`) VALUES (4,'MA-004','Mariam','Lkhssassi','Consultant','mariamlakhssassi@gmail.com','password',1);
INSERT INTO `user` (`id`,`matricule`,`first_name`,`last_name`,`role`,`email`,`password`,`Superior_id`) VALUES (5,'MA-005','Mohamed','Ahmadi','Consultant','mohamedahmadi@gmail.com','password',1);
INSERT INTO `user` (`id`,`matricule`,`first_name`,`last_name`,`role`,`email`,`password`,`Superior_id`) VALUES (6,'MA-006','Hamza','Yaccoubi','Consultant','hamzayaccoubi@gmail.com','password',1);
INSERT INTO `user` (`id`,`matricule`,`first_name`,`last_name`,`role`,`email`,`password`,`Superior_id`) VALUES (7,'MA-007','Taha','Lamrani','Consultant','tahalamrani@gmail.com','password',1);
INSERT INTO `user` (`id`,`matricule`,`first_name`,`last_name`,`role`,`email`,`password`,`Superior_id`) VALUES (8,'MA-008','Nadia','Alaoui','Consultant','nadiaalaoui@gmail.com','password',1);
INSERT INTO `user` (`id`,`matricule`,`first_name`,`last_name`,`role`,`email`,`password`,`Superior_id`) VALUES (9,'MA-009','Salma','Filali','Consultant','salmafilali@gmail.com','password',1);
INSERT INTO `user` (`id`,`matricule`,`first_name`,`last_name`,`role`,`email`,`password`,`Superior_id`) VALUES (10,'MA-010','Mohammed','Karim','Consultant','mohammedkarim@gmail.com','password',1);
INSERT INTO `user` (`id`,`matricule`,`first_name`,`last_name`,`role`,`email`,`password`,`Superior_id`) VALUES (11,'MA-011','Latifa','Ahrar','Consultant','latifaahrar@gmail.com','password',1);
INSERT INTO `user` (`id`,`matricule`,`first_name`,`last_name`,`role`,`email`,`password`,`Superior_id`) VALUES (12,'MA-012','Karima','Taqui','Consultant','karimataqui@gmail.com','password',1);
INSERT INTO `user` (`id`,`matricule`,`first_name`,`last_name`,`role`,`email`,`password`,`Superior_id`) VALUES (13,'MA-013','Fatiha','Cherkaoui','Consultant','fatihacherkaoui@gmail.com','password',1);
INSERT INTO `user` (`id`,`matricule`,`first_name`,`last_name`,`role`,`email`,`password`,`Superior_id`) VALUES (14,'MA-014','Brahim','Fettah','Consultant','brahimfettah@gmail.com','password',1);
INSERT INTO `user` (`id`,`matricule`,`first_name`,`last_name`,`role`,`email`,`password`,`Superior_id`) VALUES (15,'MA-015','John','Doe','Consultant','johndoe@gmail.com','password',1);
