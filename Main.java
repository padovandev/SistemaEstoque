import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@SuppressWarnings("unused")

public class Main {
    private static ProdutoSys produtoSys = new ProdutoSys();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::criarJanela);
    }

    public static void criarJanela() {
        JFrame frame = new JFrame("Controle de Estoque | WC Sistemas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);

        BackgroundPanel backgroundPanel = new BackgroundPanel("fundo.jpg");
        frame.setContentPane(backgroundPanel);
        backgroundPanel.setLayout(new BorderLayout());

        JTextArea txtProdutos = new JTextArea();
        txtProdutos.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtProdutos);

        JButton btnListar = new JButton("Listar Produtos");
        btnListar.addActionListener(e -> {
            txtProdutos.setText("");
            for (Produto p : produtoSys.listarProdutos()) {
                txtProdutos.append("ID: " + p.getId() +
                        " | Nome: " + p.getNome() +
                        " | Preço: R$ " + p.getPreco() +
                        " | Qtd: " + p.getQuantidade() + "\n");
            }
        });

        JButton btnCadastrar = new JButton("Cadastrar Produto");
        btnCadastrar.addActionListener(e -> abrirFormularioCadastro());

        JButton btnExcluir = new JButton("Excluir Produto");
        btnExcluir.addActionListener(e -> excluirProduto());

        JPanel panelBotoes = new JPanel();
        panelBotoes.setOpaque(false);
        panelBotoes.add(btnListar);
        panelBotoes.add(btnCadastrar);
        panelBotoes.add(btnExcluir);

        backgroundPanel.add(panelBotoes, BorderLayout.NORTH);
        backgroundPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(panelBotoes, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static void abrirFormularioCadastro() {
        JTextField txtNome = new JTextField();
        JTextField txtDescricao = new JTextField();
        JTextField txtPreco = new JTextField();
        JTextField txtQuantidade = new JTextField();

        Object[] campos = {
                "Nome:", txtNome,
                "Descrição:", txtDescricao,
                "Preço:", txtPreco,
                "Quantidade:", txtQuantidade
        };

        int option = JOptionPane.showConfirmDialog(null, campos, "Cadastrar Produto", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                Produto produto = new Produto(
                        txtNome.getText(),
                        txtDescricao.getText(),
                        Double.parseDouble(txtPreco.getText()),
                        Integer.parseInt(txtQuantidade.getText()));
                produtoSys.adicionarProduto(produto);
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + ex.getMessage());
            }
        }
    }

    private static void excluirProduto() {
        String idStr = JOptionPane.showInputDialog(null, "Digite o ID do produto a ser excluído:");
        if (idStr != null && !idStr.isEmpty()) {
            try {
                int id = Integer.parseInt(idStr);
                boolean removido = produtoSys.excluirProduto(id);
                if (removido) {
                    JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Produto não encontrado!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID inválido!");
            }
        }
    }
}
