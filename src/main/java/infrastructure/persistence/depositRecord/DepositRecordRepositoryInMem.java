package infrastructure.persistence.depositRecord;

import domain.model.depositrecord.DepositRecord;
import domain.model.depositrecord.DepositRecordId;
import domain.model.depositrecord.DepositRecordRepository;

import java.util.HashMap;
import java.util.Map;


public class DepositRecordRepositoryInMem implements DepositRecordRepository {

    private final Map<String, DepositRecord> accountCollection = new HashMap<String, DepositRecord>();

    @Override
    public void update(DepositRecord depositRecord) {
        DepositRecord oldEntity = accountCollection.get(depositRecord.getDepositRecordId().getDepositId());
        accountCollection.remove(oldEntity);
        accountCollection.put(depositRecord.getDepositRecordId().getDepositId(), depositRecord);
    }

    @Override
    public void create(DepositRecord depositRecord) {
        accountCollection.put(depositRecord.getDepositRecordId().getDepositId(), depositRecord);
    }

    @Override
    public void delete(DepositRecord depositRecord) {
        accountCollection.remove(depositRecord);
    }

    @Override
    public DepositRecord getForId(String id) {
        return accountCollection.get(id);
    }

    public DepositRecord getForDepositRecordId(DepositRecordId depositRecordId) {
        return getForId(depositRecordId.getDepositId());
    }
}
