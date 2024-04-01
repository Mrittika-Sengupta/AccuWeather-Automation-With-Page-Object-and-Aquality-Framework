package framework.tests;

import framework.pages.AccuWeatherPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccuWeatherTest extends BaseTest {

    @Test
    public void testRecentLocations() {
        AccuWeatherPage accuWeatherPage = new AccuWeatherPage();

        // Step 1: Consent data usage
        accuWeatherPage.clickUnderstandButton();
        // Step 2: Input "London" in the search field
        accuWeatherPage.typeSearchTerm("London");
        boolean isDisplayed = accuWeatherPage.isSearchResultsListDisplayed();

        // Step 3: Click on the first search result
        accuWeatherPage.clickOnFirstSearchResult();

        // Step 4: Go back to the main page
        accuWeatherPage.navigateBack();

        // Wait for the main page to be displayed after navigating back
        boolean isMainPageDisplayed = accuWeatherPage.isMainPageDisplayed();
        Assert.assertTrue(isMainPageDisplayed, "Main page is not opened after navigating back");

        // Step 5: Choose the first city in Recent locations
        accuWeatherPage.clickOnFirstRecentLocation();

        // Asserts
        Assert.assertTrue(isDisplayed, "Search results list is not displayed");

        // Assert that the city weather page header contains the expected city name
        String expectedCityName = "London, London";
        String actualCityName = accuWeatherPage.getCityName();
        Assert.assertTrue(actualCityName.contains(expectedCityName), "City weather page header does not contain the expected city name");
    }
}