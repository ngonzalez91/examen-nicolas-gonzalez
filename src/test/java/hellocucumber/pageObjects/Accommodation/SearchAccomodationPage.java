package hellocucumber.pageObjects.Accommodation;

import hellocucumber.pageObjects.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchAccomodationPage extends AbstractBasePage {

  // SELECTORS
  private By destiny               = By.cssSelector("input[placeholder=\"Ingresá una ciudad, alojamiento o atracción\"]");
  private By checkinDate           = By.cssSelector("input[placeholder=\"Entrada\"]");
  private By checkoutDate          = By.cssSelector("input[placeholder=\"Salida\"]");
  private By rooms                 = By.cssSelector("input[placeholder=\"Salida\"]");
  private By adultChildContainer   = By.cssSelector("._pnlpk-itemBlock");
  private By addChildAdultIcon     = By.cssSelector("._pnlpk-itemRow");
  private By adultChildApplyButton = By.cssSelector("._pnlpk-apply-button");
  private By searchButton          = By.cssSelector("#searchbox-sbox-all-boxes .sbox-button-default a");

  // CONSTRUCTORS
  public SearchAccomodationPage(WebDriver driver) {
    super(driver);
  }

  // METHODS
//  public void setDestiny (String destiny) {
//
//  }
//
//  public void setCheckin (String checkin) {
//
//  }
//
//  public void setCheckout (String destiny) {
//
//  }
//
//  public void setNumberOfKids (Integer numberOfKids) {
//
//  }
//
//  public void clickAdultChildApplyButton () {
//
//  }
//
//  public void clickSearchButton () {
//
//  }
//
//  public void searchAccommodation (String destiny, String checkin, String checkout, String rooms, String adults, String kids) {
//
//  }

}
