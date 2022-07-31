import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchBox extends BasePage{
    By searchBoxLocator = By.id("search-input");
    By submitButtonLocator = By.cssSelector("common-sprite button-search");

    WebElement submitButton = webDriver.findElement(searchBoxLocator);
    public SearchBox(WebDriver webDriver) {
        super(webDriver);
    }

    public void search() throws FileNotFoundException, InterruptedException {
        type(searchBoxLocator, readFromScvFile());
        Thread.sleep(500);
        clickEnter(submitButton);
        Thread.sleep(500);
    }

    public String readFromScvFile() throws FileNotFoundException {
        String value = "" ;

        File file = new File("Products.csv");
        if (file.exists())
            System.out.println("File is  found");
        else
            System.out.println("File is not found");

        Scanner s = new Scanner(file);
        while (s.hasNextLine())
            value = s.nextLine();

        s.close();
        return value;
    }
}
