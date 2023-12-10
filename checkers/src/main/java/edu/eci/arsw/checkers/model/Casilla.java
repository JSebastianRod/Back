package edu.eci.arsw.checkers.model;

public class Casilla {
    private int fila;
    private int columna;
    private Ficha ficha;


    public Casilla(int fila, int columna, Ficha ficha) {
        this.fila = fila;
        this.columna = columna;
        this.ficha = ficha;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }
    
    public boolean estaVacia() {
        return ficha == null;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean esCasillaBlanca() {
        return (fila + columna) % 2 == 0;
    }

    public boolean esCasillaNegra() {
        return !esCasillaBlanca();
    }
}