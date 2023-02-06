package lib.ui.mobile_web;

import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUI extends NavigationUI
{
    static {
        MY_LIST_LINK = "css:[data-event-name='watchlist']";
        OPEN_NAVIGATION = "css:#mv-mf-main-menu-button";
    }

    public MWNavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }
}
