public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;

    private static int contadorId = 1; // Gera IDs automaticamente

    public Produto(String nome, String descricao, double preco, int quantidade) {
        this.id = contadorId++;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
}