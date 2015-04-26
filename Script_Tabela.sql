-- Estrutura da tabela 'cliente'
CREATE TABLE IF NOT EXISTS cliente (
  id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome_cliente VARCHAR(100) NOT NULL,
  email VARCHAR(255) NOT NULL,
  cpf_cnpj VARCHAR(14) NOT NULL,
  tipo VARCHAR(10) NOT NULL  
) ENGINE=InnoDB;

-- Estrutura da tabela 'endereco_cliente'
CREATE TABLE IF NOT EXISTS endereco_cliente (
  id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  logradouro VARCHAR(150) NOT NULL,
  numero VARCHAR(20) NOT NULL,
  complemento VARCHAR(100),
  cidade VARCHAR(70) NOT NULL,
  uf VARCHAR(2) NOT NULL,
  cep VARCHAR(9) NOT NULL,
  cliente_id BIGINT(20) NOT NULL,
  CONSTRAINT fk_endereco_cliente_cliente FOREIGN KEY (cliente_id) REFERENCES cliente (id)
) ENGINE=InnoDB;

-- Estrutura da tabela 'usuario'
CREATE TABLE IF NOT EXISTS usuario (
  id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome_usuario VARCHAR(100) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE KEY,
  senha VARCHAR(20) NOT NULL
) ENGINE=InnoDB;

-- Estrutura da tabela 'grupo'
CREATE TABLE IF NOT EXISTS grupo (
  id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome_grupo VARCHAR(50) NOT NULL,
  descricao VARCHAR(100) NOT NULL
) ENGINE=InnoDB;

-- Estrutura da tabela 'usuario_grupo'
CREATE TABLE IF NOT EXISTS usuario_grupo (
  usuario_id BIGINT(20) NOT NULL,
  grupo_id BIGINT(20) NOT NULL,
  PRIMARY KEY (usuario_id, grupo_id),
  CONSTRAINT fk_usuario_grupo FOREIGN KEY (usuario_id) REFERENCES usuario (id),
  CONSTRAINT fk_grupo_usuario FOREIGN KEY (grupo_id) REFERENCES grupo (id)
) ENGINE=InnoDB;

-- Estrutura da tabela 'categoria'
CREATE TABLE IF NOT EXISTS categoria (
  id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  descricao VARCHAR(60) NOT NULL,
  CONSTRAINT fk_categoria_categoria_pai FOREIGN KEY (categoria_pai_id) REFERENCES categoria (id)
) ENGINE=InnoDB;

-- Estrutura da tabela 'produto'
CREATE TABLE IF NOT EXISTS produto (
  id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome_produto VARCHAR(80) NOT NULL,
  sku VARCHAR(20) NOT NULL UNIQUE KEY,
  valor_unitario DECIMAL(10,2) NOT NULL,
  quantidade_estoque INT(5) NOT NULL,
  CONSTRAINT fk_produto_categoria FOREIGN KEY (categoria_id) REFERENCES categoria (id)
) ENGINE=InnoDB;

-- Estrutura da tabela 'item_pedido'
CREATE TABLE IF NOT EXISTS item_pedido (
  id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  quantidade INT(5) NOT NULL,
  valor_unitario DECIMAL(10,2) NOT NULL,
  CONSTRAINT fk_item_pedito_produto FOREIGN KEY (produto_id) REFERENCES produto (id),
  CONSTRAINT fk_item_pedito_pedido FOREIGN KEY (pedido_id) REFERENCES pedido (id)
) ENGINE=InnoDB;

-- Estrutura da tabela 'pedido'
CREATE TABLE IF NOT EXISTS pedido (
  id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  data_criacao DATE NOT NULL,
  observacao VARCHAR(100),
  data_entrega DATE NOT NULL,
  valor_frete DECIMAL(10,2) NOT NULL,
  valor_desconto DECIMAL(10,2) NOT NULL,
  valor_total DECIMAL(10,2) NOT NULL,
  status VARCHAR(20) NOT NULL,
  forma_pagamento VARCHAR(20) NOT NULL,
  CONSTRAINT fk_pedito_usuario FOREIGN KEY (vendedor_id) REFERENCES usuario (id),
  CONSTRAINT fk_pedito_cliente FOREIGN KEY (cliente_id) REFERENCES cliente (id),
  CONSTRAINT fk_pedito_endereco_entrega FOREIGN KEY (endereco_entrega_id) REFERENCES endereco_entrega (id)
) ENGINE=InnoDB;

-- Estrutura da tabela 'endereco_entrega'
CREATE TABLE IF NOT EXISTS endereco_entrega (
  logradouro VARCHAR(150) NOT NULL,
  numero VARCHAR(20) NOT NULL,
  complemento VARCHAR(100),
  cidade VARCHAR(70) NOT NULL,
  uf VARCHAR(2) NOT NULL,
  cep VARCHAR(9) NOT NULL
) ENGINE=InnoDB;