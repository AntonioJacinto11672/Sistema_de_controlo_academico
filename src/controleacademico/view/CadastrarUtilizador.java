/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package controleacademico.view;

import controleacademico.ControleAcademico;
import controleacademico.controller.AlunoController;
import controleacademico.controller.ProfessorController;
import controleacademico.model.Professor;
import controleacademico.model.Aluno;
import controleacademico.model.User;

import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Double
 */
public class CadastrarUtilizador extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarUtilizador
     */
    ProfessorController professor = new ProfessorController();
    AlunoController aluno = new AlunoController();

    public CadastrarUtilizador() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        tfdNome = new javax.swing.JTextField();
        lbCargo = new javax.swing.JLabel();
        tfdCargo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jpfPassoword = new javax.swing.JPasswordField();
        jpfPasswordConfirm = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        cbxRole = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        spDate = new javax.swing.JSpinner();
        tfdNomeUsuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlbBack = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Nome");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));
        getContentPane().add(tfdNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 360, 30));

        lbCargo.setText("Cargo");
        getContentPane().add(lbCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));
        getContentPane().add(tfdCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 360, 30));

        jLabel5.setText("Senha");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, -1, -1));

        jpfPassoword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpfPassowordActionPerformed(evt);
            }
        });
        getContentPane().add(jpfPassoword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 360, 30));
        getContentPane().add(jpfPasswordConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 580, 360, 30));

        jLabel6.setText("Confirmar Senha");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 560, -1, -1));

        btnSave.setBackground(new java.awt.Color(0, 102, 94));
        btnSave.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Registar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 630, 360, 30));

        cbxRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Professor", "Aluno" }));
        cbxRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRoleActionPerformed(evt);
            }
        });
        getContentPane().add(cbxRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 360, 30));

        jLabel4.setText("Data de Nascimento");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        spDate.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(-1419511500000L), new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));
        getContentPane().add(spDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 360, 30));

        tfdNomeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdNomeUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(tfdNomeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 360, 30));

        jLabel7.setText("Nome de Usuário");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 110, -1));

        jPanel1.setBackground(new java.awt.Color(0, 102, 94));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fechar.png"))); // NOI18N
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Criar Conta");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 198, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/male-user-add_25347.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jlbBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/seta-esquerda (4).png"))); // NOI18N
        jlbBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbBackMouseClicked(evt);
            }
        });
        jPanel1.add(jlbBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 90));

        jLabel8.setText("Tipo de Usuário");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 100, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 60, 590));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jpfPassowordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpfPassowordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpfPassowordActionPerformed

    private void cbxRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRoleActionPerformed
        // TODO add your handling code here:
        String opcoaSelecionada = (String) cbxRole.getSelectedItem();
        if (opcoaSelecionada.equals("Aluno")) {
            tfdCargo.setVisible(false);
            lbCargo.setVisible(false);

        } else {
            tfdCargo.setVisible(true);
            lbCargo.setVisible(true);
        }
    }//GEN-LAST:event_cbxRoleActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String role = (String) cbxRole.getSelectedItem();
        Professor professorModel = new Professor();
        Aluno AlunoModel = new Aluno();

        //professorModel.setDataNascimento();
        Date dataNascimento1 = (Date) spDate.getValue();
        char[] password1 = jpfPassoword.getPassword();
        char[] password2 = jpfPasswordConfirm.getPassword();

        String userName = tfdNome.getText() + "" + professor.newId();
        String password = new String(password1);
        String passwordConform = new String(password2);
        User usersAc = ControleAcademico.searchUserName(tfdNomeUsuario.getText());

        professorModel.setNome(tfdNome.getText());
        professorModel.setDataNascimento(dataNascimento1);
        professorModel.setCargo(tfdCargo.getText());
        professorModel.setId(professor.newId());
        professorModel.setUserName(tfdNomeUsuario.getText());
        professorModel.setPassword(passwordConform);

        if (password.equals(passwordConform)) {

            //User usersAcade = ControleAcademico.searchUserName(professorModel.getUserName());
            if (usersAc == null) {
                if (role.equals("Professor")) {
                    boolean result = ControleAcademico.adicionarUsuario(professorModel);
                    if (result) {
                        JOptionPane.showMessageDialog(null, "Usuario Criado com sucesso!");
                        tfdCargo.setText("");
                        tfdNome.setText("");
                        tfdNomeUsuario.setText("");
                        jpfPassoword.setText("");
                        jpfPasswordConfirm.setText("");
                        spDate.setValue(new Date());

                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario Não cadastrado!");
                    }
                } else {
                    //Registar Aluno
                    AlunoModel.setNome(tfdNome.getText());
                    AlunoModel.setId(professor.newId());
                    AlunoModel.setUserName(tfdNomeUsuario.getText());
                    AlunoModel.setPassword(passwordConform);
                    boolean result = ControleAcademico.adicionarUsuario(AlunoModel);
                    if (result) {
                        JOptionPane.showMessageDialog(null, "Usuario Criado com sucesso!");
                        tfdCargo.setText("");
                        tfdNome.setText("");
                        tfdNomeUsuario.setText("");
                        jpfPassoword.setText("");
                        jpfPasswordConfirm.setText("");
                        spDate.setValue(new Date());

                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario Não cadastrado!");
                    }

                }

            } else {
                JOptionPane.showMessageDialog(null, "Já temos esse usuário Cadastrado");
            }
        } else {
            System.out.println(" Password Diferentes " + password + " != " + passwordConform);
            JOptionPane.showMessageDialog(null, "Palavra Passe não coêncidem");
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void tfdNomeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdNomeUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdNomeUsuarioActionPerformed

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCloseMouseClicked

    private void jlbBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbBackMouseClicked
        // TODO add your handling code here:
        new LoginForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jlbBackMouseClicked

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastrarUtilizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarUtilizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarUtilizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarUtilizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarUtilizador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClose;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbxRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jlbBack;
    private javax.swing.JPasswordField jpfPassoword;
    private javax.swing.JPasswordField jpfPasswordConfirm;
    private javax.swing.JLabel lbCargo;
    private javax.swing.JSpinner spDate;
    private javax.swing.JTextField tfdCargo;
    private javax.swing.JTextField tfdNome;
    private javax.swing.JTextField tfdNomeUsuario;
    // End of variables declaration//GEN-END:variables
}
