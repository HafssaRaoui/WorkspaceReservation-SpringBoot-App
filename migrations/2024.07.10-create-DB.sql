-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema reservationposition
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema reservationposition
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `reservationposition` DEFAULT CHARACTER SET utf8mb3 ;
USE `reservationposition` ;

-- -----------------------------------------------------
-- Table `reservationposition`.`flyway_schema_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reservationposition`.`flyway_schema_history` (
                                                                             `installed_rank` INT NOT NULL,
                                                                             `version` VARCHAR(50) NULL DEFAULT NULL,
    `description` VARCHAR(200) NOT NULL,
    `type` VARCHAR(20) NOT NULL,
    `script` VARCHAR(1000) NOT NULL,
    `checksum` INT NULL DEFAULT NULL,
    `installed_by` VARCHAR(100) NOT NULL,
    `installed_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `execution_time` INT NOT NULL,
    `success` TINYINT(1) NOT NULL,
    PRIMARY KEY (`installed_rank`),
    INDEX `flyway_schema_history_s_idx` (`success` ASC) VISIBLE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `reservationposition`.`position`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reservationposition`.`position` (
                                                                `id` INT NOT NULL,
                                                                `numero` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `reservationposition`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reservationposition`.`user` (
                                                            `id` INT NOT NULL AUTO_INCREMENT,
                                                            `matricule` VARCHAR(45) NOT NULL,
    `first_name` VARCHAR(45) NOT NULL,
    `last_name` VARCHAR(45) NOT NULL,
    `role` VARCHAR(45) NOT NULL,
    `email` VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    `Superior_id` INT NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `uc_user_email` (`email` ASC) VISIBLE,
    INDEX `fk_User_User1_idx` (`Superior_id` ASC) VISIBLE,
    CONSTRAINT `fk_User_User1`
    FOREIGN KEY (`Superior_id`)
    REFERENCES `reservationposition`.`user` (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 16
    DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `reservationposition`.`reservation`
-- -----------------------------------------------------
CREATE TABLE IF
    NOT EXISTS `reservationposition`.`reservation` (
                                                                   `id` INT NOT NULL AUTO_INCREMENT,
                                                                   `date_deb` DATE NOT NULL,
                                                                   `date_fin` DATE NOT NULL,
                                                                   `User_id` INT NOT NULL,
                                                                   `Position_id` INT NOT NULL,
                                                                   PRIMARY KEY (`id`),
    INDEX `fk_Reservation_User_idx` (`User_id` ASC) VISIBLE,
    INDEX `fk_Reservation_Position1_idx` (`Position_id` ASC) VISIBLE,
    CONSTRAINT `fk_Reservation_Position1`
    FOREIGN KEY (`Position_id`)
    REFERENCES `reservationposition`.`position` (`id`),
    CONSTRAINT `fk_Reservation_User`
    FOREIGN KEY (`User_id`)
    REFERENCES `reservationposition`.`user` (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 37
    DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
