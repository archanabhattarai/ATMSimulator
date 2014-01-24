package application.impl;

import application.ATMTransactionService;
import domain.model.account.Account;
import domain.model.account.AccountRepository;
import domain.model.account.Money;
import domain.model.account.exception.InsufficientFundException;
import domain.model.depositrecord.DepositRecord;
import domain.model.depositrecord.DepositRecord;


public class ATMTransactionServiceImpl implements ATMTransactionService {
    private final AccountRepository accountRepository;

    public ATMTransactionServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Money checkBalanceFor(Account account) {
        return account.getMoney();
    }

    @Override
    public void registerDeposit(Account account, DepositRecord depositRecord) {

    }

    @Override
    public Money withDrawMoneyFrom(Account account, Money withdrawMoney) throws InsufficientFundException {
        if (account.getMoney().isMoreThan(withdrawMoney)) {
            account.deduct(withdrawMoney);
            accountRepository.update(account);
            return withdrawMoney;
        }else {
            throw new InsufficientFundException();
        }
    }
}
