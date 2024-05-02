-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-05-2024 a las 10:43:40
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

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
(1, 'Madrid', 3223334, 'Espana'),
(2, 'Barcelona', 1620343, 'Espana'),
(3, 'Valencia', 791413, 'Espana'),
(4, 'Sevilla', 688592, 'Espana'),
(5, 'Zaragoza', 661108, 'Espana'),
(6, 'Malaga', 571026, 'Espana'),
(7, 'Murcia', 451123, 'Espana'),
(8, 'Palma de Mallorca', 404681, 'Espana'),
(9, 'Las Palmas de Gran Canaria', 383308, 'Espana'),
(10, 'Bilbao', 345821, 'Espana'),
(11, 'Alicante', 334678, 'Espana'),
(12, 'Cordoba', 328428, 'Espana'),
(13, 'Valladolid', 298412, 'Espana'),
(14, 'Vigo', 295364, 'Espana'),
(15, 'Gijon', 271780, 'Espana'),
(16, 'Hospitalet de Llobregat', 257038, 'Espana'),
(17, 'La Coruna', 244388, 'Espana'),
(18, 'Vitoria-Gasteiz', 242082, 'Espana'),
(19, 'Granada', 239154, 'Espana'),
(20, 'Elche', 235487, 'Espana'),
(21, 'Paris', 2140526, 'Francia'),
(22, 'Londres', 8982000, 'Reino Unido'),
(23, 'Berlin', 3769495, 'Alemania'),
(25, 'Amsterdam', 821752, 'Paises Bajo'),
(26, 'Bruselas', 1211035, 'Belgica'),
(27, 'Praga', 1301132, 'Republica C'),
(28, 'Viena', 1840573, 'Austria'),
(29, 'Atenas', 664046, 'Grecia');

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
(4, 'Ana Martinez', 28, 'Mujer', 'ana.martinez@example.com', 321654987, '65432109D'),
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
(21, 'Roberto Hernindez', 50, 'Hombre', 'roberto.hernandez@example.com', 123456789, '12345678U'),
(22, 'Luisa Gonzalez', 40, 'Mujer', 'luisa.gonzalez@example.com', 987654321, '87654321V'),
(23, 'Fernando Martinez', 45, 'Hombre', 'fernando.martinez@example.com', 456789123, '76543210W'),
(24, 'Carmen Rodriguez', 38, 'Mujer', 'carmen.rodriguez@example.com', 321654987, '65432109X'),
(25, 'Marta Sanchez', 55, 'Mujer', 'maria.sanchez@example.com', 789123456, '54321098Y'),
(26, 'Jose Garcia', 60, 'Hombre', 'jose.garcia@example.com', 654987321, '43210987Z'),
(27, 'Ana Perez', 58, 'Mujer', 'ana.perez@example.com', 147258369, '32109876A'),
(28, 'Miguel Fernandez', 63, 'Hombre', 'miguel.fernandez@example.com', 369258147, '21098765A'),
(29, 'Lucia Gomez', 52, 'Mujer', 'lucia.gomez@example.com', 258369147, '10987654A'),
(30, 'Antonio Ruiz', 64, 'Hombre', 'antonio.ruiz@example.com', 852963741, '09876543A'),
(31, 'Cristina Martinez', 55, 'Mujer', 'cristina.martinez@example.com', 369147258, '98765432A'),
(32, 'Pablo Torres', 59, 'Hombre', 'pablo.torres@example.com', 741852963, '87654321A'),
(33, 'Elena Jimenez', 61, 'Mujer', 'elena.jimenez@example.com', 963852741, '76543210A'),
(34, 'Juan Carlos Perez', 67, 'Hombre', 'juancarlos.perez@example.com', 258963147, '65432109A'),
(35, 'Marta Dolores Sanchez', 62, 'Mujer', 'mariadolores.sanchez@example.com', 852147963, '54321098A'),
(36, 'Manuel Guti�rrez', 65, 'Hombre', 'manuel.gutierrez@example.com', 147963852, '43210987A'),
(37, 'Sara L�pez', 61, 'Mujer', 'sara.lopez@example.com', 963258741, '32109876A'),
(38, 'Antonia Martin', 56, 'Mujer', 'antonia.martin@example.com', 369741852, '21098765A'),
(39, 'Juan Jose Garcia', 66, 'Hombre', 'juanjose.garcia@example.com', 741369852, '10987654A');

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

--
-- Volcado de datos para la tabla `ediciones`
--

