package testandoGenerics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Fruta<String> prints = new Fruta<>();

        List<Fruta<String>> list = new ArrayList<>();
        FrutaComparatorNome fNome = new FrutaComparatorNome();
        FrutaComparatorValor fValor = new FrutaComparatorValor();

        list.add(new Fruta<>(5, "Banana"));
        list.add(new Fruta<>(3, "Maça"));
        list.add(new Fruta<>(10, "Jabuticaba"));
        list.add(new Fruta<>(132, "Amora"));

        //Collections.sort(list); // Comparable
        //Collections.sort(list, fValor); // Classe Comparator
        Collections.sort(list, fNome); // Classe Comparator

        for(Fruta print : list)
            System.out.print(print.valor + ", " + print.nome + "\n");

        if(new FrutaComparatorValor().compare(list.get(0), list.get(1)) > 0){
            System.out.println("Banana é mais cara que a maça");
        }

    }
}
