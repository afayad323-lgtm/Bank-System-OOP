package model;
import model.AccountType;
import model.Transaction;
import java.util.ArrayList;

public class Account {
    private String ownerName;
    private double balance;
    private AccountType type;
    private ArrayList<Transaction> transactions = new ArrayList<>();
public Account(){}
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

    public void increaseBalance (double amount){
        this.balance += amount;
    }

    public void decreaseBalance (double amount){
        this.balance -= amount;
    }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

}
