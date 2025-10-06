import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class amazonSearchResultPage {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        By byBtnContinue = By.xpath("  //button[text()='Continue shopping']");
        WebElement btnContinue = driver.findElement(byBtnContinue);
        btnContinue.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // search adidas action
        // in case amazon has a/b testing

        try {
            // 1st try
            WebElement txtSearch = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
            txtSearch.sendKeys("adidas");

            WebElement btnSearch = driver.findElement(By.cssSelector("input#nav-search-submit-button"));
            btnSearch.click();

        } catch (NoSuchElementException e) {
            // fallback
            WebElement txtSearch = driver.findElement(By.cssSelector("input#nav-bb-search"));
            txtSearch.sendKeys("adidas");

            WebElement btnSearch = driver.findElement(By.cssSelector("input.nav-bb-button"));
            btnSearch.click();
        }



      /*  WebElement txtSearch;
        try {
            txtSearch = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        } catch (NoSuchElementException e) {
            txtSearch = driver.findElement(By.cssSelector("input#nav-bb-search"));
        }
        txtSearch.sendKeys("adidas");*/


//        By byTxtSearch = By.cssSelector("input#nav-bb-search");
//        WebElement txtSearch = driver.findElement(byTxtSearch);
//        txtSearch.sendKeys("adidas");

      /*  WebElement btnSearch;
        try {
            btnSearch = driver.findElement(By.cssSelector("input#nav-search-submit-button"));
        } catch (NoSuchElementException e) {
            btnSearch = driver.findElement(By.cssSelector("input.nav-bb-button"));
        }
        btnSearch.click();*/

//        By byBtnSearch = By.cssSelector("input.nav-bb-button");
//        WebElement btnSearch = driver.findElement(byBtnSearch);
//        btnSearch.click();

         wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        // 1 img of the 3rd item in the result section
        By byThirdItem = By.xpath("//div[@role='listitem'][3]//img"); //div[data-asin='B0CKMCGWQS'] img
        WebElement thirdItem = driver.findElement(byThirdItem);
        if (thirdItem.isDisplayed()){
            System.out.println("1");
        };


        // 2 price list of the 4th item in the result section
        By byPriceList = By.xpath("(//div[@class='a-section aok-inline-block'])[4]");
        WebElement priceList = driver.findElement(byPriceList);
        if (priceList.isDisplayed()){
            System.out.println("2");
        };



        // 3 price of the 7th item in the result section
        By byPrice = By.xpath("(//span[@class='a-price'])[7]");
        WebElement price = driver.findElement(byPrice);
        if (price.isDisplayed()){
            System.out.println("3");
        };


        // 4 search bar
        By bySearchBar = By.cssSelector("input#twotabsearchtextbox");
        WebElement searchBar = driver.findElement(bySearchBar);
        if (searchBar.isDisplayed()){
            System.out.println("4");
        };

        // 5  cart button
        By byCartBtn = By.xpath("//a[@id='nav-cart']");
        WebElement cartBtn = driver.findElement(byCartBtn);
        if (cartBtn.isDisplayed()){
            System.out.println("5");
        };

        // 6  Shop adidas categories >> Women footwear collection card
        By byWmFootwearCard = By.xpath("(//ol[@class='a-carousel'])[1]/li[2]");
        WebElement wmFootwearCard = driver.findElement(byWmFootwearCard);
        if (wmFootwearCard.isDisplayed()){
            System.out.println("6");
        };

        //7 kg co checkbox size
        System.out.println("7: Kg co checkbox size");

        // 8 h2 title of 3rd item
        By byH2 = By.xpath("//div[@role='listitem'][3]//a/h2"); ////div[@data-asin='B0CKMCGWQS']//a/h2
        WebElement h2 = driver.findElement(byH2);
        if (h2.isDisplayed()){
            System.out.println("8");
        };

        // 9 delivery time
        By byDeliTime = By.xpath("//div[@role='listitem'][2]//div[3]/div[4]/div[1]"); // //div[@data-asin='B06XHCYHLG']//div[3]/div[4]/div[1]
        WebElement deliTime = driver.findElement(byDeliTime);
        if (deliTime.isDisplayed()){
            System.out.println("9");
        };


        // 10 adidas title
        By byAdidasH2 = By.xpath("//div[@role='listitem'][1]//div[1]//span[text()='adidas']");
        WebElement adidasH2 = driver.findElement(byAdidasH2);
        if (adidasH2.isDisplayed()){
            System.out.println("10");
        };

        // 11 Shop top adidas collections
        By byTopCollection = By.xpath("//h2[text()='Shop top adidas collections']");
        WebElement topCollection = driver.findElement(byTopCollection);
        if (topCollection.isDisplayed()){
            System.out.println("11");
        };


        // 12 Gender > checkbox men
        By byGenderChkbox = By.xpath("//div[@id='gender']//ul/span[1]/span[1]//div[1]");
        WebElement genderChkbox = driver.findElement(byGenderChkbox);
        if (genderChkbox.isDisplayed()){
            System.out.println("12");
        };

        // 13 search result
        By bySearchResults = By.xpath("//div[@id='search']/span//h2/span[1]");
        WebElement searchResults = driver.findElement(bySearchResults);
        if (searchResults.isDisplayed()){
            System.out.println("13");
        };


        // 14 bags collection card
        By byBagsCollection = By.xpath("//div[@id='search']//a[text()='Bags']");
        WebElement bagsCollection = driver.findElement(byBagsCollection);
        if (bagsCollection.isDisplayed()){
            System.out.println("14");
        };


        Thread.sleep(3000);
       // driver.quit();

    }

}
