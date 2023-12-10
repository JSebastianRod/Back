package edu.eci.arsw.checkers.dto;

public class FichaDTO {
    private int vidas;
    private int fila;
    private int columna;
    private String nombreJugador;

    public FichaDTO() {
    }

    public FichaDTO(int vidas, int fila, int columna, String nombreJugador) {
        this.vidas = vidas;
        this.fila = fila;
        this.columna = columna;
        this.nombreJugador = nombreJugador;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }
}