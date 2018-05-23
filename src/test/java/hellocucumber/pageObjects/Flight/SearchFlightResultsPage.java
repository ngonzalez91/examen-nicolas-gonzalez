package hellocucumber.pageObjects.Flight;

import hellocucumber.pageObjects.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.List;

public class SearchFlightResultsPage extends AbstractBasePage {

  // SELECTORS
  private By flightsToolBoxContainer = By.cssSelector("toolbox-tabs");
  private By flightResultsContainer  = By.cssSelector(".flights-cluster");
  private By flightPrice             = By.cssSelector(".cluster-wrapper > fare main-fare .price-amount");
  private By progressBar             = By.cssSelector(".progress-bar-content-container");
  private By buyButton               = By.cssSelector(".cluster-wrapper > fare buy-button a");

  // CONSTRUCTOR
  public SearchFlightResultsPage(WebDriver driver) {
    super(driver);
  }

  // METHODS

  public Boolean waitForFlightsToolBoxToBeVisible () {
    try {
      WebDriverWait wait = new WebDriverWait(driver,60);
      wait.until(ExpectedConditions.visibilityOf(driver.findElement(flightsToolBoxContainer)));

      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public boolean waitUntilPresenceOfFlights () {
    try {
      WebDriverWait wait = new WebDriverWait(driver,60);
      wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(flightResultsContainer));

      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public boolean waitUntilPresenceOfProgressBar () {
    try {
      WebDriverWait wait = new WebDriverWait(driver,60);
      wait.until(ExpectedConditions.presenceOfElementLocated(progressBar));

      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public boolean waitUntilProgressBarNotPresent () {
    try {
      WebDriverWait wait = new WebDriverWait(driver,60);
      wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(progressBar)));

      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public WebElement getMostExpensiveFlight() {
    this.waitUntilPresenceOfProgressBar();
    this.waitUntilPresenceOfFlights();
    List<WebElement> listOfPrices = driver.findElements(flightPrice);
    Integer sizeOfListOfPrices = listOfPrices.size();
    Float maxPrice = Float.valueOf(0);
    Integer indexOfBuyButton = 0;
    for (int i = 0; i < sizeOfListOfPrices ; i++) {
      Float currentPrice = Float.parseFloat(listOfPrices.get(i).getText());
      if (currentPrice > maxPrice) {
        maxPrice = currentPrice;
        indexOfBuyButton = i;
      }
    }
    List<WebElement> listOfBuyButtons = driver.findElements(buyButton);
    return listOfBuyButtons.get(indexOfBuyButton);
  }

//  public void clickOnPurchaseFlight (WebElement flightToPurchase) {
//
//  }
//
//  public int numberFlightsReturned () {
//    return 1 ;
//  }

}
