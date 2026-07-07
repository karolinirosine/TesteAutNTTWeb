package pages;

import attributes.ProductAttributes;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public class ProductPage extends ProductAttributes{

    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public String pegarPreco() {

        return driver.findElement(ProductAttributes.ProductPrice).getText();
    }

    public void adicionarAoCarrinho() {

        WebElement botao = wait.until(ExpectedConditions.elementToBeClickable(ProductAttributes.AddToCart));
        botao.click();
    }

    public void irParaCarrinho() {
        WebElement botao = wait.until(ExpectedConditions.elementToBeClickable(ProductAttributes.ModalCheckoutButton));
        botao.click();
    }

    public void fecharModalSale() {
        try {
            WebElement botao = wait.until(ExpectedConditions.elementToBeClickable(ProductAttributes.ModalSale));
            botao.click();
        } catch (TimeoutException t) {

        }
    }

}
