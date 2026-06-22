import model.*;
import repository.AccountRepository;
import repository.InMemoryAccountRepository;
import service.AccountService;
import service.BankService;
import java.util.Scanner;
import util.OperationResult;
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        AccountRepository repository = new InMemoryAccountRepository();
        BankService service = new BankService(repository);
        AccountService accountService = new AccountService(repository);

        service.addAccount(new SavingsAccount("Ahmed"));
        service.addAccount(new CurrentAccount("Ali"));
        service.addAccount(new SavingsAccount("Eman"));
        service.addAccount(new CurrentAccount("Malika"));
        service.addAccount(new SavingsAccount("Mostafa"));

       while (true){
           System.out.println("----Bank System----");
           System.out.println("1- Add Account");
           System.out.println("2- Find Account");
           System.out.println("3- Show All Accounts");
           System.out.println("4- Deposit");
           System.out.println("5- Withdraw");
           System.out.println("6- Transfer");
           System.out.println("7- Show Transactions");
           System.out.println("8- Exit");
           System.out.println("Choice: ");
           int choice = reader.nextInt();

           switch (choice){
               case 1: {
                   System.out.println("Enter Your Name: ");
                   String name = reader.next();
                   System.out.println("Choose Account Type: ");
                   System.out.println("1- Current");
                   System.out.println("2- Savings");
                   System.out.println("3- VIP");
                    int type = reader.nextInt();
                    Account account;
                    if (type == 1 ){
                        account = new CurrentAccount(name);
                    }else if (type == 2){
                        account = new SavingsAccount(name);
                    }else {
                        account = new VIPAccount(name);
                    }

                    service.addAccount(account);
                   break;
               }
               case 2: {
                   System.out.println("Enter Your Name: ");
                   String name = reader.next();
                   Account acc = service.findAccount(name);
                   if (acc != null){
                       System.out.println(acc);
                   }else {
                       System.out.println("Account Not Found");
                   }
                   break;
               }
               case 3: {
                   service.showAllAccounts();
                   break;


               }
               case 4: {
                   System.out.println("Enter Your Name: ");
                   String name = reader.next();

                   System.out.println("Enter Your Amount: ");
                   double amount = reader.nextDouble();


                   OperationResult result = accountService.deposit(name , amount);
                   System.out.println(result.getMessage());
                   break;
               }
               case 5:{
                   System.out.println("Enter Your Name: ");
                   String name = reader.next();

                   System.out.println("Enter Your Amount: ");
                   double amount = reader.nextDouble();
                   Account account = service.findAccount(name);
                   OperationResult result = accountService.withdraw(name , amount);
                   System.out.println(result.getMessage());
                   break;
               }
               case 6:{
                   System.out.println("Enter sender name: ");
                   String senderName = reader.next();
                   System.out.println("Enter receiver name: ");
                   String receiverName = reader.next();
                   System.out.println("Enter amount: ");
                   double amount = reader.nextDouble();

                   OperationResult result = accountService.transfer(senderName,receiverName,amount);
                   System.out.println(result.getMessage());
                   break;
               }
               case 7:{
                    System.out.println("Enter Your Name: ");
                    String name = reader.next();
                    Account acc = service.findAccount(name);
                    if (acc != null){
                        acc.showTransactions();
                    }
                    else {
                        System.out.println("Account Not Found");
                    }
                    break;

               }
               case 8:{
                   System.out.println("GOODBYE");
                   return;
               }
               default:
                   System.out.println("Invalid Choice");

           }

       }





    }
}