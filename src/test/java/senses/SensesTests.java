package senses;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTests;
import pages.SensesPage;

public class SensesTests extends BaseTests {
    @Test
    public void testSuccessfulLogin(){
    SensesPage sensesPage = homePage.clickSensesLink();
    String stockName = "DSE";
    String searchText = "DS";

    sensesPage.searchStock(searchText);
    sensesPage.selectStock(stockName);
    sensesPage.clickShareButton();

    String shareLink = sensesPage.getShareLink(); 
    System.out.println("Share link: " + shareLink);

    Assert.assertTrue(shareLink.contains(stockName), "Share link does not contain "+ stockName + " symbol");
    }

    @Test
    public void testSelectStockFromTopSearch(){
        SensesPage sensesPage = homePage.clickSensesLink();
        int position = 3;

        sensesPage.selectStockAtPosition(position);

        Assert.assertTrue(sensesPage.isOnStockDetailPage(), "Not on the stock detail page");

        System.out.printf("The stock at position %d in the top stocks is: %s%n", position, sensesPage.getStockSymbol());
    }
}
