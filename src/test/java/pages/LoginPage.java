package pages;

import attributes.LoginAttributes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public class LoginPage extends LoginAttributes {
    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    Actions actions = new Actions(driver);

    public void preencherEmail(String email) {
        WebElement emailElement = wait.until(ExpectedConditions.presenceOfElementLocated(LoginAttributes.LoginEmail));

        //precisa fazer esses 3 movimentos pois o elemento não é Displayed
        //Somente quando coloca o mouse em cima e em sequencia clica
        actions.moveToElement(emailElement).perform();
        actions.click(emailElement).perform();
        emailElement.sendKeys(email);
    }

    public void preencherSenha(String senha){
        WebElement senhaElement = wait.until(ExpectedConditions.presenceOfElementLocated(LoginAttributes.LoginSenha));

        //mesmo caso do email
        actions.moveToElement(senhaElement).perform();
        actions.click(senhaElement).perform();
        senhaElement.sendKeys(senha);
    }

    public void clicarLogin(){
        WebElement loginBtnElement = wait.until(ExpectedConditions.presenceOfElementLocated(LoginAttributes.EntrarBtn));

        //mesmo caso do email
        actions.moveToElement(loginBtnElement).perform();
        actions.click(loginBtnElement).perform();
    }

    public boolean validarModalSeguranca(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(LoginAttributes.VerificaSeguranca)).isDisplayed();
    }
}
