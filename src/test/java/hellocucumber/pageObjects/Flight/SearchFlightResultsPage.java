package hellocucumber.pageObjects.Flight;

import hellocucumber.pageObjects.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchFlightResultsPage extends AbstractBasePage {

  // SELECTORS
  private By flight = By.cssSelector("cluster");

  // CONSTRUCTOR
  public SearchFlightResultsPage(WebDriver driver) {
    super(driver);
  }

  // METHODS
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
