package geco;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {
    LoginService loginService;
    LoginGenerator loginGenerator;
    String[] firstNames = new String[]{"Paul", "John", "Jean", "Paul", "Paul"};
    String[] lastNames = new String[]{"Durand", "Ralling", "Rolling", "Dùrand", "Du"};
    String[] logins = new String[]{"PDUR", "JRAL2", "JROL1", "PDUR1", "PDU"};

    @Before
    public void setUp() throws Exception {
        this.loginService = new LoginService(new String[]{"JROL","BPER", "CGUR", "JDU", "JRAL", "JRAL1"});
        this.loginGenerator = new LoginGenerator(this.loginService);
    }

    @Test
    public void generateLoginForNomAndPrenom() {
        for (int i = 0 ; i < logins.length ; ++i) {
            String login = this.loginGenerator.generateLoginForNomAndPrenom(lastNames[i], firstNames[i]);
            assertEquals(logins[i], login);
            assertTrue(this.loginService.loginExists(login));
        }
    }
}