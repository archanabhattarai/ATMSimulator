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
        if (sameCurrencyAs(other) && sameAmountAs(other)) {
            return true;
        }
        return false;
    }

    private boolean sameAmountAs(Money other) {
        return this.amount == other.getAmount();
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
