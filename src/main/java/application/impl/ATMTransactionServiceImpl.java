package application.impl;

import application.ATMTransactionService;
import domain.model.account.Account;
import domain.model.account.AccountRepository;
import domain.model.account.Money;
import domain.model.account.exception.InsufficientFundException;
import domain.model.depositrecord.DepositRecord;
import domain.model.depositrecord.DepositRecord;
import domain.model.depositrecord.DepositRecordRepository;


public class ATMTransactionServiceImpl implements ATMTransactionService {
    private final AccountRepository accountRepository;
    private final DepositRecordRepository depositRecordRepository;

    public ATMTransactionServiceImpl(AccountRepository accountRepository, DepositRecordRepository depositRecordRepository) {
        this.accountRepository = accountRepository;
        this.depositRecordRepository = depositRecordRepository;
    }

    @Override
    public Money checkBalanceFor(Account account) {
        return account.getMoney();
    }

    @Override
    public void registerDeposit(DepositRecord depositRecord) {
          depositRecordRepository.create(depositRecord);
    }

    @Override
    public Money withDrawMoneyFrom(Account account, Money withdrawMoney) throws InsufficientFundException {
        if (account.getMoney().isMoreThan(withdrawMoney)) {
            account.deduct(withdrawMoney);
            accountRepository.update(account);
            return withdrawMoney;
        } else {
            throw new InsufficientFundException();
        }
    }
}
