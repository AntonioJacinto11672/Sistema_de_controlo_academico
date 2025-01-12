/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controleacademico;

import controleacademico.controller.DisciplinaController;
import controleacademico.controller.TurmaController;
import controleacademico.model.Administrador;
import controleacademico.model.Aluno;
import controleacademico.model.Disciplina;
import controleacademico.model.Professor;
import controleacademico.model.User;
import controleacademico.model.TurmaModel;
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

        carregarDadosIniciais();
        new LoginForm().setVisible(true);
    }

    private static void carregarDadosIniciais() {
        Disciplina matematica = new Disciplina(1, "Matématica", "Algebrá e Logaritmo");
        Disciplina cienciaComputao = new Disciplina(2, "Ciência da Computação", "Programação Java");
        DisciplinaController.saveDisciplina(matematica);
        DisciplinaController.saveDisciplina(cienciaComputao);

        Professor professor1 = new Professor(1, "Carlo Silva", "Coordebado", new Date(), "professor", "professor123", "professor");
        Professor professor2 = new Professor(2, "Manuel Bernado", "Coordebado", new Date(), "professor", "professor123", "professor");

        Administrador adm = new Administrador(0, "Administrador", "admin", "admin1234", "admin");
        Aluno aluno = new Aluno(3, "jacinto", "jacinto.aluno", "aluno123", "Aluno");
        UsuarioController.adicionarUsuario(adm);
        UsuarioController.adicionarUsuario(professor1);
        UsuarioController.adicionarUsuario(professor2);
        UsuarioController.adicionarUsuario(aluno);
        /*
        TurmaModel turma1 = new TurmaModel(1, matematica, professor2, 20);
        TurmaModel turma2 = new TurmaModel(2, cienciaComputao, professor1, 20);
        TurmaController.adicionarTurma(turma1);
        TurmaController.adicionarTurma(turma2); */

    }

}
