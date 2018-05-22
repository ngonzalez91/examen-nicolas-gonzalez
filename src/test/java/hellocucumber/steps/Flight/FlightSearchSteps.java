package hellocucumber.steps.Flight;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import hellocucumber.pageObjects.Flight.SearchFlightPage;
import hellocucumber.pageObjects.Flight.SearchFlightResultsPage;
import hellocucumber.steps.AbstractBaseSteps;
import org.junit.Assert;

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

    @Then("^I am lead to Search Flight results page$")
    public void i_am_lead_to_Search_Flight_results_page() throws Exception {
        SearchFlightResultsPage searchFlightResultsPage = new SearchFlightResultsPage(getDriver());
        Assert.assertTrue(searchFlightResultsPage.waitForFlightsToolBoxToBeVisible());
    }
}