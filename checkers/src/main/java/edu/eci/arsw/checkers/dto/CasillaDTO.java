package edu.eci.arsw.checkers.dto;

public class CasillaDTO {
    private int fila;
    private int columna;
    private boolean vacia;
    private FichaDTO ficha;

    public CasillaDTO(int fila, int columna, boolean vacia, FichaDTO ficha) {
        this.fila = fila;
        this.columna = columna;
        this.vacia = vacia;
        this.ficha = ficha;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean isVacia() {
        return vacia;
    }

    public FichaDTO getFicha() {
        return ficha;
    }
}