# SQL com PostgreSQL

    SQL -> É uma linguagem de consulta universal de banco de dados.
    Structured Query Language -> Linguagem de consulta estruturada

    Coluna (campo)
    Linha (registro)

    SGBD (Sistema de gereciamento de Banco de Dados)?
        (Data Base Management System (DBMS)) -> é um sistema de gerenciamento de banco
        de dados. Seu principal objetivo é gerenciar acessos, armazenar informações
        , organizar, manipular dados, importar e exportar dados. É basicamente um   
        software que vai disponibilizar uma interface mais amigável para poder gerenciar
        o banco de dados. Como se fosse uma IDE.
    Ex: SQLServer, PostgreSQL,MySQL...

    Tipos de Dados no PostgreSQL:
        * Númericos
            - smallint, 2 bytes, -32768 a 32768
            - integer, 4 bytes, -2147483648 a 2147483648
            - bigint, 8 bytes, -9200000000000000 - 9200000000000000
            - decimal, variable, no limit (infinito)
            - numeric, variable, no limit (infinito)
            - real, 4 bytes, 6 decimal digits precision
            - double precision, 8 bytes, 15 decimal digits precision
            - serial, 4 bytes, 1 a 2100000 (para chaves primarias)
            - bigserial, 8 bytes, 1 a 9200000000000000 (chaves primarias maiores)
        * Caractere
            - char -> comprimento fixo ocupa espaços em branco
            - varchar -> comprimento variável e não ocupa espaços em branco
            - text -> comprimento variável e ilimitado
        * Monetário
            - money -> -20000000 a 20000000
        * Data e Hora
            - timestamp (without time zone) -> 8 bytes, data e hora sem fuso horario com precisao de 1 microssegundo
            - timestamp (with time zone) -> 8 bytes, data e hora com fuso horário, precisão de 1 microsegundo.
            - interval -> 12 b ytes, armazena faixas de tempo com precisão de 1 microssegundo
            - date -> 4 bytes, Armazena apenas datas, precisão de 1 dia
            - time (without time zone) -> 8 bytes, apenas horários do dia com precisão de 1 microssegundo
            - time with time zone -> 12 bytes, apenas horários do dia com fuso horário, com precisão de 1 microssegundo
        * Booleano
            - true ('t', 'true', 'y', 'yes', '1')
            - false ('f', 'false', 'n', 'no', '0')

´´´java

    CREATE TABLE usuarios (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) UNIQUE NOT NULL,
	data_nascimento DATE NOT NULL,
	data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );
    
    CREATE TABLE pedidos(
    codigo_pedido SERIAL PRIMARY KEY,
    usuario_id INT REFERENCES usuarios(id),
    data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );
    
    INSERT INTO usuarios(nome,email,data_nascimento)
    VALUES('Marcos Duarte', 'marcos@gmail.com', '06/07/1994'),
    ('Maria da Silva', 'maria@gmail.com', '07/02/2002'),
    ('Jorge Soares', 'jorge@gmail.com', '03/12/2022'),
    ('Roberto Manches', 'roberto@gmail.com', '12/08/1978');
    
    INSERT INTO pedidos(usuario_id) VALUES(2);
    
    SELECT * FROM usuarios;
    SELECT * FROM usuarios WHERE nome LIKE 'm%' OR nome LIKE 'M%';
    SELECT * FROM usuarios WHERE nome = 'Marcos Duarte';
    SELECT * FROM usuarios ORDER BY nome ASC; -> Ordenando a lista de usuarios de forma crescente do A ao Z ASCENDENTE
    SELECT * FROM usuarios ORDER BY data_nascimento DESC; -> ordenando de forma decrescente
    SELECT * FROM usuarios LIMIT 2; -> limitando o numero de usuarios q vai aparecer (os dois primeiros nesse caso)
    
    UPDATE usuarios SET email = 'marcos@hotmail.com' WHERE id = 1;
    
    DELETE FROM usuarios WHERE id = 4;
    
    -> Modificar a tabela adicionando mais uma coluna de idade com um valor padrão para todos de 0
    ALTER TABLE usuarios ADD COLUMN idade SMALLINT NOT NULL DEFAULT 0;

```