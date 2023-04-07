package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }

    @Test(invocationCount = 3, groups = {"smoke"})
    public void loginPositiveTest() {

        User user = User.builder()
                .email("avarion87@gmail.com")
                .password("Illumiel1!")
                .build();

        app.getUser().openLoginRegistrationForm();

        app.getUser().fillLoginRegistrationForm(user);

        app.getUser().submitLogin();

        Assert.assertTrue(app.getUser().isLogged());

    }

    @Test(groups = {"smoke", "regress"})
    public void loginNegativeTestEmail() {

        User user1 = User.builder()
                .email("avarion87gmail.com")
                .password("Illumiel1!")
                .build();

        app.getUser().openLoginRegistrationForm();

        app.getUser().fillLoginRegistrationForm(user1);

        app.getUser().submitLogin();

        app.getUser().isAlertPresent();

        Assert.assertFalse(app.getUser().isLogged());

    }

    @Test(groups = {"regress"})
    public void loginNegativeTestPassword() {

        User user2 = User.builder()
                .email("avarion87gmail.com")
                .password("Illumiel1")
                .build();

        app.getUser().openLoginRegistrationForm();

        app.getUser().fillLoginRegistrationForm(user2);

        app.getUser().submitLogin();

        app.getUser().isAlertPresent();

        Assert.assertFalse(app.getUser().isLogged());

    }

}
