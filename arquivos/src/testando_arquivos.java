import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class testando_arquivos {
    public static void main(String[] args){

        File file = new File("c:\\temp\\in.txt"); // 2 barras pq o barra é o prefixo de caracteres especiais então para colocar uma barra invertida mesmo, tem q colocar duas barras
        // o objeto "file" vai encapsular toda o processo de acessar o arquivo e o caminho do arquivo.
        // temos muitas operações q podemos fazer com o "file"

        // agora temos q instanciar um Scanner apartir do file

        Scanner sc = null;

        // Qnd tento instanciar o Scanner apartir do file o meu programa tenta abrir o arquivo podendo gerar uma exceção IOException
        // assim preciso colocar essa abertura de arquivo dentro de um bloco try

        try{
            sc = new Scanner(file);
            while(sc.hasNextLine()){ // ver se existe uma proxima linha no arquvio
                System.out.println(sc.nextLine()); // vai ler e  imprimir a proxima linha do arquivo
            }
            // sc.close(); poderia fechar o scanner aqui porém se der uma exceção o bloco try sera cortado e essa linha vai ser cortada direto
            // e o scanner não será fechado, então fecho ele no bloco finally
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            // pode ter dado um erro na hora de instanciar no scanner, no caso do scanner nem ter sido instanciado
            // o que daria um erro na hora de fechar ele pois ele esta apontando pra null. então preciso de um if
            if(sc != null)
                sc.close();
        }

    }
}
