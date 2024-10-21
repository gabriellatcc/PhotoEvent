package view;
import javax.swing.*;
import java.awt.*;

public class TelaInicial extends javax.swing.JFrame
{
    public TelaInicial()
    {
        initComponents();
        this.setResizable(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelInicial = new javax.swing.JPanel();
        jPanelLogin = new javax.swing.JPanel();
        jPanelCadastro = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanelInicial.setBackground(new java.awt.Color(255, 255, 255));
        jPanelInicial.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanelInicial.setLayout(null);
        jPanelLogin.setVisible(true);

        JTextArea titulo = new JTextArea(4,20);
        titulo.setText("Bem-vindo(a) ao Photo Event para: Luz e Lente Fotografia");
        titulo.setLineWrap(true); // Permite a quebra de linha
        titulo.setWrapStyleWord(true); // Quebra a linha por palavras
        titulo.setEditable(false); // O texto nao será editavel
        titulo.setFocusable(false); // Remove o foco do componente do cursor
        titulo.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 40));
        titulo.setForeground(new java.awt.Color(37, 114, 232)); // Cor do texto
        titulo.setOpaque(false); // Torna o fundo transparente, para se parecer mais com um JLabel
        titulo.setBounds(300, 50, 200, 40);//x y largura altura
        jPanelInicial.setLayout(new BorderLayout());
        jPanelInicial.add(titulo, BorderLayout.CENTER);

        JTextArea frase = new JTextArea(4, 20);
        frase.setText("Registre seus eventos e veja a listagem de clientes do seu negócio para manter a organização");
        frase.setLineWrap(true);
        frase.setWrapStyleWord(true);
        frase.setEditable(false);
        frase.setFocusable(false);
        frase.setFont(new java.awt.Font("SansSerif", 1, 25));
        frase.setOpaque(false);
        frase.setBounds(300, 150, 200, 25);
        jPanelInicial.add(frase);

        ImageIcon imagem = new ImageIcon(getClass().getResource("/images/logo.jpg"));
        JLabel logomarca=new JLabel(imagem);
        logomarca.setBounds(75, 100, 200, 200);
        jPanelInicial.add(logomarca);

        JButton entrar=new JButton("Entrar");
        entrar.setBackground(new java.awt.Color(37, 114, 232));
        entrar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        entrar.setForeground(new java.awt.Color(255, 255, 255));
        entrar.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 114, 232), 4, true), javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7)));
        entrar.setPreferredSize(new java.awt.Dimension(200, 50));
        entrar.setBounds(450, 320, 200, 50);
        entrar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });
        jPanelInicial.add(entrar);

        JButton cadastrar=new JButton("Cadastrar");
        cadastrar.setBackground(new java.awt.Color(37, 114, 232));
        cadastrar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        cadastrar.setForeground(new java.awt.Color(255, 255, 255));
        cadastrar.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 114, 232), 4, true), javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7)));
        cadastrar.setPreferredSize(new java.awt.Dimension(200, 50));
        cadastrar.setBounds(450, 320, 200, 50);
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });
        jPanelInicial.add(cadastrar);

        javax.swing.GroupLayout jPanelInicialLayout = new javax.swing.GroupLayout(jPanelInicial);
        jPanelInicial.setLayout(jPanelInicialLayout);
        jPanelInicialLayout.setHorizontalGroup(
            jPanelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInicialLayout.createSequentialGroup()
                .addComponent(logomarca)
                .addGap(18, 18, 18)
                .addComponent(entrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInicialLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInicialLayout.createSequentialGroup()
                        .addComponent(titulo)
                        .addGap(173, 173, 173))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInicialLayout.createSequentialGroup()
                        .addComponent(frase)
                        .addGap(201, 201, 201))))
        );

        jPanelInicialLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {entrar, cadastrar});

        jPanelInicialLayout.setVerticalGroup(
            jPanelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInicialLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(titulo)
                .addGap(20, 20, 20)
                .addComponent(frase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE) // Aqui
                .addGap(74, 74, 74)
                .addGroup(jPanelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInicialLayout.createSequentialGroup()
                        .addComponent(logomarca, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInicialLayout.createSequentialGroup()
                        .addGroup(jPanelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(entrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(180, 180, 180))))
        );

        jPanelInicialLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {entrar, cadastrar});

        getContentPane().add(jPanelInicial, "card2");

        jPanelLogin.setPreferredSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 931, Short.MAX_VALUE)
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelLogin, "card3");

        jPanelCadastro.setPreferredSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout jPanelCadastroLayout = new javax.swing.GroupLayout(jPanelCadastro);
        jPanelCadastro.setLayout(jPanelCadastroLayout);
        jPanelCadastroLayout.setHorizontalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 931, Short.MAX_VALUE)
        );
        jPanelCadastroLayout.setVerticalGroup(
            jPanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelCadastro, "card4");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelCadastro;
    private javax.swing.JPanel jPanelInicial;
    private javax.swing.JPanel jPanelLogin;
    // End of variables declaration//GEN-END:variables
}