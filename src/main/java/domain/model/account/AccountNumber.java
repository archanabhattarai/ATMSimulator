package domain.model.account;


import domain.common.ValueObject;

public final class AccountNumber implements ValueObject<AccountNumber> {
    private final String accountNumber;

    public AccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public boolean sameValueAs(AccountNumber other) {
        return this.accountNumber.equals(other.accountNumber);
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
