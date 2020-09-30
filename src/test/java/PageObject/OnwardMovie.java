package PageObject;

import Commons.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class OnwardMovie extends Driver {

    @FindBy(xpath = "//div[@id='cast-carousel']/div/div/div/span[1]")
    private WebElement actor;

    @FindBy(xpath = "//div[@id='crew-carousel']/div/div/div/span[3]")
    private WebElement musician;

    public OnwardMovie(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void verifyActor() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(actor));
        String value = actor.getText();
        String actualName = value.substring(0, 11);
        String expectedName = "Tom Holland";
        Assert.assertEquals(actualName, expectedName);
        System.out.println("The actual name: " + actualName + " and " + " the expected name " + expectedName + " matches");
    }

    public void verifyMusician() {
        String value = musician.getText();
        String actualName1 = value.substring(0, 13);
        String expectedName1 = "Mychael Danna";
        Assert.assertEquals(actualName1, expectedName1);
        System.out.println("The actual name: " + actualName1 + " and " + " the expected name " + expectedName1 + " matches");

    }

    }
