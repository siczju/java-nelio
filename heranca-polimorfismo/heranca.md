# Herança

## O que é?

É um tipo de associação que permite que uma classe herde os atributos e comportamentos de outra.

### Vantagens

- Reuso de código
- Polimorfismo

### Sintaxe

```java
class ClassA extends ClassB {
}
```

### `super()`

Utilizado para executar o construtor da classe pai.

```java
public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
    super(number, holder, balance);
    this.loanLimit = loanLimit;
}
```

### Modificador de acesso `protected`

Permite acesso:

- Pela própria classe
- Por classes do mesmo pacote
- Por subclasses, mesmo que estejam em outro pacote

### Herança x Composição

#### Composição

Ao instanciar uma classe que possui outra por composição, existem **dois objetos**.

```text
Pessoa
 └── Endereco
```

```
Pessoa  ----------> Objeto Pessoa
Endereco ---------> Objeto Endereco
```

---

#### Herança

Ao instanciar uma subclasse existe **apenas um objeto**, contendo os membros da classe pai e da classe filha.

```java
BusinessAccount b = new BusinessAccount();
```

```
Objeto BusinessAccount

+ membros de Account
+ membros de BusinessAccount
```

---

# Upcasting e Downcasting

## Classe de exemplo

```java
class Account {
}

class BusinessAccount extends Account {
}

class SavingsAccount extends Account {
}
```

Hierarquia:

```
        Account
        /     \
BusinessAccount  SavingsAccount
```

Uma **BusinessAccount é uma Account**.

---

# Upcasting

## O que é?

Conversão de uma referência da **subclasse** para a **superclasse**.

É feito automaticamente.

```java
Account acc = new BusinessAccount();
```

ou

```java
BusinessAccount b = new BusinessAccount();
Account acc = b;
```

---

## O que aconteceu?

O objeto continua sendo um **BusinessAccount**.

Apenas a referência passou a ser do tipo **Account**.

```
Objeto:
BusinessAccount

Referência:
Account
```

---

## Por que usar?

Porque normalmente trabalhamos com a classe mais genérica.

Exemplo:

```java
List<Account> contas = new ArrayList<>();

contas.add(new BusinessAccount());
contas.add(new SavingsAccount());
```

A lista aceita qualquer tipo de conta.

Outro exemplo:

```java
public void processar(Account conta) {
}
```

Agora posso fazer:

```java
processar(new BusinessAccount());
processar(new SavingsAccount());
```

Sem precisar criar vários métodos.

---

## O que posso acessar?

Somente os membros existentes em `Account`.

```java
Account acc = new BusinessAccount();

acc.deposit();
acc.withdraw();
```

Isso **não** funciona:

```java
acc.loan(500);
```

❌ Erro de compilação.

Mesmo que o objeto seja um `BusinessAccount`, a referência é do tipo `Account`.

---

# Downcasting

## O que é?

Conversão da referência da **superclasse** para a **subclasse**.

Precisa ser feita manualmente.

```java
Account acc = new BusinessAccount();

BusinessAccount b = (BusinessAccount) acc;
```

Observe o cast:

```java
(BusinessAccount)
```

---

## Por que usar?

Quando é necessário acessar métodos exclusivos da subclasse.

```java
BusinessAccount b = (BusinessAccount) acc;

b.loan(1000);
```

Agora é possível utilizar `loan()`.

---

# Quando ocorre erro?

Quando o objeto **não é realmente** daquele tipo.

Exemplo:

```java
Account acc = new Account();

BusinessAccount b = (BusinessAccount) acc;
```

Compila normalmente.

Porém, em tempo de execução ocorre:

```text
ClassCastException
```

Porque um objeto `Account` **não é** um `BusinessAccount`.

---

Outro exemplo:

```java
Account acc = new SavingsAccount();

BusinessAccount b = (BusinessAccount) acc;
```

Também gera:

```text
ClassCastException
```

Porque:

```
SavingsAccount ≠ BusinessAccount
```

São subclasses diferentes (irmãs).

---

# Como evitar o erro?

Utilizando `instanceof`.

```java
if (acc instanceof BusinessAccount) {

    BusinessAccount b = (BusinessAccount) acc;

}
```

Assim o cast só será realizado quando realmente for seguro.

---

# Quando usar Upcasting?

É extremamente comum.

Usado em:

- Polimorfismo
- `List<Account>`
- Parâmetros de métodos
- Retorno de métodos
- Frameworks

---

# Quando usar Downcasting?

Muito menos frequente.

É utilizado quando sabemos que o objeto pertence a uma determinada subclasse e precisamos acessar funcionalidades específicas dela.

