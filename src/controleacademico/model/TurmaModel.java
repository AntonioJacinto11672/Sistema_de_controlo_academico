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
import java.util.Date;

/**
 *
 * @author Double
 */
public class TurmaModel {

    private int id;
    private ArrayList<Disciplina> disciplinas;
    private ArrayList<Professor> professores;
    private int capacidade;

    public TurmaModel(int id, ArrayList<Disciplina> disciplinas, ArrayList<Professor> professores, int capacidade) {
        this.id = id;
        this.disciplinas = disciplinas;
        this.professores = professores;
        this.capacidade = capacidade;
    }

    public TurmaModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {

        if (this.disciplinas != null) {
            if (this.disciplinas.isEmpty()) {
                //System.out.println("Entrou Mas Está vazio");

                for (Disciplina dicipli : disciplinas) {
                    this.getDisciplinas().add(dicipli);
                    //System.out.println("Entrou Mas Está vazio ");

                }
            } else {

            }
        }

        if (this.disciplinas == null) {
            this.disciplinas = new ArrayList<>();
            this.disciplinas.addAll(disciplinas);

            System.out.println("Entrou no method null");

        }

        System.out.println("Equipamento " + this.disciplinas.size());

    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(ArrayList<Professor> professores) {
        this.professores = professores;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void addDisciplina(Disciplina disciplina) {
        System.out.println("id da turama na Model " + this.id);
        if (disciplinas != null && !disciplinas.isEmpty()) {
            disciplinas.add(disciplina);

        }
    }
}
