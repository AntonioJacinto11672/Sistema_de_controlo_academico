/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleacademico.model;

import java.util.ArrayList;

/**
 *
 * @author Double
 */
public class Aluno extends User {

    private ArrayList<Turma> turmasMatriculadas;

    public Aluno(int id, String Nome, String userName, String password, String role) {
        super(id, Nome, userName, password, role);
        this.turmasMatriculadas = turmasMatriculadas;
    }

    public Aluno() {
        super(0, null, null, null, null);
    }
    
    
     public ArrayList<Turma> getTurmasMatriculadas() {
        return turmasMatriculadas;
    }

    public void matricularNaTurma(Turma turma) {
        if (turmasMatriculadas.contains(turma)) {
            System.out.println("Você já está matriculado nesta turma.");
        } else if (turma.getCapacidade() > 0) {
            turmasMatriculadas.add(turma);
            turma.setCapacidade(turma.getCapacidade() - 1);
        } else {
            System.out.println("A turma está cheia.");
        }
    }
    
    
    
    

}
