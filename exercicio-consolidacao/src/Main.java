import entities.BankAccount;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter account number: ");
        int accountNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("\nEnter account holder: ");
        String accountHolder = sc.nextLine();

        System.out.print("\nIs there a initial deposit (y/n)? ");
        char condition = sc.next().charAt(0);

        while (condition != 'y' && condition != 'n') {
            System.out.print("Invalid option. Enter y or n: ");
            condition = sc.next().charAt(0);
        }

        BankAccount bank;
        if(condition == 'y') {
            System.out.print("Enter a deposit value: ");
            double deposit = sc.nextDouble();
            bank = new BankAccount(accountNumber, accountHolder, deposit);
        }
        else{
            bank = new BankAccount(accountNumber, accountHolder);
        }

        do{
            System.out.println("\nAccount data: \n" + bank + "\n");

            System.out.print("Enter a deposit value: ");
            bank.deposit(sc.nextDouble());
            System.out.println("Updated account data: \n" + bank + "\n");

            System.out.print("Enter a withdraw value: ");
            bank.withdraw(sc.nextDouble());
            System.out.println("Updated account data: \n" + bank + "\n");

            System.out.print("Leave? (y/n) ");
            condition = Character.toLowerCase(sc.next().charAt(0));

            while (condition != 'y' && condition != 'n') {
                System.out.print("Invalid option. Enter y or n: ");
                condition = sc.next().charAt(0);
            }

        } while (condition != 'y');

        sc.close();
    }
}
