/*
 * Datos del entrenador
 */
package com.pokemondam.dominio;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import static pokemondam.PokemonDAM.*;

/** 
                   _________ 
                  |_  | ___ \
                    | | |_/ /
      Autor:        | | ___ \
                /\__/ | |_/ /
                \____/\____/ 

 */
public class Entrenador {

    // Conjunto de propipokeballses
    private int idEntrenador;
    private String nombre;
    private String apellidos;
    private int pokeballs = 10;
    private float dinero = 1000;
    private ArrayList<Pokemon> pokemons;
    private ArrayList<Pokemon> equipo;
    private ArrayList<Medallas> listaMedallas;

    private static int contador = 0;

    // Constructores
    public Entrenador() {
        this.equipo = new ArrayList<>();
        this.listaMedallas = new ArrayList<>();
        this.idEntrenador = contador++;
    }

    public Entrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public Entrenador(String nombre, String apellidos) {
        this();
        this.nombre = nombre;
        this.apellidos = apellidos;
        
    }
    public Entrenador(String nombre, String apellidos, int pokeballs, float dinero) {
        this();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.pokeballs = pokeballs;
        this.dinero = dinero;
    }

    public Entrenador(String nombre, String apellidos, int pokeballs, float dinero, ArrayList<Pokemon> equipo) {
        this();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.pokeballs = pokeballs;
        this.dinero = dinero;
        this.equipo = equipo;
    }

    public Entrenador(int idEntrenador, String nombre, String apellidos, int pokeballs, float dinero, ArrayList<Pokemon> equipo) {
        this.idEntrenador = idEntrenador;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.pokeballs = pokeballs;
        this.dinero = dinero;
        this.equipo = equipo;
    }

    // Getter y Setter
    public int getIdEntrenador() {
        return idEntrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getPokeballs() {
        return pokeballs;
    }

    public void setPokeballs(int pokeballs) {
        this.pokeballs = pokeballs;
    }

    public float getDinero() {
        return dinero;
    }

    public void setDinero(float dinero) {
        this.dinero = dinero;
    }

    public ArrayList<Pokemon> getpokemons() {
        return pokemons;
    }

    public void setpokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    // Metodos    
    public void combatir() {
        
    }

    public void escapar() {
    }

    public void montarBici() {
        imprimirEspaciosLargo();
        System.out.println("     ////^\\\\\\\\\n" +
"      | ^   ^ |\n" +
"     @ (o) (o) @\n" +
"      |   <   |\n" +
"      |  ___  |\n" +
"       \\_____/\n" +
"     ____|  |____\n" +
"    /    \\__/    \\\n" +
"   /              \\\n" +
"  /\\_/|        |\\_/\\\n" +
" / /  |        |  \\ \\\n" +
"( <   |        |   > )\n" +
" \\ \\  |        |  / /\n" +
"  \\ \\ |________| / /\n" +
"   \\ \\|");
        System.out.println("OH VAYA, PARECE QUE NO TIENES BICICLETA AUN....");
        continuar();
        System.out.println("HAS VENIDO A COMPRAR UNA???");
        continuar();
        System.out.println("CON UNA BICICLETA PUEDES RECORRER GRANDES DISTANCIAS EN POCO TIEMPO.");
        continuar();
        System.out.println("QUIERES ADQUIRIR LA MEJOR BICICLETA DEL MERCADO?");
        tiempoEspera();
        
        continuar();
        System.out.println("MOCOSO!!!!!! NO TIENES DINERO SUFICIENTE PARA COMPRAR ESTA MARAVILLA DE LA INGENIERIA \nSERA MEJOR QUE SIGAS TU AVENTURA A PIE.");
        System.out.println("Y AHORA, LARGO DE AQUI!!!!");
        
        
    }

    public HashSet<Pokemon> pokemonsCapturados = new HashSet<Pokemon>();//LA LISTA HASHSET SOLO ALMACENA DATOS UNICOS Y NO PERMITE QUE HAYA VALORES REPETIDOS. ME SIRVE PARA EVITAR QUE SE CAPTURE DOS VECES EL MISMO POKEMON.

    public void iniciarCaptura(ArrayList<Pokemon> pokemons) throws InterruptedException  {

        int tiempo = (int) (Math.random() * 5 + 1);  //MATH RANDOM ME RANDOMIZA UN NUMERO Y LO ASIGNA A LA VARIABLE TIEMPO PARA DEFINIR EL TIEMPO DE BUSQUEDA DE POKEMON

        for (int i = 0; i < 6; i++) {
            if (pokeballs>=1) {
                
            caminandoHierba();   //METODO QUE ME IMPRIME POR PANTALLA LA ACCION DE CAMINAR POR LA HIERBA
            Thread.sleep(tiempo * 500);
            int indice = (int) (Math.random() * pokemons.size());  //MATH RANDOMD GENERA UN NUMERO ALEATORIO Y SE LO ASIGNA A INDICE
            Pokemon pokemonEncontrado = pokemons.get(indice);  // ASIGNO A POKEMONENCONTRADO EL GETTER DE POKEMON EL NUMERO DEL INDICE
            while (pokemonsCapturados.contains(pokemonEncontrado)) {   //BUCLE WHILE PARA COMPROBAR QUE EL PROXIMO POKEMON QUE APAREZCA NO HAYA SALIDO YA. 
                indice = (int) (Math.random() * pokemons.size());           //SI SE REPITE EL POKEMON ENCONTRADO ME GENERA OTRO.
                pokemonEncontrado = pokemons.get(indice);
            }
            pokemonsCapturados.add(pokemonEncontrado);   // ESTO ALMACENA EL POKEMON ENCONTRADO EN LA LISTA DE CAPTURADOS.
            imprimirEspacios();
            System.out.println("====================================================");
            
            dibujoPokemon(pokemonEncontrado);  //METODO QUE MUESTRA UN DIBUJO Y UN MENSAJE DEL POKEMON ENCONTRADO.
            panelCaptura();  //METODO QUE MUESTRA EL DIBUJO DEL PANEL DE CAPTURA

            Scanner lectura = new Scanner(System.in);  //ESCANER QUE RECOGE LA INFORMACION SOBRE CAPTURAR O ESCAPAR
            System.out.println("POKEBALLAS RESTANTES: " + pokeballs);
            int opcion = Integer.parseInt(lectura.nextLine());
            if (opcion == 1) {
                pokeballs--;
                tiempoCaptura();
                int intentos = 0;
                while (intentos < 2) {
                   boolean capturaExitosa = Math.random() < 0.1;
                    if (capturaExitosa) {
                        System.out.println("\n\t ________________________________");
                        System.out.println("\t|                                |");
                        System.out.println("\t|GENIAL! EL POKEMON FUE CAPTURADO|");
                        System.out.println("\t|________________________________|");
                        tiempoEspera();
                        System.out.println(pokemonEncontrado.getNombre() + " FUE TRANSFERIDO A TU EQUIPO POKEMON.");
                        equipo.add(pokemonEncontrado);
                        tiempoEspera();      //METODOS PARA ESPERAR ANTES DE MOSTRAR EL ENTRENADOR Y DE TIEMPO A LEERLO
                        mostrarEntrenador();
                        break;
                    } else {
                         System.out.println("OH, VAYA " + pokemonEncontrado.getNombre() + " SE ESCAPO.   \n QUIERES VOLVER A INTENTARLO? \n 1.SI    2.NO");
                        int otroIntento = scanner.nextInt();
                        if (otroIntento == 1) {
                            pokeballs--;
                            System.out.println("INTENTOS RESTANTES: " + (1 - intentos));
                            tiempoEspera();
                            tiempoEspera();
                            imprimirEspacios();
                            intentos++;
                            
                        }else
                            break;
                    }
                }
                if (intentos >= 3) {
                    System.out.println("EL POKEMON SE HA ESCAPADO.");
                    tiempoEspera();
                }
            } else if (opcion == 2) {
                System.out.println("ESCAPASTE SANO Y SALVO.");
                mostrarEntrenador();
            } else {
                System.out.println("OPCION INVALIDA. SALIENDO SEL COMBATE.");
            }
        }else{
                System.out.println("NO QUEDAN MAS POKEBALLS.");
                break;
            }
        }
        
        
        imprimirEspacios();
        imprimirEspacios();
        System.out.println("CAPTURA FINALIZADA.\n HAS CAPTURADO LOS SIGUIENTES POKEMONS:");
        mostrarEntrenador2();
        puntuacionCaptura(pokemons);
        tiempoEsperaLargo();
        return;
    }
            Scanner scanner = new Scanner(System.in);

    public void listapokemons(ArrayList<Pokemon> pokemons) {

        this.pokemons = pokemons;
    }

    // To String
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DATOS ENTRENADOR:").append("\n\t");
        sb.append("-ID ENTRENADOR= ").append(idEntrenador).append("\n\t");
        sb.append("- NOMBRE= ").append(nombre).append("\n\t");
        sb.append("- APELLIDOS= ").append(apellidos).append("\n\t");
        sb.append("- POKEBALLS= ").append(pokeballs).append("\n\t");
        sb.append("- DINERO= ").append(dinero).append("\n\t");
        sb.append("- EQUIPO= ").append(pokemons).append("\n\t");
        return sb.toString();
    }
//CONJUNTO DE METODOS: 
    //METODO QUE ME MUESTRA LA FICHA DEL ENTRENADOR Y SU EQUIPO POKEMONM

    private void mostrarEntrenador() {
        System.out.println("\n\n\n");
        System.out.println("FICHA DE: " + this.nombre);
        System.out.println("EQUIPO POKEMON: \n" + equipo);
        tiempoEspera();
    }

    private void mostrarEntrenador2() {
        imprimirEspaciosLargo();
        
        System.out.println("===================================");
        System.out.println(this.nombre);
        System.out.println("EQUIPO POKEMON: \n" + equipo);
        System.out.println("===================================");
        continuar();
    }
    //METODO QUE RECREA LA ANIMACION DE LANZAR LA POKEBALL Y EL TIEMPO DE CAPTURA

    private void tiempoCaptura() {
        tiempoEspera();
        imprimirEspacios();
        System.out.println("\t\t\t\t _______________________________");
        System.out.println("\t\t\t\t|                               |");
        System.out.println("\t\t\t\t|        USASTE POKEBALL        |");
        System.out.println("\t\t\t\t|_______________________________|");
        tiempoEspera();
        System.out.println("         _....._");
        System.out.println("      .;;'::::::'-.");
        System.out.println("    .;;:   ;;;:::::.'.");
        System.out.println("   /;;:    ;:;:;:;:;:\\");
        System.out.println("  |;;:':::::__::::::::|");
        System.out.println("  |;;:'''''(#_)'''''''|");
        System.out.println("  |;;::.              |");
        System.out.println("   \\;;::.            /");
        System.out.println("    ';;::.         .'");
        System.out.println("      '-;;:..  _.-'");
        System.out.println("          '''''");
        tiempoEsperaCorto();
        imprimirEspacios();
        imprimirEspacios();
        System.out.println("                                           _....._");
        System.out.println("                                        .;;'::::::'-.");
        System.out.println("                                       .;;   :;;;:::::.'.");
        System.out.println("                       ----           /;;    :;:;:;:;:;:\\");
        System.out.println("                 --------            |;;:':::::__::::::::|");
        System.out.println("                                     |;;:*****(#_)*******|");
        System.out.println("           ---------                 |;;::.              |");
        System.out.println("                                      \\;;::.            /");
        System.out.println("                         ----          ';;::.         .'");
        System.out.println("                             ---         '-;;:..  _.-'");
        System.out.println("                                             '''''");
        tiempoEsperaCorto();
        imprimirEspacios();
        imprimirEspacios();
        System.out.println("                                                                               _....._");
        System.out.println("                                                                            .;; ::::::'-.");
        System.out.println("                                                               --         .;;   :;;;:::::.'.");
        System.out.println("                                                 --------                /;;:   :;:;:;:;:;:\\");
        System.out.println("                                         ------                         |;;:':::::__::::::::|");
        System.out.println("                                      --              ---               |;;:*****(#_)*******|");
        System.out.println("                                  --------                --            |;;::.              |");
        System.out.println("                            --           ----                            \\;;::.            /");
        System.out.println("                                                  -------                  ';;::.         .'");
        System.out.println("                                                           ------            '-;;:..  _.-'");
        System.out.println("                                                                                 '''''");
        System.out.println("\t\t\t\t ________________________________");
        System.out.println("\t\t\t\t|                                |");
        System.out.println("\t\t\t\t| LA POKEBALL ACERTO AL OBJETIVO |");
        System.out.println("\t\t\t\t|________________________________|");
        tiempoEspera();
        tiempoEspera();
        imprimirEspacios();
        imprimirEspacios();
        imprimirEspacios();
        System.out.println("\t\t...1\n");
        System.out.println("                                _....._                 ");
        System.out.println("                             .;;'::::::'-.                 ");
        System.out.println("                           .;;::;:;;;:::::.'.                 ");
        System.out.println("                          /;;:':;:;:;:;:;:;:\\                 ");
        System.out.println("               -         |;;:':::::__::::::::|                 ");
        System.out.println("                         |;;:*****(#_)*******|                 ");
        System.out.println("                 ---     |;;::.              |                 ");
        System.out.println("                          \\;;::.            /                 ");
        System.out.println("                    -      ';;::.         .'                 ");
        System.out.println("                            '-;;:..  _.-'                 ");
        System.out.println("                       --        '''''                 ");
        tiempoEspera();
        imprimirEspacios();
        imprimirEspacios();
        System.out.println("\t\t.....2\n");
        System.out.println("                                     _....._                   ");
        System.out.println("                                  .;;'::::::'-.                   ");
        System.out.println("                                .;;::;:;;;:::::.'                   .");
        System.out.println("                               /;;:':;:;:;:;:;:;:\\                   ");
        System.out.println("                              |;;:':::::__::::::::|     -              ");
        System.out.println("                              |;;:*****(_#)*******|                   ");
        System.out.println("                              |;;::.              | --                  ");
        System.out.println("                               \\;;::.            /    --               ");
        System.out.println("                                ';;::.         .'                   ");
        System.out.println("                                  '-;;:..  _.-'      --             ");
        System.out.println("                                      '''''        -           ");
        tiempoEspera();
        imprimirEspacios();
        imprimirEspacios();
        System.out.println("\t\t.......Y");
        System.out.println("                                 _....._");
        System.out.println("                              .;;'::::::'-.");
        System.out.println("                            .;;::;:;;;:::::.'.");
        System.out.println("                           /;;:':;:;:;:;:;:;:\\");
        System.out.println("                          |;;:':::::__::::::::|");
        System.out.println("                          |;;:*****(##)*******|");
        System.out.println("                          |;;::.              |");
        System.out.println("                           \\;;::.            /");
        System.out.println("                            ';;::.         .'");
        System.out.println("                              '-;;:..  _.-'");
        System.out.println("                                  '''''");
        tiempoEspera();
        tiempoEspera();
    }
    //METODO QUE MUESTRA EL PANEL DE CAPTURA CON LAS OPCIONES: 1.CAPTURAR 2.ESCAPAR

    private void panelCaptura() {
        System.out.println("    Pokeballs: " + pokeballs);
        System.out.println("    = == === ==== ===== == ===== ==== === == =");
        System.out.println(" /      OPCIONES:                               \\");
        System.out.println("|                        1. CAPTURAR             |");
        System.out.println("|                                                |");
        System.out.println(" \\                       2. ESCAPAR              /");
        System.out.println("    = == === ==== ===== == ===== ==== === == =");
    }
    //METODO QUE MUESTRA EL DIBUJO DEL POKEMON ENCONTRADO EN LA HIERBA


