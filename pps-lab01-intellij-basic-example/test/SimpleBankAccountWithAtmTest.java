import lab01.example.model.AccountHolder;

import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBankAccountWithAtmTest extends SimpleBankAccountTest{

    private AccountHolder accountHolder;
    private SimpleBankAccountWithAtm bankAccount;

    @Override
    BankAccount supplyBankAccount() {
        this.bankAccount = new SimpleBankAccountWithAtm(this.accountHolder, 0);
        return this.bankAccount;
    }

    @Override
    AccountHolder supplyAccountHolder() {
        this.accountHolder = new AccountHolder("Mario", "Rossi", 1);
        return this.accountHolder;
    }

    @Test
    void testDepositWithAtm(){
        this.bankAccount.depositWithAtm(this.accountHolder.getId(), 101);
        assertEquals(100, this.bankAccount.getBalance());
    }

    @Test
    void testWrongDepositWithAtm(){
        this.bankAccount.depositWithAtm(this.accountHolder.getId(), 101);
        this.bankAccount.depositWithAtm(2, 50);
        assertEquals(100, this.bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithAtm(){
        this.bankAccount.deposit(this.accountHolder.getId(), 100);
        this.bankAccount.withdrawWithAtm(this.accountHolder.getId(),70);
        assertEquals(29, this.bankAccount.getBalance());
    }

    @Test
    void testWrongWithdrawWithAtm(){
        this.bankAccount.deposit(this.accountHolder.getId(), 100);
        this.bankAccount.withdrawWithAtm(2, 70);
        assertEquals(100, this.bankAccount.getBalance());
    }

}