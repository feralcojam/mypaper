create database mypaper;
use mypaper;
create table USUARIO (
	ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NOMBRE TEXT NOT NULL,
    CONTRASEÑA TEXT NOT NULL,
    ACTIVO TINYINT(1) NOT NULL
);
CREATE TABLE PRODUCTO (
	ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NOMBRE TEXT NOT NULL,
    ID_PROVEEDOR INT NOT NULL,
    CANTIDAD INT NOT NULL,
    PRECIO DOUBLE NOT NULL
);
CREATE TABLE PROVEEDOR (
	ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NOMBRE TEXT NOT NULL,
    MARCA TEXT NOT NULL,
    UBICACION TEXT NOT NULL
);
CREATE TABLE HISTORIAL_PRODUCTO (
	ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ID_PRODUCTO INT NOT NULL,
    ID_USUARIO INT NOT NULL,
    OPERACION TEXT NOT NULL,
    FECHA TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE VENTA (
	ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ID_PRODUCTO INT NOT NULL,
    ID_USUARIO INT NOT NULL,
    CANTIDAD INT NOT NULL,
    TOTAL DOUBLE NOT NULL,
    FECHA TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

/*Informacion de los proveedores*/
-- Insertar datos en la tabla PROVEEDOR con ubicaciones más realistas
INSERT INTO PROVEEDOR (NOMBRE, MARCA, UBICACION) VALUES
('PapelCo', 'Papelera Uno', 'Buenos Aires, Argentina'),
('Popular', 'PMat', 'Ciudad de México, México'),
('OfficeMateria', 'Office Materiales', 'Madrid, España'),
('EcoPapel', 'Eco Papel', 'São Paulo, Brasil'),
('SuministrosPlus', 'Suministros+', 'Lima, Perú');

/*iNFORMACION DE PRODUCTO*/
-- Insertar datos adicionales en la tabla PRODUCTO (con precios más altos)
INSERT INTO PRODUCTO (NOMBRE, ID_PROVEEDOR, CANTIDAD, PRECIO) VALUES
('Notas Adhesivas Grandes (50)', 3, 80, 8.99),
('Cajas de Archivo Premium', 1, 40, 49.99),
('Calculadora Científica Avanzada', 2, 25, 199.99),
('Papel para Impresora de Alta Calidad (500 hojas)', 4, 100, 34.99),
('Marcadores de Pizarra (Paquete de 12)', 5, 60, 22.99),
('Cinta Adhesiva Doble Faz (5 Rollos)', 1, 50, 17.99),
('Almohadillas de Tinta para Sello (Paquete de 3)', 3, 30, 12.99),
('Clips Metálicos Extra Resistentes (Paquete de 100)', 2, 120, 9.99),
('Agendas Ejecutivas 2023', 4, 35, 29.99),
('Borradores de Pizarra (Paquete de 4)', 5, 40, 40.99),
('Rotuladores Permanentes (Pack de 8)', 1, 75, 49.99),
('Papel de Carta de Lujo (100 hojas)', 2, 60, 29.99),
('Reglas de Plástico Duradero (Paquete de 5)', 3, 45, 10.99),
('Tinta para Impresora de Alta Capacidad (Botella)', 4, 20, 499.99),
('Clasificadores de Documentos (Juego de 3)', 5, 25, 32.99),
('Resaltadores de Texto (Paquete de 6)', 1, 55, 16.99),
('Pegamento en Barra No Tóxico (Paquete de 10)', 2, 80, 7.99),
('Papel para Dibujo Artístico (Bloc de 50 hojas)', 3, 30, 26.99),
('Estuches de Plástico para Documentos (Paquete de 6)', 4, 40, 21.99),
('Lápices de Colores de Alta Calidad (Juego de 24)', 5, 70, 23.99),
('Afiladores de Lápices Eléctricos (Paquete de 2)', 1, 15, 38.99),
('Clasificadores de Documentos Expansibles', 2, 20, 49.99),
('Bolsas Resellables para Documentos (Paquete de 50)', 3, 90, 5.99),
('Grapadora de Alta Resistencia', 4, 10, 31.99),
('Libretas de Notas Premium (Juego de 3)', 5, 45, 18.99),
('Tablones de Corcho (Paquete de 2)', 1, 25, 27.99),
('Paquete Variado de Sobres (25 Sobres)', 2, 50, 13.99),
('Carpetas de Presentación Profesional (Juego de 10)', 3, 70, 45.99),
('Cintas Correctoras de Alta Precisión (Paquete de 5)', 4, 35, 9.99);

/*insertar usuario*/
INSERT INTO USUARIO VALUES (0,"JESUS","DANIEL",0), (0,"JESUS","ALBERTO",0);

 /*Procedimiento almacenado para activar un usuario y desactivar otros*/
DELIMITER //

CREATE PROCEDURE ACTIVAR_USUARIO(IN ID_USUARIO INT)
BEGIN
    UPDATE USUARIO SET ACTIVO = 1 WHERE ID = ID_USUARIO;
    UPDATE USUARIO SET ACTIVO = 0 WHERE NOT ID = ID_USUARIO;
END //

DELIMITER ;

/*Procedimiento de buscar un usuario*/
DELIMITER //

CREATE PROCEDURE Buscar_Usuario(IN nombre_usuario text, IN contrasena_usuario text)
BEGIN
    SELECT * FROM USUARIO WHERE NOMBRE = nombre_usuario AND CONTRASEÑA = contrasena_usuario;
END //

DELIMITER ;

/*Trigger para saber quien inserta un elemento*/
drop trigger TRIGGER_INSERTAR;
DELIMITER //
CREATE TRIGGER TRIGGER_INSERTAR
AFTER INSERT ON PRODUCTO
FOR EACH ROW
BEGIN
	DECLARE ID_USUARIO INT;
    SELECT ID INTO ID_USUARIO FROM USUARIO WHERE ACTIVO = 1;
    INSERT INTO HISTORIAL_PRODUCTO (ID_PRODUCTO ,ID_USUARIO,OPERACION)VALUES (NEW.ID,ID_USUARIO,'INSERCIÓN');
END //
DELIMITER ;

/*Trigger despues de actualizar*/
DELIMITER //

CREATE TRIGGER TRIGGER_ACTUALIZAR
AFTER UPDATE ON PRODUCTO
FOR EACH ROW
BEGIN
    DECLARE ID_USUARIO INT;
    SELECT ID INTO ID_USUARIO FROM USUARIO WHERE ACTIVO = 1;
    INSERT INTO HISTORIAL_PRODUCTO (ID_PRODUCTO ,ID_USUARIO,OPERACION) VALUES (NEW.ID, ID_USUARIO, 'ACTUALIZACIÓN');
END //

DELIMITER ;

/*trigger de eliminacion*/
DELIMITER //

CREATE TRIGGER TRIGGER_ELIMINAR
AFTER DELETE ON PRODUCTO
FOR EACH ROW
BEGIN
    DECLARE ID_USUARIO INT;
    SELECT ID INTO ID_USUARIO FROM USUARIO WHERE ACTIVO = 1;
    INSERT INTO HISTORIAL_PRODUCTO (ID_PRODUCTO ,ID_USUARIO,OPERACION) VALUES (OLD.ID, ID_USUARIO, 'ELIMINACIÓN');
END //

DELIMITER ;
/*Parte 2 en proceso*/