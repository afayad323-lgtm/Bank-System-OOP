package model;

public class CurrentAccount extends Account{
    private double overDraftLimit = 1000;
    public CurrentAccount (String ownerName){
        super(ownerName);
    }

    @Override
    public boolean canWithdraw(double amount){
        return amount <= getBalance() + overDraftLimit;
    }
}
