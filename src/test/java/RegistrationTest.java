import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

//    WebDriver wd;
//    FluentWait<WebDriver> wait;


    @BeforeMethod
    public void preCondition(){
        if(isLogged()){
            logout();
        }
    }
//    public void init() {
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//
//        wait = new FluentWait<>(wd);
//
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//
//    }


    @Test
    public void regPositiveTest() {

        /*
        1. open
        2. fill
        3. submit reg
        4. assert
         */

//        WebElement loginBtn = wd.findElement(By.xpath("//a[@href='/login']"));
//        loginBtn.click();

        openLoginRegistrationForm();

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "abc" + i + "avarion87@gmail.com";
        String password = "Illumiel1!";
        fillLoginRegistrationForm(email, password);

        submitRegistration();

        Assert.assertTrue(wd.findElement(By.xpath("//a[text()='ADD']")).getText().equals("ADD"));

//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("abc" + i + "avarion87@gmail.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Illumiel1!");

//        wd.findElement(By.xpath("//button[2]")).click();

//        pause(5);

    }

//    public void pause(int time) {
//        try {
//            Thread.sleep(time);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

//        FluentWait<WebDriver> wait = new FluentWait<>(wd);
//        wait.withTimeout(Duration.ofSeconds(time));
//    }

    @Test
    public void regNegativeTestMail() {

        openLoginRegistrationForm();


        String email = "avarion87gmail.com";
        String password = "Illumiel1!";
        fillLoginRegistrationForm(email, password);

        submitRegistration();


//        WebElement loginBtn1 = wd.findElement(By.xpath("//a[@href='/login']"));
//        loginBtn1.click();
//
////          int i = (int) (System.currentTimeMillis() / 1000) % 3600;
//        WebElement emailInput1 = wd.findElement(By.xpath("//input[1]"));
//        emailInput1.click();
//        emailInput1.clear();
//        emailInput1.sendKeys("avarion87gmail.com");
//
//        WebElement passInput1 = wd.findElement(By.xpath("//input[2]"));
//        passInput1.click();
//        passInput1.clear();
//        passInput1.sendKeys("Illumiel1!");
//
//        wd.findElement(By.xpath("//button[2]")).click();
    }

    @Test
    public void regNegativeTestPass() {

        openLoginRegistrationForm();

        String email = "avarion87@gmail.com";
        String password = "Illumiel1";
        fillLoginRegistrationForm(email, password);

        submitRegistration();



//        WebElement loginBtn1 = wd.findElement(By.xpath("//a[@href='/login']"));
//        loginBtn1.click();
//
////      int i = (int) (System.currentTimeMillis() / 1000) % 3600;
//        WebElement emailInput1 = wd.findElement(By.xpath("//input[1]"));
//        emailInput1.click();
//        emailInput1.clear();
//        emailInput1.sendKeys("avarion87@gmail.com");
//
//        WebElement passInput1 = wd.findElement(By.xpath("//input[2]"));
//        passInput1.click();
//        passInput1.clear();
//        passInput1.sendKeys("Illumiel");
//
//        wd.findElement(By.xpath("//button[2]")).click();
    }


    @AfterMethod
    public void tearDown() {
//        // wd.quit();
    }


}
