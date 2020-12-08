package edu.loteria.megasena;

import java.util.Date;

/**
 *
 * @author Eduardo Gonçalves da Silva
 */
public class LotoFacil extends MegaSena{

    public LotoFacil() {
    }

    public LotoFacil(int concurso, Date dataSorteio, int arrecadaTotal, boolean acumulado, double valorAcumulado, double estimativa, double acumuladoEspecial) {
        super(concurso, dataSorteio, arrecadaTotal, acumulado, valorAcumulado, estimativa, acumuladoEspecial);
    }
    
    
}
