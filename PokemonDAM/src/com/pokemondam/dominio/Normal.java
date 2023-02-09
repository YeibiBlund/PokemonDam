/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pokemondam.dominio;

/**
 *
 * @author PC
 */
public class Normal extends Pokemon  {
   
    // Conjunto de propiedades
    private int ptsAtaqueNormal;
    
    // Constructores
    public Normal(){
        super();
    }
    
    public Normal(int idPokemon){
        super(idPokemon);
    }
    
    public Normal(String nombre, int puntosAtaque, int puntosDefensa, int nivel, int ptsAtaqueNormal){
        super(nombre, puntosAtaque, puntosDefensa, nivel);
        this.ptsAtaqueNormal = ptsAtaqueNormal;
    }
    
    public Normal(String nombre, int puntosAtaque, int puntosDefensa, int nivel, int ptsAtaqueNormal, int vida){
        super(nombre, puntosAtaque, puntosDefensa, nivel, vida);
        this.ptsAtaqueNormal = ptsAtaqueNormal;
    }
    

    
    // Getter y Setter

    public int getPtsAtaqueNormal() {
        return ptsAtaqueNormal;
    }

    public void setPtsAtaqueNormal(int ptsAtaqueNormal) {
        this.ptsAtaqueNormal = ptsAtaqueNormal;
    }

    // To string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append("\n\t");
        sb.append("  ____________________________________\n\t");
        sb.append(" |- TIPO NORMAL                       |\n\t");
        if(nivel < 9){
            sb.append(" |- NIVEL: ").append(nivel).append("                         |\n\t");
        }else
            sb.append(" |- NIVEL: ").append(nivel).append("                         |\n\t");
        sb.append(" |- PUNTOS ATAQUE: ").append(puntosAtaque).append("                 |\n\t");
        sb.append(" |- PUNTOS DEFENSA: ").append(puntosDefensa).append("                |\n\t");
        sb.append(" |- PUTOS ATAQUE ESPECIAL: ").append(ptsAtaqueNormal).append("         |\n\t");
        sb.append(" |- PUNTOS VIDA: ").append(vida).append("                  |\n\t");
        if(idPokemon > 9){
            sb.append(" |- ID POKEMON: ").append(idPokemon).append("                    |\n\t");
        }else
            sb.append(" |- ID POKEMON: ").append(idPokemon).append("                     |\n\t");
        sb.append(" |____________________________________|\n");
        return sb.toString();
    }
}