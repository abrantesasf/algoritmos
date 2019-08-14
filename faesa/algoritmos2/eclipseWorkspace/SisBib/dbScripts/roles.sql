/* ====================================================================== */
/* Banco de dados para o trabalho da disciplina: Algoritmo 2              */
/* ---------------------------------------------------------------------- */
/* Sistema de Biblioteca: SisBib                                          */
/* ====================================================================== */
/* Abrantes Araújo Silva Filho (abrantesasf@gmail.com)                    */
/* Isaac de Miranda Campos (isaac.miranda321@gmail.com)                   */
/* ====================================================================== */


/* ====================================================================== */
/* Role "dba", a proprietária dos bancos de dados de produção e de        */
/* simulação, bem como dos objetos em cada banco de dados.                */
/* ====================================================================== */

-- Apaga a role, se já existir (se existir no cluster o banco de dados
-- de produção ou de simulação, a role não pode ser dropada):
DROP ROLE IF EXISTS :roleDBA;
DROP ROLE IF EXISTS :roleUSER;

-- Cria a role:
CREATE ROLE :roleDBA WITH
  NOSUPERUSER                -- não precisa ser um super-usuário
  CREATEDB                   -- pode criar bancos de dados
  CREATEROLE                 -- pode criar outras roles ou usuários
  INHERIT                    -- herda os privilégios de outras roles
  --NOLOGIN                    -- não pode logar no banco de dados
  LOGIN                      -- pode logar no banco de dados
  NOREPLICATION              -- não pode iniciar streaming de replicação
  BYPASSRLS                  -- pode fazer bypass nas regras de row level security
  --CONNECTION LIMIT 0         -- não permite nenhum conexão
  CONNECTION LIMIT 3         -- 3 conexões administrativas simultâneas permitidas
  ENCRYPTED PASSWORD '12345' -- senha da role (alterar se necessário)
;

-- Comentário da role:
COMMENT ON ROLE :roleDBA IS 'Usuário dono dos bancos de dados e objetos do banco de dados.';


-- Cria a role:
CREATE ROLE :roleUSER WITH
  NOSUPERUSER                -- não precisa ser um super-usuário
  NOCREATEDB                 -- não pode criar bancos de dados
  NOCREATEROLE               -- não pode criar outras roles ou usuários
  INHERIT                    -- herda os privilégios de outras roles
  --NOLOGIN                    -- não pode logar no banco de dados
  LOGIN                      -- pode logar no banco de dados
  NOREPLICATION              -- não pode iniciar streaming de replicação
  NOBYPASSRLS                -- não pode fazer bypass nas regras de row level security
  --CONNECTION LIMIT 0         -- não permite nenhum conexão
  CONNECTION LIMIT 3         -- 3 conexões
  ENCRYPTED PASSWORD '12345' -- senha da role (alterar se necessário)
;

-- Comentário da role
COMMENT ON ROLE :roleUSER IS 'Role com os grants de acesso aos objetos do banco de dados.';
