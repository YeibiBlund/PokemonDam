/*
 * 
 */
package com.pokemondam.dominio;

/**
 *
 * @author brune
 */
public class Fuego extends Pokemon {
    
    // Conjunto de propiedades
    private int ptsAtaqueFuego;
    
    // Constructores
    public Fuego(){
        super();
    }
    
    public Fuego(int idPokemon){
        super(idPokemon);
    }
    
    public Fuego(String nombre, int puntosAtaque, int puntosDefensa, int nivel, int ptsAtaqueFuego){
        super(nombre, puntosAtaque, puntosDefensa, nivel);
        this.ptsAtaqueFuego = ptsAtaqueFuego;
    }
    
    public Fuego(String nombre, int puntosAtaque, int puntosDefensa, int nivel, int ptsAtaqueFuego, int vida){
        super(nombre, puntosAtaque, puntosDefensa, nivel, vida);
        this.ptsAtaqueFuego = ptsAtaqueFuego;
    }
    
    // Metodos
    public void Ascuas(){
        
    }
    
    public void LanzaLLamas(){
        
    }
    
    // Getter y Setter

    public int getPtsAtaqueFuego() {
        return ptsAtaqueFuego;
    }

    public void setPtsAtaqueFuego(int ptsAtaqueFuego) {
        this.ptsAtaqueFuego = ptsAtaqueFuego;
    }

    // To string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append("\n\t");
        sb.append("  ____________________________________\n\t");
        sb.append(" |- TIPO FUEGO                        |\n\t");
        if(nivel < 9){
            sb.append(" |- NIVEL: ").append(nivel).append("                         |\n\t");
        }else
            sb.append(" |- NIVEL: ").append(nivel).append("                         |\n\t");
        sb.append(" |- PUNTOS ATAQUE: ").append(puntosAtaque).append("                 |\n\t");
        sb.append(" |- PUNTOS DEFENSA: ").append(puntosDefensa).append("                |\n\t");
        sb.append(" |- PUTOS ATAQUE ESPECIAL: ").append(ptsAtaqueFuego).append("         |\n\t");
        sb.append(" |- PUNTOS VIDA: ").append(vida).append("                  |\n\t");
        if(idPokemon > 9){
            sb.append(" |- ID POKEMON: ").append(idPokemon).append("                    |\n\t");
        }else
            sb.append(" |- ID POKEMON: ").append(idPokemon).append("                     |\n\t");
        sb.append(" |____________________________________|\n");
        return sb.toString();
    
    }
}
