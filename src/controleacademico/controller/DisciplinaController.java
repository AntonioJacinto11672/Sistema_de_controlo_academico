/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleacademico.controller;

import Exceptions.CredenciaisInvalidasException;
import java.util.ArrayList;
import controleacademico.model.Disciplina;

/**
 *
 * @author Double
 */
public class DisciplinaController {

    private static ArrayList<Disciplina> disciplina = new ArrayList<>();

    public static boolean saveDisciplina(Disciplina disc) {
        if (disc != null) {
            disciplina.add(disc);
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Disciplina> listaTodasDisciplina() {
        return disciplina;
    }

    public static int newIdDisciplina() {
        return disciplina.size() + 1;
    }

    public static Disciplina getDisciplinaById(int id) {
        return disciplina.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static boolean RemoveDisciplina(int id) {
        boolean result = disciplina.removeIf(p -> p.getId() == id);
        if (result) {
            return true;
        } else {
            return false;
        }
    }

    public static void validarCamposLogin(String nome, String ementa) throws CredenciaisInvalidasException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new CredenciaisInvalidasException("O campo 'Nome ' não pode estar vazio.");
        }
        if (ementa == null || ementa.trim().isEmpty()) {
            throw new CredenciaisInvalidasException("O campo 'Ementa' não pode estar vazio.");
        }
    }

    public static void autenticar(String nome, String ementa) throws CredenciaisInvalidasException {
        validarCamposLogin(nome, ementa);
        Disciplina result = disciplina.stream()
                .filter(u -> u.getNome().equals(nome))
                .findFirst()
                .orElse(null);
        if (result != null) {
            throw new CredenciaisInvalidasException("A Disciplina já está cadastrada.");
        }

    }
}
