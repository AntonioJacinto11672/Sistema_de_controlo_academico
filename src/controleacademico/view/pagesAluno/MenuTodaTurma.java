/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package controleacademico.view.pagesAluno;

import Exceptions.CredenciaisInvalidasException;
import Exceptions.TurmaLotadaException;
import controleacademico.model.Disciplina;
import controleacademico.model.RendimentoEscolar;
import controleacademico.model.TurmaModel;
import controleacademico.ControleAcademico;
import controleacademico.controller.DisciplinaController;
import controleacademico.controller.RendimentoEscolarController;
import controleacademico.controller.UsuarioController;
import controleacademico.controller.TurmaController;
import controleacademico.controller.UsuarioLogadoController;
import controleacademico.model.Aluno;
import controleacademico.model.Professor;
import controleacademico.model.User;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Double
 */
public class MenuTodaTurma extends javax.swing.JInternalFrame {

    /**
     * Creates new form Disciplina
     */
    public MenuTodaTurma() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        ExibirInformacoes();

    }

    private void ExibirInformacoes() {

        //ArrayList<TurmaModel> TurmaData = TurmaController.listaTodasTurma();
        Aluno usuarioLogado = (Aluno) UsuarioLogadoController.getUsuarioLogado();
        ArrayList<TurmaModel> TurmaData = RendimentoEscolarController.obterTurmasNaoMatriculadas(usuarioLogado);
        DefaultTableModel tbTurma = (DefaultTableModel) jtbTurma.getModel();

        System.out.print("Inicializou o Metodo");
        tbTurma.setRowCount(0);

        // Adiciona os dados filtrados ou todos os dados
        for (TurmaModel turma : TurmaData) {
            tbTurma.addRow(new Object[]{
                turma.getId(),
                turma.getDisciplina().getId() + "-" + turma.getDisciplina().getNome(),
                turma.getProfessor().getId() + "-" + turma.getProfessor().getNome(),
                turma.getCapacidade()
            });
        }
        /*for (int i = 0; i < disciPlinaData.size(); i++) {
            jtbDisciplina.setValueAt("", i, 0);
            jtbDisciplina.setValueAt("", i, 1);
            System.out.print("Aqui no 1 " + disciPlinaData.get(i).getNome());

        }
        for (int i = 0; i < disciPlinaData.size() && disciPlinaData.get(i) != null; i++) {
            jtbDisciplina.setValueAt(disciPlinaData.get(i).getId(), i, 0);
            jtbDisciplina.setValueAt(disciPlinaData.get(i).getNome(), i, 1);
            jtbDisciplina.setValueAt(disciPlinaData.get(i).getEmenta(), i, 2);
            System.out.print("Aqui no 2 " + disciPlinaData.get(i).getNome());
        }*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnMatricular = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbTurma = new javax.swing.JTable();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        btnMatricular.setBackground(new java.awt.Color(0, 102, 94));
        btnMatricular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnMatricular.setForeground(new java.awt.Color(255, 255, 255));
        btnMatricular.setText("Fazer Matricula");
        btnMatricular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatricularActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 94));
        jLabel4.setText("Todas as turmas");

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 2, 13)); // NOI18N
        jLabel5.setText("\"Para te matriculares em uma turma Seleciona uma Turma e clica em Fazer Matricula\"");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMatricular, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel5)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMatricular, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 668, 90));

        jtbTurma.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 94), 1, true));
        jtbTurma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Disciplina", "Professor", "Capacidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbTurma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbTurmaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbTurma);
        if (jtbTurma.getColumnModel().getColumnCount() > 0) {
            jtbTurma.getColumnModel().getColumn(0).setResizable(false);
            jtbTurma.getColumnModel().getColumn(1).setResizable(false);
            jtbTurma.getColumnModel().getColumn(2).setResizable(false);
            jtbTurma.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 670, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtbTurmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbTurmaMouseClicked

    }//GEN-LAST:event_jtbTurmaMouseClicked

    private void btnMatricularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatricularActionPerformed
        // TODO add your handling code here:

        try {
            DefaultTableModel tbTurma = (DefaultTableModel) jtbTurma.getModel();
            if (jtbTurma.getSelectedRow() != -1) {
                int id = (int) tbTurma.getValueAt(jtbTurma.getSelectedRow(), 0);
                TurmaModel turmaById = TurmaController.getTurmaById(id);
                if (turmaById != null) {
                    User usuarioLogado = (Aluno) UsuarioLogadoController.getUsuarioLogado();
                    if (UsuarioLogadoController.isUsuarioLogado()) {
                        Aluno alunoData = new Aluno(usuarioLogado.getId(), usuarioLogado.getNome(), usuarioLogado.getUserName(), usuarioLogado.getPassword(), "Aluno");
                        //TurmaController.alunoMatriculado(alunoData, id);
                        //boolean res = TurmaController.saveAlunoInturma(alunoData, id);
                        //System.out.println("Usuario Logado");
                        RendimentoEscolar RendimentoModal = new RendimentoEscolar();
                        RendimentoModal.setAluno(alunoData);
                        RendimentoModal.setTurma(turmaById);
                        boolean res = RendimentoEscolarController.saveRendimentoEscolar(turmaById, RendimentoModal);
                        System.out.println("id TUrma fora " + turmaById.getId());
                        if (res) {
                            ExibirInformacoes();
                            JOptionPane.showMessageDialog(null, "Matriculado com Sucesso!: " + turmaById.getDisciplina().getNome());
                        } else {
                            JOptionPane.showMessageDialog(null, "Matricula Sem Sucesso");

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario Desconhecido irá sair do Sistema");
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Seleciona uma Turma para Fazer a Matricula");
            }
        } catch (TurmaLotadaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro no Aluno", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnMatricularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMatricular;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbTurma;
    // End of variables declaration//GEN-END:variables
}
