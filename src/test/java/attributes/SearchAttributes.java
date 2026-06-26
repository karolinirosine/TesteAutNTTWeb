package attributes;

import org.openqa.selenium.By;

public class SearchAttributes {

    protected static By procurarProduto(String produto) {
        return By.xpath("//a[contains(.,'" + produto + "')]");
    }

}