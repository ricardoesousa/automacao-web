package pages;

import driver.DriverManagerFactory;
import hooks.DefaultProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import report.Report;

import static report.Report.salvarEvidencia;

public class Home extends DriverManagerFactory {

    @FindBy(id = "aceiteLgpd")
    private WebElement btnContinuarEFechar;

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    private WebElement btnProsseguirComTodos;

    @FindBy(id = "search")
    private WebElement boxPesquisa;

    @FindBy(className = "button-search")
    private WebElement btnLupa;

    private WebElement prodSelecionado;

    public void acessaAplicacao() {
        getDriver().get(DefaultProperties.URL_BASE);
        String site = getDriver().getTitle();
        salvarEvidencia("Entrou no site - " + site);
        btnProsseguirComTodos.click();
        salvarEvidencia("Clicou no botão 'Prosseguir com todos' - Aviso de Cookies");
    }

    public void fazPesquisa(String pesquisa) {
         salvarEvidencia("Escreveu " + pesquisa + " no box de pesquisa");
        btnLupa.click();
        salvarEvidencia("Clicou no botão lupa");
    }

    public void selecionaProduto(String num_lista) {
        WebElement prodSelecionado = driver.findElement(By.cssSelector(".liProduct:nth-child(" + num_lista + ")"));
        salvarEvidencia("Selecionou o produto de número " + num_lista + " na lista");
        prodSelecionado.click();
        salvarEvidencia("Clicou no produto selecionado");
    }


}

