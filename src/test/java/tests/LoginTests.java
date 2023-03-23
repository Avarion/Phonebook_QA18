package tests;

import models.User;
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
//                       new User().
        User user = User.builder()
                .email("avarion87@gmail.com")
                .password("Illumiel1!")
                .build();

        app.getUser().openLoginRegistrationForm();

//      app.getUser().fillLoginRegistrationForm("avarion87@gmail.com", "Illumiel1!");
        app.getUser().fillLoginRegistrationForm(user);

        app.getUser().submitLogin();

        Assert.assertTrue(app.getUser().isLogged());

    }

    @Test
    public void loginNegativeTestEmail() {

        User user1 = User.builder()
                .email("avarion87gmail.com")
                .password("Illumiel1!")
                .build();

        app.getUser().openLoginRegistrationForm();

        app.getUser().fillLoginRegistrationForm(user1);

        app.getUser().submitLogin();

        Assert.assertFalse(app.getUser().isLogged());

    }

    @Test
    public void loginNegativeTestPassword() {

        User user2 = User.builder()
                .email("avarion87gmail.com")
                .password("Illumiel1")
                .build();

        app.getUser().openLoginRegistrationForm();

        app.getUser().fillLoginRegistrationForm(user2);

        app.getUser().submitLogin();

        Assert.assertFalse(app.getUser().isLogged());

    }

}
