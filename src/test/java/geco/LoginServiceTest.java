package geco;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest {
    String[] logins = new String[]{"Clement", "Mendicant"};
    String[] notLogins = new String[]{"Yop", "Banane", "Fraise"};
    String[] loginsToAdd = new String[]{
            "Fenri",
            "Pinoukie",
            "Pacifique",
            "Harry",
            "PtitPingouin"
    };
    LoginService loginService;

    @Before
    public void setUp() {
        this.loginService = new LoginService(logins);
    }

    @Test
    public void loginExists() {
        for (String login: logins) {
            assertTrue(this.loginService.loginExists(login));
        }
        for (String login : notLogins) {
            assertFalse(this.loginService.loginExists(login));
        }
    }

    @Test
    public void addLogin() {
        for (String login : loginsToAdd) {
            assertFalse(this.loginService.loginExists(login));
            this.loginService.addLogin(login);
            assertTrue(this.loginService.loginExists(login));
        }
    }

    @Test
    public void findAllLoginsStartingWith() {
        String search1 = this.logins[0].substring(0,1);
        String search2 = this.notLogins[0].substring(0, this.notLogins[0].length()/2);
        assertTrue(this.loginService.findAllLoginsStartingWith(search1).size() > 0);
        assertTrue(this.loginService.findAllLoginsStartingWith(search2).size() == 0);
    }

    @Test
    public void findAllLogins() {
        List<String> allLogins = this.loginService.findAllLogins();
        assertTrue(Arrays.equals(logins, allLogins.toArray()));
        assertFalse(Arrays.equals(notLogins, allLogins.toArray()));

    }
}