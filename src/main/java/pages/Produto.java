package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertEquals;
import static report.Report.salvarEvidencia;

public class Produto {

    @FindBy(css = "h1[itemprop=\"name\"]")
    private WebElement lblNome;

    @FindBy(css = "a[itemprop=brand] span[itemprop=\"name\"]")
    private WebElement lblFornecedor;

    @FindBy(css = "div.current-price-left strong")
    private WebElement lblPrecoNormal;

    @FindBy(css = "span.price-subscriber")
    private WebElement lblPrecoAssinante;

    @FindBy(css = "#addToBag > button > span > strong")
    private WebElement btnAdicionarAoCarrinho;

    public void validaDadosProduto(String nome, String fornecedor, String preco_normal, String preco_assinante) {
        String txtNome = lblNome.getText();
        String txtFornecedor = lblFornecedor.getText();
        String txtPrecoNormal = lblPrecoNormal.getText();
        String txtPrecoAssinante = lblPrecoAssinante.getText().replace(" para assinantes", "");

        assertEquals(nome, txtNome);
        assertEquals(fornecedor, txtFornecedor);
        assertEquals(preco_normal, txtPrecoNormal);
        assertEquals(preco_assinante, txtPrecoAssinante);
        salvarEvidencia("Validou os dados >>>\nNome: " + nome + "\nFornecedor: " + fornecedor + "\nPreço Normal: " + preco_normal + "\nPreço Assinante: " + preco_assinante);
    }

    public void incluiOProdutoNoCarrinho() {
        btnAdicionarAoCarrinho.click();
        salvarEvidencia("Clicou no botão 'Adicionar ao Carrinho'");
    }

}

