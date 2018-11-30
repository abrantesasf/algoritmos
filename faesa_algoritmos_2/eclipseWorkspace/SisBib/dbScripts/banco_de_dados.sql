/* ====================================================================== */
/* Banco de dados para o trabalho da disciplina: Algoritmo 2              */
/* ---------------------------------------------------------------------- */
/* Sistema de Biblioteca: SisBib                                          */
/* ====================================================================== */
/* Abrantes Araújo Silva Filho (abrantesasf@gmail.com)                    */
/* Isaac de Miranda Campos (isaac.miranda321@gmail.com)                   */
/* ====================================================================== */


/* ====================================================================== */
/* Cria o banco de dados especificado pelo prompt a ser respondido pelo   */
/* usuário.                                                               */
/* ====================================================================== */

-- Cria o banco de dados:
CREATE DATABASE :nomeDB WITH
  OWNER             = :roleDBA       -- pertence à role nutr1
  TEMPLATE          = template0      -- criado do zero mesmo, a partir do template0
  ENCODING          = 'UTF8'         -- suporte characterset utf8
  LC_COLLATE        = 'pt_BR.UTF-8'  -- collate pt_br
  LC_CTYPE          = 'pt_BR.UTF-8'  -- ctype pt_br
  --LC_COLLATE        = 'en_US.UTF-8'  -- collate US
  --LC_CTYPE          = 'en_US.UTF-8'  -- ctype US
  TABLESPACE        = DEFAULT        -- usa a tablespace padrão do postgresql
  ALLOW_CONNECTIONS = TRUE           -- permite conexões
  CONNECTION LIMIT  = -1             -- sem limite de conexões
  IS_TEMPLATE       = FALSE          -- não será template
;

-- Comentário do banco de dados:
COMMENT ON DATABASE :nomeDB IS 'Banco de dados';

-- Grant de conexão ao banco de dados para a role usuária:
GRANT CONNECT ON DATABASE :nomeDB TO :roleUSER;
