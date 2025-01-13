/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controleacademico;

import Exceptions.TurmaLotadaException;
import controleacademico.controller.DisciplinaController;
import controleacademico.controller.RendimentoEscolarController;
import controleacademico.controller.TurmaController;
import controleacademico.model.Administrador;
import controleacademico.model.Aluno;
import controleacademico.model.Disciplina;
import controleacademico.model.Professor;
import controleacademico.model.User;
import controleacademico.model.TurmaModel;
import controleacademico.controller.UsuarioController;
import controleacademico.model.RendimentoEscolar;
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
        //Adicionar Disciplinas
        Disciplina matematica = new Disciplina(1, "Matématica", "Algebrá e Logaritmo");
        Disciplina cienciaComputao = new Disciplina(2, "Ciência da Computação", "Programação Java");
        Disciplina historia = new Disciplina(3, "História", "Sobre a história de Angola");

        DisciplinaController.saveDisciplina(matematica);
        DisciplinaController.saveDisciplina(cienciaComputao);
        DisciplinaController.saveDisciplina(historia);

        //Administrador
        Administrador adm = new Administrador(1, "Administrador", "admin", "admin", "admin");

        //Professor
        Professor professor1 = new Professor(2, "Carlo Silva", "Estagiário", new Date(), "professor", "professor", "professor");
        Professor professor2 = new Professor(3, "Manuel Bernado", "Coordebado", new Date(), "professor1", "professor1", "professor");

        //Aluno
        Aluno aluno = new Aluno(4, "Isidora", "isidora", "isidora", "Aluno");
        Aluno aluno2 = new Aluno(5, "aluno", "aluno", "aluno", "Aluno");

        UsuarioController.adicionarUsuario(adm);
        UsuarioController.adicionarUsuario(professor1);
        UsuarioController.adicionarUsuario(professor2);
        UsuarioController.adicionarUsuario(aluno);
        UsuarioController.adicionarUsuario(aluno2);

        TurmaModel turma1 = new TurmaModel(1, matematica, professor1, 5);
        TurmaModel turma2 = new TurmaModel(2, cienciaComputao, professor2, 5);
        TurmaModel turma3 = new TurmaModel(3, historia, professor1, 5);
        TurmaModel turma4 = new TurmaModel(4, matematica, professor2, 5);
        TurmaModel turma5 = new TurmaModel(5, cienciaComputao, professor2, 5);
        TurmaModel turma6 = new TurmaModel(6, historia, professor1, 5);
        TurmaModel turma7 = new TurmaModel(7, historia, professor2, 5);

        TurmaController.adicionarTurma(turma1);
        TurmaController.adicionarTurma(turma2);
        TurmaController.adicionarTurma(turma3);
        TurmaController.adicionarTurma(turma4);
        TurmaController.adicionarTurma(turma5);
        TurmaController.adicionarTurma(turma6);
        TurmaController.adicionarTurma(turma7);

        //Os rendimentos estão vinculados ao aluno
        int[] trabalhos = {1, 2, 3, 4};
        float[] notasTrabalhos = {10.0f, 7.0f, 3.0f, 10f};

        int[] trabalhos2 = {1, 2, 3, 4};
        float[] notasTrabalhos2 = {3.0f, 2.0f, 3.0f, 10f};

        RendimentoEscolar rendimento = new RendimentoEscolar(turma1, aluno, 10, 5, trabalhos, notasTrabalhos);
        RendimentoEscolar rendimento1 = new RendimentoEscolar(turma2, aluno2, 5, 5, trabalhos2, notasTrabalhos2);

        try {
            RendimentoEscolarController.saveRendimentoEscolar(turma1, rendimento);
            RendimentoEscolarController.saveRendimentoEscolar(turma2, rendimento1);

        } catch (TurmaLotadaException ex) {
            System.out.println("Aluno não criou rendimento escolar");
        }
    }

}
