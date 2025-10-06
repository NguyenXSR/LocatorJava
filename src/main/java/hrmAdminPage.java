import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class hrmAdminPage {

    public static void clickWithLog(WebElement element, String elementName) {
        element.click();
        System.out.println("Clicked on: " + elementName);
    }


    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        By TxtUsername = By.xpath("//input[@placeholder='Username']");
        WebElement Username = driver.findElement(TxtUsername);
        Username.sendKeys("Admin");

        By TxtPassword = By.xpath("//input[@placeholder='Password']");
        WebElement Password = driver.findElement(TxtPassword);
        Password.sendKeys("admin123");

        By BtnLogin = By.xpath("//button[@type='submit']");
        WebElement Login = driver.findElement(BtnLogin);
        Login.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
        System.out.println("Dashboard loaded successfully.");




        //1 Admin tab

        By Admin = By.xpath("//span[text()='Admin']");
        WebElement AdminTab = driver.findElement(Admin);
        clickWithLog(AdminTab, "Admin Tab - 1");

        //2 PIM tab

        By PIM = By.xpath("//span[text()='PIM']");
        WebElement PIMTab = driver.findElement(PIM);
        clickWithLog(PIMTab, "PIM Tab - 2");

        //3 Leave tab

        By Leave = By.xpath("//span[text()='Leave']");
        WebElement LeaveTab = driver.findElement(Leave);
        clickWithLog(LeaveTab, "Leave Tab - 3");

        //4 UserName Input
        WebElement adminTab = driver.findElement(By.xpath("//span[text()='Admin']"));
        adminTab.click();
        By UserName = By.xpath("//label[text()='Username']/following::input[1]");
        WebElement InputUserName = driver.findElement(UserName);
        clickWithLog(InputUserName, "Input UserName - 4");

        //5 Select User Role

        By userRole = By.xpath("//label[text()='User Role']/following::div[contains(@class,'oxd-select-wrapper')]");
        WebElement selectUserRole = driver.findElement(userRole);
        clickWithLog(selectUserRole, "Select User Role - 5");

        //6 Select Admin in User Role
        By userRoleDropdown = By.cssSelector(".oxd-grid-item:nth-child(2) .oxd-select-wrapper");
        WebElement uRoleDropdown = driver.findElement(userRoleDropdown);

        By adminOption = By.xpath("//div[@role='option']/span[text()='Admin']");
        WebElement adOption = wait.until(ExpectedConditions.visibilityOfElementLocated(adminOption));
        clickWithLog(adOption, "User Role: Admin - 6");

        //7 Select ESS in User Role
        uRoleDropdown.click();
        By essOption = By.xpath("//div[@role='option']/span[text()='ESS']");
        WebElement eOption = wait.until(ExpectedConditions.visibilityOfElementLocated(essOption));
        clickWithLog(eOption, "User Role: ESS - 7");

        //8 Employee Name Input
        By inputEmployeeName = By.xpath("//label[text()='Employee Name']/following::input[1]");
        WebElement inputName = driver.findElement(inputEmployeeName);
        clickWithLog(inputName,"Input Employee Name - 8");

        //9 Reset Button
        By resButton = By.xpath("//button[normalize-space()='Reset']");
        WebElement resetButton = driver.findElement(resButton);
        clickWithLog(resetButton, "Reset Button - 9");

        //10 Search Button
        By search = By.xpath("//button[normalize-space()='Reset']");
        WebElement searchButton = driver.findElement(search);
        clickWithLog(searchButton, "Search Button - 10");

        //11 User Management
        By management = By.xpath("//span[text()='User Management ']");
        WebElement userM = driver.findElement(management);
        clickWithLog(userM, "User Manager - 11");

        //12 Recorded UserName
        By recUserName = By.xpath("//div[@role='table']//div[text()='amali']");
        WebElement userNameRecorded = driver.findElement(recUserName);
        clickWithLog(userNameRecorded, "Recorded UserName - 12");

        //13 Recorded UserRole
        By recUserRole = By.xpath("//div[contains(@class,'table-card')][.//div[text()='amali']]//div[text()='ESS']");
        WebElement userRoleRecorded = driver.findElement(recUserRole);
        clickWithLog(userRoleRecorded, "Recorded UserRole - 13");

        //14 Delete icon
        By deleteIcon = By.xpath("//i[@class='oxd-icon bi-trash']");
        WebElement deleteButton = driver.findElement(deleteIcon);
        clickWithLog(deleteButton, "Delete Icon - 14");

        //15 Edit icon
        By editIcon = By.xpath("//i[@class='oxd-icon bi-pencil-fill']");
        WebElement editButton = driver.findElement(editIcon);
        clickWithLog(editButton, "Edit Icon - 15");

        //16 Header UserRole
        By headerUserR = By.xpath("//div[text()='User Role']");
        WebElement UserRole = driver.findElement(headerUserR);
        clickWithLog(UserRole, "Header UserRole - 16");

        //17 Header Employee Name
        By headerEmName = By.xpath("//div[text()='Employee Name']");
        WebElement employeeName = driver.findElement(headerEmName);
        clickWithLog(employeeName, "Header Employee Name - 17");








        driver.quit();
    }
}