    private void dibujoPokemon(Pokemon pokemonEncontrado) {
        if (pokemonEncontrado.getNombre() == "CHARMANDER") {
            System.out.println("              _.--\"\"`-..");
            System.out.println("            ,'          `.");
            System.out.println("          ,'          __  `.");
            System.out.println("         /|          \" __   \\");
            System.out.println("        , |           / |.   .");
            System.out.println("        |,'          !_.'|   |");
            System.out.println("      ,'             '   |   |");
            System.out.println("     /              |`--'|   |");
            System.out.println("    |                `---'   |");
            System.out.println("     .   ,                   |                       ,\".");
            System.out.println("      ._     '           _'  |                    , ' \\ `");
            System.out.println("  `.. `.`-...___,...---\"\"    |       __,.        ,`\"   L,|");
            System.out.println("  |, `- .`._        _,-,.'   .  __.-'-. /        .   ,    \\");
            System.out.println("-:..     `. `-..--_.,.<       `\"      / `.        `-/ |   .");
            System.out.println("  `,         \"\"\"\"'     `.              ,'         |   |  ',,");
            System.out.println("    `.      '            '            /          '    |'. |/");
            System.out.println("      `.   |              \\       _,-'           |       ''");
            System.out.println("        `._'               \\   '\"\\                .      |");
            System.out.println("           |                '     \\                `._  ,'");
            System.out.println("           |                 '     \\                 .'|");
            System.out.println("           |                 .      \\                | |");
            System.out.println("           |                 |       L              ,' |");
            System.out.println("           `                 |       |             /   '");
            System.out.println("            \\                |       |           ,'   /");
            System.out.println("          ,' \\               |  _.._ ,-..___,..-'    ,'");
            System.out.println("         /     .             .      `!             ,j'");
            System.out.println("        /       `.          /        .           .'/");
            System.out.println("       .          `.       /         |        _.'.'");
            System.out.println("        `.          7`'---'          |------\"'_.'");
            System.out.println("       _,.`,_     _'                ,''-----\"'");
            System.out.println("   _,-_    '       `.     .'      ,\\");
            System.out.println("   -\" /`.         _,'     | _  _  _.|");
            System.out.println("    \"\"--'---\"\"\"\"\"'        `' '! |! /");
            System.out.println("                            `\" \" -' ");
            System.out.println("");
            System.out.println("");
        } else if (pokemonEncontrado.getNombre() == "CHARMELEON") {
            System.out.println("                      ,-'`\\");
            System.out.println("                  _,\"'    j");
            System.out.println("           __....+       /               .");
            System.out.println("       ,-'\"             /               ; `-._.'.");
            System.out.println("      /                (              ,'       .'");
            System.out.println("     |            _.    \\             \\   ---._ `-.");
            System.out.println("     ,|    ,   _.'  Y    \\             `- ,'   \\   `.`.");
            System.out.println("     l'    \\ ,'._,\\ `.    .              /       ,--. l");
            System.out.println("  .,-        `._  |  |    |              \\       _   l .");
            System.out.println(" /              `\"--'    /              .'       ``. |  )");
            System.out.println(".\\    ,                 |                .        \\ `. '");
            System.out.println("`.                .     |                '._  __   ;. \\'");
            System.out.println("  `-..--------...'       \\                  `'  `-\"'.  \\");
            System.out.println("      `......___          `._                        |  \\");
            System.out.println("               /`            `..                     |   .");
            System.out.println("              /|                `-.                  |    L");
            System.out.println("             / |               \\   `._               .    |");
            System.out.println("           ,'  |,-\"-.   .       .     `.            /     |");
            System.out.println("         ,'    |     '   \\      |       `.         /      |");
            System.out.println("       ,'     /|       \\  .     |         .       /       |");
            System.out.println("     ,'      / |        \\  .    +          \\    ,'       .'");
            System.out.println("    .       .  |         \\ |     \\          \\_,'        / j");
            System.out.println("    |       |  L          `|      .          `        ,' '");
            System.out.println("    |    _. |   \\          /      |           .     .' ,'");
            System.out.println("    |   /  `|    \\        .       |  /        |   ,' .'");
            System.out.println("    |   ,-..\\     -.     ,        | /         |,.' ,'");
            System.out.println("    `. |___,`    /  `.   /`.       '          |  .'");
            System.out.println("      '-`-'     j     ` /.\"7-..../|          ,`-'");
            System.out.println("                |        .'  / _/_|          .");
            System.out.println("                `,       `\"'/\"'    \\          `.");
            System.out.println("                  `,       '.       `.         |");
            System.out.println("             __,.-'         `.        \\'       |");
            System.out.println("            /_,-'\\          ,'        |        _.");
            System.out.println("             |___.---.   ,-'        .-':,-\"`\\,' .");
            System.out.println("                  L,.--\"'           '-' |  ,' `-.\\");
            System.out.println("                                        `.' ");
        } else if (pokemonEncontrado.getNombre() == "CHARIZARD") {
            System.out.println("                 .\"-,.__");
            System.out.println("                 `.     `.  ,");
            System.out.println("              .--'  .._,'\"-' `.");
            System.out.println("             .    .'         `'");
            System.out.println("             `.   /          ,'");
            System.out.println("               `  '--.   ,-\"'");
            System.out.println("                `\"`   |  \\");
            System.out.println("                   -. \\, |");
            System.out.println("                    `--Y.'      ___.");
            System.out.println("                         \\     L._, \\");
            System.out.println("               _.,        `.   <  <\\                _");
            System.out.println("             ,' '           `, `.   | \\            ( `");
            System.out.println("          ../, `.            `  |    .\\`.           \\ \\_");
            System.out.println("         ,' ,..  .           _.,'    ||\\l            )  '\".");
            System.out.println("        , ,'   \\           ,'.-.`-._,'  |           .  _._`.");
            System.out.println("      ,' /      \\ \\        `' ' `--/   | \\          / /   ..\\");
            System.out.println("    .'  /        \\ .         |\\__ - _ ,'` `        / /     `.`.");
            System.out.println("    |  '          ..         `-...-\"  |  `-'      / /        . `.");
            System.out.println("    | /           |L__           |    |          / /          `. `.");
            System.out.println("   , /            .   .          |    |         / /             ` `");
            System.out.println("  / /          ,. ,`._ `-_       |    |  _   ,-' /               ` \\");
            System.out.println(" / .           \\\"`_/. `-_ \\_,.  ,'    +-' `-'  _,        ..,-.    \\`.");
            System.out.println(".  '         .-f    ,'   `    '.       \\__.---'     _   .'   '     \\ \\");
            System.out.println("' /          `.'    l     .' /          \\..      ,_|/   `.  ,'`     L`");
            System.out.println("|'      _.-\"\"` `.    \\ _,'  `            \\ `.___`.'\"`-.  , |   |    | \\");
            System.out.println("||    ,'      `. `.   '       _,...._        `  |    `/ '  |   '     .|");
            System.out.println("||  ,'          `. ;.,.---' ,'       `.   `.. `-'  .-' /_ .'    ;_   ||");
            System.out.println("|| '              V      / /           `   | `   ,'   ,' '.    !  `. ||");
            System.out.println("||/            _,-------7 '              . |  `-'    l         /    `||");
            System.out.println(". |          ,' .-   ,' ||               | .-.        `.      .'     ||");
            System.out.println(" `'        ,'    `\".'    |               |    `.        '. -.'       `'");
            System.out.println("          /      ,'      |               |,'    \\-.._,.'/'");
            System.out.println("          .     /        .               .       \\    .''");
            System.out.println("        .`.    |         `.             /         :_,'.'");
            System.out.println("          \\ `...\\   _     ,'-.        .'         /_.-'");
            System.out.println("           `-.__ `,  `'   .  _.>----''.  _  __  /");
            System.out.println("                .'        /\"'          |  \"'   '_");
            System.out.println("               /_|.-'\\ ,\".             '.'`__'-( \\");
            System.out.println("                 / ,\"'\"\\,'               `/  `-.|\" ");
        } else if (pokemonEncontrado.getNombre() == "SQUIRTLE") {
            System.out.println("            ,-'            \"`-.");
            System.out.println("          ,'                   `-.");
            System.out.println("        ,'                        \\");
            System.out.println("      ,'                           .");
            System.out.println("      .'\\               ,\"\".       `");
            System.out.println("     ._.'|             / |  `       \\");
            System.out.println("     |   |            `-.'  ||       `.");
            System.out.println("     |   |            '-._,'||       | \\");
            System.out.println("     .`.,'             `..,'.'       , |`-.");
            System.out.println("     l                       .'`.  _/  |   `.");
            System.out.println("     `-.._'-   ,          _ _'   -\" \\  .     `");
            System.out.println("`.\"\"\"\"\"'-.`-...,---------','         `. `....__.");
            System.out.println(".'        `\"-..___      __,'\\          \\  \\     \\");
            System.out.println("\\_ .          |   `\"\"\"\"'    `.           . \\     \\");
            System.out.println("  `.          |              `.          |  .     L");
            System.out.println("    `.        |`--...________.'.        j   |     |");
            System.out.println("      `._    .'      |          `.     .|   ,     |");
            System.out.println("         `--,\\       .            `7\"\"' |  ,      |");
            System.out.println("            ` `      `            /     |  |      |    _,-'\"\"\"`-.");
            System.out.println("             \\ `.     .          /      |  '      |  ,'          `.");
            System.out.println("              \\  v.__  .        '       .   \\    /| /              \\");
            System.out.println("               \\/    `\"\"\\\"\"\"\"\"\"\"`.       \\   \\  /.''                |");
            System.out.println("                `        .        `._ ___,j.  `/ .-       ,---.     |");
            System.out.println("                ,`-.      \\         .\"     `.  |/        j     `    |");
            System.out.println("               /    `.     \\       /         \\ /         |     /    j");
            System.out.println("              |       `-.   7-.._ .          |\"          '         /");
            System.out.println("              |          `./_    `|          |            .     _,'");
            System.out.println("              `.           / `----|          |-............`---'");
            System.out.println("                \\          \\      |          |");
            System.out.println("               ,'           )     `.         |");
            System.out.println("                7____,,..--'      /          |");
            System.out.println("                                  `---.__,--.'");
        } else if (pokemonEncontrado.getNombre() == "WARTORTLE") {
            System.out.println("     __                                _.--'\"7");
            System.out.println("    `. `--._                        ,-'_,-  ,'");
            System.out.println("     ,'  `-.`-.                   /' .'    ,|");
            System.out.println("     `.     `. `-     __...___   /  /     - j");
            System.out.println("       `.     `  `.-\"\"        \" .  /       /");
            System.out.println("         \\     /                ` /       /");
            System.out.println("          \\   /                         ,'");
            System.out.println("          '._'_               ,-'       |");
            System.out.println("             | \\            ,|  |   ...-'");
            System.out.println("             || `         ,|_|  |   | `             _..__");
            System.out.println("            /|| |          | |  |   |  \\  _,_    .-\"     `-.");
            System.out.println("           | '.-'          |_|_,' __!  | /|  |  /           \\");
            System.out.println("   ,-...___ .=                  ._..'  /`.| ,`,.      _,.._ |");
            System.out.println("  |   |,.. \\     '  `'        ____,  ,' `--','  |    /      |");
            System.out.println(" ,`-..'  _)  .`-..___,---'_...._/  .'      '-...'   |      /");
            System.out.println("'.__' \"\"'      `.,------'\"'      ,/            ,     `.._.' `.");
            System.out.println("  `.             | `--........,-'.            .         \\     \\");
            System.out.println("    `-.          .   '.,--\"\"     |           ,'\\        |      .");
            System.out.println("       `.       /     |          L          ,\\  .       |  .,---.");
            System.out.println("         `._   '      |           \\        /  .  L      | /   __ `.");
            System.out.println("            `-.       |            `._   ,    l   .    j |   '  `. .");
            System.out.println("              |       |               `\"' |  .    |   /  '      .' |");
            System.out.println("              |       |                   j  |    |  /  , `.__,'   |");
            System.out.println("              `.      L                 _.   `    j ,'-'           |");
            System.out.println("               |`\"---..\\._______,...,--' |   |   /|'      /        j");
            System.out.println("               '       |                 |   .  / |      '        /");
            System.out.println("                .      .              ____L   \\'  j    -',       /");
            System.out.println("               / `.     .          _,\"     \\   | /  ,-','      ,'");
            System.out.println("              /    `.  ,'`-._     /         \\  i'.,'_,'      .'");
            System.out.println("             .       `.      `-..'             |_,-'      _.'");
            System.out.println("             |         `._      |            ''/      _,-'");
            System.out.println("             |            '-..._\\             `__,.--'");
            System.out.println("            ,'           ,' `-.._`.            .");
            System.out.println("           `.    __      |       \"'`.          |");
            System.out.println("             `-\"'  `\"\"\"\"'            7         `.");
            System.out.println("                                    `---'--.,'\"`' ");
        } else if (pokemonEncontrado.getNombre() == "BLASTOISE") {
            System.out.println("                       _");
            System.out.println("            _,..-\"\"\"--' `,.-\".");
            System.out.println("          ,'      __.. --',  |");
            System.out.println("        _/   _.-\"' |    .' | |       ____");
            System.out.println("  ,.-\"\"'    `-\"+.._|     `.' | `-..,',--.`.");
            System.out.println(" |   ,.                      '    j 7    l \\__");
            System.out.println(" |.-'                            /| |    j||  .");
            System.out.println(" `.                   |         / L`.`\"\"','|\\  \\");
            System.out.println("   `.,----..._       ,'`\"'-.  ,'   \\ `\"\"'  | |  l");
            System.out.println("     Y        `-----'       v'    ,'`,.__..' |   .");
            System.out.println("      `.                   /     /   /     `.|   |");
            System.out.println("        `.                /     l   j       ,^.  |L");
            System.out.println("          `._            L       +. |._   .' \\|  | \\");
            System.out.println("            .`--...__,..-'\"\"'-._  l L  \"\"\"    |  |  \\");
            System.out.println("          .'  ,`-......L_       \\  \\ \\     _.'  ,'.  l");
            System.out.println("       ,-\"`. / ,-.---.'  `.      \\  L..--\"'  _.-^.|   l");
            System.out.println(" .-\"\".'\"`.  Y  `._'   '    `.     | | _,.--'\"     |   |");
            System.out.println("  `._'   |  |,-'|      l     `.   | |\"..          |   l");
            System.out.println("  ,'.    |  |`._'      |      `.  | |_,...---\"\"\"\"\"`    L");
            System.out.println(" /   |   j _|-' `.     L       | j ,|              |   |");
            System.out.println("`--,\"._,-+' /`---^..../._____,.L',' `.             |\\  |");
            System.out.println("   |,'      L                   |     `-.          | \\j");
            System.out.println("            .                    \\       `,        |  |");
            System.out.println("             \\                __`.Y._      -.     j   |");
            System.out.println("              \\           _.,'       `._     \\    |  j");
            System.out.println("              ,-\"`-----\"\"\"\"'           |`.    \\  7   |");
            System.out.println("             /  `.        '            |  \\    \\ /   |");
            System.out.println("            |     `      /             |   \\    Y    |");
            System.out.println("            |      \\    .             ,'    |   L_.-')");
            System.out.println("             L      `.  |            /      ]     _.-^._");
            System.out.println("              \\   ,'  `-7         ,-'      / |  ,'      `-._");
            System.out.println("             _,`._       `.   _,-'        ,',^.-            `.");
            System.out.println("          ,-'     v....  _.`\"',          _:'--....._______,.-'");
            System.out.println("        ._______./     /',,-'\"'`'--.  ,-'  `.");
            System.out.println("                 \"\"\"\"\"`.,'         _\\`----...' mh");
            System.out.println("                        --------\"\"'");
        } else if (pokemonEncontrado.getNombre() == "BULBASAUR") {
            System.out.println("                                           /");
            System.out.println("                        _,.------....___,.' ',.-.");
            System.out.println("                     ,-'          _,.--\"        |");
            System.out.println("                   ,'         _.-'              .");
            System.out.println("                  /   ,     ,'                   `");
            System.out.println("                 .   /     /                     ``.");
            System.out.println("                 |  |     .                       \\.\\");
            System.out.println("       ____      |___._.  |       __               \\ `.");
            System.out.println("     .'    `---\"\"       ``\"-.--\"'`  \\               .  \\");
            System.out.println("    .  ,            __               `              |   .");
            System.out.println("    `,'         ,-\"'  .               \\             |    L");
            System.out.println("   ,'          '    _.'                -._          /    |");
            System.out.println("  ,`-.    ,\".   `--'                      >.      ,'     |");
            System.out.println(" . .'\\'   `-'       __    ,  ,-.         /  `.__.-      ,'");
            System.out.println(" ||:, .           ,'  ;  /  / \\ `        `.    .      .'/");
            System.out.println(" j|:D  \\          `--'  ' ,'_  . .         `.__, \\   , /");
            System.out.println("/ L:_  |                 .  \"' :_;                `.'.'");
            System.out.println(".    \"\"'                  \"\"\"\"\"'                    V");
            System.out.println(" `.                                 .    `.   _,..  `");
            System.out.println("   `,_   .    .                _,-'/    .. `,'   __  `");
            System.out.println("    ) \\`._        ___....----\"'  ,'   .'  \\ |   '  \\  .");
            System.out.println("   /   `. \"`-.--\"'         _,' ,'     `---' |    `./  |");
            System.out.println("  .   _  `\"\"'--.._____..--\"   ,             '         |");
            System.out.println("  | .\" `. `-.                /-.           /          ,");
            System.out.println("  | `._.'    `,_            ;  /         ,'          .");
            System.out.println(" .'          /| `-.        . ,'         ,           ,");
            System.out.println(" '-.__ __ _,','    '`-..___;-...__   ,.'\\ ____.___.'");
            System.out.println(" `\"^--'..'   '-`-^-'\"--    `-^-'`.''\"\"\"\"\"`.,^.`.--' ");
        } else if (pokemonEncontrado.getNombre() == "IVYSAUR") {
            System.out.println("                               ,'\"`.,./.");
            System.out.println("                             ,'        Y',\"..");
            System.out.println("                           ,'           \\  | \\");
            System.out.println("                          /              . |  `");
            System.out.println("                         /               | |   \\");
            System.out.println("            __          .                | |    .");
            System.out.println("       _   \\  `. ---.   |                | j    |");
            System.out.println("      / `-._\\   `Y   \\  |                |.     |");
            System.out.println("     _`.    ``    \\   \\ |..              '      |,-'\"\"7,....");
            System.out.println("     l     '-.     . , `|  | , |`. , ,  /,     ,'    '/   ,'_,.-.");
            System.out.println("     `-..     `-.  : :     |/ `   ' \"\\,' | _  /          '-'    /___");
            System.out.println("      \\\"\"' __.,.-`.: :        /   /._    l'.,'");
            System.out.println("       `--,   _.-' `\".           /__ `'-.' '         .");
            System.out.println("       ,---..._,.--\"\"\"\"\"\"\"--.__..----,-.'   .  /    .'   ,.--");
            System.out.println("       |                          ,':| /    | /     ;.,-'--      ,.-");
            System.out.println("       |     .---.              .'  :|'     |/ ,.-='\"-.`\"`' _   -.'");
            System.out.println("       /    \\    /               `. :|--.  _L,\"---.._        \"----'");
            System.out.println("     ,' `.   \\ ,'           _,     `''   ``.-'       `-  -..___,'");
            System.out.println("    . ,.  .   `   __     .-'  _.-           `.     .__    \\");
            System.out.println("    |. |`        \"  ;   !   ,.  |             `.    `.`'---'");
            System.out.println("    ,| |C\\       ` /    | ,' |(]|            -. |-..--`");
            System.out.println("   /  \"'--'       '      /___|__]        `.  `- |`.");
            System.out.println("  .       ,'                   ,   /       .    `. \\");
            System.out.println("    \\                      .,-'  ,'         .     `-.");
            System.out.println("     x---..`.  -'  __..--'\"/\"\"\"\"\"  ,-.      |   |   |");
            System.out.println("    / \\--._'-.,.--'     _`-    _. ' /       |     -.|");
            System.out.println("   ,   .   `-..__ ...--'  _,.-' | `   ,.-.  ;   /  '|");
            System.out.println("  .  _,'         '\"-----\"\"      |    `   | /  ,'    ;");
            System.out.println("  |-'  .-.    `._               |     `._// ,'     /");
            System.out.println(" _|    `-'   _,' \"`--.._________|        `,'    _ /.");
            System.out.println("//\\   ,-._.'\"/\\__,.   _,\"     /_\\__/`. /'.-.'.-/_,`-' ");
            System.out.println("`-\"`\"' v'    `\"  `-`-\"              `-'`-`  `'");
        } else if (pokemonEncontrado.getNombre() == "VENUSAUR") {
            System.out.println("                           _._       _,._");
            System.out.println("                        _.'   `. ' .'   _`.");
            System.out.println("                ,\"\"\"/`\"\"-.-.,/. ` V'\\-,`.,--/\"\"\".\"-..");
            System.out.println("              ,'    `...,' . ,\\-----._|     `.   /   \\");
            System.out.println("             `.            .`  -'`\"\" .._   :> `-'   `.");
            System.out.println("            ,'  ,-.  _,.-'| `..___ ,'   |'-..__   .._ L");
            System.out.println("           .    \\_ -'   `-'     ..      `.-' `.`-.'_ .|");
            System.out.println("           |   ,',-,--..  ,--../  `.  .-.    , `-.  ``.");
            System.out.println("           `.,' ,  |   |  `.  /'/,,.\\/  |    \\|   |");
            System.out.println("                `  `---'    `j   .   \\  .     '   j");
            System.out.println("              ,__`\"        ,'|`'\\_/`.'\\'        |\\-'-, _,.");
            System.out.println("       .--...`-. `-`. /    '- ..      _,    /\\ ,' .--\"'  ,'\".");
            System.out.println("     _'-\"\"-    --  _`'-.../ __ '.'`-^,_`-\"\"\"\"---....__  ' _,-`");
            System.out.println("   _.----`  _..--.'        |  \"`-..-\" __|'\"'         .\"\"-. \"\"'--.._");
            System.out.println("  /        '    /     ,  _.+-.'  ||._'   \"\"\"\". .          `     .__\\");
            System.out.println(" `---    /        /  / j'       _/|..`  -. `-`\\ \\   \\  \\   `.  \\ `-..");
            System.out.println(",\" _.-' /    /` ./  /`_|_,-\"   ','|       `. | -'`._,   L  \\ .  `.   |");
            System.out.println("`\"' /  /  / ,__...-----| _.,  ,'            `|----.._`-.|' |. .` ..  .");
            System.out.println("   /  '| /.,/   \\--.._ `-,' ,          .  '`.'  __,., '  ''``._ \\ \\`,'");
            System.out.println("  /_,'---  ,     \\`._,-` \\ //  / . \\    `._,  -`,  / / _   |   `-L -");
            System.out.println("   /       `.     ,  ..._ ' `_/ '| |\\ `._'       '-.'   `.,'     |");
            System.out.println("  '         /    /  ..   `.  `./ | ; `.'    ,\"\" ,.  `.    \\      |");
            System.out.println("   `.     ,'   ,'   | |\\  |       \"        |  ,'\\ |   \\    `    ,L");
            System.out.println("   /|`.  /    '     | `-| '                  /`-' |    L    `._/  \\");
            System.out.println("  / | .`|    |  .   `._.'                   `.__,'   .  |     |  (`");
            System.out.println(" '-\"\"-'_|    `. `.__,._____     .    _,        ____ ,-  j     \".-'\"'");
            System.out.println("        \\      `-.  \\/.    `\"--.._    _,.---'\"\"\\/  \"_,.'     /-'");
            System.out.println("         )        `-._ '-.        `--\"      _.-'.-\"\"        `.");
            System.out.println("        ./            `,. `\".._________...\"\"_.-\"`.          _j");
            System.out.println("       /_\\.__,\"\".   ,.'  \"`-...________.---\"     .\".   ,.  / \\");
            System.out.println("              \\_/\"\"\"-'                           `-'--(_,`\"`-` ");
        } else if (pokemonEncontrado.getNombre() == "PSYDUCK") {
            System.out.println("                              ,-'   ,\"\",");
            System.out.println("                             / / ,-'.-'");
            System.out.println("                   _,..-----+-\".\".-'_,..");
            System.out.println("           ,...,.\"'             `--.---'");
            System.out.println("         /,..,'                     `.");
            System.out.println("       ,'  .'                         `.");
            System.out.println("      j   /                             `.");
            System.out.println("      |  /,----._           ,.----.       .");
            System.out.println("     ,  j    _   \\        .'  .,   `.     |");
            System.out.println("   ,'   |        |  ____  |         | .\"--+,^.");
            System.out.println("  /     |`-....-',-'    `._`--....-' _/      |");
            System.out.println(" /      |     _,'          `--..__  `        '");
            System.out.println("j       | ,-\"'    `    .'         `. `        `.");
            System.out.println("|        .\\                        /  |         \\");
            System.out.println("|         `\\                     ,'   |          \\");
            System.out.println("|          |                    |   ,-|           `.");
            System.out.println(".         ,'                    |-\"'  |             \\");
            System.out.println(" \\       /                      `.    |              .");
            System.out.println("  ` /  ,'                        |    `              |");
            System.out.println("   /  /                          |     \\             |");
            System.out.println("  /  |                           |      \\           /");
            System.out.println(" /   |                           |       `.       _,");
            System.out.println(".     .                         .'         `.__,.',.----,");
            System.out.println("|      `.                     ,'             .-\"\"      /");
            System.out.println("|        `._               _.'               |        /");
            System.out.println("|           `---.......,--\"                  |      ,'");
            System.out.println("'                                            '    ,'");
            System.out.println(" \\                                          /   ,'");
            System.out.println("  \\                                        /  ,'");
            System.out.println("   \\                                      / ,'");
            System.out.println("    `.                                   ,+'");
            System.out.println("      >.                               ,'");
            System.out.println("  _.-'  `-.._                      _,-'-._");
            System.out.println(",__          `\",-............,.---\"       `.");
            System.out.println("   \\..---. _,-'            ,'               `.");
            System.out.println("          \"                '..,--.___,-\"\"\"---' ");
        } else if (pokemonEncontrado.getNombre() == "GOLDUCK") {
            System.out.println("                ,|");
            System.out.println("              ,' |         .',");
            System.out.println("             /   |    /\\_,' j");
            System.out.println("            /    |  ,' |    |");
            System.out.println("          ,'     |,'   |   .");
            System.out.println("         /       '    j   j    _,.-/");
            System.out.println("        /      ,'     |   |..-\"  ,'");
            System.out.println("       /              |         /                      `");
            System.out.println("      /               |       ,'");
            System.out.println("    ('  (                 ,\"\"`-.                        /|");
            System.out.println("     | | .              ,'      \\                      / |");
            System.out.println("     | |p'             /        |                     /  |");
            System.out.println("     |.`              '       ,'|-.                 ,'   '");
            System.out.println("     /`\"`\"\"\"'\"`-.    /       .  |. `.___           /    /");
            System.out.println("    /      ,-\"'_|._,'        |  | `.    `\"--..    /    j");
            System.out.println("  ,'     ,',-\"',-'           |,'    `-.       | ,'     |");
            System.out.println(" /     .'.'   /  ,-'|       \\'         `.    ,'/      j");
            System.out.println("|    .','    /  /   |   ,-.  \\           `+-','       '");
            System.out.println("|  .''      .._/   /   /   \\  \\           `.'        /");
            System.out.println(" \\/         | /`\"-.'  /_,..\"\\,\\                     /");
            System.out.println("            '/    |\"|(       \\ .                  ,'");
            System.out.println("                   .| \\       `'                 /");
            System.out.println("                    ' _\\       ,.----\"\"-\\      ,'");
            System.out.println("                 ,-'\"\"  \\    ,'          `   ,'");
            System.out.println("                |        `-.'              ,'");
            System.out.println("                .           \\           _.'");
            System.out.println("                 \\        ___\\         `.");
            System.out.println("                  `.    \"\" `. \\          \\");
            System.out.println("            ,-/\"\"\"\"'._       \\_`.         `.");
            System.out.println("`         _.`-'\"\"            /_`.\\          \\");
            System.out.println("         /.-n+==`       _,,-'\"    \\          \\");
            System.out.println("           ,\\ __.-\"\"\"\"'\"           )          `..__");
            System.out.println("          (,.'                   _/         .._   _\\_");
            System.out.println("          '                    ,\"  _,.-._   -. `_/__ \\");
            System.out.println("                              / ),+....._\\ ,--.\"    `'");
            System.out.println("                             `\"'          `.._ \\");
            System.out.println("                                              `' ");
        } else if (pokemonEncontrado.getNombre() == "GROWLITHE") {
            System.out.println("");
            System.out.println("                   _,");
            System.out.println("                 .',_..,");
            System.out.println("               ,'     /,--");
            System.out.println("             .'       ,./.__");
            System.out.println("             |_,.----/,,'`.  _");
            System.out.println("            .'__     //    `...>");
            System.out.println("       ____//|) |    `      /.'");
            System.out.println("      (/    `-.-'.._     _,|                 ,.-------.._");
            System.out.println("      .             `.  '   \\               /            `-._");
            System.out.println("      `..---._       |       `.            j                 `.");
            System.out.println("        >-,-\"`\"\"'    |        |`\"+-..__    |              -. `-.");
            System.out.println("       ( /|         /____     |  |  |  \\\"\"|+-.._     ___    `.  `.");
            System.out.println("        \" `-..._     \"--,_    |  |  `   | |   | `.-.\"   \"-._  |  -`");
            System.out.println("             ,'        '_>_   j ,'  '. ,` |,  |   `. `.-v.' `-+..._`.");
            System.out.println("            '.         >       '     | |  ' \\ L     ..`.  '        `._");
            System.out.println("             '.       /              '|`     \\|      '^,         ..,{ `.");
            System.out.println("            / /      /                '       v          |__    ___,'\"\"");
            System.out.println("          ,'  >---+-+.        |   __,..--\"`-._          /.-'`\"----'");
            System.out.println("         /`.       `. '.      |-\"'            `\"--....-'._");
            System.out.println("       .'___'        `._`,    j             ___,-','      `-..._");
            System.out.println("  _ _.'    '/.-          '  ,'       __..<\"\"__,.-'              `.");
            System.out.println(" `.)         |'---\"\"`.+-.--'-------\"\"-...__  ,-'/ .\"\\          _  |");
            System.out.println(",\"\\ ,--.  _,-          ` `'                `'\"\"\"'`\"'\"\"\"`--._  . `/");
            System.out.println(" `-`.___.'                                                  `\"-\"'");
        } else if (pokemonEncontrado.getNombre() == "ARCANINE") {
            System.out.println("            /  ,'(");
            System.out.println("           /`-'   \\__.,");
            System.out.println("         ,'     .-\"\\ `---/                     /");
            System.out.println("      |`'      /,'||    '.               ,`. ,(,_. _,");
            System.out.println("  __  |  ,--+--.  ||     `'/  .     _.-\"'   `    \"\"`.");
            System.out.println(".\" ,'-'.\"d__|  `.'_'    _,-    ,.  /        ._      `\\_");
            System.out.println("|,'     `-..-----\"._     `.     ` |           `.     \\.");
            System.out.println(" `\"V\"--._           `.   `._    ' |             \\     \\,");
            System.out.println("  \\      `----      '. _,-'    ,' |              \\     .");
            System.out.println("   `._             .--`       `.  |               .    |");
            System.out.println("      `-.          `,.       ,--  |               L    '");
            System.out.println("        /   [-,=.---' `.__`,`     `.              |     \\");
            System.out.println("    _.-'    `.._'--.._   - `--+\"\"\"\" '._           |      `._,");
            System.out.println("    \\        _  ---..__`--._'-.`,  ,' ,`._       j         -,'");
            System.out.println("   .'        ,-..     ,'    `. `  . ,'  / `._   /`._    ___,-'_");
            System.out.println("   l        .|_  `,  -' . .-\"      v   /   _.`.'`   7\",',-,.-\" --,");
            System.out.println("    \\      `.  .,  -..',')'\"\",   .    /  .'    |  ,'.',/| ,.     >");
            System.out.println("     V-.    '    -._,-\"    _,  .,'   j ,^    ,'/`--' `    -..,   `...");
            System.out.println("     '  \\/\\|.     :/       './`'|    |/    ,' /            `___    ,'");
            System.out.println("           | `. ,'`-.        /  |    ' _.-'  |               ,'  .\"");
            System.out.println("           L._`.'   |       Y,.'|    ,-    ,-'          __.,'  .'");
            System.out.println("            \\ \\  /`.|     _,.',''.  .`-,../         ,.-/,...-`'");
            System.out.println("             \\ ,|| |/_.-\\\" .+'    \\._  _,'       _.'\"  |");
            System.out.println("              '  ' L| | `,' |      `.\"\"          ,.    |");
            System.out.println("              )    `|\"      |        `>.. _,..--\" j    |");
            System.out.println("           ,-'      |____,..'       ,',-\"'       /   _,'");
            System.out.println("          /\"'    _,.'               |(      _..-' `\"\"");
            System.out.println("          `----\"'                    `'\"\"'\"\" ");
        } else if (pokemonEncontrado.getNombre() == "BELLSPROUT") {
            System.out.println("                _.--\"'\"\"\"--._");
            System.out.println("              .\"             `.");
            System.out.println("             /                 .");
            System.out.println("            j                   .");
            System.out.println("            |                   |");
            System.out.println("            |                   |");
            System.out.println("            | (')              j");
            System.out.println("            `                 ,`.");
            System.out.println("             \\               ,^. `.");
            System.out.println("              .             /   \\  .");
            System.out.println("              |            /     . |");
            System.out.println("              |          ,'      | |");
            System.out.println("             ,'---..___ /        | |");
            System.out.println("            ' `--..___ \"`.      .  |");
            System.out.println("             `\"--....___.'     /  j__.....__");
            System.out.println("                              /   |         `.");
            System.out.println("                             / _,------._     `.");
            System.out.println("                            /,+_         `.     `.");
            System.out.println("                          ,'    `-.        \\      .");
            System.out.println("                         .         `.       \\      \\");
            System.out.println("                         |           `.     |       \\");
            System.out.println("                         |             `.   |_,..__  .");
            System.out.println("                         |\\              \\  |      `.|");
            System.out.println("                         | `.,--------._  \\ |        `");
            System.out.println("                         |  |           `. \\|");
            System.out.println("                         |  |             `.|");
            System.out.println("                         |  |");
            System.out.println("                         |  |");
            System.out.println("                         |. '");
            System.out.println("                        .' \\ `.");
            System.out.println("                     _,' ,' `. ._");
            System.out.println("   ---====+,______,.\"_.-'     .  `.");
            System.out.println("   _,..==`'_.+'-\"\"\"\"'         / ^.\\`:._");
            System.out.println(" ,=\"/    ,\"            ....==+ /  `\\  `:.");
            System.out.println("'  /    / |               _+:-'    .|   ``.");
            System.out.println("       '  `.           --\"\"        |'     `\\");
            System.out.println("                                   ' ");
        } else if (pokemonEncontrado.getNombre() == "WEEPINBELL") {
            System.out.println("                                    _...._");
            System.out.println("                                  ,'   __ `.");
            System.out.println("                                .'   ,'  `. |");
            System.out.println("                               .   .'      .|");
            System.out.println("                              /   .        ||");
            System.out.println("                          .-\"'\"\"\"-'        ,'");
            System.out.println("                      _,'\"\"\"'\"--._ `.");
            System.out.println("                    .'            `.:");
            System.out.println("                  ,'                `.");
            System.out.println("                 /     _              \\");
            System.out.println("   ..--._       /     ._;              \\");
            System.out.println(" ,'      `.    j                        .");
            System.out.println(".          `.  |                        |");
            System.out.println("|           ,+-' ,-\"\"-.       _.-\"'\"\"\"`\"`._");
            System.out.println("|          : |/ /`.    |    ,'             `.");
            System.out.println("|          |// :  |    |   ,                 '.");
            System.out.println("'    .     |/  '-\"     |  /                    `.");
            System.out.println(" `    \\   ,'    `-...,'  j                       `");
            System.out.println("  '._/_\\.'               |                        `");
            System.out.println("  .'   `\"-._             |                         \\");
            System.out.println("  |         `.           |                          \\");
            System.out.println("  | --+.      `.          .                 ___      .");
            System.out.println("  '   | `.      `.         .           _.-\"\"   `\"._  |");
            System.out.println("   .  '    .      `.        `-.____,.-' /          `.|");
            System.out.println("    .  `    `.      .                  /             `");
            System.out.println("     `. `.    `.     \\                ,");
            System.out.println("       .  .     .     .             ,'");
            System.out.println("        `  `.    `.    .           .");
            System.out.println("         `.  `.    .   |        _,'");
            System.out.println("           `    `. |   |      ,'");
            System.out.println("            `.    `'   |  _.-'");
            System.out.println("              `-.      ;-'");
            System.out.println("                 `--..\" mh");
        } else if (pokemonEncontrado.getNombre() == "VICTREEBEL") {
            System.out.println("                                       ___");
            System.out.println("                                    ,\"\" __\"`.");
            System.out.println("                                   / .'\"   `-`.");
            System.out.println("                                  / /        ` .");
            System.out.println("                            _,.__. /_,...._   \\ \\");
            System.out.println("                         ,-'     |j        `-._\\ \\");
            System.out.println("                      _,'        ||            `._\\");
            System.out.println("                    ,'_,..,.      |        .----._`.");
            System.out.println("                  _,\"'   / /     `'         `.   :`-'");
            System.out.println("                        / j               ,_  \\   `|");
            System.out.println("                       j ,'-._      _..-\"\"' | `.  ||");
            System.out.println("                       | |    `'-.,'        |  |  ||");
            System.out.println("                       | |  _.              ' j   ||");
            System.out.println("                       ' '.'.'         \\\"-./ ,    |'");
            System.out.println("                        ` `/_           \\_/ /     | L");
            System.out.println("                         `._ `-..___,.-'\"_,:      | |");
            System.out.println("                          | `._      _,-' ||      | |");
            System.out.println("                          |`..,+----`.__,\" |      | |");
            System.out.println("                          |                |      | |");
            System.out.println("         _.--\"\"\"\"--._     |               _'    _.+-'\"\"\"'`-._");
            System.out.println("       ,'            `-.  |.-.           , `\\ ,'             `.");
            System.out.println("     ,'                 \\j |  |          `./ /                 `.");
            System.out.println("    / _.--\"\"\"--._        | `-\"               |    _,.-------.._  \\");
            System.out.println("   /.'           `-.    j                    | ,-'             `-.\\");
            System.out.println("  ,'                `-. |                    |'                   '.");
            System.out.println(" /   __                \\|                    /                      `");
            System.out.println("j .'\"  \"-..             |  _         ,\"`.    |           _,.--'\"\"'-. .");
            System.out.println("|/:        `._          / | \\        |  |    |        _,:           \\|");
            System.out.println("` '           `-._    ,'| `.,'       '.-'    `..__,..' '`.   __");
            System.out.println(" '                `\"\"'  '                    ;          `.`.'  \"'--...,'");
            System.out.println("                         .  Y.          /\"','             '-..____,.-'");
            System.out.println("                          `-._         _`-'");
            System.out.println("                              `\"------\" mh");
        } else if (pokemonEncontrado.getNombre() == "MEWTWO") {
            System.out.println("");
            System.out.println("                                               `/:+`                      ```                        ");
            System.out.println("                                              :- .+`     `....``        -+-:/:                      ");
            System.out.println("                                              ./. `/--:::-....--:::::-./:   +.                      ");
            System.out.println("                                               `/.  .`              `.:`  `/.                       ");
            System.out.println("                                                `/                       `+`                        ");
            System.out.println("                                                `o                       /.                         ");
            System.out.println("                                                :-                       /.                         ");
            System.out.println("                                               `+                        ./                         ");
            System.out.println("                                               .:                        `+                         ");
            System.out.println("                                               `+    `.`           `     .+                         ");
            System.out.println("                                                :-`-:``.-`      `..` `-.`/.                         ");
            System.out.println("                                                `+``o/o.` `- `- ```:+-/ ./                          ");
            System.out.println("                                                 :- //Nh/. .:-/ .:hNh--.+`                          ");
            System.out.println("                        `-:::::-`                `+```:+ss::.`:/yoo/.``+`                           ");
            System.out.println("                       `+-`   `.+.              `:+-     ``     `     -:                            ");
            System.out.println("                       /-       .o              +.`./-.            `-:-`                            ");
            System.out.println("                       :/       :+:`           ::  --.-::.` ``. `.::.                               ");
            System.out.println("                        :/-...-/:`./:--..`     o   o    s.::-..::-`                                 ");
            System.out.println("                         `..-+-`    -+:..-:-.` + `.+:---o````.+-                                    ");
            System.out.println("                  `...`      :+      `:/-..-//:+:/:-.` `.--:``-:-.-.                                ");
            System.out.println("                -/:-.-:/-``.:/. -      .s:...-/-````.-:`  `..-:-  `:-                               ");
            System.out.println("               .o`     `o/--.  `o      o`     `o`     `/.      -``  -:                              ");
            System.out.println("        ```    -/       /-      +`     s       o`       +`     ` .:` :-                             ");
            System.out.println("    `-//:::://:-s:`   `:o.``    `.   ``++.`  `:/-`      -/     .- -/  +`                            ");
            System.out.println("  `//-`       `-:os+:::----:::.````-/:-.-:::::. ./`     `+      /  +` :/                            ");
            System.out.println(" .o.   ``...:.    `:+.       `-::::-`            `+.    `+      `  :` :s                            ");
            System.out.println("`o.  `::----:+/`    `+:                           `/:`   /.      `..``/o                            ");
            System.out.println(":+  `+.       -+`     //                            ./-` `::-..-::-` :./`                           ");
            System.out.println("o.  :/         -o`     /+                             -/.    `    `  /..:                           ");
            System.out.println("y   +.          :+      //                             `::        /. :-`/                           ");
            System.out.println("y   +.           //      o-                              +.       `o``+`/`                          ");
            System.out.println("s`  /:            +/     .o                              -/        .+ .+./`                         ");
            System.out.println("+-  .o             /+`    s.                             -:         -- .+.+`                        ");
            System.out.println("-+   +-             -o:   s`                        ./::-:` .`       `  `/:o`                       ");
            System.out.println(" o`  `o.              -///-                      `:/-        ``       ````-/o:                      ");
            System.out.println(" .o   `o`                                      `//`              .:-::::::/++s+                     ");
            System.out.println("  :/   `+-                                    -+`                 -:        :+:+-                   ");
            System.out.println("   //    :+`                                 :/`                   +         `o-:+`                 ");
            System.out.println("    :+`   `//`                              :/                     o          `s`-o`                ");
            System.out.println("     -+`    .//-                           -+                     .o           o. -+                ");
            System.out.println("      `+-     `-/:-.                     `-s                      +-           o.  /:               ");
            System.out.println("       `//`      `.-:::---.....-------::::s.                     .o           `s   `s               ");
            System.out.println("         .+:`         ````......``````   :/                     `o.           //    s`              ");
            System.out.println("           -/:`                         `o`                     +-           .o`    s`              ");
            System.out.println("             ./:`                       -/                    `+-           `o.     s`              ");
            System.out.println("               .:/-`                    +.                   `+-           `o-      s               ");
            System.out.println("                 `-/:.`                 o`                  .+-           -+.      `o               ");
            System.out.println("                    `-/:-.`             o`                `//`          ./:`       :-               ");
            System.out.println("                       `.-:::-.``       :`              `:/.          .//.        ./                ");
            System.out.println("                            `.--::::-.-:+`            .:/.         `-/:.        .::`                ");
            System.out.println("                                  `.://:`          `.//.        `-:/-`       .-/-`                  ");
            System.out.println("                                  -/-`          `-/+:.````...-:/s:.      `.-/-.                     ");
            System.out.println("                                 `o         .::::-:---------..` o       `+-`                        ");
            System.out.println("                                  o`      `-:-`                 ::      .+                          ");
            System.out.println("                                  o`     ./.                     +`     +.                          ");
            System.out.println("                                 `o     .o`                      +.     +                           ");
            System.out.println("                                 ::     o.                      `o`     /`                          ");
            System.out.println("                                `o`    :+                      `+-      `+-                         ");
            System.out.println("                                :/     y`                    ./o/-`      `:/.                       ");
            System.out.println("                               `o`     h/-                  -+. `-s`       `//.`                    ");
            System.out.println("                              `o.      y`o`                 o`    o.         `:/:`                  ");
            System.out.println("                              /:       s.o.                 -o.``:s.`           .:/:.`       ````   ");
            System.out.println("                             :/        :o-                   `///-`-:/:.         ...:///::::/::://` ");
            System.out.println("                            :/         `o.`..``                       .:+.        .-:/::/++-`    .+:");
            System.out.println("                           -+  `://`    `/:..::/-                       `+:`               -+-    `s");
            System.out.println("                          -o      -+            //                        -//:.```         `/o-:--:.");
            System.out.println("                          /:     `/o-:::::::`   `s                           `-:::::::::--:-`       ");
            System.out.println("                           :/::://-        `:////-  ");
        }else if (pokemonEncontrado.getNombre() == "TAUROS" ) {
            System.out.println("(\"                                                           .'`.'\\n\");\n" +
"    (\"                                                          `     '\\n\");\n" +
"    (\"                                             ,-'.`.        `    ``\\n\");\n" +
"    (\"            '\\\"--.                          /'      \\\\        |    |\\n\");\n" +
"    (\"             \\\\   `                         '.      `.      ',    '\\n\");\n" +
"    (\"              .   |                          `- _,.\\\"-._-._   `. /\\n\");\n" +
"    (\"              '   |,`.----.                            \\\"-.`.  |'\\n\");\n" +
"    (\" ,\\\".        .'    '       '---.                            \\\\\\\\ ||\\n\");\n" +
"    (\" | :     ,-'|    .             '                            ..||\\n\");\n" +
"    (\" |  `._.',||`._.'|              \\\\.                          ||||\\n\");\n" +
"    (\" `.   / ._| `-...'\\\\              \\\\`._                       |. '\\n\");\n" +
"    (\"  _,-'             . `--.         \\\\  `.                     '.'\\n\");\n" +
"    (\".\\\" .'             _|     `-`\\\".     .   `.                 .'.\\n\");\n" +
"    (\" '-....'          |           `-. _.'    `._           _.','\\n\");\n" +
"    (\"  `.             .'                .-       `.       .'_,'\\n\");\n" +
"    (\"    `..__....._ `.               ,'           `-._ .',\\\"\\n\");\n" +
"    (\"          /    `.|               '                `.'....__\\n\");\n" +
"    (\"         .                   _:.]                   `\\\"''-._`.\\n\");\n" +
"    (\"         '                 :\\\"    '                   `.    `. .\\n\");\n" +
"    (\"          \\\\                |                                 `.`.\\n\");\n" +
"    (\"           .               |                           .       ` .\\n\");\n" +
"    (\"           |               '         |                          ` .\\n\");\n" +
"    (\"           '.             .          |                  '        .|\\n\");\n" +
"    (\"             |`.          |          |                  |        ||\\n\");\n" +
"    (\"             |  `.        '          '                  |       . '\\n\");\n" +
"    (\"             |    \\\"--.     |        /_                  |     -'   |\\n\");\n" +
"    (\"             |        `.   |       /  `'\\\"\\\"`-._          |    ,'    |\\n\");\n" +
"    (\"             '        ,\\\"'..|      .      '    `.        |    |.    |\\n\");\n" +
"    (\"              .     ,'     '.     |\\\\    .       `       |      | ,/\\n\");\n" +
"    (\"              |    /        |     | .   |        `.     |      `'\\n\");\n" +
"    (\"              |   .         |    ,' |  .           \\\\    |\\n\");\n" +
"    (\"              |   |         |    .  | .'            .__ '\\n\");\n" +
"    (\"              '-..|         |___.   '\\\"              |../\\n\");\n" +
"    (\"             /.-'           \\\\ .'\\n\");"); 
        }else if (pokemonEncontrado.getNombre() == "DITTO" ) {
            System.out.println("(\"                                           ,--._\\n\");\n" +
"    (\"                                        _,'     `.\\n\");\n" +
"    (\"                              ,.-------\\\"          `.\\n\");\n" +
"    (\"                             /                 \\\"    `-.__\\n\");\n" +
"    (\"                            .         \\\"        _,        `._\\n\");\n" +
"    (\"                            |            __..-\\\"             `.\\n\");\n" +
"    (\"                            |        ''\\\"'                     `._\\n\");\n" +
"    (\"                            |                                    `\\\"-.\\n\");\n" +
"    (\"                            '                                        `.\\n\");\n" +
"    (\"                           .                                          |\\n\");\n" +
"    (\"                          /                                           |\\n\");\n" +
"    (\"                       _,'                                           ,'\\n\");\n" +
"    (\"                     ,\\\"                                             /\\n\");\n" +
"    (\"                    .                                              /\\n\");\n" +
"    (\"                    |                                             /\\n\");\n" +
"    (\"                    |                                            .\\n\");\n" +
"    (\"                    '                                            |\\n\");\n" +
"    (\"                     `.                                          |\\n\");\n" +
"    (\"                       `.                                        |\\n\");\n" +
"    (\"                         `.                                      '\\n\");\n" +
"    (\"                           .                                      .\\n\");\n" +
"    (\"                           |                                       `.\\n\");\n" +
"    (\"                           '                                        |\\n\");\n" +
"    (\"                         ,'                                         |\\n\");\n" +
"    (\"                       ,'                                           '\\n\");\n" +
"    (\"                      /                                _...._      /\\n\");\n" +
"    (\"                     .                              ,-'      `\\\"'--'\\n\");\n" +
"    (\"      ___            |                            ,'\\n\");\n" +
"    (\"   ,-'   `\\\"-._     _.'                          ,'\\n\");\n" +
"    (\"  /           `\\\"--'             _,....__     _,'\\n\");\n" +
"    (\" '                            .'        `---'\\n\");\n" +
"    (\" `                 ____     ,'\\n\");\n" +
"    (\"  .           _.-'\\\"    `---'\\n\");"); 
        }else if (pokemonEncontrado.getNombre() == "SNORLAX" ) {
            System.out.println(" (\"      ::                                              \\n\");\n" +
"    (\"      HHH:                   :HH                      \\n\");\n" +
"    (\"      HHHHH:               :HHHH                      \\n\");\n" +
"    (\"      HHHHHH: :HHHHHHHHH: :HHHHH                      \\n\");\n" +
"    (\"      HHHHHHHHHHHHHHHHHHH:HHHHHH                      \\n\");\n" +
"    (\"      :HHHHHHHHHHHHHHHHHHHHHHHHH                      \\n\");\n" +
"    (\"      ,HHHHHHHH:,,,,:HHHH:,,:HHH                      \\n\");\n" +
"    (\"       HHHHHH:,      ,:H:    ,:H                      \\n\");\n" +
"    (\"       HHHHH:,  :HH:  ,:  :H: ,:                      \\n\");\n" +
"    (\"      :HHHH:,,:H             :H,:                     \\n\");\n" +
"    (\"      HHHHH,,,,       :::       H                     \\n\");\n" +
"    (\"      HHHH:,,,,      :::::      :,                    \\n\");\n" +
"    (\"      HHHH,,,,,,    ,:::::,     ,:                    \\n\");\n" +
"    (\"     ,HHHH,,,,,,,   H::,,:H     ,H,                   \\n\");\n" +
"    (\"     :HHHH,,,,,,,,  H: ,, H    ,,HH:,:HHHH:,          \\n\");\n" +
"    (\"     H:::HHHH:,,,,,:HHHHHHHHHHHH:HHHHHHHHHHH:         \\n\");\n" +
"    (\"    ::HHHH:,:H:,:HH::,,         ,:HHH ,HHHHHH:        \\n\");\n" +
"    (\"   :HHHHHHHH:, HH::,,             ,:H :HHHHHHH:       \\n\");\n" +
"    (\"  :HHHHHHHHHHHHH:,,,               ,:HH:,, HHHH:      \\n\");\n" +
"    (\"  HHHHHHHHHHHH:, :,                  :H,,  HHHHH      \\n\");\n" +
"    (\" ,HHHHHHHHHHHHH: H,                   :H  :HHHHH:     \\n\");\n" +
"    (\" :HHHHHHHHHHHHHH:,                     :HHHHHHHHH     \\n\");\n" +
"    (\" HHHHHHHHHHHHHH,,,                      :HHHHHHHH     \\n\");\n" +
"    (\",HHHHHHHHHHHHH:,,,,                     ,:HHHHHH:     \\n\");\n" +
"    (\":HHHHHHHHHHHH:,,,,,,                    ,,HHH: HHH:   \\n\");\n" +
"    (\"HHHHHHHHHHHH:,,,,,,:,                   ,,HHH, HH,H H:\\n\");\n" +
"    (\"HHHHHHHHHHHH,,:,,,H H,                 ,,:HH:,,:, H:,H\\n\");\n" +
"    (\"HHHHHHHHHHH:,: :,:   :,,H:            ,,,H::::H :H:, H\\n\");\n" +
"    (\"HHHHHHHHHHH,,H  HH,  H:H,H,,        ,,,,:H::,,     : :\\n\");\n" +
"    (\"HHHHHHHHHHH,:,  ::,, :H, H,,,,,,,,,,,,,,H::,,      ,: \\n\");\n" +
"    (\":HHHHHHHHHHHH,,:,,:H:,:, :,,,,,,,,,,,,,:H:,,,       H \\n\");\n" +
"    (\",HHHHHHHHHH:,:H,      ,:H,,,,,,,,,,,,,:H::,,        : \\n\");\n" +
"    (\" HHHHHHHHHH,,,,         ,:,,,,,,,,:HHHHH:,,,   ,:,  ,:\\n\");\n" +
"    (\" HHHHHHHHHH,,,           H,,,:HHHHHHHHHH:,,   ,:::,  H\\n\");\n" +
"    (\" HHHHHHHHH:,,,   ,:::,   :::HHHHHHHHHHHH:,,   :::::  H\\n\");\n" +
"    (\" HHHHHHHHH,,,    :::::,  ,HHHHHHHHHHHHHH:,,   :::::  H\\n\");\n" +
"    (\" HHHHHHHHH,,,   ,::::::   HHHHHHHHHHHHHH:,,   ::::, ,:\\n\");\n" +
"    (\" HHHHHHHHH,,,   :::::::   HHHHHHHHHHHHHH:,,   ,::,  : \\n\");\n" +
"    (\" HHHHHHHHH,,,   :::::::   HHHHHHHHHHHHHH:,,    ,,   H \\n\");\n" +
"    (\" :HHHHHHHH,,,   :::::::   HHHHHHHHHHHHHH:,,,       ,: \\n\");\n" +
"    (\" ,HHHHHHHH,,,   ::::::,   HHHHHHHHHHHHHHH:,,      ,:  \\n\");\n" +
"    (\"  HHHHHHHH,,,   ,:::::   ,HHHHHHHHHHHHHHH:,,,,  ,,H   \\n\");\n" +
"    (\"  :HHHHHHH,,,    ,:::,   :HHHHHHHHHHHHHHHH:,,,,,H:    \\n\");\n" +
"    (\"   :HHHHHH:,,,    ,:,   ,HHHHHHHHHHHHHHHHHHHHHH:      \\n\");\n" +
"    (\"    :HHHHHH,,,          :HHHHHHHHHHHHHHHHHH:,         \\n\");\n" +
"    (\"     :HHHHH:,,,        ,HHHHHHHHH:,                   \\n\");\n" +
"    (\"      :HHHHH:,,,      ,:HHHHHH:,                      \\n\");\n" +
"    (\"        H:HHH:,,,    ,:HH:,                           \\n\");\n" +
"    (\"              :HHHHHH:\\n\");");
        } 
        
        tiempoEspera();
        tiempoEspera();
        System.out.println(pokemonEncontrado);
    }
    //METODO QUE RECREA LA ANIMACION DE CAMINAR POR LA HIERBA

