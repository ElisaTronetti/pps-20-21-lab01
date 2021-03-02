import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;

import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends AbstractBankAccount{

    private AccountHolder accountHolder;

    @Override
    BankAccount supplyBankAccount() {
        return new SimpleBankAccount(this.accountHolder, 0);
    }

    @Override
    AccountHolder supplyAccountHolder() {
        this.accountHolder = new AccountHolder("Mario", "Rossi", 1);
        return this.accountHolder;
    }

}
