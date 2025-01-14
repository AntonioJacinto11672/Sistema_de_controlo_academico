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
public class MenuMinhaTurma extends javax.swing.JInternalFrame {

    /**
     * Creates new form Disciplina
     */
    public MenuMinhaTurma() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        ExibirInformacoes();

    }

    private void ExibirInformacoes() {
//ArrayList<TurmaModel> TurmaData = TurmaController.listaTodasTurma();
        Aluno usuarioLogado = (Aluno) UsuarioLogadoController.getUsuarioLogado();
        ArrayList<RendimentoEscolar> RendimentoData = RendimentoEscolarController.getRedimentoBYAluno(usuarioLogado);
        DefaultTableModel tbTurma = (DefaultTableModel) jtbRendimento.getModel();

        System.out.print("Inicializou o Metodo");
        tbTurma.setRowCount(0);

        // Adiciona os dados filtrados ou todos os dados
        String trabalhoString = "";
        String notaTrabalhoString = "";
        Disciplina disciplina = null;

        for (RendimentoEscolar rendimento : RendimentoData) {
            if (rendimento.getTrabalhos() != null) {
                trabalhoString = RendimentoEscolarController.TrabalhoToString(rendimento.getTrabalhos());
            }

            if (rendimento.getNotasTrabalhos() != null) {
                notaTrabalhoString = RendimentoEscolarController.notaTrabalhoToString(rendimento.getNotasTrabalhos());
            }

            for (Disciplina disc : rendimento.getTurma().getDisciplina()) {
                disciplina = disc;
                //System.err.println("Disciplinas do mesmo" + disc.getNome());
            }

            //System.out.println("Tamanho do Array " + rendimento.getTrabalhos() == null);
            tbTurma.addRow(new Object[]{
                rendimento.getTurma().getId() + "-" + disciplina.getNome(),
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
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbRendimento = new javax.swing.JTable();
        jspEntregar = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        btnEntregar = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitleMain.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        lbTitleMain.setForeground(new java.awt.Color(0, 102, 94));
        lbTitleMain.setText("Turmas Matriculadas");

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 2, 13)); // NOI18N
        jLabel5.setText("\"Para Entrega de Trabalho Seleciona a turma\"");

        jtbRendimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Turma", "Nota P1", "Nota P2", "Trabalhos", "Nota dos Trabalhos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtbRendimento);

        jspEntregar.setModel(new javax.swing.SpinnerNumberModel(1, 1, 4, 1));

        jLabel2.setText("Entregar Trabalho");

        btnEntregar.setBackground(new java.awt.Color(0, 102, 94));
        btnEntregar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEntregar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntregar.setText("Entregar Trabalho");
        btnEntregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelMainLayout = new javax.swing.GroupLayout(painelMain);
        painelMain.setLayout(painelMainLayout);
        painelMainLayout.setHorizontalGroup(
            painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
            .addGroup(painelMainLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelMainLayout.createSequentialGroup()
                        .addComponent(jspEntregar, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEntregar, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelMainLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(lbTitleMain))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(painelMainLayout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jLabel5)
                .addGap(0, 213, Short.MAX_VALUE))
        );
        painelMainLayout.setVerticalGroup(
            painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMainLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lbTitleMain, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jspEntregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEntregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(painelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 680, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntregarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tbTurma = (DefaultTableModel) jtbRendimento.getModel();
        if (jtbRendimento.getSelectedRow() != -1) {
            Object trTeste = jtbRendimento.getValueAt(jtbRendimento.getSelectedRow(), 1);
            Aluno usuarioLogado = (Aluno) UsuarioLogadoController.getUsuarioLogado();
            String turmaString = (String) jtbRendimento.getValueAt(jtbRendimento.getSelectedRow(), 0);
            //Pegar id Turma
            String[] partes = turmaString.split("-");
            int parteInteiraIdTurma = Integer.parseInt(partes[0]);

            //System.out.println(" " + trTeste);
            //Pegar os trabalhos verificar se tem trabalho
            Object trabalhos = jtbRendimento.getValueAt(jtbRendimento.getSelectedRow(), 3);
            //Pegar sppiner value
            int valueEntrega = (int) jspEntregar.getValue();
            //Pegar o rendiment
            if (trabalhos == null) {

                //System.out.println("Trabalhos nulll" + valueEntrega + "id Turma " + parteInteiraIdTurma);
            }
            //Pegar rendimento com a turma
            RendimentoEscolar rendimentoP = RendimentoEscolarController.getRendimentoByIdAlunoIdTurma(usuarioLogado.getId(), parteInteiraIdTurma);
            if (rendimentoP == null) {

            }
            int[] trabalhoAEtregar = {valueEntrega};
            float notap1 = 10;
            rendimentoP.setTrabalhos(valueEntrega);
            rendimentoP.setNotaProva1(10);

            //System.out.println("Rendimento status:  " + rendimentoP.getAluno().getNome());
            ExibirInformacoes();
        } else {
            JOptionPane.showMessageDialog(null, "Seleciona uma Turma");
        }

    }//GEN-LAST:event_btnEntregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntregar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jspEntregar;
    private javax.swing.JTable jtbRendimento;
    private javax.swing.JLabel lbTitleMain;
    private javax.swing.JPanel painelMain;
    // End of variables declaration//GEN-END:variables
}
