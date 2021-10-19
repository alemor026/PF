-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bd_proyecto
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(60) NOT NULL,
  `apellidos` varchar(60) NOT NULL,
  `nit` varchar(12) NOT NULL,
  `genero` bit(1) NOT NULL,
  `telefono` varchar(25) NOT NULL,
  `correo_electronico` varchar(45) NOT NULL,
  `fecha_ingreso` datetime NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras` (
  `idCompra` int NOT NULL AUTO_INCREMENT,
  `no_orden_compra` int NOT NULL,
  `idProveedor` int NOT NULL,
  `fecha_orden` date NOT NULL,
  `fecha_ingreso` datetime NOT NULL,
  PRIMARY KEY (`idCompra`),
  KEY `id_compra_proveedor_idx` (`idProveedor`),
  CONSTRAINT `id_compra_proveedor` FOREIGN KEY (`idProveedor`) REFERENCES `proveedores` (`idProveedor`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras_detalle`
--

DROP TABLE IF EXISTS `compras_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras_detalle` (
  `idCompra_Detalle` bigint NOT NULL AUTO_INCREMENT,
  `idCompra` int NOT NULL,
  `idProducto` int NOT NULL,
  `cantidad` int NOT NULL,
  `precio_costo_unitario` decimal(8,2) NOT NULL,
  PRIMARY KEY (`idCompra_Detalle`),
  KEY `id_compra_compra_detalle_idx` (`idCompra`),
  KEY `id_producto_compra_detalle_idx` (`idProducto`),
  CONSTRAINT `id_compra_compra_detalle` FOREIGN KEY (`idCompra`) REFERENCES `compras` (`idCompra`) ON UPDATE CASCADE,
  CONSTRAINT `id_producto_compra_detalle` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`idProducto`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras_detalle`
--

LOCK TABLES `compras_detalle` WRITE;
/*!40000 ALTER TABLE `compras_detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `compras_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `idEmpleado` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(60) NOT NULL,
  `apellidos` varchar(60) NOT NULL,
  `direccion` varchar(60) NOT NULL,
  `telefono` varchar(25) NOT NULL,
  `DPI` varchar(15) NOT NULL,
  `genero` bit(1) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `idPuesto` smallint NOT NULL,
  `fecha_inicio_labores` date NOT NULL,
  `fecha_ingreso` datetime NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  KEY `id_empleado_puesto_idx` (`idPuesto`),
  CONSTRAINT `id_empleado_puesto` FOREIGN KEY (`idPuesto`) REFERENCES `puestos` (`idPuesto`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marcas`
--

DROP TABLE IF EXISTS `marcas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marcas` (
  `idMarca` smallint NOT NULL AUTO_INCREMENT,
  `marca` varchar(50) NOT NULL,
  PRIMARY KEY (`idMarca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marcas`
--

LOCK TABLES `marcas` WRITE;
/*!40000 ALTER TABLE `marcas` DISABLE KEYS */;
/*!40000 ALTER TABLE `marcas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `idProducto` int NOT NULL AUTO_INCREMENT,
  `producto` varchar(50) NOT NULL,
  `idMarca` smallint NOT NULL,
  `decripcion` varchar(100) NOT NULL,
  `imagen` varchar(30) NOT NULL,
  `precio_costo` decimal(8,2) NOT NULL,
  `precio_venta` decimal(8,2) NOT NULL,
  `existencia` int NOT NULL,
  `fecha_ingreso` datetime NOT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `id_producto_marca_idx` (`idMarca`),
  CONSTRAINT `id_producto_marca` FOREIGN KEY (`idMarca`) REFERENCES `marcas` (`idMarca`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `idProveedor` int NOT NULL AUTO_INCREMENT,
  `proveedor` varchar(60) NOT NULL,
  `nit` varchar(12) NOT NULL,
  `direccion` varchar(80) NOT NULL,
  `telefono` varchar(25) NOT NULL,
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puestos`
--

DROP TABLE IF EXISTS `puestos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `puestos` (
  `idPuesto` smallint NOT NULL AUTO_INCREMENT,
  `puesto` varchar(50) NOT NULL,
  PRIMARY KEY (`idPuesto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puestos`
--

LOCK TABLES `puestos` WRITE;
/*!40000 ALTER TABLE `puestos` DISABLE KEYS */;
/*!40000 ALTER TABLE `puestos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `idVenta` int NOT NULL AUTO_INCREMENT,
  `no_factura` int NOT NULL,
  `serie` char(1) NOT NULL,
  `fecha_factura` date NOT NULL,
  `idCliente` int NOT NULL,
  `idEmpleado` int NOT NULL,
  `fechaingreso` datetime NOT NULL,
  PRIMARY KEY (`idVenta`),
  KEY `id_venta_cliente_idx` (`idCliente`),
  KEY `id_venta_empleado_idx` (`idEmpleado`),
  CONSTRAINT `id_venta_cliente` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idCliente`) ON UPDATE CASCADE,
  CONSTRAINT `id_venta_empleado` FOREIGN KEY (`idEmpleado`) REFERENCES `empleados` (`idEmpleado`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas_detalle`
--

DROP TABLE IF EXISTS `ventas_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas_detalle` (
  `idVenta_detalle` bigint NOT NULL AUTO_INCREMENT,
  `idVenta` int NOT NULL,
  `idProducto` int NOT NULL,
  `cantidad` varchar(45) NOT NULL,
  `precio_unitario` decimal(8,2) NOT NULL,
  PRIMARY KEY (`idVenta_detalle`),
  KEY `id_venta_venta_detalle_idx` (`idVenta`),
  KEY `id_producto_venta_detalle_idx` (`idProducto`),
  CONSTRAINT `id_producto_venta_detalle` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`idProducto`) ON UPDATE CASCADE,
  CONSTRAINT `id_venta_venta_detalle` FOREIGN KEY (`idVenta`) REFERENCES `ventas` (`idVenta`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas_detalle`
--

LOCK TABLES `ventas_detalle` WRITE;
/*!40000 ALTER TABLE `ventas_detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventas_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'bd_proyecto'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-07 20:08:07
