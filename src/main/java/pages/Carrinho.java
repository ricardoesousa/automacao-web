package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import report.Report;

import static org.junit.Assert.assertEquals;


public class Carrinho {

    @FindBy(css = ".td-resumo")
    private WebElement lblNome;

    @FindBy(css = "td.preco")
    private WebElement lblPrecoNormal;

    public void validaDadosProduto(String nome, String preco_normal) {
        String txtNome = lblNome.getText();
        String txtPrecoNormal = lblPrecoNormal.getText();

        Report.tirarFotoDaTela();
        assertEquals(nome, txtNome);
        assertEquals(preco_normal, txtPrecoNormal);
        Report.criarLog("Validou os dados: ");
        Report.criarLog("Nome: " + nome);
        Report.criarLog("Preço Normal: " + preco_normal);
    }

}

