package hellocucumber.steps.Flight;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hellocucumber.Utils.Utils;
import hellocucumber.pageObjects.Accommodation.PurchaseAccommodationPage;
import hellocucumber.pageObjects.Flight.PurchaseFlightPage;
import hellocucumber.pageObjects.Flight.SearchFlightResultsPage;
import hellocucumber.steps.AbstractBaseSteps;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class FlightPurchaseSteps extends AbstractBaseSteps {
  @When("^I want to buy the most expensive flight$")
  public void i_want_to_buy_the_most_expensive_flight() throws Exception {
    SearchFlightResultsPage searchFlightResultsPage = new SearchFlightResultsPage(getDriver());
    searchFlightResultsPage.waitForFlightsToolBoxToBeVisible();

    WebElement mostExpensiveFlight = searchFlightResultsPage.getMostExpensiveFlight();
    Utils.clickWebElement(mostExpensiveFlight);
  }

  @Then("^I am lead to Flight Tickets purchase page$")
  public void i_am_lead_to_Flight_Tickets_purchase_page() throws Exception {
    PurchaseFlightPage purchaseFlightPage = new PurchaseFlightPage(getDriver());
    Assert.assertTrue(purchaseFlightPage.waitUntilPresenceOfPassengersSection());
    Assert.assertTrue(purchaseFlightPage.waitUntilPresenceOfPaymentDefinitionSection());
    Assert.assertTrue(purchaseFlightPage.waitUntilPresenceOfInvoiceDefinitionSection());
    Assert.assertTrue(purchaseFlightPage.waitUntilPresenceOfContactDefinitionSection());
  }
}
