package testandoGenerics;

import java.util.Comparator;

public class FrutaComparatorValor implements Comparator<Fruta> {

    public int compare(Fruta p, Fruta p2){
        return p.valor - p2.valor;
    }
}
