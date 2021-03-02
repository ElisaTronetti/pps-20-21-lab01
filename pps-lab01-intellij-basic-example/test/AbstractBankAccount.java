import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class AbstractBankAccount {

    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    abstract BankAccount supplyBankAccount();

    abstract AccountHolder supplyAccountHolder();

    @BeforeEach
    public void beforeEach(){
        this.accountHolder = supplyAccountHolder();
        this.bankAccount = supplyBankAccount();
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, this.bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        this.bankAccount.deposit(this.accountHolder.getId(), 100);
        assertEquals(100, this.bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        this.bankAccount.deposit(this.accountHolder.getId(), 100);
        this.bankAccount.deposit(2, 50);
        assertEquals(100, this.bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        this.bankAccount.deposit(this.accountHolder.getId(), 100);
        this.bankAccount.withdraw(this.accountHolder.getId(), 70);
        assertEquals(30, this.bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        this.bankAccount.deposit(this.accountHolder.getId(), 100);
        this.bankAccount.withdraw(2, 70);
        assertEquals(100, bankAccount.getBalance());
    }
}
