/*
 * 
 */
package com.pokemondam.dominio;

/**
 *
 * @author brune
 */
public class Agua extends Pokemon {
    
    // Conjunto de propiedades
    private int ptsAtaqueAgua;
    
    // Constructores
    public Agua(){
        super();
    }
    
    public Agua(int idPokemon){
        super(idPokemon);
    }
    
    
    public Agua(String nombre, int puntosAtaque, int puntosDefensa, int nivel, int ptsAtaqueAgua, int vida){
        super(nombre, puntosAtaque, puntosDefensa, nivel, vida);
        this.ptsAtaqueAgua = ptsAtaqueAgua;
    }
    
    // Metodos
    public void PistolaAgua(){
    }
    
    public void Burbuja(){
    }
    
    // Getter y Setter

    public int getPtsAtaqueAgua() {
        return ptsAtaqueAgua;
    }

    public void setPtsAtaqueAgua(int ptsAtaqueAgua) {
        this.ptsAtaqueAgua = ptsAtaqueAgua;
    }

    // To string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append("\n\t");
        sb.append("  ____________________________________\n\t");
        sb.append(" |- TIPO AGUA                         |\n\t");
        if(nivel < 9){
            sb.append(" |- NIVEL: ").append(nivel).append("                         |\n\t");
        }else
            sb.append(" |- NIVEL: ").append(nivel).append("                         |\n\t");
        sb.append(" |- PUNTOS ATAQUE: ").append(puntosAtaque).append("                 |\n\t");
        sb.append(" |- PUNTOS DEFENSA: ").append(puntosDefensa).append("                |\n\t");
        sb.append(" |- PUTOS ATAQUE ESPECIAL: ").append(ptsAtaqueAgua).append("         |\n\t");
        sb.append(" |- PUNTOS VIDA: ").append(vida).append("                  |\n\t");
        if(idPokemon > 9){
            sb.append(" |- ID POKEMON: ").append(idPokemon).append("                    |\n\t");
        }else
            sb.append(" |- ID POKEMON: ").append(idPokemon).append("                     |\n\t");
        sb.append(" |____________________________________|\n");
        return sb.toString();
    }
    
}
