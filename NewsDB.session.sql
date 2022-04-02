USE noticias;

CREATE TABLE IF NOT EXISTS Usuario(
    id_usuario INT NOT NULL AUTO_INCREMENT,
    nombre_usuario VARCHAR(10) NOT NULL,
    contrasena VARCHAR(8) NOT NULL,
    foto LONGBLOB NOT NULL,
    PRIMARY KEY(id_usuario)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Personal(
    id_personal INT NOT NULL AUTO_INCREMENT,
    ape_paterno VARCHAR(100) NOT NULL,
    ape_materno VARCHAR(100) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    fecha_ingreso DATE NOT NULL,
    id_usuario INT NOT NULL,
    PRIMARY KEY(id_personal),
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Empleado(
    id_empleado INT NOT NULL AUTO_INCREMENT,
    id_usuario INT NOT NULL,
    PRIMARY KEY(id_empleado),
    FOREIGN KEY(id_usuario) REFERENCES Usuario(id_usuario)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS Externo(
    id_externo INT NOT NULL AUTO_INCREMENT,
    id_usuario INT NOT NULL,
    PRIMARY KEY(id_externo),
    FOREIGN KEY(id_usuario) REFERENCES Usuario(id_usuario)
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