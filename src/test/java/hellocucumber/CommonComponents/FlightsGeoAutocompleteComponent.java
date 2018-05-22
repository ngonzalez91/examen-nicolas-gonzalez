package hellocucumber.CommonComponents;

import hellocucumber.pageObjects.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FlightsGeoAutocompleteComponent extends AbstractBasePage {

  // SELECTORS
  private By container1     = By.cssSelector("div[class$='geo-show-autocomplete'] .geo-autocomplete-main");
  private By itemContainer1 = By.cssSelector("div[class$='geo-show-autocomplete'] .geo-autocomplete-main > div:nth-child(1) a");

  private By container2     = By.cssSelector(".ac-wrapper.-desktop.-show");
  private By itemContainer2 = By.cssSelector(".ac-wrapper.-desktop.-show ul > li:nth-child(1)");


  // CONSTRUCTOR
  public FlightsGeoAutocompleteComponent(WebDriver driver) {
    super(driver);
  }

  // METHODS
  public void clickOnAirport () {

    if (this.isVisible(container1)) {
      this.waitUntilPresenceOf(itemContainer1);
      this.clickItem(itemContainer1);
    } else {
      this.waitUntilPresenceOf(itemContainer2);
      this.clickItem(itemContainer2);
    }
  }

  public void clickItem (By bySelector) {
    driver.findElement(bySelector).click();
  }

  public boolean isVisible (By bySelector) {
    try{
      WebDriverWait wait = new WebDriverWait(driver, 120);
      wait.until(ExpectedConditions.visibilityOf(driver.findElement(bySelector)));

      return true;

    }catch(Exception ex){
      return false;
    }
  }

  public void waitUntilPresenceOf (By bySelector) {
    WebDriverWait wait = new WebDriverWait(driver, 120);

    wait.until(ExpectedConditions.presenceOfElementLocated(bySelector));
  }
}
