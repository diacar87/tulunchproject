-- --------------------------------------------------------

--
-- Base de datos: `tulunch`
--
DROP DATABASE IF EXISTS `tulunch`;
CREATE DATABASE `tulunch` ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--
DROP TABLE IF EXISTS `tulunch`.`empleado`;
CREATE TABLE  `tulunch`.`empleado`
(
    `id`        int(3)       NOT NULL auto_increment,
    `nombre`    varchar(50)  NOT NULL,
    `password`  varchar(32)  NOT NULL,
    `cargo`     char(13)     NOT NULL,
    `telefono`  char(7)      default NULL,
    `celular`   char(10)     default NULL,

    PRIMARY KEY  (`id`)
)
ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_spanish_ci;
--
-- Volcar la base de datos para la tabla `empleado`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--
DROP TABLE IF EXISTS `tulunch`.`producto`;
CREATE TABLE  `tulunch`.`producto`
(
    `id`         int(3)        NOT NULL auto_increment,
    `precio`     double        NOT NULL,
    `tipo`       varchar(30)   NOT NULL,
    `nombre`     varchar(50)   NOT NULL,
    `estaEnMenu` tinyint(1)    NOT NULL default '1',
    `eliminado`  tinyint(1)    NOT NULL default '0',

    PRIMARY KEY  (`id`)
)
ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_spanish_ci;
--
-- Volcar la base de datos para la tabla `producto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--
DROP TABLE IF EXISTS `tulunch`.`pedido`;
CREATE TABLE  `tulunch`.`pedido`
(
    `id`          int(3)       NOT NULL auto_increment,
    `mesa`        int(3)       NOT NULL,
    `enCurso`     tinyint(1)   NOT NULL default '1',
    `fecha`       varchar(10)  NOT NULL,
    `empleado`    int(3)       default NULL,

    PRIMARY KEY  (`id`),
    KEY `FK_pedido_empleado` (`empleado`),
    CONSTRAINT `FK_pedido_empleado` FOREIGN KEY (`empleado`) REFERENCES `empleado` (`id`)
)
ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_spanish_ci;
--
-- Volcar la base de datos para la tabla `pedido`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido_producto`
--
DROP TABLE IF EXISTS `tulunch`.`pedido_producto`;
CREATE TABLE  `tulunch`.`pedido_producto`
(
    `pedido`     int(3) NOT NULL,
    `producto`   int(3) NOT NULL,

    CONSTRAINT `FK_pedido_producto_pedido` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`id`),
    CONSTRAINT `FK_pedido_producto_productos` FOREIGN KEY (`producto`) REFERENCES `producto` (`id`)
)
ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_spanish_ci;
--
-- Volcar la base de datos para la tabla `pedido_producto`
--