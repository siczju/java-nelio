import java.util.Locale;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Formatar: toLowerCase(transforma em minuscula), ToUpperCase(transforma em maiuscula), trim(remove espacos);
        // Recortar: substring(inicio), substring(inicio, fim)
        // Substituir: Replace(char, char), Replace(string, stirng)
        // Buscar: IndexOf, LastIndexOf
        // Recortar em um array: str.Split(" ")
        // Casas decimais: String.format("%.2f", variavel);
        String original = "abcde FGHIJ ABC abc DEFG   ";

        // Converter para letras minusculas
        String minusculas = original.toLowerCase();

        // Converter para letras maiucuslas
        String maiusculas = original.toUpperCase();

        // Mantém a string original porém sem os espaços em brancos nos cantos da string (começo e fim)
        String trim = original.trim();

        // Recorta a string do index 2 em diante, então se era "abcde" vira "cde"
        String substring = original.substring(2);

        // Recorta a string apartir do 2 porém abaixo do caractere 9, então se era "abcdefghijk" fica "cdefghi"
        // sendo c o index 2 e o j o index 9
        String substring2 = original.substring(2, 9);

        // Sempre que achar um 'a' troque por 'x', mas também funciona com string por exemplo: ("abc", "efg")
        String replace = original.replace('a', 'x');

        // Qual a primeira posição do "bc"? (indexOf), "abcd" nesse caso é na posição 1
        int indexof = original.indexOf("bc");

        // Qual a ultima posição de ocorrência "bc"? (lastIndexOf), então vai procurar a ultima posição q aparece o "bc"
        int lastindexof = original.lastIndexOf("bc");

        // Recortar meu string em um array (Split)
        String[] vect = original.split(" ");
        String abc1 = vect[0];
        String abc2 = vect[1];

        // Limitando para 2 casas decimais: String.Format("%.2f", variavel);
        float num = 12.2323f;
        System.out.println("Float: " + String.format("%.2f", num));

        System.out.println("Original: -" + original + "-");
        System.out.println("toLowerCase: -" + minusculas + "-");
        System.out.println("toUpperCase: -" + maiusculas + "-");
        System.out.println("trim: -" + trim + "-");
        System.out.println("substring(2): -" + substring + "-");
        System.out.println("substring(2,9): -" + substring2 + "-");
        System.out.println("replace(a,x): -" + replace + "-");
        System.out.println("indexOf(\"bc\"): -" + indexof + "-");
        System.out.println("lastIndexOf(\"bc\"): -" + lastindexof + "-");
        System.out.println("split(\" \"): -" + abc1 + " " + abc2 + "-");
    }
}