/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.loteria.util;

/**
 *
 * @author Eduardo Gonçalves
 */
public class Ganhadores {
    private int nGanhadores;
    private String cidade;
    private String estado;
    private double rateio;
    private int nAcertos;

    public Ganhadores() {
    }
    
    public Ganhadores(int nGanhadores, String cidade, String estado, double rateio, int nAcertos) {
        this.nGanhadores = nGanhadores;
        this.cidade = cidade;
        this.estado = estado;
        this.rateio = rateio;//Repartição para os ganhadores
        this.nAcertos = nAcertos;
    }

    public int getnGanhadores() {
        return nGanhadores;
    }

    public void setnGanhadores(int nGanhadores) {
        this.nGanhadores = nGanhadores;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getRateio() {
        return rateio;
    }

    public void setRateio(double rateio) {
        this.rateio = rateio;
    }

    public int getnAcertos() {
        return nAcertos;
    }

    public void setnAcertos(int nAcertos) {
        this.nAcertos = nAcertos;
    }

    @Override
    public String toString() {
        return "Ganhadores{" + "NGanhadores=" + nGanhadores + ", Cidade=" + cidade + ", Estado=" + estado + ", Rateio=" + rateio + ", NAcertos=" + nAcertos + '}';
    }
}
