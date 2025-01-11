/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleacademico.controller;

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
    
    public static boolean RemoveDisciplina(int id){
        boolean result = disciplina.removeIf(p -> p.getId() == id);
        if(result) {
            return true;
        } else {
            return false;
        }
    }
}
