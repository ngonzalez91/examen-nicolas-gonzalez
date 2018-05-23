package hellocucumber.pageObjects.Accommodation;

import hellocucumber.CommonComponents.DateTimePickerComponent;
import hellocucumber.CommonComponents.GeoAutocompleteComponent;
import hellocucumber.Utils.Utils;
import hellocucumber.pageObjects.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchAccomodationPage extends AbstractBasePage {

  // SELECTORS
  private By destiny                = By.cssSelector("input[placeholder=\"Ingresá una ciudad, alojamiento o atracción\"]");
  private By checkinDate            = By.cssSelector("input[placeholder=\"Entrada\"]");
  private By inputRooms             = By.cssSelector("input[class*=\"sbox-rooms\"]");
  private By checkoutDate           = By.cssSelector("input[placeholder=\"Salida\"]");
  private By roomsBlockContainer    = By.cssSelector("div[class$=\"-itemBlock\"]");
  private By adultsPlusMinusButtons = By.cssSelector("div[class$=\"-itemBlock\"] > div[class$=\"_itemRows\"] >div:nth-child(1) a[class^=\"steppers-icon\"]");
  private By kidsPlusMinusButtons   = By.cssSelector("div[class$=\"-itemBlock\"] > div[class$=\"_itemRows\"] >div:nth-child(2) a[class^=\"steppers-icon\"]");
  private By minorAgeContainer      = By.cssSelector("div[class$=\"-itemBlock\"] div[class$=\"minor-age-select-last-item\"]");
  private By selectKidsAge          = By.cssSelector("div[class$=\"-itemBlock\"] div[class$=\"minor-age-select-last-item\"] select");
  private By applyButton            = By.cssSelector("._pnlpk-panel__footer ._pnlpk-apply-button");
  private By searchButton           = By.cssSelector("#searchbox-sbox-all-boxes .sbox-button-container a");

  // CONSTRUCTORS
  public SearchAccomodationPage(WebDriver driver) {
    super(driver);
  }

  // METHODS
  public void  navigateToAccommodationsPage () {
    driver.navigate().to("https://www.despegar.com.ar/hoteles");
    closeLoginPopup();
  }
  public void setDestiny (String destinyValue) {
    Utils.clearField(driver.findElement(destiny));
    driver.findElement(destiny).sendKeys(destinyValue);
  }
//
  public void setCheckIn (String checkinValue) {
    driver.findElement(checkinDate).click();
    DateTimePickerComponent dateTimePickerComponent = new DateTimePickerComponent(driver);
    dateTimePickerComponent.setDate(checkinValue);
  }

  public void setCheckOut (String checkOutValue) {
    driver.findElement(checkoutDate).click();
    DateTimePickerComponent dateTimePickerComponent = new DateTimePickerComponent(driver);
    dateTimePickerComponent.setStayDuration(checkOutValue);
  }

  public void setRooms (String adultsValue, String kidsValue) {
    driver.findElement(inputRooms).click();
    WebDriverWait wait = new WebDriverWait(driver,60);

    // Set adult amount
    wait.until(ExpectedConditions.presenceOfElementLocated(roomsBlockContainer));
    List<WebElement> adultButtons = driver.findElements(adultsPlusMinusButtons);
    while(!adultButtons.get(0).getAttribute("class").contains("disable")) {
      adultButtons.get(0).click();
    }
    Integer adultsCounter = 1;
    while (adultsCounter != Integer.valueOf(adultsValue)) {
      adultButtons.get(1).click();
      adultsCounter++;
    }

    // Set children amount
    wait.until(ExpectedConditions.presenceOfElementLocated(roomsBlockContainer));
    List<WebElement> kidsButtons = driver.findElements(kidsPlusMinusButtons);
    while(!kidsButtons.get(0).getAttribute("class").contains("disable")) {
      adultButtons.get(0).click();
    }
    Integer kidsCounter = 0;
    while (kidsCounter != Integer.valueOf(kidsValue)) {
      kidsButtons.get(1).click();
      kidsCounter++;
    }
    if (kidsCounter>0){
      wait.until(ExpectedConditions.presenceOfElementLocated(minorAgeContainer));
      Select kidsAgeDropdown = new Select(driver.findElement(selectKidsAge));
      kidsAgeDropdown.selectByValue("0");
    }
    driver.findElement(applyButton).click();
  }

  public void clickSearchButton () {

    driver.findElement(searchButton).click();
  }
//
  public void searchAccommodations (String destinyValue, String checkinValue, String stayDurationValue, String adultsValue, String kidsValue) {
    GeoAutocompleteComponent geoAutocompleteComponent = new GeoAutocompleteComponent(driver);

    this.setDestiny(destinyValue);
    geoAutocompleteComponent.clickFirstItem();

    this.setCheckIn(checkinValue);
    this.setCheckOut(stayDurationValue);

    this.setRooms(adultsValue, kidsValue);

    this.clickSearchButton();
    }
}
