INSERT INTO `tulunch`.`Producto` (`nombre` ,`tipo` ,`precio`, `estaEnMenu`, `eliminado`) VALUES
	
	-- BEBIDAS
	('Avena', 'Bebida', 2000, 1, 0),
	('Chicha', 'Bebida', 2000, 1, 0),
	('Guarapo',	'Bebida', 2000, 1, 0),
	('Jugo de Mandarina', 'Bebida', 1500, 1, 0),
	('Jugo de Mango', 'Bebida', 1500, 0, 0),
	('Jugo de Mora', 'Bebida', 1500, 0, 0),
	('Jugo de Piña', 'Bebida', 1500, 0, 0),
	('Limonada','Bebida', 1500, 1, 1),
	('Masato','Bebida', 2000, 1, 0),
	('Ponche','Bebida', 1000, 0, 0),
	('Sabajón','Bebida', 1500, 0, 0),
	('Salpicon','Bebida', 2000, 0, 0),
	('Sorbete de Borojo','Bebida', 2000, 1, 1),
	('Sorbete de Curuba','Bebida', 2000, 0, 0),
	('Sorbete de Guanabana','Bebida', 2000, 1, 0),
	('Sorbete de Mora','Bebida', 2000, 1, 0),
	('Vino Blanco','Bebida', 3000, 1, 0),
	('Vino Tinto','Bebida', 3000, 1, 1),
	
	-- SOPAS
	('Ajiaco', 'Sopa', 1500, 1, 0),
	('Cazuela de Mariscos', 'Sopa', 2000, 1, 0),
	('Crema de Cebolla', 'Sopa', 1000, 0, 0),
	('Crema de Mazorca', 'Sopa', 1500, 1, 0),
	('Crema de Tomate', 'Sopa', 1500, 0, 0),
	('Crema de Champiñones', 'Sopa', 2000, 1, 0),
	('Cuchuco de Trigo', 'Sopa', 1500, 1, 0),
	('Sancocho de Costilla', 'Sopa', 1500, 1, 0),
	('Sancocho de Pollo', 'Sopa', 2000, 0, 1),
	('Mazamorra', 'Sopa', 2000, 1, 0),
	('Mondongo', 'Sopa', 2000, 1, 1),
	('Sancocho de Gallina', 'Sopa', 2000, 1, 0),
	('Sancocho de Pescado', 'Sopa', 2000, 0, 0),
	('Sopa Arroz', 'Sopa', 1500, 0, 0),
	('Sopa de Mute', 'Sopa', 1500, 1, 1),
	('Sopa de Pasta', 'Sopa', 1500, 0, 0),
	('Sopa de Plátano', 'Sopa', 2000, 1, 0),
	('Sopa de Verduras', 'Sopa', 1500, 0, 0),

	-- PLATOS FUERTES
	('Albóndigas de Pollo', 'Plato Fuerte', 2000, 1, 0),
	('Albóndigas de Pescado', 'Plato Fuerte', 2000, 1, 1),
	('Albóndigas de Carne', 'Plato Fuerte', 2000, 1, 0),
	('Arroz Atollado', 'Plato Fuerte', 2000, 1, 0),
	('Arroz con Camarones', 'Plato Fuerte', 2000, 1, 0),
	('Arroz a la Marinera', 'Plato Fuerte', 2000, 0, 0),
	('Arroz con Pollo', 'Plato Fuerte', 2000, 0, 0),
	('Bagre Apanado', 'Plato Fuerte', 10000, 1, 1),
	('Bagre Sudado', 'Plato Fuerte', 10000, 1, 0),
	('Bagre Frito', 'Plato Fuerte', 10000, 0, 0),
	('Bandeja Paisa', 'Plato Fuerte', 5000, 0, 0),
	('Bistec a la Criolla', 'Plato Fuerte', 4000, 1, 0),
	('Costillitas de Cerdo', 'Plato Fuerte', 10000, 1, 0),
	('Chuletas de Cerdo', 'Plato Fuerte', 10000, 0, 1),
	('Espaguetis', 'Plato Fuerte', 3000, 1, 0),
	('Frijoles Rancheros', 'Plato Fuerte', 3000, 1, 0),
	('Filete de Pescado', 'Plato Fuerte', 12000, 1, 0),
	('Lengua en Salsa', 'Plato Fuerte', 5000, 0, 1),
	('Hígado', 'Plato Fuerte', 5000, 1, 0),
	('Macarrones con Pollo', 'Plato Fuerte', 2000, 1, 1),
	('Mojarra (Apanada, Sudada, Frita)', 'Plato Fuerte', 10000, 1, 0),
	('Sobrebarriga al Horno', 'Plato Fuerte', 10000, 0, 0),
	('Viudo de Capaz', 'Plato Fuerte', 10000, 1, 0),
	
	-- ENSALADAS
	('Ensalada de Frutas', 'Ensalada', 5000, 0, 0),
	('Ensalada de Espinacas', 'Ensalada', 3000, 0, 1),
	('Ensalada de Pepino, Rabano, Lechuga y Repollo', 'Ensalada', 1500, 1, 0),
	('Ensalada de Remolacha y Zanahoria', 'Ensalada', 1500, 0, 0),
	('Ensalada de Atún', 'Ensalada', 3000, 0, 0),
	('Ensalada de Carnes Frias', 'Ensalada',  7000, 1, 1), 
	('Ensalada de Pollo', 'Ensalada', 5000, 1, 1),
	('Ensalada Rusa', 'Ensalada',  4000, 1, 0),
	('Ensalada Agridulce', 'Ensalada',  3000, 0, 1),
	('Ensalada de Verduras', 'Ensalada',  4000, 1, 0),
	
	-- ACOMPAÑAMIENTOS
	('Arroz Blanco', 'Acompañamiento', 1000, 1, 0),
	('Arroz con Coco', 'Acompañamiento', 1500, 0, 0),
	('Arroz con Coco y Pasas', 'Acompañamiento', 2000, 1, 0),
	('Arroz con Queso', 'Acompañamiento', 1500, 0, 1),
	('Torta de Maíz', 'Acompañamiento', 1000, 1, 0),
	('Torta de Maduro', 'Acompañamiento', 1000, 0, 0),
	('Torta de Queso', 'Acompañamiento', 1000, 1, 1),
	('Torta de Yuca', 'Acompañamiento', 1000, 1, 0),
	('Torta de Zanahoria', 'Acompañamiento', 1000, 1, 1),
	('Torta de Verduras', 'Acompañamiento', 1000, 1, 0),
	('Papa (Salada, Pure, Francesa,Cocida)', 'Acompañamiento', 100, 1, 0),
	('Yuca (Frita, Cocida)', 'Acompañamiento', 100, 1, 0),
	('Maduro (Patacón, Tajadas)', 'Acompañamiento', 1000, 1, 0),
	
	-- POSTRES
	('Arroz con Leche', 'Postre', 1000, 1, 0),
	('Bocadillo Veleño con Queso', 'Postre', 1000, 1, 0),
	('Brevas con Arequipe', 'Postre', 1000, 1, 1),
	('Cocadas', 'Postre', 1000, 1, 0),
	('Dulce de Mora', 'Postre', 1000, 1, 0),
	('Fresas en Almíbar', 'Postre', 1000, 0, 0),
	('Fresas con Cremas', 'Postre', 1000, 1, 1),
	('Dulce de Melocotón', 'Postre', 1000, 0, 0),
	('Esponjado de Curuba', 'Postre', 1000, 0, 1),
	('Flan de Mango', 'Postre', 1000, 1, 0),
	('Gelatina de Frutas', 'Postre', 1000, 0, 1),
	('Manjar Blanco', 'Postre', 1000, 1, 0),
	('Postre de Natas', 'Postre', 1000, 0, 1),
	('Postre de Leche Asada', 'Postre', 1000, 0, 1),
	('Postre de tres Leches', 'Postre', 1000, 1, 0);

