package listas.work;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int employeesRegistered = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < employeesRegistered; i++){
            System.out.println("\nEmployee #" + (i + 1));

            System.out.print("Id: ");
            Integer id = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Salary: ");
            Double salary = sc.nextDouble();
            sc.nextLine();

            employees.add(new Employee(id,name,salary));
        }

        System.out.print("\nEnter the employee id that will have salary increase: ");
        Integer id = sc.nextInt();

        Employee existId = employees.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(null);

        Double percentage;
        if(existId != null) {
            System.out.print("\nEnter the percentage: ");
            percentage = sc.nextDouble();
            existId.setSalary(existId.getSalary() + existId.getSalary() * (percentage / 100));
        }
        else
            System.out.println("This id does not exist!");

        System.out.println("\nList of employees:");
        for(Employee emp : employees){
            System.out.println(emp);
        }




    }
}
