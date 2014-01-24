package domain.model.depositrecord;

import domain.common.Entity;
import domain.model.account.Money;

import java.util.Date;

public class DepositRecord implements Entity<DepositRecord> {
    private final DepositRecordId depositRecordId;
    private final long timeStamp;
    private final Money money;

    public DepositRecord(DepositRecordId depositRecordId, Date date, Money money) {
        this.money = money;
        this.depositRecordId = depositRecordId;
        timeStamp = date.getTime();
    }

    @Override
    public boolean sameIdentityAs(DepositRecord other) {
        return false;
    }

    public DepositRecordId getDepositRecordId() {
        return depositRecordId;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public Money getMoney() {
        return money;
    }
}
