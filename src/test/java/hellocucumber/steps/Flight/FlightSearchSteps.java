package hellocucumber.steps.Flight;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import hellocucumber.pageObjects.Flight.SearchFlightPage;
import hellocucumber.steps.AbstractBaseSteps;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class FlightSearchSteps extends AbstractBaseSteps {

    SearchFlightPage searchFlightPage;

    @Given("^I search for flights$")
    public void i_search_for_flights(DataTable arg1) throws Exception {
        List<Map<String,String>> data = arg1.asMaps(String.class,String.class);

        String origin, destiny, departDate, returnDate;

        origin = data.get(0).get("from");
        destiny = data.get(0).get("to");
        departDate = data.get(0).get("depart date");
        returnDate = data.get(0).get("return date");

        searchFlightPage = new SearchFlightPage(getDriver());
        searchFlightPage.searchFlights(origin,destiny,departDate,returnDate);
    }
//
//    @When("^I search for flights$")
//    public void i_search_for_flights(DataTable arg1) throws Exception {
//        // Write code here that turns the phrase above into concrete actions
//        // For automatic transformation, change DataTable to one of
//        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
//        // E,K,V must be a scalar (String, Integer, Date, enum etc)
//        throw new PendingException();
//    }
//
//    @Then("^I am lead to Search Flight results page$")
//    public void i_am_lead_to_Search_Flight_results_page() throws Exception {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
}