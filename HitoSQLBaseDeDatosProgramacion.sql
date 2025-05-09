DROP DATABASE IF EXISTS cine_mariosanz;
CREATE DATABASE IF NOT EXISTS cine_mariosanz;
USE cine_mariosanz;

DROP TABLE IF EXISTS peliculas;
DROP TABLE IF EXISTS directores;

CREATE TABLE IF NOT EXISTS directores (
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    nacionalidad VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS peliculas (
    codigo VARCHAR(10) PRIMARY KEY,
    titulo VARCHAR(100),
    genero VARCHAR(50),
    duracion INT,
    clasificacion VARCHAR(10),
    id_director INT,
    FOREIGN KEY (id_director) REFERENCES directores(id)
);

-- Datos de prueba
INSERT IGNORE INTO directores VALUES 
(1, 'Christopher Nolan', 'Británica'), 
(2, 'Greta Gerwig', 'Estadounidense'),
(3, 'Chad Stahelski', 'Estadounidense');

INSERT IGNORE INTO peliculas VALUES 
('P001', 'Oppenheimer', 'Drama', 180, '18', 1),
('P002', 'Barbie', 'Comedia', 110, 'PG-13', 2);

SELECT * FROM peliculas;
SELECT * FROM directores;
