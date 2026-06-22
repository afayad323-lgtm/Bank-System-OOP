package service;
import model.Account;
import model.Transaction;
import util.OperationResult;

public class AccountService {

    public OperationResult deposit (Account account , double amount){

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

    public OperationResult withdraw (Account account , double amount){

        if (account == null){

            return new OperationResult(false , "Account Not Found");
        }
        if (amount <= 0){

            return new OperationResult(false , "Invalid amount");
        }

        if (amount > account.getBalance()){

            return new OperationResult(false , "Insufficient balance");
        }
        account.decreaseBalance(amount);
        account.addTransaction(new Transaction("Withdraw: " , amount));

        return new OperationResult(true , "Withdraw Successful");
    }

    public OperationResult transfer(Account sender , Account receiver , double amount){


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
