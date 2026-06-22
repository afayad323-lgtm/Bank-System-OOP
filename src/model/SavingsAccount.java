package model;

public class SavingsAccount extends Account{
    public SavingsAccount (String ownerName){
        super(ownerName);
    }

    @Override
    public boolean canWithdraw(double amount){
        return amount <= getBalance();

    }
}
