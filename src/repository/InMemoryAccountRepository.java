package repository;
import model.Account;
import java.util.List;
import java.util.ArrayList;

public class InMemoryAccountRepository implements AccountRepository{
    private final List<Account> accounts = new ArrayList<>();

    @Override
    public void saveAccount(Account account){
        accounts.add(account);
    }

    @Override
    public Account findByName(String name){
        return accounts.stream()
                .filter(n -> n.getOwnerName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Account> findAll(){
        return accounts;
    }
}
