package edu.eci.arsw.checkers.service;


public class PlayerPowerThread extends Thread {

    private String jugadorPoder;
    private Object lock;
    private JuegoService juego;
    

    public PlayerPowerThread(Object lock) {
        this.jugadorPoder = null;
        this.lock = lock;
        this.juego = null;
    }

    public void run(String jugadorPoder, JuegoService juego) {
        synchronized(lock){
            this.juego = juego;
            if (this.jugadorPoder == null) {
                this.jugadorPoder = jugadorPoder;
                System.out.println("Jugador con poder: " + jugadorPoder);
                System.out.println(juego.getJuego().getJugadorActual().getNombre()); 
            }
            if (!juego.getJuego().getJugadorActual().getNombre().equals(jugadorPoder)&&this.jugadorPoder!=null) {
                juego.pulsarBoton(jugadorPoder);
                System.out.println("Se uso el poder del jugador: " + jugadorPoder);
                this.jugadorPoder = null;
            }
        }
    }
}
