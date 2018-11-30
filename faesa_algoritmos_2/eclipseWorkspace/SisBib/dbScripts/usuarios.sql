/* ====================================================================== */
/* Banco de dados para o trabalho da disciplina: Algoritmo 2              */
/* ---------------------------------------------------------------------- */
/* Sistema de Biblioteca: SisBib                                          */
/* ====================================================================== */
/* Abrantes Araújo Silva Filho (abrantesasf@gmail.com)                    */
/* Isaac de Miranda Campos (isaac.miranda321@gmail.com)                   */
/* ====================================================================== */


/* ---------------------------------------------------------------------- */
/* Tabela de usuários                                                     */
/* ---------------------------------------------------------------------- */

--DROP SEQUENCE :schemaUSER.seq_usuarios_id;
--CREATE SEQUENCE :schemaUSER.seq_usuarios_id
--    START WITH 1
--    INCREMENT BY 1
--    MINVALUE 1
--    NO CYCLE
--    CACHE 1;

--REVOKE USAGE ON SEQUENCE :schemaUSER.seq_usuarios_id FROM :roleUSER;
--GRANT USAGE ON SEQUENCE  :schemaUSER.seq_usuarios_id TO   :roleUSER;

--DROP TABLE IF EXISTS :schemaUSER.usuarios CASCADE;
CREATE TABLE :schemaUSER.usuarios (
  matricula  SMALLINT     CONSTRAINT nn_usuarios_matricula NOT NULL
                          CONSTRAINT cc_usuarios_matricula CHECK (matricula BETWEEN 1 AND 99999999),
  nome       VARCHAR(250) CONSTRAINT nn_usuarios_nome      NOT NULL,
  endereco   VARCHAR(300) CONSTRAINT nn_usuarios_endereco  NOT NULL,
  data       DATE         CONSTRAINT nn_usuarios_data      NOT NULL,
  CONSTRAINT pk_usuarios PRIMARY KEY (matricula) USING INDEX TABLESPACE PG_DEFAULT
)
TABLESPACE PG_DEFAULT;

CREATE INDEX idx_usuarios_nome ON :schemaUSER.usuarios (nome) TABLESPACE PG_DEFAULT;

--ALTER TABLE :schemaUSER.usuarios ADD CONSTRAINT cc_<nome>
--    CHECK (<coluna> IN ('x', 'y'));

--ALTER TABLE :schemaUSER.usuarios ADD CONSTRAINT cc_<nome>
--    CHECK (coluna BETWEEN 999 AND 999);

COMMENT ON TABLE  :schemaUSER.usuarios            IS 'Cadastro dos usuarios do SisBib';
COMMENT ON COLUMN :schemaUSER.usuarios.matricula  IS 'PK da tabela, matrícula dos usuários';
COMMENT ON COLUMN :schemaUSER.usuarios.nome       IS 'Nome do usuário';
COMMENT ON COLUMN :schemaUSER.usuarios.endereco   IS 'Endereço completo do usuário';
COMMENT ON COLUMN :schemaUSER.usuarios.data       IS 'Data de ingresso do usuário';

--REVOKE SELECT, INSERT, UPDATE, DELETE ON :schemaUSER.usuarios FROM :roleUSER;
GRANT  SELECT, INSERT, UPDATE, DELETE ON :schemaUSER.usuarios TO   :roleUSER;

