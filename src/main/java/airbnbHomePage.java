import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class airbnbHomePage {
    public static void checkDisplay(WebDriverWait wait, By locator, String elementName) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            if (element.isDisplayed()) {
                System.out.println("Visible: " + elementName);
            } else {
                System.out.println("Not visible: " + elementName);
            }
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for: " + elementName);
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + elementName);
        } catch (Exception e) {
            System.out.println("Error checking element: " + elementName + " | " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        WebDriver driver = null;
        try {

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setExperimentalOption("useAutomationExtension", false);

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.get("https://demo4.cybersoft.edu.vn/");


            // 1. Logo
            checkDisplay(wait, By.xpath("//nav//a[contains(@href,'/home') or contains(@href,'/')]//img"), "Logo - 1");

            // 2. Home Nav
            checkDisplay(wait, By.xpath("//nav//a[normalize-space()='Home']"), "Home Nav - 2");

            // 3. About Nav
            checkDisplay(wait, By.xpath("//nav//a[normalize-space()='About']"), "About Nav - 3");

            // 4. Profile Icon
            checkDisplay(wait, By.xpath("//nav//img[contains(@class,'h-10')]"), "Profile Icon - 4");

            // 5. Destination Search Box
            checkDisplay(wait, By.xpath("//p[normalize-space()='Địa điểm']"), "Destination Search Box - 5");

            // 6. Date Search
            checkDisplay(wait, By.xpath("//div[@id='root']/div[2]/div[1]/div[3]"), "Date Search Box - 6");

            // 7. Guest Selector Button
            checkDisplay(wait, By.xpath("//div[@id='root']/div[2]/div/div[5]"), "Guest Selector - 7");

            // 8. Increase Guest (+)
            checkDisplay(wait, By.xpath("//div[@id='root']//div[5]/div[2]/div/button[2]"), "Increase Guest Button - 8");

            // 9. Decrease Guest (-)
            checkDisplay(wait, By.xpath("//div[@id='root']//div[5]/div[2]/div/button[1]"), "Decrease Guest Button - 9");

            // 10. HCM Card
            checkDisplay(wait, By.xpath("//a[contains(@href,'ho-chi-minh')]"), "HCM Card - 10");

            // 11. Can Tho Card Title
            checkDisplay(wait, By.xpath("//a[contains(@href,'can-tho')]//h2"), "Can Tho Card Title - 11");

            // 12. Destination Type Option
            checkDisplay(wait, By.xpath("//button[contains(.,'Loại chỗ ở')]"), "Destination Type Option - 12");

            // 13. Price Option
            checkDisplay(wait, By.xpath("//button[contains(.,'Giá')]"), "Price Option - 13");

            // 14. Nha Trang Driving Time
            checkDisplay(wait, By.xpath("//a[contains(@href,'nha-trang')]//p[contains(text(),'giờ') or contains(text(),'phút')]"), "Nha Trang Driving Time - 14");


        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

        driver.quit();
        }
    }

