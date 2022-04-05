USE noticias;

CREATE TABLE IF NOT EXISTS Personal(
    id_personal INT NOT NULL AUTO_INCREMENT,
    ape_paterno VARCHAR(100) NOT NULL,
    ape_materno VARCHAR(100) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    fecha_ingreso DATE NOT NULL,
    PRIMARY KEY(id_personal)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Usuario(
    id_usuario INT NOT NULL AUTO_INCREMENT,
    nombre_usuario VARCHAR(10) NOT NULL,
    contrasena VARCHAR(8) NOT NULL,
    foto LONGBLOB NOT NULL,
    id_personal INT NOT NULL,
    PRIMARY KEY(id_usuario),
    FOREIGN KEY (id_personal) REFERENCES Personal(id_personal)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Nota(
    id_nota INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(30) NOT NULL,
    contenido VARCHAR(100) NOT NULL,
    fecha_nota DATETIME NOT NULL,
    id_usuario INT NOT NULL,
    PRIMARY KEY(id_nota),
    FOREIGN KEY(id_usuario) REFERENCES Usuario(id_usuario)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Comentario(
    id_comentario INT NOT NULL AUTO_INCREMENT,
    contenido VARCHAR(100) NOT NULL,
    fecha_com DATETIME NOT NULL,
    id_nota INT NOT NULL,
    id_usuario INT NOT NULL,
    PRIMARY KEY(id_comentario),
    FOREIGN KEY(id_nota) REFERENCES Nota(id_nota),
    FOREIGN KEY(id_usuario) REFERENCES Usuario(id_usuario)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Respuesta(
    id_respuesta INT NOT NULL AUTO_INCREMENT,
    contenido VARCHAR(100) NOT NULL,
    fecha_res DATETIME NOT NULL,
    id_comentario INT NOT NULL,
    id_usuario INT NOT NULL,
    PRIMARY KEY(id_respuesta),
    FOREIGN KEY(id_comentario) REFERENCES Comentario(id_comentario),
    FOREIGN KEY(id_usuario) REFERENCES Usuario(id_usuario)
) ENGINE = InnoDB;

INSERT INTO `personal` (
        `id_personal`,
        `ape_paterno`,
        `ape_materno`,
        `nombre`,
        `direccion`,
        `fecha_ingreso`
    )
VALUES
    (
        'Ibarra',
        'Hernandez',
        'Daniel',
        'Direccion generica #1 col. Colonia #1',
        '2022-03-12'
    ),
    (
        'Juarez',
        'Perez',
        'Juan',
        'Direccion generica #2 col. Colonia #2',
        '2013-04-02'
    ),
    (
        'Gomez',
        'Hernandez',
        'Maria',
        'Direccion generica #3 col. Colonia #3',
        '2011-03-02'
    ),
    (
        'Jimenez',
        'Lopez',
        'Humberto',
        'Direccion generica #4 col. Colonia #4',
        '2012-04-02'
    ),
    (
        'Nuñez',
        'Gomez',
        'Luis',
        'Direccion generica #5 col. Colonia #5',
        '2001-11-22'
    ),
    (
        'Mercado',
        'Juarez',
        'Jaime',
        'Direccion generica #6 col. Colonia #6',
        '2001-02-13'
    ),
    (
        'Juarez',
        'Ibarra',
        'Carlos',
        'Direccion generica #7 col. Colonia #7',
        '2011-05-07'
    ),
    (
        'Gutierrez',
        'Restrepo',
        'Ivan',
        'Direccion generica #8 col. Colonia #8',
        '2013-07-09'
    ),
    (
        'Patiño',
        'Escartini',
        'Federico',
        'Direccion generica #9 col. Colonia #9',
        '2013-01-23'
    )