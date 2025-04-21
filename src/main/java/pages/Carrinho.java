package pages;

import driver.DriverManagerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;
import static report.Report.salvarEvidencia;


public class Carrinho extends DriverManagerFactory {

    Actions action = new Actions(driver);

    @FindBy(css = ".delete-icon")
    private WebElement botaoLixeira;

    @FindBy(css = "button.button.is-large.button-submit")
    private WebElement botaoExcluir;

    public void validaDadosProduto(String nome, String preco_normal) {
        WebElement labelnome = driver.findElement(By.xpath("//div[@class='cart-item-detail']/div[text()='" + nome + "']"));
        WebElement labelPrecoNormal = driver.findElement(By.xpath("//div[@class='cart-item-detail detail-price']/div[@class='money' and text()='" + preco_normal + "']"));

        assertTrue(labelnome.isEnabled());
        assertTrue(labelPrecoNormal.isEnabled());
        salvarEvidencia("Validou os dados >>>\nNome: " + nome + "\nPreço Normal: " + preco_normal);
    }

    public void excluiProduto() {
        String mensagemEsperada = "Sua sacola está vazia";

        action.click(botaoLixeira).perform();
        salvarEvidencia("Clicou no botão 'Lixeira'");

        botaoExcluir.click();
        salvarEvidencia("Clicou no botão 'Excluir'");

        WebElement labelSacolaVazia = driver.findElement(By.xpath("//h1[text()='" + mensagemEsperada + "']"));
        assertTrue(labelSacolaVazia.isEnabled());
        salvarEvidencia("Validou mensagem '" + mensagemEsperada + "'");

    }

}

