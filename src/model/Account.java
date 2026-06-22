package model;
import java.util.ArrayList;

public abstract class Account {
    private String ownerName;
    private double balance;

    private ArrayList<Transaction> transactions = new ArrayList<>();
public Account(){}
    public Account(String name ){
        this.ownerName = name;
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
        return ownerName + " - "+ balance ;
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

    public abstract boolean canWithdraw(double amount);

}
