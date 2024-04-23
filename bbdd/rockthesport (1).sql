
-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-04-2024 a las 10:15:48
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `rockthesport`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudades`
--

CREATE TABLE `ciudades` (
  `idCiudad` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `poblacion` int(11) NOT NULL,
  `ubicacionGeografica` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `ciudades`
--

INSERT INTO `ciudades` (`idCiudad`, `nombre`, `poblacion`, `ubicacionGeografica`) VALUES
(1, 'Madrid', 3223334, 'España'),
(2, 'Barcelona', 1620343, 'España'),
(3, 'Valencia', 791413, 'España'),
(4, 'Sevilla', 688592, 'España'),
(5, 'Zaragoza', 661108, 'España'),
(6, 'Málaga', 571026, 'España'),
(7, 'Murcia', 451123, 'España'),
(8, 'Palma de Mallorca', 404681, 'España'),
(9, 'Las Palmas de Gran Canaria', 383308, 'España'),
(10, 'Bilbao', 345821, 'España'),
(11, 'Alicante', 334678, 'España'),
(12, 'Córdoba', 328428, 'España'),
(13, 'Valladolid', 298412, 'España'),
(14, 'Vigo', 295364, 'España'),
(15, 'Gijón', 271780, 'España'),
(16, 'Hospitalet de Llobregat', 257038, 'España'),
(17, 'La Coruña', 244388, 'España'),
(18, 'Vitoria-Gasteiz', 242082, 'España'),
(19, 'Granada', 239154, 'España'),
(20, 'Elche', 235487, 'España'),
(21, 'París', 2140526, 'Francia'),
(22, 'Londres', 8982000, 'Reino Unido'),
(23, 'Berlín', 3769495, 'Alemania'),
(24, 'Roma', 2873494, 'Italia'),
(25, 'Ámsterdam', 821752, 'Países Bajo'),
(26, 'Bruselas', 1211035, 'Bélgica'),
(27, 'Praga', 1301132, 'República C'),
(28, 'Viena', 1840573, 'Austria'),
(29, 'Atenas', 664046, 'Grecia'),
(30, 'Estambul', 15423500, 'Turquía');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `deportista`
--

CREATE TABLE `deportista` (
  `idDeportista` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `edad` int(11) NOT NULL,
  `genero` enum('Hombre','Mujer','No-Binario','Apache 130DX') NOT NULL,
  `email` varchar(255) NOT NULL,
  `telefono` int(11) NOT NULL,
  `DNI` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `deportista`
--

INSERT INTO `deportista` (`idDeportista`, `Nombre`, `edad`, `genero`, `email`, `telefono`, `DNI`) VALUES
(1, 'Juan Perez', 25, 'Hombre', 'juan.perez@example.com', 123456789, '12345678A'),
(2, 'Maria Garcia', 30, 'Mujer', 'maria.garcia@example.com', 987654321, '87654321B'),
(3, 'Carlos Rodriguez', 22, 'Hombre', 'carlos.rodriguez@example.com', 456789123, '76543210C'),
(4, 'Ana Martínez', 28, 'Mujer', 'ana.martinez@example.com', 321654987, '65432109D'),
(5, 'Pedro Sanchez', 35, 'Hombre', 'pedro.sanchez@example.com', 789123456, '54321098E'),
(6, 'Laura Fernandez', 29, 'Mujer', 'laura.fernandez@example.com', 654987321, '43210987F'),
(7, 'David Lopez', 27, 'Hombre', 'david.lopez@example.com', 147258369, '32109876G'),
(8, 'Sofia Perez', 24, 'Mujer', 'sofia.perez@example.com', 369258147, '21098765H'),
(9, 'Manuel Gomez', 31, 'Hombre', 'manuel.gomez@example.com', 258369147, '10987654I'),
(10, 'Elena Alonso', 26, 'Mujer', 'elena.alonso@example.com', 852963741, '09876543J'),
(11, 'Daniel Ruiz', 33, 'Hombre', 'daniel.ruiz@example.com', 369147258, '98765432K'),
(12, 'Lucia Torres', 23, 'Mujer', 'lucia.torres@example.com', 741852963, '87654321L'),
(13, 'Javier Jimenez', 32, 'Hombre', 'javier.jimenez@example.com', 963852741, '76543210M'),
(14, 'Carmen Sanchez', 28, 'Mujer', 'carmen.sanchez@example.com', 258963147, '65432109N'),
(15, 'Diego Vazquez', 29, 'Hombre', 'diego.vazquez@example.com', 852147963, '54321098O'),
(16, 'Isabel Lopez', 27, 'Mujer', 'isabel.lopez@example.com', 147963852, '43210987P'),
(17, 'Adrian Fernandez', 30, 'Hombre', 'adrian.fernandez@example.com', 963258741, '32109876Q'),
(18, 'Natalia Gonzalez', 25, 'Mujer', 'natalia.gonzalez@example.com', 369741852, '21098765R'),
(19, 'Alejandro Martin', 34, 'Hombre', 'alejandro.martin@example.com', 741369852, '10987654S'),
(20, 'Paula Diaz', 24, 'Mujer', 'paula.diaz@example.com', 852147963, '09876543T'),
(21, 'Roberto Hernández', 50, 'Hombre', 'roberto.hernandez@example.com', 123456789, '12345678U'),
(22, 'Luisa González', 40, 'Mujer', 'luisa.gonzalez@example.com', 987654321, '87654321V'),
(23, 'Fernando Martínez', 45, 'Hombre', 'fernando.martinez@example.com', 456789123, '76543210W'),
(24, 'Carmen Rodríguez', 38, 'Mujer', 'carmen.rodriguez@example.com', 321654987, '65432109X'),
(25, 'María Sánchez', 55, 'Mujer', 'maria.sanchez@example.com', 789123456, '54321098Y'),
(26, 'José García', 60, 'Hombre', 'jose.garcia@example.com', 654987321, '43210987Z'),
(27, 'Ana Pérez', 58, 'Mujer', 'ana.perez@example.com', 147258369, '32109876A'),
(28, 'Miguel Fernández', 63, 'Hombre', 'miguel.fernandez@example.com', 369258147, '21098765A'),
(29, 'Lucía Gómez', 52, 'Mujer', 'lucia.gomez@example.com', 258369147, '10987654A'),
(30, 'Antonio Ruiz', 64, 'Hombre', 'antonio.ruiz@example.com', 852963741, '09876543A'),
(31, 'Cristina Martínez', 55, 'Mujer', 'cristina.martinez@example.com', 369147258, '98765432A'),
(32, 'Pablo Torres', 59, 'Hombre', 'pablo.torres@example.com', 741852963, '87654321A'),
(33, 'Elena Jiménez', 61, 'Mujer', 'elena.jimenez@example.com', 963852741, '76543210A'),
(34, 'Juan Carlos Pérez', 67, 'Hombre', 'juancarlos.perez@example.com', 258963147, '65432109A'),
(35, 'María Dolores Sánchez', 62, 'Mujer', 'mariadolores.sanchez@example.com', 852147963, '54321098A'),
(36, 'Manuel Gutiérrez', 65, 'Hombre', 'manuel.gutierrez@example.com', 147963852, '43210987A'),
(37, 'Sara López', 61, 'Mujer', 'sara.lopez@example.com', 963258741, '32109876A'),
(38, 'Antonia Martín', 56, 'Mujer', 'antonia.martin@example.com', 369741852, '21098765A'),
(39, 'Juan José García', 66, 'Hombre', 'juanjose.garcia@example.com', 741369852, '10987654A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ediciones`
--

