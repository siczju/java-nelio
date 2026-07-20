package entities;

public class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double sale;

    public BankAccount(){}

    public BankAccount(int accountNumber, String accountHolder, double sale){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.sale = sale;
    }

    public BankAccount(String accountHolder, double sale){
        this.accountHolder = accountHolder;
        this.sale = sale;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getSale() {
        return sale;
    }

    public void deposit(double value) {
        this.sale += value;
    }

    public void withdraw(double value){
        double tax = 5.00;
        this.sale -= value - tax;
    }

    public String toString(){
        return "Account " +
                accountNumber + ", " +
                "Holder: " +
                accountHolder + ", " +
                "Balance: $ " +
                String.format("%.2f", sale);

    }
}
