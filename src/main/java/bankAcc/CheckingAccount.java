package bankAcc;

public class CheckingAccount extends Account {

    public CheckingAccount(int balance) {
        this.balance = balance;
        System.out.println("Создан расчетный счет"
                + "\nБаланс: " + balance);
    }

    @Override
    public boolean pay(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Списание средств с расчетного счета на сумму: " + amount
                    + "\nОстаток средств: " + balance);
            return true;
        }
        else {
            System.out.println("Недостаточно средств");
            return false;
        }
    }

    @Override
    public boolean transfer(Account account, int amount) {
        if (balance >= amount
                && account.addMoney(amount)) {
            balance -= amount;
            System.out.println("Совершен перевод с расчетного счета на сумму: " + amount
                    + "\nОстаток средств: " + balance);
            return true;
        }
        else {
            System.out.println("Операция отклонена");
            return false;
        }
    }

    @Override
    public boolean addMoney(int amount) {
        balance += amount;
        System.out.println("Пополнение расчетного счета на сумму " + amount
                + "\nБаланс: " + balance);
        return true;
    }
}
