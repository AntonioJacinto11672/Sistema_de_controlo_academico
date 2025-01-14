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
public class MenuHome extends javax.swing.JInternalFrame {

    /**
     * Creates new form Disciplina
     */
    public MenuHome() {
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
        DefaultTableModel tbTurma = (DefaultTableModel) jtbTurma.getModel();

        tbTurma.setRowCount(0);
        Disciplina disciplina = null;

        for (RendimentoEscolar rendimento : RendimentoData) {
            //System.out.println("Tamanho do Array " + rendimento.getTrabalhos() == null);
            for (Disciplina disc : rendimento.getTurma().getDisciplina()) {
                disciplina = disc;
                //System.err.println("Disciplinas do mesmo" + disc.getNome());
            }
            tbTurma.addRow(new Object[]{
                rendimento.getTurma().getId(),
                disciplina.getNome(),
                disciplina.getEmenta(),
                disciplina.getProfessor().getNome(),});
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
        jtbTurma = new javax.swing.JTable();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitleMain.setFont(new java.awt.Font("Bookman Old Style", 1, 16)); // NOI18N
        lbTitleMain.setForeground(new java.awt.Color(0, 102, 94));
        lbTitleMain.setText("Turmas");

        jtbTurma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Número", "Disciplina", "Ementa da disciplina", "Professor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtbTurma);

        javax.swing.GroupLayout painelMainLayout = new javax.swing.GroupLayout(painelMain);
        painelMain.setLayout(painelMainLayout);
        painelMainLayout.setHorizontalGroup(
            painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
            .addGroup(painelMainLayout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(lbTitleMain)
                .addContainerGap(372, Short.MAX_VALUE))
        );
        painelMainLayout.setVerticalGroup(
            painelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelMainLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lbTitleMain, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(painelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 680, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtbTurma;
    private javax.swing.JLabel lbTitleMain;
    private javax.swing.JPanel painelMain;
    // End of variables declaration//GEN-END:variables
}
