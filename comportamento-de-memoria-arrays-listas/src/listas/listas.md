# Listas
    ->  Lista é uma estrutura de dados, que guarda dados do mesmo tipo, 
        De forma ordenada (elementos acessados por meio de posições (index -> 0,1,2..), 
        Ela inicia vazia e seus elementos são alocados por demanda,
        E cada elemento ocupa um nó ou nodo da lista

    -> Tipo (interface): List
        Então se um tipo é interface, ele só especifica as operações, então precisamos
        de uma classe que implemente essa interface. E não posso instanciar uma interface.
        Classes que implementam List: ArrayList, LinkedList, etc..
    
    -> Vantagens: Tamanho variável, Facilidade para se realizar inserções e deleções
    -> Desvantagens: Acesso sequencial aos elementos

    ArrayList -> É uma mistura de Array com List otimizada, onde minimiza as desvantagens dos dois
        e maximiza todas as vantagens

    * Tamanho da Lista: size()

    * Inserir elemento na lista: add(obj), add(int,obj)
        Onde add(int, obj) o int é o index

    * Remover elementos da lista: remove(obj), remove(int), removeIf(Predicate)
        list.remove("Anna"); -> remove por meio da comparação do valor
        list.remove(1); -> remove pelo index
        list.removeIf(x -> x.charAt(0) == 'M'); -> remove pelo predicado, quem o nome começa com M
            Onde diz: pega o valor "x" do tipo String e remove TODOS que o x.CharAt(0) é igual a M

    * Encontrar posição de elemento: indexOf(obj), lastIndexOf(obj)
        list.indexOf("Bob"); -> procura por valor, e se não encontrar retorna -1

    * Filtrar lista com base em predicado: 
        List<Integer> result = list.stream().filter(x -> x > 4).collect(Collectors.toList());
            -> Primeiro ele pega a lista, transforma em stream, faz a filtragem via lambda e 
                depois transforma em list dnv.
            -> E vai retornar uma lista só com numeros maiores que 4

    * Encontrar primeira ocorrência com base em predicado:
        Integer result = list.stream().filter(x -> x > 4).findFirst().orElse(null);

    -> A lista não aceita tipos primitivos, ex: List<int>, e sim wrapper class List<Integer>
        List<String> list = new ArrayList<>();

    -> Assuntos pendentes: interfaces, generics, predicados (lambda)