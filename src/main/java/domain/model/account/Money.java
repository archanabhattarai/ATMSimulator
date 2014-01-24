package domain.model.account;


import domain.common.ValueObject;

public class Money implements ValueObject<Money> {
    private final Long amount;
    private final Currency currency;

    public Money(Long amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public boolean sameValueAs(Money other) {
        return false;
    }

    public Long getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public boolean sameCurrencyAs(Money money) {
        return this.currency.equals(money.getCurrency());
    }

    public boolean isMoreThan(Money money) {
        if (sameCurrencyAs(money) && this.getAmount() > money.getAmount()) {
            return true;
        }
        return false;
    }
}
