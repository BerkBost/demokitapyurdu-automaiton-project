import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    By cartModuleLocator =By.id("cart_module");
    By objectQuantity = By.name("quantity");

    By cartCountLocator =  By.cssSelector("span.fl");

    By refreshButtonLocator = By.className("fa-refresh");

    By refreshAnnouncementLocator = By.className("swal2-header");

    By removeButtonLocator = By.className("red-icon");



    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isInCartPage() {
        return isDisplay(cartModuleLocator);
    }
    public void changeQuantity() throws InterruptedException {
        WebElement a = find(objectQuantity);
        Thread.sleep(1000);
        a.clear();
        a.sendKeys("2");
    }

    public void refreshQuantity() throws InterruptedException {
        Thread.sleep(2000);
        click(refreshButtonLocator);
    }

    public boolean isRefresh() throws InterruptedException {
        Thread.sleep(1000);
        return isDisplay(refreshAnnouncementLocator);
    }

    public void removeProduct() throws InterruptedException {
        click(removeButtonLocator);
        Thread.sleep(1000);
    }

    public boolean isRemove() throws InterruptedException {
        Thread.sleep(1000);
        return getCartCount() == 0;
    }

    private int getCartCount(){
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }
}
