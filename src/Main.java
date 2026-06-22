import model.Account;
import model.AccountType;
import service.AccountService;
import service.BankService;
import java.util.Scanner;
import util.OperationResult;
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        BankService service = new BankService();
        AccountService accountService = new AccountService();

        service.addAccount(new Account("Ahmed", AccountType.SAVINGS));
        service.addAccount(new Account("Ali", AccountType.CURRENT));
        service.addAccount(new Account("Eman", AccountType.SAVINGS));
        service.addAccount(new Account("Malika", AccountType.CURRENT));
        service.addAccount(new Account("Mostafa", AccountType.SAVINGS));

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
                   System.out.println("Enter Account Type (SAVINGS / CURRENT): ");
                   String type = reader.next().toUpperCase();
                   AccountType acc = AccountType.valueOf(type);
                   service.addAccount(new Account(name, acc));
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

                   Account account = service.findAccount(name);
                   OperationResult result = accountService.deposit(account , amount);
                   System.out.println(result.getMessage());
                   break;
               }
               case 5:{
                   System.out.println("Enter Your Name: ");
                   String name = reader.next();

                   System.out.println("Enter Your Amount: ");
                   double amount = reader.nextDouble();
                   Account account = service.findAccount(name);
                   OperationResult result = accountService.withdraw(account , amount);
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
                   Account sender = service.findAccount(senderName);
                   Account receiver = service.findAccount(receiverName);
                   OperationResult result = accountService.transfer(sender,receiver,amount);
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