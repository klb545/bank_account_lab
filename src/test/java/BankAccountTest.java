import org.example.BankAccount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {

    BankAccount bankAccount;

    @BeforeEach
    public void setUp(){
        bankAccount = new BankAccount("Katie", "Bamford", LocalDate.of(1995,2,18), "saver");
    }

// TESTING GETTERS
    @Test
    public void hasFirstName(){
//        BDD: given, when, then
//        given (already in @BeforeEach)
//        when
        String actual = bankAccount.getFirstName();
        String expected = "Katie";
//        then
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void hasLastName(){
        String actual = bankAccount.getLastName();
        String expected = "Bamford";
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void hasDateOfBirth(){
        LocalDate actual = bankAccount.getDateOfBirth();
        LocalDate expected = LocalDate.of(1995,2,18);
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void hasAccountNumber(){
        String actual = bankAccount.getAccountNumber();
        String expected = "";
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void hasBalance(){
        double actual = bankAccount.getBalance();
        double expected = 0;
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void hasAccountType(){
        String actual = bankAccount.getAccountType();
        String expected = "";
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void hasOverdraft(){
        Integer actual = bankAccount.getOverdraft();
        Integer expected = -500;
        assertThat(actual).isEqualTo(expected);
    }

    // TESTING SETTERS
    @Test
    public void doesSetFirstName(){
        bankAccount.setFirstName("Anna");
        assertEquals("Anna", bankAccount.getFirstName());
    }
    @Test
    public void doesSetLastName(){
        bankAccount.setLastName("Henderson");
        assertEquals("Henderson", bankAccount.getLastName());
    }
    @Test
    public void doesSetDateOfBirth(){
        bankAccount.setDateOfBirth(LocalDate.of(2000, 2, 18));
        assertThat(LocalDate.of(2000,2,18)).isEqualTo(bankAccount.getDateOfBirth());
    }
    @Test
    public void doesSetAccountNumber(){
        bankAccount.setAccountNumber("");
        assertThat("").isEqualTo(bankAccount.getAccountNumber());
    }
    @Test
    public void doesSetBalance(){
        bankAccount.setBalance(1000);
        assertEquals(1000, bankAccount.getBalance());
    }
    @Test
    public void doesSetAccountType(){
        bankAccount.setAccountType("");
        assertEquals("", bankAccount.getAccountType());
    }
    @Test
    public void doesSetOverdraft(){
        bankAccount.setOverdraft(-1000);
        assertEquals(-1000, bankAccount.getOverdraft());
    }

    // TESTING CUSTOM METHODS
    @Test
    public void testDepositMethod(){
        bankAccount.deposit(10);
        double actual = bankAccount.getBalance();
        double expected = 10;
        assertEquals(actual, expected);
    }
    @Test
    public void testWithdrawalMethod1(){
        bankAccount.withdraw(10);
        double actual = bankAccount.getBalance();
        double expected = -10;
        assertEquals(actual, expected);
    }

    @Test
    public void testWithdrawalMethod2(){
        bankAccount.withdraw(500);
        double actual = bankAccount.getBalance();
        double expected = -500;
        assertEquals(actual, expected);
    }

    @Test
    public void testWithdrawalMethod3(){
        bankAccount.withdraw(501);
        double actual = bankAccount.getBalance();
        double expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void testPayInterestMethod(){
        bankAccount.setBalance(100);
        bankAccount.payInterest("Katie", "Bamford", "saver");
        double actual = bankAccount.getBalance();
        double expected = 100.50;
        assertEquals(actual, expected);
    }


}



