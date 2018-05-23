package hellocucumber.pageObjects.Flight;

import hellocucumber.pageObjects.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchaseFlightPage extends AbstractBasePage {

  // SELECTORS
  private By passengersSection        = By.cssSelector("#passengers-container");
  private By paymentDefinitionSection = By.cssSelector("#paymentDefinition");
  private By invoiceDefinitionSection = By.cssSelector("#invoiceDefinition");
  private By contactDefinitionSection = By.cssSelector("#contactDefinition");

  // CONSTRUCTOR
  public PurchaseFlightPage(WebDriver driver) {
    super(driver);
  }

  public boolean waitUntilPresenceOfPassengersSection() {
    try {
      WebDriverWait wait = new WebDriverWait(driver, 60);
      wait.until(ExpectedConditions.presenceOfElementLocated(passengersSection));
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public boolean waitUntilPresenceOfPaymentDefinitionSection() {
    try {
      WebDriverWait wait = new WebDriverWait(driver, 60);
      wait.until(ExpectedConditions.presenceOfElementLocated(paymentDefinitionSection));
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public boolean waitUntilPresenceOfInvoiceDefinitionSection() {
    try {
      WebDriverWait wait = new WebDriverWait(driver, 60);
      wait.until(ExpectedConditions.presenceOfElementLocated(invoiceDefinitionSection));
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public boolean waitUntilPresenceOfContactDefinitionSection() {
    try {
      WebDriverWait wait = new WebDriverWait(driver, 60);
      wait.until(ExpectedConditions.presenceOfElementLocated(contactDefinitionSection));
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  // METHODS
}
