package hellocucumber.pageObjects;

import hellocucumber.pageObjects.Flight.SearchFlightPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractBasePage {

  protected static WebDriver driver;

  public AbstractBasePage(WebDriver driver) {
    this.driver = driver;
  }

  public void  naviageToFlightsPage () {
    driver.navigate().to("https://www.despegar.com.ar/vuelos");
    closeLoginPopup();
  }

  protected void closeLoginPopup() {
    WebDriverWait wait = new WebDriverWait(driver,60);
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".as-login-close"))));
    driver.findElement(By.cssSelector(".as-login-close")).click();
  }
}
