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

    private TurmaModel turma;
    private Aluno aluno;
    private float notaProva1;
    private float notaProva2;
    private int[] trabalhos;
    private float[] notasTrabalhos;

    public RendimentoEscolar(TurmaModel turma, Aluno aluno, float notaProva1, float notaProva2, int[] trabalhos, float[] notasTrabalhos) {
        this.turma = turma;
        this.aluno = aluno;
        this.notaProva1 = notaProva1;
        this.notaProva2 = notaProva2;
        this.trabalhos = trabalhos;
        this.notasTrabalhos = notasTrabalhos;
    }

    public RendimentoEscolar() {
        this.trabalhos = new int[0];
        this.notasTrabalhos = new float[0];
    }

    public TurmaModel getTurma() {
        return turma;
    }

    public void setTurma(TurmaModel turma) {
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

    public void setTrabalhos(int trabalhos) {
        if (this.trabalhos.length == 0) {
            this.trabalhos = new int[4];
        }
        if (trabalhos >= 0 && trabalhos <= this.trabalhos.length) {
            System.out.println("Index no model: " + (trabalhos - 1));
            this.trabalhos[trabalhos - 1] = trabalhos;
        } else {
            System.out.println("Opição invalida");
        }
    }

    public float[] getNotasTrabalhos() {
        return notasTrabalhos;
    }

    public void setNotasTrabalhos(int index, float notasTrabalhos) {
        System.out.println("Ínicio " + (index - 1) + " tamanho " + this.notasTrabalhos.length);
        if (this.notasTrabalhos.length == 0) {
            this.notasTrabalhos = new float[4];
        }

        if (index >= 0 && index <= 4) {
            System.out.println("Entrou " + (index - 1));
            this.notasTrabalhos[index - 1] = notasTrabalhos;
        }

    }

   
}
