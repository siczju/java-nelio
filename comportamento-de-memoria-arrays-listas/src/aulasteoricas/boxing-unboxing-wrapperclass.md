# Boxing - Unboxing - Wrapper classes

## Boxing
    -> É o processo de conversão de um objeto tipo valor para um objeto tipo referência compatível
    
    Object -> É uma classe, é a classe padrão onde todas classes variam dela

    int x = 20;
    Object obj = x;

## Unboxing
    -> É o processo de conversão de um objeto tipo referência para um objeto tipo valor compatível

    int x = 20;
    Object obj = 20;
    int y = (int) obj;

# Wrapper classes
    -> Classes equivalentes aos tipos primitivos
    -> Para cada tipo primitivo no java tem um tipo classe compátivel com esse tipo.
    ex:
        * boolean -> Boolean
        * char -> Character
        * int -> Integer
        * double -> Double
    
    -> Serve para que seja feito o boxing/unboxing de maneira natural
    -> E também porque o Wrapper class aceita valor nulo e podemos usar as vantagens de POO em tipos primitivos
    -> Possuem métodos úteis, como conversão e comparação (parseInt(), compareTo(), etc.).