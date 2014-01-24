package infrastructure.persistence.account;

import domain.model.account.Account;
import domain.model.account.AccountNumber;
import domain.model.account.AccountRepository;

import java.util.HashMap;
import java.util.Map;


public class AccountRepositoryInMem implements AccountRepository {

    private final Map<String, Account> accountCollection = new HashMap<String, Account>();

    @Override
    public void update(Account account) {
        Account oldEntity = accountCollection.get(account.getAccountNumber().getAccountNumber());
        accountCollection.remove(oldEntity);
        accountCollection.put(account.getAccountNumber().getAccountNumber(), account);
    }

    @Override
    public void create(Account account) {
        accountCollection.put(account.getAccountNumber().getAccountNumber(), account);
    }

    @Override
    public void delete(Account account) {
        accountCollection.remove(account);
    }

    @Override
    public Account getForId(String id) {
        return accountCollection.get(id);
    }

    public Account getForAccountNumber(AccountNumber accountNumber) {
        return getForId(accountNumber.getAccountNumber());
    }
}
