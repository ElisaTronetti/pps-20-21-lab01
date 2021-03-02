package lab01.example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount implements BankAccount {

    private static final int FEE = 1;

    public SimpleBankAccountWithAtm(final AccountHolder accountHolder, final double balance){
        super(accountHolder, balance);
    }

    public void depositWithAtm(final int idUser, final double amount){
        deposit(idUser, amount - FEE);
    }

    public void withdrawWithAtm(final int idUser, final double amount) {
        withdraw(idUser, amount + FEE);
    }

}