CREATE TABLE `ediciones` (
  `idEdicion` int(11) NOT NULL,
  `cuposDisponibles` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `idEvento` int(11) NOT NULL,
  `idCiudad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eventosdeportivos`
--

CREATE TABLE `eventosdeportivos` (
  `idEvento` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `tipoDeporte` enum('Triatlon','Ciclismo','Maraton','PiragÃ¼ismo','Futbol','Eskupilota','CestaPunta') NOT NULL,
  `idOrganizador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripciones`
--

CREATE TABLE `inscripciones` (
  `idInscripcion` int(11) NOT NULL,
  `dorsal` int(11) NOT NULL,
  `fechaInscipcion` date NOT NULL,
  `idDeportista` int(11) NOT NULL,
  `idEdicion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `organizadores`
--

CREATE TABLE `organizadores` (
  `idOrganizador` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `telefono` int(9) NOT NULL,
  `dni` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resultados`
--

CREATE TABLE `resultados` (
  `idResultado` int(11) NOT NULL,
  `tiempo` varchar(255) NOT NULL,
  `clasificaion` int(11) NOT NULL,
  `idInscripcion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ciudades`
--
ALTER TABLE `ciudades`
  ADD PRIMARY KEY (`idCiudad`);

--
-- Indices de la tabla `deportista`
--
ALTER TABLE `deportista`
  ADD PRIMARY KEY (`idDeportista`);

--
-- Indices de la tabla `ediciones`
--
ALTER TABLE `ediciones`
  ADD PRIMARY KEY (`idEdicion`),
  ADD UNIQUE KEY `idCiudad` (`idCiudad`),
  ADD UNIQUE KEY `idEvento` (`idEvento`);

--
-- Indices de la tabla `eventosdeportivos`
--
ALTER TABLE `eventosdeportivos`
  ADD PRIMARY KEY (`idEvento`),
  ADD UNIQUE KEY `idOrganizador` (`idOrganizador`);

--
-- Indices de la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  ADD PRIMARY KEY (`idInscripcion`),
  ADD UNIQUE KEY `idDeportista` (`idDeportista`,`idEdicion`),
  ADD KEY `idEdicion` (`idEdicion`);

--
-- Indices de la tabla `organizadores`
--
ALTER TABLE `organizadores`
  ADD PRIMARY KEY (`idOrganizador`);

--
-- Indices de la tabla `resultados`
--
ALTER TABLE `resultados`
  ADD PRIMARY KEY (`idResultado`),
  ADD UNIQUE KEY `idInscripcion` (`idInscripcion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ciudades`
--
ALTER TABLE `ciudades`
  MODIFY `idCiudad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `deportista`
--
ALTER TABLE `deportista`
  MODIFY `idDeportista` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT de la tabla `ediciones`
--
ALTER TABLE `ediciones`
  MODIFY `idEdicion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `eventosdeportivos`
--
ALTER TABLE `eventosdeportivos`
  MODIFY `idEvento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  MODIFY `idInscripcion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `organizadores`
--
ALTER TABLE `organizadores`
  MODIFY `idOrganizador` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `resultados`
--
ALTER TABLE `resultados`
  MODIFY `idResultado` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ediciones`
--
ALTER TABLE `ediciones`
  ADD CONSTRAINT `ediciones_ibfk_1` FOREIGN KEY (`idCiudad`) REFERENCES `ciudades` (`idCiudad`) ON DELETE CASCADE,
  ADD CONSTRAINT `ediciones_ibfk_2` FOREIGN KEY (`idEvento`) REFERENCES `eventosdeportivos` (`idEvento`) ON DELETE CASCADE;

--
-- Filtros para la tabla `eventosdeportivos`
--
ALTER TABLE `eventosdeportivos`
  ADD CONSTRAINT `eventosdeportivos_ibfk_1` FOREIGN KEY (`idOrganizador`) REFERENCES `organizadores` (`idOrganizador`) ON DELETE CASCADE;

--
-- Filtros para la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  ADD CONSTRAINT `inscripciones_ibfk_1` FOREIGN KEY (`idDeportista`) REFERENCES `deportista` (`idDeportista`) ON DELETE CASCADE,
  ADD CONSTRAINT `inscripciones_ibfk_2` FOREIGN KEY (`idEdicion`) REFERENCES `ediciones` (`idEdicion`) ON DELETE CASCADE;

--
-- Filtros para la tabla `resultados`
--
ALTER TABLE `resultados`
  ADD CONSTRAINT `resultados_ibfk_1` FOREIGN KEY (`idInscripcion`) REFERENCES `inscripciones` (`idInscripcion`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
