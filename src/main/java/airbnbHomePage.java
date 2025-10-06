import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class airbnbHomePage {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demo4.cybersoft.edu.vn/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // 1 logo
        By byLogo = By.xpath("//nav/div/a[1]");
        WebElement logo = driver.findElement(byLogo);
        if (logo.isDisplayed()){
            System.out.println("1 logo");
        };

        // 2 nav home
        By byHomeNav = By.xpath("//a[text()='Home']");
        WebElement homeNav = driver.findElement(byHomeNav);
        if (homeNav.isDisplayed()){
            System.out.println("2");
        };

        // 3 nav About
        By byAboutNav = By.xpath("//a[text()='About']");
        WebElement aboutNav = driver.findElement(byAboutNav);
        if (aboutNav.isDisplayed()){
            System.out.println("3");
        };


        // 4 profile icon
        By byProfIcon = By.cssSelector("img.h-10");
        WebElement profIcon = driver.findElement(byProfIcon);
        profIcon.click();
        if (profIcon.isDisplayed()){
            System.out.println("4");
        };


        // 5 destination search
        By byDesSearch = By.xpath("//div[@id='root']/div[2]/div/div[1]");
        WebElement desSearch = driver.findElement(byDesSearch);
        desSearch.getLocation();
        if (desSearch.isDisplayed()){
            System.out.println("5");
        };

        // 6 date search
        By byDateSearch = By.xpath("//div[@id='root']/div[2]/div/div[3]");
        WebElement dateSearch = driver.findElement(byDateSearch);
        if (dateSearch.isDisplayed()){
            System.out.println("6");
        };


        // 7 no of guest
        By byGuestNo = By.xpath("//div[@id='root']/div[2]/div/div[5]");
        WebElement guestNo = driver.findElement(byGuestNo);
        guestNo.click();
        if (guestNo.isDisplayed()){
            System.out.println("7");
        };


        // 8 +
        By byIncreaseBtn = By.xpath("//div[@id='root']//div[5]/div[2]/div/button[2]");
        WebElement increaseBtn = driver.findElement(byIncreaseBtn);
        if (increaseBtn.isDisplayed()){
            System.out.println("8");
        };


        // 9 -
        By byDecreaseBtn = By.xpath("//div[@id='root']//div[5]/div[2]/div/button[1]");
        WebElement decreaseBtn = driver.findElement(byDecreaseBtn);
        if (decreaseBtn.isDisplayed()){
            System.out.println("9");
        };

        // 10  HCM card
        By byHcmCard = By.xpath("//div[@id='root']/div[3]/div[1]/div[1]/a[1]");
        WebElement hcmCard = driver.findElement(byHcmCard);
        if (hcmCard.isDisplayed()){
            System.out.println("10");
        };

        // 11 Can Tho card title
        By byCtCardH2 = By.xpath("//div[@id='root']/div[3]/div[1]/div[1]/a[1]");
        WebElement ctCardH2 = driver.findElement(byCtCardH2);
        if (ctCardH2.isDisplayed()){
            System.out.println("11");
        };

        // 12 Destination type option

        By byDestinationType = By.xpath("//div[@id='root']/div[2]/div[2]/button[1]");
        WebElement destinationType = driver.findElement(byDestinationType);
        if (destinationType.isDisplayed()){
            System.out.println("12");
        };

        // 13 price option

        By byPriceOpt = By.xpath("//div[@id='root']/div[2]/div[2]/button[2]");
        WebElement priceOpt = driver.findElement(byPriceOpt);
        if (priceOpt.isDisplayed()){
            System.out.println("13");
        };

        // 14 Nha Trang driving time duration

        By byDrivingTime = By.xpath("//div[@id='root']/div[3]/div[1]/div[1]/a[3]//p");
        WebElement drivingTime = driver.findElement(byDrivingTime);
        if (drivingTime.isDisplayed()){
            System.out.println("14");
        };


        Thread.sleep(3000);
        driver.quit();
    }

}
