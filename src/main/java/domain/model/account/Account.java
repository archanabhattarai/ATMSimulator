package domain.model.account;


import domain.common.Entity;

public class Account implements Entity<Account> {

    private final AccountNumber accountNumber;
    private Money money;

    public Account(AccountNumber accountNumber, Money money) {
        this.accountNumber = accountNumber;
        this.money = money;
    }

    @Override
    public boolean sameIdentityAs(Account other) {
        return false;
    }

    public AccountNumber getAccountNumber() {
        return accountNumber;
    }

    public Money getMoney() {
        return money;
    }


    public void deduct(Money withdrawMoney) {
        if (this.money.getCurrency().equals(withdrawMoney.getCurrency())) {
            this.money = new Money(this.money.getAmount() - withdrawMoney.getAmount(), this.money.getCurrency());
        }
    }
}
