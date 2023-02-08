package lib.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomePageObject extends MainPageObject{

    private static final String
            STEP_LEARN_MORE_LINK = "id:Свободная энциклопедия",
            STEP_NEW_WAYS_TO_EXPLORE_TEXT = "id:Новые способы изучения",
            STEP_ADD_OR_EDIT_PREFERRED_LAND_LINK = "xpath://XCUIElementTypeStaticText[@name='Добавить или изменить предпочтительные языки']",
            STEP_LEARN_MORE_ABOUT_DATE_COLLECTED_LINK = "xpath://XCUIElementTypeButton[@name='Узнать подробнее о сборе данных']",
            NEXT_LINK = "xpath://XCUIElementTypeButton[@name='Далее']",
            GET_STARTED_LINK = "xpath://XCUIElementTypeButton[@name='Начать']",
            SKIP = "xpath://XCUIElementTypeButton[@name='Пропустить']";

    public WelcomePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    @Step("Waiting learn more link on the welcome screen")
    public void waitForLearnMoreLink()
    {
        this.waitForElementPresent(
                STEP_LEARN_MORE_LINK,
                "Cannot find 'Свободная энциклопедия'",
                10
        );
    }

    @Step("Clicking next button on the welcome screen")
    public void clickNextButton()
    {
        this.waitForElementAndClick(
                NEXT_LINK,
                "Cannot find and click Next",
                10
        );
    }

    @Step("Waiting for new way to explore text on the welcome screen")
    public void waitForNewWayToExploreText()
    {
        this.waitForElementPresent(
                STEP_NEW_WAYS_TO_EXPLORE_TEXT,
                "Cannot find 'Свободная энциклопедия'",
                10
        );
    }

    @Step("Waiting for add or edit preferred lang text on the welcome screen")
    public void waitAddOrEditPreferredLangText()
    {
        this.waitForElementPresent(
                STEP_ADD_OR_EDIT_PREFERRED_LAND_LINK,
                "Cannot find AddOrEditPreferredLang",
                10
        );
    }

    @Step("Waiting for learn more about date collected text on the welcome screen")
    public void waitForLearnMoreAboutDateCollectedText()
    {
        this.waitForElementPresent(
                STEP_LEARN_MORE_ABOUT_DATE_COLLECTED_LINK,
                "Cannot find LearnMoreAboutDateCollectedText",
                10
        );
    }

    @Step("Clicking the get started button on the welcome screen")
    public void clickGetStartedButton()
    {
        this.waitForElementAndClick(
                GET_STARTED_LINK,
                "Cannot find and click Get started button",
                10
        );
    }

    @Step("Clicking the skip button on the welcome screen")
    public void clickSkip()
    {
        this.waitForElementAndClick(
                SKIP,
                "Cannot find and click skip button",
                10
        );
    }
}