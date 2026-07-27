package projeto_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.println("Enter file path: ");
        // String path = "c:\\temp\\input.csv";
        String path = sc.nextLine();

        File sourceFile = new File(path);
        File sourceFolder = new File(sourceFile.getParent());

        boolean success = new File(sourceFolder + "\\out").mkdir(); // criar pasta out

        System.out.println("Folder out created: " + success);

        String fileSummary = sourceFolder + "\\out\\summary.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(sourceFile))){
            String itemCsv = br.readLine();
            while(itemCsv != null) {
                String[] lines = itemCsv.split(",");

                String name = lines[0];
                double price = Double.parseDouble(lines[1]);
                int quantity = Integer.parseInt((lines[2]));

                list.add(new Product(name, price, quantity));
                itemCsv = br.readLine();
            }

            try(BufferedWriter fw = new BufferedWriter(new FileWriter(fileSummary))){
                for(Product prod : list){
                    fw.write(prod.toString());
                    fw.newLine();
                }
                System.out.println("SUMMARY CREATED");
            }
            catch (IOException e){
                System.out.println("Error: " + e.getMessage());
            }

        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }


        sc.close();
    }
}
