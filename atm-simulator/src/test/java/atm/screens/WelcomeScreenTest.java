package atm.screens;

import com.codurance.atm.account.Account;
import com.codurance.atm.account.AccountService;
import com.codurance.atm.infrastructure.CliPrompt;
import com.codurance.atm.screens.Screen;
import com.codurance.atm.screens.TransactionScreen;
import com.codurance.atm.screens.WelcomeScreen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WelcomeScreenTest {

    @Test
    public void WhenWelcomeScreenIsCreatedShowReturnACorrectTransactionScreen(){
        //When
        CliPrompt cliPrompt = mock(CliPrompt.class);
        AccountService accountService = mock(AccountService.class);
        Account expectedAccount = new Account("123456", 0);
        when(cliPrompt.accountNumber()).thenReturn("123456");
        when(cliPrompt.pin()).thenReturn("123456");
        when(accountService.findBy("123456","123456")).thenReturn(expectedAccount);

        WelcomeScreen welcomeScreen = new WelcomeScreen(cliPrompt, accountService);
        Screen transaction = welcomeScreen.show();
        Screen withdraw = transaction.show();
        Assertions.assertEquals(withdraw.show(), null);
    }
}
