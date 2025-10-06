-- =====================================================
-- ESQUEMA UNIFICADO DE BASE DE DATOS
-- =====================================================

CREATE SCHEMA IF NOT EXISTS app;

SET search_path TO app;

-- ==============================
-- CATÁLOGO
-- ==============================
CREATE TABLE productos (
    id_producto SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10,2) NOT NULL,
    categoria VARCHAR(50),
    disponible BOOLEAN DEFAULT TRUE,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE categorias (
    id_categoria SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT
);

-- ==============================
-- PEDIDOS
-- ==============================
CREATE TABLE pedidos (
    id_pedido SERIAL PRIMARY KEY,
    id_cliente INT NOT NULL,
    fecha_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(30) DEFAULT 'pendiente',
    total DECIMAL(10,2) DEFAULT 0.00
);

CREATE TABLE detalles_pedido (
    id_detalle SERIAL PRIMARY KEY,
    id_pedido INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) GENERATED ALWAYS AS (cantidad * precio_unitario) STORED
);

-- ==============================
-- PAGOS
-- ==============================
CREATE TABLE pagos (
    id_pago SERIAL PRIMARY KEY,
    id_pedido INT NOT NULL,
    metodo_pago VARCHAR(30) NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    moneda VARCHAR(10) DEFAULT 'COP',
    estado VARCHAR(20) DEFAULT 'pendiente',
    fecha_pago TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    referencia_transaccion VARCHAR(100)
);

-- ==============================
-- INVENTARIO
-- ==============================
CREATE TABLE inventario (
    id_inventario SERIAL PRIMARY KEY,
    id_producto INT NOT NULL,
    cantidad_disponible INT NOT NULL,
    ubicacion VARCHAR(100),
    ultima_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE movimientos_inventario (
    id_movimiento SERIAL PRIMARY KEY,
    id_producto INT NOT NULL,
    tipo_movimiento VARCHAR(20) CHECK (tipo_movimiento IN ('entrada', 'salida')),
    cantidad INT NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    descripcion TEXT
);

-- ==============================
-- ENVIOS
-- ==============================
CREATE TABLE envios (
    id_envio SERIAL PRIMARY KEY,
    id_pedido INT NOT NULL,
    direccion_envio VARCHAR(200) NOT NULL,
    ciudad VARCHAR(100),
    departamento VARCHAR(100),
    codigo_postal VARCHAR(20),
    estado VARCHAR(30) DEFAULT 'pendiente',
    transportadora VARCHAR(100),
    fecha_envio TIMESTAMP,
    fecha_entrega TIMESTAMP
);

-- ==============================
-- NOTIFICACIONES
-- ==============================
CREATE TABLE notificaciones (
    id_notificacion SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    mensaje TEXT NOT NULL,
    canal VARCHAR(30) CHECK (canal IN ('email', 'sms', 'push')),
    estado VARCHAR(20) DEFAULT 'pendiente',
    fecha_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE plantillas_notificacion (
    id_plantilla SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    asunto VARCHAR(150),
    contenido TEXT,
    canal VARCHAR(30) CHECK (canal IN ('email', 'sms', 'push')),
    activo BOOLEAN DEFAULT TRUE
);

-- ==============================
-- CLIENTES
-- ==============================
CREATE TABLE clientes (
    id_cliente SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(20),
    direccion VARCHAR(200),
    ciudad VARCHAR(100),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =====================================================
-- ÍNDICES DE OPTIMIZACIÓN
-- =====================================================
CREATE INDEX idx_pedidos_cliente ON pedidos (id_cliente);
CREATE INDEX idx_detalle_pedido ON detalles_pedido (id_pedido);
CREATE INDEX idx_inventario_producto ON inventario (id_producto);
CREATE INDEX idx_envios_pedido ON envios (id_pedido);
CREATE INDEX idx_pagos_pedido ON pagos (id_pedido);
CREATE INDEX idx_notificaciones_usuario ON notificaciones (id_usuario);
