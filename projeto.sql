CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Solo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Solo` (
  `idSolo` INT NOT NULL AUTO_INCREMENT,
  `nivelDePh` INT NOT NULL,
  PRIMARY KEY (`idSolo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Maquinário`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Maquinário` (
  `numerodeserie` VARCHAR(45),
  `uso` TINYINT NOT NULL,
  `Trator_numerodeserie` VARCHAR(6) NOT NULL,
  `Plantadeira_numerodeserie` VARCHAR(6) NOT NULL,
  `Colheitadeira_numerodeserie` VARCHAR(6) NOT NULL,
  PRIMARY KEY (`numerodeserie`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Espécie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Espécie` (
  `nome` VARCHAR(45) NOT NULL,
  `quantidaDeMudas` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`nome`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pragas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pragas` (
  `tipo` VARCHAR(45) NOT NULL,
  `forca` INT NOT NULL,
  PRIMARY KEY (`tipo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Funcionários`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Funcionários` (
  `CPF` VARCHAR(11) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `idade` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`CPF`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Fazenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Fazenda` (
  `nome` VARCHAR(45) NOT NULL,
  `hectaresTotais` INT NOT NULL,
  `hectaresParaPlantio` INT NOT NULL,
  `numeroDoMesAtual` INT NOT NULL,
  `numPragas` INT NOT NULL,
  `numFunc` INT NOT NULL,
  `Solo_idSolo` INT NOT NULL,
  `Maquinário_numerodeserie` VARCHAR(45) NOT NULL,
  `Espécie_nome` VARCHAR(45) NOT NULL,
  `Pragas_tipo` VARCHAR(45) NOT NULL,
  `Funcionários_CPF` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`nome`),
  INDEX `fk_Fazenda_Solo1_idx` (`Solo_idSolo` ASC) VISIBLE,
  INDEX `fk_Fazenda_Maquinário1_idx` (`Maquinário_numerodeserie` ASC) VISIBLE,
  INDEX `fk_Fazenda_Espécie1_idx` (`Espécie_nome` ASC) VISIBLE,
  INDEX `fk_Fazenda_Pragas1_idx` (`Pragas_tipo` ASC) VISIBLE,
  INDEX `fk_Fazenda_Funcionários1_idx` (`Funcionários_CPF` ASC) VISIBLE,
  CONSTRAINT `fk_Fazenda_Solo1`
    FOREIGN KEY (`Solo_idSolo`)
    REFERENCES `mydb`.`Solo` (`idSolo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fazenda_Maquinário1`
    FOREIGN KEY (`Maquinário_numerodeserie`)
    REFERENCES `mydb`.`Maquinário` (`numerodeserie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fazenda_Espécie1`
    FOREIGN KEY (`Espécie_nome`)
    REFERENCES `mydb`.`Espécie` (`nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fazenda_Pragas1`
    FOREIGN KEY (`Pragas_tipo`)
    REFERENCES `mydb`.`Pragas` (`tipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fazenda_Funcionários1`
    FOREIGN KEY (`Funcionários_CPF`)
    REFERENCES `mydb`.`Funcionários` (`CPF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Alocacoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Alocacoes` (
  `Maquinário_numerodeserie` VARCHAR(45) NOT NULL,
  `Funcionários_CPF` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`Maquinário_numerodeserie`, `Funcionários_CPF`),
  INDEX `fk_Maquinário_has_Funcionários_Funcionários1_idx` (`Funcionários_CPF` ASC) VISIBLE,
  INDEX `fk_Maquinário_has_Funcionários_Maquinário1_idx` (`Maquinário_numerodeserie` ASC) VISIBLE,
  CONSTRAINT `fk_Maquinário_has_Funcionários_Maquinário1`
    FOREIGN KEY (`Maquinário_numerodeserie`)
    REFERENCES `mydb`.`Maquinário` (`numerodeserie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Maquinário_has_Funcionários_Funcionários1`
    FOREIGN KEY (`Funcionários_CPF`)
    REFERENCES `mydb`.`Funcionários` (`CPF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


