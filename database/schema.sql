CREATE DATABASE IF NOT EXISTS mediturndb
  DEFAULT CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci;

USE mediturndb;

CREATE TABLE usuarios (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  apellido VARCHAR(100) NOT NULL,
  email VARCHAR(150) NOT NULL,
  password VARCHAR(255) NOT NULL,
  rol VARCHAR(20) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY email_UNIQUE (email)
);

CREATE TABLE especialidades (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  descripcion VARCHAR(255) NOT NULL,
  duracion_minutos INT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE pacientes (
  id INT NOT NULL AUTO_INCREMENT,
  dni VARCHAR(20) NOT NULL,
  usuario_id INT NOT NULL,
  obra_social VARCHAR(100) NOT NULL,
  PRIMARY KEY (id),
  KEY fk_paciente_usuario_idx (usuario_id),
  CONSTRAINT fk_paciente_usuario
    FOREIGN KEY (usuario_id) REFERENCES usuarios (id)
);

CREATE TABLE profesionales (
  id INT NOT NULL AUTO_INCREMENT,
  matricula VARCHAR(45) NOT NULL,
  usuario_id INT NOT NULL,
  especialidad_id INT NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY matricula_UNIQUE (matricula),
  KEY fk_profesional_usuario_idx (usuario_id),
  KEY fk_profesional_especialidad_idx (especialidad_id),
  CONSTRAINT fk_profesional_usuario
    FOREIGN KEY (usuario_id) REFERENCES usuarios (id),
  CONSTRAINT fk_profesional_especialidad
    FOREIGN KEY (especialidad_id) REFERENCES especialidades (id)
);

CREATE TABLE disponibilidades (
  id INT NOT NULL AUTO_INCREMENT,
  profesional_id INT NOT NULL,
  dia_de_semana VARCHAR(20) NOT NULL,
  hora_inicio TIME NOT NULL,
  hora_fin TIME NOT NULL,
  PRIMARY KEY (id),
  KEY fk_disponibilidad_profesional_idx (profesional_id),
  CONSTRAINT fk_disponibilidad_profesional
    FOREIGN KEY (profesional_id) REFERENCES profesionales (id)
);

CREATE TABLE turnos (
  id INT NOT NULL AUTO_INCREMENT,
  paciente_id INT NOT NULL,
  profesional_id INT NOT NULL,
  fecha_hora DATETIME NOT NULL,
  estado VARCHAR(30) NOT NULL,
  observaciones VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY fk_turno_paciente_idx (paciente_id),
  KEY fk_turno_profesional_idx (profesional_id),
  CONSTRAINT fk_turno_paciente
    FOREIGN KEY (paciente_id) REFERENCES pacientes (id),
  CONSTRAINT fk_turno_profesional
    FOREIGN KEY (profesional_id) REFERENCES profesionales (id)
);