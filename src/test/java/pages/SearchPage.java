package pages;

import attributes.SearchAttributes;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

public class SearchPage extends SearchAttributes{

    WebDriver driver = DriverManager.getDriver();

    public void selecionarProduto(String produto) {
       driver.findElement(SearchAttributes.procurarProduto(produto)).click();
    }

}