INSERT INTO `tulunch`.`empleado` (`nombre`, `password`, `cargo`, `telefono`, `celular`) VALUES

	-- Clave: 1265 
	('Alberto Perez', 'ce2ffd21fc958d9efee9ba5336e357', 'Mesero', '8143894', '3125631254'),
	-- Clave: 1245
	('Jorge Camacho', '5eac43aceba42c8757b5403a58277b5', 'Mesero', '2143874', '3102561216'),
	-- Clave: 8456
	('Carlos Quiroga', '706bf9581a8f1747195e5c19835a9bc', 'Mesero', '3173888', '3151232726'),
	-- Clave: 4659
	('Roberto Medina','868554965016d9e1d14bf97226245b', 'Mesero', '7143671', '3131123573'),
	-- Clave:  1532
	('Marisol Cristancho','8483789cdf46631a10aca5258e16', 'Cocina', '3243791', '3011276155'),
	-- Clave: 4895
	('Javier Ramirez', 'f0837f171aae7ccf1a899b6a0cc3559', 'Cocina', '5246194', '3001221236'),
	-- Clave: 1789
	('Andrea Molina', 'ecd62de2ea67e1c2d933d311b8178a', 'Cocina', '5183854', '3161231957'),
	-- Clave: 1234
	('Jaime Pineda', '81dc9bdb52d04dc2036dbd8313ed055', 'Administrador', '3244594', '3112642156'),
	-- Clave: 8435
	('Julio Moreno', 'ad16fe8f92f051afbf656271afd7872d', 'Cajero', '3133894', '3002981456');

INSERT INTO `tulunch`.`pedido` (`mesa`, `fecha`, `empleado`, `enCurso`) VALUES

	(1, '10/02/2000', 1, 0),
	(11, '09/11/2005', 2, 0),
	(2, '15/04/2006', 3, 0),
	(10, '29/12/2007', 4, 0),
	(20, '13/04/2008', 3, 0),
	(5, '21/04/2008', 4, 0),
	(18, '21/04/2008', 3, 0),
	(9, '21/04/2008', 2, 1),
	(3, '21/04/2008', 1, 1);
	
INSERT INTO `tulunch`.`pedido_producto` (`pedido`, `producto`) VALUES

	(1, 40),
	(1, 40),
	(1, 12),
	(1, 36),
	(1, 5),
	(2, 26),
	(2, 35),
	(2, 38),
	(3, 90),
	(4, 45),
	(4, 45),
	(4, 68),
	(4, 23),
	(5, 10),
	(6, 12),
	(7, 1),
	(8, 12),
	(8, 50),
	(9, 90),
	(9, 31),
	(9, 11),
	(9, 58);