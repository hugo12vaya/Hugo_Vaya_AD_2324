-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS Biblioteca;
USE Biblioteca;

-- Crear la tabla Autor
CREATE TABLE IF NOT EXISTS Autor (
    AutorID INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50) NOT NULL,
    Nacionalidad VARCHAR(50)
);

-- Crear la tabla Editorial
CREATE TABLE IF NOT EXISTS Editorial (
    EditorialID INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50) NOT NULL,
    Direccion VARCHAR(100)
);

-- Crear la tabla Libro con relación 1-1 con Autor
CREATE TABLE IF NOT EXISTS Libro (
    LibroID INT PRIMARY KEY AUTO_INCREMENT,
    Titulo VARCHAR(100) NOT NULL,
    ISBN VARCHAR(13) UNIQUE,
    AutorID INT,
    FOREIGN KEY (AutorID) REFERENCES Autor(AutorID)
);

-- Crear la tabla Libro con relación 1-M con Editorial
CREATE TABLE IF NOT EXISTS Libro (
    LibroID INT PRIMARY KEY AUTO_INCREMENT,
    Titulo VARCHAR(100) NOT NULL,
    ISBN VARCHAR(13) UNIQUE,
    AutorID INT,
    EditorialID INT,
    FOREIGN KEY (AutorID) REFERENCES Autor(AutorID),
    FOREIGN KEY (EditorialID) REFERENCES Editorial(EditorialID)
);

-- Crear la tabla de relación N:M entre Libro y Autor (ya existe la tabla Libro)
CREATE TABLE IF NOT EXISTS LibroAutor (
    LibroID INT,
    AutorID INT,
    PRIMARY KEY (LibroID, AutorID),
    FOREIGN KEY (LibroID) REFERENCES Libro(LibroID),
    FOREIGN KEY (AutorID) REFERENCES Autor(AutorID)
);

