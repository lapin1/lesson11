import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;

class ChromeCreateTest {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = WebDriverManager.chromedriver().create();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    public void succesfullRegistration() {
        driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box/way2auto_jquery/registration.php");
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys("Yauheni");
        driver.findElement(By.cssSelector("p:nth-child(2) > input")).click();
        driver.findElement(By.cssSelector("p:nth-child(2) > input")).sendKeys("Lapin");
        driver.findElement(By.name("m_status")).click();
        driver.findElement(By.name("hobby")).click();
        driver.findElement(By.cssSelector("fieldset:nth-child(4) > select")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector("fieldset:nth-child(4) > select"));
            dropdown.findElement(By.xpath("//option[. = 'India']")).click();
        }
        driver.findElement(By.cssSelector(".time_feild:nth-child(2) > select")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector(".time_feild:nth-child(2) > select"));
            dropdown.findElement(By.xpath("//option[. = '1']")).click();
        }
        driver.findElement(By.cssSelector(".time_feild:nth-child(3) > select")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector(".time_feild:nth-child(3) > select"));
            dropdown.findElement(By.xpath("//option[. = '1']")).click();
        }
        driver.findElement(By.cssSelector(".time_feild:nth-child(4) > select")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector(".time_feild:nth-child(4) > select"));
            dropdown.findElement(By.xpath("//option[. = '2014']")).click();
        }
        driver.findElement(By.name("phone")).click();
        driver.findElement(By.name("phone")).sendKeys("44800900500");
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys("yauheni11");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("lapinzh@gmail.com");
        //driver.findElement(By.cssSelector("#register_form > fieldset:nth-child(9) > input")).click();
        //driver.findElement(By.cssSelector("#register_form > fieldset:nth-child(9) > input")).sendKeys("C:\\fakepath\\user.png");
        driver.findElement(By.cssSelector("textarea")).click();
        driver.findElement(By.cssSelector("textarea")).sendKeys("hello testing");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("superPassword11");
        driver.findElement(By.name("c_password")).click();
        driver.findElement(By.name("c_password")).sendKeys("superPassword11");
        driver.findElement(By.cssSelector("fieldset:nth-child(13) > input")).click();
        
        WebElement element = driver.findElement(By.cssSelector("fieldset:nth-child(13) > input"));
        Assertions.assertTrue(isClicked(element));
    }

    @Test
    public void unseccessfulRegistration() {
        driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys("Yauheni");
        driver.findElement(By.name("m_status")).click();
        driver.findElement(By.cssSelector("fieldset:nth-child(4) > select")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector("fieldset:nth-child(4) > select"));
            dropdown.findElement(By.xpath("//option[. = 'India']")).click();
        }
        driver.findElement(By.cssSelector(".time_feild:nth-child(3) > select")).click();
        {
            WebElement dropdown = driver.findElement(By.cssSelector(".time_feild:nth-child(3) > select"));
            dropdown.findElement(By.xpath("//option[. = '1']")).click();
        }
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys("yauheni11");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("superPassword11");
        driver.findElement(By.name("c_password")).click();
        driver.findElement(By.name("c_password")).sendKeys("superPassword11");
        driver.findElement(By.cssSelector("fieldset:nth-child(13) > input")).click();
        
        WebElement element = driver.findElement(By.cssSelector("fieldset:nth-child(13) > input"));
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
