package testandoGenericsComparator;

import java.util.ArrayList;
import java.util.List;

public class Fruta<T> implements Comparable<Fruta> {
    public int valor;
    public String nome;
    public List<T> lista = new ArrayList<>();

    public Fruta() {
    }

    public Fruta(int valor, String nome) {
        this.valor = valor;
        this.nome = nome;
    }

    public Fruta(int valor) {
        this.valor = valor;
    }

    public void adicionar(T generico){
        lista.add(generico);
    }

    public T primeiro(){
        return lista.get(0);
    }

    @Override
    public int compareTo(Fruta o) {
        return Integer.compare(o.valor, this.valor);

        /*
        if(this.valor > o.valor)
            return 1;
        if(this.valor < o.valor)
            return -1;

        return 0;

        OU

        return this.valor - o.valor; // ordem crescente
        return o.valor - this.valor; // // ordem decrescente

        OU

        return Integer.compare(this.valor, o.valor); // ordem crescente
        return Integer.compare(o.valor, this.valor); // ordem decrescente
         */
    }

}
