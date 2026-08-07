# 1. ORM

**ORM (Object-Relational Mapping)** é o mapeamento entre objetos Java e tabelas do banco.

```text
Objeto Java ↔ Tabela do banco
```

Exemplo:

```java
Pessoa
- id
- nome
- email
```

Pode representar:

```text
Tabela pessoa
----------------
id
nome
email
```

O ORM permite trabalhar com objetos Java sem precisar escrever SQL manualmente para todas as operações.

O mapeamento objeto-relacional também envolve conceitos como:

- Contexto de persistência
- Mapa de identidade
- Lazy Loading

---

# 2. JPA

**JPA = Java Persistence API**

JPA é uma **especificação**, não uma implementação.

```text
JPA
 ↓
Define regras e APIs

Hibernate
 ↓
Implementa essas regras
```

Para utilizar JPA, precisamos de uma implementação, como o Hibernate.

---

# 3. Hibernate

Hibernate é uma implementação da JPA.

Ele faz a comunicação entre os objetos Java e o banco.

```text
Java
 ↓
JPA
 ↓
Hibernate
 ↓
JDBC
 ↓
PostgreSQL
```

---

# 4. Entity

Uma classe que representa uma entidade persistente é marcada com:

```java
@Entity
public class Pessoa {
    
}
```

Isso informa ao Hibernate:

> "Essa classe deve ser tratada como uma entidade persistente."

---

# 5. @Id

Define o atributo que representa a chave primária:

```java
@Id
private Integer id;
```

Conceitualmente:

```sql
id PRIMARY KEY
```

---

# 6. @GeneratedValue

Indica que o banco/JPA deve gerar o valor do ID.

```java
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
```

Por isso podemos criar:

```java
Pessoa p1 = new Pessoa(
    null,
    "Carlos",
    "carlos@gmail.com"
);
```

O ID será gerado automaticamente.

---

# 7. Serializable

No curso aparece:

```java
public class Pessoa implements Serializable
```

e:

```java
private static final long serialVersionUID = 1L;
```

`Serializable` permite que objetos sejam serializados.

O que transforma `Pessoa` em uma entidade JPA é principalmente:

```java
@Entity
```

---

# 8. EntityManager

É uma das principais classes da JPA.

```java
EntityManager em;
```

Ele é responsável por realizar operações sobre entidades, como:

- Inserir
- Buscar
- Atualizar
- Remover

Exemplo:

```java
em.persist(p1);
```

Significa:

> Persistir o objeto `p1` no banco.

O `EntityManager` trabalha dentro de um **contexto de persistência**.

---

# 9. EntityManagerFactory

É responsável por criar objetos `EntityManager`.

```java
EntityManagerFactory emf =
    Persistence.createEntityManagerFactory("exemplo-jpa");
```

Depois:

```java
EntityManager em =
    emf.createEntityManager();
```

Fluxo:

```text
EntityManagerFactory
        ↓
   cria EntityManager
        ↓
   trabalha com o banco
```

Normalmente existe uma `EntityManagerFactory` para a aplicação e `EntityManager` conforme o contexto de utilização.

---

# 10. Persistence

A classe `Persistence` é utilizada para criar a `EntityManagerFactory`.

```java
Persistence.createEntityManagerFactory("exemplo-jpa");
```

O nome precisa corresponder ao nome da `persistence-unit`:

```xml
<persistence-unit name="exemplo-jpa">
```

---

# 11. persistence.xml

É o arquivo responsável pela configuração da JPA.

Estrutura:

```text
src
└── main
    └── resources
        └── META-INF
            └── persistence.xml
```

---

# 12. persistence-unit

Dentro do `persistence.xml`:

```xml
<persistence-unit
    name="exemplo-jpa"
    transaction-type="RESOURCE_LOCAL">
```

O nome:

```text
exemplo-jpa
```

é usado no Java:

```java
Persistence.createEntityManagerFactory("exemplo-jpa");
```

---

# 13. RESOURCE_LOCAL

```xml
transaction-type="RESOURCE_LOCAL"
```

Indica que a aplicação está trabalhando com transações locais.

Para o projeto de estudo, essa configuração é suficiente.

---

# 14. Configuração do PostgreSQL

### URL

```xml
<property
    name="jakarta.persistence.jdbc.url"
    value="jdbc:postgresql://localhost:5432/aulajpa"/>
```

Significa:

```text
localhost → computador local
5432      → porta do PostgreSQL
aulajpa   → banco de dados
```

### Driver

```xml
<property
    name="jakarta.persistence.jdbc.driver"
    value="org.postgresql.Driver"/>
```

### Usuário

```xml
<property
    name="jakarta.persistence.jdbc.user"
    value="postgres"/>
```

### Senha

```xml
<property
    name="jakarta.persistence.jdbc.password"
    value="SUA_SENHA"/>
```

---

# 15. Hibernate hbm2ddl.auto

No projeto:

```xml
<property
    name="hibernate.hbm2ddl.auto"
    value="update"/>
```

O `update` permite que o Hibernate atualize a estrutura das tabelas conforme os mapeamentos das entidades.

É útil para estudos.

Em projetos reais, normalmente é melhor utilizar ferramentas de migração, como Flyway.

---

# 16. Hibernate Dialect

Você pode informar:

```xml
<property
    name="hibernate.dialect"
    value="org.hibernate.dialect.PostgreSQLDialect"/>
```

Isso informa ao Hibernate que o banco utilizado é PostgreSQL.

