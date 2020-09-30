package DataProviders;

import org.testng.annotations.DataProvider;

public class TC9BankOffer {
    @DataProvider(name = "OfferName")
    public static Object[][] dataProviderOfferName() {
        return new Object[][]{
                {"ICICI Bank 25% Discount Offer"}
        };
    }
}

