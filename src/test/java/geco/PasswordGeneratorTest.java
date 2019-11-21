package geco;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordGeneratorTest {

    @Test
    public void getRandomPassword() {
        assertEquals(PasswordGenerator.getRandomPassword().length(), 8);
    }
}