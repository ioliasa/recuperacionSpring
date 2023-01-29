-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: mysqlDawes:3306
-- Tiempo de generación: 29-01-2023 a las 18:09:50
-- Versión del servidor: 5.7.22
-- Versión de PHP: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `prueba30Enero`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jacarandenno`
--

CREATE DATABASE `prueba30Enero`;


CREATE TABLE `prueba30Enero`.`jacarandenno` (
  `username` varchar(50) NOT NULL,
  `password` varchar(64) NOT NULL,
  `name` varchar(100) NOT NULL,
  `role` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `jacarandenno`
--

INSERT INTO `prueba30Enero`.`jacarandenno` (`username`, `password`, `name`, `role`) VALUES
('felipe', 'felipe', 'Acosta Del Barco, Felipe', 'STUDENT'),
('alberto', 'albert', 'Adame Roldán, Alberto', 'STUDENT'),
('inma', 'inma', 'Inmaculada Olias', 'TEACHER'),
('joaquin', 'joaquin', 'Joaquin Delhom', 'TEACHER'),
('antonio', 'antonio', 'Calzado Sánchez, Antonio', 'STUDENT'),
('jose', 'jose', 'Castillejo Lobato, José Antonio', 'STUDENT'),
('manuel', 'manuel', 'Manuel Garcia', 'TEACHER'),
('chisela', 'chisela', 'Colás Gil, Chisela Marien', 'STUDENT'),
('nadia', 'nadia', 'Correa Morales, Nadia Lia', 'STUDENT'),
('joseba', 'joseba', 'Díaz González, Joseba', 'STUDENT'),
('raquel', 'raquel', 'Raquel Molina', 'TEACHER'),
('juanma', 'juam', 'García Lora, Juan Manuel', 'STUDENT'),
('tomas', 'tomas', 'Tomas Moreno', 'TEACHER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `module`
--

CREATE TABLE `prueba30Enero`.`module` (
  `initials` varchar(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `hour` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `module`
--

INSERT INTO `prueba30Enero`.`module` (`initials`, `name`, `hour`) VALUES
('DAW', 'Despliegue de aplicaciones web', 3),
('DAWEC', 'Desarrollo de aplicaciones web en entorno cliente', 6),
('DAWES', 'Desarrollo de aplicaciones web en entorno servidor', 8),
('DIW', 'Diseño de interfaces Web', 6),
('EIE', 'Empresa e Iniciativa Emprendedora', 4),
('HLC', 'Horas de libre configuración', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turn`
--

CREATE TABLE `prueba30Enero`.`turn` (
  `id_student` varchar(50) NOT NULL,
  `initials_module` varchar(10) NOT NULL,
  `time` datetime NOT NULL,
  `done` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `turn`
--

INSERT INTO `prueba30Enero`.`turn` (`id_student`, `initials_module`, `time`, `done`) VALUES
('antonio', 'DAW', '2023-01-17 10:35:23', 0),
('antonio', 'DAW', '2023-01-24 00:00:00', 1),
('juanma', 'DAW', '2023-01-29 10:57:32', 0),
('juanma', 'DAWEC', '2023-01-23 10:35:23', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `jacarandenno`
--
ALTER TABLE `prueba30Enero`.`jacarandenno`
  ADD PRIMARY KEY (`username`);

--
-- Indices de la tabla `module`
--
ALTER TABLE `prueba30Enero`.`module`
  ADD PRIMARY KEY (`initials`);

--
-- Indices de la tabla `turn`
--
ALTER TABLE `prueba30Enero`.`turn`
  ADD PRIMARY KEY (`id_student`,`initials_module`,`time`),
  ADD KEY `fk_pruebEnero_module` (`initials_module`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `turn`
--
ALTER TABLE `prueba30Enero`.`turn`
  ADD CONSTRAINT `fk_pruebEnero_module` FOREIGN KEY (`initials_module`) REFERENCES `module` (`initials`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_pruebEnero_student` FOREIGN KEY (`id_student`) REFERENCES `jacarandenno` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;


