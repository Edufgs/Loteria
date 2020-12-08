package edu.loteria.megasena;

import edu.loteria.util.Ganhadores;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Eduardo Gonçalves da Silva
 */
public class MegaSena {
    private int concurso;
    private Date dataSorteio;
    private List dezenas = new ArrayList<>();
    private int arrecadaTotal;
    private List<Ganhadores> ganhadores = new ArrayList<>();
    private boolean acumulado;
    private double valorAcumulado;
    private double estimativa; //Estimativa para o proximo sorteio
    private double acumuladoEspecial; //Valor acumulado para mega da virada(6 meses antes começa a acumular 5% dos sorteios

    public MegaSena() {
        for(int i = 0; i<4; i++){
            Ganhadores aux = new Ganhadores();
            this.ganhadores.add(aux);
        }
    }

    public MegaSena(int concurso, Date dataSorteio, int arrecadaTotal, boolean acumulado, double valorAcumulado, double estimativa, double acumuladoEspecial) {
        
        this.concurso = concurso;
        this.dataSorteio = dataSorteio;
        this.arrecadaTotal = arrecadaTotal;
        this.acumulado = acumulado;
        this.valorAcumulado = valorAcumulado;
        this.estimativa = estimativa;
        this.acumuladoEspecial = acumuladoEspecial;
    }

    public int getConcurso() {
        return concurso;
    }

    public void setConcurso(int concurso) {
        this.concurso = concurso;
    }

    public Date getDataSorteio() {
        return dataSorteio;
    }

    public void setDataSorteio(Date dataSorteio) {
        this.dataSorteio = dataSorteio;
    }

    public List getDezenas() {
        return dezenas;
    }

    public void setDezenas(int objeto) {
        this.dezenas.add(objeto);
    }

    public int getArrecadaTotal() {
        return arrecadaTotal;
    }

    public void setArrecadaTotal(int arrecadaTotal) {
        this.arrecadaTotal = arrecadaTotal;
    }

    public List getGanhadores() {
        return ganhadores;
    }
    
    public void setganhadoresNGanhadores(int p, int n){
        Ganhadores aux = this.ganhadores.get(p);
        aux.setnGanhadores(n);
    }
    
    public void setGanhadoresCidade(int p, String n){
        Ganhadores aux = this.ganhadores.get(p);
        aux.setCidade(n);
    }
    
    public void setGanhadoresEstado(int p, String n){
       Ganhadores aux = this.ganhadores.get(p);
        aux.setEstado(n);
    }
    
    public void setGanhadoresRateio(int p, double n){
       Ganhadores aux = this.ganhadores.get(p);
        aux.setRateio(n);
    }
    
    public void setGanhadoresNAcertos(int p, int n){
        Ganhadores aux = this.ganhadores.get(p);
        aux.setnAcertos(n);
    }

    public boolean getAcumulado() {
        return acumulado;
    }

    public void setAcumulado(boolean acumulado) {
        this.acumulado = acumulado;
    }

    public double getValorAcumulado() {
        return valorAcumulado;
    }

    public void setValorAcumulado(double valorAcumulado) {
        this.valorAcumulado = valorAcumulado;
    }

    public double getEstimativa() {
        return estimativa;
    }

    public void setEstimativa(double estimativa) {
        this.estimativa = estimativa;
    }

    public double getAcumuladoMegaVirada() {
        return acumuladoEspecial;
    }

    public void setAcumuladoMegaVirada(double acumuladoMegaVirada) {
        this.acumuladoEspecial = acumuladoMegaVirada;
    }  

    @Override
    public String toString() {
        return "MegaSena{ " + "Concurso= " + concurso + ", DataSorteio= " + dataSorteio + ", Dezenas= " + dezenas + ", ArrecadaTotal= " + arrecadaTotal + ", Ganhadores= " + ganhadores + ", Acumulado= " + acumulado + ", ValorAcumulado= " + valorAcumulado + ", Estimativa= " + estimativa + ", AcumuladoMegaVirada=" + acumuladoEspecial + '}' + "\n";
    }
}
