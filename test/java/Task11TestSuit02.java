import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

class Task11TestSuit02 {

    WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeEach
    void setup() {
        driver = WebDriverManager.chromedriver().create();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    public void userRegistration() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().setSize(new Dimension(1152, 707));
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email_create")).click();
        vars.put("EmailTest", js.executeScript("return \"lapinzh\" + Math.floor(Math.random() * 1000) + \"@gmail.com\""));
        driver.findElement(By.id("email_create")).sendKeys(vars.get("EmailTest").toString());
        driver.findElement(By.cssSelector("#SubmitCreate > span")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("Yauheni");
        driver.findElement(By.id("customer_lastname")).click();
        driver.findElement(By.id("customer_lastname")).sendKeys("Lapin");
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).sendKeys("superPass11");
        driver.findElement(By.id("days")).click();
        {
            Select day = new Select(driver.findElement(By.id("days")));
            day.selectByVisibleText("-");
            day.selectByValue("29");
        }
        driver.findElement(By.id("months")).click();
        {
            Select month = new Select(driver.findElement(By.id("months")));
            month.selectByVisibleText("-");
            month.selectByValue("6");
        }
        driver.findElement(By.id("years")).click();
        {
            Select year = new Select(driver.findElement(By.id("years")));
            year.selectByVisibleText("-");
            year.selectByValue("1997");
        }
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.id("company")).click();
        driver.findElement(By.id("company")).sendKeys("Andersen");
        driver.findElement(By.id("address1")).click();
        driver.findElement(By.id("address1")).sendKeys("85 Albert Bridge Rd");
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys("London");
        driver.findElement(By.id("id_state")).click();
        {
            WebElement dropdown = driver.findElement(By.id("id_state"));
            dropdown.findElement(By.xpath("//option[. = 'Alaska']")).click();
        }
        driver.findElement(By.id("postcode")).click();
        driver.findElement(By.id("postcode")).sendKeys("12345");
        driver.findElement(By.id("id_country")).click();
        driver.findElement(By.id("other")).click();
        driver.findElement(By.id("other")).sendKeys("hello testing 2");
        driver.findElement(By.id("phone")).click();
        driver.findElement(By.id("phone")).sendKeys("44800900700");
        driver.findElement(By.id("phone_mobile")).click();
        driver.findElement(By.id("phone_mobile")).sendKeys("44800900902");
        driver.findElement(By.cssSelector("#submitAccount > span")).click();
        
        WebElement element = driver.findElement(By.cssSelector("#submitAccount > span"));
        Assertions.assertTrue(isClicked(element));
    }

    @Test
    public void productPurchase() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().setSize(new Dimension(1152, 707));
        driver.findElement(By.linkText("Women")).click();
        driver.findElement(By.cssSelector(".product_img_link > .replace-2x")).click();
        driver.findElement(By.id("group_1")).click();
        {
            Select size = new Select(driver.findElement(By.id("group_1")));
            size.selectByVisibleText("S");
            size.selectByValue("2");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("color_14")).click();
        driver.findElement(By.cssSelector(".exclusive > span")).click();
        driver.findElement(By.cssSelector(".button-medium > span")).click();
        driver.findElement(By.cssSelector(".standard-checkout > span")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("lapinzh358@gmail.com");
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).sendKeys("superPass11");
        driver.findElement(By.id("login_form")).click();
        driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
        driver.findElement(By.cssSelector(".button:nth-child(4) > span")).click();
        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.cssSelector(".standard-checkout > span")).click();
        driver.findElement(By.linkText("Pay by bank wire (order processing will be longer)")).click();
        driver.findElement(By.cssSelector("#cart_navigation span")).click();
        
        WebElement element = driver.findElement(By.cssSelector("#cart_navigation span"));
        Assertions.assertTrue(isClicked(element));
    }
    
    public boolean isClicked(WebElement element){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    

}

