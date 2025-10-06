import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class amazonSearchResultPage {

    public static void checkDisplay(WebDriver driver, By locator, String elementName) {
        try {
            WebElement element = driver.findElement(locator);
            if (element.isDisplayed()) {
                System.out.println("Displayed: " + elementName);
            } else {
                System.out.println("Not visible: " + elementName);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Not found: " + elementName);
        } catch (Exception e) {
            System.out.println("Error checking: " + elementName + " -> " + e.getMessage());
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Handle pop-up "Continue shopping" if exists
        try {
            WebElement btnContinue = driver.findElement(By.xpath("//button[text()='Continue shopping']"));
            btnContinue.click();
        } catch (Exception ignored) {
        }

        // Search for "adidas"
        try {
            WebElement txtSearch = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
            txtSearch.sendKeys("adidas");
            WebElement btnSearch = driver.findElement(By.cssSelector("input#nav-search-submit-button"));
            btnSearch.click();
        } catch (NoSuchElementException e) {

            WebElement txtSearch = driver.findElement(By.cssSelector("input#nav-bb-search"));
            txtSearch.sendKeys("adidas");
            WebElement btnSearch = driver.findElement(By.cssSelector("input.nav-bb-button"));
            btnSearch.click();
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


        checkDisplay(driver, By.xpath("//div[@role='listitem'][3]//img"), "1 - Image of 3rd item");
        checkDisplay(driver, By.xpath("(//div[@class='a-section aok-inline-block'])[4]"), "2 - Price list of 4th item");
        checkDisplay(driver, By.xpath("(//span[@class='a-price'])[7]"), "3 - Price of 7th item");
        checkDisplay(driver, By.cssSelector("input#twotabsearchtextbox"), "4 - Search bar");
        checkDisplay(driver, By.xpath("//a[@id='nav-cart']"), "5 - Cart button");
        checkDisplay(driver, By.xpath("(//ol[@class='a-carousel'])[1]/li[2]"), "6 - Women footwear collection card");
        checkDisplay(driver, By.xpath("//div[@role='listitem'][3]//a/h2"), "8 - Title (H2) of 3rd item");
        checkDisplay(driver, By.xpath("//div[@role='listitem'][2]//div[3]/div[4]/div[1]"), "9 - Delivery time");
        checkDisplay(driver, By.xpath("//div[@role='listitem'][1]//span[text()='adidas']"), "10 - Adidas title");
        checkDisplay(driver, By.xpath("//h2[text()='Shop top adidas collections']"), "11 - Shop top adidas collections");
        checkDisplay(driver, By.xpath("//div[@id='gender']//ul/span[1]/span[1]//div[1]"), "12 - Gender > Checkbox men");
        checkDisplay(driver, By.xpath("//div[@id='search']/span//h2/span[1]"), "13 - Search result");
        checkDisplay(driver, By.xpath("//div[@id='search']//a[text()='Bags']"), "14 - Bags collection card");

        Thread.sleep(3000);
        driver.quit();
    }

}
