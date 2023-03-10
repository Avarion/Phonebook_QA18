package tests;

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
        String email = "abc" + i + "avarion87@gmail.com";
        String password = "Illumiel1!";
        app.getUser().fillLoginRegistrationForm(email, password);

        app.getUser().submitRegistration();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[text()='ADD']")));

    }

    @Test
    public void regNegativeTestMail() {

        app.getUser().openLoginRegistrationForm();

        String email = "avarion87gmail.com";
        String password = "Illumiel1!";
        app.getUser().fillLoginRegistrationForm(email, password);

        app.getUser().submitRegistration();

        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//a[text()='ADD']")));

    }

    @Test
    public void regNegativeTestPass() {

        app.getUser().openLoginRegistrationForm();

        String email = "avarion87@gmail.com";
        String password = "Illumiel1";
        app.getUser().fillLoginRegistrationForm(email, password);

        app.getUser().submitRegistration();

        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//a[text()='ADD']")));

    }

    @AfterMethod
    public void tearDown() {
//        // wd.quit();
    }

}
