/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleacademico.controller;

import controleacademico.model.Aluno;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Double
 */
public class AlunoController {
      private ArrayList<Aluno> aluno = new ArrayList<>();

    public boolean cadastrarProfessor(Aluno alun) {
        if (alun != null) {
            aluno.add(alun);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Professor Não registado");
            return false;
        }
    }

    public ArrayList<Aluno> retornarTodos() {
        return aluno;
    }

    public int newId() {
        return aluno.size() + 1;
    }
    
}
