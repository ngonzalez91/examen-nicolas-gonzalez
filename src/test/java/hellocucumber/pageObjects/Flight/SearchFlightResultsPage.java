package hellocucumber.pageObjects.Flight;

import hellocucumber.pageObjects.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchFlightResultsPage extends AbstractBasePage {

  // SELECTORS
  private By flightsToolBoxContainer = By.cssSelector("toolbox-tabs");

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
//  public WebElement getMostExpensiveFlight () {
//
//  }

//  public void clickOnPurchaseFlight (WebElement flightToPurchase) {
//
//  }
//
//  public int numberFlightsReturned () {
//    return 1 ;
//  }

}
