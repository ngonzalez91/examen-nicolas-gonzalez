package hellocucumber.steps;

import cucumber.api.java.en.Given;
import hellocucumber.pageObjects.Accommodation.SearchAccomodationPage;
import hellocucumber.pageObjects.Flight.SearchFlightPage;
import org.openqa.selenium.WebDriver;

public class CommonSteps extends AbstractBaseSteps {
  SearchFlightPage searchFlightPage;
  SearchAccomodationPage searchAccomodationPage;

  @Given("^I go to Despegar flights site$")
  public void i_go_to_Despegar_flights_site() throws Exception {
    searchFlightPage = new SearchFlightPage(this.getDriver());
    searchFlightPage.naviageToFlightsPage();
  }

  @Given("^I go to Despegar accommodations site$")
  public void i_go_to_Despegar_accommodations_site() throws Exception {
    searchAccomodationPage = new SearchAccomodationPage(this.getDriver());
    searchAccomodationPage.navigateToAccommodationsPage();
  }
}