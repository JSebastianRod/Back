package edu.eci.arsw.checkers.dto;


public class JuegoDTO {
    private String jugadorActual;
    private TableroDTO tablero; 
    private boolean button;
    private String tokenPartida;

    public JuegoDTO(String jugadorActual, TableroDTO tablero, boolean button, String tokenPartida) {
        this.jugadorActual = jugadorActual;
        this.tablero = tablero;
        this.button = button;
        this.tokenPartida = tokenPartida;
    }

    public String getJugadorActual() {
        return jugadorActual;
    }


    public void setJugadorActual(String jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    public TableroDTO getTablero() {
        return tablero;
    }

    public void setTablero(TableroDTO tablero) {
        this.tablero = tablero;
    }

    public boolean getButton() {
        return button;
    }

    public void setButton(boolean button) {
        this.button = button;
    }

    public String getTokenPartida() {
        return tokenPartida;
    }

    public void setTokenPartida(String tokenPartida) {
        this.tokenPartida = tokenPartida;
    }


}