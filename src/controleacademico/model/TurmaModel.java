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
    private Disciplina disciplina;
    private Professor professor;
    private static int capacidade;
    private static ArrayList<Aluno> alunos;

    public TurmaModel(int id, Disciplina disciplina, Professor professor, int capacidade) {
        this.id = id;
        this.disciplina = disciplina;
        this.professor = professor;
        this.capacidade = capacidade;
        this.alunos = new ArrayList<>();
    }

    public TurmaModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public static  boolean adicionarAluno(Aluno aluno) throws TurmaLotadaException {
        if (alunos.size() >= capacidade) {
            throw new TurmaLotadaException("A turma está cheia.");
        }
        if (aluno != null) {

            alunos.add(aluno);
            return true;
        } else {
            return false;
        }
    }

    public static  boolean alunoMatriculado(Aluno alunoM, int idTurma) throws TurmaLotadaException {
        if(alunoM == null ) {
            throw new TurmaLotadaException("Aluno Desconhecido");
        }
       
        Aluno alunoF = alunos.stream().filter(a -> a.getId() == alunoM.getId())
                .findFirst()
                .orElse(null);

        if (alunoF == null) {
            return true;
        } else {
            System.out.println("");
            throw new TurmaLotadaException("Usuario já está nessa Turma: " + alunoF.getUserName());
        }

    }

}
