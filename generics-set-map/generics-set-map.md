# Generics
    -> Permitem criar classes, métodos e interfaces que funcionam com qualquer tipo de dado.
    -> Evitam castings desnecessários e aumentam a segurança de tipos em tempo de compilação.

Exemplo:
```java
List<String> nomes = new ArrayList<>();
```

# Generics Delimitados (Bounded Generics)
    -> Restringem quais tipos podem ser usados em um genérico usando `extends`.

Exemplo:
```java
<T extends Comparable<T>>
```

Significa:
    - `T` pode ser qualquer tipo, desde que implemente `Comparable`.

Uso:
    - Quando o método precisa utilizar funcionalidades específicas do tipo (como `compareTo()`).

---

# Comparable

    -> Interface usada para definir a ordem natural de uma classe.
    -> A própria classe define como será comparada.

Método obrigatório:
```java
compareTo(T outro)
```

Retorno:
- `< 0` → menor
- `0` → igual
- `> 0` → maior

Uso:
- `Collections.sort()`
- `Arrays.sort()`
- Métodos como `max()`

Exemplo:
```java
class Produto implements Comparable<Produto>
```

---

# Comparator

    -> Interface usada para criar regras de comparação externas à classe.
    -> Permite ordenar o mesmo objeto de diferentes formas.

Método:
```java
compare(T o1, T o2)
```

Uso:
- Ordenar por nome, preço, idade, etc., sem alterar a classe.

Exemplo:
```java
Collections.sort(lista, comparator);
```

---

# Comparable x Comparator

| Comparable | Comparator |
|------------|------------|
| Comparação dentro da classe | Comparação fora da classe |
| Método `compareTo()` | Método `compare()` |
| Um critério de ordenação | Vários critérios de ordenação |
| Implementado pela própria classe | Implementado em outra classe |

## Tipos Curingas (wildcard types)

    -> Generics são invariantes.
    List<Object> -> não é o supertipo de qualqeur tipo de lista
    

```java
    List<Object> myObjs = new ArrayList<Object>();
    List<Integer> myNumbers = new ArrayList<Integer>();
    myObjs = myNumbers; // erro de compilação
```    

    -> O supertipo de qualqeur tipo de lista é List<?>. Este é um tipo curinga:

```java
    List<?> myObjs = new ArrayList<Object>();
    List<Integer> myNumbers = new ArrayList<Integer>();
    myObjs = myNumbers; // funciona 
```    

    -> Com tipos curinga podemos fazer métodos que recebem um genérico de "qualquer tipo"

```java

    public ... main(){
        List<Integer> myInts = Arrays.asList(5,2,10);
        printList(myInts);
    }
    
    public static void printList(List<?> list){
        for(Object obj : list){
            System.out.println(obj);
        }
    }

```

    -> Porém não é possível adicionar dadosa a uma coleção de tipo curinga

```java
    List<?> list = new ArrayList<>();
    list.add(3); // erro de compilação
```

## Curingas delimitados (bounded wildcards)

```java

    public static double totalArea(List<Pessoa> list){}
    // Se receber uma lista de um subtipo de Pessoa, da erro.
    
    public static double totalArea(List<? extends Pessoa> list){} 
    // Agora posso receber uma lista de Pessoas ou de qualquer tipo q extenda de Pessoa

```

    -> porém  continuamos sem conseguir adicionar elementos a essa lista. que seja do tipo <?>

## Hashcode e Equals
    -> São operações da classe Object utilizadas para comparasr se um objeto é
        igual ao outro

    -> equals: lento, resposta 100%
    -> hashCode: rápido, porém resposta positiva não é 100%

    -> Tipos comuns (String, Date, Integer, Double, etc.) já possuem implementação
        para essas operações. Classes personalizadas precisam sobrepô-las.

    Equals:
        -> método que compara se o objeto é igual ao outro, retornando true/falso
    
    String a = "Maria";
    String b = "Alex";
    System.out.println(a.equals(b)); -> retorna false

    hashCode:
        -> Método que retorna um número inteiro representando um código gerado
            a partir das informações do objeto

    String a = "Maria";
    String b = "Alex";
     System.out.println(a.hashCode()); -> retorna 12312
     System.out.println(b.hashCode()); -> retorna 41233

    -> porém se forem objetos iguais vão retornar o mesmo código
    -> Mas posso ter objetos diferentes q coincidentemente geraram o mesmo hashcode
    -> Mas não acontece do mesmo objeto gerar códigos diferentes

