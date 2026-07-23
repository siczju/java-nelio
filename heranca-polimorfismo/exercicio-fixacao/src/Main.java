import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int productsNumber = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= productsNumber; i++){
            System.out.println("Product #" + i + ": ");
            System.out.print("Common, used or imported (c/u/i)? ");
            char choose = sc.next().charAt(0);
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            Double price = sc.nextDouble();
            sc.nextLine();

            if(choose == 'i'){
                System.out.print("Customs fee: ");
                Double customsFee = sc.nextDouble();
                productList.add(new ImportedProduct(name, price, customsFee));
            }
            else if (choose == 'u'){
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String date = sc.nextLine();
                productList.add(new UsedProduct(name, price, LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            }
            else
                productList.add(new Product(name, price));
        }

        System.out.println("\nPRICE TAGS:");
        for(Product prod : productList){
            System.out.println(prod.priceTag());
        }

        sc.close();
    }
}
