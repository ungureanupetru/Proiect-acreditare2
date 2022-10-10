package Tests;

import Pages.LoginPage;
import Pages.ShopPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShopTests {
    private WebDriver driver;

    private LoginPage loginPage;
    private ShopPage shopPage;

    @Before
    public void initializareShopTests(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        shopPage = new ShopPage(driver);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.get("http://qa5.fasttrackit.org:8008/");
    }

    @Test
    public void validShopTest(){
        shopPage.setClickshop();
        driver.findElement(By.cssSelector("li.post-1050.product.type-product.status-publish.product_cat-uncategorized.product_tag-produs-nou.instock.sale.shipping-taxable.purchasable.product-type-simple div.collection_desc.clearfix div a")).click();
        shopPage.setThirdpage();
        driver.findElement(By.cssSelector("li.post-972.product.type-product.status-publish.product_cat-accessories.last.instock.shipping-taxable.purchasable.product-type-simple div.collection_desc.clearfix div a")).click();
    }
    @After
    public void closevalidShopTest(){
        driver.quit();
    }

    @Test
    public void validApplyCuponTest(){
        shopPage.setClickshop();
        driver.findElement(By.cssSelector("li.post-34.product.type-product.status-publish.has-post-thumbnail.product_cat-music.first.instock.downloadable.virtual.purchasable.product-type-simple div.collection_desc.clearfix div a")).click();

        wait(3);

        shopPage.setClickcart();
        driver.findElement(By.cssSelector("#coupon_code")).sendKeys("Test1234");
        driver.findElement(By.cssSelector("div form table tbody tr:nth-child(2) td div input.button")).click();
        wait(2);
    }
    @After
    public void ClosevalidApplyCuponTest(){
        driver.quit();
    }
    @Test
    public void validCheckoutTest(){
        shopPage.setClickshop();
        driver.findElement(By.cssSelector("li.post-28.product.type-product.status-publish.has-post-thumbnail.product_cat-accessories.first.instock.sale.featured.shipping-taxable.purchasable.product-type-simple div.collection_desc.clearfix div a")).click();
        driver.findElement(By.cssSelector("li.post-28.product.type-product.status-publish.has-post-thumbnail.product_cat-accessories.first.instock.sale.featured.shipping-taxable.purchasable.product-type-simple div.collection_desc.clearfix div a")).click();
        wait(1);

        driver.findElement(By.cssSelector("#menu-item-72 a")).click();
        driver.findElement(By.cssSelector("#post-5 div div div div div div div a")).click();
        driver.findElement(By.cssSelector("#billing_first_name")).sendKeys("Petru-Alexandru");
        driver.findElement(By.cssSelector("#billing_last_name")).sendKeys("Ungureanu");
        driver.findElement(By.cssSelector("#billing_address_1#billing_address_1")).sendKeys("Bulevardul Chimiei");
        driver.findElement(By.cssSelector("#billing_city")).sendKeys("Iasi");
        driver.findElement(By.cssSelector("#billing_postcode")).sendKeys("523420");
        driver.findElement(By.cssSelector("#billing_phone")).sendKeys("07222333444");
        driver.findElement(By.cssSelector("#billing_email")).sendKeys("ungureanu.petru.alexandru@gmail.com");
        driver.findElement(By.cssSelector("#order_comments")).sendKeys("As dori sa fiu sunat cu o jumatate de ora inainte sa vina soferul cu coletul.");
        wait(2);
        driver.findElement(By.cssSelector("#place_order")).click();
        wait(5);

    }
    @After
    public void ClosevalidCheckoutTest(){
        driver.quit();
    }
    @Test
    public void validReviewTest(){
        shopPage.setClickshop();
        driver.findElement(By.cssSelector("#primary div nav ul li:nth-child(2) a")).click();

        driver.findElement(By.cssSelector("li.post-32.product.type-product.status-publish.has-post-thumbnail.product_cat-tshirts.first.instock.shipping-taxable.purchasable.product-type-simple div.collection_combine div div div a")).click();
        driver.findElement(By.cssSelector("#tab-title-additional_information > a")).click();

        driver.findElement(By.cssSelector("#tab-title-reviews a")).click();

        driver.findElement(By.cssSelector("#commentform div p span a.star-5")).click();
        driver.findElement(By.id("comment")).sendKeys("Imi doream de foarte multa vreme acest produs; stiu ca este foarte calitativ din cauza ca l-am mai avut odata dar pe alta culoare");
        driver.findElement(By.id("author")).sendKeys("Ungureanu Petru-Alexandru");
        driver.findElement(By.id("email")).sendKeys("ungureanu.petru.alexandru@gmail.com");
        driver.findElement(By.cssSelector("#submit")).click();

        wait(2);
    }
    @After
    public void ClosevalidReviewTest(){
        driver.quit();
    }

    @Test
    public void validSearchTest1(){
        driver.findElement(By.name("s")).sendKeys("Belt");
        driver.findElement(By.cssSelector("div.top-header.clearfix div div.headertwo-wrap div.search-form form button")).click();
        wait(4);
    }
    @After
    public void ClosevalidSearchTest1(){
        driver.quit();
    }

    @Test
    public void addproducttocartandremove(){
        shopPage.setClickshop();
        driver.findElement(By.cssSelector("li.post-43.product.type-product.status-publish.has-post-thumbnail.product_cat-accessories.instock.sale.shipping-taxable.purchasable.product-type-simple div.collection_desc.clearfix div a")).click();
        wait(2);
        shopPage.setClickcart();
        wait(2);
        driver.findElement(By.cssSelector("tr.woocommerce-cart-form__cart-item.cart_item td.product-remove a")).click();
        wait(2);
    }
    @After
    public void Closeaddproducttocartandremove(){
        driver.quit();
    }
    @Test
    public void sorttesting(){
        shopPage.setClickshop();
        driver.findElement(By.cssSelector("#primary div form select")).click();
        wait(2);
        driver.findElement(By.cssSelector("#primary div form select option:nth-child(2)")).click();
        wait(2);
    }
    @After
    public void closesorttesting(){
        driver.quit();
    }
    @Test
    public void trackingordertest(){
        loginPage.setClicmyaccount();
        loginPage.login("admin", "parola11");
        driver.findElement(By.cssSelector("div.u-column1.col-1 form p:nth-child(3) label")).click();
        driver.findElement(By.cssSelector("div.u-column1.col-1 form p:nth-child(3) button")).click();
        wait(2);
        shopPage.setClickshop();
        driver.findElement(By.cssSelector("li.post-32.product.type-product.status-publish.has-post-thumbnail.product_cat-tshirts.first.instock.shipping-taxable.purchasable.product-type-simple div.collection_combine div div div a")).click();
        driver.findElement(By.cssSelector("#menu-item-71 a")).click();
        driver.findElement(By.cssSelector("#place_order")).click();
        wait(5);
        driver.findElement(By.cssSelector("#menu-item-70 a")).click();
        driver.findElement(By.cssSelector("li.woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--orders a")).click();
        wait(5);
    }
    @After
    public void closetrackingordertest(){
        driver.quit();
    }

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}