Se um projeto utiliza downcasting constantemente, normalmente isso indica que o polimorfismo poderia ter sido melhor aproveitado.

---

# Resumo

| Upcasting | Downcasting |
|-----------|-------------|
| Filho → Pai | Pai → Filho |
| Automático | Precisa de cast `( )` |
| Sempre seguro | Pode gerar `ClassCastException` |
| Muito utilizado | Pouco utilizado |
| Perde acesso aos métodos específicos da filha | Recupera acesso aos métodos da filha |

---

# Entendendo na memória

## Classe utilizada

```java
class Account {

    public void withdraw() {
        System.out.println("Saque");
    }

}

class BusinessAccount extends Account {

    public void loan() {
        System.out.println("Empréstimo");
    }

}
```

---

## 1. Criando um objeto

```java
BusinessAccount b = new BusinessAccount();
```

Na memória:

```text
Stack (referências)             Heap (objetos)

b ---------------------------> BusinessAccount
                                 + withdraw()
                                 + loan()
```

Como a referência também é `BusinessAccount`, podemos acessar tudo.

```java
b.withdraw();
b.loan();
```

---

## 2. Fazendo Upcasting

```java
Account acc = b;
```

Agora temos:

```text
Stack                           Heap

b --------┐
          │
          ▼
acc ------> BusinessAccount
             + withdraw()
             + loan()
```

Observe:

- Existem **duas referências**.
- Ambas apontam para **o mesmo objeto**.
- O objeto continua sendo um `BusinessAccount`.

Podemos fazer:

```java
acc.withdraw();
```

Mas:

```java
acc.loan();
```

❌ Erro de compilação.

O compilador olha para o **tipo da referência (`Account`)**, não para o objeto.

---

## 3. Fazendo Downcasting

```java
BusinessAccount b2 = (BusinessAccount) acc;
```

Agora:

```text
Stack                           Heap

b --------┐
          │
acc ------┼---------------------> BusinessAccount
          │
b2 -------┘
```

Agora existem **três referências** apontando para o mesmo objeto.

Como `b2` é um `BusinessAccount`, podemos acessar:

```java
b2.withdraw();
b2.loan();
```

Nenhum objeto foi criado.

Nenhum objeto foi copiado.

Apenas foi criada uma nova referência.

---

## 4. Downcasting inválido

```java
Account acc = new Account();

BusinessAccount b = (BusinessAccount) acc;
```

Na memória:

```text
Stack                           Heap

acc ---------------------------> Account
                                  + withdraw()
```

O compilador aceita.

Em execução ocorre:

```text
ClassCastException
```

Porque o objeto é um `Account`, e não um `BusinessAccount`.

---

## 5. Outro erro

```java
Account acc = new SavingsAccount();

BusinessAccount b = (BusinessAccount) acc;
```

Na memória:

```text
Stack                           Heap

acc ---------------------------> SavingsAccount
```

O objeto é um `SavingsAccount`.

Você tentou tratá-lo como `BusinessAccount`.

Resultado:

```text
ClassCastException
```

---

## 6. Como evitar

```java
if (acc instanceof BusinessAccount) {

    BusinessAccount b = (BusinessAccount) acc;

}
```

`instanceof` verifica o tipo real do objeto antes do cast.

---

# O desenho mais importante

## Antes do Upcasting

```text
BusinessAccount b
        │
        ▼
+----------------------+
| BusinessAccount      |
|----------------------|
| withdraw()           |
| loan()               |
+----------------------+
```

---

## Depois do Upcasting

```text
BusinessAccount b ───┐
                     │
Account acc ─────────┤
                     ▼
            +----------------------+
            | BusinessAccount      |
            |----------------------|
            | withdraw()           |
            | loan()               |
            +----------------------+
```

O objeto continua exatamente o mesmo.

---

## Depois do Downcasting

```text
BusinessAccount b ───┐
                     │
Account acc ─────────┤
                     │
BusinessAccount b2 ──┤
                     ▼
            +----------------------+
            | BusinessAccount      |
            |----------------------|
            | withdraw()           |
            | loan()               |
            +----------------------+
```

Continuamos tendo **um único objeto**, apenas com mais referências apontando para ele.

---

# Regra de ouro

> **O cast nunca altera o objeto.**

Ele apenas muda **o tipo da referência**.

O objeto continua sendo exatamente o mesmo na memória.

---

# Macete para decorar

```
Aluno é uma Pessoa.
```

Logo:

```java
Pessoa p = new Aluno();
```

✔ Upcasting (sempre seguro)

Agora:

```java
Aluno a = (Aluno) p;
```

Só funciona se `p` realmente apontar para um objeto `Aluno`.

Caso contrário:

```text
ClassCastException
```