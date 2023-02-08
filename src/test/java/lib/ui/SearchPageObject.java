package lib.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SearchPageObject extends MainPageObject{

    protected static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_ELEMENT,
            SEARCH_EMPTY_RESULT_ELEMENT;

    public SearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHODS */

    @Step("Initializing the search field")
    public void initSearchInput()
    {
        this.waitForElementPresent(
                SEARCH_INIT_ELEMENT,
                "Cannot find search input after clicking search init element"
        );

        this.waitForElementAndClick(
                SEARCH_INIT_ELEMENT,
                "Cannot find and click search init element",
                5
        );
    }


    @Step("Waiting for button to cancel search result")
    public void waitForCancelButtonToAppear()
    {
        this.waitForElementPresent(
                SEARCH_CANCEL_BUTTON,
                "Cannot find cancel button",
                5
        );
    }

    @Step("Waiting for search cancel button to disappear")
    public void waitForCancelButtonToDisappear()
    {
        this.waitForElementNotPresent(
                SEARCH_CANCEL_BUTTON,
                "Cancel search button is still present",
                5
        );
    }

    @Step("Click button to cancel search result")
    public void clickCancelSearch()
    {
        this.waitForElementAndClick(
                SEARCH_CANCEL_BUTTON,
                "Cannot find and click search cancel button",
                5
        );
    }

    @Step("Typing '{search_line}' to the search line")
    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(
                SEARCH_INPUT,
                search_line,
                "Cannot find and tipe search input",
                5
        );
    }

    @Step("Waiting for search result")
    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(
                search_result_xpath,
                "Cannot find search result with substring " + substring
        );
    }

    @Step("Waiting for search result and select an article by substring in article title")
    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(
                search_result_xpath,
                "Cannot find and click search result with substring " + substring,
                10
        );
    }

    @Step("Getting amount of found articles")
    public int getAmountOfFoundArticles()
    {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by the request",
                15
        );
        return this.getAmountOfElements(
                SEARCH_RESULT_ELEMENT
        );
    }

    @Step("Waiting for empty result label")
    public void waitForEmptyResultsLabel()
    {
        this.waitForElementPresent(
                SEARCH_EMPTY_RESULT_ELEMENT,
                "Cannot find empty result element",
                15
        );
    }

    @Step("Making sure there are no results for the search")
    public void assertThereIsNoResultOfSearch()
    {
        this.assertElementNotPresent(
                SEARCH_RESULT_ELEMENT,
                "We suppused not to find any results"
        );
    }
}