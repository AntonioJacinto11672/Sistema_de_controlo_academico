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
public class MenuMedia extends javax.swing.JInternalFrame {

    /**
     * Creates new form Disciplina
     */
    public MenuMedia() {
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
            for(Disciplina disc:turmaM.getDisciplina()) {
                disciplina = disc;
            }

            modeloTurma.addElement(turmaM.getId() + "-" + disciplina.getNome());
            //cbxTurma.addItem(turmaM.getDisciplina().getNome());
        }
        cbxTurma.setModel(modeloTurma);

        lbAlunoAprovado.setText("");
        lbAlunoExame.setText("");
        lbAlunoReprovados.setText("");

    }

    private void ExibirInformacoes(int idTurma) {
//ArrayList<TurmaModel> TurmaData = TurmaController.listaTodasTurma();
        Professor usuarioLogado = (Professor) UsuarioLogadoController.getUsuarioLogado();
        ArrayList<RendimentoEscolar> RendimentoData = RendimentoEscolarController.getAlunosByTurma(idTurma);
        DefaultTableModel tbTurma = (DefaultTableModel) jtbRendimento.getModel();

        //System.out.print("Inicializou o Metodo");
        tbTurma.setRowCount(0);

        // Adiciona os dados filtrados ou todos os dados
        String trabalhoString = "";
        String notaTrabalhoString = "";
        float media = 0.0f;
        float maP1 = 0.0f;
        float maP2 = 0.0f;
        float mpP1 = 0.0f;
        float mpP2 = 0.0f;
        String situacao = "";
        int aprovados = 0, exameFinal = 0, reprovados = 0;

        for (RendimentoEscolar rendimento : RendimentoData) {
            if (rendimento.getTrabalhos() != null) {
                trabalhoString = RendimentoEscolarController.TrabalhoToString(rendimento.getTrabalhos());

            }

            if (rendimento.getNotasTrabalhos() != null) {
                notaTrabalhoString = RendimentoEscolarController.notaTrabalhoToString(rendimento.getNotasTrabalhos());
                if (rendimento.getNotasTrabalhos().length > 0 && rendimento.getNotasTrabalhos().length < 5) {
                    maP1 = (rendimento.getNotasTrabalhos()[0] + rendimento.getNotasTrabalhos()[1]) / 2;
                    maP2 = (rendimento.getNotasTrabalhos()[2] + rendimento.getNotasTrabalhos()[3]) / 2;
                    mpP1 = Math.min(rendimento.getNotaProva1() + 0.1f * maP1, 10);
                    mpP2 = Math.min(rendimento.getNotaProva2() + 0.1f * maP2, 10);

                    media = (0.4f * mpP1) + (0.6f * mpP2);
                    media = Math.round(media);

                    if (media >= 7) {
                        situacao = "Aprovado";
                        aprovados++;
                    } else if (media >= 4) {
                        situacao = "Exame Final";
                        exameFinal++;
                    } else {
                        situacao = "Reprovado";
                        reprovados++;
                    }
                    //System.out.println("Trabalho  nota:  média Artimetrica 1" + maP1 + " Media arti 2" + maP2 + "média ponderada 1" + mpP1 + "média ponderada 1" + mpP2);
                    //System.out.println("Média Final" + media);
                }
            }

            //System.out.println("Tamanho do Array " + rendimento.getTrabalhos() == null);
            tbTurma.addRow(new Object[]{
                rendimento.getAluno().getNome(),
                maP1,
                maP2,
                mpP1,
                mpP2,
                media,
                situacao,});
        }

        lbAlunoAprovado.setText("Alunos Reprovados: " + aprovados);
        lbAlunoExame.setText("Alunos no Exame Final: " + exameFinal);
        lbAlunoReprovados.setText("Alunos Reprovadoss: " + reprovados);
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
        cbxTurma = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        lbAlunoAprovado = new javax.swing.JLabel();
        lbAlunoReprovados = new javax.swing.JLabel();
        lbAlunoExame = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitleMain.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        lbTitleMain.setForeground(new java.awt.Color(0, 102, 94));
        lbTitleMain.setText("Turmas Matriculadas");

        jtbRendimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Aluno", "MA P1", "MA P2", "MP P1", "MP P2", "Média Final", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
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

        cbxTurma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTurmaActionPerformed(evt);
            }
        });

        jLabel5.setText("Seleciona a Turma");

        lbAlunoAprovado.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        lbAlunoAprovado.setForeground(new java.awt.Color(0, 102, 94));
        lbAlunoAprovado.setText("Aluno Aprovados");

        lbAlunoReprovados.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        lbAlunoReprovados.setForeground(new java.awt.Color(255, 0, 0));
        lbAlunoReprovados.setText("Aluno Reprovados");

        lbAlunoExame.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        lbAlunoExame.setForeground(new java.awt.Color(255, 153, 0));
        lbAlunoExame.setText("Aluno no Exame");

        javax.swing.GroupLayout painelMainLayout = new javax.swing.GroupLayout(painelMain);
        painelMain.setLayout(painelMainLayout);
        painelMainLayout.setHorizontalGroup(
            painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMainLayout.createSequentialGroup()
                .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelMainLayout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(lbTitleMain))
                    .addGroup(painelMainLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel5))
                    .addGroup(painelMainLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 9, Short.MAX_VALUE))
            .addGroup(painelMainLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lbAlunoAprovado)
                .addGap(40, 40, 40)
                .addComponent(lbAlunoExame)
                .addGap(71, 71, 71)
                .addComponent(lbAlunoReprovados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelMainLayout.setVerticalGroup(
            painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMainLayout.createSequentialGroup()
                .addComponent(lbTitleMain, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAlunoAprovado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAlunoReprovados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbAlunoExame, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        getContentPane().add(painelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 680, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JComboBox<String> cbxTurma;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtbRendimento;
    private javax.swing.JLabel lbAlunoAprovado;
    private javax.swing.JLabel lbAlunoExame;
    private javax.swing.JLabel lbAlunoReprovados;
    private javax.swing.JLabel lbTitleMain;
    private javax.swing.JPanel painelMain;
    // End of variables declaration//GEN-END:variables
}
