-- MySQL Workbench Forward Engineering
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema simple_company
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema simple_company
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `simple_company` DEFAULT CHARACTER SET utf8 ;
USE `simple_company` ;

-- -----------------------------------------------------
-- Table `simple_company`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `simple_company`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fisrtName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `gender` CHAR NOT NULL,
  `dob` DATE NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `simple_company`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `simple_company`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` TEXT NOT NULL,
  `category` INT NOT NULL,
  `upc` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `simple_company`.`purchase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `simple_company`.`purchase` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product` INT NOT NULL,
  `customer` INT NOT NULL,
  `purchaseDate` TIMESTAMP NOT NULL,
  `purchaseAmount` DECIMAL(4,2) NOT NULL,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `product`
    FOREIGN KEY (`id`)
    REFERENCES `simple_company`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `customer`
    FOREIGN KEY (`id`)
    REFERENCES `simple_company`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `simple_company`.`creditcard`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `simple_company`.`creditcard` (
  `id` INT NOT NULL,
  `ccNumber` VARCHAR(45) NOT NULL,
  `expDate` VARCHAR(45) NOT NULL,
  `securityCode` VARCHAR(45) NOT NULL,
  INDEX `fk_creditcard_customer_idx` (`id` ASC) VISIBLE,
  CONSTRAINT `id`
    FOREIGN KEY (`id`)
    REFERENCES `simple_company`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `simple_company`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `simple_company`.`address` (
  `id` INT NOT NULL,
  `address1` VARCHAR(45) NOT NULL,
  `address2` VARCHAR(45) NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `zipcode` VARCHAR(45) NOT NULL,
  INDEX `fk_address_customer_idx` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_address_customer_id`
    FOREIGN KEY (`id`)
    REFERENCES `simple_company`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
