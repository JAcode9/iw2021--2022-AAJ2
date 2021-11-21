package com.example.application.classes;

import java.util.ArrayList;

public class Sala {
    private final int num_sala;
    private final int num_asientos;
    private final int num_filas;
    private ArrayList<Proyeccion> proyecciones;

    public Sala(int num_sala, int num_asientos, int num_filas) {
        this.num_sala = num_sala;
        this.num_asientos = num_asientos;
        this.num_filas = num_filas;
        this.proyecciones = new ArrayList<>();
    }

    public int getNum_sala() {
        return num_sala;
    }

    public int getNum_asientos() {
        return num_asientos;
    }

    public int getNum_filas() {
        return num_filas;
    }
}