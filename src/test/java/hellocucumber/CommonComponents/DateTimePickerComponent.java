package hellocucumber.CommonComponents;

import hellocucumber.pageObjects.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DateTimePickerComponent extends AbstractBasePage {

  // SELECTORS
  private By container = By.cssSelector(".datepicker-flights-main > div[class$=-show]");
  private By currentMonthDate = By.cssSelector("div[class$=--month-active] div[class$=--dates] > span");
  private By nextMonthDate = By.cssSelector("div[class$=--months] > div:nth-child(2) div[class$=--dates] > span");

  // CONSTRUCTOR
  public DateTimePickerComponent(WebDriver driver) {
    super(driver);
  }

  // METHODS

  public void setDate(String date) {
    switch (date.toLowerCase()) {
      case "tomorrow":
        this.clickFutureDay(false, 1);
        break;
      case "in 1 week":
        this.clickFutureDay(false,7);
        break;
      case "in 10 days":
        this.clickFutureDay(false,10);
    }
  }

  public void clickFutureDay (Boolean nightStayCriteria, Integer daysInFuture) {

      List<WebElement> currentMonthDates = driver.findElements(currentMonthDate);
      Integer sizeOfList = currentMonthDates.size();
      Integer indexWhereILeft = 0;

      // Search today webelement
      for (int i = 0; i < sizeOfList; i++) {
        WebElement today = null;
        if (nightStayCriteria) {
          if (currentMonthDates.get(i).getAttribute("class").contains("--range-start")) {
            today = currentMonthDates.get(i);
          }
        } else {
          if (currentMonthDates.get(i).getAttribute("class").contains("--today")) {
            today = currentMonthDates.get(i);
          }
        }

        if (today != null) {
          indexWhereILeft = i;
          break;
        }
      }
      Integer dayCounter = 0;
      Boolean dayIsClicked = false;

      // Start counting days
      for (int i = indexWhereILeft; i < sizeOfList; i++) {
        if (dayCounter == daysInFuture) {
          currentMonthDates.get(i).click();
          dayIsClicked = true;
          break;
        } else {
          dayCounter++;
        }
      }

      // If day was not clicked, is because you reach the end of month. Hence, we move to next month
      if (!dayIsClicked) {
        List<WebElement> nextMonthDates = driver.findElements(nextMonthDate);
        for (int i = 0; i < dayCounter; i++) {
          if (dayCounter == daysInFuture) {
            nextMonthDates.get(i).click();
            break;
          } else {
            dayCounter++;
          }
        }
      }
  }

  public void setStayDuration(String checkOutValue) {
    switch (checkOutValue) {
      case "3 nights":
        this.clickFutureDay(true, 3);
    }
  }
}
