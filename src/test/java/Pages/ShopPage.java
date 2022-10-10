package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {
    private WebDriver driver;
    public ShopPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#menu-item-73 a")
    private WebElement clickshop;
    @FindBy(css = "#primary div nav ul li:nth-child(2) a")
    private WebElement secondpage;
    @FindBy(css = "#primary div nav ul li:nth-child(3) a")
    private WebElement thirdpage;
    @FindBy(css = "#primary div nav ul li:nth-child(4) a")
    private WebElement fourpage;
    @FindBy(css = "#menu-item-72 a")
    private WebElement clickcart;
    public void setClickshop(){
        clickshop.click();
    }
    public void setSecondpage(){
        secondpage.click();
    }
    public void setThirdpage(){
        thirdpage.click();
    }
    public void setFourpage(){
        fourpage.click();
    }
    public void setClickcart(){
        clickcart.click();
    }

}
