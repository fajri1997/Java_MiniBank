package Bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

 public class BankAccount {

    private String accountNumber;
    private  double balance;
    private List<Transaction> transactionHistory;

//    public BankAccount(String accountNumber) {
//        this.accountNumber = accountNumber;
//    }
    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }



    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<Transaction> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(new Transaction( new Date(),"deposit", amount  ));
            System.out.println("Deposited $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }


     public void withdrawal(double amount ) {

        if (amount > 0.0d) {
            System.out.println("Cannot withdraw a negative amount");
        }
        if (amount > balance) {
            System.out.println("Cannot overdraw an account");
        } else {
            setBalance(balance - amount);
            Date date = new Date();
            Transaction transaction = new Transaction(date,"withdrawal", amount);
            this.transactionHistory.add(transaction);

        }

    }

    public void  displayTransactionHistory(){
        System.out.println("Transaction History for Account: "  + transactionHistory);

    }


}
