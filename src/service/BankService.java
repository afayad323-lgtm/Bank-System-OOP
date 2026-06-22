package service;


import java.util.ArrayList;
import model.Account;
import model.Transaction;

public class BankService {
    private ArrayList<Account> accounts = new ArrayList<>();
    public void addAccount(Account account){
        accounts.add(account);

    }

    public Account findAccount(String ownerName){
        return accounts.stream()
                .filter(a -> a.getOwnerName().equalsIgnoreCase(ownerName))
                .findFirst()
                .orElse(null);


    }

    public void showAllAccounts (){
        accounts.forEach(System.out::println);

    }

    public void deposit (String name , double amount){
        Account account = findAccount(name);
        if (account == null){
            System.out.println("Account Not Found");
            return;
        }

        if (amount <= 0){
            System.out.println("Invalid amount");
            return;
        }
        account.increaseBalance(amount);
        account.addTransaction(new Transaction("Deposit: " , amount));
        System.out.println("Deposit Successful");

    }

    public void withdraw (String name , double amount){
        Account account = findAccount(name);
        if (account == null){
            System.out.println("Account Not Found");
            return;
        }
        if (amount <= 0){
            System.out.println("Amount must be greater than zero");
            return;
        }

        if (amount > account.getBalance()){
            System.out.println("Insufficient balance");
            return;
        }
        account.decreaseBalance(amount);
        account.addTransaction(new Transaction("Withdraw: " , amount));
        System.out.println("Withdraw Successful");
    }

    public void transfer(String senderName , String receiverName , double amount){
        Account sender = findAccount(senderName);
        Account receiver = findAccount(receiverName);

        if (sender == null || receiver == null){
            System.out.println("Account Not Found");
            return;
        }

        if (amount <= 0){
            System.out.println("Amount must be greater than zero");
            return;
        }
        if (amount > sender.getBalance()){
            System.out.println("Insufficient balance");
            return;
        }
        sender.decreaseBalance(amount);
        receiver.increaseBalance(amount);
        System.out.println("Transfer Successful");
        sender.addTransaction(new Transaction("Transfer to "+receiverName+" : " , amount));
        receiver.addTransaction(new Transaction("Transfer from  "+senderName+" : " , amount));
    }




}
