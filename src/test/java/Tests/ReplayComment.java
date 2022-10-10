package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReplayComment {
    private WebDriver driver;

    @Before
    public void ReplayComment(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa5.fasttrackit.org:8008/");
    }
    @Test
    public void validReplayComment(){
        driver.findElement(By.cssSelector("#post-1 > div > div > div a")).click();
        wait(5);
        driver.findElement(By.cssSelector("#div-comment-1 div.reply a")).click();
        driver.findElement(By.cssSelector("#comment")).sendKeys("1234... Test, replay comment");
        driver.findElement(By.cssSelector("#author")).sendKeys("Ungureanu");
        driver.findElement(By.cssSelector("#email")).sendKeys("ungureanu.petru.alexandru@gmail.com");
        driver.findElement(By.cssSelector("#url")).sendKeys("www.google.com");
        driver.findElement(By.cssSelector("#submit")).click();
    }
    @After
    public void ClosevalidReplayComment(){
        driver.quit();
    }
    @Test
    public void validReplaythesamemessagetoaComment(){
        driver.findElement(By.cssSelector("#post-1 > div > div > div a")).click();
        driver.findElement(By.cssSelector("#div-comment-1 div.reply a")).click();
        driver.findElement(By.cssSelector("#comment")).sendKeys("1234... Test, replay comment");
        driver.findElement(By.cssSelector("#author")).sendKeys("Ungureanu");
        driver.findElement(By.cssSelector("#email")).sendKeys("ungureanu.petru.alexandru@gmail.com");
        driver.findElement(By.cssSelector("#url")).sendKeys("www.google.com");
        driver.findElement(By.cssSelector("#submit")).click();
        wait(5);
    }
    @After
    public void ClosevalidReplaythesamemessagetoaComment(){
        driver.quit();
    }
    @Test
    public void validReplaytoaCategory(){
        driver.findElement(By.cssSelector("#post-1 > div > div > div a")).click();
        driver.findElement(By.cssSelector("#comment")).sendKeys("1234... @Test,replay");
        driver.findElement(By.cssSelector("#author")).sendKeys("Ungureanu");
        driver.findElement(By.cssSelector("#email")).sendKeys("ungureanu.petru.alexandru@gmail.com");
        driver.findElement(By.cssSelector("#url")).sendKeys("www.google.com");
        driver.findElement(By.cssSelector("#submit")).click();
    }
    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
