package service;


import java.util.ArrayList;
import model.Account;
import model.Transaction;
import repository.AccountRepository;
import util.OperationResult;

public class BankService {
    private final AccountRepository accountRepository;


    public BankService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    public void addAccount(Account account){
        accountRepository.saveAccount(account);

    }

    public Account findAccount(String ownerName){
       return accountRepository.findByName(ownerName);
    }

    public void showAllAccounts (){
        accountRepository.findAll().forEach(System.out::println);

    }





}
