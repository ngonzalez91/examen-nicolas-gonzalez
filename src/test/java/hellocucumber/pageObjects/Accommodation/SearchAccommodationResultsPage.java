package hellocucumber.pageObjects.Accommodation;

import hellocucumber.pageObjects.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchAccommodationResultsPage extends AbstractBasePage {

  // SELECTORS
  private By flight = By.cssSelector("cluster");

  // CONSTRUCTOR
  public SearchAccommodationResultsPage(WebDriver driver) {
    super(driver);
  }

  // METHODS
//  public void filterByStars (String criteria) {
//
//  }

//  public WebElement getCheapestAccommodation () {
//
//  }
}
