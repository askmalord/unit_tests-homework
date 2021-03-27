package bankAcc;

public class Main {
    public static void main(String[] args) {
        Account savingsAccount = new SavingsAccount(150000);
        Account creditAccount = new CreditAccount();
        Account checkingAccount = new CheckingAccount(50000);
        creditAccount.pay(100000);
        savingsAccount.transfer(checkingAccount,145000);
        checkingAccount.transfer(creditAccount,30000);
        checkingAccount.transfer(savingsAccount,210000);
        checkingAccount.transfer(creditAccount,110000);
        checkingAccount.transfer(creditAccount,60000);
    }
}
