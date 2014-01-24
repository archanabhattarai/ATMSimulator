package application;

import domain.model.account.Account;
import domain.model.account.Money;
import domain.model.account.exception.InsufficientFundException;
import domain.model.depositrecord.DepositRecord;
import domain.model.depositrecord.DepositRecord;

/*
ATM transaction service.
transactions are: check balance, withdraw money, transfer money, register depositrecord
 */
public interface ATMTransactionService {

    Money checkBalanceFor(Account account);

    void registerDeposit(Account account, DepositRecord depositRecord);

    Money withDrawMoneyFrom(Account account, Money withdrawMoney) throws InsufficientFundException;
}