    private void caminandoHierba() {
        for (int i = 0; i < 3; i++) {
            
        imprimirEspacios();
        imprimirEspacios();
        System.out.println("          /\\");
        System.out.println("         /**\\");
        System.out.println("        /****\\   /\\");
        System.out.println("       /      \\ /**\\");
        System.out.println("      /  /\\    /    \\        /\\    /\\  /\\      /\\            /\\/\\/\\  /\\");
        System.out.println("     /  /  \\  /      \\      /  \\/\\/  \\/  \\  /\\/  \\/\\  /\\  /\\/ / /  \\/  \\");
        System.out.println("    /  /    \\/ /\\     \\    /    \\ \\  /    \\/ /   /  \\/  \\/  \\  /    \\   \\");
        System.out.println("   /  /      \\/  \\/\\   \\  /      \\    /   /    \\");
        System.out.println("__/__/_______/___/__\\___\\__________________________________________________");
        System.out.println("CAMINANDO POR LA HIERBA ALTA...");
        tiempoEspera();
        imprimirEspacios();
        imprimirEspacios();
        System.out.println("             /\\");
        System.out.println("            /**\\");
        System.out.println("           /****\\   /\\");
        System.out.println("          /      \\ /**\\");
        System.out.println("         /  /\\    /    \\        /\\    /\\  /\\      /\\            /\\/\\/\\  /\\");
        System.out.println("        /  /  \\  /      \\      /  \\/\\/  \\/  \\  /\\/  \\/\\  /\\  /\\/ / /  \\/  \\");
        System.out.println("       /  /    \\/ /\\     \\    /    \\ \\  /    \\/ /   /  \\/  \\/  \\  /    \\   \\");
        System.out.println("      /  /      \\/  \\/\\   \\  /      \\    /   /    \\");
        System.out.println("_____/__/_______/___/__\\___\\__________________________________________________");
        System.out.println("CAMINANDO POR LA HIERBA ALTA...");
        tiempoEspera();
        }
        System.out.println("\n\n\t\t\t\tCHOCASTE CONTRA ALGO!!!...");
        tiempoEspera();
    }
    //METODO QUE RECIBE EL ARRAY LIST DE POKEMONS, EVALUA ESTADISTICAS DE POKEMONS CAPTURADOS Y MUESTRA PUNTUACION FINAL.

    public void puntuacionCaptura(ArrayList<Pokemon> pokemons) {
        int sumaAtaque = 0;
        int sumaDefensa = 0;
        int sumaNivel = 0;
        int puntuacionTotal = 0;

        for (Pokemon pokemon : equipo) {
            sumaAtaque += pokemon.getPuntosAtaque();
            sumaDefensa += pokemon.getPuntosDefensa();
            sumaNivel += pokemon.getNivel();
        }

        int longitud = equipo.size();
        puntuacionTotal = (sumaAtaque + sumaDefensa + sumaNivel) / longitud;

        System.out.println("SUMA DE ATAQUE: " + sumaAtaque);
        System.out.println("SUMA DE DEFENSA: " + sumaDefensa);
        System.out.println("SUMA DE VELOCIDAD: " + sumaNivel);
        System.out.println("PUNTUACION DE CAPTURA: " + puntuacionTotal + "/297");

    }

