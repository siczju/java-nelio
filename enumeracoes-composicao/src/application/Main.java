package application;

import application.entities.HourContract;
import application.entities.Worker;
import application.entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Worker worker = null;

        System.out.print("Enter department's name: ");
        String depName = sc.nextLine();

        System.out.println("\nEnter worker data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();

        System.out.print("Level: ");
        String workerLevel = sc.next();

        System.out.print("Base salary: ");
        Double workerBaseSalary = sc.nextDouble();

        worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary, depName);

        System.out.print("\nHow many contracts to this worker? ");
        int manyContracts = sc.nextInt();
        sc.nextLine();


        for(int i = 0; i < manyContracts; i++){
            System.out.println("\nEnter contract #" + (i + 1) + " data:");

            System.out.print("Date (DD/MM/YYYY): ");
            String date = sc.nextLine();
            LocalDate dateFormatted = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.print("Value per hour: ");
            Double valuePHour = sc.nextDouble();

            System.out.print("Duration (hours): ");
            Integer duration = sc.nextInt();
            sc.nextLine();

            HourContract contract = new HourContract(dateFormatted, valuePHour, duration);
            worker.addContract(contract);
        }

        System.out.print("\nEnter month and year to calculate income(MM/YYYY): ");
        String date = sc.nextLine();
        LocalDate dateFormatted = LocalDate.parse("01/" + date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("\n" + worker + "\nIncome for " + date + ": " + worker.income(dateFormatted.getYear(), dateFormatted.getMonthValue()));

    }
}
