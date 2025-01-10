/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleacademico.model;

import java.util.Date;

/**
 *
 * @author Double
 */
public class Professor extends User  {

    private String cargo;
    private Date dataNascimento;

    public Professor(int id, String Nome,String cargo,Date dataNascimento, String userName, String password, String role) {
        super(id, Nome, userName, password, role);
        this.cargo = cargo;
        this.dataNascimento = dataNascimento;
    }

    public Professor() {
        super(0, null, null, null, null);
    }

    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    
   

   
    
    

       
    
}
