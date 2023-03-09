import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(isLogged()){
            logout();
        }
    }
    @Test
    public void loginPositiveTest() {

        openLoginRegistrationForm();

        String email = "avarion87@gmail.com";
        String password = "Illumiel1!";
        fillLoginRegistrationForm(email, password);

        submitLogin();

        Assert.assertTrue(wd.findElement(By.xpath("//a[text()='ADD']")).getText().equals("ADD"));

    }

    @Test
    public void loginNegativeTestEmail() {

        openLoginRegistrationForm();

        String email = "avarion87gmail.com";
        String password = "Illumiel1!";
        fillLoginRegistrationForm(email, password);

        submitLogin();

        Assert.assertTrue(wd.findElement(By.xpath("//*[text()='LOADING...']")).getText().equals("LOADING..."));


    }

    @Test
    public void loginNegativeTestPassword() {

        openLoginRegistrationForm();

        String email = "avarion87@gmail.com";
        String password = "Illumiel1";
        fillLoginRegistrationForm(email, password);

        submitLogin();

        Assert.assertTrue(wd.findElement(By.xpath("//*[text()='LOADING...']")).getText().equals("LOADING..."));
    }


}
