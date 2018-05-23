package hellocucumber.Utils;

import org.openqa.selenium.WebElement;

public abstract class Utils {

  // METHODS
  public static void clearField (WebElement webElement) {
    webElement.clear();
  }

  public static void clickWebElement(WebElement webElement) {
    webElement.click();
  }
}
