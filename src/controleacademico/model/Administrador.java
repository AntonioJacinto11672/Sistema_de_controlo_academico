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
public class Administrador extends User {

    private ArrayList<Disciplina> disciplinas;
    private ArrayList<Turma> turmas;
    private ArrayList<Professor> professores;

    public Administrador(int id, String Nome, String userName, String password, String role) {
        super(id, Nome, userName, password, role);
        this.disciplinas = new ArrayList<>();
        this.turmas = new ArrayList<>();
        this.professores = new ArrayList<>();

    }

    public void cadastrarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
        System.out.println("Disciplina cadastrada com sucesso: " + disciplina.getNome());
    }

    public void listarDisciplinas() {
        System.out.println("Disciplinas cadastradas:");
        disciplinas.forEach(d -> System.out.println(d.getId() + " - " + d.getNome()));
    }
}

// Classe Turma
class Turma {

    private int id;
    private Disciplina disciplina;
    private Professor professor;
    private int capacidade;

    public Turma(int id, Disciplina disciplina, Professor professor, int capacidade) {
        this.id = id;
        this.disciplina = disciplina;
        this.professor = professor;
        this.capacidade = capacidade;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

}
