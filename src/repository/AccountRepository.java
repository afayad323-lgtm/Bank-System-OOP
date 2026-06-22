package repository;

import model.Account;
import java.util.List;

public interface AccountRepository {
    void saveAccount(Account account);

    Account findByName(String name);
     List<Account> findAll();
}
