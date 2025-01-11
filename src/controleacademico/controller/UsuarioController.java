package controleacademico.controller;

import Exceptions.CredenciaisInvalidasException;
import controleacademico.model.Administrador;
import controleacademico.model.Aluno;
import controleacademico.model.Professor;
import controleacademico.model.User;
import java.util.ArrayList;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Double
 */
public class UsuarioController {

    private static ArrayList<User> users = new ArrayList<>();

    public static void carregarUsers() {
        users.add(new Administrador(0, "Administrador", "admin", "admin1234", "admin"));
        users.add(new Professor(2, "Carlo Silva", "Coordebado", new Date(), "professor", "professor123", "professor"));
        users.add(new Professor(4, "António Jacinto", "professor", new Date(), "professor", "professor", "professor"));
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
        if (usuario != null) {
            users.add(usuario);
            System.out.println(users.size());
            return true;
        } else {
            return false;
        }
    }

    private static void validarCamposLogin(String nomeUsuario, String senha) throws CredenciaisInvalidasException {
        if (nomeUsuario == null || nomeUsuario.trim().isEmpty()) {
            throw new CredenciaisInvalidasException("O campo 'Nome do Usuário' não pode estar vazio.");
        }
        if (senha == null || senha.trim().isEmpty()) {
            throw new CredenciaisInvalidasException("O campo 'Senha' não pode estar vazio.");
        }
    }

    public static User autenticar(String nomeUsuario, String senha) throws CredenciaisInvalidasException {
        validarCamposLogin(nomeUsuario, senha);
        return users.stream()
                .filter(u -> u.getUserName().equals(nomeUsuario) && u.getPassword().equals(senha))
                .findFirst()
                .orElseThrow(() -> new CredenciaisInvalidasException("Usuário ou senha inválidos."));
    }

    public static int newIdUser() {
        return users.size() + 1;
    }

    public static ArrayList<Professor> listarProfessores() {
        ArrayList<Professor> professores = new ArrayList<>();
        for (User usuario : users) {
            if (usuario instanceof Professor) {
                professores.add((Professor) usuario);
            }
        }
        return professores;
    }

    public static boolean RemoveUsuario(int id) {
        boolean result = users.removeIf(p -> p.getId() == id);
        if (result) {
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Professor> pesquisarProfessores(String termo) {
        ArrayList<Professor> resultados = new ArrayList<>();
        for (User usuario : users) {
            if (usuario instanceof Professor) {
                Professor professor = (Professor) usuario;
                if (professor.getNome().toLowerCase().contains(termo.toLowerCase())
                        || professor.getCargo().toLowerCase().contains(termo.toLowerCase())
                        || professor.getUserName().toLowerCase().contains(termo.toLowerCase())
                        || (professor.getDataNascimento() != null && professor.getDataNascimento().toString().contains(termo))) {
                    resultados.add(professor);
                }
            }
        }
        return resultados;
    }

    public static Professor pesquisarProfessorByNameAndId(String nome, int id) {
        User userP = users.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
        if (userP instanceof Professor) {
            Professor resultProfessor = new Professor(userP.getId(), userP.getNome(), ((Professor) userP).getCargo(), ((Professor) userP).getDataNascimento(), userP.getUserName(), userP.getPassword(), userP.getRole());
            return resultProfessor;
        } else {
            return null;
        }
    }

}
