import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class filereader_bufferedreader {
    public static void main(String[] args){

        /*
        String path = "c:\\temp\\in.txt";
        FileReader fr = null;
        BufferedReader br = null;

        -> FORMA ANTIGA, AGORA VOU MOSTRAR COM TRY-WITH-RESOURCES que é mt melhor pra mexer
                com streams, invés de abrir e fechar manualmente essas streams
        try{
            fr = new FileReader(path);
            br = new BufferedReader(fr); // instancio dando como argumento a stream básica
            // ou: br = new BufferedReader(new FileReader(path));

            String line = br.readLine(); // le uma linha do arquivo, se o arquivo ja estiver no final, o readline vai retornar nulo

            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
            }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
            }
        finally {
            // tenho que abrir outro bloco try pois pode dar uma exception na hora de fechar os streams tb
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            }
            catch(IOException e){
                e.printStackTrace();
        }
        }
         */

        // bloco try-with-resources -> é um bloco try que declara um ou mais recursos que garante
        // que esses recursos serão fechados ao final do bloco

        String path = "c:\\temp\\in.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}
