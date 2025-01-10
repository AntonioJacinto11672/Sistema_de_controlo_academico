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
    private ArrayList <Disciplina> disciplina = new ArrayList<>();
    
    public boolean saveDisciplina(Disciplina disc) {
        if(disc != null){
            disciplina.add(disc);
            return true;
        } else {
            return false;
        }
    }
    
    public ArrayList<Disciplina> listaTodasDisciplina(){
        return disciplina;
    }
    
}
