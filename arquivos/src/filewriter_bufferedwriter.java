import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class filewriter_bufferedwriter {
    public static void main(String[] args){

        String[] lines = new String[] { "Good morning", "Good afternoon", "Good night"};

        // Criar arquivo e gravar esses dados em "lines" nesse arquivo

        String path = "c:\\temp\\out.txt";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
            for(String line : lines){
                bw.write(line);
                bw.newLine(); // para quebrar linha
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
