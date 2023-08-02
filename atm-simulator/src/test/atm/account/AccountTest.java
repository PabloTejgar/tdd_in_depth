package atm.account;

import com.codurance.atm.account.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest{

    private Account account;

    @BeforeEach
    public void SetUp(){ account = new Account("123456", 100); }

    @Test
    public void whenAccountIsCreatedThenAccountNumberIsReturned(){
        Assertions.assertEquals("123456", account.accountNumber());
    }

    @Test
    public void whenAccountIsCreatedThenBalanceIsReturned(){
        Assertions.assertEquals(100, account.balance());
    }

}
