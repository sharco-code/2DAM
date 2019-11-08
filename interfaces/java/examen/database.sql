-- MySQL dump 10.13  Distrib 5.7.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: examen
-- ------------------------------------------------------
-- Server version	5.7.23-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `caja`
--

DROP TABLE IF EXISTS `caja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caja` (
  `idCaja` bigint(20) NOT NULL AUTO_INCREMENT,
  `Fecha` date NOT NULL,
  `DineroCambio` decimal(10,2) NOT NULL,
  PRIMARY KEY (`idCaja`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caja`
--

LOCK TABLES `caja` WRITE;
/*!40000 ALTER TABLE `caja` DISABLE KEYS */;
INSERT INTO `caja` VALUES (1,'2019-02-07',450.00),(2,'2019-02-08',500.00),(3,'2019-01-01',1000.00),(6,'2019-02-09',300.00),(24,'2019-02-11',300.00),(32,'2019-02-13',69.00),(33,'2019-02-14',300.00),(34,'2019-02-15',99999999.99),(49,'2019-02-16',200.00),(50,'2019-02-17',2500.00),(51,'2019-02-20',200.00),(55,'2019-02-18',200.00),(56,'2019-02-19',200.00),(60,'2019-02-25',310.00);
/*!40000 ALTER TABLE `caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idCliente` bigint(20) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Dir` varchar(100) NOT NULL,
  `Pob` varchar(100) NOT NULL,
  `cp` varchar(10) NOT NULL,
  `CIF` varchar(30) NOT NULL,
  `Prov` varchar(100) NOT NULL,
  `Tel` varchar(100) NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compras` (
  `idCompra` bigint(20) NOT NULL AUTO_INCREMENT,
  `idProducto` bigint(20) NOT NULL,
  `Cantidad` decimal(10,2) NOT NULL,
  `fecha` date NOT NULL,
  `idProveedor` bigint(20) NOT NULL,
  PRIMARY KEY (`idCompra`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
INSERT INTO `compras` VALUES (1,1,100.00,'2019-05-11',1),(2,5,13413.00,'2019-10-08',2),(4,10,213.00,'2019-10-08',2),(5,2,411.00,'2019-05-11',2),(8,5,1.00,'2019-10-08',3),(9,5,1.00,'2019-10-08',1),(10,5,21.00,'2019-10-08',1),(11,1,12.00,'2019-10-08',3);
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `elementosmenu`
--

DROP TABLE IF EXISTS `elementosmenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `elementosmenu` (
  `idrow` int(11) NOT NULL AUTO_INCREMENT,
  `idMenu` bigint(20) NOT NULL,
  `idProducto` bigint(20) NOT NULL,
  `Cantidad` decimal(10,2) NOT NULL,
  `fin` int(11) NOT NULL,
  PRIMARY KEY (`idrow`),
  KEY `idMenu` (`idMenu`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elementosmenu`
--

LOCK TABLES `elementosmenu` WRITE;
/*!40000 ALTER TABLE `elementosmenu` DISABLE KEYS */;
INSERT INTO `elementosmenu` VALUES (1,7,1,0.00,0),(2,6,13,1.00,0),(3,6,14,1.00,0),(4,6,15,1.00,1);
/*!40000 ALTER TABLE `elementosmenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `elementosplantilla`
--

DROP TABLE IF EXISTS `elementosplantilla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `elementosplantilla` (
  `idrow` int(11) NOT NULL AUTO_INCREMENT,
  `IdElemMenu` int(11) NOT NULL,
  `IdProducto` int(11) NOT NULL,
  PRIMARY KEY (`idrow`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elementosplantilla`
--

LOCK TABLES `elementosplantilla` WRITE;
/*!40000 ALTER TABLE `elementosplantilla` DISABLE KEYS */;
INSERT INTO `elementosplantilla` VALUES (2,13,1),(3,13,2),(4,14,4),(5,14,5),(9,15,8),(10,15,9);
/*!40000 ALTER TABLE `elementosplantilla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleados` (
  `idEmpleado` int(11) NOT NULL AUTO_INCREMENT,
  `Empleado` varchar(40) NOT NULL,
  `Clave` varchar(20) NOT NULL,
  PRIMARY KEY (`idEmpleado`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,'Admin','Admin'),(2,'Marcos','contraseña'),(3,'Raul','calveraul');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturaticket`
--

DROP TABLE IF EXISTS `facturaticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facturaticket` (
  `idFactura` bigint(20) NOT NULL AUTO_INCREMENT,
  `IdPagoCaja` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `idCliente` bigint(20) NOT NULL,
  PRIMARY KEY (`idFactura`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturaticket`
--

LOCK TABLES `facturaticket` WRITE;
/*!40000 ALTER TABLE `facturaticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `facturaticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `familiasproductos`
--

DROP TABLE IF EXISTS `familiasproductos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `familiasproductos` (
  `idFamilia` bigint(20) NOT NULL AUTO_INCREMENT,
  `Familia` varchar(60) NOT NULL,
  `Foto` varchar(100) NOT NULL,
  `ver` smallint(6) NOT NULL,
  `EsMenu` char(1) NOT NULL,
  PRIMARY KEY (`idFamilia`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `familiasproductos`
--

LOCK TABLES `familiasproductos` WRITE;
/*!40000 ALTER TABLE `familiasproductos` DISABLE KEYS */;
INSERT INTO `familiasproductos` VALUES (1,'Bocatas','bocatas.png',1,'N'),(2,'Café','cafe.png',1,'N'),(3,'Cerveza','cerveza.png',1,'N'),(4,'Ensaladas','Ensaladas.png',1,'N'),(5,'Snacks','',0,'N'),(6,'Platos Pescado','Pescado.png',0,'N'),(7,'Platos Carne','Carne.png',0,'N'),(8,'Pizza','pizza.png',0,'N'),(9,'Refrescos','Refrescos.png',0,'N'),(10,'Vino','Vino.png',0,'N'),(11,'Menus','Menus.png',1,'S'),(12,'Pizza 2 x 1','pizza1.png',0,'N'),(13,'Almuerzos','Almuerzo.png',1,'S');
/*!40000 ALTER TABLE `familiasproductos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historicopedidos`
--

DROP TABLE IF EXISTS `historicopedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historicopedidos` (
  `idPedido` bigint(20) NOT NULL,
  `linea` int(11) NOT NULL,
  `menu` bigint(20) NOT NULL,
  `Fecha` date NOT NULL,
  `Hora` time NOT NULL,
  `idMesa` int(11) NOT NULL,
  `idProducto` bigint(20) NOT NULL,
  `CompletaMenu` bigint(20) NOT NULL,
  `Preparado` time NOT NULL,
  `Servido` time NOT NULL,
  `Cobrado` time NOT NULL,
  `HoraFactura` time NOT NULL,
  `Importe` decimal(10,2) NOT NULL,
  `idEmpleado` int(11) NOT NULL,
  `TipoPedido` enum('Barra','Mesa') NOT NULL,
  `DeCocina` tinyint(1) NOT NULL,
  `EsPlantilla` int(1) NOT NULL,
  `idFactura` int(11) NOT NULL,
  PRIMARY KEY (`idPedido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historicopedidos`
--

LOCK TABLES `historicopedidos` WRITE;
/*!40000 ALTER TABLE `historicopedidos` DISABLE KEYS */;
INSERT INTO `historicopedidos` VALUES (0,0,0,'2019-02-21','05:00:00',1,5,1,'11:00:00','19:00:00','15:00:00','15:08:05',250.00,3,'Mesa',2,2,1),(1,0,0,'2019-02-21','05:00:00',1,4,1,'11:00:00','19:00:00','15:00:00','07:00:00',20.00,1,'Barra',1,1,1),(2,0,0,'2019-02-21','05:00:00',1,3,1,'11:00:00','19:00:00','15:00:00','09:18:13',20.00,2,'Barra',4,1,6),(3,0,0,'2019-02-21','22:11:00',1,2,1,'11:00:00','19:00:00','15:00:00','04:00:00',250.00,2,'Mesa',1,5,6),(4,0,0,'2019-02-21','00:00:00',1,1,1,'11:00:00','19:00:00','15:00:00','09:00:00',3000.00,2,'Mesa',4,1,2),(5,0,0,'2019-02-25','05:00:00',1,5,1,'11:00:00','19:00:00','15:00:00','15:08:05',250.00,3,'Mesa',2,2,1),(6,0,0,'2019-02-25','05:00:00',1,4,1,'11:00:00','19:00:00','15:00:00','07:00:00',20.00,1,'Barra',1,1,1),(7,0,0,'2019-02-25','05:00:00',1,3,1,'11:00:00','19:00:00','15:00:00','09:18:13',20.00,2,'Barra',4,1,6),(8,0,0,'2019-02-25','22:11:00',1,2,1,'11:00:00','19:00:00','15:00:00','04:00:00',250.00,2,'Mesa',1,5,6),(9,0,0,'2019-02-25','00:00:00',1,1,1,'11:00:00','19:00:00','15:00:00','09:00:00',3000.00,2,'Mesa',4,1,2);
/*!40000 ALTER TABLE `historicopedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mesas`
--

DROP TABLE IF EXISTS `mesas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mesas` (
  `idMesa` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(10) NOT NULL,
  `Estado` enum('Libre','PideCuenta','PendienteServir','Servido') NOT NULL,
  `TipoMesa` enum('Mesa','Barra') NOT NULL,
  PRIMARY KEY (`idMesa`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mesas`
--

LOCK TABLES `mesas` WRITE;
/*!40000 ALTER TABLE `mesas` DISABLE KEYS */;
INSERT INTO `mesas` VALUES (1,'1','PideCuenta','Mesa'),(3,'1-2','Libre',''),(4,'1-3','Libre','Mesa'),(5,'2','PendienteServir','Mesa'),(6,'2-4','Libre','Mesa'),(7,'3','PendienteServir','Mesa'),(8,'3-4','Libre','Mesa'),(9,'4','Servido','Mesa'),(10,'5','Libre','Mesa'),(11,'111','Libre','Barra'),(12,'222','Libre','Barra'),(13,'322','PendienteServir','Barra'),(14,'4','Servido','Barra'),(15,'5','Libre','Barra'),(16,'6','Libre','Barra'),(26,'1','Libre','Barra'),(27,'2','Libre','Barra'),(28,'3','PendienteServir','Barra'),(29,'4','Servido','Barra'),(30,'5','Libre','Barra'),(31,'6','Libre','Barra');
/*!40000 ALTER TABLE `mesas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagoscaja`
--

DROP TABLE IF EXISTS `pagoscaja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagoscaja` (
  `idPagoCaja` int(11) NOT NULL AUTO_INCREMENT,
  `idCaja` bigint(20) NOT NULL,
  `Importe` int(11) NOT NULL,
  `Descripcion` varchar(400) DEFAULT NULL,
  `Hora` time NOT NULL,
  `idEmpleado` int(11) NOT NULL,
  `Comentario` varchar(400) NOT NULL,
  PRIMARY KEY (`idPagoCaja`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagoscaja`
--

LOCK TABLES `pagoscaja` WRITE;
/*!40000 ALTER TABLE `pagoscaja` DISABLE KEYS */;
INSERT INTO `pagoscaja` VALUES (1,1,250,'1','10:00:00',1,'Ha venido San Miguel y ha dejado 5 cajas'),(2,1,20,'202','11:00:00',1,'Se ha fundido una lampara y la hemos cambiado1'),(3,1,6565,'4554','08:00:00',1,'Pago al de fanta'),(4,2,65,'2','22:02:00',1,'222'),(5,32,123,'1234','04:30:21',0,'Descarga de Piñas'),(6,32,25000,'1','04:34:44',0,'papapapap'),(7,32,323,'2323','04:39:36',0,'2323'),(8,33,2,'Papas','23:55:39',0,'eeeeee'),(9,33,2,'Papas','23:55:48',0,'eeeeee'),(10,33,0,'Papas','23:56:09',0,'oooo'),(11,35,21,'1','10:11:21',1,'jejejejejje9'),(12,40,1,'1','11:20:34',1,'1'),(13,40,2,'2','11:20:44',1,'2'),(14,40,3,'3','11:21:01',1,'3'),(15,41,454,'gfgfg','12:06:54',0,'gfgfg'),(18,41,0,'gjghjgh','12:23:34',0,'jghjghj'),(19,54,3,'erere','12:56:22',0,'rerer'),(21,54,666,'uuuuuuuu','13:12:35',0,'u666'),(22,50,12,'','03:49:58',0,'jklhjhjghhjgh'),(23,56,34,'','08:24:19',0,'dfdfdfdf'),(25,57,234,'','09:02:55',1,'fdfdfdfdfdf'),(26,60,12212,'','18:28:25',1,'1212121212345345345 ewrwewer');
/*!40000 ALTER TABLE `pagoscaja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidos` (
  `idPedido` bigint(20) NOT NULL AUTO_INCREMENT,
  `linea` int(11) NOT NULL,
  `menu` bigint(20) NOT NULL,
  `Fecha` date NOT NULL,
  `Hora` time NOT NULL,
  `idMesa` int(11) NOT NULL,
  `idProducto` bigint(20) NOT NULL,
  `CompletaMenu` bigint(20) NOT NULL,
  `Preparado` time NOT NULL,
  `Servido` time NOT NULL,
  `Cobrado` time NOT NULL,
  `HoraFactura` time NOT NULL,
  `Importe` decimal(10,2) NOT NULL,
  `idEmpleado` int(11) NOT NULL,
  `TipoPedido` enum('Barra','Mesa') NOT NULL,
  `DeCocina` tinyint(1) NOT NULL,
  `EsPlantilla` int(1) NOT NULL,
  `idFactura` int(11) NOT NULL,
  `cantidad` int(10) NOT NULL,
  PRIMARY KEY (`idPedido`)
) ENGINE=InnoDB AUTO_INCREMENT=232 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (119,1,0,'2019-03-16','16:05:14',1,2,0,'21:12:21','21:12:21','00:00:00','00:00:00',1.00,1,'Mesa',0,0,0,4),(162,9,0,'2019-03-22','03:15:15',1,2,0,'06:54:58','07:14:34','00:00:00','00:00:00',1.00,1,'Mesa',0,0,0,1),(163,10,0,'2019-03-22','04:03:50',1,4,0,'07:14:48','07:14:48','00:00:00','00:00:00',3.00,1,'Mesa',1,0,0,1),(164,1,0,'2019-03-22','17:15:24',11,2,0,'21:13:17','21:13:21','00:00:00','00:00:00',1.00,1,'Barra',0,0,0,1),(165,1,0,'2019-03-22','18:58:43',5,3,0,'04:00:00','05:00:00','00:00:00','00:00:00',1.00,1,'Mesa',0,0,0,1),(166,1,0,'2019-03-22','19:03:39',14,9,0,'21:13:33','21:13:33','00:00:00','00:00:00',1.00,1,'Barra',0,0,0,1),(167,2,0,'2019-03-23','01:17:57',14,11,0,'21:13:31','00:00:00','00:00:00','00:00:00',2.00,1,'Barra',1,0,0,1),(168,2,0,'2019-03-23','01:18:26',5,11,0,'06:00:00','20:40:45','00:00:00','00:00:00',2.00,1,'Mesa',1,0,0,4),(174,3,0,'2019-03-23','20:53:10',5,3,0,'19:08:56','19:09:22','00:00:00','00:00:00',1.00,1,'Mesa',0,0,0,7),(175,4,4,'2019-03-23','20:54:36',5,6,0,'00:00:00','00:00:00','00:00:00','00:00:00',6.00,1,'Mesa',1,0,0,1),(176,6,4,'2019-03-23','20:54:36',5,14,5,'20:56:47','07:36:21','00:00:00','00:00:00',0.00,1,'Mesa',1,0,0,1),(177,7,4,'2019-03-23','20:54:36',5,15,9,'07:23:08','07:23:08','00:00:00','00:00:00',0.00,1,'Mesa',0,0,0,1),(179,1,0,'2019-03-24','17:54:53',9,5,0,'17:56:15','17:56:15','00:00:00','00:00:00',3.00,1,'Mesa',1,0,0,5),(185,12,0,'2019-03-24','19:05:07',1,10,0,'19:05:32','21:12:48','00:00:00','00:00:00',1.00,1,'Mesa',0,0,0,1),(186,13,0,'2019-03-24','19:05:22',1,2,0,'21:12:23','21:12:23','00:00:00','00:00:00',1.00,1,'Mesa',0,0,0,1),(187,2,0,'2019-03-24','19:07:53',9,2,0,'21:52:48','00:00:00','00:00:00','00:00:00',1.00,1,'Mesa',0,0,0,2),(188,14,0,'2019-07-30','18:40:25',1,8,0,'18:41:57','21:51:34','00:00:00','00:00:00',1.00,1,'Mesa',0,0,0,1),(189,15,0,'2019-07-30','18:41:34',1,9,0,'21:51:37','21:51:37','00:00:00','00:00:00',1.00,1,'Mesa',0,0,0,1),(190,2,2,'2019-11-04','17:27:10',11,7,0,'00:00:00','00:00:00','00:00:00','00:00:00',12.00,1,'Barra',1,0,0,1),(191,3,2,'2019-11-04','17:27:10',11,1,0,'00:00:00','00:00:00','00:00:00','00:00:00',0.00,1,'Barra',0,0,0,1),(192,4,4,'2019-11-04','17:27:12',11,7,0,'00:00:00','00:00:00','00:00:00','00:00:00',12.00,1,'Barra',1,0,0,1),(193,5,4,'2019-11-04','17:27:12',11,1,0,'00:00:00','00:00:00','00:00:00','00:00:00',0.00,1,'Barra',0,0,0,1),(194,6,6,'2019-11-04','17:27:13',11,7,0,'00:00:00','00:00:00','00:00:00','00:00:00',12.00,1,'Barra',1,0,0,1),(195,7,6,'2019-11-04','17:27:13',11,1,0,'00:00:00','00:00:00','00:00:00','00:00:00',0.00,1,'Barra',0,0,0,1),(196,8,8,'2019-11-04','17:27:13',11,7,0,'00:00:00','00:00:00','00:00:00','00:00:00',12.00,1,'Barra',1,0,0,1),(197,9,8,'2019-11-04','17:27:13',11,1,0,'00:00:00','00:00:00','00:00:00','00:00:00',0.00,1,'Barra',0,0,0,1),(224,16,0,'2019-11-04','17:30:53',1,8,0,'17:33:01','00:00:00','00:00:00','00:00:00',1.00,1,'Mesa',0,0,0,1),(225,17,0,'2019-11-04','17:31:13',1,10,0,'17:33:05','17:33:05','00:00:00','00:00:00',1.00,1,'Mesa',0,0,0,1),(226,18,18,'2019-11-04','17:31:50',1,6,0,'00:00:00','00:00:00','00:00:00','00:00:00',6.00,1,'Mesa',1,0,0,1),(227,19,18,'2019-11-04','17:31:50',1,13,2,'17:34:30','00:00:00','00:00:00','00:00:00',0.00,1,'Mesa',0,0,0,1),(228,20,18,'2019-11-04','17:31:50',1,14,5,'17:34:42','17:34:44','00:00:00','00:00:00',0.00,1,'Mesa',1,0,0,1),(229,21,18,'2019-11-04','17:31:50',1,15,8,'17:34:33','00:00:00','00:00:00','00:00:00',0.00,1,'Mesa',0,0,0,1),(230,3,3,'2019-11-04','17:35:48',9,7,0,'00:00:00','00:00:00','00:00:00','00:00:00',12.00,1,'Mesa',1,0,0,1),(231,4,3,'2019-11-04','17:35:48',9,1,0,'00:00:00','00:00:00','00:00:00','00:00:00',0.00,1,'Mesa',0,0,0,1);
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `idProducto` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(60) NOT NULL,
  `Foto` varchar(100) NOT NULL,
  `ver` smallint(6) NOT NULL,
  `PVP` decimal(10,2) NOT NULL,
  `Coste` decimal(10,2) NOT NULL,
  `DeCocina` enum('si','no') NOT NULL,
  `EsMenu` enum('si','no') NOT NULL,
  `EsPlantilla` enum('SÍ','No') NOT NULL,
  `idFamilia` bigint(20) NOT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Coca cola','cocacola.png',0,1.50,1.00,'no','no','No',9),(2,'Amstel 1/3','Amstel.png',1,1.00,1.00,'no','no','No',3),(3,'Amstel 1/5','Amstel.png',1,1.00,1.00,'no','no','No',3),(4,'B Sepia','Sepia.png',0,3.00,2.00,'si','no','No',1),(5,'Brascada','Brascada.png',0,3.00,2.00,'si','no','No',1),(6,'Almuerzo','Almuerzo.png',0,6.00,4.00,'si','si','No',13),(7,'Menu 1','menus.png',0,12.00,8.00,'si','si','No',11),(8,'Sólo','cafe.png',0,1.00,1.00,'no','no','No',2),(9,'Cortado','cafe.png',0,1.00,1.00,'no','no','No',2),(10,'Carajillo de ron','cafe.png',0,1.00,1.00,'no','no','No',2),(11,'Cesar','ensaladas.png',0,2.00,0.00,'si','no','No',4),(12,'Cacahuetes almuerzo','cacahuetes.png',0,0.00,0.00,'no','no','No',5),(13,'Bebida Almuerzo ','cerveza.png',0,0.00,1.00,'no','no','SÍ',3),(14,'Bocadillo almuerzo (sepia, brascada, tortilla langonizas)','bocadillo.png',0,0.00,2.00,'si','no','SÍ',1),(15,'Cafe Almuerzo','cafe.png',0,0.00,0.00,'no','no','SÍ',2);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `idProveedor` bigint(20) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Dir` varchar(100) NOT NULL,
  `Pob` varchar(100) NOT NULL,
  `cp` varchar(10) NOT NULL,
  `CIF` varchar(30) NOT NULL,
  `Prov` varchar(100) NOT NULL,
  `Tel` varchar(100) NOT NULL,
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'Proveedor ALB','C/Valle del Honor 31','Orgrimar','66666','U1526211F','Durotar','666555444'),(2,'Ventormenta Imports','Barrio de los Magos 3','Ventormenta','77777','U1526111F','Bosque de Elwyn','644222777'),(3,'Lolaso SL','C/ Patronum','Los Santos','21313','Asad213','San Andreas','123123123');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservas` (
  `idReserva` bigint(20) NOT NULL AUTO_INCREMENT,
  `Fecha` date NOT NULL,
  `idCliente` bigint(20) NOT NULL,
  `NumeroComensales` int(11) NOT NULL,
  `idMesa` int(11) NOT NULL,
  PRIMARY KEY (`idReserva`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiposproductos`
--

DROP TABLE IF EXISTS `tiposproductos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiposproductos` (
  `idTipo` bigint(20) NOT NULL AUTO_INCREMENT,
  `Tipo` varchar(60) NOT NULL,
  `Foto` varchar(100) NOT NULL,
  `ver` smallint(6) NOT NULL,
  `EsMenu` char(1) NOT NULL,
  PRIMARY KEY (`idTipo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiposproductos`
--

LOCK TABLES `tiposproductos` WRITE;
/*!40000 ALTER TABLE `tiposproductos` DISABLE KEYS */;
INSERT INTO `tiposproductos` VALUES (1,'Café','cafe.png',1,'N'),(2,'Cerveza','cerveza.png',1,'N'),(3,'Ensaladas','Ensaladas.png',1,'N'),(4,'Snacks','',0,'N'),(5,'Refrescos','Refrescos.png',0,'N');
/*!40000 ALTER TABLE `tiposproductos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-08 11:59:37
