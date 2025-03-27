import java.util.ArrayList;
import java.util.List;

public class ProdutoSys {
    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public boolean excluirProduto(int id) {
        return produtos.removeIf(produto -> produto.getId() == id);
    }
}