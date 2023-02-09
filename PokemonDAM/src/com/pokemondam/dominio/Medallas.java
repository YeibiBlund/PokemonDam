/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pokemondam.dominio;

/**
 *
 * @author PC
 */
class Medallas {
    private int idMedallas;
    private String nombre;
    
    private static int contador = 0;
    
    public Medallas(){
        this.idMedallas = contador++;
    }
    public Medallas(String nombre){
        this.idMedallas = contador++;
        this.nombre = nombre;
    }

    public Medallas(int idMedallas, String nombre) {
        this();
        this.idMedallas = idMedallas;
    }

     //GETTER Y SETTER
    public int getIdMedallas() {
        return idMedallas;
    }

    public void setIdMedallas(int idMedallas) {
        this.idMedallas = idMedallas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MEDALLAS{");
        sb.append("\n\tIDMEDALLAS=").append(idMedallas);
        sb.append("\n\tNOMBRES=").append(nombre);
        return sb.toString();
    }
    
    
}
