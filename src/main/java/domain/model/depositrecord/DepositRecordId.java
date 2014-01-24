package domain.model.depositrecord;


import domain.common.ValueObject;

public class DepositRecordId implements ValueObject<DepositRecordId> {
    private final String depositId;

    public DepositRecordId(String depositId) {
        this.depositId = depositId;
    }

    @Override
    public boolean sameValueAs(DepositRecordId other) {
        return false;
    }

    public String getDepositId() {
        return depositId;
    }
}
