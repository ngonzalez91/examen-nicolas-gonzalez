package hellocucumber.CommonComponents;

import hellocucumber.pageObjects.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlightsGeoAutocompleteComponent extends AbstractBasePage {

  // SELECTORS
  private By container1     = By.cssSelector(".geo-autocomplete-group");
  private By itemContainer1  = By.cssSelector(".geo-autocomplete-group > ul > li > a");

  private By container2     = By.cssSelector(".ac-group-container");
  private By itemContainer2 = By.cssSelector(".ac-group-container .ac-group-items > li > a");

  // CONSTRUCTOR
  public FlightsGeoAutocompleteComponent(WebDriver driver) {
    super(driver);
  }

  // METHODS
  public void clickOnAirport (Integer indexOfItem ) {
    if (this.isContainer1Present()) {
      System.out.println("------ >>> Espacioooo container 1 ---->>> ");

      waitUntilItemsAreAllVisibles("container1");

      driver.findElements(itemContainer1).get(indexOfItem - 1).click();

      waitUntilContainerIsNotVisible ("container1");
    } else {
      System.out.println("------ >>> Espacioooo container 2 ---->>> ");

      waitUntilItemsAreAllVisibles("container1");

      driver.findElements(itemContainer1).get(indexOfItem - 1).click();

      waitUntilContainerIsNotVisible ("container1");
    }
  }

  public boolean isContainer1Present () {
    try{

      WebDriverWait wait = new WebDriverWait(driver, 120);
      wait.until(ExpectedConditions.visibilityOf(driver.findElement(container1)));

      return true;

    }catch(Exception ex){

      return false;

    }
  }

  public void waitUntilItemsAreAllVisibles (String nameOfContainer) {
    WebDriverWait wait = new WebDriverWait(driver, 120);
    if (nameOfContainer == "container1") {
      wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(itemContainer1)));
    } else {
      wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(itemContainer2)));
    }
  }

  public void waitUntilContainerIsNotVisible (String nameOfContainer) {
    WebDriverWait wait = new WebDriverWait(driver, 120);
    if (nameOfContainer == "container1") {
      wait.until(ExpectedConditions.invisibilityOf(driver.findElement(container1)));
    } else {
      wait.until(ExpectedConditions.invisibilityOf(driver.findElement(container2)));
    }
  }
}