    private void dibujoPokemonCombate(ArrayList<Pokemon> pokemon) {
        if (pokemon.get(0).nombre == "CHARMANDER") {
            System.out.println("              _.--\"\"`-..");
            System.out.println("            ,'          `.");
            System.out.println("          ,'          __  `.");
            System.out.println("         /|          \" __   \\");
            System.out.println("        , |           / |.   .");
            System.out.println("        |,'          !_.'|   |");
            System.out.println("      ,'             '   |   |");
            System.out.println("     /              |`--'|   |");
            System.out.println("    |                `---'   |");
            System.out.println("     .   ,                   |                       ,\".");
            System.out.println("      ._     '           _'  |                    , ' \\ `");
            System.out.println("  `.. `.`-...___,...---\"\"    |       __,.        ,`\"   L,|");
            System.out.println("  |, `- .`._        _,-,.'   .  __.-'-. /        .   ,    \\");
            System.out.println("-:..     `. `-..--_.,.<       `\"      / `.        `-/ |   .");
            System.out.println("  `,         \"\"\"\"'     `.              ,'         |   |  ',,");
            System.out.println("    `.      '            '            /          '    |'. |/");
            System.out.println("      `.   |              \\       _,-'           |       ''");
            System.out.println("        `._'               \\   '\"\\                .      |");
            System.out.println("           |                '     \\                `._  ,'");
            System.out.println("           |                 '     \\                 .'|");
            System.out.println("           |                 .      \\                | |");
            System.out.println("           |                 |       L              ,' |");
            System.out.println("           `                 |       |             /   '");
            System.out.println("            \\                |       |           ,'   /");
            System.out.println("          ,' \\               |  _.._ ,-..___,..-'    ,'");
            System.out.println("         /     .             .      `!             ,j'");
            System.out.println("        /       `.          /        .           .'/");
            System.out.println("       .          `.       /         |        _.'.'");
            System.out.println("        `.          7`'---'          |------\"'_.'");
            System.out.println("       _,.`,_     _'                ,''-----\"'");
            System.out.println("   _,-_    '       `.     .'      ,\\");
            System.out.println("   -\" /`.         _,'     | _  _  _.|");
            System.out.println("    \"\"--'---\"\"\"\"\"'        `' '! |! /");
            System.out.println("                            `\" \" -' ");
            System.out.println("");
            System.out.println("");
        } else if (pokemon.get(0).nombre == "CHARMELEON") {
            System.out.println("                      ,-'`\\");
            System.out.println("                  _,\"'    j");
            System.out.println("           __....+       /               .");
            System.out.println("       ,-'\"             /               ; `-._.'.");
            System.out.println("      /                (              ,'       .'");
            System.out.println("     |            _.    \\             \\   ---._ `-.");
            System.out.println("     ,|    ,   _.'  Y    \\             `- ,'   \\   `.`.");
            System.out.println("     l'    \\ ,'._,\\ `.    .              /       ,--. l");
            System.out.println("  .,-        `._  |  |    |              \\       _   l .");
            System.out.println(" /              `\"--'    /              .'       ``. |  )");
            System.out.println(".\\    ,                 |                .        \\ `. '");
            System.out.println("`.                .     |                '._  __   ;. \\'");
            System.out.println("  `-..--------...'       \\                  `'  `-\"'.  \\");
            System.out.println("      `......___          `._                        |  \\");
            System.out.println("               /`            `..                     |   .");
            System.out.println("              /|                `-.                  |    L");
            System.out.println("             / |               \\   `._               .    |");
            System.out.println("           ,'  |,-\"-.   .       .     `.            /     |");
            System.out.println("         ,'    |     '   \\      |       `.         /      |");
            System.out.println("       ,'     /|       \\  .     |         .       /       |");
            System.out.println("     ,'      / |        \\  .    +          \\    ,'       .'");
            System.out.println("    .       .  |         \\ |     \\          \\_,'        / j");
            System.out.println("    |       |  L          `|      .          `        ,' '");
            System.out.println("    |    _. |   \\          /      |           .     .' ,'");
            System.out.println("    |   /  `|    \\        .       |  /        |   ,' .'");
            System.out.println("    |   ,-..\\     -.     ,        | /         |,.' ,'");
            System.out.println("    `. |___,`    /  `.   /`.       '          |  .'");
            System.out.println("      '-`-'     j     ` /.\"7-..../|          ,`-'");
            System.out.println("                |        .'  / _/_|          .");
            System.out.println("                `,       `\"'/\"'    \\          `.");
            System.out.println("                  `,       '.       `.         |");
            System.out.println("             __,.-'         `.        \\'       |");
            System.out.println("            /_,-'\\          ,'        |        _.");
            System.out.println("             |___.---.   ,-'        .-':,-\"`\\,' .");
            System.out.println("                  L,.--\"'           '-' |  ,' `-.\\");
            System.out.println("                                        `.' ");
        } else if (pokemon.get(0).nombre == "CHARIZARD") {
            System.out.println("                 .\"-,.__");
            System.out.println("                 `.     `.  ,");
            System.out.println("              .--'  .._,'\"-' `.");
            System.out.println("             .    .'         `'");
            System.out.println("             `.   /          ,'");
            System.out.println("               `  '--.   ,-\"'");
            System.out.println("                `\"`   |  \\");
            System.out.println("                   -. \\, |");
            System.out.println("                    `--Y.'      ___.");
            System.out.println("                         \\     L._, \\");
            System.out.println("               _.,        `.   <  <\\                _");
            System.out.println("             ,' '           `, `.   | \\            ( `");
            System.out.println("          ../, `.            `  |    .\\`.           \\ \\_");
            System.out.println("         ,' ,..  .           _.,'    ||\\l            )  '\".");
            System.out.println("        , ,'   \\           ,'.-.`-._,'  |           .  _._`.");
            System.out.println("      ,' /      \\ \\        `' ' `--/   | \\          / /   ..\\");
            System.out.println("    .'  /        \\ .         |\\__ - _ ,'` `        / /     `.`.");
            System.out.println("    |  '          ..         `-...-\"  |  `-'      / /        . `.");
            System.out.println("    | /           |L__           |    |          / /          `. `.");
            System.out.println("   , /            .   .          |    |         / /             ` `");
            System.out.println("  / /          ,. ,`._ `-_       |    |  _   ,-' /               ` \\");
            System.out.println(" / .           \\\"`_/. `-_ \\_,.  ,'    +-' `-'  _,        ..,-.    \\`.");
            System.out.println(".  '         .-f    ,'   `    '.       \\__.---'     _   .'   '     \\ \\");
            System.out.println("' /          `.'    l     .' /          \\..      ,_|/   `.  ,'`     L`");
            System.out.println("|'      _.-\"\"` `.    \\ _,'  `            \\ `.___`.'\"`-.  , |   |    | \\");
            System.out.println("||    ,'      `. `.   '       _,...._        `  |    `/ '  |   '     .|");
            System.out.println("||  ,'          `. ;.,.---' ,'       `.   `.. `-'  .-' /_ .'    ;_   ||");
            System.out.println("|| '              V      / /           `   | `   ,'   ,' '.    !  `. ||");
            System.out.println("||/            _,-------7 '              . |  `-'    l         /    `||");
            System.out.println(". |          ,' .-   ,' ||               | .-.        `.      .'     ||");
            System.out.println(" `'        ,'    `\".'    |               |    `.        '. -.'       `'");
            System.out.println("          /      ,'      |               |,'    \\-.._,.'/'");
            System.out.println("          .     /        .               .       \\    .''");
            System.out.println("        .`.    |         `.             /         :_,'.'");
            System.out.println("          \\ `...\\   _     ,'-.        .'         /_.-'");
            System.out.println("           `-.__ `,  `'   .  _.>----''.  _  __  /");
            System.out.println("                .'        /\"'          |  \"'   '_");
            System.out.println("               /_|.-'\\ ,\".             '.'`__'-( \\");
            System.out.println("                 / ,\"'\"\\,'               `/  `-.|\" ");
        } else if (pokemon.get(0).nombre == "SQUIRTLE") {
            System.out.println("            ,-'            \"`-.");
            System.out.println("          ,'                   `-.");
            System.out.println("        ,'                        \\");
            System.out.println("      ,'                           .");
            System.out.println("      .'\\               ,\"\".       `");
            System.out.println("     ._.'|             / |  `       \\");
            System.out.println("     |   |            `-.'  ||       `.");
            System.out.println("     |   |            '-._,'||       | \\");
            System.out.println("     .`.,'             `..,'.'       , |`-.");
            System.out.println("     l                       .'`.  _/  |   `.");
            System.out.println("     `-.._'-   ,          _ _'   -\" \\  .     `");
            System.out.println("`.\"\"\"\"\"'-.`-...,---------','         `. `....__.");
            System.out.println(".'        `\"-..___      __,'\\          \\  \\     \\");
            System.out.println("\\_ .          |   `\"\"\"\"'    `.           . \\     \\");
            System.out.println("  `.          |              `.          |  .     L");
            System.out.println("    `.        |`--...________.'.        j   |     |");
            System.out.println("      `._    .'      |          `.     .|   ,     |");
            System.out.println("         `--,\\       .            `7\"\"' |  ,      |");
            System.out.println("            ` `      `            /     |  |      |    _,-'\"\"\"`-.");
            System.out.println("             \\ `.     .          /      |  '      |  ,'          `.");
            System.out.println("              \\  v.__  .        '       .   \\    /| /              \\");
            System.out.println("               \\/    `\"\"\\\"\"\"\"\"\"\"`.       \\   \\  /.''                |");
            System.out.println("                `        .        `._ ___,j.  `/ .-       ,---.     |");
            System.out.println("                ,`-.      \\         .\"     `.  |/        j     `    |");
            System.out.println("               /    `.     \\       /         \\ /         |     /    j");
            System.out.println("              |       `-.   7-.._ .          |\"          '         /");
            System.out.println("              |          `./_    `|          |            .     _,'");
            System.out.println("              `.           / `----|          |-............`---'");
            System.out.println("                \\          \\      |          |");
            System.out.println("               ,'           )     `.         |");
            System.out.println("                7____,,..--'      /          |");
            System.out.println("                                  `---.__,--.'");
        } else if (pokemon.get(0).nombre == "WARTORTLE") {
            System.out.println("     __                                _.--'\"7");
            System.out.println("    `. `--._                        ,-'_,-  ,'");
            System.out.println("     ,'  `-.`-.                   /' .'    ,|");
            System.out.println("     `.     `. `-     __...___   /  /     - j");
            System.out.println("       `.     `  `.-\"\"        \" .  /       /");
            System.out.println("         \\     /                ` /       /");
            System.out.println("          \\   /                         ,'");
            System.out.println("          '._'_               ,-'       |");
            System.out.println("             | \\            ,|  |   ...-'");
            System.out.println("             || `         ,|_|  |   | `             _..__");
            System.out.println("            /|| |          | |  |   |  \\  _,_    .-\"     `-.");
            System.out.println("           | '.-'          |_|_,' __!  | /|  |  /           \\");
            System.out.println("   ,-...___ .=                  ._..'  /`.| ,`,.      _,.._ |");
            System.out.println("  |   |,.. \\     '  `'        ____,  ,' `--','  |    /      |");
            System.out.println(" ,`-..'  _)  .`-..___,---'_...._/  .'      '-...'   |      /");
            System.out.println("'.__' \"\"'      `.,------'\"'      ,/            ,     `.._.' `.");
            System.out.println("  `.             | `--........,-'.            .         \\     \\");
            System.out.println("    `-.          .   '.,--\"\"     |           ,'\\        |      .");
            System.out.println("       `.       /     |          L          ,\\  .       |  .,---.");
            System.out.println("         `._   '      |           \\        /  .  L      | /   __ `.");
            System.out.println("            `-.       |            `._   ,    l   .    j |   '  `. .");
            System.out.println("              |       |               `\"' |  .    |   /  '      .' |");
            System.out.println("              |       |                   j  |    |  /  , `.__,'   |");
            System.out.println("              `.      L                 _.   `    j ,'-'           |");
            System.out.println("               |`\"---..\\._______,...,--' |   |   /|'      /        j");
            System.out.println("               '       |                 |   .  / |      '        /");
            System.out.println("                .      .              ____L   \\'  j    -',       /");
            System.out.println("               / `.     .          _,\"     \\   | /  ,-','      ,'");
            System.out.println("              /    `.  ,'`-._     /         \\  i'.,'_,'      .'");
            System.out.println("             .       `.      `-..'             |_,-'      _.'");
            System.out.println("             |         `._      |            ''/      _,-'");
            System.out.println("             |            '-..._\\             `__,.--'");
            System.out.println("            ,'           ,' `-.._`.            .");
            System.out.println("           `.    __      |       \"'`.          |");
            System.out.println("             `-\"'  `\"\"\"\"'            7         `.");
            System.out.println("                                    `---'--.,'\"`' ");
        } else if (pokemon.get(0).nombre == "BLASTOISE") {
            System.out.println("                       _");
            System.out.println("            _,..-\"\"\"--' `,.-\".");
            System.out.println("          ,'      __.. --',  |");
            System.out.println("        _/   _.-\"' |    .' | |       ____");
            System.out.println("  ,.-\"\"'    `-\"+.._|     `.' | `-..,',--.`.");
            System.out.println(" |   ,.                      '    j 7    l \\__");
            System.out.println(" |.-'                            /| |    j||  .");
            System.out.println(" `.                   |         / L`.`\"\"','|\\  \\");
            System.out.println("   `.,----..._       ,'`\"'-.  ,'   \\ `\"\"'  | |  l");
            System.out.println("     Y        `-----'       v'    ,'`,.__..' |   .");
            System.out.println("      `.                   /     /   /     `.|   |");
            System.out.println("        `.                /     l   j       ,^.  |L");
            System.out.println("          `._            L       +. |._   .' \\|  | \\");
            System.out.println("            .`--...__,..-'\"\"'-._  l L  \"\"\"    |  |  \\");
            System.out.println("          .'  ,`-......L_       \\  \\ \\     _.'  ,'.  l");
            System.out.println("       ,-\"`. / ,-.---.'  `.      \\  L..--\"'  _.-^.|   l");
            System.out.println(" .-\"\".'\"`.  Y  `._'   '    `.     | | _,.--'\"     |   |");
            System.out.println("  `._'   |  |,-'|      l     `.   | |\"..          |   l");
            System.out.println("  ,'.    |  |`._'      |      `.  | |_,...---\"\"\"\"\"`    L");
            System.out.println(" /   |   j _|-' `.     L       | j ,|              |   |");
            System.out.println("`--,\"._,-+' /`---^..../._____,.L',' `.             |\\  |");
            System.out.println("   |,'      L                   |     `-.          | \\j");
            System.out.println("            .                    \\       `,        |  |");
            System.out.println("             \\                __`.Y._      -.     j   |");
            System.out.println("              \\           _.,'       `._     \\    |  j");
            System.out.println("              ,-\"`-----\"\"\"\"'           |`.    \\  7   |");
            System.out.println("             /  `.        '            |  \\    \\ /   |");
            System.out.println("            |     `      /             |   \\    Y    |");
            System.out.println("            |      \\    .             ,'    |   L_.-')");
            System.out.println("             L      `.  |            /      ]     _.-^._");
            System.out.println("              \\   ,'  `-7         ,-'      / |  ,'      `-._");
            System.out.println("             _,`._       `.   _,-'        ,',^.-            `.");
            System.out.println("          ,-'     v....  _.`\"',          _:'--....._______,.-'");
            System.out.println("        ._______./     /',,-'\"'`'--.  ,-'  `.");
            System.out.println("                 \"\"\"\"\"`.,'         _\\`----...' mh");
            System.out.println("                        --------\"\"'");
        } else if (pokemon.get(0).nombre == "BULBASAUR") {
            System.out.println("                                           /");
            System.out.println("                        _,.------....___,.' ',.-.");
            System.out.println("                     ,-'          _,.--\"        |");
            System.out.println("                   ,'         _.-'              .");
            System.out.println("                  /   ,     ,'                   `");
            System.out.println("                 .   /     /                     ``.");
            System.out.println("                 |  |     .                       \\.\\");
            System.out.println("       ____      |___._.  |       __               \\ `.");
            System.out.println("     .'    `---\"\"       ``\"-.--\"'`  \\               .  \\");
            System.out.println("    .  ,            __               `              |   .");
            System.out.println("    `,'         ,-\"'  .               \\             |    L");
            System.out.println("   ,'          '    _.'                -._          /    |");
            System.out.println("  ,`-.    ,\".   `--'                      >.      ,'     |");
            System.out.println(" . .'\\'   `-'       __    ,  ,-.         /  `.__.-      ,'");
            System.out.println(" ||:, .           ,'  ;  /  / \\ `        `.    .      .'/");
            System.out.println(" j|:D  \\          `--'  ' ,'_  . .         `.__, \\   , /");
            System.out.println("/ L:_  |                 .  \"' :_;                `.'.'");
            System.out.println(".    \"\"'                  \"\"\"\"\"'                    V");
            System.out.println(" `.                                 .    `.   _,..  `");
            System.out.println("   `,_   .    .                _,-'/    .. `,'   __  `");
            System.out.println("    ) \\`._        ___....----\"'  ,'   .'  \\ |   '  \\  .");
            System.out.println("   /   `. \"`-.--\"'         _,' ,'     `---' |    `./  |");
            System.out.println("  .   _  `\"\"'--.._____..--\"   ,             '         |");
            System.out.println("  | .\" `. `-.                /-.           /          ,");
            System.out.println("  | `._.'    `,_            ;  /         ,'          .");
            System.out.println(" .'          /| `-.        . ,'         ,           ,");
            System.out.println(" '-.__ __ _,','    '`-..___;-...__   ,.'\\ ____.___.'");
            System.out.println(" `\"^--'..'   '-`-^-'\"--    `-^-'`.''\"\"\"\"\"`.,^.`.--' ");
        } else if (pokemon.get(0).nombre == "IVYSAUR") {
            System.out.println("                               ,'\"`.,./.");
            System.out.println("                             ,'        Y',\"..");
            System.out.println("                           ,'           \\  | \\");
            System.out.println("                          /              . |  `");
            System.out.println("                         /               | |   \\");
            System.out.println("            __          .                | |    .");
            System.out.println("       _   \\  `. ---.   |                | j    |");
            System.out.println("      / `-._\\   `Y   \\  |                |.     |");
            System.out.println("     _`.    ``    \\   \\ |..              '      |,-'\"\"7,....");
            System.out.println("     l     '-.     . , `|  | , |`. , ,  /,     ,'    '/   ,'_,.-.");
            System.out.println("     `-..     `-.  : :     |/ `   ' \"\\,' | _  /          '-'    /___");
            System.out.println("      \\\"\"' __.,.-`.: :        /   /._    l'.,'");
            System.out.println("       `--,   _.-' `\".           /__ `'-.' '         .");
            System.out.println("       ,---..._,.--\"\"\"\"\"\"\"--.__..----,-.'   .  /    .'   ,.--");
            System.out.println("       |                          ,':| /    | /     ;.,-'--      ,.-");
            System.out.println("       |     .---.              .'  :|'     |/ ,.-='\"-.`\"`' _   -.'");
            System.out.println("       /    \\    /               `. :|--.  _L,\"---.._        \"----'");
            System.out.println("     ,' `.   \\ ,'           _,     `''   ``.-'       `-  -..___,'");
            System.out.println("    . ,.  .   `   __     .-'  _.-           `.     .__    \\");
            System.out.println("    |. |`        \"  ;   !   ,.  |             `.    `.`'---'");
            System.out.println("    ,| |C\\       ` /    | ,' |(]|            -. |-..--`");
            System.out.println("   /  \"'--'       '      /___|__]        `.  `- |`.");
            System.out.println("  .       ,'                   ,   /       .    `. \\");
            System.out.println("    \\                      .,-'  ,'         .     `-.");
            System.out.println("     x---..`.  -'  __..--'\"/\"\"\"\"\"  ,-.      |   |   |");
            System.out.println("    / \\--._'-.,.--'     _`-    _. ' /       |     -.|");
            System.out.println("   ,   .   `-..__ ...--'  _,.-' | `   ,.-.  ;   /  '|");
            System.out.println("  .  _,'         '\"-----\"\"      |    `   | /  ,'    ;");
            System.out.println("  |-'  .-.    `._               |     `._// ,'     /");
            System.out.println(" _|    `-'   _,' \"`--.._________|        `,'    _ /.");
            System.out.println("//\\   ,-._.'\"/\\__,.   _,\"     /_\\__/`. /'.-.'.-/_,`-' ");
            System.out.println("`-\"`\"' v'    `\"  `-`-\"              `-'`-`  `'");
        } else if (pokemon.get(0).nombre == "VENUSAUR") {
            System.out.println("                           _._       _,._");
            System.out.println("                        _.'   `. ' .'   _`.");
            System.out.println("                ,\"\"\"/`\"\"-.-.,/. ` V'\\-,`.,--/\"\"\".\"-..");
            System.out.println("              ,'    `...,' . ,\\-----._|     `.   /   \\");
            System.out.println("             `.            .`  -'`\"\" .._   :> `-'   `.");
            System.out.println("            ,'  ,-.  _,.-'| `..___ ,'   |'-..__   .._ L");
            System.out.println("           .    \\_ -'   `-'     ..      `.-' `.`-.'_ .|");
            System.out.println("           |   ,',-,--..  ,--../  `.  .-.    , `-.  ``.");
            System.out.println("           `.,' ,  |   |  `.  /'/,,.\\/  |    \\|   |");
            System.out.println("                `  `---'    `j   .   \\  .     '   j");
            System.out.println("              ,__`\"        ,'|`'\\_/`.'\\'        |\\-'-, _,.");
            System.out.println("       .--...`-. `-`. /    '- ..      _,    /\\ ,' .--\"'  ,'\".");
            System.out.println("     _'-\"\"-    --  _`'-.../ __ '.'`-^,_`-\"\"\"\"---....__  ' _,-`");
            System.out.println("   _.----`  _..--.'        |  \"`-..-\" __|'\"'         .\"\"-. \"\"'--.._");
            System.out.println("  /        '    /     ,  _.+-.'  ||._'   \"\"\"\". .          `     .__\\");
            System.out.println(" `---    /        /  / j'       _/|..`  -. `-`\\ \\   \\  \\   `.  \\ `-..");
            System.out.println(",\" _.-' /    /` ./  /`_|_,-\"   ','|       `. | -'`._,   L  \\ .  `.   |");
            System.out.println("`\"' /  /  / ,__...-----| _.,  ,'            `|----.._`-.|' |. .` ..  .");
            System.out.println("   /  '| /.,/   \\--.._ `-,' ,          .  '`.'  __,., '  ''``._ \\ \\`,'");
            System.out.println("  /_,'---  ,     \\`._,-` \\ //  / . \\    `._,  -`,  / / _   |   `-L -");
            System.out.println("   /       `.     ,  ..._ ' `_/ '| |\\ `._'       '-.'   `.,'     |");
            System.out.println("  '         /    /  ..   `.  `./ | ; `.'    ,\"\" ,.  `.    \\      |");
            System.out.println("   `.     ,'   ,'   | |\\  |       \"        |  ,'\\ |   \\    `    ,L");
            System.out.println("   /|`.  /    '     | `-| '                  /`-' |    L    `._/  \\");
            System.out.println("  / | .`|    |  .   `._.'                   `.__,'   .  |     |  (`");
            System.out.println(" '-\"\"-'_|    `. `.__,._____     .    _,        ____ ,-  j     \".-'\"'");
            System.out.println("        \\      `-.  \\/.    `\"--.._    _,.---'\"\"\\/  \"_,.'     /-'");
            System.out.println("         )        `-._ '-.        `--\"      _.-'.-\"\"        `.");
            System.out.println("        ./            `,. `\".._________...\"\"_.-\"`.          _j");
            System.out.println("       /_\\.__,\"\".   ,.'  \"`-...________.---\"     .\".   ,.  / \\");
            System.out.println("              \\_/\"\"\"-'                           `-'--(_,`\"`-` ");
        } else if (pokemon.get(0).nombre == "PSYDUCK") {
            System.out.println("                              ,-'   ,\"\",");
            System.out.println("                             / / ,-'.-'");
            System.out.println("                   _,..-----+-\".\".-'_,..");
            System.out.println("           ,...,.\"'             `--.---'");
            System.out.println("         /,..,'                     `.");
            System.out.println("       ,'  .'                         `.");
            System.out.println("      j   /                             `.");
            System.out.println("      |  /,----._           ,.----.       .");
            System.out.println("     ,  j    _   \\        .'  .,   `.     |");
            System.out.println("   ,'   |        |  ____  |         | .\"--+,^.");
            System.out.println("  /     |`-....-',-'    `._`--....-' _/      |");
            System.out.println(" /      |     _,'          `--..__  `        '");
            System.out.println("j       | ,-\"'    `    .'         `. `        `.");
            System.out.println("|        .\\                        /  |         \\");
            System.out.println("|         `\\                     ,'   |          \\");
            System.out.println("|          |                    |   ,-|           `.");
            System.out.println(".         ,'                    |-\"'  |             \\");
            System.out.println(" \\       /                      `.    |              .");
            System.out.println("  ` /  ,'                        |    `              |");
            System.out.println("   /  /                          |     \\             |");
            System.out.println("  /  |                           |      \\           /");
            System.out.println(" /   |                           |       `.       _,");
            System.out.println(".     .                         .'         `.__,.',.----,");
            System.out.println("|      `.                     ,'             .-\"\"      /");
            System.out.println("|        `._               _.'               |        /");
            System.out.println("|           `---.......,--\"                  |      ,'");
            System.out.println("'                                            '    ,'");
            System.out.println(" \\                                          /   ,'");
            System.out.println("  \\                                        /  ,'");
            System.out.println("   \\                                      / ,'");
            System.out.println("    `.                                   ,+'");
            System.out.println("      >.                               ,'");
            System.out.println("  _.-'  `-.._                      _,-'-._");
            System.out.println(",__          `\",-............,.---\"       `.");
            System.out.println("   \\..---. _,-'            ,'               `.");
            System.out.println("          \"                '..,--.___,-\"\"\"---' ");
        } else if (pokemon.get(0).nombre == "GOLDUCK") {
            System.out.println("                ,|");
            System.out.println("              ,' |         .',");
            System.out.println("             /   |    /\\_,' j");
            System.out.println("            /    |  ,' |    |");
            System.out.println("          ,'     |,'   |   .");
            System.out.println("         /       '    j   j    _,.-/");
            System.out.println("        /      ,'     |   |..-\"  ,'");
            System.out.println("       /              |         /                      `");
            System.out.println("      /               |       ,'");
            System.out.println("    ('  (                 ,\"\"`-.                        /|");
            System.out.println("     | | .              ,'      \\                      / |");
            System.out.println("     | |p'             /        |                     /  |");
            System.out.println("     |.`              '       ,'|-.                 ,'   '");
            System.out.println("     /`\"`\"\"\"'\"`-.    /       .  |. `.___           /    /");
            System.out.println("    /      ,-\"'_|._,'        |  | `.    `\"--..    /    j");
            System.out.println("  ,'     ,',-\"',-'           |,'    `-.       | ,'     |");
            System.out.println(" /     .'.'   /  ,-'|       \\'         `.    ,'/      j");
            System.out.println("|    .','    /  /   |   ,-.  \\           `+-','       '");
            System.out.println("|  .''      .._/   /   /   \\  \\           `.'        /");
            System.out.println(" \\/         | /`\"-.'  /_,..\"\\,\\                     /");
            System.out.println("            '/    |\"|(       \\ .                  ,'");
            System.out.println("                   .| \\       `'                 /");
            System.out.println("                    ' _\\       ,.----\"\"-\\      ,'");
            System.out.println("                 ,-'\"\"  \\    ,'          `   ,'");
            System.out.println("                |        `-.'              ,'");
            System.out.println("                .           \\           _.'");
            System.out.println("                 \\        ___\\         `.");
            System.out.println("                  `.    \"\" `. \\          \\");
            System.out.println("            ,-/\"\"\"\"'._       \\_`.         `.");
            System.out.println("`         _.`-'\"\"            /_`.\\          \\");
            System.out.println("         /.-n+==`       _,,-'\"    \\          \\");
            System.out.println("           ,\\ __.-\"\"\"\"'\"           )          `..__");
            System.out.println("          (,.'                   _/         .._   _\\_");
            System.out.println("          '                    ,\"  _,.-._   -. `_/__ \\");
            System.out.println("                              / ),+....._\\ ,--.\"    `'");
            System.out.println("                             `\"'          `.._ \\");
            System.out.println("                                              `' ");
        } else if (pokemon.get(0).nombre == "GROWLITHE") {
            System.out.println("");
            System.out.println("                   _,");
            System.out.println("                 .',_..,");
            System.out.println("               ,'     /,--");
            System.out.println("             .'       ,./.__");
            System.out.println("             |_,.----/,,'`.  _");
            System.out.println("            .'__     //    `...>");
            System.out.println("       ____//|) |    `      /.'");
            System.out.println("      (/    `-.-'.._     _,|                 ,.-------.._");
            System.out.println("      .             `.  '   \\               /            `-._");
            System.out.println("      `..---._       |       `.            j                 `.");
            System.out.println("        >-,-\"`\"\"'    |        |`\"+-..__    |              -. `-.");
            System.out.println("       ( /|         /____     |  |  |  \\\"\"|+-.._     ___    `.  `.");
            System.out.println("        \" `-..._     \"--,_    |  |  `   | |   | `.-.\"   \"-._  |  -`");
            System.out.println("             ,'        '_>_   j ,'  '. ,` |,  |   `. `.-v.' `-+..._`.");
            System.out.println("            '.         >       '     | |  ' \\ L     ..`.  '        `._");
            System.out.println("             '.       /              '|`     \\|      '^,         ..,{ `.");
            System.out.println("            / /      /                '       v          |__    ___,'\"\"");
            System.out.println("          ,'  >---+-+.        |   __,..--\"`-._          /.-'`\"----'");
            System.out.println("         /`.       `. '.      |-\"'            `\"--....-'._");
            System.out.println("       .'___'        `._`,    j             ___,-','      `-..._");
            System.out.println("  _ _.'    '/.-          '  ,'       __..<\"\"__,.-'              `.");
            System.out.println(" `.)         |'---\"\"`.+-.--'-------\"\"-...__  ,-'/ .\"\\          _  |");
            System.out.println(",\"\\ ,--.  _,-          ` `'                `'\"\"\"'`\"'\"\"\"`--._  . `/");
            System.out.println(" `-`.___.'                                                  `\"-\"'");
        } else if (pokemon.get(0).nombre == "ARCANINE") {
            System.out.println("            /  ,'(");
            System.out.println("           /`-'   \\__.,");
            System.out.println("         ,'     .-\"\\ `---/                     /");
            System.out.println("      |`'      /,'||    '.               ,`. ,(,_. _,");
            System.out.println("  __  |  ,--+--.  ||     `'/  .     _.-\"'   `    \"\"`.");
            System.out.println(".\" ,'-'.\"d__|  `.'_'    _,-    ,.  /        ._      `\\_");
            System.out.println("|,'     `-..-----\"._     `.     ` |           `.     \\.");
            System.out.println(" `\"V\"--._           `.   `._    ' |             \\     \\,");
            System.out.println("  \\      `----      '. _,-'    ,' |              \\     .");
            System.out.println("   `._             .--`       `.  |               .    |");
            System.out.println("      `-.          `,.       ,--  |               L    '");
            System.out.println("        /   [-,=.---' `.__`,`     `.              |     \\");
            System.out.println("    _.-'    `.._'--.._   - `--+\"\"\"\" '._           |      `._,");
            System.out.println("    \\        _  ---..__`--._'-.`,  ,' ,`._       j         -,'");
            System.out.println("   .'        ,-..     ,'    `. `  . ,'  / `._   /`._    ___,-'_");
            System.out.println("   l        .|_  `,  -' . .-\"      v   /   _.`.'`   7\",',-,.-\" --,");
            System.out.println("    \\      `.  .,  -..',')'\"\",   .    /  .'    |  ,'.',/| ,.     >");
            System.out.println("     V-.    '    -._,-\"    _,  .,'   j ,^    ,'/`--' `    -..,   `...");
            System.out.println("     '  \\/\\|.     :/       './`'|    |/    ,' /            `___    ,'");
            System.out.println("           | `. ,'`-.        /  |    ' _.-'  |               ,'  .\"");
            System.out.println("           L._`.'   |       Y,.'|    ,-    ,-'          __.,'  .'");
            System.out.println("            \\ \\  /`.|     _,.',''.  .`-,../         ,.-/,...-`'");
            System.out.println("             \\ ,|| |/_.-\\\" .+'    \\._  _,'       _.'\"  |");
            System.out.println("              '  ' L| | `,' |      `.\"\"          ,.    |");
            System.out.println("              )    `|\"      |        `>.. _,..--\" j    |");
            System.out.println("           ,-'      |____,..'       ,',-\"'       /   _,'");
            System.out.println("          /\"'    _,.'               |(      _..-' `\"\"");
            System.out.println("          `----\"'                    `'\"\"'\"\" ");
        } else if (pokemon.get(0).nombre == "BELLSPROUT") {
            System.out.println("                _.--\"'\"\"\"--._");
            System.out.println("              .\"             `.");
            System.out.println("             /                 .");
            System.out.println("            j                   .");
            System.out.println("            |                   |");
            System.out.println("            |                   |");
            System.out.println("            | (')              j");
            System.out.println("            `                 ,`.");
            System.out.println("             \\               ,^. `.");
            System.out.println("              .             /   \\  .");
            System.out.println("              |            /     . |");
            System.out.println("              |          ,'      | |");
            System.out.println("             ,'---..___ /        | |");
            System.out.println("            ' `--..___ \"`.      .  |");
            System.out.println("             `\"--....___.'     /  j__.....__");
            System.out.println("                              /   |         `.");
            System.out.println("                             / _,------._     `.");
            System.out.println("                            /,+_         `.     `.");
            System.out.println("                          ,'    `-.        \\      .");
            System.out.println("                         .         `.       \\      \\");
            System.out.println("                         |           `.     |       \\");
            System.out.println("                         |             `.   |_,..__  .");
            System.out.println("                         |\\              \\  |      `.|");
            System.out.println("                         | `.,--------._  \\ |        `");
            System.out.println("                         |  |           `. \\|");
            System.out.println("                         |  |             `.|");
            System.out.println("                         |  |");
            System.out.println("                         |  |");
            System.out.println("                         |. '");
            System.out.println("                        .' \\ `.");
            System.out.println("                     _,' ,' `. ._");
            System.out.println("   ---====+,______,.\"_.-'     .  `.");
            System.out.println("   _,..==`'_.+'-\"\"\"\"'         / ^.\\`:._");
            System.out.println(" ,=\"/    ,\"            ....==+ /  `\\  `:.");
            System.out.println("'  /    / |               _+:-'    .|   ``.");
            System.out.println("       '  `.           --\"\"        |'     `\\");
            System.out.println("                                   ' ");
        } else if (pokemon.get(0).nombre == "WEEPINBELL") {
            System.out.println("                                    _...._");
            System.out.println("                                  ,'   __ `.");
            System.out.println("                                .'   ,'  `. |");
            System.out.println("                               .   .'      .|");
            System.out.println("                              /   .        ||");
            System.out.println("                          .-\"'\"\"\"-'        ,'");
            System.out.println("                      _,'\"\"\"'\"--._ `.");
            System.out.println("                    .'            `.:");
            System.out.println("                  ,'                `.");
            System.out.println("                 /     _              \\");
            System.out.println("   ..--._       /     ._;              \\");
            System.out.println(" ,'      `.    j                        .");
            System.out.println(".          `.  |                        |");
            System.out.println("|           ,+-' ,-\"\"-.       _.-\"'\"\"\"`\"`._");
            System.out.println("|          : |/ /`.    |    ,'             `.");
            System.out.println("|          |// :  |    |   ,                 '.");
            System.out.println("'    .     |/  '-\"     |  /                    `.");
            System.out.println(" `    \\   ,'    `-...,'  j                       `");
            System.out.println("  '._/_\\.'               |                        `");
            System.out.println("  .'   `\"-._             |                         \\");
            System.out.println("  |         `.           |                          \\");
            System.out.println("  | --+.      `.          .                 ___      .");
            System.out.println("  '   | `.      `.         .           _.-\"\"   `\"._  |");
            System.out.println("   .  '    .      `.        `-.____,.-' /          `.|");
            System.out.println("    .  `    `.      .                  /             `");
            System.out.println("     `. `.    `.     \\                ,");
            System.out.println("       .  .     .     .             ,'");
            System.out.println("        `  `.    `.    .           .");
            System.out.println("         `.  `.    .   |        _,'");
            System.out.println("           `    `. |   |      ,'");
            System.out.println("            `.    `'   |  _.-'");
            System.out.println("              `-.      ;-'");
            System.out.println("                 `--..\" mh");
        } else if (pokemon.get(0).nombre == "VICTREEBEL") {
            System.out.println("                                       ___");
            System.out.println("                                    ,\"\" __\"`.");
            System.out.println("                                   / .'\"   `-`.");
            System.out.println("                                  / /        ` .");
            System.out.println("                            _,.__. /_,...._   \\ \\");
            System.out.println("                         ,-'     |j        `-._\\ \\");
            System.out.println("                      _,'        ||            `._\\");
            System.out.println("                    ,'_,..,.      |        .----._`.");
            System.out.println("                  _,\"'   / /     `'         `.   :`-'");
            System.out.println("                        / j               ,_  \\   `|");
            System.out.println("                       j ,'-._      _..-\"\"' | `.  ||");
            System.out.println("                       | |    `'-.,'        |  |  ||");
            System.out.println("                       | |  _.              ' j   ||");
            System.out.println("                       ' '.'.'         \\\"-./ ,    |'");
            System.out.println("                        ` `/_           \\_/ /     | L");
            System.out.println("                         `._ `-..___,.-'\"_,:      | |");
            System.out.println("                          | `._      _,-' ||      | |");
            System.out.println("                          |`..,+----`.__,\" |      | |");
            System.out.println("                          |                |      | |");
            System.out.println("         _.--\"\"\"\"--._     |               _'    _.+-'\"\"\"'`-._");
            System.out.println("       ,'            `-.  |.-.           , `\\ ,'             `.");
            System.out.println("     ,'                 \\j |  |          `./ /                 `.");
            System.out.println("    / _.--\"\"\"--._        | `-\"               |    _,.-------.._  \\");
            System.out.println("   /.'           `-.    j                    | ,-'             `-.\\");
            System.out.println("  ,'                `-. |                    |'                   '.");
            System.out.println(" /   __                \\|                    /                      `");
            System.out.println("j .'\"  \"-..             |  _         ,\"`.    |           _,.--'\"\"'-. .");
            System.out.println("|/:        `._          / | \\        |  |    |        _,:           \\|");
            System.out.println("` '           `-._    ,'| `.,'       '.-'    `..__,..' '`.   __");
            System.out.println(" '                `\"\"'  '                    ;          `.`.'  \"'--...,'");
            System.out.println("                         .  Y.          /\"','             '-..____,.-'");
            System.out.println("                          `-._         _`-'");
            System.out.println("                              `\"------\" mh");
        } else if (pokemon.get(0).nombre == "MEWTWO") {
            System.out.println("");
            System.out.println("                                               `/:+`                      ```                        ");
            System.out.println("                                              :- .+`     `....``        -+-:/:                      ");
            System.out.println("                                              ./. `/--:::-....--:::::-./:   +.                      ");
            System.out.println("                                               `/.  .`              `.:`  `/.                       ");
            System.out.println("                                                `/                       `+`                        ");
            System.out.println("                                                `o                       /.                         ");
            System.out.println("                                                :-                       /.                         ");
            System.out.println("                                               `+                        ./                         ");
            System.out.println("                                               .:                        `+                         ");
            System.out.println("                                               `+    `.`           `     .+                         ");
            System.out.println("                                                :-`-:``.-`      `..` `-.`/.                         ");
            System.out.println("                                                `+``o/o.` `- `- ```:+-/ ./                          ");
            System.out.println("                                                 :- //Nh/. .:-/ .:hNh--.+`                          ");
            System.out.println("                        `-:::::-`                `+```:+ss::.`:/yoo/.``+`                           ");
            System.out.println("                       `+-`   `.+.              `:+-     ``     `     -:                            ");
            System.out.println("                       /-       .o              +.`./-.            `-:-`                            ");
            System.out.println("                       :/       :+:`           ::  --.-::.` ``. `.::.                               ");
            System.out.println("                        :/-...-/:`./:--..`     o   o    s.::-..::-`                                 ");
            System.out.println("                         `..-+-`    -+:..-:-.` + `.+:---o````.+-                                    ");
            System.out.println("                  `...`      :+      `:/-..-//:+:/:-.` `.--:``-:-.-.                                ");
            System.out.println("                -/:-.-:/-``.:/. -      .s:...-/-````.-:`  `..-:-  `:-                               ");
            System.out.println("               .o`     `o/--.  `o      o`     `o`     `/.      -``  -:                              ");
            System.out.println("        ```    -/       /-      +`     s       o`       +`     ` .:` :-                             ");
            System.out.println("    `-//:::://:-s:`   `:o.``    `.   ``++.`  `:/-`      -/     .- -/  +`                            ");
            System.out.println("  `//-`       `-:os+:::----:::.````-/:-.-:::::. ./`     `+      /  +` :/                            ");
            System.out.println(" .o.   ``...:.    `:+.       `-::::-`            `+.    `+      `  :` :s                            ");
            System.out.println("`o.  `::----:+/`    `+:                           `/:`   /.      `..``/o                            ");
            System.out.println(":+  `+.       -+`     //                            ./-` `::-..-::-` :./`                           ");
            System.out.println("o.  :/         -o`     /+                             -/.    `    `  /..:                           ");
            System.out.println("y   +.          :+      //                             `::        /. :-`/                           ");
            System.out.println("y   +.           //      o-                              +.       `o``+`/`                          ");
            System.out.println("s`  /:            +/     .o                              -/        .+ .+./`                         ");
            System.out.println("+-  .o             /+`    s.                             -:         -- .+.+`                        ");
            System.out.println("-+   +-             -o:   s`                        ./::-:` .`       `  `/:o`                       ");
            System.out.println(" o`  `o.              -///-                      `:/-        ``       ````-/o:                      ");
            System.out.println(" .o   `o`                                      `//`              .:-::::::/++s+                     ");
            System.out.println("  :/   `+-                                    -+`                 -:        :+:+-                   ");
            System.out.println("   //    :+`                                 :/`                   +         `o-:+`                 ");
            System.out.println("    :+`   `//`                              :/                     o          `s`-o`                ");
            System.out.println("     -+`    .//-                           -+                     .o           o. -+                ");
            System.out.println("      `+-     `-/:-.                     `-s                      +-           o.  /:               ");
            System.out.println("       `//`      `.-:::---.....-------::::s.                     .o           `s   `s               ");
            System.out.println("         .+:`         ````......``````   :/                     `o.           //    s`              ");
            System.out.println("           -/:`                         `o`                     +-           .o`    s`              ");
            System.out.println("             ./:`                       -/                    `+-           `o.     s`              ");
            System.out.println("               .:/-`                    +.                   `+-           `o-      s               ");
            System.out.println("                 `-/:.`                 o`                  .+-           -+.      `o               ");
            System.out.println("                    `-/:-.`             o`                `//`          ./:`       :-               ");
            System.out.println("                       `.-:::-.``       :`              `:/.          .//.        ./                ");
            System.out.println("                            `.--::::-.-:+`            .:/.         `-/:.        .::`                ");
            System.out.println("                                  `.://:`          `.//.        `-:/-`       .-/-`                  ");
            System.out.println("                                  -/-`          `-/+:.````...-:/s:.      `.-/-.                     ");
            System.out.println("                                 `o         .::::-:---------..` o       `+-`                        ");
            System.out.println("                                  o`      `-:-`                 ::      .+                          ");
            System.out.println("                                  o`     ./.                     +`     +.                          ");
            System.out.println("                                 `o     .o`                      +.     +                           ");
            System.out.println("                                 ::     o.                      `o`     /`                          ");
            System.out.println("                                `o`    :+                      `+-      `+-                         ");
            System.out.println("                                :/     y`                    ./o/-`      `:/.                       ");
            System.out.println("                               `o`     h/-                  -+. `-s`       `//.`                    ");
            System.out.println("                              `o.      y`o`                 o`    o.         `:/:`                  ");
            System.out.println("                              /:       s.o.                 -o.``:s.`           .:/:.`       ````   ");
            System.out.println("                             :/        :o-                   `///-`-:/:.         ...:///::::/::://` ");
            System.out.println("                            :/         `o.`..``                       .:+.        .-:/::/++-`    .+:");
            System.out.println("                           -+  `://`    `/:..::/-                       `+:`               -+-    `s");
            System.out.println("                          -o      -+            //                        -//:.```         `/o-:--:.");
            System.out.println("                          /:     `/o-:::::::`   `s                           `-:::::::::--:-`       ");
            System.out.println("                           :/::://-        `:////-  ");
        }else if (pokemon.get(0).getNombre() == "TAUROS" ) {
            System.out.println("(\"                                                           .'`.'\\n\");\n" +
"    (\"                                                          `     '\\n\");\n" +
"    (\"                                             ,-'.`.        `    ``\\n\");\n" +
"    (\"            '\\\"--.                          /'      \\\\        |    |\\n\");\n" +
"    (\"             \\\\   `                         '.      `.      ',    '\\n\");\n" +
"    (\"              .   |                          `- _,.\\\"-._-._   `. /\\n\");\n" +
"    (\"              '   |,`.----.                            \\\"-.`.  |'\\n\");\n" +
"    (\" ,\\\".        .'    '       '---.                            \\\\\\\\ ||\\n\");\n" +
"    (\" | :     ,-'|    .             '                            ..||\\n\");\n" +
"    (\" |  `._.',||`._.'|              \\\\.                          ||||\\n\");\n" +
"    (\" `.   / ._| `-...'\\\\              \\\\`._                       |. '\\n\");\n" +
"    (\"  _,-'             . `--.         \\\\  `.                     '.'\\n\");\n" +
"    (\".\\\" .'             _|     `-`\\\".     .   `.                 .'.\\n\");\n" +
"    (\" '-....'          |           `-. _.'    `._           _.','\\n\");\n" +
"    (\"  `.             .'                .-       `.       .'_,'\\n\");\n" +
"    (\"    `..__....._ `.               ,'           `-._ .',\\\"\\n\");\n" +
"    (\"          /    `.|               '                `.'....__\\n\");\n" +
"    (\"         .                   _:.]                   `\\\"''-._`.\\n\");\n" +
"    (\"         '                 :\\\"    '                   `.    `. .\\n\");\n" +
"    (\"          \\\\                |                                 `.`.\\n\");\n" +
"    (\"           .               |                           .       ` .\\n\");\n" +
"    (\"           |               '         |                          ` .\\n\");\n" +
"    (\"           '.             .          |                  '        .|\\n\");\n" +
"    (\"             |`.          |          |                  |        ||\\n\");\n" +
"    (\"             |  `.        '          '                  |       . '\\n\");\n" +
"    (\"             |    \\\"--.     |        /_                  |     -'   |\\n\");\n" +
"    (\"             |        `.   |       /  `'\\\"\\\"`-._          |    ,'    |\\n\");\n" +
"    (\"             '        ,\\\"'..|      .      '    `.        |    |.    |\\n\");\n" +
"    (\"              .     ,'     '.     |\\\\    .       `       |      | ,/\\n\");\n" +
"    (\"              |    /        |     | .   |        `.     |      `'\\n\");\n" +
"    (\"              |   .         |    ,' |  .           \\\\    |\\n\");\n" +
"    (\"              |   |         |    .  | .'            .__ '\\n\");\n" +
"    (\"              '-..|         |___.   '\\\"              |../\\n\");\n" +
"    (\"             /.-'           \\\\ .'\\n\");"); 
        }else if (pokemon.get(0).getNombre() == "DITTO" ) {
            System.out.println("(\"                                           ,--._\\n\");\n" +
"    (\"                                        _,'     `.\\n\");\n" +
"    (\"                              ,.-------\\\"          `.\\n\");\n" +
"    (\"                             /                 \\\"    `-.__\\n\");\n" +
"    (\"                            .         \\\"        _,        `._\\n\");\n" +
"    (\"                            |            __..-\\\"             `.\\n\");\n" +
"    (\"                            |        ''\\\"'                     `._\\n\");\n" +
"    (\"                            |                                    `\\\"-.\\n\");\n" +
"    (\"                            '                                        `.\\n\");\n" +
"    (\"                           .                                          |\\n\");\n" +
"    (\"                          /                                           |\\n\");\n" +
"    (\"                       _,'                                           ,'\\n\");\n" +
"    (\"                     ,\\\"                                             /\\n\");\n" +
"    (\"                    .                                              /\\n\");\n" +
"    (\"                    |                                             /\\n\");\n" +
"    (\"                    |                                            .\\n\");\n" +
"    (\"                    '                                            |\\n\");\n" +
"    (\"                     `.                                          |\\n\");\n" +
"    (\"                       `.                                        |\\n\");\n" +
"    (\"                         `.                                      '\\n\");\n" +
"    (\"                           .                                      .\\n\");\n" +
"    (\"                           |                                       `.\\n\");\n" +
"    (\"                           '                                        |\\n\");\n" +
"    (\"                         ,'                                         |\\n\");\n" +
"    (\"                       ,'                                           '\\n\");\n" +
"    (\"                      /                                _...._      /\\n\");\n" +
"    (\"                     .                              ,-'      `\\\"'--'\\n\");\n" +
"    (\"      ___            |                            ,'\\n\");\n" +
"    (\"   ,-'   `\\\"-._     _.'                          ,'\\n\");\n" +
"    (\"  /           `\\\"--'             _,....__     _,'\\n\");\n" +
"    (\" '                            .'        `---'\\n\");\n" +
"    (\" `                 ____     ,'\\n\");\n" +
"    (\"  .           _.-'\\\"    `---'\\n\");"); 
        }else if (pokemon.get(0).getNombre() == "SNORLAX" ) {
            System.out.println(" (\"      ::                                              \\n\");\n" +
"    (\"      HHH:                   :HH                      \\n\");\n" +
"    (\"      HHHHH:               :HHHH                      \\n\");\n" +
"    (\"      HHHHHH: :HHHHHHHHH: :HHHHH                      \\n\");\n" +
"    (\"      HHHHHHHHHHHHHHHHHHH:HHHHHH                      \\n\");\n" +
"    (\"      :HHHHHHHHHHHHHHHHHHHHHHHHH                      \\n\");\n" +
"    (\"      ,HHHHHHHH:,,,,:HHHH:,,:HHH                      \\n\");\n" +
"    (\"       HHHHHH:,      ,:H:    ,:H                      \\n\");\n" +
"    (\"       HHHHH:,  :HH:  ,:  :H: ,:                      \\n\");\n" +
"    (\"      :HHHH:,,:H             :H,:                     \\n\");\n" +
"    (\"      HHHHH,,,,       :::       H                     \\n\");\n" +
"    (\"      HHHH:,,,,      :::::      :,                    \\n\");\n" +
"    (\"      HHHH,,,,,,    ,:::::,     ,:                    \\n\");\n" +
"    (\"     ,HHHH,,,,,,,   H::,,:H     ,H,                   \\n\");\n" +
"    (\"     :HHHH,,,,,,,,  H: ,, H    ,,HH:,:HHHH:,          \\n\");\n" +
"    (\"     H:::HHHH:,,,,,:HHHHHHHHHHHH:HHHHHHHHHHH:         \\n\");\n" +
"    (\"    ::HHHH:,:H:,:HH::,,         ,:HHH ,HHHHHH:        \\n\");\n" +
"    (\"   :HHHHHHHH:, HH::,,             ,:H :HHHHHHH:       \\n\");\n" +
"    (\"  :HHHHHHHHHHHHH:,,,               ,:HH:,, HHHH:      \\n\");\n" +
"    (\"  HHHHHHHHHHHH:, :,                  :H,,  HHHHH      \\n\");\n" +
"    (\" ,HHHHHHHHHHHHH: H,                   :H  :HHHHH:     \\n\");\n" +
"    (\" :HHHHHHHHHHHHHH:,                     :HHHHHHHHH     \\n\");\n" +
"    (\" HHHHHHHHHHHHHH,,,                      :HHHHHHHH     \\n\");\n" +
"    (\",HHHHHHHHHHHHH:,,,,                     ,:HHHHHH:     \\n\");\n" +
"    (\":HHHHHHHHHHHH:,,,,,,                    ,,HHH: HHH:   \\n\");\n" +
"    (\"HHHHHHHHHHHH:,,,,,,:,                   ,,HHH, HH,H H:\\n\");\n" +
"    (\"HHHHHHHHHHHH,,:,,,H H,                 ,,:HH:,,:, H:,H\\n\");\n" +
"    (\"HHHHHHHHHHH:,: :,:   :,,H:            ,,,H::::H :H:, H\\n\");\n" +
"    (\"HHHHHHHHHHH,,H  HH,  H:H,H,,        ,,,,:H::,,     : :\\n\");\n" +
"    (\"HHHHHHHHHHH,:,  ::,, :H, H,,,,,,,,,,,,,,H::,,      ,: \\n\");\n" +
"    (\":HHHHHHHHHHHH,,:,,:H:,:, :,,,,,,,,,,,,,:H:,,,       H \\n\");\n" +
"    (\",HHHHHHHHHH:,:H,      ,:H,,,,,,,,,,,,,:H::,,        : \\n\");\n" +
"    (\" HHHHHHHHHH,,,,         ,:,,,,,,,,:HHHHH:,,,   ,:,  ,:\\n\");\n" +
"    (\" HHHHHHHHHH,,,           H,,,:HHHHHHHHHH:,,   ,:::,  H\\n\");\n" +
"    (\" HHHHHHHHH:,,,   ,:::,   :::HHHHHHHHHHHH:,,   :::::  H\\n\");\n" +
"    (\" HHHHHHHHH,,,    :::::,  ,HHHHHHHHHHHHHH:,,   :::::  H\\n\");\n" +
"    (\" HHHHHHHHH,,,   ,::::::   HHHHHHHHHHHHHH:,,   ::::, ,:\\n\");\n" +
"    (\" HHHHHHHHH,,,   :::::::   HHHHHHHHHHHHHH:,,   ,::,  : \\n\");\n" +
"    (\" HHHHHHHHH,,,   :::::::   HHHHHHHHHHHHHH:,,    ,,   H \\n\");\n" +
"    (\" :HHHHHHHH,,,   :::::::   HHHHHHHHHHHHHH:,,,       ,: \\n\");\n" +
"    (\" ,HHHHHHHH,,,   ::::::,   HHHHHHHHHHHHHHH:,,      ,:  \\n\");\n" +
"    (\"  HHHHHHHH,,,   ,:::::   ,HHHHHHHHHHHHHHH:,,,,  ,,H   \\n\");\n" +
"    (\"  :HHHHHHH,,,    ,:::,   :HHHHHHHHHHHHHHHH:,,,,,H:    \\n\");\n" +
"    (\"   :HHHHHH:,,,    ,:,   ,HHHHHHHHHHHHHHHHHHHHHH:      \\n\");\n" +
"    (\"    :HHHHHH,,,          :HHHHHHHHHHHHHHHHHH:,         \\n\");\n" +
"    (\"     :HHHHH:,,,        ,HHHHHHHHH:,                   \\n\");\n" +
"    (\"      :HHHHH:,,,      ,:HHHHHH:,                      \\n\");\n" +
"    (\"        H:HHH:,,,    ,:HH:,                           \\n\");\n" +
"    (\"              :HHHHHH:\\n\");");
        } 
        System.out.println(pokemon.get(0).nombre);
        tiempoEspera();
        tiempoEspera();
        
    }
    
