package hellocucumber.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class AbstractBaseSteps {

  protected static WebDriver driver;

  protected WebDriver getDriver() {
    if (driver == null) {
      System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver");

      ChromeOptions options = new ChromeOptions();
      options.addArguments("--start-maximized");

      driver = new ChromeDriver(options);

      driver.manage().deleteAllCookies();
    }
    return driver;
  }
}
