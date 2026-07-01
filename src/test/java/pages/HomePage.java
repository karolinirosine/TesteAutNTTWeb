package pages;

import attributes.HomeAttributes;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public class HomePage extends HomeAttributes {

    WebDriver driver = DriverManager.getDriver();
    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public void acessarSite(String url) {
        driver.get(url);
    }

    public void buscarProduto(String produto){
        driver.findElement(HomeAttributes.HeaderSearch).sendKeys(produto, Keys.ENTER);
    }

    public void loginPageMouseOver(){
        WebElement profile = driver.findElement(HomeAttributes.LoginMouseOver);
        actions.moveToElement(profile).perform();
    }

    public void clicarLogin(){
        WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(HomeAttributes.LoginBtn));
        btnLogin.click();
    }

    public void aceitarCookies() {
        //try/catch pois os cookies podem aparecer tanto na página inicial quanto na página de produto
        //não há padronização
        try {
            WebElement cookies = wait.until(ExpectedConditions.presenceOfElementLocated(HomeAttributes.CookieButton));
            cookies.click();
        } catch (TimeoutException t){
        }

    }

    //public boolean validarLogin(){
    //    return driver.findElement(HomeAttributes.HeaderOla).isDisplayed();
    //}
}