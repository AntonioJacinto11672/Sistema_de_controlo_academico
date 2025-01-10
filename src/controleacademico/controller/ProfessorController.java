/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleacademico.controller;

import controleacademico.model.Professor;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Double
 */
public class ProfessorController {

    private ArrayList<Professor> professor = new ArrayList<>();

    public boolean cadastrarProfessor(Professor prof) {
        if (prof != null) {
            professor.add(prof);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Professor Não registado");
            return false;
        }
    }

    public ArrayList<Professor> retornarTodos() {
        return professor;
    }

    public int newId() {
        return professor.size() + 1;
    }

    

}
