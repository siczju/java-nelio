# Sobreposição (sobrescrita), super(), final, @Override

## Sobreposição (sobrescrita)
    -> É a implementação de um método de uma superclasse na subclasse

    -> é fortemente recomendavel usar anotação @Override em um método sobrescrito
        -> Pois facilita a leitura e compreensão do código
        -> E avisamos ao compilador (boa prática)

## Super()
    -> É possível chamar a implementação da superclasse usando a palavra super.

    ex: suponha que na classe BusinessAccount a regra para saque seja realizar o saque normalmente da superclasse
        e descontar mais 2.0 

    @Override
    public void withdraw(double amount){
        super.withdraw(amount);
        balance -= 2.0;
    }

## Final
    Palavra chave: final

    Classe: evita que a classe seja herdada
    ex: public final class SavingsAccount

    Método: evita que o método sob seja sobreposto[

    Pra que? 
        -> Segurança: dependendo da regra de negócio, as vezes é desejavel garantir que uma classe 
            não seja herdada, ou que um metodo não seja sobrescrito
            (geralmente convem acrescentar final em metodos sobrespostos pois sobreposições multiplas
             podem ser uma porta de entrada para inconsistencias)

        -> Performance: atributos de tiop de uma classe final são analisados de forma mais rápida em tempo
            de execução.