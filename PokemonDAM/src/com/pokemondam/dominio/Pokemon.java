/*
 * Datos del pokemon
 */
package com.pokemondam.dominio;

import java.util.ArrayList;

/**
 *
 * @author brune
 */
public class Pokemon {
    
    // Conjunto de propiedades
    protected int idPokemon;
    protected String nombre;
    protected int puntosAtaque;
    protected int puntosDefensa;
    protected int nivel;
    protected int vida;
    protected ArrayList<Ataques> listaAtaques;
    
    private static int contador = 0;
    
    // Constructores
    public Pokemon(){
        this.idPokemon = contador++;
        this.listaAtaques = new ArrayList<>();
    }

    public Pokemon(int idPokemon) {
        this();
        this.idPokemon = idPokemon;
    }

    public Pokemon(String nombre, int puntosAtaque, int puntosDefensa, int nivel) {
        this();
        this.nombre = nombre;
        this.puntosAtaque = puntosAtaque;
        this.puntosDefensa = puntosDefensa;
        this.nivel = nivel;
    }
    public Pokemon(String nombre, int puntosAtaque, int puntosDefensa, int nivel, int vida) {
        this();
        this.nombre = nombre;
        this.puntosAtaque = puntosAtaque;
        this.puntosDefensa = puntosDefensa;
        this.nivel = nivel;
        this.vida= vida;
    }

    public Pokemon(int idPokemon, String nombre, int puntosAtaque, int puntosDefensa, int nivel) {
        this();
        this.idPokemon = idPokemon;
        this.nombre = nombre;
        this.puntosAtaque = puntosAtaque;
        this.puntosDefensa = puntosDefensa;
        this.nivel = nivel;
    }
    
    //METODOS
    public void addAtaque(Ataques ataque){
        
       this.listaAtaques.add(ataque);
       
    }
    
    public ArrayList<Ataques> getListaAtaques(){
        
        return this.listaAtaques;
        
    } 



    
    // Getter y Setter

    public int getIdPokemon() {
        return idPokemon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }

    public int getPuntosDefensa() {
        return puntosDefensa;
    }

    public void setPuntosDefensa(int puntosDefensa) {
        this.puntosDefensa = puntosDefensa;
    }
    
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    // Metodos
    public void AtaqueRapido(){
        
    }
    
    public void Esquivar(){
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pokemon{");
        sb.append("idPokemon= ").append(idPokemon);
        sb.append(", nombre= ").append(nombre);
        sb.append(", puntosAtaque= ").append(puntosAtaque);
        sb.append(", puntosDefensa= ").append(puntosDefensa);
        sb.append(", nivel= ").append(nivel);
        sb.append(", nivel= ").append(vida);
        sb.append('}');
        return sb.toString();
    }
}





















        