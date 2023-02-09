/*
 * 
 */
package com.pokemondam.dominio;

/**
 *
 * @author brune
 */
public class Planta extends Pokemon {
    
    // Conjunto de propiedades
    private int ptsAtaquePlanta;
    
    // Constructores
    public Planta(){
        super();
    }
    
    public Planta(int idPokemon){
        super(idPokemon);
    }
    
    public Planta(String nombre, int puntosAtaque, int puntosDefensa, int nivel, int ptsAtaquePlanta){
        super(nombre, puntosAtaque, puntosDefensa, nivel);
        this.ptsAtaquePlanta = ptsAtaquePlanta;
    }
    
    public Planta(String nombre, int puntosAtaque, int puntosDefensa, int nivel, int ptsAtaquePlanta, int vida){
        super(nombre, puntosAtaque, puntosDefensa, nivel, vida);
        this.ptsAtaquePlanta = ptsAtaquePlanta;
    }
    
    // Metodos
    public void LatigoCepa(){        
    }
    
    public void RayoSolar(){
    }
    
    // Getter y Setter

    public int getPtsAtaquePlanta() {
        return ptsAtaquePlanta;
    }

    public void setPtsAtaquePlanta(int ptsAtaquePlanta) {
        this.ptsAtaquePlanta = ptsAtaquePlanta;
    }

    // To string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append("\n\t");
        sb.append("  ____________________________________\n\t");
        sb.append(" |- TIPO PLANTA                       |\n\t");
        if(nivel < 9){
            sb.append(" |- NIVEL: ").append(nivel).append("                         |\n\t");
        }else
            sb.append(" |- NIVEL: ").append(nivel).append("                         |\n\t");
        sb.append(" |- PUNTOS ATAQUE: ").append(puntosAtaque).append("                 |\n\t");
        sb.append(" |- PUNTOS DEFENSA: ").append(puntosDefensa).append("                |\n\t");
        sb.append(" |- PUTOS ATAQUE ESPECIAL: ").append(ptsAtaquePlanta).append("         |\n\t");
        sb.append(" |- PUNTOS VIDA: ").append(vida).append("                  |\n\t");
        if(idPokemon > 9){
            sb.append(" |- ID POKEMON: ").append(idPokemon).append("                    |\n\t");
        }else
            sb.append(" |- ID POKEMON: ").append(idPokemon).append("                     |\n\t");
        sb.append(" |____________________________________|\n");
        return sb.toString();
    }
}
