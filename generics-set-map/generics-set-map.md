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