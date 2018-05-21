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
  private By container1     = By.cssSelector(".geo-autocomplete-main");
  private By itemContainer1 = By.cssSelector(".geo-autocomplete-main > div:nth-child(1) a");

  private By container2     = By.cssSelector(".ac-container");
  private By itemContainer2 = By.cssSelector(".ac-container ul > li:nth-child(1) span");


  // CONSTRUCTOR
  public FlightsGeoAutocompleteComponent(WebDriver driver) {
    super(driver);
  }

  // METHODS
  public void clickOnAirport (Integer indexOfItem ) {

    if (isContainer1Visible()) {
      System.out.println("------ >>> Espacioooo container 1 ---->>> ");
      waitUntilContainer1IsVisible();
      driver.findElement(itemContainer1).click();
      waitUntilContainer1IsNotVisible();
    } else {
      System.out.println("------ >>> Espacioooo container 2 ---->>> ");
      waitUntilContainer2IsVisible();
      driver.findElement(itemContainer2).click();
      waitUntilContainer2IsNotVisible();
    }
  }

  public boolean isContainer1Visible () {
    try{
      WebDriverWait wait = new WebDriverWait(driver, 120);
      wait.until(ExpectedConditions.visibilityOf(driver.findElement(container1)));

      return true;

    }catch(Exception ex){
      return false;
    }
  }

  public void waitUntilContainer1IsVisible () {
    WebDriverWait wait = new WebDriverWait(driver, 120);

    wait.until(ExpectedConditions.visibilityOf(driver.findElement(container1)));
  }

  public void waitUntilContainer1IsNotVisible () {
    WebDriverWait wait = new WebDriverWait(driver, 120);

    wait.until(ExpectedConditions.invisibilityOf(driver.findElement(container1)));
  }

  public void waitUntilContainer2IsVisible () {
    WebDriverWait wait = new WebDriverWait(driver, 120);

    wait.until(ExpectedConditions.visibilityOf(driver.findElement(container2)));
  }

  public void waitUntilContainer2IsNotVisible () {
    WebDriverWait wait = new WebDriverWait(driver, 120);

    wait.until(ExpectedConditions.invisibilityOf(driver.findElement(container2)));
  }
}
