package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import driver.DriverManagerFactory;
import hooks.DefaultProperties;
import org.openqa.selenium.support.PageFactory;
import pages.Carrinho;
import pages.Home;
import pages.Produto;

public class ProdutoSteps extends DriverManagerFactory implements DefaultProperties {

    private Home home = PageFactory.initElements(getDriver(), Home.class);
    private Produto produto = PageFactory.initElements(getDriver(), Produto.class);
    private Carrinho carrinho = PageFactory.initElements(getDriver(), Carrinho.class);

    @Dado("eu tenha acessado o site PETZ e tenha feito a pesquisa por: {string}")
    public void euTenhaAcessadoOSitePETZETenhaFeitoAPesquisaPor(String pesquisa) {
        home.acessaAplicacao();
        home.fazPesquisa(pesquisa);
    }

    @Quando("eu selecionar o produto {string}, validar os dados: {string},{string},{string},{string}")
    public void euSelecionarOProduto(String num_lista, String nome, String fornecedor, String preco_normal, String preco_assinante) {
        home.selecionaProduto(num_lista);
        produto.validaDadosProduto(nome, fornecedor, preco_normal, preco_assinante);
    }

    @E("incluir no carrinho de compras")
    public void incluirNoCarrinhoDeCompras() {
        produto.incluiOProdutoNoCarrinho();
    }

    @Então("o produto deve continuar com os dados idênticos ao da página de produto: {string},{string}")
    public void oProdutoDeveContinuarComOsDadosIdenticosAoDaHomepage(String nome, String preco_normal) {
        carrinho.validaDadosProduto(nome, preco_normal);
        carrinho.excluiProduto();
    }


}
