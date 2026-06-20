package model;
import model.AccountType;
import model.Transaction;
import java.util.ArrayList;

public class Account {
    private String ownerName;
    private double balance;
    private AccountType type;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account(String name , AccountType type){
        this.ownerName = name;
        this.type = type;
        this.balance =0;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }
    public void deposit (double amount){
        balance += amount;
        transactions.add(new Transaction("Deposit: " , amount));
    }

    public void withdraw (double amount){
        balance -= amount;
        transactions.add(new Transaction("Withdraw: " , amount));
    }

    public void showTransactions(){
        if (transactions.isEmpty()){
            System.out.println("No Transactions Found");
        }
        transactions.forEach(System.out::println);
    }
@Override
    public String toString(){
        return ownerName + " - "+ balance + " - " + type;
    }

}
