/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleacademico.model;

import Exceptions.TurmaLotadaException;
import java.util.ArrayList;
import controleacademico.model.Aluno;
import controleacademico.model.Disciplina;
import controleacademico.model.Professor;

/**
 *
 * @author Double
 */
public class TurmaModel {

    private int id;
    private ArrayList<Disciplina> disciplinas;
    private int capacidade;

    public TurmaModel(int id, int capacidade) {
        this.id = id;
        this.capacidade = capacidade;
    }

    public TurmaModel() {
        this.disciplinas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Disciplina> getDisciplina() {
        return disciplinas;
    }

    public void setDisciplina(Disciplina disciplina) {
        if (this.disciplinas == null) {
            this.disciplinas = new ArrayList<>();
        }
        
        this.disciplinas.add(disciplina);
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

}
