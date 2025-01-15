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
public class MenuMinhaTurma extends javax.swing.JInternalFrame {

    /**
     * Creates new form Disciplina
     */
    public MenuMinhaTurma() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        //ExibirInformacoes();

        DefaultComboBoxModel<String> modeloTurma = new DefaultComboBoxModel<>();
        Professor usuarioLogado = (Professor) UsuarioLogadoController.getUsuarioLogado();
        ArrayList<TurmaModel> turmaData = TurmaController.getTurmaByProfessor(usuarioLogado);

        modeloTurma.addElement("Seleciona");
        Disciplina disciplina = null;
        for (TurmaModel turmaM : turmaData) {
            for (Disciplina disc : turmaM.getDisciplina()) {
                disciplina = disc;
                //System.err.println("Disciplinas do mesmo" + disc.getNome());
            }

            modeloTurma.addElement(turmaM.getId() + "-" + disciplina.getNome());
            //cbxTurma.addItem(turmaM.getDisciplina().getNome());
        }
        cbxTurma.setModel(modeloTurma);

    }

    private void ExibirInformacoes(int idTurma) {
//ArrayList<TurmaModel> TurmaData = TurmaController.listaTodasTurma();
        Professor usuarioLogado = (Professor) UsuarioLogadoController.getUsuarioLogado();
        ArrayList<RendimentoEscolar> RendimentoData = RendimentoEscolarController.getAlunosByTurma(idTurma);
        DefaultTableModel tbTurma = (DefaultTableModel) jtbRendimento.getModel();

        System.out.print("Inicializou o Metodo");
        tbTurma.setRowCount(0);

        // Adiciona os dados filtrados ou todos os dados
        String trabalhoString = "";
        String notaTrabalhoString = "";

        for (RendimentoEscolar rendimento : RendimentoData) {
            if (rendimento.getTrabalhos() != null) {
                trabalhoString = RendimentoEscolarController.TrabalhoToString(rendimento.getTrabalhos());
            }

            if (rendimento.getNotasTrabalhos() != null) {
                notaTrabalhoString = RendimentoEscolarController.notaTrabalhoToString(rendimento.getNotasTrabalhos());
            }

            //System.out.println("Tamanho do Array " + rendimento.getTrabalhos() == null);
            tbTurma.addRow(new Object[]{
                rendimento.getTurma().getId(),
                rendimento.getAluno().getId() + "-" + rendimento.getAluno().getNome(),
                rendimento.getNotaProva1(),
                rendimento.getNotaProva2(),
                trabalhoString,
                notaTrabalhoString,});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelMain = new javax.swing.JPanel();
        lbTitleMain = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbRendimento = new javax.swing.JTable();
        jspSelecionarTrabalho = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        btnSubmitTrabalho = new javax.swing.JButton();
        jspNotaTrabalho = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jspSelecionarProva = new javax.swing.JSpinner();
        jspNotaProva = new javax.swing.JSpinner();
        btnSubmitProva = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxTurma = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitleMain.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        lbTitleMain.setForeground(new java.awt.Color(0, 102, 94));
        lbTitleMain.setText("Turmas Matriculadas");

        jtbRendimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Turma", "Aluno", "Nota P1", "Nota P2", "Trabalhos", "Nota dos Trabalhos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbRendimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbRendimentoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbRendimento);

        jspSelecionarTrabalho.setModel(new javax.swing.SpinnerNumberModel(1, 1, 4, 1));

        jLabel2.setText("Seleciona o Trabalho");

        btnSubmitTrabalho.setBackground(new java.awt.Color(0, 102, 94));
        btnSubmitTrabalho.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSubmitTrabalho.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmitTrabalho.setText("Efectuar Nota do Trabalho");
        btnSubmitTrabalho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitTrabalhoActionPerformed(evt);
            }
        });

        jspNotaTrabalho.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(10.0f), Float.valueOf(1.0f)));

        jLabel3.setText("Nota");

        jspSelecionarProva.setModel(new javax.swing.SpinnerNumberModel(1, 1, 2, 1));

        jspNotaProva.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        btnSubmitProva.setBackground(new java.awt.Color(0, 102, 94));
        btnSubmitProva.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSubmitProva.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmitProva.setText("Efectuar Nota");
        btnSubmitProva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitProvaActionPerformed(evt);
            }
        });

        jLabel4.setText("Seleciona á Prova");

        jLabel6.setText("Nota");

        cbxTurma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTurmaActionPerformed(evt);
            }
        });

        jLabel5.setText("Seleciona a Turma");

        javax.swing.GroupLayout painelMainLayout = new javax.swing.GroupLayout(painelMain);
        painelMain.setLayout(painelMainLayout);
        painelMainLayout.setHorizontalGroup(
            painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE))
            .addGroup(painelMainLayout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(lbTitleMain)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(painelMainLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelMainLayout.createSequentialGroup()
                        .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jspSelecionarProva, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(jspSelecionarTrabalho))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(painelMainLayout.createSequentialGroup()
                                .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painelMainLayout.createSequentialGroup()
                                        .addComponent(jspNotaTrabalho)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSubmitTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelMainLayout.createSequentialGroup()
                                        .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jspNotaProva, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                            .addGroup(painelMainLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel5)
                                                .addGap(47, 47, 47)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSubmitProva, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(29, 29, 29))))
                    .addGroup(painelMainLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(112, 112, 112)
                        .addComponent(jLabel3)
                        .addContainerGap())
                    .addGroup(painelMainLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(78, 78, 78)
                        .addComponent(cbxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        painelMainLayout.setVerticalGroup(
            painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMainLayout.createSequentialGroup()
                .addComponent(lbTitleMain, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jspSelecionarTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jspNotaTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubmitTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelMainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jspSelecionarProva, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jspNotaProva, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubmitProva, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(jLabel5))
                    .addGroup(painelMainLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6)
                        .addGap(57, 57, 57)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        getContentPane().add(painelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 680, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitTrabalhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitTrabalhoActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tbTurma = (DefaultTableModel) jtbRendimento.getModel();
        if (jtbRendimento.getSelectedRow() != -1) {

            String alunoString = tbTurma.getValueAt(jtbRendimento.getSelectedRow(), 1).toString();
            //Pegar id Turma
            String[] partes = alunoString.split("-");
            int parteInteiraIdAluno = Integer.parseInt(partes[0]);

            //Pegar id Turma
            String idTurma = tbTurma.getValueAt(jtbRendimento.getSelectedRow(), 0).toString();
            int parteInteiraIdTurma = Integer.parseInt(idTurma);

            int valueTrabalhos = (int) jspSelecionarTrabalho.getValue();
            float valueNotaTrabalhos = Float.parseFloat(jspNotaTrabalho.getValue().toString());

            //Pegar rendimento com a turma
            RendimentoEscolar rendimentoP = RendimentoEscolarController.getRendimentoByIdAlunoIdTurma(parteInteiraIdAluno, parteInteiraIdTurma);
            //System.out.println("Rendimento status:  " + rendimentoP.getAluno().getNome());

            rendimentoP.setNotasTrabalhos(valueTrabalhos, valueNotaTrabalhos);
            //rendimentoP.setTrabalhos(valueEntrega);
            ExibirInformacoes(parteInteiraIdTurma);
            rendimentoP.setNotaProva1(10);
            JOptionPane.showMessageDialog(null, "Nota do Trabalho atualizada  com Sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Seleciona um Aluno");
        }

    }//GEN-LAST:event_btnSubmitTrabalhoActionPerformed

    private void btnSubmitProvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitProvaActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tbTurma = (DefaultTableModel) jtbRendimento.getModel();
        if (jtbRendimento.getSelectedRow() != -1) {

            String alunoString = tbTurma.getValueAt(jtbRendimento.getSelectedRow(), 1).toString();
            //Pegar id Turma
            String[] partes = alunoString.split("-");
            int parteInteiraIdAluno = Integer.parseInt(partes[0]);

            //Pegar id Turma
            String idTurma = tbTurma.getValueAt(jtbRendimento.getSelectedRow(), 0).toString();
            int parteInteiraIdTurma = Integer.parseInt(idTurma);

            int valueProva = (int) jspSelecionarProva.getValue();
            float valueNotaProva = Float.parseFloat(jspNotaProva.getValue().toString());

            //Pegar rendimento com a turma
            RendimentoEscolar rendimentoP = RendimentoEscolarController.getRendimentoByIdAlunoIdTurma(parteInteiraIdAluno, parteInteiraIdTurma);
            //System.out.println("Rendimento status:  " + rendimentoP.getAluno().getNome());

            if (valueProva == 1) {
                rendimentoP.setNotaProva1(valueNotaProva);
            }

            if (valueProva == 2) {
                rendimentoP.setNotaProva2(valueNotaProva);
            }

            //rendimentoP.setTrabalhos(valueEntrega);
            ExibirInformacoes(parteInteiraIdTurma);
            JOptionPane.showMessageDialog(null, "Nota do Trabalho atualizada  com Sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Seleciona um Aluno");
        }

    }//GEN-LAST:event_btnSubmitProvaActionPerformed

    private void jtbRendimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbRendimentoMouseClicked
        // TODO add your handling code here:
        if (jtbRendimento.getSelectedRow() != -1) {

        }
    }//GEN-LAST:event_jtbRendimentoMouseClicked

    private void cbxTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTurmaActionPerformed
        // TODO add your handling code here:
        //System.out.print("itens Selecionados " + cbxTurma.getSelectedItem());
        String cbxTurmaValue = (String) cbxTurma.getSelectedItem();
        if (cbxTurmaValue.equals("Seleciona")) {
            DefaultTableModel tbTurma = (DefaultTableModel) jtbRendimento.getModel();
            tbTurma.setRowCount(0);

        } else {
            String[] partes = cbxTurmaValue.split("-");
            int id = Integer.parseInt(partes[0]);

            if (id < 0) {
                return;
            } else {
                ExibirInformacoes(id);
            }
        }
    }//GEN-LAST:event_cbxTurmaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmitProva;
    private javax.swing.JButton btnSubmitTrabalho;
    private javax.swing.JComboBox<String> cbxTurma;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jspNotaProva;
    private javax.swing.JSpinner jspNotaTrabalho;
    private javax.swing.JSpinner jspSelecionarProva;
    private javax.swing.JSpinner jspSelecionarTrabalho;
    private javax.swing.JTable jtbRendimento;
    private javax.swing.JLabel lbTitleMain;
    private javax.swing.JPanel painelMain;
    // End of variables declaration//GEN-END:variables
}
