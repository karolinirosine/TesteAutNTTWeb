package attributes;

import org.openqa.selenium.By;

public class ProductAttributes {
    protected static final By ProductPrice = By.xpath("//div[@id='ecom-produto-price-default']//p[contains(@class,'font-bold')]");

    protected static final By AddToCart =  By.cssSelector("button[data-testid='add-to-cart-button']");

    protected static final By ModalCheckoutButton = By.cssSelector("button[data-testid='drawer-bag-checkout-button']");

    protected static final By CookieButton = By.id("onetrust-accept-btn-handler");
}