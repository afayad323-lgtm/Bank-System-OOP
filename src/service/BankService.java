package service;


import java.util.ArrayList;
import model.Account;
import model.Transaction;
import util.OperationResult;

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





}
