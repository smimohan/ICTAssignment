package DataProviders;

import org.testng.annotations.DataProvider;

public class City_DP {

    @DataProvider(name = "CityName")
    public static Object[][] dataProviderCity() {
        return new Object[][]{
                {"Goa"}
        };
    }
}
