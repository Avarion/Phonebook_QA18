package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }

    @Test
    public void loginPositiveTest() {

        app.getUser().openLoginRegistrationForm();

        String email = "avarion87@gmail.com";
        String password = "Illumiel1!";

        app.getUser().fillLoginRegistrationForm(email, password);

        app.getUser().submitLogin();

        Assert.assertTrue(app.getUser().isLogged());

    }

    @Test
    public void loginNegativeTestEmail() {

        app.getUser().openLoginRegistrationForm();

        String email = "avarion87gmail.com";
        String password = "Illumiel1!";
        app.getUser().fillLoginRegistrationForm(email, password);

        app.getUser().submitLogin();

        Assert.assertFalse(app.getUser().isLogged());

    }

    @Test
    public void loginNegativeTestPassword() {

        app.getUser().openLoginRegistrationForm();

        String email = "avarion87@gmail.com";
        String password = "Illumiel1";
        app.getUser().fillLoginRegistrationForm(email, password);

        app.getUser().submitLogin();

        Assert.assertFalse(app.getUser().isLogged());

    }

}
