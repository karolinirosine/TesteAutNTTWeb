Feature: Login

  Scenario: Realizar login com sucesso

    Given que um usuario acessa o site "https://www.petz.com.br/"
    When passa o mouse em cima do icone entrar cadastre-se
    And clica no botao Entrar
    And informa o email "testeautaut@gmail.com"
    And informa a senha "Teste@#2026"
    And confirma o login
    Then deve visualizar o modal de verificacao de seguranca