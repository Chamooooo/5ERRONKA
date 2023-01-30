CREATE DATABASE SALMENTAK;

CREATE TABLE PRODUCTO 
(	ID_PRODUCTO INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	IZENA VARCHAR(45),
	KOPURUA INT,
    PISUA DECIMAL,
    PREZIOA DECIMAL 
);

CREATE TABLE DENDA
(	ID_DENDA INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	IZENA VARCHAR(45)
);

CREATE TABLE LANGILEA
(	ID_LANGILEA INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	IZENA VARCHAR(45),
    ABIZENA VARCHAR(45),
    ID_PRODUCTO INT,
	FOREIGN KEY (ID_PRODUCTO)
	REFERENCES PRODUCTO(ID_PRODUCTO),
    ID_DENDA INT,
    FOREIGN KEY (ID_DENDA)
    REFERENCES DENDA(ID_DENDA)
);

CREATE TABLE TICKET
(	ID_TICKET INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	IZENA VARCHAR(45),
	NOIZ_ATERA_DA DATE,
    ORDUA TIME,
    PISUA DECIMAL,
    PREZIOA_KILOKO DECIMAL,
    PREZIO_TOTALA DECIMAL,
    ID_LANGILEA INT,
    FOREIGN KEY (ID_LANGILEA)
    REFERENCES LANGILEA(ID_LANGILEA),
    ID_DENDA INT,
    FOREIGN KEY (ID_DENDA)
    REFERENCES DENDA(ID_DENDA)
);