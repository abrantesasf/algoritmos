\timing on
\set VERBOSITY verbose

\o instalacao_log.txt

\qecho /* ====================================================================== */
\echo /* ====================================================================== */
\qecho /* Instalação do banco de dados para o projeto SisBib                     */
\echo /* Instalação do banco de dados para o projeto SisBib                     */
\qecho /* Abrantes Araújo Silva Filho                                            */
\echo /* Abrantes Araújo Silva Filho                                            */
\qecho /* Isaac de Miranda Campos                                                */
\echo /* Isaac de Miranda Campos                                                */
\qecho /* ====================================================================== */
\echo /* ====================================================================== */
\qecho

\echo
\qecho === Obtendo nome do banco de dados do usuário ===
\echo =======================================================================
\echo Atenção: você deverá digitar o nome do banco de dados a ser criado para
\echo a instalação. Se esse banco de dados já existir no cluster do
\echo PostgreSQL, ele === TOTALMENTE APAGADO === incluindo quaisquer dados
\echo existentes. Por favor, aborte esta instalação se você não souber o que
\echo está fazendo ou se está em dúvida do procedimento correto a ser feito.
\echo Considere-se avisado!
\echo =======================================================================
\prompt '\nEntre com o nome do banco de dados (Ctrl-C para abortar): ' nomeDB
\prompt '\nEntre com o nome da role DBA (Ctrl-C para abortar): ' roleDBA
\prompt '\nEntre com o nome da role comum (Ctrl-C para abortar): ' roleUSER
\prompt '\nEntre com o nome do schema (Ctrl-C para abortar): ' schemaUSER
\qecho

\qecho === Removendo o banco de dados antigo, se exister ===
\echo === Removendo o banco de dados antigo, se exister ===
DROP DATABASE IF EXISTS :nomeDB ;
\qecho
\echo

\qecho === Cria as roles ===
\echo === Cria as roles ===
\i roles.sql
\qecho
\echo

\qecho === Cria o banco de dados ===
\echo === Cria o banco de dados ===
\i banco_de_dados.sql
\qecho
\echo

\qecho === Conectando-se ao novo banco de dados, como usuário postgres ===
\echo === Conectando-se ao novo banco de dados, como usuário postgres ===
\c :nomeDB postgres
\qecho
\echo

\qecho === Cria o schema específico, remove o schema public e revoga privilégios de PUBLIC ===
\echo === Cria o schema específico, remove o schema public e revoga privilégios de PUBLIC ===
\i schemas.sql
\qecho
\echo

\qecho === Conectando-se ao novo banco de dados, como usuário dba ===
\echo === Conectando-se ao novo banco de dados, como usuário dba ===
\c :nomeDB :roleDBA
\qecho
\echo

\qecho === Tabela e dados das filiais ===
\echo === Tabela e dados das filiais ===
\i usuarios.sql
\qecho
\echo

