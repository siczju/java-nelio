import java.io.File;
import java.util.Scanner;

public class manipulando_pastas_com_file {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a folder path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        // pegar todas as pastas apartir de determinado caminho (path), e imprimir

        File[] folders = path.listFiles(File::isDirectory); // Listar somente quem é pasta

        System.out.println("FOLDERS:");

        for(File folder : folders){
            System.out.println(folder);
        }

        File[] files = path.listFiles(File::isFile);

        System.out.println("FILES: ");
        for (File file : files)
            System.out.println(file);

        boolean sucess = new File(strPath + "\\subdir").mkdir(); // criar uma subpasta dentro do \temp
        System.out.println("Directory created sucessfully: " + sucess);

        sc.close();
    }
}
