import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import java.util.HashMap;
import java.util.Map;

public class Task13TestSuit {
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
    public void changeInfoTest(){
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().setSize(new Dimension(1276, 775));
        driver.findElement(By.linkText("My personal info")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("lapinzh358@gmail.com");
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).sendKeys("superPass11");

        driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
        driver.findElement(By.cssSelector("li:nth-child(4) span:nth-child(2)")).click();
        driver.findElement(By.id("firstname")).click();
        driver.findElement(By.id("firstname")).click();
        driver.findElement(By.id("firstname")).sendKeys("yauhen");
        driver.findElement(By.id("lastname")).click();
        driver.findElement(By.id("lastname")).click();
        driver.findElement(By.id("lastname")).sendKeys("lapin");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("old_passwd")).click();
        driver.findElement(By.id("old_passwd")).sendKeys("superPass11");
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).sendKeys("superPass11");
        driver.findElement(By.id("confirmation")).click();
        driver.findElement(By.id("confirmation")).sendKeys("superPass11");
        driver.findElement(By.id("security_informations")).click();
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.cssSelector(".button-medium:nth-child(1) .icon-chevron-right")).click();

        String text = "Your personal information has been successfully updated.";
        Assertions.assertTrue(driver.getPageSource().contains(text));
    }

    @Test
    public void changeAddress() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().setSize(new Dimension(1276, 775));
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("lapinzh358@gmail.com");
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).sendKeys("superPass11");
        driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
        driver.findElement(By.cssSelector("li:nth-child(3) > a > span:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".address_update > .btn:nth-child(1) > span")).click();
        driver.findElement(By.id("address1")).click();
        driver.findElement(By.id("address1")).click();
        driver.findElement(By.id("center_column")).click();
        driver.findElement(By.id("address1")).sendKeys("85 Albert Bridge Rd12");
        driver.findElement(By.cssSelector(".required:nth-child(5)")).click();
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("center_column")).click();
        driver.findElement(By.id("city")).sendKeys("London");
        driver.findElement(By.cssSelector("#submitAddress > span")).click();

        String changedCity = "London";
        Assertions.assertTrue(driver.getPageSource().contains(changedCity));

    }
}
