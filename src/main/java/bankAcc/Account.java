package bankAcc;

public abstract class Account {

    protected int balance;

    public abstract boolean pay(int amount); //заплатить
    public abstract boolean transfer(Account account, int amount); //перевести
    public abstract boolean addMoney(int amount); //пополнить

    public int getBalance() {
        return balance;
    }
}
