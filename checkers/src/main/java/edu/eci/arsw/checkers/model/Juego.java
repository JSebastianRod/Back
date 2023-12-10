package edu.eci.arsw.checkers.model;

import java.util.List;

public class Juego {
    private Tablero tablero;
    private Jugador jugadorActual;
    private String tokenPartida;

    public Juego() {
    }

    public Juego(String nameJugador1, String nameJugador2, String tokenPartida) {
        tablero = new Tablero(8, 8, nameJugador1, nameJugador2, tokenPartida);
        jugadorActual = tablero.getJugador1();
        tablero.inicializarTablero();
    }

    public void setTokenPartida(String tokenPartida){
        this.tokenPartida = tokenPartida;
    }

    public void moverFicha(String jugador, int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino) {
        
        if (!jugador.equalsIgnoreCase(jugadorActual.getNombre())) {
            System.out.println("es turno de: " + jugadorActual.getNombre()+" usted es "+ jugador);
            return;
        }
    
        Casilla casillaOrigen = tablero.getCasilla(filaOrigen, columnaOrigen);
        Casilla casillaDestino = tablero.getCasilla(filaDestino, columnaDestino);
    
        if (casillaOrigen == null || casillaDestino == null) {
            return;
        }
    
        Ficha ficha = casillaOrigen.getFicha();
    
        int difFilas = Math.abs(filaDestino - filaOrigen);
        int difColumnas = Math.abs(columnaDestino - columnaOrigen);
    
        if (difFilas == 1 && difColumnas == 1) {
            if (casillaDestino.estaVacia()) {
                tablero.getCasilla(filaOrigen, columnaOrigen).setFicha(null);
                tablero.getCasilla(filaDestino, columnaDestino).setFicha(ficha);
                ficha.setFila(filaDestino);
                ficha.setColumna(columnaDestino);
    
                cambiarTurno();
            }
        } else if (difFilas == 2 && difColumnas == 2) {
            int filaIntermedia = (filaOrigen + filaDestino) / 2;
            int columnaIntermedia = (columnaOrigen + columnaDestino) / 2;
    
            Casilla casillaIntermedia = tablero.getCasilla(filaIntermedia, columnaIntermedia);
    
            if (!casillaIntermedia.estaVacia() && casillaIntermedia.getFicha().getNombreJugador().equals(getJugadorEspera().getNombre())) {
                tablero.getCasilla(filaOrigen, columnaOrigen).setFicha(null);
                tablero.getCasilla(filaDestino, columnaDestino).setFicha(ficha);
                ficha.setFila(filaDestino);
                ficha.setColumna(columnaDestino);
    
                Ficha fichaCapturada = casillaIntermedia.getFicha();
                fichaCapturada.reducirVidas(1);
    
                if (fichaCapturada.getVidas() <= 0) {
                    casillaIntermedia.setFicha(null);
                }
    
                cambiarTurno();
            }
        }
    }

    public void cambiarTurno() {
        if (jugadorActual == tablero.getJugador1()) {
            jugadorActual = tablero.getJugador2();
        } else {
            jugadorActual = tablero.getJugador1();
        }
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }
    public Jugador getJugadorEspera(){
        if (jugadorActual == tablero.getJugador1()) {
            return tablero.getJugador2();
        } else {
            return tablero.getJugador1();
        }
         
    }

    public List<Ficha> getFichas(Jugador jugador) {
        return jugador.getFichas();
    }


}
