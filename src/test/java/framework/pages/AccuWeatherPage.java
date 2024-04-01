package framework.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import framework.LocatorConstants;
import org.openqa.selenium.By;

public class AccuWeatherPage extends Form {

    private static final String MAIN_PAGE_NAME = "Main Page";
    private static final By MAIN_PAGE_ACCUWEATHER_LOGO = By.xpath("/html/body/div/div[1]/div[1]/div[1]/div/a");
    private final ILabel mainPageAccuWeatherLogo;
    private static final By CONSENT_PAGE_UNDERSTAND_BUTTON = By.cssSelector(".banner-button.policy-accept");
    private final IButton consentPageUnderstandButton;

    private static final By SEARCH_RESULT_PAGE_SEARCH_INPUT = By.xpath(".//input[contains(@class,'search-input')]");
    private final ITextBox searchResultPageSearchInput;
    private static final By CITY_WEATHER_PAGE_HEADER_CITY_NAME = By.xpath("//h1[@class='header-loc']");

    private static final By CITY_WEATHER_PAGE_FIRST_SEARCH_RESULT = By.xpath("//div[contains(@class,'results-container')]//div[contains(@class,'search-bar-result')][1]");
    private final ILabel cityWeatherPageHeaderCityName;
    private final IButton cityWeatherPageFirstSearchResultButton;
    private final ILabel searchResultsLabel;
    private final IButton firstRecentLocationButton; // Declare and initialize the button here

    // CSS Selector for first recent location button
    private static final By FIRST_RECENT_LOCATION_BUTTON_SELECTOR = By.xpath("/html/body/div/div[1]/div[3]/div/div[2]/div[2]/div/a[1]");

    public AccuWeatherPage() {
        super(MAIN_PAGE_ACCUWEATHER_LOGO, MAIN_PAGE_NAME);
        mainPageAccuWeatherLogo = getElementFactory().getLabel(MAIN_PAGE_ACCUWEATHER_LOGO, "AccuWeather Logo");
        consentPageUnderstandButton = getElementFactory().getButton(CONSENT_PAGE_UNDERSTAND_BUTTON, "I Understand Button");
        searchResultPageSearchInput = getElementFactory().getTextBox(SEARCH_RESULT_PAGE_SEARCH_INPUT, "Search Input");
        cityWeatherPageHeaderCityName = getElementFactory().getLabel(CITY_WEATHER_PAGE_HEADER_CITY_NAME, "City Name");
        cityWeatherPageFirstSearchResultButton = getElementFactory().getButton(CITY_WEATHER_PAGE_FIRST_SEARCH_RESULT, "First Search Result");
        searchResultsLabel = getElementFactory().getLabel(LocatorConstants.SEARCH_RESULT_PAGE_SEARCH_RESULTS, LocatorConstants.SEARCH_RESULT_PAGE_NAME);
        firstRecentLocationButton = getElementFactory().getButton(FIRST_RECENT_LOCATION_BUTTON_SELECTOR, "First Recent Location Button"); // Initialize the button
    }

    public void clickUnderstandButton() {
        consentPageUnderstandButton.click();
    }

    public void typeSearchTerm(String searchTerm) {
        searchResultPageSearchInput.clearAndType(searchTerm);
    }

    public boolean isSearchResultsListDisplayed() {
        return searchResultsLabel.state().waitForDisplayed();
    }

    public void clickOnFirstSearchResult() {
        cityWeatherPageFirstSearchResultButton.click();
        // Wait for the city weather page header to be displayed
        cityWeatherPageHeaderCityName.state().waitForDisplayed();
    }
    public void navigateBack() {
        AqualityServices.getBrowser().goBack();
    }

    public boolean isMainPageDisplayed() {
        return mainPageAccuWeatherLogo.state().waitForDisplayed();

    }


    public void clickOnFirstRecentLocation() {
        firstRecentLocationButton.click();
        // Wait for the city weather page header to be displayed
        cityWeatherPageHeaderCityName.state().waitForDisplayed();
    }

    public String getCityName() {
        return cityWeatherPageHeaderCityName.getText();
    }

    public String getAccuWeatherLogoText() {
        return mainPageAccuWeatherLogo.getText();
    }
}
