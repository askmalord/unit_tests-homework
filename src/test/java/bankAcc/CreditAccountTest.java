package bankAcc;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CreditAccountTest {

    private static CreditAccount creditAccount;
    private static CheckingAccount checkingAccount;
    private static CreditAccount supportCreditAccount;

    @BeforeAll
    public static void createSomeCreditAcc() {
        System.out.println("Создание счетов для теста:");
        creditAccount = new CreditAccount();
        checkingAccount = new CheckingAccount(1000);
        supportCreditAccount = new CreditAccount();
    }

    @AfterAll
    public static void messageThatTestsEnd() {
        System.out.println("Все тесты завершены.");
    }

    @Test
    public void validityTest() {
        System.out.println("Проверка валидности созданного счета: success");
        assertThat(creditAccount, allOf(instanceOf(Account.class), hasProperty("balance")));
    }

    @Test
    public void payTest() {
        System.out.println("Проверка возможности оплаты с кредитного счета: success");
        assertThat(creditAccount.pay(5000), equalTo(Boolean.TRUE));
    }

    @Test
    public void transferTest() {
        System.out.println("Проверка возможности перевода с кредитного счета: success");
        assertThat(creditAccount.transfer(checkingAccount, 8000), equalTo(Boolean.TRUE));
    }

    @Test
    public void addMoneyTest() {
        System.out.println("Проверка возможности пополнения кредитного счета: success");
        assertThat(creditAccount.addMoney(30000), equalTo(Boolean.FALSE));
    }

    @Test
    public void transferFromCreditToCreditAccTest() {
        System.out.println("Проверка перевода средств с одного кредитного счета"
                + " на другой с превышением суммы задолженности: success");
        assertThat(creditAccount.transfer(supportCreditAccount, 2000), equalTo(Boolean.FALSE));
    }
}