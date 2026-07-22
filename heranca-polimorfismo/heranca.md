# Herança

    -> É um tipo de associação que permite que uma classe herde todos dados e comportamentos de outra

    Vantagens: Reuso e Polimorfismo

    Sintaxe: ClassA extends ClassB

    super() -> Para executar a lógica do construtor da classe pai

    Modificador de acesso PROTECTED 
        -> permite o acesso por outra classe do mesmo pacote e por subclasse independente do pacote
    
    -> Quando eu tenho composição entre duas classes, qnd eu instanciar eu vou ter 2 objetos.
        Porém na herança qnd eu instancio uma classe que herda de outra, vou ter um objeto só
        com todos os membros das duas classes.

## Upcasting e Downcasting

    upcasting -> Casting da subclasse para superclasse ou seja 
                 converter uma referência da classe filha para a classe pai.
              -> Uso comum: polimorfismo
    ex: Account acc = new BusinessAccount(); -> Atribui uma subclass para uma superclass
        -> Porém não posso usar os metodos do BusinessAccount pois o tipo do objeto é Account

    downcasting -> casting da superclasse para subclasse
                -> Palavra instanceof
                -> Uso comum: métodos que recebem parâmetros genérico (ex: Equals)
    ex: BusienssAccount acc2 = acc; -> vai dar erro pois não é seguro
        -> Para fazer forçado: BusinessAccount acc2 = (BusinessAccount) acc2;

    class Account {
    }

    class BusinessAccount extends Account {
    }
    
    class SavingsAccount extends Account {
    }
    
    Temos:
    
            Account
            /     \
    Business    Savings
    
    Uma BusinessAccount é uma Account

## Upcasting
    Account acc = new BusinessAccount();
    O que aconteceu? -> O objeto continua sendo um BusinessAccount.
                        Só que agora você está olhando para ele como se fosse um Account.

    Objeto:
    BusinessAccount
    
    Referência:
    Account

###    Por que usar?
        -> Porque normalmente trabalhamos com a classe mais genérica.
    
    Exemplo:
    List<Account> contas = new ArrayList<>();
    contas.add(new BusinessAccount());
    contas.add(new SavingsAccount());
    
    A lista aceita qualquer tipo de conta (Account).

    Outro exemplo:
    
    public void processar(Account conta) {
    }
    
    Agora posso fazer:
    
    processar(new BusinessAccount());
    processar(new SavingsAccount());

    Sem precisar criar vários métodos

###    O que posso acessar?
    
    Somente aquilo que existe em Account.
    
    Account acc = new BusinessAccount();
    
    acc.deposit();
    acc.withdraw();
    
    Mas isso NÃO:
    
    acc.loan(500); // ERRO pois é da classe BusinessAccount
    Mesmo que o objeto seja BusinessAccount, a referência é Account.

## Downcasting (pai → filho)

    Agora é o contrário.
    Você possui uma referência do pai e quer tratá-la como filha.
    Isso precisa ser feito manualmente.
    
    Account acc = new BusinessAccount();
    BusinessAccount b = (BusinessAccount) acc;
    
    Perceba o cast: (BusinessAccount)

###    Por que usar?
    
    Porque às vezes você precisa acessar métodos exclusivos da classe filha.
    
    Exemplo:
    
    BusinessAccount b = (BusinessAccount) acc;
    b.loan(1000);
    
    Agora pode chamar loan().

## Quando dá erro?

    Quando o objeto não é daquele tipo.
    
    Veja:
    
    Account acc = new Account();
    BusinessAccount b = (BusinessAccount) acc;
    
    isso compila mas em execução acontece: ClassCastException
    Porque um Account comum não virou um BusinessAccount.

    Outro exemplo:

    Account acc = new SavingsAccount();
    BusinessAccount b = (BusinessAccount) acc;
    
    Também dá erro porque:
    
    SavingsAccount != BusinessAccount
    
    São irmãos então um nunca pode virar o outro.

### Como evitar o erro?

    Usando instanceof.

    Account acc = new BusinessAccount();

    Objeto: BusinessAccount
    Referência: Account

    if (acc instanceof BusinessAccount) {
        BusinessAccount b = (BusinessAccount) acc;
    }
    
    Assim você só faz o cast se realmente puder.

### Quando usar Upcasting?

    É muito usado em:
        Polimorfismo
        Listas (List<Account>)
        Parâmetros de métodos
        Retornos de métodos
        Frameworks

### Quando usar Downcasting?

    Bem menos.
    
    Normalmente quando você sabe que aquele objeto é de um tipo específico e precisa acessar 
    funcionalidades exclusivas da subclasse.
    
    Em projetos grandes, muitas vezes o uso frequente de downcasting é um sinal de que o design
    pode ser melhorado usando polimorfismo.

### Notas

    Upcasting ->  Account = BusinessAccount -> perde acesso aos métodos da BusinessAccount
    DownCasting -> BusinessAccount = (BusinessAccount) Account -> recupera acesso aos métodos da filha