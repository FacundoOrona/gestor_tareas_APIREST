-- Crear base de datos
CREATE DATABASE IF NOT EXISTS gestor_tareas CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE gestor_tareas;

-- Tabla de usuarios
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    contraseña VARCHAR(255) NOT NULL,
    rol ENUM('ADMIN', 'MIEMBRO') NOT NULL
);

-- Tabla de proyectos
CREATE TABLE proyectos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    fecha_inicio DATE,
    fecha_fin DATE
);

-- Tabla de tareas
CREATE TABLE tareas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    descripcion TEXT,
    estado ENUM('PENDIENTE', 'EN_PROGRESO', 'FINALIZADA') NOT NULL DEFAULT 'PENDIENTE',
    prioridad ENUM('BAJA', 'MEDIA', 'ALTA') NOT NULL DEFAULT 'MEDIA',
    fecha_limite DATE,
    proyecto_id BIGINT,
    responsable_id BIGINT,
    etiquetas VARCHAR(255),

    CONSTRAINT fk_tarea_proyecto FOREIGN KEY (proyecto_id) REFERENCES proyectos(id) ON DELETE SET NULL,
    CONSTRAINT fk_tarea_responsable FOREIGN KEY (responsable_id) REFERENCES usuarios(id) ON DELETE SET NULL
);