No Hibernate 7, porém, o dialect do PostgreSQL pode ser detectado automaticamente.

---

# 20. Persistindo objetos

Exemplo:

```java
em.getTransaction().begin();

em.persist(p1);
em.persist(p2);
em.persist(p3);

em.getTransaction().commit();
```

Fluxo:

```text
begin()
   ↓
inicia transação
   ↓
persist()
   ↓
entidades são persistidas
   ↓
commit()
   ↓
confirma alterações
```

---

# 21. Transações

Para iniciar:

```java
em.getTransaction().begin();
```

Para confirmar:

```java
em.getTransaction().commit();
```

Em caso de erro, pode ser utilizado:

```java
rollback();
```

Conceito:

```text
BEGIN
 ↓
operações
 ↓
COMMIT
```

ou:

```text
BEGIN
 ↓
erro
 ↓
ROLLBACK
 ↓
desfaz alterações
```

---

# 22. O que acontece no persist()

Quando fazemos:

```java
em.persist(p1);
```

O Hibernate pega o objeto:

```java
Pessoa p1
```

e utiliza os mapeamentos:

```java
@Entity
@Id
@GeneratedValue
```

para saber como persistir esse objeto no banco.

Fluxo:

```text
Pessoa
 ↓
Hibernate
 ↓
SQL
 ↓
PostgreSQL
```

---

# 23. Maven

Maven é utilizado para gerenciar o projeto e suas dependências.

Em vez de baixar `.jar` manualmente:

```text
Maven
 ↓
pom.xml
 ↓
baixa dependências
 ↓
adiciona ao projeto
```

Exemplo:

```xml
<dependency>
    <groupId>org.hibernate.orm</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>7.4.5.Final</version>
</dependency>
```

PostgreSQL:

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.13</version>
</dependency>
```

---

# 24. Hibernate EntityManager

O curso antigo utiliza:

```xml
<artifactId>hibernate-entitymanager</artifactId>
```

porque ele está utilizando Hibernate 5.4.

No Hibernate moderno, como o Hibernate 7, você não precisa adicionar essa dependência antiga separadamente.

---

# 25. JDBC × JPA/Hibernate

## JDBC

No JDBC trabalhamos diretamente com:

```text
Connection
PreparedStatement
ResultSet
SQL
```

Exemplo:

```java
PreparedStatement st =
    conn.prepareStatement(
        "SELECT * FROM seller WHERE id = ?"
    );
```

---

## JPA/Hibernate

Com JPA trabalhamos principalmente com:

```text
@Entity
EntityManager
persist()
find()
remove()
```

O Hibernate cuida de boa parte do SQL.

---

## Relação

```text
JPA
 ↓
Hibernate
 ↓
JDBC
 ↓
PostgreSQL
```

Portanto:

> JPA/Hibernate não elimina o JDBC. O Hibernate utiliza JDBC por baixo.

---

# 26. DAO × JPA

No JDBC você estudou:

```text
DAO
 ↓
PreparedStatement
 ↓
SQL
 ↓
Banco
```

Com JPA:

```text
DAO / Repository
 ↓
EntityManager
 ↓
Hibernate
 ↓
JDBC
 ↓
Banco
```

A ideia de separar o acesso aos dados continua sendo importante.

---

# 27. Contexto de persistência

O `EntityManager` trabalha com um **contexto de persistência**.

Simplificando:

```text
EntityManager
      ↓
Contexto de persistência
      ↓
Entidades gerenciadas
      ↓
Banco
```

O Hibernate acompanha as entidades que estão sendo gerenciadas nesse contexto.

---

# 28. Mapa de identidade

É um conceito relacionado ao contexto de persistência.

O Hibernate mantém referências de objetos que já foram carregados para evitar simplesmente criar várias instâncias diferentes para a mesma entidade dentro do mesmo contexto.

---

# 29. Lazy Loading

**Lazy Loading** significa carregamento tardio.

Uma informação relacionada pode não ser carregada imediatamente.

Ela é carregada somente quando for necessária.

É um conceito importante em relacionamentos JPA/Hibernate.

---

# 30. Estrutura mental

A arquitetura que você precisa guardar:

```text
                 JPA
                  │
          especificação
                  │
                  ▼
              Hibernate
             implementação
                  │
                  ▼
                JDBC
                  │
                  ▼
             PostgreSQL
```

E dentro da aplicação:

```text
Pessoa
  │
  │ @Entity
  ▼
Hibernate
  │
  │ EntityManager
  ▼
Transação
  │
  ▼
PostgreSQL
```

# Resumo final

O mais importante para guardar é:

```text
JPA = especificação
Hibernate = implementação da JPA
JDBC = comunicação com o banco
PostgreSQL = banco de dados
```

E:

```text
@Entity
   ↓
representa uma entidade

@Id
   ↓
chave primária

@GeneratedValue
   ↓
ID gerado automaticamente

EntityManager
   ↓
opera sobre as entidades

EntityManagerFactory
   ↓
cria EntityManager

persistence.xml
   ↓
configura a persistência

persist()
   ↓
salva entidade

commit()
   ↓
confirma transação
```

### Fluxo completo:

```text
Pessoa.java
    ↓
@Entity
    ↓
EntityManager
    ↓
Hibernate
    ↓
JDBC
    ↓
PostgreSQL
```

> **A principal ideia do capítulo:** você deixa de pensar apenas em "mandar SQL para o banco" e passa a trabalhar com **objetos Java que são mapeados para tabelas**, deixando o JPA/Hibernate cuidar da comunicação com o banco.