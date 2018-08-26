package myprojects.automation.assignment3.tests;


import org.openqa.selenium.support.events.EventFiringWebDriver;
import myprojects.automation.assignment3.BaseScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class CreateCategoryTest extends BaseScript {
    public static void main(String[] args) throws InterruptedException {
        // TODO prepare driver objec
//        WebDriver driver = getDriver();
        EventFiringWebDriver driver =
                new EventFiringWebDriver(getDriver());
        driver.register(new WebDriverLogger());

        // login
        driver.get(Properties.getBaseAdminUrl());
        WebElement fieldEmail = driver.findElement(By.id("email"));
        fieldEmail.sendKeys("webinar.test@gmail.com");

        WebElement fieldPasswd = driver.findElement(By.id("passwd"));
        fieldPasswd.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement button = driver.findElement(By.name("submitLogin"));
        button.click();

        // create category
        try {
            Sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Actions actions = new Actions(driver);
        WebElement menuHoverLink = driver.findElement(By.linkText("Каталог"));
        actions.moveToElement(menuHoverLink).perform();
        try {
            Sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.linkText("категории")).click();
        try {
            Sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("page-header-desc-category-new_category")).click();
        try {
            Sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("name_1")).sendKeys("Новая категория");
        driver.findElement(By.id("category_form_submit_btn")).click();
        // check that new category appears in Categories table
        try {
            Sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.name("categoryFilter_name")).sendKeys("Новая категория");
        driver.findElement(By.id("submitFilterButtoncategory")).click();

        if(driver.findElements(By.xpath("//table//td[contains(text(),'Новая категория')]")).size()>0){
            System.out.println("OK!");
        }
        // finish script
        driver.quit();
    }
    public static void Sleep(int millis) throws java.lang.InterruptedException{
        Thread.sleep(millis);
    }
}
