package DataProviders;

import org.testng.annotations.DataProvider;

public class TC1MovieName {

    @DataProvider(name = "MovieName")
    public static Object[][] dataProviderMovieName() {
        return new Object[][]{
                {"Fantasy Island"}

        };
    }
}

