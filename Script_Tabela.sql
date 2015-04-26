/* Estrutura da tabela 'cliente' */
CREATE TABLE IF NOT EXISTS cliente (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome_cliente VARCHAR(100) NOT NULL,
  email VARCHAR(255) NOT NULL,
  cpf_cnpj VARCHAR(14) NOT NULL,
  tipo VARCHAR(10) NOT NULL  
) ENGINE=InnoDB;

/* Estrutura da tabela 'endereco_cliente' */
CREATE TABLE IF NOT EXISTS endereco_cliente (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  logradouro VARCHAR(150) NOT NULL,
  numero VARCHAR(20) NOT NULL,
  complemento VARCHAR(100),
  cidade VARCHAR(70) NOT NULL,
  uf VARCHAR(2) NOT NULL,
  cep VARCHAR(9) NOT NULL,
  cliente_id BIGINT NOT NULL,
  CONSTRAINT fk_endereco_cliente_cliente FOREIGN KEY (cliente_id) REFERENCES cliente (id)
) ENGINE=InnoDB;