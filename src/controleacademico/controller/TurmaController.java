/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleacademico.controller;

import Exceptions.CredenciaisInvalidasException;
import Exceptions.TurmaLotadaException;
import controleacademico.model.Disciplina;
import controleacademico.model.TurmaModel;
import controleacademico.model.Aluno;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author Double
 */
public class TurmaController {

    private static ArrayList<TurmaModel> turmas = new ArrayList<>();

    public static int TotalTurma() {
        return turmas.size();
    }

    public static boolean adicionarTurma(TurmaModel turma) {
        if (turma != null) {
            turmas.add(turma);
            TurmaModel turmas = new TurmaModel();

            //System.out.println(turmas.size());
            return true;
        } else {
            return false;
        }
    }

    //Adicionar Turma 
    public static boolean saveAlunoInturma(Aluno aluno, int idTurma) throws TurmaLotadaException {
        int index = idTurma - 1;
        System.out.println("Index " + index);
        if (turmas.get(index).getAlunos().size() >= turmas.get(index).getCapacidade()) {
            throw new TurmaLotadaException("A turma está cheia.");
        }
        if (aluno != null && idTurma > 0) {
            turmas.get(index).getAlunos().add(aluno);
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<TurmaModel> listaTodasTurma() {
        return turmas;
    }

    public static ArrayList<TurmaModel> listaTodasTurmaVerificarAluno(Aluno aluno) {
        if (aluno != null) {
            return turmas.stream().filter(turma -> turma.getAlunos().stream().noneMatch(alunoF -> alunoF.getId() == aluno.getId()))
                    .collect(Collectors.toCollection(ArrayList::new));
        } else {
            return null;
        }

    }

    public static int newIdTurma() {
        return turmas.size() + 1;
    }

    public static boolean RemoveTurma(int id) {
        boolean result = turmas.removeIf(p -> p.getId() == id);
        if (result) {
            return true;
        } else {
            return false;
        }
    }

    public static TurmaModel getTurmaById(int id) {
        return turmas.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static void autenticar(Disciplina disciplina) throws CredenciaisInvalidasException {
        boolean result = turmas.stream()
                .anyMatch(u -> u.getDisciplina().equals(disciplina));

        if (result) {
            throw new CredenciaisInvalidasException("A Turma Com Disciplina já está cadastrada.");
        }

    }

    public static void autenticarAtualiação(Disciplina disciplina, int idTurma) throws CredenciaisInvalidasException {
        boolean result = turmas.stream()
                .anyMatch(u -> u.getDisciplina().equals(disciplina) && u.getId() != idTurma);

        if (result) {
            throw new CredenciaisInvalidasException("A Turma Com Disciplina já está cadastrada.");
        }

    }

    //Relação turma e aluno
    public static void alunoMatriculado(Aluno alunoM, int idTurma) throws TurmaLotadaException {
        if (alunoM == null) {
            throw new TurmaLotadaException("Aluno Desconhecido");
        }
        boolean valid = turmas.stream().anyMatch(p -> p.getAlunos().equals(alunoM) && p.getId() == idTurma);
        if (valid) {
            throw new TurmaLotadaException("Já estais nessa turma.");
        }

    }
}
