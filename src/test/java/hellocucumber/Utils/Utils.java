package hellocucumber.Utils;

import hellocucumber.pageObjects.AbstractBasePage;
import org.openqa.selenium.WebElement;

public abstract class Utils {

  // METHODS
  public static void clearField (WebElement webElement) {
    webElement.clear();
  }
}
