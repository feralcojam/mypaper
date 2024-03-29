create database BD_Papeleria;
use BD_Papeleria;
create table USUARIOS (
	ID INT PRIMARY KEY AUTO_INCREMENT,
    NOMBRES varchar(50) NOT NULL,
    APELLIDOS varchar(50) NOT NULL,
    NOMBRE_CREDENCIAL varchar(50) NOT NULL,
    CONTRASEÑA_CREDENCIAL TEXT NOT NULL,
    CARGO varchar(15) NOT NULL CHECK (CARGO IN ('Administrador', 'Vendedor')),
    ACTIVO TINYINT(1) NOT NULL
);
CREATE TABLE PROVEEDORES (
	ID_PROVEEDOR INT PRIMARY KEY AUTO_INCREMENT,
    NOMBRE varchar(50) NOT NULL,
    MARCA varchar(50) NOT NULL,
    UBICACION TEXT NOT NULL
);
CREATE TABLE PRODUCTOS (
	ID_PRODUCTO BIGINT PRIMARY KEY,
    NOMBRE varchar(50) NOT NULL,
    ID_PROVEEDOR INT NOT NULL,
    STOCK INT NOT NULL,
    PRECIO DOUBLE NOT NULL,
    FOREIGN KEY (ID_PROVEEDOR) REFERENCES PROVEEDORES (ID_PROVEEDOR)
);
CREATE TABLE VENTAS (
	ID_VENTA INT PRIMARY KEY AUTO_INCREMENT,
    ID_USUARIO INT NOT NULL,
    TOTAL DOUBLE NOT NULL,
    FECHA TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ID_USUARIO) REFERENCES USUARIOS(ID)
);
CREATE TABLE ESPECIFICACIONES_VENTAS (
	ID_VENTA INT NOT NULL,
    ID_PRODUCTO BIGINT NOT NULL,
    CANTIDAD DOUBLE NOT NULL,
    FOREIGN KEY (ID_VENTA) REFERENCES VENTAS(ID_VENTA),
    FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTOS(ID_PRODUCTO)
);
CREATE TABLE HISTORIAL_PRODUCTO (
	ID_ INT PRIMARY KEY AUTO_INCREMENT,
    ID_PRODUCTO BIGINT NOT NULL,
    ID_USUARIO INT NOT NULL,
    OPERACION varchar(50) NOT NULL CHECK (OPERACION IN ('INSERTAR', 'ACTUALIZAR', 'ELIMINAR')),
    FECHA TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

/*Insertar el usuario administrador*/
INSERT INTO USUARIOS (ID,NOMBRES,APELLIDOS,NOMBRE_CREDENCIAL,CONTRASEÑA_CREDENCIAL,CARGO,ACTIVO) 
VALUES (0,"Jesus Daniel","Mendoza Medina","Jesus","Daniel123","Administrador",0);

/*Insertar un proveedor inicial*/
INSERT INTO PROVEEDORES (ID_PROVEEDOR, NOMBRE, MARCA, UBICACION)
VALUES (0, "MAYORGA", "BARCEL", "EL MANTE, TAMAULIPAS");

 /*Procedimiento almacenado para activar un usuario y desactivar otros*/
DELIMITER //

CREATE PROCEDURE ACTIVAR_USUARIO(IN ID_USUARIO INT)
BEGIN
    UPDATE USUARIOS SET ACTIVO = 1 WHERE ID = ID_USUARIO;
    UPDATE USUARIOS SET ACTIVO = 0 WHERE NOT ID = ID_USUARIO;
END //

DELIMITER ;

/*Procedimiento de buscar un usuario*/
DELIMITER //

CREATE PROCEDURE Buscar_Usuario(IN nombre_usuario text, IN contrasena_usuario text)
BEGIN
    SELECT * FROM USUARIOS WHERE NOMBRE_CREDENCIAL = nombre_usuario AND CONTRASEÑA_CREDENCIAL = contrasena_usuario;
END //

DELIMITER ;

/*Procedimiento de buscar info general de un usuario*/
DELIMITER //

CREATE PROCEDURE INFO_GENERAL_USUARIO()
BEGIN
    SELECT * FROM USUARIOS;
END //

DELIMITER ;

/*Procedimiento de buscar info de un usuario especifico*/
DELIMITER //

CREATE PROCEDURE Buscar_Usuario_Especifico(IN NOMBRE VARCHAR(50))
BEGIN
    SELECT * FROM USUARIOS WHERE NOMBRES = NOMBRE;
END //

DELIMITER ;

 /*Procedimiento almacenanado para insertar un usuario*/
DELIMITER //

CREATE PROCEDURE INSERTAR_USUARIO(IN NOMBRES VARCHAR (50), IN APELLIDOS VARCHAR (50), IN NOMBRE_CREDENCIAL VARCHAR (50), CONTRASEÑA_CREDENCIAL VARCHAR (50)
	, IN CARGO VARCHAR (15), IN ACTIVO TINYINT(1))
BEGIN
	INSERT INTO USUARIOS (ID,NOMBRES,APELLIDOS,NOMBRE_CREDENCIAL,CONTRASEÑA_CREDENCIAL,CARGO,ACTIVO) 
VALUES (0,NOMBRES,APELLIDOS,NOMBRE_CREDENCIAL,CONTRASEÑA_CREDENCIAL,CARGO,ACTIVO);
END //

DELIMITER ;

/*Procedimiento almacenanado para actualizar un usuario*/
DELIMITER //

CREATE PROCEDURE ACTUALIZAR_USUARIO(IN ID_P INT, IN NOMBRES_P VARCHAR (50), IN APELLIDOS_P VARCHAR (50), IN NOMBRE_CREDENCIAL_P VARCHAR (50), CONTRASEÑA_CREDENCIAL_P VARCHAR (50)
	, IN CARGO_P VARCHAR (15))
BEGIN
	UPDATE USUARIOS  
    SET NOMBRES = NOMBRES_P,
    APELLIDOS = APELLIDOS_P,
    NOMBRE_CREDENCIAL = NOMBRE_CREDENCIAL_P,
    CONTRASEÑA_CREDENCIAL = CONTRASEÑA_CREDENCIAL_P,
    CARGO = CARGO_P 
    WHERE ID = ID_P;
END //

DELIMITER ;


/*Procedimiento almacenanado para borrar un usuario*/
DELIMITER //

CREATE PROCEDURE BORRAR_USUARIO(IN ID_P INT)
BEGIN
	DELETE FROM USUARIOS WHERE ID = ID_P;
END //

DELIMITER ;

/*Informacion general de los productos*/
DELIMITER //

CREATE PROCEDURE Info_general_inventario()
BEGIN
	SELECT PROD.ID_PRODUCTO, PROD.NOMBRE, PROV.MARCA, PROD.STOCK, PROD.PRECIO FROM PRODUCTOS AS PROD JOIN PROVEEDORES AS PROV ON PROD.ID_PROVEEDOR = PROV.ID_PROVEEDOR;
END //

DELIMITER ;

/*Informacion especifica de los productos*/
DELIMITER //

CREATE PROCEDURE Info_especifica_inventario(IN NOMBRE VARCHAR(50))
BEGIN
	SELECT PROD.ID_PRODUCTO, PROD.NOMBRE, PROV.MARCA, PROD.STOCK, PROD.PRECIO 
    FROM PRODUCTOS AS PROD JOIN PROVEEDORES AS PROV ON PROD.ID_PROVEEDOR = PROV.ID_PROVEEDOR
    WHERE PROD.NOMBRE = NOMBRE;
END //

DELIMITER ;

 /*Procedimiento almacenanado para insertar un Producto*/
 /*DROP PROCEDURE IF EXISTS INSERTAR_PRODUCTO;
 CALL INSERTAR_PRODUCTO (604722009619, "Enkanton SURTIMIX", "BARCEL", 10, 18)*/
DELIMITER //

CREATE PROCEDURE INSERTAR_PRODUCTO(IN ID_P BIGINT, IN NOMBRE_P VARCHAR (50), IN NOMBRE_PROV VARCHAR (50), IN CANTIDAD INT
	, IN PRECIO_P DOUBLE)
BEGIN
	DECLARE Id_Pro INT;
    SELECT ID_PROVEEDOR INTO Id_Pro FROM PROVEEDORES WHERE MARCA = NOMBRE_PROV Limit 1;
	INSERT INTO PRODUCTOS (ID_PRODUCTO, NOMBRE, ID_PROVEEDOR, STOCK, PRECIO) 
	VALUES (ID_P,NOMBRE_P,Id_Pro,CANTIDAD,PRECIO_P);
END //

DELIMITER ;


/*Procedimiento almacenanado para atualizar un Producto*/
DELIMITER //

CREATE PROCEDURE ACTUALIZAR_PRODUCTO(IN ID_P BIGINT, IN NOMBRE_P VARCHAR (50), IN NOMBRE_PROV VARCHAR (50), IN CANTIDAD INT
	, IN PRECIO_P DOUBLE)
BEGIN
	DECLARE Id_Pro INT;
    SELECT ID_PROVEEDOR INTO Id_Pro FROM PROVEEDORES WHERE MARCA = NOMBRE_PROV Limit 1;
    UPDATE PRODUCTOS 
    SET NOMBRE = NOMBRE_P,
    ID_PROVEEDOR = Id_Pro,
    STOCK = CANTIDAD,
    PRECIO = PRECIO_P
    WHERE ID_PRODUCTO = ID_P;
END //
DELIMITER ;

/*Procedimiento almacenanado para eliminar un Producto*/
DELIMITER //

CREATE PROCEDURE ELIMINAR_PRODUCTO(IN ID_P BIGINT)
BEGIN
	DELETE FROM PRODUCTOS
    WHERE ID_PRODUCTO = ID_P;
END //
DELIMITER ;

/*Procedimiento almacenanado para retirar cantidad de un Producto*/
DELIMITER //

CREATE PROCEDURE RETIRAR_CANTIDAD(IN ID_P BIGINT, IN CANTIDAD INT)
BEGIN
	UPDATE PRODUCTOS 
    SET STOCK = STOCK - CANTIDAD
    WHERE ID_PRODUCTO = ID_P;
END //
DELIMITER ;

/*Procedimiento almacenanado para regresar cantidad de un Producto*/
DELIMITER //

CREATE PROCEDURE REGRESAR_CANTIDAD(IN ID_P BIGINT, IN CANTIDAD INT)
BEGIN
	UPDATE PRODUCTOS 
    SET STOCK = STOCK + CANTIDAD
    WHERE ID_PRODUCTO = ID_P;
END //
DELIMITER ;


/*Procedimiento almacenanado para verificar la cantidad de un Producto*/
DELIMITER //

CREATE PROCEDURE VERIFICAR_CANTIDAD(IN ID_P BIGINT)
BEGIN
	SELECT STOCK FROM PRODUCTOS WHERE ID_PRODUCTO = ID_P;
END //
DELIMITER ;

/*Informacion de nombre y precio de los productos*/
DELIMITER //

CREATE PROCEDURE Info_especifica_producto(IN ID_P BIGINT)
BEGIN
	SELECT NOMBRE, PRECIO FROM PRODUCTOS WHERE ID_PRODUCTO = ID_P LIMIT 1;
END //

DELIMITER ;

/*Informacion de codigo apartir de un nombre*/
DELIMITER //

CREATE PROCEDURE Nombre_producto_codigo(IN NOMBRE_P VARCHAR(50))
BEGIN
	SELECT ID_PRODUCTO FROM PRODUCTOS WHERE NOMBRE =  NOMBRE_P LIMIT 1;
END //


/*Procedimiento almacenado de como insertar una venta*/
DELIMITER //

CREATE PROCEDURE REGISTRAR_VENTA(IN ID_U INT, IN TOTAL DOUBLE)
BEGIN
	INSERT INTO VENTAS (ID_USUARIO, TOTAL)
    VALUES (ID_U, TOTAL);
    SELECT LAST_INSERT_ID() AS UltimoID;
END //

DELIMITER ;

/*Procedimiento almacenado de como insertar un especificacion de venta*/
DELIMITER //
/*ESPECIFICACIONES_VENTAS*/
CREATE PROCEDURE REGISTRAR_ESPECIFICACIONES_VENTA(IN ID_V INT, IN ID_P BIGINT, IN CANTIDAD_P INT)
BEGIN
	INSERT INTO ESPECIFICACIONES_VENTAS (ID_VENTA, ID_PRODUCTO, CANTIDAD)
    VALUES (ID_V, ID_P, CANTIDAD_P);
END //

DELIMITER ;