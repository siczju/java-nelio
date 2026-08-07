# O que é JDBC?

**JDBC (Java Database Connectivity)** é a API padrão do Java para comunicação com bancos de dados relacionais.

Fluxo:

```text
Java
   ↓
JDBC
   ↓
Driver PostgreSQL/MySQL
   ↓
Banco de Dados
```

Com JDBC podemos:

- Abrir conexão
- Executar SQL
- Receber resultados
- Inserir registros
- Atualizar registros
- Excluir registros
- Fechar conexão

---

# Driver JDBC

É a biblioteca que permite ao Java conversar com um banco específico.

Exemplo:

- PostgreSQL → postgresql-42.x.x.jar
- MySQL → mysql-connector-j.jar

Sem o driver o Java não consegue conectar ao banco.

---

# db.properties

Arquivo utilizado para guardar as configurações da conexão.

Exemplo:

```properties
db.url=jdbc:postgresql://localhost:5432/coursejdbc
user=postgres
password=123456
```

## Vantagens

- Não deixa usuário e senha no código
- Fácil de alterar
- Código mais organizado

---

# Classe DB

Responsável por centralizar toda a conexão com o banco.

Normalmente possui métodos como:

```java
getConnection()

closeConnection()

closeStatement()

closeResultSet()
```

Assim nenhuma outra classe precisa saber como abrir conexão.

---

# Properties

Classe usada para ler arquivos `.properties`.

Exemplo:

```java
Properties props = new Properties();
props.load(fs);
```

Depois podemos recuperar valores:

```java
props.getProperty("db.url");
props.getProperty("user");
props.getProperty("password");
```

---

# FileInputStream

Serve para abrir um arquivo em bytes.

```java
FileInputStream fs = new FileInputStream("db.properties");
```

Foi usado porque:

- Properties trabalha com InputStream.
- É o jeito mais comum para carregar arquivos de configuração.

---

# Connection

Representa uma conexão aberta com o banco.

```java
Connection conn = DB.getConnection();
```

Pense como:

> "Agora estou conectado ao PostgreSQL."

---

# DriverManager

É quem cria a conexão.

```java
DriverManager.getConnection(url, props);
```

Recebe:

- URL
- usuário
- senha

e devolve um objeto Connection.

---

# Statement

Executa SQL simples.

Exemplo:

```java
Statement st = conn.createStatement();

ResultSet rs = st.executeQuery(
    "SELECT * FROM department"
);
```

Usado quando a consulta é fixa.

---

# PreparedStatement ⭐

É uma versão melhor do Statement.

Permite parâmetros.

Exemplo:

```sql
INSERT INTO seller
(name,email)
VALUES (?,?)
```

Depois:

```java
st.setString(1,"Carlos");
st.setString(2,"carlos@gmail.com");
```

## Por que usar?

✔ Evita SQL Injection

✔ Código mais organizado

✔ Pode reutilizar a consulta

✔ Melhor desempenho

Na prática quase todos os projetos usam PreparedStatement.

---

# O significado do ?

Os `?` representam espaços reservados.

Exemplo:

```sql
VALUES (?,?)
```

Depois:

```java
st.setString(1,"Carlos");
st.setString(2,"carlos@gmail.com");
```

O JDBC monta:

```sql
VALUES ('Carlos','carlos@gmail.com')
```

---

# ResultSet

Representa o resultado de um SELECT.

```java
ResultSet rs
```

Percorrendo:

```java
while(rs.next()){
    ...
}
```

Obtendo valores:

```java
rs.getInt("id");

rs.getString("name");

rs.getDouble("basesalary");

rs.getDate("birthdate");
```

---

# executeQuery()

Usado para consultas SELECT.

```java
ResultSet rs = st.executeQuery(sql);
```

Retorna:

```
ResultSet
```

---

# executeUpdate()

Usado para:

- INSERT

- UPDATE

- DELETE

Retorna:

```java
int rowsAffected
```

Exemplo:

```java
int rows = st.executeUpdate();
```

Se retornar:

```
1
```

Uma linha foi alterada.

---

# SQL mais importantes

## SELECT

```sql
SELECT *
FROM department;
```

---

## SELECT com WHERE

```sql
SELECT *
FROM seller
WHERE id = ?;
```

---

## INNER JOIN

```sql
SELECT seller.*, department.name AS depname

FROM seller

INNER JOIN department

ON seller.departmentid = department.id

WHERE seller.id = ?;
```

---

## INSERT

