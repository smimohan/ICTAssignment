package PageObject;

import Commons.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Planner extends Driver {

    @FindBy(xpath = "//div[@class='card__section card__section--tight']//div[2]//ul//li[1]")
    private WebElement checkBoxPrice;
    @FindBy(xpath="//div[@class='product-item product-item--vertical  1/3--tablet-and-up 1/4--desk']")
    private List<WebElement> plannerList;

    public Planner(WebDriver driver) { PageFactory.initElements(driver, this);}

    public void verifyPriceIsDisplayed() {
        int noOfProductsDisplayed = plannerList.size();
        System.out.println("The No of products in Planners are " + noOfProductsDisplayed);
    }
     public void verifyFilteredDisplay(){
        int filteredListCount= plannerList.size();
        System.out.println("the No of Products displayed on filter are  "+filteredListCount);
           }

           public void clickFilter() {
               JavascriptExecutor js = (JavascriptExecutor) driver;
               js.executeScript("arguments[0].click();", checkBoxPrice);
           }
}