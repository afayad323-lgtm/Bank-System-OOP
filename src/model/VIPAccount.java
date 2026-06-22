package model;

public class VIPAccount extends Account{
    public VIPAccount(String ownerName){
        super(ownerName);
    }
    public boolean canWithdraw(double amount){
        return true;
    }
}