      private void dibujoPokemonCombateEntrenador() {
        if (equipo.get(0).getNombre() == "CHARMANDER") {
            System.out.println("              _.--\"\"`-..");
            System.out.println("            ,'          `.");
            System.out.println("          ,'          __  `.");
            System.out.println("         /|          \" __   \\");
            System.out.println("        , |           / |.   .");
            System.out.println("        |,'          !_.'|   |");
            System.out.println("      ,'             '   |   |");
            System.out.println("     /              |`--'|   |");
            System.out.println("    |                `---'   |");
            System.out.println("     .   ,                   |                       ,\".");
            System.out.println("      ._     '           _'  |                    , ' \\ `");
            System.out.println("  `.. `.`-...___,...---\"\"    |       __,.        ,`\"   L,|");
            System.out.println("  |, `- .`._        _,-,.'   .  __.-'-. /        .   ,    \\");
            System.out.println("-:..     `. `-..--_.,.<       `\"      / `.        `-/ |   .");
            System.out.println("  `,         \"\"\"\"'     `.              ,'         |   |  ',,");
            System.out.println("    `.      '            '            /          '    |'. |/");
            System.out.println("      `.   |              \\       _,-'           |       ''");
            System.out.println("        `._'               \\   '\"\\                .      |");
            System.out.println("           |                '     \\                `._  ,'");
            System.out.println("           |                 '     \\                 .'|");
            System.out.println("           |                 .      \\                | |");
            System.out.println("           |                 |       L              ,' |");
            System.out.println("           `                 |       |             /   '");
            System.out.println("            \\                |       |           ,'   /");
            System.out.println("          ,' \\               |  _.._ ,-..___,..-'    ,'");
            System.out.println("         /     .             .      `!             ,j'");
            System.out.println("        /       `.          /        .           .'/");
            System.out.println("       .          `.       /         |        _.'.'");
            System.out.println("        `.          7`'---'          |------\"'_.'");
            System.out.println("       _,.`,_     _'                ,''-----\"'");
            System.out.println("   _,-_    '       `.     .'      ,\\");
            System.out.println("   -\" /`.         _,'     | _  _  _.|");
            System.out.println("    \"\"--'---\"\"\"\"\"'        `' '! |! /");
            System.out.println("                            `\" \" -' ");
            System.out.println("");
            System.out.println("");
        } else if (equipo.get(0).getNombre() == "CHARMELEON") {
            System.out.println("                      ,-'`\\");
            System.out.println("                  _,\"'    j");
            System.out.println("           __....+       /               .");
            System.out.println("       ,-'\"             /               ; `-._.'.");
            System.out.println("      /                (              ,'       .'");
            System.out.println("     |            _.    \\             \\   ---._ `-.");
            System.out.println("     ,|    ,   _.'  Y    \\             `- ,'   \\   `.`.");
            System.out.println("     l'    \\ ,'._,\\ `.    .              /       ,--. l");
            System.out.println("  .,-        `._  |  |    |              \\       _   l .");
            System.out.println(" /              `\"--'    /              .'       ``. |  )");
            System.out.println(".\\    ,                 |                .        \\ `. '");
            System.out.println("`.                .     |                '._  __   ;. \\'");
            System.out.println("  `-..--------...'       \\                  `'  `-\"'.  \\");
            System.out.println("      `......___          `._                        |  \\");
            System.out.println("               /`            `..                     |   .");
            System.out.println("              /|                `-.                  |    L");
            System.out.println("             / |               \\   `._               .    |");
            System.out.println("           ,'  |,-\"-.   .       .     `.            /     |");
            System.out.println("         ,'    |     '   \\      |       `.         /      |");
            System.out.println("       ,'     /|       \\  .     |         .       /       |");
            System.out.println("     ,'      / |        \\  .    +          \\    ,'       .'");
            System.out.println("    .       .  |         \\ |     \\          \\_,'        / j");
            System.out.println("    |       |  L          `|      .          `        ,' '");
            System.out.println("    |    _. |   \\          /      |           .     .' ,'");
            System.out.println("    |   /  `|    \\        .       |  /        |   ,' .'");
            System.out.println("    |   ,-..\\     -.     ,        | /         |,.' ,'");
            System.out.println("    `. |___,`    /  `.   /`.       '          |  .'");
            System.out.println("      '-`-'     j     ` /.\"7-..../|          ,`-'");
            System.out.println("                |        .'  / _/_|          .");
            System.out.println("                `,       `\"'/\"'    \\          `.");
            System.out.println("                  `,       '.       `.         |");
            System.out.println("             __,.-'         `.        \\'       |");
            System.out.println("            /_,-'\\          ,'        |        _.");
            System.out.println("             |___.---.   ,-'        .-':,-\"`\\,' .");
            System.out.println("                  L,.--\"'           '-' |  ,' `-.\\");
            System.out.println("                                        `.' ");
        } else if (equipo.get(0).getNombre() == "CHARIZARD") {
            System.out.println("                 .\"-,.__");
            System.out.println("                 `.     `.  ,");
            System.out.println("              .--'  .._,'\"-' `.");
            System.out.println("             .    .'         `'");
            System.out.println("             `.   /          ,'");
            System.out.println("               `  '--.   ,-\"'");
            System.out.println("                `\"`   |  \\");
            System.out.println("                   -. \\, |");
            System.out.println("                    `--Y.'      ___.");
            System.out.println("                         \\     L._, \\");
            System.out.println("               _.,        `.   <  <\\                _");
            System.out.println("             ,' '           `, `.   | \\            ( `");
            System.out.println("          ../, `.            `  |    .\\`.           \\ \\_");
            System.out.println("         ,' ,..  .           _.,'    ||\\l            )  '\".");
            System.out.println("        , ,'   \\           ,'.-.`-._,'  |           .  _._`.");
            System.out.println("      ,' /      \\ \\        `' ' `--/   | \\          / /   ..\\");
            System.out.println("    .'  /        \\ .         |\\__ - _ ,'` `        / /     `.`.");
            System.out.println("    |  '          ..         `-...-\"  |  `-'      / /        . `.");
            System.out.println("    | /           |L__           |    |          / /          `. `.");
            System.out.println("   , /            .   .          |    |         / /             ` `");
            System.out.println("  / /          ,. ,`._ `-_       |    |  _   ,-' /               ` \\");
            System.out.println(" / .           \\\"`_/. `-_ \\_,.  ,'    +-' `-'  _,        ..,-.    \\`.");
            System.out.println(".  '         .-f    ,'   `    '.       \\__.---'     _   .'   '     \\ \\");
            System.out.println("' /          `.'    l     .' /          \\..      ,_|/   `.  ,'`     L`");
            System.out.println("|'      _.-\"\"` `.    \\ _,'  `            \\ `.___`.'\"`-.  , |   |    | \\");
            System.out.println("||    ,'      `. `.   '       _,...._        `  |    `/ '  |   '     .|");
            System.out.println("||  ,'          `. ;.,.---' ,'       `.   `.. `-'  .-' /_ .'    ;_   ||");
            System.out.println("|| '              V      / /           `   | `   ,'   ,' '.    !  `. ||");
            System.out.println("||/            _,-------7 '              . |  `-'    l         /    `||");
            System.out.println(". |          ,' .-   ,' ||               | .-.        `.      .'     ||");
            System.out.println(" `'        ,'    `\".'    |               |    `.        '. -.'       `'");
            System.out.println("          /      ,'      |               |,'    \\-.._,.'/'");
            System.out.println("          .     /        .               .       \\    .''");
            System.out.println("        .`.    |         `.             /         :_,'.'");
            System.out.println("          \\ `...\\   _     ,'-.        .'         /_.-'");
            System.out.println("           `-.__ `,  `'   .  _.>----''.  _  __  /");
            System.out.println("                .'        /\"'          |  \"'   '_");
            System.out.println("               /_|.-'\\ ,\".             '.'`__'-( \\");
            System.out.println("                 / ,\"'\"\\,'               `/  `-.|\" ");
        } else if (equipo.get(0).getNombre() == "SQUIRTLE") {
            System.out.println("            ,-'            \"`-.");
            System.out.println("          ,'                   `-.");
            System.out.println("        ,'                        \\");
            System.out.println("      ,'                           .");
            System.out.println("      .'\\               ,\"\".       `");
            System.out.println("     ._.'|             / |  `       \\");
            System.out.println("     |   |            `-.'  ||       `.");
            System.out.println("     |   |            '-._,'||       | \\");
            System.out.println("     .`.,'             `..,'.'       , |`-.");
            System.out.println("     l                       .'`.  _/  |   `.");
            System.out.println("     `-.._'-   ,          _ _'   -\" \\  .     `");
            System.out.println("`.\"\"\"\"\"'-.`-...,---------','         `. `....__.");
            System.out.println(".'        `\"-..___      __,'\\          \\  \\     \\");
            System.out.println("\\_ .          |   `\"\"\"\"'    `.           . \\     \\");
            System.out.println("  `.          |              `.          |  .     L");
            System.out.println("    `.        |`--...________.'.        j   |     |");
            System.out.println("      `._    .'      |          `.     .|   ,     |");
            System.out.println("         `--,\\       .            `7\"\"' |  ,      |");
            System.out.println("            ` `      `            /     |  |      |    _,-'\"\"\"`-.");
            System.out.println("             \\ `.     .          /      |  '      |  ,'          `.");
            System.out.println("              \\  v.__  .        '       .   \\    /| /              \\");
            System.out.println("               \\/    `\"\"\\\"\"\"\"\"\"\"`.       \\   \\  /.''                |");
            System.out.println("                `        .        `._ ___,j.  `/ .-       ,---.     |");
            System.out.println("                ,`-.      \\         .\"     `.  |/        j     `    |");
            System.out.println("               /    `.     \\       /         \\ /         |     /    j");
            System.out.println("              |       `-.   7-.._ .          |\"          '         /");
            System.out.println("              |          `./_    `|          |            .     _,'");
            System.out.println("              `.           / `----|          |-............`---'");
            System.out.println("                \\          \\      |          |");
            System.out.println("               ,'           )     `.         |");
            System.out.println("                7____,,..--'      /          |");
            System.out.println("                                  `---.__,--.'");
        } else if (equipo.get(0).getNombre() == "WARTORTLE") {
            System.out.println("     __                                _.--'\"7");
            System.out.println("    `. `--._                        ,-'_,-  ,'");
            System.out.println("     ,'  `-.`-.                   /' .'    ,|");
            System.out.println("     `.     `. `-     __...___   /  /     - j");
            System.out.println("       `.     `  `.-\"\"        \" .  /       /");
            System.out.println("         \\     /                ` /       /");
            System.out.println("          \\   /                         ,'");
            System.out.println("          '._'_               ,-'       |");
            System.out.println("             | \\            ,|  |   ...-'");
            System.out.println("             || `         ,|_|  |   | `             _..__");
            System.out.println("            /|| |          | |  |   |  \\  _,_    .-\"     `-.");
            System.out.println("           | '.-'          |_|_,' __!  | /|  |  /           \\");
            System.out.println("   ,-...___ .=                  ._..'  /`.| ,`,.      _,.._ |");
            System.out.println("  |   |,.. \\     '  `'        ____,  ,' `--','  |    /      |");
            System.out.println(" ,`-..'  _)  .`-..___,---'_...._/  .'      '-...'   |      /");
            System.out.println("'.__' \"\"'      `.,------'\"'      ,/            ,     `.._.' `.");
            System.out.println("  `.             | `--........,-'.            .         \\     \\");
            System.out.println("    `-.          .   '.,--\"\"     |           ,'\\        |      .");
            System.out.println("       `.       /     |          L          ,\\  .       |  .,---.");
            System.out.println("         `._   '      |           \\        /  .  L      | /   __ `.");
            System.out.println("            `-.       |            `._   ,    l   .    j |   '  `. .");
            System.out.println("              |       |               `\"' |  .    |   /  '      .' |");
            System.out.println("              |       |                   j  |    |  /  , `.__,'   |");
            System.out.println("              `.      L                 _.   `    j ,'-'           |");
            System.out.println("               |`\"---..\\._______,...,--' |   |   /|'      /        j");
            System.out.println("               '       |                 |   .  / |      '        /");
            System.out.println("                .      .              ____L   \\'  j    -',       /");
            System.out.println("               / `.     .          _,\"     \\   | /  ,-','      ,'");
            System.out.println("              /    `.  ,'`-._     /         \\  i'.,'_,'      .'");
            System.out.println("             .       `.      `-..'             |_,-'      _.'");
            System.out.println("             |         `._      |            ''/      _,-'");
            System.out.println("             |            '-..._\\             `__,.--'");
            System.out.println("            ,'           ,' `-.._`.            .");
            System.out.println("           `.    __      |       \"'`.          |");
            System.out.println("             `-\"'  `\"\"\"\"'            7         `.");
            System.out.println("                                    `---'--.,'\"`' ");
        } else if (equipo.get(0).getNombre() == "BLASTOISE") {
            System.out.println("                       _");
            System.out.println("            _,..-\"\"\"--' `,.-\".");
            System.out.println("          ,'      __.. --',  |");
            System.out.println("        _/   _.-\"' |    .' | |       ____");
            System.out.println("  ,.-\"\"'    `-\"+.._|     `.' | `-..,',--.`.");
            System.out.println(" |   ,.                      '    j 7    l \\__");
            System.out.println(" |.-'                            /| |    j||  .");
            System.out.println(" `.                   |         / L`.`\"\"','|\\  \\");
            System.out.println("   `.,----..._       ,'`\"'-.  ,'   \\ `\"\"'  | |  l");
            System.out.println("     Y        `-----'       v'    ,'`,.__..' |   .");
            System.out.println("      `.                   /     /   /     `.|   |");
            System.out.println("        `.                /     l   j       ,^.  |L");
            System.out.println("          `._            L       +. |._   .' \\|  | \\");
            System.out.println("            .`--...__,..-'\"\"'-._  l L  \"\"\"    |  |  \\");
            System.out.println("          .'  ,`-......L_       \\  \\ \\     _.'  ,'.  l");
            System.out.println("       ,-\"`. / ,-.---.'  `.      \\  L..--\"'  _.-^.|   l");
            System.out.println(" .-\"\".'\"`.  Y  `._'   '    `.     | | _,.--'\"     |   |");
            System.out.println("  `._'   |  |,-'|      l     `.   | |\"..          |   l");
            System.out.println("  ,'.    |  |`._'      |      `.  | |_,...---\"\"\"\"\"`    L");
            System.out.println(" /   |   j _|-' `.     L       | j ,|              |   |");
            System.out.println("`--,\"._,-+' /`---^..../._____,.L',' `.             |\\  |");
            System.out.println("   |,'      L                   |     `-.          | \\j");
            System.out.println("            .                    \\       `,        |  |");
            System.out.println("             \\                __`.Y._      -.     j   |");
            System.out.println("              \\           _.,'       `._     \\    |  j");
            System.out.println("              ,-\"`-----\"\"\"\"'           |`.    \\  7   |");
            System.out.println("             /  `.        '            |  \\    \\ /   |");
            System.out.println("            |     `      /             |   \\    Y    |");
            System.out.println("            |      \\    .             ,'    |   L_.-')");
            System.out.println("             L      `.  |            /      ]     _.-^._");
            System.out.println("              \\   ,'  `-7         ,-'      / |  ,'      `-._");
            System.out.println("             _,`._       `.   _,-'        ,',^.-            `.");
            System.out.println("          ,-'     v....  _.`\"',          _:'--....._______,.-'");
            System.out.println("        ._______./     /',,-'\"'`'--.  ,-'  `.");
            System.out.println("                 \"\"\"\"\"`.,'         _\\`----...' mh");
            System.out.println("                        --------\"\"'");
        } else if (equipo.get(0).getNombre() == "BULBASAUR") {
            System.out.println("                                           /");
            System.out.println("                        _,.------....___,.' ',.-.");
            System.out.println("                     ,-'          _,.--\"        |");
            System.out.println("                   ,'         _.-'              .");
            System.out.println("                  /   ,     ,'                   `");
            System.out.println("                 .   /     /                     ``.");
            System.out.println("                 |  |     .                       \\.\\");
            System.out.println("       ____      |___._.  |       __               \\ `.");
            System.out.println("     .'    `---\"\"       ``\"-.--\"'`  \\               .  \\");
            System.out.println("    .  ,            __               `              |   .");
            System.out.println("    `,'         ,-\"'  .               \\             |    L");
            System.out.println("   ,'          '    _.'                -._          /    |");
            System.out.println("  ,`-.    ,\".   `--'                      >.      ,'     |");
            System.out.println(" . .'\\'   `-'       __    ,  ,-.         /  `.__.-      ,'");
            System.out.println(" ||:, .           ,'  ;  /  / \\ `        `.    .      .'/");
            System.out.println(" j|:D  \\          `--'  ' ,'_  . .         `.__, \\   , /");
            System.out.println("/ L:_  |                 .  \"' :_;                `.'.'");
            System.out.println(".    \"\"'                  \"\"\"\"\"'                    V");
            System.out.println(" `.                                 .    `.   _,..  `");
            System.out.println("   `,_   .    .                _,-'/    .. `,'   __  `");
            System.out.println("    ) \\`._        ___....----\"'  ,'   .'  \\ |   '  \\  .");
            System.out.println("   /   `. \"`-.--\"'         _,' ,'     `---' |    `./  |");
            System.out.println("  .   _  `\"\"'--.._____..--\"   ,             '         |");
            System.out.println("  | .\" `. `-.                /-.           /          ,");
            System.out.println("  | `._.'    `,_            ;  /         ,'          .");
            System.out.println(" .'          /| `-.        . ,'         ,           ,");
            System.out.println(" '-.__ __ _,','    '`-..___;-...__   ,.'\\ ____.___.'");
            System.out.println(" `\"^--'..'   '-`-^-'\"--    `-^-'`.''\"\"\"\"\"`.,^.`.--' ");
        } else if (equipo.get(0).getNombre() == "IVYSAUR") {
            System.out.println("                               ,'\"`.,./.");
            System.out.println("                             ,'        Y',\"..");
            System.out.println("                           ,'           \\  | \\");
            System.out.println("                          /              . |  `");
            System.out.println("                         /               | |   \\");
            System.out.println("            __          .                | |    .");
            System.out.println("       _   \\  `. ---.   |                | j    |");
            System.out.println("      / `-._\\   `Y   \\  |                |.     |");
            System.out.println("     _`.    ``    \\   \\ |..              '      |,-'\"\"7,....");
            System.out.println("     l     '-.     . , `|  | , |`. , ,  /,     ,'    '/   ,'_,.-.");
            System.out.println("     `-..     `-.  : :     |/ `   ' \"\\,' | _  /          '-'    /___");
            System.out.println("      \\\"\"' __.,.-`.: :        /   /._    l'.,'");
            System.out.println("       `--,   _.-' `\".           /__ `'-.' '         .");
            System.out.println("       ,---..._,.--\"\"\"\"\"\"\"--.__..----,-.'   .  /    .'   ,.--");
            System.out.println("       |                          ,':| /    | /     ;.,-'--      ,.-");
            System.out.println("       |     .---.              .'  :|'     |/ ,.-='\"-.`\"`' _   -.'");
            System.out.println("       /    \\    /               `. :|--.  _L,\"---.._        \"----'");
            System.out.println("     ,' `.   \\ ,'           _,     `''   ``.-'       `-  -..___,'");
            System.out.println("    . ,.  .   `   __     .-'  _.-           `.     .__    \\");
            System.out.println("    |. |`        \"  ;   !   ,.  |             `.    `.`'---'");
            System.out.println("    ,| |C\\       ` /    | ,' |(]|            -. |-..--`");
            System.out.println("   /  \"'--'       '      /___|__]        `.  `- |`.");
            System.out.println("  .       ,'                   ,   /       .    `. \\");
            System.out.println("    \\                      .,-'  ,'         .     `-.");
            System.out.println("     x---..`.  -'  __..--'\"/\"\"\"\"\"  ,-.      |   |   |");
            System.out.println("    / \\--._'-.,.--'     _`-    _. ' /       |     -.|");
            System.out.println("   ,   .   `-..__ ...--'  _,.-' | `   ,.-.  ;   /  '|");
            System.out.println("  .  _,'         '\"-----\"\"      |    `   | /  ,'    ;");
            System.out.println("  |-'  .-.    `._               |     `._// ,'     /");
            System.out.println(" _|    `-'   _,' \"`--.._________|        `,'    _ /.");
            System.out.println("//\\   ,-._.'\"/\\__,.   _,\"     /_\\__/`. /'.-.'.-/_,`-' ");
            System.out.println("`-\"`\"' v'    `\"  `-`-\"              `-'`-`  `'");
        } else if (equipo.get(0).getNombre() == "VENUSAUR") {
            System.out.println("                           _._       _,._");
            System.out.println("                        _.'   `. ' .'   _`.");
            System.out.println("                ,\"\"\"/`\"\"-.-.,/. ` V'\\-,`.,--/\"\"\".\"-..");
            System.out.println("              ,'    `...,' . ,\\-----._|     `.   /   \\");
            System.out.println("             `.            .`  -'`\"\" .._   :> `-'   `.");
            System.out.println("            ,'  ,-.  _,.-'| `..___ ,'   |'-..__   .._ L");
            System.out.println("           .    \\_ -'   `-'     ..      `.-' `.`-.'_ .|");
            System.out.println("           |   ,',-,--..  ,--../  `.  .-.    , `-.  ``.");
            System.out.println("           `.,' ,  |   |  `.  /'/,,.\\/  |    \\|   |");
            System.out.println("                `  `---'    `j   .   \\  .     '   j");
            System.out.println("              ,__`\"        ,'|`'\\_/`.'\\'        |\\-'-, _,.");
            System.out.println("       .--...`-. `-`. /    '- ..      _,    /\\ ,' .--\"'  ,'\".");
            System.out.println("     _'-\"\"-    --  _`'-.../ __ '.'`-^,_`-\"\"\"\"---....__  ' _,-`");
            System.out.println("   _.----`  _..--.'        |  \"`-..-\" __|'\"'         .\"\"-. \"\"'--.._");
            System.out.println("  /        '    /     ,  _.+-.'  ||._'   \"\"\"\". .          `     .__\\");
            System.out.println(" `---    /        /  / j'       _/|..`  -. `-`\\ \\   \\  \\   `.  \\ `-..");
            System.out.println(",\" _.-' /    /` ./  /`_|_,-\"   ','|       `. | -'`._,   L  \\ .  `.   |");
            System.out.println("`\"' /  /  / ,__...-----| _.,  ,'            `|----.._`-.|' |. .` ..  .");
            System.out.println("   /  '| /.,/   \\--.._ `-,' ,          .  '`.'  __,., '  ''``._ \\ \\`,'");
            System.out.println("  /_,'---  ,     \\`._,-` \\ //  / . \\    `._,  -`,  / / _   |   `-L -");
            System.out.println("   /       `.     ,  ..._ ' `_/ '| |\\ `._'       '-.'   `.,'     |");
            System.out.println("  '         /    /  ..   `.  `./ | ; `.'    ,\"\" ,.  `.    \\      |");
            System.out.println("   `.     ,'   ,'   | |\\  |       \"        |  ,'\\ |   \\    `    ,L");
            System.out.println("   /|`.  /    '     | `-| '                  /`-' |    L    `._/  \\");
            System.out.println("  / | .`|    |  .   `._.'                   `.__,'   .  |     |  (`");
            System.out.println(" '-\"\"-'_|    `. `.__,._____     .    _,        ____ ,-  j     \".-'\"'");
            System.out.println("        \\      `-.  \\/.    `\"--.._    _,.---'\"\"\\/  \"_,.'     /-'");
            System.out.println("         )        `-._ '-.        `--\"      _.-'.-\"\"        `.");
            System.out.println("        ./            `,. `\".._________...\"\"_.-\"`.          _j");
            System.out.println("       /_\\.__,\"\".   ,.'  \"`-...________.---\"     .\".   ,.  / \\");
            System.out.println("              \\_/\"\"\"-'                           `-'--(_,`\"`-` ");
        } else if (equipo.get(0).getNombre() == "PSYDUCK") {
            System.out.println("                              ,-'   ,\"\",");
            System.out.println("                             / / ,-'.-'");
            System.out.println("                   _,..-----+-\".\".-'_,..");
            System.out.println("           ,...,.\"'             `--.---'");
            System.out.println("         /,..,'                     `.");
            System.out.println("       ,'  .'                         `.");
            System.out.println("      j   /                             `.");
            System.out.println("      |  /,----._           ,.----.       .");
            System.out.println("     ,  j    _   \\        .'  .,   `.     |");
            System.out.println("   ,'   |        |  ____  |         | .\"--+,^.");
            System.out.println("  /     |`-....-',-'    `._`--....-' _/      |");
            System.out.println(" /      |     _,'          `--..__  `        '");
            System.out.println("j       | ,-\"'    `    .'         `. `        `.");
            System.out.println("|        .\\                        /  |         \\");
            System.out.println("|         `\\                     ,'   |          \\");
            System.out.println("|          |                    |   ,-|           `.");
            System.out.println(".         ,'                    |-\"'  |             \\");
            System.out.println(" \\       /                      `.    |              .");
            System.out.println("  ` /  ,'                        |    `              |");
            System.out.println("   /  /                          |     \\             |");
            System.out.println("  /  |                           |      \\           /");
            System.out.println(" /   |                           |       `.       _,");
            System.out.println(".     .                         .'         `.__,.',.----,");
            System.out.println("|      `.                     ,'             .-\"\"      /");
            System.out.println("|        `._               _.'               |        /");
            System.out.println("|           `---.......,--\"                  |      ,'");
            System.out.println("'                                            '    ,'");
            System.out.println(" \\                                          /   ,'");
            System.out.println("  \\                                        /  ,'");
            System.out.println("   \\                                      / ,'");
            System.out.println("    `.                                   ,+'");
            System.out.println("      >.                               ,'");
            System.out.println("  _.-'  `-.._                      _,-'-._");
            System.out.println(",__          `\",-............,.---\"       `.");
            System.out.println("   \\..---. _,-'            ,'               `.");
            System.out.println("          \"                '..,--.___,-\"\"\"---' ");
        } else if (equipo.get(0).getNombre() == "GOLDUCK") {
            System.out.println("                ,|");
            System.out.println("              ,' |         .',");
            System.out.println("             /   |    /\\_,' j");
            System.out.println("            /    |  ,' |    |");
            System.out.println("          ,'     |,'   |   .");
            System.out.println("         /       '    j   j    _,.-/");
            System.out.println("        /      ,'     |   |..-\"  ,'");
            System.out.println("       /              |         /                      `");
            System.out.println("      /               |       ,'");
            System.out.println("    ('  (                 ,\"\"`-.                        /|");
            System.out.println("     | | .              ,'      \\                      / |");
            System.out.println("     | |p'             /        |                     /  |");
            System.out.println("     |.`              '       ,'|-.                 ,'   '");
            System.out.println("     /`\"`\"\"\"'\"`-.    /       .  |. `.___           /    /");
            System.out.println("    /      ,-\"'_|._,'        |  | `.    `\"--..    /    j");
            System.out.println("  ,'     ,',-\"',-'           |,'    `-.       | ,'     |");
            System.out.println(" /     .'.'   /  ,-'|       \\'         `.    ,'/      j");
            System.out.println("|    .','    /  /   |   ,-.  \\           `+-','       '");
            System.out.println("|  .''      .._/   /   /   \\  \\           `.'        /");
            System.out.println(" \\/         | /`\"-.'  /_,..\"\\,\\                     /");
            System.out.println("            '/    |\"|(       \\ .                  ,'");
            System.out.println("                   .| \\       `'                 /");
            System.out.println("                    ' _\\       ,.----\"\"-\\      ,'");
            System.out.println("                 ,-'\"\"  \\    ,'          `   ,'");
            System.out.println("                |        `-.'              ,'");
            System.out.println("                .           \\           _.'");
            System.out.println("                 \\        ___\\         `.");
            System.out.println("                  `.    \"\" `. \\          \\");
            System.out.println("            ,-/\"\"\"\"'._       \\_`.         `.");
            System.out.println("`         _.`-'\"\"            /_`.\\          \\");
            System.out.println("         /.-n+==`       _,,-'\"    \\          \\");
            System.out.println("           ,\\ __.-\"\"\"\"'\"           )          `..__");
            System.out.println("          (,.'                   _/         .._   _\\_");
            System.out.println("          '                    ,\"  _,.-._   -. `_/__ \\");
            System.out.println("                              / ),+....._\\ ,--.\"    `'");
            System.out.println("                             `\"'          `.._ \\");
            System.out.println("                                              `' ");
        } else if (equipo.get(0).getNombre() == "GROWLITHE") {
            System.out.println("");
            System.out.println("                   _,");
            System.out.println("                 .',_..,");
            System.out.println("               ,'     /,--");
            System.out.println("             .'       ,./.__");
            System.out.println("             |_,.----/,,'`.  _");
            System.out.println("            .'__     //    `...>");
            System.out.println("       ____//|) |    `      /.'");
            System.out.println("      (/    `-.-'.._     _,|                 ,.-------.._");
            System.out.println("      .             `.  '   \\               /            `-._");
            System.out.println("      `..---._       |       `.            j                 `.");
            System.out.println("        >-,-\"`\"\"'    |        |`\"+-..__    |              -. `-.");
            System.out.println("       ( /|         /____     |  |  |  \\\"\"|+-.._     ___    `.  `.");
            System.out.println("        \" `-..._     \"--,_    |  |  `   | |   | `.-.\"   \"-._  |  -`");
            System.out.println("             ,'        '_>_   j ,'  '. ,` |,  |   `. `.-v.' `-+..._`.");
            System.out.println("            '.         >       '     | |  ' \\ L     ..`.  '        `._");
            System.out.println("             '.       /              '|`     \\|      '^,         ..,{ `.");
            System.out.println("            / /      /                '       v          |__    ___,'\"\"");
            System.out.println("          ,'  >---+-+.        |   __,..--\"`-._          /.-'`\"----'");
            System.out.println("         /`.       `. '.      |-\"'            `\"--....-'._");
            System.out.println("       .'___'        `._`,    j             ___,-','      `-..._");
            System.out.println("  _ _.'    '/.-          '  ,'       __..<\"\"__,.-'              `.");
            System.out.println(" `.)         |'---\"\"`.+-.--'-------\"\"-...__  ,-'/ .\"\\          _  |");
            System.out.println(",\"\\ ,--.  _,-          ` `'                `'\"\"\"'`\"'\"\"\"`--._  . `/");
            System.out.println(" `-`.___.'                                                  `\"-\"'");
        } else if (equipo.get(0).getNombre() == "ARCANINE") {
            System.out.println("            /  ,'(");
            System.out.println("           /`-'   \\__.,");
            System.out.println("         ,'     .-\"\\ `---/                     /");
            System.out.println("      |`'      /,'||    '.               ,`. ,(,_. _,");
            System.out.println("  __  |  ,--+--.  ||     `'/  .     _.-\"'   `    \"\"`.");
            System.out.println(".\" ,'-'.\"d__|  `.'_'    _,-    ,.  /        ._      `\\_");
            System.out.println("|,'     `-..-----\"._     `.     ` |           `.     \\.");
            System.out.println(" `\"V\"--._           `.   `._    ' |             \\     \\,");
            System.out.println("  \\      `----      '. _,-'    ,' |              \\     .");
            System.out.println("   `._             .--`       `.  |               .    |");
            System.out.println("      `-.          `,.       ,--  |               L    '");
            System.out.println("        /   [-,=.---' `.__`,`     `.              |     \\");
            System.out.println("    _.-'    `.._'--.._   - `--+\"\"\"\" '._           |      `._,");
            System.out.println("    \\        _  ---..__`--._'-.`,  ,' ,`._       j         -,'");
            System.out.println("   .'        ,-..     ,'    `. `  . ,'  / `._   /`._    ___,-'_");
            System.out.println("   l        .|_  `,  -' . .-\"      v   /   _.`.'`   7\",',-,.-\" --,");
            System.out.println("    \\      `.  .,  -..',')'\"\",   .    /  .'    |  ,'.',/| ,.     >");
            System.out.println("     V-.    '    -._,-\"    _,  .,'   j ,^    ,'/`--' `    -..,   `...");
            System.out.println("     '  \\/\\|.     :/       './`'|    |/    ,' /            `___    ,'");
            System.out.println("           | `. ,'`-.        /  |    ' _.-'  |               ,'  .\"");
            System.out.println("           L._`.'   |       Y,.'|    ,-    ,-'          __.,'  .'");
            System.out.println("            \\ \\  /`.|     _,.',''.  .`-,../         ,.-/,...-`'");
            System.out.println("             \\ ,|| |/_.-\\\" .+'    \\._  _,'       _.'\"  |");
            System.out.println("              '  ' L| | `,' |      `.\"\"          ,.    |");
            System.out.println("              )    `|\"      |        `>.. _,..--\" j    |");
            System.out.println("           ,-'      |____,..'       ,',-\"'       /   _,'");
            System.out.println("          /\"'    _,.'               |(      _..-' `\"\"");
            System.out.println("          `----\"'                    `'\"\"'\"\" ");
        } else if (equipo.get(0).getNombre() == "BELLSPROUT") {
            System.out.println("                _.--\"'\"\"\"--._");
            System.out.println("              .\"             `.");
            System.out.println("             /                 .");
            System.out.println("            j                   .");
            System.out.println("            |                   |");
            System.out.println("            |                   |");
            System.out.println("            | (')              j");
            System.out.println("            `                 ,`.");
            System.out.println("             \\               ,^. `.");
            System.out.println("              .             /   \\  .");
            System.out.println("              |            /     . |");
            System.out.println("              |          ,'      | |");
            System.out.println("             ,'---..___ /        | |");
            System.out.println("            ' `--..___ \"`.      .  |");
            System.out.println("             `\"--....___.'     /  j__.....__");
            System.out.println("                              /   |         `.");
            System.out.println("                             / _,------._     `.");
            System.out.println("                            /,+_         `.     `.");
            System.out.println("                          ,'    `-.        \\      .");
            System.out.println("                         .         `.       \\      \\");
            System.out.println("                         |           `.     |       \\");
            System.out.println("                         |             `.   |_,..__  .");
            System.out.println("                         |\\              \\  |      `.|");
            System.out.println("                         | `.,--------._  \\ |        `");
            System.out.println("                         |  |           `. \\|");
            System.out.println("                         |  |             `.|");
            System.out.println("                         |  |");
            System.out.println("                         |  |");
            System.out.println("                         |. '");
            System.out.println("                        .' \\ `.");
            System.out.println("                     _,' ,' `. ._");
            System.out.println("   ---====+,______,.\"_.-'     .  `.");
            System.out.println("   _,..==`'_.+'-\"\"\"\"'         / ^.\\`:._");
            System.out.println(" ,=\"/    ,\"            ....==+ /  `\\  `:.");
            System.out.println("'  /    / |               _+:-'    .|   ``.");
            System.out.println("       '  `.           --\"\"        |'     `\\");
            System.out.println("                                   ' ");
        } else if (equipo.get(0).getNombre() == "WEEPINBELL") {
            System.out.println("                                    _...._");
            System.out.println("                                  ,'   __ `.");
            System.out.println("                                .'   ,'  `. |");
            System.out.println("                               .   .'      .|");
            System.out.println("                              /   .        ||");
            System.out.println("                          .-\"'\"\"\"-'        ,'");
            System.out.println("                      _,'\"\"\"'\"--._ `.");
            System.out.println("                    .'            `.:");
            System.out.println("                  ,'                `.");
            System.out.println("                 /     _              \\");
            System.out.println("   ..--._       /     ._;              \\");
            System.out.println(" ,'      `.    j                        .");
            System.out.println(".          `.  |                        |");
            System.out.println("|           ,+-' ,-\"\"-.       _.-\"'\"\"\"`\"`._");
            System.out.println("|          : |/ /`.    |    ,'             `.");
            System.out.println("|          |// :  |    |   ,                 '.");
            System.out.println("'    .     |/  '-\"     |  /                    `.");
            System.out.println(" `    \\   ,'    `-...,'  j                       `");
            System.out.println("  '._/_\\.'               |                        `");
            System.out.println("  .'   `\"-._             |                         \\");
            System.out.println("  |         `.           |                          \\");
            System.out.println("  | --+.      `.          .                 ___      .");
            System.out.println("  '   | `.      `.         .           _.-\"\"   `\"._  |");
            System.out.println("   .  '    .      `.        `-.____,.-' /          `.|");
            System.out.println("    .  `    `.      .                  /             `");
            System.out.println("     `. `.    `.     \\                ,");
            System.out.println("       .  .     .     .             ,'");
            System.out.println("        `  `.    `.    .           .");
            System.out.println("         `.  `.    .   |        _,'");
            System.out.println("           `    `. |   |      ,'");
            System.out.println("            `.    `'   |  _.-'");
            System.out.println("              `-.      ;-'");
            System.out.println("                 `--..\" mh");
        } else if (equipo.get(0).getNombre() == "VICTREEBEL") {
            System.out.println("                                       ___");
            System.out.println("                                    ,\"\" __\"`.");
            System.out.println("                                   / .'\"   `-`.");
            System.out.println("                                  / /        ` .");
            System.out.println("                            _,.__. /_,...._   \\ \\");
            System.out.println("                         ,-'     |j        `-._\\ \\");
            System.out.println("                      _,'        ||            `._\\");
            System.out.println("                    ,'_,..,.      |        .----._`.");
            System.out.println("                  _,\"'   / /     `'         `.   :`-'");
            System.out.println("                        / j               ,_  \\   `|");
            System.out.println("                       j ,'-._      _..-\"\"' | `.  ||");
            System.out.println("                       | |    `'-.,'        |  |  ||");
            System.out.println("                       | |  _.              ' j   ||");
            System.out.println("                       ' '.'.'         \\\"-./ ,    |'");
            System.out.println("                        ` `/_           \\_/ /     | L");
            System.out.println("                         `._ `-..___,.-'\"_,:      | |");
            System.out.println("                          | `._      _,-' ||      | |");
            System.out.println("                          |`..,+----`.__,\" |      | |");
            System.out.println("                          |                |      | |");
            System.out.println("         _.--\"\"\"\"--._     |               _'    _.+-'\"\"\"'`-._");
            System.out.println("       ,'            `-.  |.-.           , `\\ ,'             `.");
            System.out.println("     ,'                 \\j |  |          `./ /                 `.");
            System.out.println("    / _.--\"\"\"--._        | `-\"               |    _,.-------.._  \\");
            System.out.println("   /.'           `-.    j                    | ,-'             `-.\\");
            System.out.println("  ,'                `-. |                    |'                   '.");
            System.out.println(" /   __                \\|                    /                      `");
            System.out.println("j .'\"  \"-..             |  _         ,\"`.    |           _,.--'\"\"'-. .");
            System.out.println("|/:        `._          / | \\        |  |    |        _,:           \\|");
            System.out.println("` '           `-._    ,'| `.,'       '.-'    `..__,..' '`.   __");
            System.out.println(" '                `\"\"'  '                    ;          `.`.'  \"'--...,'");
            System.out.println("                         .  Y.          /\"','             '-..____,.-'");
            System.out.println("                          `-._         _`-'");
            System.out.println("                              `\"------\" mh");
        } else if (equipo.get(0).getNombre() == "MEWTWO" ) {
            System.out.println("");
            System.out.println("                                               `/:+`                      ```                        ");
            System.out.println("                                              :- .+`     `....``        -+-:/:                      ");
            System.out.println("                                              ./. `/--:::-....--:::::-./:   +.                      ");
            System.out.println("                                               `/.  .`              `.:`  `/.                       ");
            System.out.println("                                                `/                       `+`                        ");
            System.out.println("                                                `o                       /.                         ");
            System.out.println("                                                :-                       /.                         ");
            System.out.println("                                               `+                        ./                         ");
            System.out.println("                                               .:                        `+                         ");
            System.out.println("                                               `+    `.`           `     .+                         ");
            System.out.println("                                                :-`-:``.-`      `..` `-.`/.                         ");
            System.out.println("                                                `+``o/o.` `- `- ```:+-/ ./                          ");
            System.out.println("                                                 :- //Nh/. .:-/ .:hNh--.+`                          ");
            System.out.println("                        `-:::::-`                `+```:+ss::.`:/yoo/.``+`                           ");
            System.out.println("                       `+-`   `.+.              `:+-     ``     `     -:                            ");
            System.out.println("                       /-       .o              +.`./-.            `-:-`                            ");
            System.out.println("                       :/       :+:`           ::  --.-::.` ``. `.::.                               ");
            System.out.println("                        :/-...-/:`./:--..`     o   o    s.::-..::-`                                 ");
            System.out.println("                         `..-+-`    -+:..-:-.` + `.+:---o````.+-                                    ");
            System.out.println("                  `...`      :+      `:/-..-//:+:/:-.` `.--:``-:-.-.                                ");
            System.out.println("                -/:-.-:/-``.:/. -      .s:...-/-````.-:`  `..-:-  `:-                               ");
            System.out.println("               .o`     `o/--.  `o      o`     `o`     `/.      -``  -:                              ");
            System.out.println("        ```    -/       /-      +`     s       o`       +`     ` .:` :-                             ");
            System.out.println("    `-//:::://:-s:`   `:o.``    `.   ``++.`  `:/-`      -/     .- -/  +`                            ");
            System.out.println("  `//-`       `-:os+:::----:::.````-/:-.-:::::. ./`     `+      /  +` :/                            ");
            System.out.println(" .o.   ``...:.    `:+.       `-::::-`            `+.    `+      `  :` :s                            ");
            System.out.println("`o.  `::----:+/`    `+:                           `/:`   /.      `..``/o                            ");
            System.out.println(":+  `+.       -+`     //                            ./-` `::-..-::-` :./`                           ");
            System.out.println("o.  :/         -o`     /+                             -/.    `    `  /..:                           ");
            System.out.println("y   +.          :+      //                             `::        /. :-`/                           ");
            System.out.println("y   +.           //      o-                              +.       `o``+`/`                          ");
            System.out.println("s`  /:            +/     .o                              -/        .+ .+./`                         ");
            System.out.println("+-  .o             /+`    s.                             -:         -- .+.+`                        ");
            System.out.println("-+   +-             -o:   s`                        ./::-:` .`       `  `/:o`                       ");
            System.out.println(" o`  `o.              -///-                      `:/-        ``       ````-/o:                      ");
            System.out.println(" .o   `o`                                      `//`              .:-::::::/++s+                     ");
            System.out.println("  :/   `+-                                    -+`                 -:        :+:+-                   ");
            System.out.println("   //    :+`                                 :/`                   +         `o-:+`                 ");
            System.out.println("    :+`   `//`                              :/                     o          `s`-o`                ");
            System.out.println("     -+`    .//-                           -+                     .o           o. -+                ");
            System.out.println("      `+-     `-/:-.                     `-s                      +-           o.  /:               ");
            System.out.println("       `//`      `.-:::---.....-------::::s.                     .o           `s   `s               ");
            System.out.println("         .+:`         ````......``````   :/                     `o.           //    s`              ");
            System.out.println("           -/:`                         `o`                     +-           .o`    s`              ");
            System.out.println("             ./:`                       -/                    `+-           `o.     s`              ");
            System.out.println("               .:/-`                    +.                   `+-           `o-      s               ");
            System.out.println("                 `-/:.`                 o`                  .+-           -+.      `o               ");
            System.out.println("                    `-/:-.`             o`                `//`          ./:`       :-               ");
            System.out.println("                       `.-:::-.``       :`              `:/.          .//.        ./                ");
            System.out.println("                            `.--::::-.-:+`            .:/.         `-/:.        .::`                ");
            System.out.println("                                  `.://:`          `.//.        `-:/-`       .-/-`                  ");
            System.out.println("                                  -/-`          `-/+:.````...-:/s:.      `.-/-.                     ");
            System.out.println("                                 `o         .::::-:---------..` o       `+-`                        ");
            System.out.println("                                  o`      `-:-`                 ::      .+                          ");
            System.out.println("                                  o`     ./.                     +`     +.                          ");
            System.out.println("                                 `o     .o`                      +.     +                           ");
            System.out.println("                                 ::     o.                      `o`     /`                          ");
            System.out.println("                                `o`    :+                      `+-      `+-                         ");
            System.out.println("                                :/     y`                    ./o/-`      `:/.                       ");
            System.out.println("                               `o`     h/-                  -+. `-s`       `//.`                    ");
            System.out.println("                              `o.      y`o`                 o`    o.         `:/:`                  ");
            System.out.println("                              /:       s.o.                 -o.``:s.`           .:/:.`       ````   ");
            System.out.println("                             :/        :o-                   `///-`-:/:.         ...:///::::/::://` ");
            System.out.println("                            :/         `o.`..``                       .:+.        .-:/::/++-`    .+:");
            System.out.println("                           -+  `://`    `/:..::/-                       `+:`               -+-    `s");
            System.out.println("                          -o      -+            //                        -//:.```         `/o-:--:.");
            System.out.println("                          /:     `/o-:::::::`   `s                           `-:::::::::--:-`       ");
            System.out.println("                           :/::://-        `:////-  ");
        }else if (equipo.get(0).getNombre() == "TAUROS" ) {
            System.out.println("(\"                                                           .'`.'\\n\");\n" +
"    (\"                                                          `     '\\n\");\n" +
"    (\"                                             ,-'.`.        `    ``\\n\");\n" +
"    (\"            '\\\"--.                          /'      \\\\        |    |\\n\");\n" +
"    (\"             \\\\   `                         '.      `.      ',    '\\n\");\n" +
"    (\"              .   |                          `- _,.\\\"-._-._   `. /\\n\");\n" +
"    (\"              '   |,`.----.                            \\\"-.`.  |'\\n\");\n" +
"    (\" ,\\\".        .'    '       '---.                            \\\\\\\\ ||\\n\");\n" +
"    (\" | :     ,-'|    .             '                            ..||\\n\");\n" +
"    (\" |  `._.',||`._.'|              \\\\.                          ||||\\n\");\n" +
"    (\" `.   / ._| `-...'\\\\              \\\\`._                       |. '\\n\");\n" +
"    (\"  _,-'             . `--.         \\\\  `.                     '.'\\n\");\n" +
"    (\".\\\" .'             _|     `-`\\\".     .   `.                 .'.\\n\");\n" +
"    (\" '-....'          |           `-. _.'    `._           _.','\\n\");\n" +
"    (\"  `.             .'                .-       `.       .'_,'\\n\");\n" +
"    (\"    `..__....._ `.               ,'           `-._ .',\\\"\\n\");\n" +
"    (\"          /    `.|               '                `.'....__\\n\");\n" +
"    (\"         .                   _:.]                   `\\\"''-._`.\\n\");\n" +
"    (\"         '                 :\\\"    '                   `.    `. .\\n\");\n" +
"    (\"          \\\\                |                                 `.`.\\n\");\n" +
"    (\"           .               |                           .       ` .\\n\");\n" +
"    (\"           |               '         |                          ` .\\n\");\n" +
"    (\"           '.             .          |                  '        .|\\n\");\n" +
"    (\"             |`.          |          |                  |        ||\\n\");\n" +
"    (\"             |  `.        '          '                  |       . '\\n\");\n" +
"    (\"             |    \\\"--.     |        /_                  |     -'   |\\n\");\n" +
"    (\"             |        `.   |       /  `'\\\"\\\"`-._          |    ,'    |\\n\");\n" +
"    (\"             '        ,\\\"'..|      .      '    `.        |    |.    |\\n\");\n" +
"    (\"              .     ,'     '.     |\\\\    .       `       |      | ,/\\n\");\n" +
"    (\"              |    /        |     | .   |        `.     |      `'\\n\");\n" +
"    (\"              |   .         |    ,' |  .           \\\\    |\\n\");\n" +
"    (\"              |   |         |    .  | .'            .__ '\\n\");\n" +
"    (\"              '-..|         |___.   '\\\"              |../\\n\");\n" +
"    (\"             /.-'           \\\\ .'\\n\");"); 
        }else if (equipo.get(0).getNombre() == "DITTO" ) {
            System.out.println("(\"                                           ,--._\\n\");\n" +
"    (\"                                        _,'     `.\\n\");\n" +
"    (\"                              ,.-------\\\"          `.\\n\");\n" +
"    (\"                             /                 \\\"    `-.__\\n\");\n" +
"    (\"                            .         \\\"        _,        `._\\n\");\n" +
"    (\"                            |            __..-\\\"             `.\\n\");\n" +
"    (\"                            |        ''\\\"'                     `._\\n\");\n" +
"    (\"                            |                                    `\\\"-.\\n\");\n" +
"    (\"                            '                                        `.\\n\");\n" +
"    (\"                           .                                          |\\n\");\n" +
"    (\"                          /                                           |\\n\");\n" +
"    (\"                       _,'                                           ,'\\n\");\n" +
"    (\"                     ,\\\"                                             /\\n\");\n" +
"    (\"                    .                                              /\\n\");\n" +
"    (\"                    |                                             /\\n\");\n" +
"    (\"                    |                                            .\\n\");\n" +
"    (\"                    '                                            |\\n\");\n" +
"    (\"                     `.                                          |\\n\");\n" +
"    (\"                       `.                                        |\\n\");\n" +
"    (\"                         `.                                      '\\n\");\n" +
"    (\"                           .                                      .\\n\");\n" +
"    (\"                           |                                       `.\\n\");\n" +
"    (\"                           '                                        |\\n\");\n" +
"    (\"                         ,'                                         |\\n\");\n" +
"    (\"                       ,'                                           '\\n\");\n" +
"    (\"                      /                                _...._      /\\n\");\n" +
"    (\"                     .                              ,-'      `\\\"'--'\\n\");\n" +
"    (\"      ___            |                            ,'\\n\");\n" +
"    (\"   ,-'   `\\\"-._     _.'                          ,'\\n\");\n" +
"    (\"  /           `\\\"--'             _,....__     _,'\\n\");\n" +
"    (\" '                            .'        `---'\\n\");\n" +
"    (\" `                 ____     ,'\\n\");\n" +
"    (\"  .           _.-'\\\"    `---'\\n\");"); 
        }else if (equipo.get(0).getNombre() == "SNORLAX" ) {
            System.out.println(" (\"      ::                                              \\n\");\n" +
"    (\"      HHH:                   :HH                      \\n\");\n" +
"    (\"      HHHHH:               :HHHH                      \\n\");\n" +
"    (\"      HHHHHH: :HHHHHHHHH: :HHHHH                      \\n\");\n" +
"    (\"      HHHHHHHHHHHHHHHHHHH:HHHHHH                      \\n\");\n" +
"    (\"      :HHHHHHHHHHHHHHHHHHHHHHHHH                      \\n\");\n" +
"    (\"      ,HHHHHHHH:,,,,:HHHH:,,:HHH                      \\n\");\n" +
"    (\"       HHHHHH:,      ,:H:    ,:H                      \\n\");\n" +
"    (\"       HHHHH:,  :HH:  ,:  :H: ,:                      \\n\");\n" +
"    (\"      :HHHH:,,:H             :H,:                     \\n\");\n" +
"    (\"      HHHHH,,,,       :::       H                     \\n\");\n" +
"    (\"      HHHH:,,,,      :::::      :,                    \\n\");\n" +
"    (\"      HHHH,,,,,,    ,:::::,     ,:                    \\n\");\n" +
"    (\"     ,HHHH,,,,,,,   H::,,:H     ,H,                   \\n\");\n" +
"    (\"     :HHHH,,,,,,,,  H: ,, H    ,,HH:,:HHHH:,          \\n\");\n" +
"    (\"     H:::HHHH:,,,,,:HHHHHHHHHHHH:HHHHHHHHHHH:         \\n\");\n" +
"    (\"    ::HHHH:,:H:,:HH::,,         ,:HHH ,HHHHHH:        \\n\");\n" +
"    (\"   :HHHHHHHH:, HH::,,             ,:H :HHHHHHH:       \\n\");\n" +
"    (\"  :HHHHHHHHHHHHH:,,,               ,:HH:,, HHHH:      \\n\");\n" +
"    (\"  HHHHHHHHHHHH:, :,                  :H,,  HHHHH      \\n\");\n" +
"    (\" ,HHHHHHHHHHHHH: H,                   :H  :HHHHH:     \\n\");\n" +
"    (\" :HHHHHHHHHHHHHH:,                     :HHHHHHHHH     \\n\");\n" +
"    (\" HHHHHHHHHHHHHH,,,                      :HHHHHHHH     \\n\");\n" +
"    (\",HHHHHHHHHHHHH:,,,,                     ,:HHHHHH:     \\n\");\n" +
"    (\":HHHHHHHHHHHH:,,,,,,                    ,,HHH: HHH:   \\n\");\n" +
"    (\"HHHHHHHHHHHH:,,,,,,:,                   ,,HHH, HH,H H:\\n\");\n" +
"    (\"HHHHHHHHHHHH,,:,,,H H,                 ,,:HH:,,:, H:,H\\n\");\n" +
"    (\"HHHHHHHHHHH:,: :,:   :,,H:            ,,,H::::H :H:, H\\n\");\n" +
"    (\"HHHHHHHHHHH,,H  HH,  H:H,H,,        ,,,,:H::,,     : :\\n\");\n" +
"    (\"HHHHHHHHHHH,:,  ::,, :H, H,,,,,,,,,,,,,,H::,,      ,: \\n\");\n" +
"    (\":HHHHHHHHHHHH,,:,,:H:,:, :,,,,,,,,,,,,,:H:,,,       H \\n\");\n" +
"    (\",HHHHHHHHHH:,:H,      ,:H,,,,,,,,,,,,,:H::,,        : \\n\");\n" +
"    (\" HHHHHHHHHH,,,,         ,:,,,,,,,,:HHHHH:,,,   ,:,  ,:\\n\");\n" +
"    (\" HHHHHHHHHH,,,           H,,,:HHHHHHHHHH:,,   ,:::,  H\\n\");\n" +
"    (\" HHHHHHHHH:,,,   ,:::,   :::HHHHHHHHHHHH:,,   :::::  H\\n\");\n" +
"    (\" HHHHHHHHH,,,    :::::,  ,HHHHHHHHHHHHHH:,,   :::::  H\\n\");\n" +
"    (\" HHHHHHHHH,,,   ,::::::   HHHHHHHHHHHHHH:,,   ::::, ,:\\n\");\n" +
"    (\" HHHHHHHHH,,,   :::::::   HHHHHHHHHHHHHH:,,   ,::,  : \\n\");\n" +
"    (\" HHHHHHHHH,,,   :::::::   HHHHHHHHHHHHHH:,,    ,,   H \\n\");\n" +
"    (\" :HHHHHHHH,,,   :::::::   HHHHHHHHHHHHHH:,,,       ,: \\n\");\n" +
"    (\" ,HHHHHHHH,,,   ::::::,   HHHHHHHHHHHHHHH:,,      ,:  \\n\");\n" +
"    (\"  HHHHHHHH,,,   ,:::::   ,HHHHHHHHHHHHHHH:,,,,  ,,H   \\n\");\n" +
"    (\"  :HHHHHHH,,,    ,:::,   :HHHHHHHHHHHHHHHH:,,,,,H:    \\n\");\n" +
"    (\"   :HHHHHH:,,,    ,:,   ,HHHHHHHHHHHHHHHHHHHHHH:      \\n\");\n" +
"    (\"    :HHHHHH,,,          :HHHHHHHHHHHHHHHHHH:,         \\n\");\n" +
"    (\"     :HHHHH:,,,        ,HHHHHHHHH:,                   \\n\");\n" +
"    (\"      :HHHHH:,,,      ,:HHHHHH:,                      \\n\");\n" +
"    (\"        H:HHH:,,,    ,:HH:,                           \\n\");\n" +
"    (\"              :HHHHHH:\\n\");");
        }      
    }
    
