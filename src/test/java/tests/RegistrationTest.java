package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

    @Test
    public void regPositiveTest() {

        app.getUser().openLoginRegistrationForm();

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = User.builder()
                .email("avarion87" + i + "@gmail.com")
                .password("Illumiel1!")
                .build();

        app.getUser().fillLoginRegistrationForm(user);

        app.getUser().submitRegistration();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[text()='ADD']")));

    }

    @Test
    public void regNegativeTestMail() {

        app.getUser().openLoginRegistrationForm();

        User user1 = User.builder()
                .email("avarion87gmail.com")
                .password("Illumiel1!")
                .build();

        app.getUser().fillLoginRegistrationForm(user1);

        app.getUser().submitRegistration();

        app.getUser().isAlertPresent();

        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//a[text()='ADD']")));

    }

    @Test
    public void regNegativeTestPass() {

        app.getUser().openLoginRegistrationForm();

        User user2 = User.builder()
                .email("avarion87gmail.com")
                .password("Illumiel1")
                .build();

        app.getUser().fillLoginRegistrationForm(user2);

        app.getUser().submitRegistration();

        app.getUser().isAlertPresent();

        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//a[text()='ADD']")));

    }

    @AfterMethod
    public void tearDown() {
//        // wd.quit();
    }

}
