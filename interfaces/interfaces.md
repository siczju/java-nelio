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