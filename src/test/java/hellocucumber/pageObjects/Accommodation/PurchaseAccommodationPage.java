package hellocucumber.pageObjects.Accommodation;

import hellocucumber.pageObjects.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchaseAccommodationPage extends AbstractBasePage {

  // SELECTORS
  private By passengersSection        = By.cssSelector("#passengers-container");
  private By paymentDefinitionSection = By.cssSelector("#paymentDefinition");
  private By invoiceDefinitionSection = By.cssSelector("#invoiceDefinition");
  private By contactDefinitionSection = By.cssSelector("#contactDefinition");

//  CONSTRUCTOR
  public PurchaseAccommodationPage(WebDriver driver) {
    super(driver);
  }
}