    public void combate2(ArrayList<Pokemon> equipo) {

        dibujoGimnasio();
        continuar();
        dibujoOscar();
                
        Entrenador ash = new Entrenador();
        ArrayList<Pokemon> listaCombateash = new ArrayList<>();

        //RELLENO DE POKEMONS RANDOM  A ASH
        for (int i = 0; i < 4; i++) {
            int numeroRandom = new Random().nextInt(pokemons.size());
            listaCombateash.add(pokemons.get(numeroRandom));
            pokemons.remove(numeroRandom);
        }
        ash.setpokemons(listaCombateash);

        //AQUI SE COMBATE  
        int turnos = 20;
        for (int i = 0; i < turnos; i++) {
            imprimirEspaciosLargo();
            System.out.println("\n\nTURNO " + (i + 1) + "\n.");
            Scanner scanner = new Scanner(System.in);
            dibujoPokemonCombate(listaCombateash);
            System.out.println("TURNO LIDER DE GIMNASIO OSCAR");
            System.out.println("INFORMACION CPU: ");
            System.out.println("\tPOKEMON EN BATALLA: " + listaCombateash.get(0).getNombre());
            System.out.println("\tPUNTOS DE VIDA: " + listaCombateash.get(0).getVida());
            System.out.println("\tNIVEL: " + listaCombateash.get(0).getNivel());
            System.out.println("\tPUNTOS DE ATAQUE: " + listaCombateash.get(0).getPuntosAtaque());
            System.out.println("\tPUNTOS DE DEFENSA: " + listaCombateash.get(0).getPuntosDefensa());
            System.out.println("================================================================================");
            continuar();

            //EMPIEZA A ATACAR LA CPU
            ataqueCPU(listaCombateash);
            int pokemons_debilitados_ash = 0;
            //METODO QUE COMPRUEBA SI EL POKEMON EN EL CAMPO TIENE VIDA. 
            if (equipo.get(0).getVida() <= 0) {
                pokemons_debilitados_ash++;
                System.out.println(equipo.get(0).getNombre() + " HA SIDO DEBILITADO");
                continuar();
                equipo.remove(0);
                //METODO QUE COMPRUEBA SI A EL RIVAL LE QUEDAN POKEMONS VIVOS. 
                if (equipo.isEmpty()) {
                    System.out.println("NO TE QUEDAN MAS POKEMONS...");
                    continuar();
                    break;
                }
            }
            //===============================================================================
            ataqueEntrenador(listaCombateash);

            if (listaCombateash.get(0).getVida() <= 0) {
                System.out.println(listaCombateash.get(0).nombre + "HA SIDO DEBILITADO");
                listaCombateash.remove(0);
                //METODO QUE COMPRUEBA SI A EL RIVAL LE QUEDAN POKEMONS VIVOS. 
                if (listaCombateash.isEmpty()) {
                    System.out.println("A ENTRENADOR OSCAR NO LE QUEDAN MAS POKEMONS.");
                    continuar();
                    dibujoOscar2();
                    System.out.println("ENHORABUENA, GANASTE EL COMBATE.");
                    System.out.println("COMO RECOMPENSA HAS OBTENIDO LA MEDALLA AGUA.\n YA PUEDES VERLA EN TU ALBUM DE MEDALLAS.");
                    dibujoMedalla();
                    continuar();
                    System.out.println("TAMBIEN TE DARE ALGO DE DINERO PARA COMPRAR PROTEINAS... QUE FALTA TE HACE....");
                    System.out.println("ENTRENADOR RECIBIO 1000 MONEDAS");
                    setDinero(dinero+1000);
                    añadirMedallaAgua();
                    mostrarMedallas(listaMedallas);
                    continuar();
                    break;
                }
            }
        }
    }

