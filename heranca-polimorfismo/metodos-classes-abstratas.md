# Classes abstratas e métodos abstratos

## Classes abstratas
    -> São classes que não podem ser instanciadas
    -> É uma forma de garantir herança total: somente subclasses não abstratas podem ser
        instanciadas, mas nunca a superclasse abstrata

    public abstract class Account {}

    Se a classe n pode ser instanciada pq criar ela?
     * Reuso
     * Polimorfismo: a superclasse genérica nos permite tratar de forma fácil e uniforme todos os tipos
       de conta, inclusive com polimorfismo se for o caso. Por exemplo se vc quiser colocar todos os tipos
       de contas em uma mesma coleção.

## Métodos abstratos
    -> São métodos que não possuem implementação.
    -> Métodos precisam ser abstratos quando a classe é genérica demais para conter sua implementação
    -> se uma classe possuir pelo menos um método abstrato então esta classe também é abstrata

    public abstract double area();