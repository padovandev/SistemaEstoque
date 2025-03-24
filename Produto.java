public class Produto {
    private int id;
    private String name;
    private String desc;
    private double price;
    private int ammount;
    private int categoryID;

    public Produto(int id, String name, String desc, double price, int ammount, int categoryID) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.ammount = ammount;
        this.categoryID = categoryID;
    }

    // Getters do Produto
    public int getId() {
        return id;
    }

    public String getNome() {
        return name;
    }

    public String getDescricao() {
        return desc;
    }

    public double getPreco() {
        return price;
    }

    public int getQuantidade() {
        return ammount;
    }

    public int getCategoriaId() {
        return categoryID;
    }

    // Setters do Produto
    public void setNome(String name) {
        this.name = name;
    }

    public void setDescricao(String desc) {
        this.desc = desc;
    }

    public void setPreco(double price) {
        this.price = price;
    }

    public void setQuantidade(int ammount) {
        this.ammount = ammount;
    }

    public void setCategoriaId(int categoryID) {
        this.categoryID = categoryID;
    }
}
