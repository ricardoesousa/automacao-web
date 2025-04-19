package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import report.Report;

import static org.junit.Assert.assertEquals;

public class Produto {

    @FindBy(css = "h1[itemprop=\"name\"]")
    private WebElement lblNome;

    @FindBy(css = "a[itemprop=brand] span[itemprop=\"name\"]")
    private WebElement lblFornecedor;

    @FindBy(css = "div.price-current")
    private WebElement lblPrecoNormal;

    @FindBy(css = "span.price-subscriber")
    private WebElement lblPrecoAssinante;

    @FindBy(id = "adicionarAoCarrinho")
    private WebElement btnAdicionarAoCarrinho;

    public void validaDadosProduto(String nome, String fornecedor, String preco_normal, String preco_assinante) {
        String txtNome = lblNome.getText();
        String txtFornecedor = lblFornecedor.getText();
        String txtPrecoNormal = lblPrecoNormal.getText();
        String txtPrecoAssinante = lblPrecoAssinante.getText();

        assertEquals(nome, txtNome);
        assertEquals(fornecedor, txtFornecedor);
        assertEquals(preco_normal, txtPrecoNormal);
        assertEquals(preco_assinante, txtPrecoAssinante);
        Report.criarLog("Validou os dados:");
        Report.criarLog("Nome: " + nome);
        Report.criarLog("Fornecedor: " + fornecedor);
        Report.criarLog("Preço Normal: " + preco_normal);
        Report.criarLog("Preço Assinante: " + txtPrecoAssinante);
    }

    public void incluiOProdutoNoCarrinho() {
        btnAdicionarAoCarrinho.click();
        Report.criarLog("Clicou no botão 'Adicionar ao Carrinho'");
        Report.tirarFotoDaTela();
    }

}

