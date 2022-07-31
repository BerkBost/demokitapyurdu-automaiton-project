import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Stack;

public class HomePage extends BasePage {

    SearchBox searchBox ;

    By homePageElementLocator= By.className("ribbon-text");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        searchBox = new SearchBox(webDriver);
    }

    public SearchBox searchBox() {
        return this.searchBox;
    }




    public boolean isOnHomePage() {
        return isDisplay(homePageElementLocator);
    }
}