    private void cambiarPokemon(ArrayList<Pokemon> equipo) {
        System.out.println("ESCOGE UN POKEMON PARA COMBATIR:");
        for (int i = 0; i < equipo.size(); i++) {
            System.out.println(i + 1 + ". " + equipo.get(i).getNombre());
        }
        Scanner scanner = new Scanner(System.in);
        int opcionElegida = Integer.parseInt(scanner.nextLine());
        Pokemon sustituido = equipo.get(opcionElegida - 1);

        for (int i = opcionElegida - 1; i > 0; i--) {
            equipo.set(i, equipo.get(i - 1));
        }
        equipo.set(0, sustituido);
    }

    private void ataqueCPU(ArrayList<Pokemon> listaCombateash) {
        int randomNumber = (int) (Math.random() * 100 + 1);
        int vida_restante = 0;
        int danio_realizado = 0;
        int danio_realizado2 = 0;
        int danio_total = 0;
        int defensa_total = equipo.get(0).getPuntosDefensa() / 3;
        int pokemons_debilitados_ash = 0;
        if (randomNumber <= 95) {
            int ataqueRandom = (int) (Math.random() * 100 + 1);
            if (ataqueRandom >= 0 && ataqueRandom <= 24) {
                //INDICE 0 
                if (listaCombateash.get(0) instanceof Planta) {
                    Planta planta = (Planta) listaCombateash.get(0);
                    planta.getPtsAtaquePlanta();
                    danio_realizado = (planta.getPtsAtaquePlanta() + planta.getPuntosAtaque()) / 2;
                    danio_realizado2 = (danio_realizado + planta.listaAtaques.get(0).getDaño());
                    danio_total = danio_realizado2 - (equipo.get(0).getPuntosDefensa() / 3);
                    vida_restante = equipo.get(0).getVida();
                    equipo.get(0).setVida(vida_restante - danio_total);
                    System.out.println("\nENTRENADOR RIVAL USO: \n\t" + planta.listaAtaques.get(0).getNombre());
                    System.out.println(danio_total);
                    continuar();
                } else if (listaCombateash.get(0) instanceof Agua) {
                    Agua agua = (Agua) listaCombateash.get(0);
                    agua.getPtsAtaqueAgua();
                    danio_realizado = (agua.getPtsAtaqueAgua() + agua.getPuntosAtaque()) / 2;
                    danio_realizado2 = (danio_realizado + agua.listaAtaques.get(0).getDaño());
                    danio_total = danio_realizado2 - (equipo.get(0).getPuntosDefensa() / 3);
                    vida_restante = equipo.get(0).getVida();
                    equipo.get(0).setVida(vida_restante - danio_total);
                    System.out.println("\nENTRENADOR RIVAL USO: \n\t" + agua.listaAtaques.get(0).getNombre());
                    System.out.println(danio_total);
                    continuar();
                } else if (listaCombateash.get(0) instanceof Fuego) {
                    Fuego fuego = (Fuego) listaCombateash.get(0);
                    fuego.getPtsAtaqueFuego();
                    danio_realizado = (fuego.getPtsAtaqueFuego() + fuego.getPuntosAtaque()) / 2;
                    danio_realizado2 = (danio_realizado + fuego.listaAtaques.get(0).getDaño());
                    danio_total = danio_realizado2 - (equipo.get(0).getPuntosDefensa() / 3);
                    vida_restante = equipo.get(0).getVida();
                    equipo.get(0).setVida(vida_restante - danio_total);
                    System.out.println("\nENTRENADOR RIVAL USO: \n\t" + fuego.listaAtaques.get(0).getNombre());
                    continuar();
                } else {
                    Normal normal = (Normal) listaCombateash.get(0);
                    normal.getPtsAtaqueNormal();
                    System.out.println(normal.listaAtaques.get(0).getNombre());
                    System.out.println(normal.getPtsAtaqueNormal());
                    danio_realizado = (normal.getPtsAtaqueNormal() + normal.getPuntosAtaque()) / 2;
                    danio_realizado2 = (danio_realizado + normal.listaAtaques.get(0).getDaño());
                    danio_total = danio_realizado2 - (equipo.get(0).getPuntosDefensa() / 3);
                    vida_restante = equipo.get(0).getVida();
                    equipo.get(0).setVida(vida_restante - danio_total);
                    System.out.println("\nENTRENADOR RIVAL USO: \n\t" + normal.listaAtaques.get(0).getNombre());
                    System.out.println(danio_total);
                    continuar();
                }
                //INDICE 1
            } else if (ataqueRandom >= 25 && ataqueRandom <= 49) {
                if (listaCombateash.get(0) instanceof Planta) {
                    Planta planta = (Planta) listaCombateash.get(0);
                    planta.getPtsAtaquePlanta();
                    danio_realizado = (planta.getPtsAtaquePlanta() + planta.getPuntosAtaque()) / 2;
                    danio_realizado2 = (danio_realizado + planta.listaAtaques.get(1).getDaño());
                    danio_total = danio_realizado2 - (equipo.get(0).getPuntosDefensa() / 3);
                    vida_restante = equipo.get(0).getVida();
                    equipo.get(0).setVida(vida_restante - danio_total);
                    System.out.println("\nENTRENADOR RIVAL USO: \n\t" + planta.listaAtaques.get(1).getNombre());
                    System.out.println(danio_total);
                    continuar();
                } else if (listaCombateash.get(0) instanceof Agua) {
                    Agua agua = (Agua) listaCombateash.get(0);
                    agua.getPtsAtaqueAgua();
                    danio_realizado = (agua.getPtsAtaqueAgua() + agua.getPuntosAtaque()) / 2;
                    danio_realizado2 = (danio_realizado + agua.listaAtaques.get(1).getDaño());
                    danio_total = danio_realizado2 - (equipo.get(0).getPuntosDefensa() / 3);
                    vida_restante = equipo.get(0).getVida();
                    equipo.get(0).setVida(vida_restante - danio_total);
                    System.out.println("\nENTRENADOR RIVAL USO: \n\t" + agua.listaAtaques.get(1).getNombre());
                    System.out.println(danio_total);
                    continuar();
                } else if (listaCombateash.get(0) instanceof Fuego) {
                    Fuego fuego = (Fuego) listaCombateash.get(0);
                    fuego.getPtsAtaqueFuego();
                    danio_realizado = (fuego.getPtsAtaqueFuego() + fuego.getPuntosAtaque()) / 2;
                    danio_realizado2 = (danio_realizado + fuego.listaAtaques.get(1).getDaño());
                    danio_total = danio_realizado2 - (equipo.get(0).getPuntosDefensa() / 3);
                    vida_restante = equipo.get(0).getVida();
                    equipo.get(0).setVida(vida_restante - danio_total);
                    System.out.println("\nENTRENADOR RIVAL USO: \n\t" + fuego.listaAtaques.get(1).getNombre());
                    System.out.println(danio_total);
                    continuar();
                } else {
                    Normal normal = (Normal) listaCombateash.get(0);
                    normal.getPtsAtaqueNormal();
                    danio_realizado = (normal.getPtsAtaqueNormal() + normal.getPuntosAtaque()) / 2;
                    danio_realizado2 = (danio_realizado + normal.listaAtaques.get(1).getDaño());
                    danio_total = danio_realizado2 - (equipo.get(0).getPuntosDefensa() / 3);
                    vida_restante = equipo.get(0).getVida();
                    equipo.get(0).setVida(vida_restante - danio_total);
                    System.out.println("\nENTRENADOR RIVAL USO: \n\t" + normal.listaAtaques.get(1).getNombre());
                    System.out.println(danio_total);
                    continuar();
                }
                //INDICE 2
            } else if (ataqueRandom >= 50 && ataqueRandom <= 74) {
                if (listaCombateash.get(0) instanceof Planta) {
                    Planta planta = (Planta) listaCombateash.get(0);
                    planta.getPtsAtaquePlanta();
                    danio_realizado = (planta.getPtsAtaquePlanta() + planta.getPuntosAtaque()) / 2;
                    danio_realizado2 = (danio_realizado + planta.listaAtaques.get(2).getDaño());
                    danio_total = danio_realizado2 - (equipo.get(0).getPuntosDefensa() / 3);
                    vida_restante = equipo.get(0).getVida();
                    equipo.get(0).setVida(vida_restante - danio_total);
                    System.out.println("\nENTRENADOR RIVAL USO: \n\t" + planta.listaAtaques.get(2).getNombre());
                    System.out.println(danio_total);
                    continuar();
                } else if (listaCombateash.get(0) instanceof Agua) {
                    Agua agua = (Agua) listaCombateash.get(0);
                    agua.getPtsAtaqueAgua();
                    System.out.println(agua.listaAtaques.get(2).getNombre());
                    System.out.println(agua.getPtsAtaqueAgua());
                    danio_realizado = (agua.getPtsAtaqueAgua() + agua.getPuntosAtaque()) / 2;
                    danio_realizado2 = (danio_realizado + agua.listaAtaques.get(2).getDaño());
                    danio_total = danio_realizado2 - (equipo.get(0).getPuntosDefensa() / 3);
                    vida_restante = equipo.get(0).getVida();
                    equipo.get(0).setVida(vida_restante - danio_total);
                    System.out.println("\nENTRENADOR RIVAL USO: \n\t" + agua.listaAtaques.get(2).getNombre());
                    System.out.println(danio_total);
                    continuar();
                } else if (listaCombateash.get(0) instanceof Fuego) {
                    Fuego fuego = (Fuego) listaCombateash.get(0);
                    fuego.getPtsAtaqueFuego();
                    System.out.println(fuego.listaAtaques.get(2).getNombre());
                    System.out.println(fuego.getPtsAtaqueFuego());
                    danio_realizado = (fuego.getPtsAtaqueFuego() + fuego.getPuntosAtaque()) / 2;
                    danio_realizado2 = (danio_realizado + fuego.listaAtaques.get(2).getDaño());
                    danio_total = danio_realizado2 - (equipo.get(0).getPuntosDefensa() / 3);
                    vida_restante = equipo.get(0).getVida();
                    equipo.get(0).setVida(vida_restante - danio_total);
                    System.out.println("DAÑO REALIZADO POR: \n" + fuego.listaAtaques.get(2).getNombre());
                    System.out.println(danio_total);
                    continuar();
                } else {
                    Normal normal = (Normal) listaCombateash.get(0);
                    normal.getPtsAtaqueNormal();
                    danio_realizado = (normal.getPtsAtaqueNormal() + normal.getPuntosAtaque()) / 2;
                    danio_realizado2 = (danio_realizado + normal.listaAtaques.get(2).getDaño());
                    danio_total = danio_realizado2 - (equipo.get(0).getPuntosDefensa() / 3);
                    vida_restante = equipo.get(0).getVida();
                    equipo.get(0).setVida(vida_restante - danio_total);
                    System.out.println("\nENTRENADOR RIVAL USO: \n\t" + normal.listaAtaques.get(2).getNombre());
                    System.out.println(danio_total);
                    continuar();
                }
                //INDICE 3
            } else if (ataqueRandom >= 75 && ataqueRandom <= 100) {
                if (listaCombateash.get(0) instanceof Planta) {
                    Planta planta = (Planta) listaCombateash.get(0);
                    planta.getPtsAtaquePlanta();
                    danio_realizado = (planta.getPtsAtaquePlanta() + planta.getPuntosAtaque()) / 2;
                    danio_realizado2 = (danio_realizado + planta.listaAtaques.get(3).getDaño());
                    danio_total = danio_realizado2 - (equipo.get(0).getPuntosDefensa() / 3);
                    vida_restante = equipo.get(0).getVida();
                    equipo.get(0).setVida(vida_restante - danio_total);
                    System.out.println("\nENTRENADOR RIVAL USO: \n\t" + planta.listaAtaques.get(3).getNombre());
                    System.out.println(danio_total);
                    continuar();
                } else if (listaCombateash.get(0) instanceof Agua) {
                    Agua agua = (Agua) listaCombateash.get(0);
                    agua.getPtsAtaqueAgua();
                    System.out.println(agua.listaAtaques.get(3).getNombre());
                    System.out.println(agua.getPtsAtaqueAgua());
                    danio_realizado = (agua.getPtsAtaqueAgua() + agua.getPuntosAtaque()) / 2;
                    danio_realizado2 = (danio_realizado + agua.listaAtaques.get(3).getDaño());
                    danio_total = danio_realizado2 - (equipo.get(0).getPuntosDefensa() / 3);
                    vida_restante = equipo.get(0).getVida();
                    equipo.get(0).setVida(vida_restante - danio_total);
                    System.out.println("\nENTRENADOR RIVAL USO: \n\t" + agua.listaAtaques.get(3).getNombre());
                    System.out.println(danio_total);
                    continuar();
                } else if (listaCombateash.get(0) instanceof Fuego) {
                    Fuego fuego = (Fuego) listaCombateash.get(0);
                    fuego.getPtsAtaqueFuego();
                    System.out.println(fuego.listaAtaques.get(3).getNombre());
                    System.out.println(fuego.getPtsAtaqueFuego());
                    danio_realizado = (fuego.getPtsAtaqueFuego() + fuego.getPuntosAtaque()) / 2;
                    danio_realizado2 = (danio_realizado + fuego.listaAtaques.get(3).getDaño());
                    danio_total = danio_realizado2 - (equipo.get(0).getPuntosDefensa() / 3);
                    vida_restante = equipo.get(0).getVida();
                    equipo.get(0).setVida(vida_restante - danio_total);
                    System.out.println("\nENTRENADOR RIVAL USO: \n\t" + fuego.listaAtaques.get(3).getNombre());
                    System.out.println(danio_total);
                    continuar();
                } else {
                    Normal normal = (Normal) listaCombateash.get(0);
                    normal.getPtsAtaqueNormal();
                    danio_realizado = (normal.getPtsAtaqueNormal() + normal.getPuntosAtaque()) / 2;
                    danio_realizado2 = (danio_realizado + normal.listaAtaques.get(3).getDaño());
                    danio_total = danio_realizado2 - (equipo.get(0).getPuntosDefensa() / 3);
                    vida_restante = equipo.get(0).getVida();
                    equipo.get(0).setVida(vida_restante - danio_total);
                    System.out.println("\nENTRENADOR RIVAL USO: \n\t" + normal.listaAtaques.get(3).getNombre());
                    System.out.println(danio_total);
                    continuar();
                }
            }

        } else {
            System.out.println("EL ATAQUE DE " + listaCombateash.get(0).getNombre() + " FALLO\n\n");
            continuar();
        }
    }

