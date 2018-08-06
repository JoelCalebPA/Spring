DROP DATABASE IF EXISTS db_tienda_web;
CREATE DATABASE db_tienda_web;

USE db_tienda_web;

CREATE TABLE IF NOT EXISTS `db_tienda_web`.`tbl_usuario` (
  `id_usuario` INT(11) NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `tipo` INT(11) NOT NULL DEFAULT '1',
  `registro` date NOT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db_tienda_web`.`tbl_cliente` (
  `id_cliente` INT(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` INT(11) NOT NULL,
  `nombre` VARCHAR(30) NOT NULL,
  `apellidos` VARCHAR(30) NOT NULL,
  `telefono` varchar(30) DEFAULT NULL,
  `ruc` varchar(100),
  `dni` INT(11),
  PRIMARY KEY (`id_cliente`),
  CONSTRAINT `fk_cli_usr`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `db_tienda_web`.`tbl_usuario` (`id_usuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db_tienda_web`.`tbl_marca` (
  `id_marca` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `descripcion` TEXT NOT NULL,
  PRIMARY KEY (`id_marca`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db_tienda_web`.`tbl_producto` (
  `id_producto` INT(11) NOT NULL AUTO_INCREMENT,
  `id_marca` INT(11) NOT NULL,
  `descripcion` VARCHAR(100) NOT NULL,
  `detalle` TEXT NOT NULL,
  `precio` DECIMAL(10,2) NOT NULL,
  `stock` INT(11) NOT NULL,
  `descuento` INT(11) DEFAULT '0',
  `calificacion` DECIMAL(10,2) DEFAULT '0',
  PRIMARY KEY (`id_producto`),
  CONSTRAINT `fk_pro_marca`
    FOREIGN KEY (`id_marca`)
    REFERENCES `db_tienda_web`.`tbl_marca` (`id_marca`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db_tienda_web`.`tbl_especificacion` (
    id_producto INT(11) NOT NULL,
    marca VARCHAR(100) NOT NULL,
    modelo VARCHAR(1000) NOT NULL,
    so VARCHAR(100) NOT NULL,
    pantalla VARCHAR(1000) NOT NULL,
    ram VARCHAR(500) NOT NULL,
    almacenamiento VARCHAR(500) NOT NULL,
    camara VARCHAR(1000) NOT NULL,
    bateria VARCHAR(1000) NOT NULL,
    peso VARCHAR(200) NOT NULL,
    banda VARCHAR(1000) NOT NULL,
    sim VARCHAR(500) NOT NULL,
    conectividad VARCHAR(1000) NOT NULL,
    dimension VARCHAR(100) NOT NULL,
    CONSTRAINT `fk_esp_pro`
        FOREIGN KEY (`id_producto`)
        REFERENCES `tbl_producto` (`id_producto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `db_tienda_web`.`tbl_venta` (
  `id_venta` INT(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` INT(11) NOT NULL,
  `fecha` DATE NOT NULL,
  `pago_total` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id_venta`),
  INDEX `fk_venta_cliente` (`id_cliente` ASC),
  CONSTRAINT `fk_venta_cliente`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `db_tienda_web`.`tbl_cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

DROP TABLE IF EXISTS `db_tienda_web`.`tbl_detalle_venta`;
CREATE TABLE IF NOT EXISTS `db_tienda_web`.`tbl_detalle_venta` (
  `id_venta` INT(11) NOT NULL,
  `id_producto` INT(11) NOT NULL,
  `cantidad` INT(11) NOT NULL,
  `precio` INT(11) NOT NULL,
  INDEX `fk_deta_producto` (`id_producto` ASC),
  INDEX `fk_deta_venta` (`id_venta` ASC),
  PRIMARY KEY (`id_venta`, `id_producto`),
  CONSTRAINT `fk_deta_producto`
    FOREIGN KEY (`id_producto`)
    REFERENCES `db_tienda_web`.`tbl_producto` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_deta_venta`
    FOREIGN KEY (`id_venta`)
    REFERENCES `db_tienda_web`.`tbl_venta` (`id_venta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `tbl_cart` (
  `id_cliente` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  PRIMARY KEY (`id_cliente`,`id_producto`),
  KEY `fk_cart_producto` (`id_producto`),
  CONSTRAINT `fk_cart_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `tbl_cliente` (`id_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cart_producto` FOREIGN KEY (`id_producto`) REFERENCES `tbl_producto` (`id_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8