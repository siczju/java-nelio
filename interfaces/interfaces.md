# Interfaces
    -> Interface é um tipo que define um conjunto de operações que
        uma classe deve implementar
    -> A interface estabelece um contrato que a classe deve cumprir
    -> Pra que? Para criar sistemas com baixo acoplamento e flexíveis.
    -> As interfaces podem ter default methods / defender methods

```java
    interface Shape {
        double area();
        double perimeter();
}
```

##  Inversão de controle e injeção de dependência

    Inversão de controle -> Padrão de desenvolvimento que consiste
        em retirar da classe a responsabilidade de instanciar suas
        dependências.

    Injeção de dependência -> É uma forma de realizar a inversão de
        controle: um componente externo instancia a dependência, que
        é então injetada no objeto "pai". Pode ser implementada de
        várias formas: Construtor, Classe de instanciação (builder
         / factory) e Container/Framework

### Injeção de dependência por construtor

## Exemplo

```java
RentalService rentalService =
    new RentalService(
        pricePerHour,
        pricePerDay,
        new BrazilTaxService()
    );
```

No construtor:

```java
class RentalService {

    private TaxService taxService;

    public RentalService(
        double pricePerHour,
        double pricePerDay,
        TaxService taxService) {

        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }
}

- `BrazilTaxService` implementa (ou herda de) `TaxService`.
- Ao passar `new BrazilTaxService()` para o construtor, ocorre um **upcasting**.
- O construtor recebe um objeto do tipo **TaxService**, mas o objeto real continua sendo um **BrazilTaxService**.
- Isso é chamado de **injeção de dependência por construtor**, pois a dependência (`TaxService`) é fornecida de fora da classe, em vez de ser criada dentro dela.

### Vantagem

A `RentalService` fica desacoplada da implementação concreta.

Hoje:

```java
new BrazilTaxService()
```

Amanhã basta trocar por:

```java
new USATaxService()
```

ou

```java
new EuropeTaxService()
```

Sem alterar nenhuma linha da classe `RentalService`.

> **Resumo:** A classe depende da abstração (`TaxService`), e não da implementação (`BrazilTaxService`). Isso deixa o código mais flexível, reutilizável e facilita a manutenção.

## Herdar vs Cumprir contrato 

    Em ambos os casos eu tenho uma relação "é-um", polimorfismo e o conceito de generalização/especialização
    
    Diferença:
        Herança -> reuso de informações e comportamentos
        Interface -> contrato a ser cumprido

## Herança multipla e o problema do diamante
    -> A herança multipla pode gera o problema do diamante: uma ambiguidade causada pela
        existência do mesmo método em mais de uma superclasse
    -> Herança múltipla não é permitida na maioria das linguagens

## Interface Comparable
    
```java
public interface Comparable<T>{
    int compareTo(T o);
}
```

## Default methods (Defender methods)
    -> Interfaces podem conter métodos concretos
    -> A intenção básica é prover implementação padrão para métodos, de modo a evitar:
        1) repetição de implementação em toda classe que implemente a interface
        2) a necessidade de se criar classes abstratas para prover reuso de implementação

    Outras vantagens:
        * Manter a retrocompatibilidade com sistemas existentes
        * Permitir que "interfaces funcionais" (que devem conter apenas um método)
            possam prover operações padrão reutilizaveis

```java
public interface InteresetServices{
    default double getInterestRate(){
        return payment();
    }
    double payment(double amount, int months);
}
```

    Agora as interfaces podem prover reuso
    Ainda é mt diferente de classe abstrata pois interface não possuem recursos tais como construtores e atributos