package service;
import model.Account;
import model.Transaction;
import repository.AccountRepository;
import util.OperationResult;

public class AccountService {
    private AccountRepository repository;

    public AccountService(AccountRepository repository){
        this.repository = repository;
    }

    public OperationResult deposit (String name , double amount){

        Account account = repository.findByName(name);

        if (account == null){

            return new OperationResult(false , "Account Not Found");
        }

        if (amount <= 0){

            return new OperationResult(false , "Invalid amount");
        }
        account.increaseBalance(amount);
        account.addTransaction(new Transaction("Deposit: " , amount));

        return new OperationResult(true , "Deopsit Successful");

    }

    public OperationResult withdraw (String name , double amount){
Account account = repository.findByName(name);
        if (account == null){

            return new OperationResult(false , "Account Not Found");
        }
        if (amount <= 0){

            return new OperationResult(false , "Invalid amount");
        }

        if (!account.canWithdraw(amount)){

            return new OperationResult(false , "Insufficient balance");
        }
        account.decreaseBalance(amount);
        account.addTransaction(new Transaction("Withdraw: " , amount));

        return new OperationResult(true , "Withdraw Successful");
    }

    public OperationResult transfer(String senderName , String receiverName , double amount){
    Account sender = repository.findByName(senderName);
    Account receiver = repository.findByName(receiverName);

        if (sender == null || receiver == null){

            return new OperationResult(false , "Account Not Found");
        }

        if (amount <= 0){

            return new OperationResult(false , "Invalid amount");
        }
        if (amount > sender.getBalance()){

            return new OperationResult(false , "Insufficient balance");
        }
        sender.decreaseBalance(amount);
        receiver.increaseBalance(amount);

        sender.addTransaction(new Transaction("Transfer to "+receiver.getOwnerName()+" : " , amount));
        receiver.addTransaction(new Transaction("Transfer from  "+sender.getOwnerName()+" : " , amount));
        return new OperationResult(true , "Transfer Successful");
    }

}
