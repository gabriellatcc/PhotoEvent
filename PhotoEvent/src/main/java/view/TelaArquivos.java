package view;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;

import models.ArquivosCRUD;
import org.bson.Document;

public class TelaArquivos extends JPanel{
    private JPanel painelGaleria;
    private ArquivosCRUD arquivosCRUD;
    private JFrame tela;

    public TelaArquivos() {
        tela=new JFrame();
        tela.setTitle("Galeria de Fotos com MongoDB");
        tela.setSize(800, 600);
        tela.setLayout(new BorderLayout());
        this.tela=tela;

        arquivosCRUD = new ArquivosCRUD("GaleriaDB", "imagens");

        JPanel painelBotoes = new JPanel();
        JButton btnUpload = new JButton("Upload");
        JButton btnDelete = new JButton("Deletar");
        JButton btnUpdate = new JButton("Atualizar");

        painelBotoes.add(btnUpload);
        painelBotoes.add(btnDelete);
        painelBotoes.add(btnUpdate);
        tela.add(painelBotoes, BorderLayout.NORTH);

        painelGaleria = new JPanel();
        painelGaleria.setLayout(new GridLayout(0, 4, 10, 10));
        JScrollPane scrollPane = new JScrollPane(painelGaleria);
        tela.add(scrollPane, BorderLayout.CENTER);

        btnUpload.addActionListener(e -> fazerUpload());
        btnDelete.addActionListener(e -> fazerDelete());
        btnUpdate.addActionListener(e -> fazerUpdate());

        carregarImagens();
        tela.setVisible(true);
    }

    private void fazerUpload() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int resultado = fileChooser.showOpenDialog(tela);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File arquivo = fileChooser.getSelectedFile();
            String filePath = arquivo.getAbsolutePath();
            String fileName = arquivo.getName();

            arquivosCRUD.insertImage(filePath, fileName);
            carregarImagens();
        }
    }

    private void fazerDelete() {
        String fileName = JOptionPane.showInputDialog(this, "Digite o nome da imagem para deletar:");
        if (fileName != null && !fileName.isEmpty()) {
            arquivosCRUD.deleteImage(fileName);
            carregarImagens();
        }
    }

    private void fazerUpdate() {
        String oldName = JOptionPane.showInputDialog(this, "Digite o nome da imagem para atualizar:");
        if (oldName != null && !oldName.isEmpty()) {
            JFileChooser fileChooser = new JFileChooser();
            int resultado = fileChooser.showOpenDialog(tela);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                File arquivo = fileChooser.getSelectedFile();
                String newPath = arquivo.getAbsolutePath();
                String newName = arquivo.getName();

                arquivosCRUD.updateImage(oldName, newPath, newName);
                carregarImagens();
            }
        }
    }

    private void carregarImagens() {
        painelGaleria.removeAll();
        List<Document> imagens = arquivosCRUD.getAllImages();

        for (Document doc : imagens) {
            String filePath = doc.getString("filePath");
            ImageIcon imagem = new ImageIcon(filePath);
            JLabel labelImagem = new JLabel(imagem);
            labelImagem.setPreferredSize(new Dimension(150, 150));
            painelGaleria.add(labelImagem);
        }

        painelGaleria.revalidate();
        painelGaleria.repaint();
    }
}
