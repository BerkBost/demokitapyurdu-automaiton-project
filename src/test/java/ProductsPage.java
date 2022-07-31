import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Random;

import java.util.List;

public class ProductsPage extends BasePage{

    By listCountLocator = By.id("faceted-search-list-total");
    By productNameLocator = By.className("product-cr");

    public ProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isOnProductsPage() {
        return isDisplay(listCountLocator);
    }

    public void selectProduct() throws InterruptedException {
        getAllProducts().get(1).click();
    }

    private List<WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }

    private int randomNumberGenerator() throws InterruptedException {
        Thread.sleep(500);
        Random rand = new Random();
        int upperBound = 10 ;
        return rand.nextInt(upperBound);
    }

}
