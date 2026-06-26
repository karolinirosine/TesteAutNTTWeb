package attributes;

import org.openqa.selenium.By;

public class LoginAttributes {

    protected static final By LoginEmail = By.id("loginEmail");

    protected static final By LoginSenha = By.id("loginPassword");

    protected static final By EntrarBtn = By.cssSelector("button[data-testid='ptz-button-entrar']");

    protected static final By VerificaSeguranca = By.xpath("//div[contains(@class,'title') and contains(.,'Verificação de segurança')]");

}
