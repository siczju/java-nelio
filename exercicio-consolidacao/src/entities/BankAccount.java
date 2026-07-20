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

    public BankAccount(int accountNumber, String accountHolder){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
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
        value += tax;
        this.sale -= value;
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
