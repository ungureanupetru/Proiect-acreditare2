package Tests;

import Pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;



    @Before
    public void initializareLoginTest() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.get("http://qa5.fasttrackit.org:8008/");

    }

    @Test
    public void validLoginTest() {
        loginPage.setClicmyaccount();
        loginPage.login("ungureanu.petru.alexandru@gmail.ru", "Alexandru2002");
        driver.findElement(By.cssSelector("div.u-column1.col-1 form p:nth-child(3) label")).click();
        driver.findElement(By.cssSelector("div.u-column1.col-1 form p:nth-child(3) button")).click();
        wait(2);
        // Cu un cont care nu a fost creat.
    }
    @After
    public void CloseLoginTest(){
        loginPage.CloseBrowser();
    }


    @Test
    public void validLoginTest2(){
        loginPage.setClicmyaccount();
        loginPage.login("admin", "parola11");
        driver.findElement(By.cssSelector("div.u-column1.col-1 form p:nth-child(3) label")).click();
        driver.findElement(By.cssSelector("div.u-column1.col-1 form p:nth-child(3) button")).click();
        wait(2);
        // Cu un cont care este creat.
    }
    @After
    public void CloseLoginTest2(){
        loginPage.CloseBrowser();
    }
    @Test
    public void validResetPasswordTest(){
        loginPage.setClicmyaccount();
        driver.findElement(By.cssSelector("p.woocommerce-LostPassword.lost_password a")).click();
        driver.findElement(By.cssSelector("#user_login")).sendKeys("ungureanu.petru.alexandru@gmail.com");
        driver.findElement(By.cssSelector("form p:nth-child(4) button")).click();
        wait(2);
    }
    @After
    public void ClosevalidResetPasswordTest(){
        loginPage.CloseBrowser();
    }
    @Test
    public void loginwithoutthecorrectpassword(){
        loginPage.setClicmyaccount();
        loginPage.login("admin","1234567890");
        driver.findElement(By.cssSelector("div.u-column1.col-1 form p:nth-child(3) label")).click();
        driver.findElement(By.cssSelector("div.u-column1.col-1 form p:nth-child(3) button")).click();
    }
    @After
    public void closeloginwithoutthecorrectpassword(){
        loginPage.CloseBrowser();
    }
    @Test
    public void Changeshippingadresstoaaccount(){
        loginPage.setClicmyaccount();
        loginPage.login("admin", "parola11");
        driver.findElement(By.cssSelector("div.u-column1.col-1 form p:nth-child(3) label")).click();
        driver.findElement(By.cssSelector("div.u-column1.col-1 form p:nth-child(3) button")).click();
        wait(2);
        driver.findElement(By.cssSelector("li.woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--edit-address a")).click();
        wait(2);
        driver.findElement(By.cssSelector("div.u-column2.col-2.woocommerce-Address header a")).click();
        wait(2);
        driver.findElement(By.cssSelector("#shipping_first_name")).sendKeys("fasdfd");
        driver.findElement(By.cssSelector("#shipping_last_name")).sendKeys("gfdasg");
        driver.findElement(By.cssSelector("#shipping_address_1")).sendKeys("312431");
        driver.findElement(By.cssSelector("#shipping_city")).sendKeys("gadsgsa");
        driver.findElement(By.cssSelector("#shipping_postcode")).sendKeys("3213123");
    }
    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
