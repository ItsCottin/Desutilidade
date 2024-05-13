/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.*;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.intellijthemes.*;
import dbmanager.Conexao;
import dbmanager.DBLogin;
import java.sql.Connection;
import javax.swing.UIManager;

/**
 *
 * @author 00348046
 */
public class Desutilidade extends javax.swing.JFrame {

    private UIManager.LookAndFeelInfo[] themes;
    
    /**
     * Creates new form Desutilidade
     */
    public Desutilidade() {
        initComponents();
        themes = new UIManager.LookAndFeelInfo[]
        {
            new UIManager.LookAndFeelInfo(FlatLightLaf.NAME, FlatLightLaf.class.getName()),
            new UIManager.LookAndFeelInfo(FlatDarkLaf.NAME, FlatDarkLaf.class.getName()),
            new UIManager.LookAndFeelInfo(FlatIntelliJLaf.NAME, FlatIntelliJLaf.class.getName()),
            new UIManager.LookAndFeelInfo(FlatDarculaLaf.NAME, FlatDarculaLaf.class.getName()),
            new UIManager.LookAndFeelInfo(FlatMacDarkLaf.NAME, FlatMacDarkLaf.class.getName()),
            new UIManager.LookAndFeelInfo(FlatMacLightLaf.NAME, FlatMacLightLaf.class.getName()),
            new UIManager.LookAndFeelInfo(FlatArcIJTheme.NAME, FlatArcIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatArcDarkIJTheme.NAME, FlatArcDarkIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatArcDarkOrangeIJTheme.NAME, FlatArcDarkOrangeIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatArcOrangeIJTheme.NAME, FlatArcOrangeIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatCarbonIJTheme.NAME, FlatCarbonIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatCobalt2IJTheme.NAME, FlatCobalt2IJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatCyanLightIJTheme.NAME, FlatCyanLightIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatDarkFlatIJTheme.NAME, FlatDarkFlatIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatDarkPurpleIJTheme.NAME, FlatDarkPurpleIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatDraculaIJTheme.NAME, FlatDraculaIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatGradiantoDarkFuchsiaIJTheme.NAME, FlatGradiantoDarkFuchsiaIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatGradiantoDeepOceanIJTheme.NAME, FlatGradiantoDeepOceanIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatGradiantoMidnightBlueIJTheme.NAME, FlatGradiantoMidnightBlueIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatGradiantoNatureGreenIJTheme.NAME, FlatGradiantoNatureGreenIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatGrayIJTheme.NAME, FlatGrayIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatGruvboxDarkHardIJTheme.NAME, FlatGruvboxDarkHardIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatGruvboxDarkMediumIJTheme.NAME, FlatGruvboxDarkMediumIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatGruvboxDarkSoftIJTheme.NAME, FlatGruvboxDarkSoftIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatHiberbeeDarkIJTheme.NAME, FlatHiberbeeDarkIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatHighContrastIJTheme.NAME, FlatHighContrastIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatLightFlatIJTheme.NAME, FlatLightFlatIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatMaterialDesignDarkIJTheme.NAME, FlatMaterialDesignDarkIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatMonocaiIJTheme.NAME, FlatMonocaiIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatMonokaiProIJTheme.NAME, FlatMonokaiProIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatNordIJTheme.NAME, FlatNordIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatOneDarkIJTheme.NAME, FlatOneDarkIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatSolarizedDarkIJTheme.NAME, FlatSolarizedDarkIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatSolarizedLightIJTheme.NAME, FlatSolarizedLightIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatSpacegrayIJTheme.NAME, FlatSpacegrayIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatVuesionIJTheme.NAME, FlatVuesionIJTheme.class.getName()),
            new UIManager.LookAndFeelInfo(FlatXcodeDarkIJTheme.NAME, FlatXcodeDarkIJTheme.class.getName())
        };
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (UIManager.LookAndFeelInfo info : themes) {
            listModel.addElement(info.getName());
        }
        listaTema.setModel(listModel);
        listaTema.addListSelectionListener(e -> {
            // Verifique se uma seleção foi feita
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = listaTema.getSelectedIndex();
                if (selectedIndex != -1) {
                    try {
                        // Aplique o tema selecionado
                        UIManager.setLookAndFeel(themes[selectedIndex].getClassName());
                        SwingUtilities.updateComponentTreeUI(this);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelLogin = new javax.swing.JPanel();
        tituloMain = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        campoUsuario = new javax.swing.JTextField();
        labelSenha = new javax.swing.JLabel();
        campoSenha = new javax.swing.JTextField();
        botaoLogin = new javax.swing.JButton();
        BotaoCadastro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaTema = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Desutilidade");
        setMaximumSize(new java.awt.Dimension(476, 290));
        setMinimumSize(new java.awt.Dimension(476, 290));
        setPreferredSize(new java.awt.Dimension(476, 290));
        setResizable(false);

        painelLogin.setFocusable(false);
        painelLogin.setMaximumSize(new java.awt.Dimension(476, 290));
        painelLogin.setMinimumSize(new java.awt.Dimension(476, 290));
        painelLogin.setPreferredSize(new java.awt.Dimension(476, 290));

        tituloMain.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        tituloMain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloMain.setText("Desutilidade");

        labelUsuario.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        labelUsuario.setText("Usuário:");

        campoUsuario.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        campoUsuario.setMaximumSize(new java.awt.Dimension(140, 29));
        campoUsuario.setMinimumSize(new java.awt.Dimension(140, 29));
        campoUsuario.setPreferredSize(new java.awt.Dimension(140, 29));

        labelSenha.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        labelSenha.setText("Senha:");

        campoSenha.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        campoSenha.setMaximumSize(new java.awt.Dimension(140, 29));
        campoSenha.setMinimumSize(new java.awt.Dimension(140, 29));
        campoSenha.setPreferredSize(new java.awt.Dimension(140, 29));

        botaoLogin.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        botaoLogin.setText("Entrar");

        BotaoCadastro.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        BotaoCadastro.setText("Cadastrar");
        BotaoCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarAction(evt);
            }
        });

        listaTema.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaTema);

        javax.swing.GroupLayout painelLoginLayout = new javax.swing.GroupLayout(painelLogin);
        painelLogin.setLayout(painelLoginLayout);
        painelLoginLayout.setHorizontalGroup(
            painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLoginLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelLoginLayout.createSequentialGroup()
                        .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelSenha)
                            .addComponent(labelUsuario)
                            .addComponent(botaoLogin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotaoCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(tituloMain))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        painelLoginLayout.setVerticalGroup(
            painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLoginLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(painelLoginLayout.createSequentialGroup()
                        .addComponent(tituloMain)
                        .addGap(31, 31, 31)
                        .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelUsuario)
                            .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelSenha)
                            .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoLogin)
                            .addComponent(BotaoCadastro))))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarAction
        //Conexao conexao = new Conexao();
        //Connection conect = conexao.conectar();
        DBLogin dbLogin = new DBLogin();
        dbLogin.setLogin(campoUsuario.getText());
        dbLogin.setSenha(campoSenha.getText());
        dbLogin.incluirLogin();
        System.out.println("Deu bom?");
    }//GEN-LAST:event_cadastrarAction

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
            //for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            //    if ("Nimbus".equals(info.getName())) {
            //        javax.swing.UIManager.setLookAndFeel(info.getClassName());
            //        break;
            //    }
            //}
        //} catch (ClassNotFoundException ex) {
        //    java.util.logging.Logger.getLogger(Desutilidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        //} catch (InstantiationException ex) {
        //    java.util.logging.Logger.getLogger(Desutilidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        //} catch (IllegalAccessException ex) {
        //    java.util.logging.Logger.getLogger(Desutilidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Desutilidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Desutilidade().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoCadastro;
    private javax.swing.JButton botaoLogin;
    private javax.swing.JTextField campoSenha;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JList<String> listaTema;
    private javax.swing.JPanel painelLogin;
    private javax.swing.JLabel tituloMain;
    // End of variables declaration//GEN-END:variables
}
