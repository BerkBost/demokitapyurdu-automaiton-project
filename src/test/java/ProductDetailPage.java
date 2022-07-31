import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {

    By addToCartButtonLocator = By.className("add-to-cart");
    By cartCountLocator =  By.cssSelector("span.fl");
    By myCartLocator = By.id("cart-items");
    By GoToMyCartLocator = By.className("button");

    public ProductDetailPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplay(addToCartButtonLocator);
    }

    public void addToCart() {
        click(addToCartButtonLocator);
    }

    public boolean isProductCountUp() {
        System.out.println(getCartCount());
        return getCartCount() > 0 ;
    }

    private int getCartCount(){
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }

    public void goToCart() throws InterruptedException {
        click(myCartLocator);
        Thread.sleep(1000);
        click(GoToMyCartLocator);
    }
}