INSERT INTO `ediciones` (`idEdicion`, `cuposDisponibles`, `fecha`, `idEvento`, `idCiudad`) VALUES
(11, 5000, '2024-06-15', 11, 1),
(12, 8000, '2024-07-20', 12, 2),
(13, 6000, '2024-08-10', 13, 3),
(14, 7000, '2024-09-05', 14, 4),
(15, 9000, '2024-10-12', 15, 5),
(16, 10000, '2024-11-18', 16, 6),
(17, 12000, '2024-12-22', 17, 7),
(18, 3000, '2025-01-30', 18, 8),
(19, 4000, '2025-02-25', 19, 9),
(20, 6000, '2025-03-15', 20, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eventosdeportivos`
--

CREATE TABLE `eventosdeportivos` (
  `idEvento` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `tipoDeporte` enum('Triatlon','Ciclismo','Maraton','Piragüismo','Futbol','Eskupilota','CestaPunta') NOT NULL,
  `idOrganizador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `eventosdeportivos`
--

INSERT INTO `eventosdeportivos` (`idEvento`, `nombre`, `descripcion`, `tipoDeporte`, `idOrganizador`) VALUES
(11, 'Maraton de Madrid', '¡Unete a la carrera mas emocionante de la ciudad!', 'Maraton', 1),
(12, 'Campeonato de Ciclismo de Montana', '¡Desafia las montanas en esta competicion unica!', 'Ciclismo', 2),
(13, 'Triatlon Costa del Sol', '¡Nada, pedalea y corre en uno de los eventos mas desafiantes!', 'Triatlon', 3),
(14, 'Copa de Futbol Internacional', '¡Los equipos mas grandes del mundo compiten por la gloria!', 'Futbol', 4),
(15, 'Torneo de Piraguismo en el Danubio', '¡Deslizate por las aguas del Danubio en este emocionante torneo!', 'Piragüismo', 5),
(16, 'Campeonato de Eskupilota', '¡Experimenta la velocidad y la destreza en este torneo de pelota vasca!', 'Eskupilota', 6),
(17, 'Maraton de Atenas', '¡Corre en la cuna de los Juegos Olimpicos en este desafiante maraton!', 'Maraton', 7),
(18, 'Carrera de Cesta Punta en Biarritz', '¡Disfruta del deporte vasco en las playas de Biarritz!', 'CestaPunta', 8),
(19, 'Campeonato Nacional de Triatlon', '¡Los mejores triatletas del pais compiten por el titulo nacional!', 'Triatlon', 9),
(20, 'Torneo de Ciclismo de Ruta en los Alpes', '¡Enfrenta los desafios de las carreteras alpinas en este emocionante torneo!', 'Ciclismo', 10);

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

--
-- Volcado de datos para la tabla `inscripciones`
--

INSERT INTO `inscripciones` (`idInscripcion`, `dorsal`, `fechaInscipcion`, `idDeportista`, `idEdicion`) VALUES
(31, 1001, '2024-06-01', 1, 11),
(32, 1002, '2024-06-02', 2, 11),
(33, 1003, '2024-06-03', 3, 11),
(34, 1004, '2024-06-04', 4, 11),
(35, 1005, '2024-06-05', 5, 12),
(36, 1006, '2024-06-06', 6, 12),
(37, 1007, '2024-06-07', 7, 12),
(38, 1008, '2024-06-08', 8, 13),
(39, 1009, '2024-06-09', 9, 13),
(40, 1010, '2024-06-10', 10, 14),
(41, 1011, '2024-07-01', 11, 14),
(42, 1012, '2024-07-02', 12, 15),
(43, 1013, '2024-07-03', 13, 15),
(44, 1014, '2024-07-04', 14, 16),
(45, 1015, '2024-07-05', 15, 16),
(46, 1016, '2024-07-06', 16, 17),
(47, 1017, '2024-07-07', 17, 17),
(48, 1018, '2024-07-08', 18, 17),
(49, 1019, '2024-07-09', 19, 18),
(50, 1020, '2024-07-10', 20, 18),
(51, 1021, '2024-08-01', 21, 18),
(52, 1022, '2024-08-02', 22, 18),
(53, 1023, '2024-08-03', 23, 19),
(54, 1024, '2024-08-04', 24, 19),
(55, 1025, '2024-08-05', 25, 19),
(56, 1026, '2024-08-06', 26, 20),
(57, 1027, '2024-08-07', 27, 20),
(58, 1028, '2024-08-08', 28, 20),
(59, 1029, '2024-08-09', 29, 20),
(60, 1030, '2024-08-10', 30, 20);

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

--
-- Volcado de datos para la tabla `organizadores`
--

INSERT INTO `organizadores` (`idOrganizador`, `nombre`, `email`, `telefono`, `dni`) VALUES
(1, 'Ana Garcia', 'ana.garcia@example.com', 123456789, 12345678),
(2, 'David Martinez', 'david.martinez@example.com', 987654321, 87654321),
(3, 'Elena Lopez', 'elena.lopez@example.com', 456789123, 76543210),
(4, 'Juan Rodriguez', 'juan.rodriguez@example.com', 321654987, 65432109),
(5, 'Maria Sanchez', 'maria.sanchez@example.com', 789123456, 54321098),
(6, 'Carlos Feraández', 'carlos.fernandez@example.com', 654987321, 43210987),
(7, 'Laura Perez', 'laura.perez@example.com', 147258369, 32109876),
(8, 'Daniel Gonzalez', 'daniel.gonzalez@example.com', 369258147, 21098765),
(9, 'Sara Martin', 'sara.martin@example.com', 258369147, 10987654),
(10, 'Javier Ruiz', 'javier.ruiz@example.com', 852963741, 9876543);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resultados`
--

CREATE TABLE `resultados` (
  `idResultado` int(11) NOT NULL,
  `tiempo` varchar(255) NOT NULL,
  `clasificacion` int(11) NOT NULL,
  `idInscripcion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `resultados`
--

INSERT INTO `resultados` (`idResultado`, `tiempo`, `clasificacion`, `idInscripcion`) VALUES
(1, '2:15:30', 1, 31),
(2, '2:20:15', 10, 32),
(3, '2:25:45', 6, 33),
(4, '2:30:10', 8, 34),
(5, '2:35:20', 3, 35),
(6, '2:40:55', 7, 36),
(7, '2:45:30', 4, 37),
(8, '2:50:40', 9, 38),
(9, '2:55:15', 5, 39),
(10, '3:00:25', 2, 40),
(11, '3:10:30', 3, 41),
(12, '3:15:20', 4, 42),
(13, '3:20:45', 5, 43),
(14, '3:25:55', 6, 44),
(15, '3:30:40', 7, 45),
(16, '3:35:25', 8, 46),
(17, '3:40:10', 9, 47),
(18, '3:45:20', 10, 48),
(19, '3:50:15', 1, 49),
(20, '3:55:30', 2, 50),
(21, '4:05:20', 5, 51),
(22, '4:10:30', 6, 52),
(23, '4:15:40', 7, 53),
(24, '4:20:55', 8, 54),
(25, '4:25:15', 9, 55);

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
  ADD KEY `idCiudad` (`idCiudad`) USING BTREE,
  ADD KEY `idEvento` (`idEvento`) USING BTREE;

--
-- Indices de la tabla `eventosdeportivos`
--
ALTER TABLE `eventosdeportivos`
  ADD PRIMARY KEY (`idEvento`),
  ADD KEY `fk_foreign_key_organizador` (`idOrganizador`);

--
-- Indices de la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  ADD PRIMARY KEY (`idInscripcion`),
  ADD KEY `idEdicion` (`idEdicion`),
  ADD KEY `idDeportista` (`idDeportista`,`idEdicion`) USING BTREE;

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
  ADD KEY `idInscripcion` (`idInscripcion`) USING BTREE;

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ciudades`
--
ALTER TABLE `ciudades`
  MODIFY `idCiudad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT de la tabla `deportista`
--
ALTER TABLE `deportista`
  MODIFY `idDeportista` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT de la tabla `ediciones`
--
ALTER TABLE `ediciones`
  MODIFY `idEdicion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `eventosdeportivos`
--
ALTER TABLE `eventosdeportivos`
  MODIFY `idEvento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  MODIFY `idInscripcion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT de la tabla `organizadores`
--
ALTER TABLE `organizadores`
  MODIFY `idOrganizador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `resultados`
--
ALTER TABLE `resultados`
  MODIFY `idResultado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

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
  ADD CONSTRAINT `eventosdeportivos_ibfk_1` FOREIGN KEY (`idOrganizador`) REFERENCES `organizadores` (`idOrganizador`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_foreign_key_organizador` FOREIGN KEY (`idOrganizador`) REFERENCES `organizadores` (`idOrganizador`);

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
