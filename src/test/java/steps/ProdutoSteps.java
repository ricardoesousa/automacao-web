package steps;

import driver.DriverManagerFactory;
import properties.DefaultProperties;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.support.PageFactory;
import pages.Carrinho;
import pages.Home;
import pages.Produto;

public class ProdutoSteps extends DriverManagerFactory implements DefaultProperties {

    private final Home home = PageFactory.initElements(getDriver(), Home.class);
    private final Produto produto = PageFactory.initElements(getDriver(), Produto.class);
    private final Carrinho carrinho = PageFactory.initElements(getDriver(), Carrinho.class);

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
    }

    @Quando("excluir o produto do carrinho de compras")
    public void excluir_o_produto_do_carrinho_de_compras() {
        carrinho.excluiProduto();
    }

    @Então("a mensagem indicando que a sacola está vazia deve aparecer na tela")
    public void a_mensagem_indicando_que_a_sacola_está_vazia_deve_aparecer_na_tela() {
        carrinho.validaSacolaVazia();
    }




}
