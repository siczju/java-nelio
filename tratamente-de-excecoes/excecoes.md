# Exceções
    -> Uma exceção é qualquer condição de erro ou comportamento inesperado encontrado por um programa em execução

    -> Em java, uma exceção é um objeto herdado da classe:
        * java.lang.Exception - o compilador obriga a tratar ou propagar 
        * java.lang.RuntimeException - o compilador não obriga a tratar ou propagar (NullPointerException)

    -> Quando lançada, uma exceção é propagada na pilha de chamados de métodos em execução,
        até que seja capturada (tratada) ou o programa seja encerrado

## Porque exceções?
    -> o modelo de tratamento de exceções permite que erros sejam tratados de forma consistente e flexível
        usando boas práticas.
    
    -> Vantagens:
        * Delega a lógica do erro para a classe responsável por conhecer as regras que podem ocasionar o erro
        * Trata de forma organizada (inclusive hierárquica) exceções de tipos diferentes
        * A exceção pode carregar dados quaisquer

## Estrutura try-catch
    
    Bloco try
        -> contém o código que representa a execução normal do trecho de código que pode acarretar em uma exceção  
    
    Bloco catch 
        -> Contém o código a ser executado caso uma exceção ocorra
        -> Deve ser especificado o tipo da exceção a ser tratada (upcasting é permitido)

    Sintaxe:
    try{
    
    }
    catch(ExceptionType e){
    }
    catch(ExceptionType e){
    }

## Pilha de chamada de métodos (stack trace)
    -> Mostra todas as chamadas de métodos que acarretou aquela exceção

## Bloco finally
    -> É um bloco que contém código a ser executado independentemente de ter ocorrido ou não uma exceção
    -> Exemplo clássico: fechar um arquivo, conexão de banco de dados, ou outro recurso específico ao final do processamento
    
    try{
    }
    catch(ExceptionType e){
    }
    finally {
    }

## Propagar exceção
    -> Qnd vc tem um método e dentro dele vc tem uma chamada de um método que pode lançar uma exceção, ou vc tem que tratar
        essa exceção (try-catch) ou propaga a exceção colocando a palavra throws e o nome da exceção
        ex: public static void main(String[] args) throws ParseException {}
        Assim eventualmente um outro método q chamasse esse main teria que tratar essa exceção ou propagar também, ai
        vai pra pilha de chamados (stack trace)

## Criando exceções personalizadas
    -> Criar um pacote de exceções (exceptions) normalmente dentro de model
    -> Posso dar o nome que eu quiser para a minha exceção mas é bom dar um nome que tenha sentido
    -> E no final sempre tem que ter Exception, então: DomainException, SeilaException
    
    -> E essa exceção pode ser uma extensão (herdar) de Exception ou RuntimeException
        -> A diferença é que Exception o compilador obriga você tratar e o RuntimeException o compilador n obriga
    
    -> a classe Exception é seriazable, e toda classe seriazable precisa ter uma versão, como estamos herdando Exception
        precisamos ter uma versão na nossa exception personalizada, podemos colocar só o valor padrão:
        private static final long serialVersionUID = 1L;

    -> Depois disso temos que criar um construtor na nossa exceção que recebe uma mensagem no argumento e damos o 
        super(msg) para repassar essa mensagem para o construtor da superclasse (Exception)

    public class DomainException extends Exception {
        private static final long serialVersionUID = 1L;

        public DomainException(String msg){
            super(msg);
        }

## Vantagens
    -> Lógica delegada
    -> Construtores podem ter tratamento de exceções
    -> Possibilidade de auxílio do compilador (Exception)
    -> Código mais simples. Não há aninhamento de condicionais: a qualquer momento que uma exceção for disparada,
        a execução é interrompida e cai no bloco catch correspondente
    -> É possível capturar inclusive outras exceções de sistema