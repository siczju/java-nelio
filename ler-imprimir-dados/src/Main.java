import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US); // Definir separador de numeros como ponto

        // Entrada de dados
        Scanner sc = new Scanner(System.in);

        // Ler um texto sem espaços:
        // String x = sc.next();

        // Ler um numero inteiro
        // int y = sc.nextInt();

        // Ler numero flutuante
        // double z = sc.nextDouble();

        // Ler um caractere
        //char c = sc.next().charAt(0); // charAt pega o primeiro caractere da sua string

        // Ler texto até a quebra de linha
        // String s = sc.nextLine();

        int i = sc.nextInt();
        sc.nextLine(); // Para consumir a quebra de linha do nextInt.
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();

        System.out.println(i);
        System.out.print(s1 + "\n"); // imprime sem pular linha.
        System.out.println(s2); // imprime e pula para a próxima linha.
        System.out.printf("%s", s3); // imprime com formatação (%s, %d, %.2f, etc.).

        sc.close();
    }
}