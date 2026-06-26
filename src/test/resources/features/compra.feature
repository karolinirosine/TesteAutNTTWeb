Feature: Comprar produto

  Scenario: Validar o valor do produto

    Given que um usuario acessa o site "https://www.petz.com.br/"
    When que seleciona um produto com o nome "Escada Baw & Miaw Grafite para Cães e Gatos"
    And na pagina do produto inclui o produto no carrinho
    And vai ate o carrinho de compra atravez do modal
    Then devera verificar se estao corretos os valores do produto "R$ 339,99"

