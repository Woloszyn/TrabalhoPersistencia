/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopersistencia;

/**
 *
 * @author 10489658997
 */
public class Carro {
    protected static String chassi;
    protected static String nome;
    protected static double valor;
    protected static int quantidade;
    protected static String cor;
    protected static long esquerda;
    protected static long direita;

    public Carro() {
    }

    public static String getChassi() {
        return chassi;
    }

    public static void setChassi(String chassi) {
        Carro.chassi = chassi;
    }

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        Carro.nome = nome;
    }

    public static double getValor() {
        return valor;
    }

    public static void setValor(double valor) {
        Carro.valor = valor;
    }

    public static int getQuantidade() {
        return quantidade;
    }

    public static void setQuantidade(int quantidade) {
        Carro.quantidade = quantidade;
    }

    public static String getCor() {
        return cor;
    }

    public static void setCor(String cor) {
        Carro.cor = cor;
    }

    public static long getEsquerda() {
        return esquerda;
    }

    public static void setEsquerda(long esquerda) {
        Carro.esquerda = esquerda;
    }

    public static long getDireita() {
        return direita;
    }

    public static void setDireita(long direita) {
        Carro.direita = direita;
    }
    
    
}
