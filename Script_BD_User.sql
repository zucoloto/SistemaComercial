/* Base de Dados: 'sistema_comercial' */
CREATE DATABASE IF NOT EXISTS sistema_comercial;
USE sistema_comercial;

/* Cria o usuário e senha */
CREATE USER 'user_comercial'@'localhost' IDENTIFIED BY '008516';

/* Libera as permissões */
GRANT ALL PRIVILEGES ON sistema_comercial.* TO 'user_comercial'@'localhost' WITH GRANT OPTION;