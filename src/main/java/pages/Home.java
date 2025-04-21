package pages;

import driver.DriverManagerFactory;
import hooks.DefaultProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static report.Report.salvarEvidencia;

public class Home extends DriverManagerFactory {

    @FindBy(id = "aceiteLgpd")
    private WebElement botaoContinuarEFechar;

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    private WebElement botaoProsseguirComTodos;

    @FindBy(id = "headerSearch")
    private WebElement campoPesquisa;

    @FindBy(xpath = "/html/body/div[9]/ptz-header/header/div/div/ptz-header-search/form/ptz-text-field/ptz-input/ptz-icon")
    private WebElement botaoLupa;

    public void acessaAplicacao() {
        getDriver().get(DefaultProperties.URL_BASE);
        String site = getDriver().getTitle();
        salvarEvidencia("Entrou no site - " + site);
        botaoProsseguirComTodos.click();
        salvarEvidencia("Clicou no botão 'Prosseguir com todos - Aviso de Cookies'");
    }

    public void fazPesquisa(String pesquisa) {
        campoPesquisa.sendKeys(pesquisa);
        salvarEvidencia("Escreveu '" + pesquisa + "' no box de pesquisa");
        botaoLupa.click();
        salvarEvidencia("Clicou no botão 'Lupa'");
    }

    public void selecionaProduto(String num_lista) {
        WebElement produtoSelecionado = driver.findElement(By.xpath("//*[@itemtype='https://schema.org/ListItem'][" + num_lista + "]"));
        produtoSelecionado.click();
        salvarEvidencia("Selecionou o produto de número " + num_lista + " na lista");
    }
}