```sql
INSERT INTO seller
(name,email,birthdate,basesalary,departmentid)

VALUES
(?,?,?,?,?);
```

---

## UPDATE

```sql
UPDATE seller

SET
name=?,
email=?,
birthdate=?,
basesalary=?,
departmentid=?

WHERE id=?;
```

---

## DELETE

```sql
DELETE FROM seller

WHERE id=?;
```

---

# SQLException

Exceção lançada pelo JDBC.

Exemplo:

```java
catch(SQLException e)
```

Normalmente é encapsulada em uma DbException.

---

# DbException

Exceção personalizada criada pelo projeto.

Serve para não espalhar SQLException pela aplicação.

---

# CRUD

CRUD significa:

C → Create (INSERT)

R → Read (SELECT)

U → Update (UPDATE)

D → Delete (DELETE)

Todo sistema faz essas quatro operações.

---

# DAO (Data Access Object)

DAO é um padrão de projeto.

Sua função é separar o acesso ao banco da lógica da aplicação.

Sem DAO:

```text
Main

↓

SQL

↓

Banco
```

Tudo fica misturado.

Com DAO:

```text
Main

↓

SellerDao

↓

SellerDaoJDBC

↓

Banco
```

Muito mais organizado.

---

# Interface DAO

Define apenas os métodos.

Exemplo:

```java
public interface SellerDao {

    Seller findById(Integer id);

    List<Seller> findAll();

    void insert(Seller obj);

    void update(Seller obj);

    void deleteById(Integer id);

}
```

Não possui SQL.

---

# Implementação DAO

Quem implementa a interface.

Exemplo:

```java
SellerDaoJDBC
```

É aqui que ficam:

- PreparedStatement

- ResultSet

- SQL

- JDBC

---

# DaoFactory

Responsável por criar os DAOs.

Ao invés de fazer:

```java
new SellerDaoJDBC(conn);
```

fazemos:

```java
SellerDao dao =
DaoFactory.createSellerDao();
```

A Factory esconde a implementação.

---

# Estrutura do projeto

```text
application
│
├── Main
│
model
│
├── entities
│     Seller
│     Department
│
├── dao
│     SellerDao
│     DepartmentDao
│
├── dao.impl
│     SellerDaoJDBC
│     DepartmentDaoJDBC
│
db
│
├── DB
├── DbException
└── db.properties
```

---

# Fluxo da aplicação

```text
Main

↓

SellerDao

↓

SellerDaoJDBC

↓

PreparedStatement

↓

DB.getConnection()

↓

DriverManager

↓

PostgreSQL
```

---

# Boas práticas

✅ Usar PreparedStatement

✅ Guardar conexão em db.properties

✅ Fechar Connection

✅ Fechar Statement

✅ Fechar ResultSet

✅ Centralizar conexão na classe DB

✅ Organizar acesso ao banco usando DAO

---

# Conceitos importantes

## Connection

Representa uma conexão com o banco.

---

## DriverManager

Cria a conexão.

---

## Properties

Lê o arquivo de configuração.

---

## Statement

Executa SQL simples.

---

## PreparedStatement

Executa SQL parametrizado.

---

## ResultSet

Resultado de um SELECT.

---

## executeQuery()

Usado em SELECT.

---

## executeUpdate()

Usado em INSERT, UPDATE e DELETE.

---

## SQLException

Erro do JDBC.

---

## DbException

Exceção personalizada.

---

## DAO

Camada responsável pelo acesso ao banco.

---

## DaoFactory

Cria os objetos DAO.

---

# O que preciso saber para dominar JDBC

- ✅ O que é JDBC
- ✅ Driver JDBC
- ✅ Connection
- ✅ DriverManager
- ✅ db.properties
- ✅ Properties
- ✅ FileInputStream
- ✅ Statement
- ✅ PreparedStatement
- ✅ ResultSet
- ✅ executeQuery()
- ✅ executeUpdate()
- ✅ INSERT
- ✅ UPDATE
- ✅ DELETE
- ✅ SELECT
- ✅ INNER JOIN
- ✅ SQLException
- ✅ Classe DB
- ✅ DAO
- ✅ Interface DAO
- ✅ Implementação DAO
- ✅ DaoFactory

> **Resumo final:** JDBC é a tecnologia que permite ao Java conversar com o banco de dados. O padrão DAO organiza esse acesso, deixando todo o código SQL em uma camada específica, enquanto a aplicação apenas solicita operações como buscar, inserir, atualizar ou excluir dados.