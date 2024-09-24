package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SensesPage {
    private WebDriver driver;   
    private By shareButton = By.xpath("//button[@aria-label='share']");
    private By searchBox = By.xpath("//input[@data-testid='input-search-symbol']");
    private By shareLink = By.xpath("//button[@aria-label='Copy']/preceding-sibling::p");
    private By stockDetailTitle = By.xpath("//div[@data-testid='block-price-quote']/parent::div//h2");
    private WebDriverWait wait;


    public SensesPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void searchStock(String stockSymbol) {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        searchInput.clear();
        searchInput.sendKeys(stockSymbol);
    }

    public void selectStock(String stockName) {
        WebElement stockResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-testid='symbol-" + stockName + "']")));
        stockResult.click();
    }

    public void clickShareButton() {
        WebElement shareBtn = wait.until(ExpectedConditions.elementToBeClickable(shareButton));
        shareBtn.click();
    }

    public String getShareLink() {
        WebElement shareLinkElement = wait.until(ExpectedConditions.visibilityOfElementLocated(shareLink));
        return shareLinkElement.getText();
    }

    public void selectStockAtPosition(int position) {
        WebElement stockResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[.//div[text()='Top tìm kiếm']]//button[" + position + "]")));
        stockResult.click();
    }

    public boolean isOnStockDetailPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(stockDetailTitle));
        return driver.getCurrentUrl().contains("senses/co-phieu");
    }

    public String getStockSymbol() {
        WebElement stockDetailTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(stockDetailTitle));
        return stockDetailTitleElement.getText();
    }
}
