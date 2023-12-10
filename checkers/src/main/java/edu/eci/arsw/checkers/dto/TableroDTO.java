package edu.eci.arsw.checkers.dto;

import java.util.List;

public class TableroDTO {
    private int filas;
    private int columnas;
    private List<CasillaDTO> casillas;

    public TableroDTO(int filas, int columnas, List<CasillaDTO> casillas) {
        this.filas = filas;
        this.columnas = columnas;
        this.casillas = casillas;
    }
    

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public List<CasillaDTO> getCasillas() {
        return casillas;
    }
}