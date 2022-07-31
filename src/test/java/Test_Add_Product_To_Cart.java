import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;


public class Test_Add_Product_To_Cart extends BaseTest {

    //Test kısmımız toplamda 6 testten oluşuyor

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;


    //İlk testimiz bize sayfanın açılıp açılmadığını,ana sayafaya ulaştığımızı test ediyor.
    @Test
    @Order(0)
    public void isOnHomePage(){
        homePage = new HomePage(driver);
        Assertions.assertTrue(homePage.isOnHomePage(),
                "Not on Home Page");

    }

    //Bu kısımda başarlı bir arama yapmış mıyız testini yapıyor
    @Test
    @Order(1)
    public void search_a_product() throws FileNotFoundException, InterruptedException {
        productsPage = new ProductsPage(driver);
        homePage = new HomePage(driver);
        homePage.searchBox().search();
        Assertions.assertTrue(productsPage.isOnProductsPage(),
                "Not on products Page");
    }

    //Bu kısımda başarlı bir şekildeürün seçimi yapılmış mı testini yapıyor
    @Test
    @Order(2)
    public void select_a_product() throws InterruptedException {
        productDetailPage = new ProductDetailPage(driver);
        productsPage = new ProductsPage(driver);
        productsPage.selectProduct();
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),
                "Not on products detail page");
    }

    //Sepetimize ekleme testi yapıyor
    @Test
    @Order(3)
    public void add_product_to_cart() throws InterruptedException {
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.addToCart();
        Thread.sleep(1000);
        Assertions.assertTrue(productDetailPage.isProductCountUp(),
                "Products count did not increase");
    }

    //Sepetimize gitme testi yapıyor
    @Test
    @Order(4)
    public void go_to_cart() throws InterruptedException {
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);
        productDetailPage.goToCart();
        Assertions.assertTrue(cartPage.isInCartPage(),
                "Did not go CartPage");

    }


    //Sepetmize eklediğimiz ürünün sayısını artırma testi
    @Test
    @Order(5)
    public void change_quantity() throws InterruptedException {
        cartPage = new CartPage(driver);
        Thread.sleep(1000);
        cartPage.changeQuantity();
        Thread.sleep(1000);
        cartPage.refreshQuantity();
        Assertions.assertTrue(cartPage.isRefresh(),
                "Products count did not refresh");
    }

    //Sepetteki ürünü kaldırma testi
    @Test
    @Order(6)
    public void remove_product_from_cart() throws InterruptedException {
        Thread.sleep(1000);
        cartPage = new CartPage(driver);
        cartPage.removeProduct();
        Thread.sleep(1000);
        Assertions.assertTrue(cartPage.isRemove(),
                "Products did not remove");

    }

}
