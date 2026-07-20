import entities.BankAccount;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        BankAccount bank = new BankAccount();

        System.out.print("\nEnter account number: ");
        bank.setAccountNumber(sc.nextInt());
        sc.nextLine();

        System.out.print("\nEnter account holder: ");
        bank.setAccountHolder(sc.nextLine());

        System.out.print("\nIs there a initial deposit (y/n)? ");
        char condition = sc.next().charAt(0);

        if(condition == 'y') {
            System.out.print("Enter a deposit value: ");
            bank.deposit(sc.nextDouble());
            sc.nextLine();
        }

        do{
            System.out.println("\nAccount data: \n" + bank + "\n");

            System.out.print("Enter a deposit value: ");
            bank.deposit(sc.nextDouble());
            System.out.println("Updated account data: \n" + bank + "\n");

            System.out.print("Enter a withdraw value: ");
            bank.withdraw(sc.nextDouble());
            System.out.println("Updated account data: \n" + bank + "\n");

            System.out.println("Leave? (y/n)");
            condition = sc.next().charAt(0);

        } while (condition != 'y');

        sc.close();
    }
}
