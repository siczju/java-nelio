# Tipo referência VS Tipo valor

    Variáveie que são do tipo classes são ponteiros 

    Product p1, p2; -> alocadas na memória stack
    p1 = new Product("tv", 900, 0) -> o objeto é alocado na memória heap (alocação dinâmica)

    Então p1 é um ponteiro (stack) que guarda o endereço do objeto (heap) (new Project...) 

    p2 = p1; -> p2 vai passar apontar para onde p1 aponta, então o p2 vai apontar para o mesmo objeto.
    ou seja vao guardar o mesmo endereço

    tipos referência aceitam o valor "null" que indica que a variável não aponta para ninguém.
    p2 = null;

    Tipos primitivos são tipo valor ou seja são caixas de memória na memória que guardam um valor invés de uma referência

    Valores padrão -> qnd alocamos (new) qualquer tipo estruturado (classe ou array) são atribuídos valores padrões
    aos seus elementos
        Números: 0
        Booleans: false
        Char: caractere código 0
        Objeto: null

    Tipos referência (classe) -> objetos não utilizados são desalocados em um momento próximo pelo garbage collector
    Tipos valor (primitivos) -> São desalocados imediatamente quando seu escopo de execução é finalizado