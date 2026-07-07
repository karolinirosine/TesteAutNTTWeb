package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.DriverManager;
import utils.Log;
import utils.Screenshot;

import static org.junit.Assert.assertTrue;


public class PetzSteps {

    HomePage home = new HomePage();
    ProductPage product = new ProductPage();
    CartPage cart = new CartPage();
    SearchPage search = new SearchPage();
    LoginPage login = new LoginPage();
    WebDriver driver = DriverManager.getDriver();

    String precoSacola;

    @Given("que um usuario acessa o site {string}")
    public void entraSite(String url) throws InterruptedException  {
        Log.escreverLog("Iniciando teste...");
        home.acessarSite(url);
        home.aceitarCookies();

        //Adicionei o sleep para poder tirar o print do site carregado
        Thread.sleep(5000);
        Screenshot.tirarPrint(driver, "inicio_teste");
    }

    @When("que seleciona um produto com o nome {string}")
    public void selecionaProduto(String produto){
        home.buscarProduto(produto);
        search.selecionarProduto(produto);
        Screenshot.tirarPrint(driver, "produto_selecionado");
        Log.escreverLog("Produto selecionado: " + produto);
    }

    @When("na pagina do produto inclui o produto no carrinho")
    public void adicionaCarrinho() {
        product.fecharModalSale();
        precoSacola = product.pegarPreco();
        home.aceitarCookies();
        product.adicionarAoCarrinho();
        Log.escreverLog("Adicionando produto no carrinho...");
    }

    @And("vai ate o carrinho de compra atravez do modal")
    public void acessaCarrinho() throws InterruptedException {
        //Adicionei o sleep para poder tirar o print do modal
        Thread.sleep(5000);
        Log.escreverLog("Produto adicionado no carrinho!");
        Screenshot.tirarPrint(driver, "produto_adicionado_no_carrinho_modal");
        product.irParaCarrinho();
    }

    @Then("devera verificar se os valores na pagina e no carrinho estao igualados")
    public void validaValores() {
        String precoCarrinho = cart.pegarPrecoCarrinho();

        Screenshot.tirarPrint(driver, "produto_no_carrinho");
        Log.escreverLog("Validando preço...");
        Log.escreverLog("PRECO PRODUTO: " + precoSacola);
        Log.escreverLog("PRECO CARRINHO: " + precoCarrinho);

        Assert.assertEquals(precoSacola, precoCarrinho);
        Log.escreverLog("TESTE PASSOU!");
    }

    //Login
    //Como o site da Petz SEMPRE vai pedir a confirmaçao via SMS
    //Defini que para evitar empecilhos na correção do teste
    //Parar no modal da verificação de segurança (SMS) como um cenário de login completo
    //Combinado com o Darlan em call

    @When("passa o mouse em cima do icone entrar cadastre-se")
    public void passaOMouseEmCimaDoIconeEntrarCadastreSe() {
        home.loginPageMouseOver();
    }
    
    @And("clica no botao Entrar")
    public void clicaNoBotaoEntrar() {
        home.clicarLogin();
        Screenshot.tirarPrint(driver, "clicar_para_logar");
    }

    @And("informa o email {string}")
    public void informaOEmail(String email) {
        Log.escreverLog("Preenchendo login...");
        login.preencherEmail(email);
    }

    @And("informa a senha {string}")
    public void informaASenha(String senha) {
        login.preencherSenha(senha);
    }

    @And("confirma o login")
    public void confirmaOLogin() {
        Screenshot.tirarPrint(driver, "tela_login_preenchida");
        login.clicarLogin();
        Log.escreverLog("Logando...");
    }

    @Then("deve visualizar o modal de verificacao de seguranca")
    public void deveVisualizarModalSeguranca() {
        boolean check = login.validarModalSeguranca();
        assertTrue(check);
        Screenshot.tirarPrint(driver, "tela_modal_seguranca");
        Log.escreverLog("Modal de segurança validado!");
        Log.escreverLog("TESTE PASSOU!");
    }

}
