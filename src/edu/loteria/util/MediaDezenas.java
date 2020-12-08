package edu.loteria.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo Gonçalves da Silva
 */
public class MediaDezenas implements Comparable<MediaDezenas> {
    private int dezena;
    private int quantidadeDezena;

    public MediaDezenas() {
    }
    
    public MediaDezenas(int dezena, int quantidadeDezena) {
        this.dezena = dezena;
        this.quantidadeDezena += quantidadeDezena;
    }

    public int getDezena() {
        return dezena;
    }

    public void setDezena(int dezena) {
        this.dezena = dezena;
    }

    public int getQuantidadeDezena() {
        return quantidadeDezena;
    }

    public void setQuantidadeDezena(int quantidadeDezena) {
        this.quantidadeDezena += quantidadeDezena;
    }
    
    @Override
    public String toString() {
        return "MediaDezenas{" + "Dezena=" + dezena + ", QuantidadeDezena=" + quantidadeDezena + '}' + "\n" ;
    }

    @Override
    public int compareTo(MediaDezenas o) {
         if (this.quantidadeDezena > o.getQuantidadeDezena()) {
            return -1;
        }
        if (this.quantidadeDezena < o.getQuantidadeDezena()) {
            return 1;
        }
            return 0;
    }
}
