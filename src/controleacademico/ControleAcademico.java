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
import controleacademico.view.LoginForm;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Double
 */
public class ControleAcademico {

    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Disciplina> disciplina = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //new LoginForm().setVisible(true);
        carregarUsers();

        new LoginForm().setVisible(true);
    }

    private static void carregarUsers() {
        users.add(new Administrador(0, "Administrador", "admin", "admin1234", "admin"));
        users.add(new Professor(2, "Carlo Silva", "Coordebado", new Date(), "professor", "professor123", "professor"));
        users.add(new Aluno(3, "jacinto", "jacinto.aluno", "aluno123", "Aluno"));
    }

    public static User searchUser(String nomeUsuario, String senha) {
        return users.stream()
                .filter(p -> p.getUserName().equals(nomeUsuario) && p.getPassword().equals(senha))
                .findFirst()
                .orElse(null);
    }
    
    public static User searchUserName(String nomeUsuario) {
        return users.stream()
                .filter(p -> p.getUserName().equals(nomeUsuario))
                .findFirst()
                .orElse(null);
    }
    

  
    public static boolean adicionarUsuario(User usuario) {
        if(usuario != null) {
            users.add(usuario);
            System.out.println(users.size());
            return true;
        } else {
            return false;
        }
    }
  
      /*  Disciplinas */
    
   

    
}
