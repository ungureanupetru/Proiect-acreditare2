package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#menu-item-70 > a")
    private WebElement clicmyaccount;

    public void setClicmyaccount(){
        clicmyaccount.click();
    }


    public void register(String username, String password){
        WebElement usernameTxt = driver.findElement(By.id("reg_email"));
        WebElement passwordTxt = driver.findElement(By.id("reg_password"));
        usernameTxt.sendKeys(username);
        passwordTxt.sendKeys(password);
    }
    public void login(String usernamelogin1, String passwordlogin1){
        WebElement usernamelogin = driver.findElement(By.id("username"));
        WebElement passwordlogin = driver.findElement(By.id("password"));
        usernamelogin.sendKeys(usernamelogin1);
        passwordlogin.sendKeys(passwordlogin1);
    }
    public void CloseBrowser(){
        driver.quit();
    }
}
