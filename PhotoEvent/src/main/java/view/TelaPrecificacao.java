package view;

import controllers.BordaPadraoController;
import models.PrecificacaoCRUD;

import javax.swing.*;
import java.awt.*;

public class TelaPrecificacao extends JPanel {
    private TelaMenuAdmin telaMenuAdmin;
    private JTextField txtPrecoAssistente, txtPrecoFotografo, txtPrecoVideomaker, txtPrecoEditorVideo, txtPrecoEditorFoto;
    private JButton btnSalvar;

    public TelaPrecificacao(TelaMenuAdmin telaMenuAdmin) {
        this.telaMenuAdmin = telaMenuAdmin;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(new Color(255, 255, 255));

        JButton voltarBtn = new JButton("⬅");
        voltarBtn.setForeground(new Color(0x393536));
        voltarBtn.setBackground(new Color(0xffffff));
        voltarBtn.setFocusable(false);
        voltarBtn.setFocusPainted(false);
        voltarBtn.setBorder(BorderFactory.createEmptyBorder(7, 1, 7, 1));
        voltarBtn.setFont(new Font("Calibre", Font.BOLD, 35));
        voltarBtn.setHorizontalAlignment(SwingConstants.CENTER);
        voltarBtn.setBounds(10, 10, 70, 55);
        voltarBtn.addActionListener(evt -> telaMenuAdmin.mostrarCard("cardMenu"));
        add(voltarBtn, BorderLayout.WEST);

        JLabel title = new JLabel("Precificação de Cargos");
        title.setFont(new Font("Open Sans", Font.BOLD, 40));
        title.setForeground(new Color(0x393536));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);

        JPanel painelCampos = new JPanel();
        painelCampos.setLayout(new GridLayout(6, 2, 10, 10)); // Usando GridLayout para distribuir os campos de forma organizada
        painelCampos.setBackground(new Color(255, 255, 255));

        PrecificacaoCRUD model = new PrecificacaoCRUD();

        JLabel lblAssistente = new JLabel("Assistente (por hora):");
        lblAssistente.setFont(new Font("Open Sans", Font.PLAIN, 18));
        txtPrecoAssistente = new JTextField();
        painelCampos.add(lblAssistente);
        painelCampos.add(txtPrecoAssistente);

        JLabel lblFotografo = new JLabel("Fotógrafo (por hora):");
        lblFotografo.setFont(new Font("Open Sans", Font.PLAIN, 18));
        txtPrecoFotografo = new JTextField();
        painelCampos.add(lblFotografo);
        painelCampos.add(txtPrecoFotografo);

        JLabel lblVideomaker = new JLabel("Videomaker (por hora):");
        lblVideomaker.setFont(new Font("Open Sans", Font.PLAIN, 18));
        txtPrecoVideomaker = new JTextField();
        painelCampos.add(lblVideomaker);
        painelCampos.add(txtPrecoVideomaker);

        JLabel lblEditorVideo = new JLabel("Editor de Vídeo (por hora):");
        lblEditorVideo.setFont(new Font("Open Sans", Font.PLAIN, 18));
        txtPrecoEditorVideo = new JTextField();
        painelCampos.add(lblEditorVideo);
        painelCampos.add(txtPrecoEditorVideo);

        JLabel lblEditorFoto = new JLabel("Editor de Foto (por hora):");
        lblEditorFoto.setFont(new Font("Open Sans", Font.PLAIN, 18));
        txtPrecoEditorFoto = new JTextField();
        painelCampos.add(lblEditorFoto);
        painelCampos.add(txtPrecoEditorFoto);

        add(painelCampos, BorderLayout.CENTER);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBackground(new Color(0x4CAF50));
        btnSalvar.setForeground(Color.WHITE);
        btnSalvar.setFont(new Font("Open Sans", Font.BOLD, 18));
        btnSalvar.setFocusable(false);
        btnSalvar.addActionListener(e -> {
            try {
                model.definirPrecoPorCargo("Assistente", Double.parseDouble(txtPrecoAssistente.getText()));
                model.definirPrecoPorCargo("Fotógrafo", Double.parseDouble(txtPrecoFotografo.getText()));
                model.definirPrecoPorCargo("Videomaker", Double.parseDouble(txtPrecoVideomaker.getText()));
                model.definirPrecoPorCargo("Editor de Vídeo", Double.parseDouble(txtPrecoEditorVideo.getText()));
                model.definirPrecoPorCargo("Editor de Foto", Double.parseDouble(txtPrecoEditorFoto.getText()));
                JOptionPane.showMessageDialog(this, "Preços salvos com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar: " + ex.getMessage());
            }
        });
        JPanel painelBotao = new JPanel();
        painelBotao.add(btnSalvar);
        painelBotao.setBackground(new Color(255, 255, 255));
        add(painelBotao, BorderLayout.SOUTH);
    }

}