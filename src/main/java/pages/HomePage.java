package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By thiTruongMenu = By.xpath("//button[@data-testid='nav-parent-thi-truong']");
    private By sensesOption = By.xpath("//li[@data-testid='header-menu-item-senses']");
    
    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public SensesPage clickSensesLink(){
        WebElement thiTruongMenuElement = wait.until(ExpectedConditions.visibilityOfElementLocated(thiTruongMenu));
        Actions actions = new Actions(driver);
        actions.moveToElement(thiTruongMenuElement).perform();
        WebElement sensesOptionElement = wait.until(ExpectedConditions.elementToBeClickable(sensesOption));
        sensesOptionElement.click();
        return new SensesPage(driver);
    }
}
