package hellocucumber.steps.Accommodation;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hellocucumber.pageObjects.Accommodation.SearchAccomodationPage;
import hellocucumber.pageObjects.Flight.SearchFlightPage;
import hellocucumber.steps.AbstractBaseSteps;

import java.util.List;
import java.util.Map;

public class AccommodationSearchSteps extends AbstractBaseSteps {

  SearchAccomodationPage searchAccomodationPage;

  @When("^I search for hotels$")
  public void i_search_for_hotels(DataTable arg1) throws Exception {
    List<Map<String,String>> data = arg1.asMaps(String.class,String.class);

    String destiny, checkIn, stayDuration, room, adults, kids;

    destiny = data.get(0).get("destiny");
    checkIn = data.get(0).get("check in");
    stayDuration = data.get(0).get("stay duration");
    room = data.get(0).get("room");
    adults = data.get(0).get("adults");
    kids = data.get(0).get("kids");

    searchAccomodationPage = new SearchAccomodationPage(getDriver());
    searchAccomodationPage.searchAccommodations(destiny,checkIn,stayDuration,adults,kids);
  }

  @Then("^I am lead to Search Accommodations results page$")
  public void i_am_lead_to_Search_Accommodations_results_page() throws Exception {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }
//
//  @When("^I filter Accommodations by '(\\d+)' stars$")
//  public void i_filter_Accommodations_by_stars(int arg1) throws Exception {
//    // Write code here that turns the phrase above into concrete actions
//    throw new PendingException();
//  }
}
