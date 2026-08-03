package testandoGenericsComparator;

import java.util.Comparator;

public class FrutaComparatorNome implements Comparator<Fruta> {

    public int compare(Fruta f, Fruta f1){
        return f.nome.compareTo(f1.nome);
    }

}
