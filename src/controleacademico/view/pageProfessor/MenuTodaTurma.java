/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package controleacademico.view.pageProfessor;

import controleacademico.view.pagesAluno.*;
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

        DefaultComboBoxModel<String> modeloDisciplinas = new DefaultComboBoxModel<>();
        for (Disciplina d : DisciplinaController.listaTodasDisciplina()) {
            modeloDisciplinas.addElement(d.getNome());
            //cbxDisciplina.addItem(d.getNome());
        }
        cbxDisciplina.setModel(modeloDisciplinas);
    }

    private void ExibirInformacoes() {

        //ArrayList<TurmaModel> TurmaData = TurmaController.listaTodasTurma();
        Professor usuarioLogado = (Professor) UsuarioLogadoController.getUsuarioLogado();
        ArrayList<TurmaModel> turmaData = TurmaController.listaTodasTurma();
        DefaultTableModel tbTurma = (DefaultTableModel) jtbTurma.getModel();

        System.out.print("Inicializou o Metodo");
        tbTurma.setRowCount(0);

        // Adiciona os dados filtrados ou todos os dados
        Disciplina disciplina = null;
        String nomeDisciplina = "";
        String nomeEmenta = "";
        String nomesProfessores = "";

        for (TurmaModel turma : turmaData) {
            //System.out.println("Tamanho do Array " + rendimento.getTrabalhos() == null);

            if (turma.getDisciplina() != null && !turma.getDisciplina().isEmpty()) {
                for (Disciplina discipli : turma.getDisciplina()) {
                    //System.out.println("Length " + turma.getDisciplina().size());
                    if (discipli != null) {

                        disciplina = discipli;
                        nomeDisciplina = nomeDisciplina.concat(discipli.getNome() + ", ");
                        if (discipli.getProfessor().getNome() != null) {
                            nomesProfessores = nomesProfessores.concat(discipli.getProfessor().getNome() + ",");
                        }
                    }

                }
            }
            if (! nomesProfessores.equals(usuarioLogado.getNome())) {
                tbTurma.addRow(new Object[]{
                    turma.getId(),
                    nomeDisciplina,
                    nomesProfessores,
                    turma.getCapacidade()});
            }
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
        btnMinhaTurma = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxDisciplina = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbTurma = new javax.swing.JTable();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        btnMinhaTurma.setBackground(new java.awt.Color(0, 102, 94));
        btnMinhaTurma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnMinhaTurma.setForeground(new java.awt.Color(255, 255, 255));
        btnMinhaTurma.setText("Minha Turma");
        btnMinhaTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinhaTurmaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 94));
        jLabel4.setText("Todas as turmas");

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 2, 13)); // NOI18N
        jLabel5.setText("\"Para te fazeres parte de uma turma Seleciona uma Turma e clica em Minha Turma\"");

        jLabel6.setFont(new java.awt.Font("Bookman Old Style", 2, 13)); // NOI18N
        jLabel6.setText("\"Para te fazeres parte de uma turma Seleciona uma Turma e clica em Minha Turma\"");

        jLabel1.setText("Seleciona a Disciplina");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(cbxDisciplina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnMinhaTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))))
                .addGap(23, 76, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMinhaTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addGap(14, 14, 14))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 668, 130));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 670, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtbTurmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbTurmaMouseClicked

    }//GEN-LAST:event_jtbTurmaMouseClicked

    private void btnMinhaTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinhaTurmaActionPerformed
        // TODO add your handling code here:

        DefaultTableModel tbTurma = (DefaultTableModel) jtbTurma.getModel();
        if (jtbTurma.getSelectedRow() != -1) {

            int id = (int) tbTurma.getValueAt(jtbTurma.getSelectedRow(), 0);
            String nomeDisciplina = (String) cbxDisciplina.getSelectedItem();
            Disciplina disciplinaById = DisciplinaController.getDisciplinaByName(nomeDisciplina);
            if (disciplinaById != null) {
                Professor usuarioLogado = (Professor) UsuarioLogadoController.getUsuarioLogado();
                if (UsuarioLogadoController.isUsuarioLogado()) {
                    disciplinaById.setProfessor(usuarioLogado);
                    
                    ExibirInformacoes();
                    JOptionPane.showMessageDialog(null, "Operação efetuada com Sucesso");

                } else {
                    JOptionPane.showMessageDialog(null, "Usuario Desconhecido irá sair do Sistema");
                }
            } else {
                JOptionPane.showMessageDialog(null, "A Disciplina não está cadastrada nessa Turma");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleciona uma Turma para Fazer a Matricula");
        }


    }//GEN-LAST:event_btnMinhaTurmaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMinhaTurma;
    private javax.swing.JComboBox<String> cbxDisciplina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbTurma;
    // End of variables declaration//GEN-END:variables
}
