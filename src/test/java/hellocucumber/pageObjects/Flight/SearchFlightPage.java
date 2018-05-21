package hellocucumber.pageObjects.Flight;

import hellocucumber.CommonComponents.FlightsGeoAutocompleteComponent;
import hellocucumber.Utils.Utils;
import hellocucumber.pageObjects.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchFlightPage extends AbstractBasePage {

  // Selectors
  private By origin = By.cssSelector("input[placeholder=\"Ingresá desde dónde viajas\"]");
  private By destiny  = By.cssSelector("input[placeholder=\"Ingresá hacia dónde viajas\"]");
  private By departDate = By.cssSelector("input[placeholder=\"Partida\"]");
  private By returnDate = By.cssSelector("input[placeholder=\"Regreso\"]");
  private By searchButton = By.cssSelector("#searchbox-sbox-all-boxes .sbox-button-default a");

  // CONSTRUCTOR
  public SearchFlightPage(WebDriver driver) {
    super(driver);
  }

  // METHODS
  public void setOrigin (String value) {
    driver.findElement(origin).sendKeys(value);
  }

  public void setDestiny (String value) {
    driver.findElement(destiny).sendKeys(value);
  }

  public void setDepartDate (String value) {
    driver.findElement(departDate).sendKeys(value);
  }

  public void setReturnDate (String value) {
    driver.findElement(returnDate).sendKeys(value);
  }

  public void clickSearchButton () {
    driver.findElement(searchButton).click();
  }

  public void searchFlights (String originValue, String destinyValue, String departDateValue, String returnDateValue) {
    FlightsGeoAutocompleteComponent flightsGeoAutocompleteComponent = new FlightsGeoAutocompleteComponent(driver);

    Utils.clearField(driver.findElement(origin));
    this.setOrigin(originValue);
    flightsGeoAutocompleteComponent.clickOnAirport(1);

    Utils.clearField(driver.findElement(destiny));
    this.setDestiny(destinyValue);
    flightsGeoAutocompleteComponent.clickOnAirport(1);

//    Utils.clearField(driver.findElement(departDate));
//    this.setDepartDate(departDateValue);
//
//    Utils.clearField(driver.findElement(departDate));
//    this.setDepartDate(returnDateValue);
//
//    this.clickSearchButton();
  }
}
