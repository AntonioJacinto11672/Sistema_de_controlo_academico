/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controleacademico;

import controleacademico.model.Administrador;
import controleacademico.model.Aluno;
import controleacademico.model.Disciplina;
import controleacademico.model.Professor;
import controleacademico.model.User;
import controleacademico.controller.UsuarioController;
import controleacademico.view.LoginForm;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Double
 */
public class ControleAcademico {

    private static ArrayList<User> users = new ArrayList<>();


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //new LoginForm().setVisible(true);
        UsuarioController.carregarUsers();

        new LoginForm().setVisible(true);
    }

   
  
      /*  Disciplinas */
    
   

    
}
