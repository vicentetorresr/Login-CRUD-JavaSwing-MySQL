-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-09-2024 a las 21:24:04
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bbdd_torres_toro`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vtjt_atleta`
--

CREATE TABLE `vtjt_atleta` (
  `atl_rut` varchar(10) NOT NULL,
  `atl_nombre` varchar(50) NOT NULL,
  `atl_apellido1` varchar(50) NOT NULL,
  `atl_apellido2` varchar(50) NOT NULL,
  `atl_fechaNacimiento` date NOT NULL,
  `atl_especialidad` int(11) NOT NULL,
  `atl_ciudad_id` int(11) NOT NULL,
  `atl_estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vtjt_atleta`
--

INSERT INTO `vtjt_atleta` (`atl_rut`, `atl_nombre`, `atl_apellido1`, `atl_apellido2`, `atl_fechaNacimiento`, `atl_especialidad`, `atl_ciudad_id`, `atl_estado`) VALUES
('000000000', 'Atleta10', 'Apellido1', 'Apellido2', '1999-10-10', 5, 5, 1),
('111111111', 'Atleta1', 'Apellido1', 'Apellido2', '1990-01-01', 1, 1, 1),
('222222222', 'Atleta2', 'Apellido1', 'Apellido2', '1991-02-02', 2, 2, 1),
('333333333', 'Atleta3', 'Apellido1', 'Apellido2', '1992-03-03', 3, 3, 1),
('444444444', 'Atleta4', 'Apellido1', 'Apellido2', '1993-04-04', 4, 4, 1),
('555555555', 'Atleta5', 'Apellido1', 'Apellido2', '1994-05-05', 5, 5, 1),
('666666666', 'Atleta6', 'Apellido1', 'Apellido2', '1995-06-06', 1, 1, 1),
('777777777', 'Atleta7', 'Apellido1', 'Apellido2', '1996-07-07', 2, 2, 1),
('888888888', 'Atleta8', 'Apellido1', 'Apellido2', '1997-08-08', 3, 3, 1),
('999999999', 'Atleta9', 'Apellido1', 'Apellido2', '1998-09-09', 4, 4, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vtjt_ciudad`
--

CREATE TABLE `vtjt_ciudad` (
  `ciu_id` int(11) NOT NULL,
  `ciu_ciudad_origen` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vtjt_ciudad`
--

INSERT INTO `vtjt_ciudad` (`ciu_id`, `ciu_ciudad_origen`) VALUES
(4, 'Bogotá'),
(2, 'Buenos Aires'),
(5, 'Ciudad de México'),
(3, 'Lima'),
(1, 'Santiago');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vtjt_detalle_evento`
--

CREATE TABLE `vtjt_detalle_evento` (
  `dee_id` int(11) NOT NULL,
  `dee_evento_id` int(11) NOT NULL,
  `dee_atleta_rut` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vtjt_detalle_evento`
--

INSERT INTO `vtjt_detalle_evento` (`dee_id`, `dee_evento_id`, `dee_atleta_rut`) VALUES
(1, 1, '111111111'),
(2, 1, '222222222'),
(3, 2, '333333333'),
(4, 2, '444444444'),
(5, 3, '555555555'),
(6, 3, '666666666'),
(7, 4, '777777777'),
(8, 4, '888888888'),
(9, 5, '999999999'),
(10, 5, '000000000'),
(11, 3, '555555555'),
(12, 3, '666666666'),
(13, 3, '222222222'),
(14, 1, '111111111'),
(15, 1, '222222222'),
(16, 1, '999999999');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vtjt_especialidad`
--

CREATE TABLE `vtjt_especialidad` (
  `esp_id` int(11) NOT NULL,
  `esp_especialidad_atleta` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vtjt_especialidad`
--

INSERT INTO `vtjt_especialidad` (`esp_id`, `esp_especialidad_atleta`) VALUES
(3, 'Atletismo'),
(2, 'Ciclismo'),
(4, 'Gimnasia'),
(1, 'Natación'),
(5, 'Vóley');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vtjt_estado`
--

CREATE TABLE `vtjt_estado` (
  `est_id` int(11) NOT NULL,
  `est_estado` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vtjt_estado`
--

INSERT INTO `vtjt_estado` (`est_id`, `est_estado`) VALUES
(1, 'activo'),
(2, 'inactivo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vtjt_evento`
--

CREATE TABLE `vtjt_evento` (
  `eve_id` int(11) NOT NULL,
  `eve_nombre` varchar(50) NOT NULL,
  `eve_fechaCreacion` date NOT NULL,
  `eve_fechaRealizacion` date NOT NULL,
  `eve_descripcion` varchar(200) NOT NULL,
  `eve_estado` int(11) NOT NULL,
  `eve_ciudad_id` int(11) NOT NULL,
  `eve_usuario_cargo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vtjt_evento`
--

INSERT INTO `vtjt_evento` (`eve_id`, `eve_nombre`, `eve_fechaCreacion`, `eve_fechaRealizacion`, `eve_descripcion`, `eve_estado`, `eve_ciudad_id`, `eve_usuario_cargo`) VALUES
(1, 'Evento1', '2023-01-01', '2023-02-01', 'Descripción evento 1', 1, 1, '123456789'),
(2, 'Evento2', '2023-02-01', '2023-03-01', 'Descripción evento 2', 1, 2, '123456789'),
(3, 'Evento3', '2023-03-01', '2023-04-01', 'Descripción evento 3', 1, 3, '987654321'),
(4, 'Evento4', '2023-04-01', '2023-05-01', 'Descripción evento 4', 1, 4, '987654321'),
(5, 'Evento5', '2023-05-01', '2023-06-01', 'Descripción evento 5', 1, 5, '555666777');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vtjt_usuario`
--

CREATE TABLE `vtjt_usuario` (
  `usu_rut` varchar(10) NOT NULL,
  `usu_nombre` varchar(30) NOT NULL,
  `usu_contrasena` varchar(50) NOT NULL CHECK (char_length(`usu_contrasena`) between 8 and 16),
  `usu_tipo` varchar(15) NOT NULL DEFAULT 'administrador' CHECK (`usu_tipo` in ('usuario','administrador')),
  `usu_estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vtjt_usuario`
--

INSERT INTO `vtjt_usuario` (`usu_rut`, `usu_nombre`, `usu_contrasena`, `usu_tipo`, `usu_estado`) VALUES
('111223344', 'User2', 'user45633333', 'usuario', 1),
('123456789', 'Admin1', 'admin1233333', 'administrador', 1),
('20170977', 'vicente', '12345678', 'administrador', 1),
('555666777', 'User3', 'user7893333', 'usuario', 1),
('987654321', 'User1', 'user12333333', 'usuario', 1),
('999000111', 'Admin2', 'contrasena', 'administrador', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `vtjt_atleta`
--
ALTER TABLE `vtjt_atleta`
  ADD PRIMARY KEY (`atl_rut`),
  ADD KEY `atleta_estado_fk` (`atl_estado`),
  ADD KEY `atleta_especialidad_fk` (`atl_especialidad`),
  ADD KEY `atleta_ciudad_fk` (`atl_ciudad_id`);

--
-- Indices de la tabla `vtjt_ciudad`
--
ALTER TABLE `vtjt_ciudad`
  ADD PRIMARY KEY (`ciu_id`),
  ADD UNIQUE KEY `ciu_ciudad_origen` (`ciu_ciudad_origen`);

--
-- Indices de la tabla `vtjt_detalle_evento`
--
ALTER TABLE `vtjt_detalle_evento`
  ADD PRIMARY KEY (`dee_id`),
  ADD KEY `detalle_evento_fk` (`dee_evento_id`),
  ADD KEY `detalle_atleta_fk` (`dee_atleta_rut`);

--
-- Indices de la tabla `vtjt_especialidad`
--
ALTER TABLE `vtjt_especialidad`
  ADD PRIMARY KEY (`esp_id`),
  ADD UNIQUE KEY `esp_especialidad_atleta` (`esp_especialidad_atleta`);

--
-- Indices de la tabla `vtjt_estado`
--
ALTER TABLE `vtjt_estado`
  ADD PRIMARY KEY (`est_id`),
  ADD UNIQUE KEY `est_estado` (`est_estado`);

--
-- Indices de la tabla `vtjt_evento`
--
ALTER TABLE `vtjt_evento`
  ADD PRIMARY KEY (`eve_id`),
  ADD KEY `evento_estado_fk` (`eve_estado`),
  ADD KEY `evento_ciudad_fk` (`eve_ciudad_id`),
  ADD KEY `evento_usuario_fk` (`eve_usuario_cargo`);

--
-- Indices de la tabla `vtjt_usuario`
--
ALTER TABLE `vtjt_usuario`
  ADD PRIMARY KEY (`usu_rut`),
  ADD KEY `usuario_estado_fk` (`usu_estado`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `vtjt_ciudad`
--
ALTER TABLE `vtjt_ciudad`
  MODIFY `ciu_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `vtjt_detalle_evento`
--
ALTER TABLE `vtjt_detalle_evento`
  MODIFY `dee_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `vtjt_especialidad`
--
ALTER TABLE `vtjt_especialidad`
  MODIFY `esp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `vtjt_estado`
--
ALTER TABLE `vtjt_estado`
  MODIFY `est_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `vtjt_evento`
--
ALTER TABLE `vtjt_evento`
  MODIFY `eve_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `vtjt_atleta`
--
ALTER TABLE `vtjt_atleta`
  ADD CONSTRAINT `atleta_ciudad_fk` FOREIGN KEY (`atl_ciudad_id`) REFERENCES `vtjt_ciudad` (`ciu_id`),
  ADD CONSTRAINT `atleta_especialidad_fk` FOREIGN KEY (`atl_especialidad`) REFERENCES `vtjt_especialidad` (`esp_id`),
  ADD CONSTRAINT `atleta_estado_fk` FOREIGN KEY (`atl_estado`) REFERENCES `vtjt_estado` (`est_id`);

--
-- Filtros para la tabla `vtjt_detalle_evento`
--
ALTER TABLE `vtjt_detalle_evento`
  ADD CONSTRAINT `detalle_atleta_fk` FOREIGN KEY (`dee_atleta_rut`) REFERENCES `vtjt_atleta` (`atl_rut`),
  ADD CONSTRAINT `detalle_evento_fk` FOREIGN KEY (`dee_evento_id`) REFERENCES `vtjt_evento` (`eve_id`);

--
-- Filtros para la tabla `vtjt_evento`
--
ALTER TABLE `vtjt_evento`
  ADD CONSTRAINT `evento_ciudad_fk` FOREIGN KEY (`eve_ciudad_id`) REFERENCES `vtjt_ciudad` (`ciu_id`),
  ADD CONSTRAINT `evento_estado_fk` FOREIGN KEY (`eve_estado`) REFERENCES `vtjt_estado` (`est_id`),
  ADD CONSTRAINT `evento_usuario_fk` FOREIGN KEY (`eve_usuario_cargo`) REFERENCES `vtjt_usuario` (`usu_rut`);

--
-- Filtros para la tabla `vtjt_usuario`
--
ALTER TABLE `vtjt_usuario`
  ADD CONSTRAINT `usuario_estado_fk` FOREIGN KEY (`usu_estado`) REFERENCES `vtjt_estado` (`est_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
