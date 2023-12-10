package edu.eci.arsw.checkers.model;

public class Ficha {
    private int vidas;
    private int fila;
    private int columna;
    private String nombreJugador;

    public Ficha(int fila, int columna, int vidas, String nombreJugador) {
        this.vidas = vidas;
        this.fila = fila;
        this.columna = columna;
        this.nombreJugador = nombreJugador;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getVidas() {
        return vidas;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void reducirVidas(int cantidad) {
        vidas -= cantidad;
    }


}