# Polimorfismo
    
    -> Em programação Orientada a Objetos, polimorfismo é um recurso que permite que variáveis de um mesmo
        tipo mais genérico possam possam apontar para objetos de tipos específicos diferentes, tendo assim
        comportamentos diferentes conforme cada tipo específico.
    -> Ou seja variáveis do mesmo tipo se comportando de forma diferente
    
    Account x = new Account(1020, "Alex");
    Account y = new SavingsAccount(1023, "Maria", 0.01);
    
    -> Métodos com mesmo nome porém com diferentes comportamentos
    x.withdraw(50.0);
    y.withdraw(50.0);