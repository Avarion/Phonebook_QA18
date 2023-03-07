import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {

        openLoginRegistrationForm();

        String email = "avarion87@gmail.com";
        String password = "Illumiel1!";
        fillLoginRegistrationForm(email, password);

        submitLogin();

    }


}
