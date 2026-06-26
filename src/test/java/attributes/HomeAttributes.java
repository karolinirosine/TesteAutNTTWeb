package attributes;

import org.openqa.selenium.By;

public class HomeAttributes {

    protected static final By HeaderSearch = By.id("headerSearch");

    protected static final By LoginBtn = By.cssSelector("button[data-testid='ptz-button-entrar']");

    protected  static final By LoginMouseOver = By.cssSelector(".ptz-header-profile");

    //protected static final By HeaderOla = By.xpath("//span[contains(@class,'ptz-header-profile-button-content-logged') and contains(text(),'Olá,')]");

}
