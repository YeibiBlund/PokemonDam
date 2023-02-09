/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pokemondam.dominio;

/**
 *
 * @author Yeibi
 */
public class Ataques {
    
     private String nombre;
     private int daño;

//CONSTRUCTORES
    
public Ataques(String nombre, int daño) {
    this.nombre = nombre;
    this.daño = daño;
}

    public Ataques(int daño) {
        this.daño = daño;
    }

//GETTER Y SETTER
    public String getNombre(){
    return nombre;
    }     
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDaño(){
    return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n\t");
        sb.append("=\n\t").append(nombre);
        sb.append(", PUNTOS ATAQUE:").append(daño);
        sb.append('}');
        return sb.toString();
    }


}

