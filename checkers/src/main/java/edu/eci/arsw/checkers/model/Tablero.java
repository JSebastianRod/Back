package edu.eci.arsw.checkers.model;

public class Tablero {
    private Casilla[][] casillas;
    private int filas;
    private int columnas;
    private Jugador jugador1;
    private Jugador jugador2;

    public Tablero(int filas, int columnas, String nameJugador1, String nameJugador2, String tokenPartida) {
        this.filas = filas;
        this.columnas = columnas;
        jugador1 = new Jugador(nameJugador1, "abajo");
        jugador2 = new Jugador(nameJugador2, "arriba");
        casillas = new Casilla[filas][columnas];
    }
    public void inicializarTablero(){
        for (int fila = 0; fila < getFilas(); fila++) {
            for (int columna = 0; columna < getColumnas(); columna++) {
                Casilla casilla = new  Casilla(fila, columna, null);
                setCasilla(casilla, fila, columna);
                
                if (!casilla.esCasillaNegra()) {
                    continue;
                }

                if (fila < 3) {
                    Ficha ficha = new Ficha(fila, columna, 1,jugador1.getNombre());
                    getCasilla(fila, columna).setFicha(ficha);
                    jugador1.agregarFicha(ficha);
                }

                if (fila >= getFilas() - 3) {
                    Ficha ficha = new Ficha(fila, columna, 1, jugador2.getNombre());
                    getCasilla(fila, columna).setFicha(ficha);
                    jugador2.agregarFicha(ficha);
                }
            }
        }
    }

    public Jugador getJugador1(){
        return jugador1;
    }

    public Jugador getJugador2(){
        return jugador2;
    }


    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public Casilla getCasilla(int fila, int columna) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            return casillas[fila][columna];
        } else {
            return null;
        }
    }

    public void setCasilla(Casilla casilla, int fila, int columna) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            casillas[fila][columna] = casilla;
        }
    }

    public Casilla getCasilla(Ficha ficha) {
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                Casilla casilla = casillas[fila][columna];
                if (casilla.getFicha() == ficha) {
                    return casilla;
                }
            }
        }
        return null;
    }

}