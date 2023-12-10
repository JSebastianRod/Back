package edu.eci.arsw.checkers.dto;

public class MovimientoDTO {
    private String jugador;
    private int filaOrigen;
    private int columnaOrigen;
    private int filaDestino;
    private int columnaDestino;

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public int getFilaOrigen() {
        return filaOrigen;
    }

    public void setFilaOrigen(int filaOrigen) {
        this.filaOrigen = filaOrigen;
    }

    public int getColumnaOrigen() {
        return columnaOrigen;
    }

    public void setColumnaOrigen(int columnaOrigen) {
        this.columnaOrigen = columnaOrigen;
    }

    public int getFilaDestino() {
        return filaDestino;
    }

    public void setFilaDestino(int filaDestino) {
        this.filaDestino = filaDestino;
    }

    public int getColumnaDestino() {
        return columnaDestino;
    }

    public void setColumnaDestino(int columnaDestino) {
        this.columnaDestino = columnaDestino;
    }
}