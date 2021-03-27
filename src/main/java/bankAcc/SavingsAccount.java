package bankAcc;

public class SavingsAccount extends Account {

     public SavingsAccount(int balance) {
         this.balance = balance;
         System.out.println("Создан сберегательный счет"
                 + "\nБаланс: " + balance);
     }

    @Override
    public boolean pay(int amount) {
         System.out.println("Оплата со сберегательного счета невозможна");
         return false;
    }

    @Override
    public boolean transfer(Account account, int amount) {
        boolean confirmOfTransfer;
        if (balance >= amount
                && (confirmOfTransfer = account.addMoney(amount))) {
            balance -= amount;
            System.out.println("Совершен перевод со сберегательного счета на сумму: " + amount
                    + "\nОстаток средств: " + balance);
            return true;
        }
        else {
            System.out.println("Операция оклонена");
            return false;
        }
    }

    @Override
    public boolean addMoney(int amount) {
        balance += amount;
        System.out.println("Пополнение сберегательного счета на сумму " + amount
                + "\nБаланс: " + balance);
        return true;
    }
}
