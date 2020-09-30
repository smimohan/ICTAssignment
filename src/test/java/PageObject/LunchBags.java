package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LunchBags {

   // List<String> obtainedList;

    @FindBy(xpath = "//a[@class='product-item__title text--strong link']")
    private List<WebElement> filterList;
    @FindBy(xpath = "//div[@class='mm-sort-content']//select")
    private WebElement filter;

    public LunchBags(WebDriver driver) {
        PageFactory.initElements(driver, this);} //constructor

    public void filterByAlphabeticalOrder()
    {
        Select dropdown= new Select(filter); //methods
        dropdown.selectByVisibleText("Alphabetically: Z-A");
    }

    public List<String> obtainedOrder()
    {
        List<String> obtainedList = new ArrayList<>();
        for (WebElement webElement : filterList) {
            obtainedList.add(webElement.getText());
        }
        return obtainedList;
    }

    public List<String> sortedList()
    {
        List<String> sortedList = new ArrayList<>(obtainedOrder());
        Collections.sort(sortedList);
        return sortedList;
    }
}
