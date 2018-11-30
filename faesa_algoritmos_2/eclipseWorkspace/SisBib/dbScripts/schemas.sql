/* ====================================================================== */
/* Banco de dados para o trabalho da disciplina: Algoritmo 2              */
/* ---------------------------------------------------------------------- */
/* Sistema de Biblioteca: SisBib                                          */
/* ====================================================================== */
/* Abrantes Araújo Silva Filho (abrantesasf@gmail.com)                    */
/* Isaac de Miranda Campos (isaac.miranda321@gmail.com)                   */
/* ====================================================================== */


/* ====================================================================== */
/* Cria o schema com o mesmo nome da roleUSER e, por segurança, remove o  */
/* schema public                                                          */
/* ====================================================================== */

-- Apaga os schemas roleUSER e public (o schema public é apagado para forçar
-- que todos os comandos SQL sejam qualificados e para que algum comando
-- não qualificado acabe criando objetos no schema public):
DROP SCHEMA IF EXISTS public    CASCADE;
DROP SCHEMA IF EXISTS :roleUSER CASCADE;

-- Cria o schema usuário:
CREATE SCHEMA IF NOT EXISTS :roleUSER AUTHORIZATION :roleDBA;

-- Comentário sobre o schema:
COMMENT ON SCHEMA :roleUSER IS 'Schema para os objetos do banco de dados';

-- Remove todos os privilégios sobre o banco de dados e o schema roleUSER de PUBLIC:
REVOKE ALL ON DATABASE :nomeDB   FROM PUBLIC;
REVOKE ALL ON SCHEMA   :roleUSER FROM PUBLIC;

-- Grant de acesso ao schema nutr1, pela role nutr1:
GRANT USAGE ON SCHEMA :roleUSER TO :roleUSER;
