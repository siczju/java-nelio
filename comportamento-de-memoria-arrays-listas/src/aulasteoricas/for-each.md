## For each
    -> Sintaxe opcional e simplificada para percorrer coleções
    -> Não precisa de índice (i).
    -> Ideal quando apenas deseja ler os elementos.

    for(Tipo apelido : coleção){
    }
    
    ex: 
    String[] nomes = {"Ana", "João", "Maria"};

    for (String nome : nomes) {
    System.out.println(nome);
    }