package services;

import entities.Contract;
import entities.Installment;

import java.time.LocalDate;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService){
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months){

        LocalDate date;


        for(int i = 1; i <= months; i++) {
            Double amount = contract.getTotalValue() / months;
            amount += onlinePaymentService.interest(amount, i);
            amount += onlinePaymentService.paymentFee(amount);

            date = contract.getDate().plusMonths(i);

            contract.getInstallmentsList().add(new Installment(date, amount));
        }
    }
}
