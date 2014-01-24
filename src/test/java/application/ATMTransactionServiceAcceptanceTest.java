package application;

import application.impl.ATMTransactionServiceImpl;
import domain.model.account.*;
import domain.model.account.exception.InsufficientFundException;
import domain.model.depositrecord.DepositRecord;
import domain.model.depositrecord.DepositRecordId;
import domain.model.depositrecord.DepositRecord;
import domain.model.depositrecord.DepositRecordId;
import infrastructure.persistence.account.AccountRepositoryInMem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;


public class ATMTransactionServiceAcceptanceTest {

    private ATMTransactionService atmTransactionService;
    private AccountRepository accountRepository;
    private Money money;
    private Account account;


    @Before
    public void setUp() throws Exception {
        accountRepository = new AccountRepositoryInMem();
        atmTransactionService = new ATMTransactionServiceImpl(accountRepository);
        money = new Money(123l, Currency.DOLLAR);
        account = new Account(new AccountNumber("123456"), money);
        accountRepository.create(account);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCheckBalance() {
        assertEquals(money, atmTransactionService.checkBalanceFor(account));
    }

    @Test
    public void shouldRegisterDeposit() {
        DepositRecord depositRecord = new DepositRecord(new DepositRecordId("1234"), new Date(), money);
        atmTransactionService.registerDeposit(account, depositRecord);
    }

    @Test
    public void shouldWithDrawMoney() throws InsufficientFundException {
        Money withdrawMoney = new Money(20l, Currency.DOLLAR);
        assertEquals(withdrawMoney, atmTransactionService.withDrawMoneyFrom(account, withdrawMoney));
    }

    @Test(expected = InsufficientFundException.class)
    public void shouldNotBeAbleToWithdrawWhenInsufficientFundInAccount() throws InsufficientFundException {
        Money withdrawMoney = new Money(240l, Currency.DOLLAR);
        atmTransactionService.withDrawMoneyFrom(account, withdrawMoney);
    }
}
