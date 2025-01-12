/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleacademico.controller;

import Exceptions.TurmaLotadaException;
import java.util.ArrayList;
import controleacademico.model.RendimentoEscolar;
import controleacademico.model.TurmaModel;
import controleacademico.model.Aluno;

/**
 *
 * @author Double
 */
public class RendimentoEscolarController {

    private static ArrayList<RendimentoEscolar> rendimentosEscolares = new ArrayList<>();

    public static boolean saveRendimentoEscolar(TurmaModel turma, RendimentoEscolar rendimento) throws TurmaLotadaException {
        if (rendimento != null) {
            verificarCapacidadeTurmas(turma, rendimentosEscolares);
            rendimentosEscolares.add(rendimento);
            return true;
        } else {
            return false;
        }

    }

    public static ArrayList<RendimentoEscolar> listaTodasRendimentos() {
        return rendimentosEscolares;
    }

    public static void verificarCapacidadeTurmas(TurmaModel turma, ArrayList<RendimentoEscolar> rendimentos) throws TurmaLotadaException {
        int contador = 0;
        for (RendimentoEscolar rendimento : rendimentos) {
            if (rendimento.getTurma().getId() == turma.getId()) {
                System.out.println("Turma  id: " + rendimento.getTurma().getId());
                System.out.println("Capacidade  : " + turma.getCapacidade());
                System.out.println("Contador by : " + contador);
                contador++;
            }

            if (contador >= turma.getCapacidade()) {
                throw new TurmaLotadaException("Turma lotada.");
            }
        }
    }

    public static ArrayList<TurmaModel> obterTurmasNaoMatriculadas(Aluno aluno) {
        ArrayList<TurmaModel> turmasNaoMatriculadas = new ArrayList<>();
        ArrayList<TurmaModel> turmas = TurmaController.listaTodasTurma();
        
        for (TurmaModel turma : turmas) {
            boolean estaMatriculado = false;

            // Verifica se o aluno está matriculado na turma
            for (RendimentoEscolar rendimento : rendimentosEscolares) {
                if (rendimento.getTurma().getId() == turma.getId() && rendimento.getAluno().getId() == aluno.getId()) {
                    estaMatriculado = true;
                    break;
                }
            }

            // Se o aluno não está matriculado, adiciona à lista de não matriculadas
            if (!estaMatriculado) {
                turmasNaoMatriculadas.add(turma);
            }
        }

        return turmasNaoMatriculadas;
    }
}
