/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleacademico.model;

/**
 *
 * @author Double
 */
public class RendimentoEscolar {

    private Turma turma;
    private Aluno aluno;
    private float notaProva1;
    private float notaProva2;
    private int[] trabalhos;
    private float[] notasTrabalhos;

    public RendimentoEscolar(Turma turma, Aluno aluno, float notaProva1, float notaProva2, int[] trabalhos, float[] notasTrabalhos) {
        this.turma = turma;
        this.aluno = aluno;
        this.notaProva1 = notaProva1;
        this.notaProva2 = notaProva2;
        this.trabalhos = trabalhos;
        this.notasTrabalhos = notasTrabalhos;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public float getNotaProva1() {
        return notaProva1;
    }

    public void setNotaProva1(float notaProva1) {
        this.notaProva1 = notaProva1;
    }

    public float getNotaProva2() {
        return notaProva2;
    }

    public void setNotaProva2(float notaProva2) {
        this.notaProva2 = notaProva2;
    }

    public int[] getTrabalhos() {
        return trabalhos;
    }

    public void setTrabalhos(int[] trabalhos) {
        this.trabalhos = trabalhos;
    }

    public float[] getNotasTrabalhos() {
        return notasTrabalhos;
    }

    public void setNotasTrabalhos(float[] notasTrabalhos) {
        this.notasTrabalhos = notasTrabalhos;
    }

}