## Set<T> -> Interface
    -> Representa um conjunto de elementos 
    -> Não admite repetições
    -> Elementos não possuem posição
    -> Acesso, inserção e remoção de elementos são rápidos
    -> Oferece operações eficientes de conjunto: interseção, união, diferença
    -> Principais implementações:
        -> HashSet -> mais rápido (operações O(1) em tabela hash) e não ordenado
        -> TreeSet -> mais lento (operações O(log(n)) em árvore rubro-negra)
                        e ordenadoo pelo compareTo do objeto (ou Comparator)
        -> LinkedhashSet -> velocidade intermediária e elementos na ordem em 
                            que são adicionados 

    Métodos importantes
        -> add(obj), remove(obj), contains(obj)
        (Baseado em equals e hashCode.)
        (Se equals e hashCode não existir, é usada comparação de ponteiros.)
    -> clear(), size(), removeIf(predicate)
    -> addAll(other) - união: adiciona no conjunto os elementos do outro conjunto, 
        Ssem repetição
    -> retainAll(other) - interseção: remove do conjunto os elementos não contidos
        em other. Ou seja so elementos em comum
    -> removeAll(other) - diferença: remove do conjunto os elementos contidos
        em other

```java

    Set<String> set = new HashSet<>();
    
    set.add("TV");
    set.add("Notebook");
    set.add("Tablet");
    
    System.out.println(set.contains("Notebook"));
    
    for(String p : set){
        System.out.println(p)
            }
```

    Como o set testam igualdade?
        -> Se hashCode e equals estiverem implementados:
            * Primeiro hashCode. Se der igual, usa equals para confirmar.
            * Lembre-se: String, Integer, Double, etc. Ja possuem equals/hashCode
        -> Se hashCode e equals não estiverem implementados:
            * Compara as referências (ponteiros) dos objetos.

    Como o TreeSet compara os elementos?
        -> Com o compareTo, então a classe que estiver sendo generalizada pelo TreeSet
        ex: Set<Product> set = new TreeSet<>();
        -> Esse Product, ele obrigatoriamente tem que implementar Comparable<T>

## Map<K,V>

    -> É uma coleção de pares chave/valor -> onde chave/valor podem ser de qualquer tipo
        * Não admite repetições do objeto chave
        * Os elementos são indexados pelo objeto chave (não possuem posição)
        * Acesso, inserção e remoção de elementos são rápidos

    -> Uso comum: cookies, local storage, qualquer modelo chave-valor

    -> Principais implementações:
        * HashMap - mais rápido (operações O(1) em tabela hash) e não ordenado
        * TreeMap - mais lento (operações O(log(n)) em àrevore rubro-negra) e ordenado pelo
                    compareTo do objeto (ou Comparator)
        * LinkedHashMap - velocidade intermediária e elementos na ordem em que são adicionadas

    -> Alguns métodos importantes:
        * put(key, value) serve para inserir, remove(key), containsKey(key), get(key)
            -> baseado em equals e hashcode
            -> se equals e hashcode não existir, é usada comparação de ponteiros (referencia)
        * clear(), size().
        * keySet() - retorna um Set<K> (lista de elementos) com as chaves do Map
        * values() - retorna um Collection<V> (lista de elementos) com os valores do meu Map

```java -> para percorrer um Map (supondo que a chave é tipo string e o map chama cookiesMap)
    
    for(String key : cookiesMap.keySet()){
        
            }

```