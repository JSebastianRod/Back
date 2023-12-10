package edu.eci.arsw.checkers.model;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private String posicion; //arriba o abajo
    private boolean turno;
    private List<Ficha> fichas;

    public Jugador(String nombre, String posicion) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.turno = false;
        fichas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public boolean tieneTurno() {
        return turno;
    }

    public void cambiarTurno() {
        turno = !turno;
    }

    public void agregarFicha(Ficha ficha) {
        fichas.add(ficha);
    }
    public List<Ficha> getFichas() {
        return fichas;
    }
}