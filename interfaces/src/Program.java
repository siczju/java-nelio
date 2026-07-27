import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter the contract data: ");

        System.out.print("\nNumber Contract: ");
        Integer numberContract = sc.nextInt();
        sc.nextLine();

        System.out.print("Date (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.nextLine(), fmt);

        System.out.print("Contract value: ");
        Double contractValue = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter the installment's quantity: ");
        Integer installmentsQuantity = sc.nextInt();

        Contract contract = new Contract(numberContract, date, contractValue);
        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, installmentsQuantity);

        for(Installment aux : contract.getInstallmentsList()){
            System.out.println(aux);
        }
    }
}
