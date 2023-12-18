-- V1__create-tables.sql

-- Tabela bibliotecário
CREATE TABLE bibliotecario (
                               id SERIAL PRIMARY KEY,
                               nome VARCHAR(255) NOT NULL,
                               status VARCHAR(50) NOT NULL,
                               setor VARCHAR(100),
                               contato VARCHAR(100),
                               created_at TIMESTAMP
);

-- Tabela livro
CREATE TABLE livro (
                       id SERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       ISBN BIGINT,
                       descricao TEXT,
                       autor VARCHAR(255),
                       disponibilidade VARCHAR(50)
);

-- Ttabela aluno
CREATE TABLE aluno (
                       id SERIAL PRIMARY KEY,
                       nome VARCHAR(255) NOT NULL,
                       matricula BIGINT NOT NULL,
                       created_at TIMESTAMP,
                       status VARCHAR(255),
                       contato VARCHAR(255)
);
