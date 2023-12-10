package edu.eci.arsw.checkers.service;

import edu.eci.arsw.checkers.dto.JuegoDTO;
import edu.eci.arsw.checkers.dto.TableroDTO;
import edu.eci.arsw.checkers.dto.CasillaDTO;
import edu.eci.arsw.checkers.dto.FichaDTO;
import edu.eci.arsw.checkers.model.Casilla;
import edu.eci.arsw.checkers.model.Ficha;
import edu.eci.arsw.checkers.model.Juego;
import edu.eci.arsw.checkers.model.Tablero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class JuegoService {
    private Juego juego;
    private Map<String, List<String>> partidasTokens = new HashMap<>();
    private int contadorMovimientos = 1;

    public JuegoService() {
        String tokenPartida = generarTokenUnico();  // Genera un token único
        partidasTokens.put(tokenPartida, new ArrayList<>()); 
    }

    public String generarTokenUnico() {
        String token = UUID.randomUUID().toString();
        System.out.println("\n\n"+token+"\n\n");
        return token;
    }

    public JuegoService(Juego juego) {
        this.juego = juego;
    }

    public JuegoDTO obtenerEstadoJuego() {
        String jugadorActual = juego.getJugadorActual().getNombre();
        TableroDTO tableroDTO = crearTableroDTO(juego.getTablero());
        contadorMovimientos++;
        if (contadorMovimientos % 5 == 0) {
            return new JuegoDTO(jugadorActual, tableroDTO,true, partidasTokens.keySet().iterator().next());
        }
        return new JuegoDTO(jugadorActual, tableroDTO,false, partidasTokens.keySet().iterator().next());
    }
    public int getCantidadJugadores(String tokenPartida){
        List<String> jugadores = partidasTokens.get(tokenPartida);
        if (jugadores != null) {
            return jugadores.size();
        } else {
            System.out.println("el token es " + tokenPartida);
            return 0;
        }
    }
    
    private TableroDTO crearTableroDTO(Tablero tablero) {
        int filas = tablero.getFilas();
        int columnas = tablero.getColumnas();
        List<CasillaDTO> casillasDTO = new ArrayList<>();
    
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                Casilla casilla = tablero.getCasilla(fila, columna);
                CasillaDTO casillaDTO = crearCasillaDTO(casilla);
                casillasDTO.add(casillaDTO);
            }
        }
    
        return new TableroDTO(filas, columnas, casillasDTO);
    }
    
    private CasillaDTO crearCasillaDTO(Casilla casilla) {
        int fila = casilla.getFila();
        int columna = casilla.getColumna();
        boolean vacia = casilla.estaVacia();
        FichaDTO fichaDTO = null;
    
        if (!vacia) {
            Ficha ficha = casilla.getFicha();
            fichaDTO = crearFichaDTO(ficha);
        }
    
        return new CasillaDTO(fila, columna, vacia, fichaDTO);
    }
    
    public void registrarUsuario(String nombreUsuario, String tokenPartida) {
        if(partidasTokens.get(tokenPartida) == null){
            partidasTokens.put(tokenPartida, new ArrayList<>());
        }
        List<String> jugadores = partidasTokens.get(tokenPartida);
        
 
        if (jugadores != null && jugadores.size() < 2) {
            jugadores.add(nombreUsuario);
            if (jugadores.size() == 2){
                juego = new Juego(jugadores.get(0), jugadores.get(1), tokenPartida);
            }
        } else {
            throw new RuntimeException("El token de la partida no es válido o la partida está llena.");
        }
    }


    private FichaDTO crearFichaDTO(Ficha ficha) {
        int vidas = ficha.getVidas();
        int fila = ficha.getFila();
        int columna = ficha.getColumna();
        String nombreJugador = ficha.getNombreJugador();
    
        return new FichaDTO(vidas, fila, columna, nombreJugador);
    }

    

    public void moverFicha(String jugador, int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino) {
        juego.moverFicha(jugador, filaOrigen, columnaOrigen, filaDestino, columnaDestino);
    }

    public void pulsarBoton(String jugador) {
            juego.cambiarTurno();
        System.out.println("Nuevo turno para " + jugador );
    }

    public Juego getJuego() {
        return juego;
    }

    public void setToken(String token){
        juego.setTokenPartida(token);
    }


}