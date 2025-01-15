/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleacademico.model;

/**
 *
 * @author Double
 */
public class Disciplina {

    
    private int id;
    private String nome;
    private String ementa;
    private Professor professor;

    public Disciplina(int id, String nome, String ementa, Professor professor) {
        this.id = id;
        this.nome = nome;
        this.ementa = ementa;
        this.professor = professor;
    }

    public Disciplina() {
    }
    
    

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    
}
