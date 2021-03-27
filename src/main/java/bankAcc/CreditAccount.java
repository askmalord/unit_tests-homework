package bankAcc;

public class CreditAccount extends Account {

    public CreditAccount() {
        this.balance = 0;
        System.out.println("Создан кредитный счет"
                + "\nБаланс: " + balance);
    }

    @Override
    public boolean pay(int amount) {
        if (balance <= 0) {
            balance -= amount;
            System.out.println("Списание средств с кредитного счета на сумму: " + amount
                    + "\nОстаток средств: " + balance);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean transfer(Account account, int amount) {
        if (account.addMoney(amount)) {
            balance -= amount;
            System.out.println("Совершен перевод с кредитного счета на сумму: " + amount
                    + "\nОстаток средств: " + balance);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean addMoney(int amount) {
        if ((amount + balance) <= 0) {
            balance += amount;
            System.out.println("Пополнение кредитного счета на сумму " + amount
                    + "\nБаланс: " + balance);
            return true;
        }
        else {
            System.out.println("Сумма пополнения превышает задолженность по счету");
            return false;
        }
    }

}
