CREATE DATABASE SALMENTAK;

CREATE TABLE PRODUCTO
(	ID_PRODUCTO INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	IZENA VARCHAR(45) NULL,
	KOPURUA INT NULL,
    PISUA DECIMAL NULL,
    PREZIOA DECIMAL NULL
);

CREATE TABLE DENDA
(	ID_DENDA INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	IZENA VARCHAR(45)
);

CREATE TABLE LANGILEA
(	ID_LANGILEA INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	IZENA VARCHAR(45) NULL,
    ABIZENA VARCHAR(45) NULL,
    ID_PRODUCTO INT,
	FOREIGN KEY (ID_PRODUCTO)
	REFERENCES PRODUCTO(ID_PRODUCTO),
    ID_DENDA INT,
    FOREIGN KEY (ID_DENDA)
    REFERENCES DENDA(ID_DENDA)
);

CREATE TABLE TICKET
(	ID_TICKET INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	NOIZ_ATERA_DA DATE NULL,
    KOPURUA INT NULL,
    PISUA DECIMAL NULL,
    PREZIOA DECIMAL NULL,
    ID_LANGILEA INT,
    FOREIGN KEY (ID_LANGILEA)
    REFERENCES LANGILEA(ID_LANGILEA),
    ID_DENDA INT,
    FOREIGN KEY (ID_DENDA)
    REFERENCES DENDA(ID_DENDA)
);

