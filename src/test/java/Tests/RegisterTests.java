package Tests;

import Pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTests {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void initializareRegisterTest() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.get("http://qa5.fasttrackit.org:8008/");
    }

    @Test
    public void validRegisterTest(){
        loginPage.setClicmyaccount();
        loginPage.register("ungureanu.petru.alexandru@gmail.ro", "Alexandru2002@");
        driver.findElement(By.cssSelector("p.woocommerce-FormRow.form-row button")).click();

        wait(3);
    }
    @After
    public void ClosevalidRegisterTest(){
        loginPage.CloseBrowser();
    }
    @Test
    public void Registerwithoutamail(){
        loginPage.setClicmyaccount();
        loginPage.register("admin", "1234567890");
        driver.findElement(By.cssSelector("p.woocommerce-FormRow.form-row button")).click();
        //Register without a mail
    }
    @After
    public void CloseTest(){
        loginPage.CloseBrowser();
    }
    @Test
    public void Registerwithaweakpassword(){
        loginPage.setClicmyaccount();
        loginPage.register("ungureanu.petru.alexandru@gmail.com","parola11");
        driver.findElement(By.cssSelector("p.woocommerce-FormRow.form-row button")).click();
    }
    @After
    public void CloseTest1(){
        loginPage.CloseBrowser();
    }
    @Test
    public void Registerwithaaccountalerdycreated(){
        loginPage.setClicmyaccount();
        loginPage.register("ungureanu.petru.alexandru@gmail.ro", "Alexandru2002@");
        driver.findElement(By.cssSelector("p.woocommerce-FormRow.form-row button")).click();
    }
    @After
    public void closeRegisterwithaaccountalerdycreated(){
        loginPage.CloseBrowser();
    }
    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}