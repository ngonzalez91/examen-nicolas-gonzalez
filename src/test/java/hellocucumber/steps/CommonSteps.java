package hellocucumber.steps;

import cucumber.api.java.en.Given;
import hellocucumber.pageObjects.Flight.SearchFlightPage;
import org.openqa.selenium.WebDriver;

public class CommonSteps extends AbstractBaseSteps {
  SearchFlightPage searchFlightPage;

  @Given("^I go to Despegar flights site$")
  public void i_go_to_Despegar_flights_site() throws Exception {
    //this.driver.get("https://www.despegar.com.ar/");
    searchFlightPage = new SearchFlightPage(this.getDriver());
    searchFlightPage.naviageToFlightsPage();
  }
}