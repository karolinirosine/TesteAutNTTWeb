package pages;

import attributes.CartAttributes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public class CartPage extends CartAttributes {

    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public String pegarPrecoCarrinho() {
        String preco = wait.until(ExpectedConditions.presenceOfElementLocated(CartAttributes.CartPrice)).getAttribute("innerHTML").trim();

        return preco;
    }
}