    private void ataqueEntrenador(ArrayList<Pokemon> listaCombateash) {
        Scanner scanner = new Scanner(System.in);
        imprimirEspacios();
        dibujoPokemonCombateEntrenador();
        System.out.println("TURNO ENTRENADOR");
        System.out.println("\tPOKEMON EN BATALLA: " + equipo.get(0).getNombre());
        System.out.println("\tPUNTOS DE VIDA: " + equipo.get(0).getVida());
        System.out.println("\tPUNTOS DE ATAQUE: " + equipo.get(0).getPuntosAtaque());
        System.out.println("1. ATACAR");
        System.out.println("2. CAMBIAR DE POKEMON");
        int accionJugador = scanner.nextInt();
        int vida_restante = 0;
        int danio_realizado = 0;
        int danio_realizado2 = 0;
        int danio_total = 0;
        if (accionJugador == 1) {
            System.out.println("\nLISTA ATAQUES:");
            //SI ES PLANTA MUESTRO LISTA DE ATAQUES
            if (equipo.get(0) instanceof Planta) {
                Planta planta = (Planta) equipo.get(0);
                System.out.println("SELECCIONA UN ATAQUE:");
                for (int i = 0; i < planta.listaAtaques.size(); i++) {
                    System.out.println("\t" + (i + 1) + ": " + planta.listaAtaques.get(i).getNombre());
                }
                int eleccionAtaque = scanner.nextInt() - 1;
                if (eleccionAtaque >= 0 && eleccionAtaque < planta.listaAtaques.size()) {
                    Ataques ataqueElegido = planta.listaAtaques.get(eleccionAtaque);
                    int danioRealizado = (planta.getPtsAtaquePlanta() + planta.getPuntosAtaque()) / 2;
                    danioRealizado = (danioRealizado + ataqueElegido.getDaño());
                    int danioTotal = danioRealizado - (listaCombateash.get(0).getPuntosDefensa() / 3);
                    int vidaRestante = listaCombateash.get(0).getVida();
                    listaCombateash.get(0).setVida(vidaRestante - danioTotal);
                    System.out.println("\n\nENTRENADOR USO: \n" + ataqueElegido.getNombre());
                    System.out.println(danioTotal);
                    continuar();
                } else {
                    System.out.println("OPCION INVALIDA");
                }
                //SI ES AGUA MUESTRO LISTA DE ATAQUES
            } else if (equipo.get(0) instanceof Agua) {
                Agua agua = (Agua) equipo.get(0);
                System.out.println("SELECCIONA UN ATAQUE:");
                for (int i = 0; i < agua.listaAtaques.size(); i++) {
                    System.out.println("\t" + (i + 1) + ": " + agua.listaAtaques.get(i).getNombre());
                }
                int eleccionAtaque = scanner.nextInt() - 1;
                if (eleccionAtaque >= 0 && eleccionAtaque < agua.listaAtaques.size()) {
                    Ataques ataqueElegido = agua.listaAtaques.get(eleccionAtaque);
                    int danioRealizado = (agua.getPtsAtaqueAgua() + agua.getPuntosAtaque()) / 2;
                    danioRealizado = (danioRealizado + ataqueElegido.getDaño());
                    int danioTotal = danioRealizado - (listaCombateash.get(0).getPuntosDefensa() / 3);
                    int vidaRestante = listaCombateash.get(0).getVida();
                    listaCombateash.get(0).setVida(vidaRestante - danioTotal);
                    System.out.println("\n\nENTRENADOR USO: \n" + ataqueElegido.getNombre());
                    System.out.println(danioTotal);
                    continuar();
                } else {
                    System.out.println("OPCION INVALIDA");
                }
                //SI ES FUEGO MUESTRO LA LISTA DE ATAQUES DE FUEGO
            } else if (equipo.get(0) instanceof Fuego) {
                Fuego fuego = (Fuego) equipo.get(0);
                System.out.println("SELECCIONA UN ATAQUE:");
                for (int i = 0; i < fuego.listaAtaques.size(); i++) {
                    System.out.println("\t" + (i + 1) + ": " + fuego.listaAtaques.get(i).getNombre());
                }
                int eleccionAtaque = scanner.nextInt() - 1;
                if (eleccionAtaque >= 0 && eleccionAtaque < fuego.listaAtaques.size()) {
                    Ataques ataqueElegido = fuego.listaAtaques.get(eleccionAtaque);
                    int danioRealizado = (fuego.getPtsAtaqueFuego() + fuego.getPuntosAtaque()) / 2;
                    danioRealizado = (danioRealizado + ataqueElegido.getDaño());
                    int danioTotal = danioRealizado - (listaCombateash.get(0).getPuntosDefensa() / 3);
                    int vidaRestante = listaCombateash.get(0).getVida();
                    listaCombateash.get(0).setVida(vidaRestante - danioTotal);
                    System.out.println("\n\nENTRENADOR USO: \n" + ataqueElegido.getNombre());
                    System.out.println(danioTotal);
                    continuar();
                } else {
                    System.out.println("OPCION INVALIDA");
                }
                //SI ES NORMAL MUESTRO LA LISTA DE ATAQUES DE NORMAL
            } else if (equipo.get(0) instanceof Normal) {
                Normal normal = (Normal) equipo.get(0);
                System.out.println("SELECCIONA UN ATAQUE:");
                for (int i = 0; i < normal.listaAtaques.size(); i++) {
                    System.out.println("\t" + (i + 1) + ": " + normal.listaAtaques.get(i).getNombre());
                }
                int eleccionAtaque = scanner.nextInt() - 1;
                if (eleccionAtaque >= 0 && eleccionAtaque < normal.listaAtaques.size()) {
                    Ataques ataqueElegido = normal.listaAtaques.get(eleccionAtaque);
                    int danioRealizado = (normal.getPtsAtaqueNormal() + normal.getPuntosAtaque()) / 2;
                    danioRealizado = (danioRealizado + ataqueElegido.getDaño());
                    int danioTotal = danioRealizado - (listaCombateash.get(0).getPuntosDefensa() / 3);
                    int vidaRestante = listaCombateash.get(0).getVida();
                    listaCombateash.get(0).setVida(vidaRestante - danioTotal);
                    System.out.println("\n\nENTRENADOR USO: \n" + ataqueElegido.getNombre());
                    System.out.println(danioTotal);
                    continuar();
                } else {
                    System.out.println("OPCION INVALIDA");
                }
            }
        }
        if (accionJugador == 2) {
            cambiarPokemon(equipo);
            System.out.println("CAMBIASTE DE POKEMON ");
        }
    }

    public void añadirMedallaAgua() {
        Medallas medallaAgua = new Medallas ("MEDALLA GYM OSCRACK");    
        listaMedallas.add(medallaAgua);
}

    private void mostrarMedallas(ArrayList<Medallas> listaMedallas) {
        imprimirEspaciosLargo();
        System.out.println("\t   MEDALLAS");
        System.out.println("        .-=========-.\n" +
"        \\'-=======-'/\n" +
"        _|   .=.   |_\n" +
"       ((|  {{1}}  |))\n" +
"        \\|   /|\\   |/\n" +
"         \\__ '`' __/\n" +
"           _`) (`_\n" +
"         _/_______\\_\n" +
"        /___________\\");
        System.out.println("=============================");
        System.out.println("MEDALLAS DE " + nombre);
        System.out.println(listaMedallas);
        System.out.println("=============================");
        continuar();
    }

    public void modoHistoria(ArrayList<Pokemon> pokemons) throws InterruptedException  {
        while (true) {
            imprimirEspaciosLargo();
            dibujoCasa();
            System.out.println("        ____________ _______________________________ ____________");
            System.out.println("       /     1.     |  ____________________________ |      5.     \\");
            System.out.println("      |   POKEMONS  | |9:25                 [][][]| |  BICICLETA  |");
            System.out.println("      |_____________| |                           | |_____________|");
            System.out.println("      |      2.     | |                           | |      6.     |");
            System.out.println("      |  FICHA ENT. | |           MENU            | |   CAPTURAR  |");
            System.out.println("      |_____________| |            DE             | |_____________|");
            System.out.println("      |      3.     | |         OPCIONES          | |      7.     |");
            System.out.println("      |    TIENDA   | |                           | | CENTRO POKE.|");
            System.out.println("      |_____________| |___________________________| |_____________|");
            System.out.println("      |      4.     |_______________________________|      8.     |");
            System.out.println("      |   MEDALLAS  |        0.   S A L I R         |   GIMNASIO  |");
            System.out.println("       \\____________|_______________________________|____________/");
            int opcion = scanner.nextInt();
            switch (opcion) {

                case 1:
                    mostrarEntrenador2();
                    System.out.println();
                    continuar();
                    break;
                case 2:
                    fichaEntrenador();
                    continuar();
                    break;
                case 3:
                    tienda();
                    continuar();
                    break;
                case 4:
                    mostrarMedallas(listaMedallas);
                    continuar();
                    break;
                case 5:
                    montarBici();
                    continuar();
                    break;
                case 6:
                    capturaHistoria(opcion);
                    imprimirEspaciosLargo();
                    break;
                case 7:
                    if (equipo.size() <= 0) {
                        imprimirEspaciosLargo();
                        System.out.println("            OH VAYA, PARECE QUE NO TIENES NINGUN POKEMON.");
                        continuar();
                        System.out.println("RECUERDA QUE CUANDO UN POKEMON ES DEBILITADO LO PIERDES DE TU EQUIPO.");
                        System.out.println("             ASEGURATE DE MANTENERLES CON ALGO DE VIDA.");
                        continuar();
                    } else {
                        centroPokemon();
                    }

                    break;
                case 8:
                    if (equipo.size() <= 0) {
                        imprimirEspaciosLargo();
                        System.out.println("NO TIENES POKEMONS COMO PARA ENFRENTARTE AL GRAN LIDER DE GIMNASIO.");
                        int bueno = scanner.nextInt();
                        continuar();
                    } else {
                        combate2(equipo);
                        mostrarEntrenador2();
                    }
                    break;
                case 0:
                    System.out.println("FIN DEL JUEGO!");
                    return; // Salir del programa

                default:
                    System.out.println("OPCION INVALIDA. GAME OVER");
                    break;
            }
        }
    }

    private void centroPokemon() {
        imprimirEspaciosLargo();
        System.out.println("          .---. .----..-. .-. .---. .----.  .----.    \n" +
"         /  ___}| {_  |  `| |{_   _}| {}  }/  {}  \\   \n" +
"         \\     }| {__ | |\\  |  | |  | .-. \\\\      /   \n" +
"          `---' `----'`-' `-'  `-'  `-' `-' `----'    \n" +
".----.  .----. .-. .-..----..-.   .-. .----. .-. .-.  \n" +
"| {}  }/  {}  \\| |/ / | {_  |  `.'  |/  {}  \\|  `| |  \n" +
"| .--' \\      /| |\\ \\ | {__ | |\\ /| |\\      /| |\\  |  \n" +
"`-'     `----' `-' `-'`----'`-' ` `-' `----' `-' `-' ");
        System.out.println("        _____       __________\n" +
        "        \\_+_/      |\n" +
        "       .//`\\\\.     |   _______\n" +
        "       ((o,o))     |  |       |\n" +
        "        '.=.'      |  |       |\n" +
        "        _)_(_      |  |       |\n" +
        "      /' \\ / '\\    |  | ,.,., |\n" +
        "     / (_ | _) \\   |  |_______|\n" +
        "    / / )_o_( \\ \\  |()\n" +
        "    \\ \\/     \\/ /  |\n" +
        "     \\/_)   (_\\/  _|__|~|_______\n" +
        "      |       |  |______________\n" +
        "      |       |   , ||, '\n" +
        "      |_______|     ||  ,\n" +
        "       \\  |  /      || ,\n");

            for (int i = 0; i < equipo.size(); i++) {
        equipo.get(0).setVida(150);
        }
        System.out.println("OH VAYA, PARECE QUE TUS POKEMONS ESTAN UN POCO DEBILES...");
        continuar();
        System.out.println("       UN MOMENTO, NOSOTROS NOS ENCARGAMOS.\n");
        tiempoEsperaLargo();
        System.out.println("\n  GENIAL, TUS POKEMONS ESTAN EN PLENA FORMA.");
        continuar();
    }

    private void fichaEntrenador() {
        imprimirEspaciosLargo();
        System.out.println("             ________________________________________________\n" +
"            /                                                \\\n" +
"           |    _________________________________________     |\n" +
"           |   |                                         |    |\n" +
"           |   |  DATOS                                  |    |\n" +
"           |   |  DE                                     |    |\n" +
"           |   |  ENTRENADOR:                            |    |\n" +
"           |   |                                         |    |\n" +
"           |   |                                         |    |\n" +
"           |   |   NOMBRE:  "+nombre+"                        |    |\n" +
"           |   |                                         |    |\n" +
"           |   |   APODO:   "+apellidos+"                        |    |\n" +
"           |   |                                         |    |\n" +
"           |   |                                         |    |\n" +
"           |   |                                         |    |\n" +
"           |   |                                         |    |\n" +
"           |   |_________________________________________|    |\n" +
"           |                                                  |\n" +
"            \\_________________________________________________/\n" +
"                   \\___________________________________/\n" +
"                ___________________________________________\n" +
"             _-'    .-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.  --- `-_\n" +
"          _-'.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.--.  .-.-.`-_\n" +
"       _-'.-.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-`__`. .-.-.-.`-_\n" +
"    _-'.-.-.-.-. .-----.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-----. .-.-.-.-.`-_\n" +
" _-'.-.-.-.-.-. .---.-. .-------------------------. .-.---. .---.-.-.-.`-_\n" +
":-------------------------------------------------------------------------:\n" +
"`---._.-------------------------------------------------------------._.---'");
        System.out.println("===========================================================================");
        System.out.println("\t\t\t     FICHA DE:" + apellidos);
        System.out.println("\t\t\t     POKEBALLS: " + pokeballs);
        System.out.println("\t\t\t     DINERO: " + dinero);
        System.out.println("===========================================================================");
        continuar();
    }

    private void continuar() {
    String apellidos = scanner.nextLine();
    }

    private void dibujoOscar() {
System.out.println("                 ,#####,\n" +
"                 #_   _#\n" +
"                 |a` `a|\n" +
"                 |  u  |\n" +
"                 \\  =  /\n" +
"                 |\\___/|\n" +
"        ___ ____/:     :\\____ ___\n" +
"      .'   `.-===-\\   /-===-.`   '.\n" +
"     /      .-\"\"\"\"\"-.-\"\"\"\"\"-.      \\\n" +
"    /'             =:=             '\\\n" +
"  .'  ' .:    o   -=:=-   o    :. '  `.\n" +
"  (.'   /'. '-.....-'-.....-' .'\\   '.)\n" +
"  /' ._/   \".     --:--     .\"   \\_. '\\\n" +
" |  .'|      \".  ---:---  .\"      |'.  |\n" +
" |  : |       |  ---:---  |       | :  |\n" +
"  \\ : |       |_____._____|       | : /\n" +
"  /   (       |----|------|       )   \\\n" +
" /... .|      |    |      |      |. ...\\\n" +
"|::::/'' jgs /     |       \\     ''\\::::|\n" +
"'\"\"\"\"       /'    .L_      `\\       \"\"\"\"'\n" +
"           /'-.,__/` `\\__..-'\\\n" +
"          ;      /     \\      ;\n" +
"          :     /       \\     |\n" +
"          |    /         \\.   |\n" +
"          |`../           |  ,/\n" +
"          ( _ )           |  _)\n" +
"          |   |           |   |\n" +
"          |___|           \\___|\n" +
"          :===|            |==|\n" +
"           \\  /            |__|\n" +
"           /\\/\\           /\"\"\"`8.__\n" +
"           |oo|           \\__.//___)\n" +
"           |==|\n" +
"           \\__/");
        System.out.println("LIDER DE GIMNASIO OSCAR:");
        continuar();
        System.out.println("VAYA VAYA... QUE TENEMOS POR AQUI...OTRO ENTRENADOR QUE QUIERE DESAFIARME?");
        continuar();
        System.out.println("PREPARATE PARA SENTIR EL PODER DE MIS BICEPS!!!");
        tiempoEspera();
        tiempoEsperaLargo();
        System.out.println("AL ATAQUE!!");
        imprimirEspaciosLargo();
    }

    private void dibujoGimnasio() {
        imprimirEspaciosLargo();
        System.out.println("                        ________  ____  ___              \n" +
"                       / ____/\\ \\/ /  |/  /              \n" +
"                      / / __   \\  / /|_/ /               \n" +
"                     / /_/ /   / / /  / /                \n" +
"                ____ \\____/ __/_/_/__/_/___   ________ __\n" +
"               / __ \\/ ___// ____/ __ \\/   | / ____/ //_/\n" +
"              / / / /\\__ \\/ /   / /_/ / /| |/ /   / ,<   \n" +
"             / /_/ /___/ / /___/ _, _/ ___ / /___/ /| |  \n" +
"             \\____//____/\\____/_/ |_/_/  |_\\____/_/ |_|  \n\n" +
"                \\`--.___,'=================`.___,--'/\n" +
"                 \\`--._.__                 __._,--'/\n" +
"                   \\  ,. l`~~~~~~~~~~~~~~~'l ,.  /\n" +
"       __            \\||(_)!_!_!_.-._!_!_!(_)||/            __\n" +
"       \\\\`-.__        ||_|____!!_|;|_!!____|_||        __,-'//\n" +
"        \\\\    `==---='-----------'='-----------`=---=='    //\n" +
"        | `--.                                         ,--' |\n" +
"         \\  ,.`~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~',.  /\n" +
"           \\||  ____,-------._,-------._,-------.____  ||/\n" +
"            ||\\|___!`=======\"!`=======\"!`=======\"!___|/||\n" +
"            || |---||--------||-| | |-!!--------||---| ||\n" +
"  __O_____O_ll_lO_____O_____O|| |'|'| ||O_____O_____Ol_ll_O_____O__\n" +
"  o H o o H o o H o o H o o |-----------| o o H o o H o o H o o H o\n" +
" ___H_____H_____H_____H____O =========== O____H_____H_____H_____H___\n" +
"                          /|=============|\\\n" +
"()______()______()______() '==== +-+ ====' ()______()______()______()\n" +
"||{_}{_}||{_}{_}||{_}{_}/| ===== |_| ===== |\\{_}{_}||{_}{_}||{_}{_}||\n" +
"||      ||      ||     / |==== s(   )s ====| \\     ||      ||      ||\n" +
"======================()  =================  ()======================\n" +
"----------------------/| ------------------- |\\----------------------\n" +
"                     / |---------------------| \\\n" +
"-'--'--'           ()  '---------------------'  ()\n" +
"                   /| ------------------------- |\\    --'--'--'\n" +
"       --'--'     / |---------------------------| \\    '--'\n" +
"                ()  |___________________________|  ()           '--'-\n" +
"  --'-          /| _______________________________  |\\\n" +
" --'           / |__________________________________| \\");    
    continuar();}
    
    private void dibujoOscar2() {
System.out.println("                 ,#####,\n" +
"                 #_   _#\n" +
"                 |a` `a|\n" +
"                 |  u  |\n" +
"                 \\  =  /\n" +
"                 |\\___/|\n" +
"        ___ ____/:     :\\____ ___\n" +
"      .'   `.-===-\\   /-===-.`   '.\n" +
"     /      .-\"\"\"\"\"-.-\"\"\"\"\"-.      \\\n" +
"    /'             =:=             '\\\n" +
"  .'  ' .:    o   -=:=-   o    :. '  `.\n" +
"  (.'   /'. '-.....-'-.....-' .'\\   '.)\n" +
"  /' ._/   \".     --:--     .\"   \\_. '\\\n" +
" |  .'|      \".  ---:---  .\"      |'.  |\n" +
" |  : |       |  ---:---  |       | :  |\n" +
"  \\ : |       |_____._____|       | : /\n" +
"  /   (       |----|------|       )   \\\n" +
" /... .|      |    |      |      |. ...\\\n" +
"|::::/'' jgs /     |       \\     ''\\::::|\n" +
"'\"\"\"\"       /'    .L_      `\\       \"\"\"\"'\n" +
"           /'-.,__/` `\\__..-'\\\n" +
"          ;      /     \\      ;\n" +
"          :     /       \\     |\n" +
"          |    /         \\.   |\n" +
"          |`../           |  ,/\n" +
"          ( _ )           |  _)\n" +
"          |   |           |   |\n" +
"          |___|           \\___|\n" +
"          :===|            |==|\n" +
"           \\  /            |__|\n" +
"           /\\/\\           /\"\"\"`8.__\n" +
"           |oo|           \\__.//___)\n" +
"           |==|\n" +
"           \\__/");
        System.out.println("OH MALDICION... ERES MAS FUERTE DE LO QUE PENSABA...");
        continuar();
        System.out.println("BUENO ME DA IGUAL, ME MARCHO A COMERME UNAS TOSTADAS DE AVENA.");
        continuar();

    }

    private void dibujoCasa() {
        System.out.println("                                     (   )\n" +
"                                   (    )\n" +
"                                    (    )\n" +
"                                   (    )\n" +
"                                     )  )\n" +
"                                    (  (                  /\\\n" +
"                                     (_)                 /  \\  /\\\n" +
"                             ________[_]________      /\\/    \\/  \\\n" +
"                    /\\      /\\        ______    \\    /   /\\/\\  /\\/\\\n" +
"                   /  \\    //_\\       \\    /\\    \\  /\\/\\/    \\/    \\\n" +
"            /\\    / /\\/\\  //___\\       \\__/  \\    \\/\n" +
"           /  \\  /\\/    \\//_____\\       \\ |[]|     \\\n" +
"          /\\/\\/\\/       //_______\\       \\|__|      \\\n" +
"         /      \\      /XXXXXXXXXX\\                  \\\n" +
"                 \\    /_I_II  I__I_\\__________________\\\n" +
"                        I_I|  I__I_____[]_|_[]_____I\n" +
"                        I_II  I__I_____[]_|_[]_____I\n" +
"                        I II__I  I     XXXXXXX     I\n" +
"                     ~~~~~\"   \"~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("EN CASA...");
    }

    private void dibujoMedalla() {
        System.out.println(" _______________\n" +
"|@@@@|     |####|\n" +
"|@@@@|     |####|\n" +
"|@@@@|     |####|\n" +
"\\@@@@|     |####/\n" +
" \\@@@|     |###/\n" +
"  `@@|_____|##'\n" +
"       (O)\n" +
"    .-'''''-.\n" +
"  .'  * * *  `.\n" +
" :  *       *  :\n" +
": ~   G Y M   ~ :\n" +
": ~ O S C A R ~ :\n" +
" :  *       *  :\n" +
"  `.  * * *  .'\n" +
"    `-.....-'");
        
    }

    private void tienda() {
        imprimirEspaciosLargo();
        System.out.println("               .-\"\"-.\n" +
"              /-.{}  \\\n" +
"              | _\\__.|\n" +
"              \\/^)^ \\/\n" +
"               \\ =  /\n" +
"          .---./`--`\\.--._\n" +
"         /     `;--'`     \\\n" +
"        ;        /`       ;\n" +
"        |       |*        |\n" +
"        /   |   |     |    \\\n" +
"        |    \\  |*    /    |\n" +
"        \\_   |\\_|____/|  __/\n" +
"          \\__//======\\\\__/\n" +
"          / //_      _\\\\ \\\n" +
"          -'  |`\"\"\"\"`|  `-");
        System.out.println("\t\t\t\t\t\t\tDINERO:"+ dinero);
        System.out.println("HOLA BUENAS, BIENVENDIO A LA TIENDA POKEMON.");
        continuar();
        System.out.println("HACE MUY POCO QUE ABRIMOS ASIQUE SOLAMENTE TENEMOS A LA VENTA POKEBALLS.");
        continuar();
        System.out.println("QUIERES COMPRAR POKEBALLS? TENEMOS UNA OFERTA DE 100 LA UNIDAD.");
        System.out.println("1. SI        2. NO");
        int opcionPokeballs = scanner.nextInt();
        if (opcionPokeballs == 1) {
            System.out.println("CUANTAS POKEBALLS QUIERES?");
            int numeroPokeballs = scanner.nextInt();
            int coste= numeroPokeballs*100;
            if (coste <= dinero) {
                setPokeballs(pokeballs+numeroPokeballs);
                setDinero(dinero-coste);
                System.out.println("GENIAL! AQUI TIENES.");
                continuar();
            }else
                System.out.println("LO SIENTO, NO TIENES SUFICIENTE DINERO, NOS VEMOS EN OTRA OCASION.");
                continuar();
        }
        System.out.println("VUELVE PRONTO!");
        continuar();
    }

    private void capturaHistoria(int opcion) throws InterruptedException {
        if (equipo.size() <= 5) {
            if (pokeballs > 0) {
                int tiempo = (int) (Math.random() * 5 + 1);  //MATH RANDOM ME RANDOMIZA UN NUMERO Y LO ASIGNA A LA VARIABLE TIEMPO PARA DEFINIR EL TIEMPO DE BUSQUEDA DE POKEMON
                for (int i = 0; i < 1; i++) {
                    caminandoHierba();   //METODO QUE ME IMPRIME POR PANTALLA LA ACCION DE CAMINAR POR LA HIERBA
                    Thread.sleep(tiempo * 500);
                    int indice = (int) (Math.random() * pokemons.size());  //MATH RANDOMD GENERA UN NUMERO ALEATORIO Y SE LO ASIGNA A INDICE
                    Pokemon pokemonEncontrado = pokemons.get(indice);  // ASIGNO A POKEMONENCONTRADO EL GETTER DE POKEMON EL NUMERO DEL INDICE
                    while (pokemonsCapturados.contains(pokemonEncontrado)) {   //BUCLE WHILE PARA COMPROBAR QUE EL PROXIMO POKEMON QUE APAREZCA NO HAYA SALIDO YA. 
                        indice = (int) (Math.random() * pokemons.size());           //SI SE REPITE EL POKEMON ENCONTRADO ME GENERA OTRO.
                        pokemonEncontrado = pokemons.get(indice);
                    }
                    pokemonsCapturados.add(pokemonEncontrado);   // ESTO ALMACENA EL POKEMON ENCONTRADO EN LA LISTA DE CAPTURADOS.
                    imprimirEspacios();
                    System.out.println("====================================================");
                    dibujoPokemon(pokemonEncontrado);  //METODO QUE MUESTRA UN DIBUJO Y UN MENSAJE DEL POKEMON ENCONTRADO.
                    panelCaptura();  //METODO QUE MUESTRA EL DIBUJO DEL PANEL DE CAPTURA
                    Scanner lectura = new Scanner(System.in);  //ESCANER QUE RECOGE LA INFORMACION SOBRE CAPTURAR O ESCAPAR
                    int opcion1 = scanner.nextInt();
                    if (opcion1 == 1) {
                        pokeballs--;
                        tiempoCaptura();
                        int intentos = 0;
                        while (intentos < 3) {
                            boolean capturaExitosa = Math.random() < 0.5;
                            if (capturaExitosa) {
                                System.out.println("\n\t ________________________________");
                                System.out.println("\t|                                |");
                                System.out.println("\t|GENIAL! EL POKEMON FUE CAPTURADO|");
                                System.out.println("\t|________________________________|");
                                tiempoEspera();
                                System.out.println(pokemonEncontrado.getNombre() + " FUE TRANSFERIDO A TU EQUIPO POKEMON.");
                                equipo.add(pokemonEncontrado);
                                tiempoEspera();      //METODOS PARA ESPERAR ANTES DE MOSTRAR EL ENTRENADOR Y DE TIEMPO A LEERLO
                                mostrarEntrenador();
                                break;
                            } else {
                                System.out.println("OH, VAYA " + pokemonEncontrado.getNombre() + " SE ESCAPO.   \n QUIERES VOLVER A INTENTARLO? \n 1.SI    2.NO");
                                int otroIntento = scanner.nextInt();
                                if (otroIntento == 1) {
                                    pokeballs--;
                                    System.out.println("INTENTOS RESTANTES: " + (1 - intentos));
                                    tiempoEspera();
                                    tiempoEspera();
                                    imprimirEspacios();
                                    intentos++;
                                } else {
                                    break;
                                }
                            }
                        }
                        if (intentos >= 3) {
                            System.out.println("EL POKEMON SE HA ESCAPADO.");
                            tiempoEspera();
                        }
                    } else if (opcion1 == 2) {
                        System.out.println("ESCAPASTE SANO Y SALVO.");
                        mostrarEntrenador();
                    } else {
                        System.out.println("OPCION INVALIDA. SALIENDO SEL COMBATE.");
                    }
                }
            } else {
                System.out.println("NO TE QUEDAN POKEBALLS.");
                continuar();
                imprimirEspaciosLargo();
            }
        } else {
            System.out.println("LO SENTIMOS SU EQUIPO ESTA COMPLETO.");
            continuar();
        }
    }
    }




