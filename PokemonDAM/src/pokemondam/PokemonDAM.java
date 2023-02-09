//CONDICIONES DEL EJERCICIO:
/*    Iniciar juego.
           1. Seleccionar el jugador que quiere iniciar el juego.
           2. El entrenador tiene que tener un metodo e1.IniciarCaptura().
                --> Pasado un tiempo random entre 1 y 30 seg. Debe aparecer un pokemon de nuestro array de pokemons. 
                --> Muestra un mensaje de advertencia + info pokemon.
                --> 2 opciones: Capturar o Escapar.
           3.Capturar.
                --> 3 Intentos de capturar el Pokemon --> random de true - false.
                    --> True = "Enhorabuena has capturado el pokemon y lo tiene que asignar al listado de pokemon del entrenador.
                    --> False = Otro intento hasta 3 contador.
          3.3 Si hemos superado los intentos => El pokemon se ha escapado.
 */
package pokemondam;


import com.pokemondam.dominio.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/** 
                   _________ 
                  |_  | ___ \
                    | | |_/ /
      Autor:        | | ___ \
                /\__/ | |_/ /
                \____/\____/ 

 */
public class PokemonDAM {

    
                                                //CONJUNTO DE METODOS:
    
 
    //CONJUNTO DE METODOS PARA SETEAR ESTADISTICAS Y ATAQUES SEGUN NIVEL Y TIPO
    public static Pokemon crearPokemonNormalFuerte(String nombre) {
        Random random = new Random();
                    // int nivelAlto = random.nextInt(40)+60; //NIVEL ALEATORIO ENTRE 60 Y 99 INCLUYENDO AMBOS. 
            //ORDEN DE ESTADISTICAS:-----------------ATAQUE-----------------DEFENSA----------------NIVEL-------------------ESPECIAL       
        Pokemon pokemon = new Normal (nombre, random.nextInt(40) + 60, random.nextInt(40) + 60, random.nextInt(40) + 60,random.nextInt(40) + 60, 160);
        pokemon.addAtaque(new Ataques("CABEZAZO", 50));
        pokemon.addAtaque(new Ataques("GOLPE CUERPO", 60));
        pokemon.addAtaque(new Ataques("GARRA BRUTAL",70));
        pokemon.addAtaque(new Ataques("TERREMOTO", 85));
        return pokemon;
    }
    public static Pokemon crearPokemonNormalMedio(String nombre) {
        Random random = new Random();
                    // int nivelMdio = random.nextInt(30)+30; //NIVEL ALEATORIO ENTRE 30 Y 59 INCLUYENDO AMBOS.
            //ORDEN DE ESTADISTICAS:-----------------ATAQUE-----------------DEFENSA----------------NIVEL-------------------ESPECIAL       
        Pokemon pokemon = new Normal(nombre, random.nextInt(30) + 30, random.nextInt(30) + 30, random.nextInt(30) + 30,random.nextInt(30) + 30, 150);
        pokemon.addAtaque(new Ataques("ATAQUE RAPIDO",35));
        pokemon.addAtaque(new Ataques("FURIA", 40));
        pokemon.addAtaque(new Ataques("CABEZAZO", 50));
        pokemon.addAtaque(new Ataques("GARRA BRUTAL", 60));
        return pokemon;
    }
    public static Pokemon crearPokemonNormalFlojo(String nombre) {

        Random random = new Random();
                    // int nivelBajo = random.nextInt(25)+5;  //NIVEL ALEATORIO ENTRE 5 Y 29 INCLUYENDO AMBOS.
            //ORDEN DE ESTADISTICAS:-----------------ATAQUE-----------------DEFENSA----------------NIVEL-------------------ESPECIAL       
        Pokemon pokemon = new Normal(nombre, random.nextInt(30) + 30, random.nextInt(30) + 30, random.nextInt(30) + 30,random.nextInt(30) + 30, 150);
        pokemon.addAtaque(new Ataques("ARAÑAZO", 15));
        pokemon.addAtaque(new Ataques("BOFETON", 25));
        pokemon.addAtaque(new Ataques("ATAQUE RAPIDO",35));
        pokemon.addAtaque(new Ataques("FURIA", 40));
        return pokemon;
    }
    public static Pokemon crearPokemonPlantaFuerte(String nombre) {
        Random random = new Random();
                    // int nivelAlto = random.nextInt(40)+60; //NIVEL ALEATORIO ENTRE 60 Y 99 INCLUYENDO AMBOS. 
            //ORDEN DE ESTADISTICAS:-----------------ATAQUE-----------------DEFENSA----------------NIVEL-------------------ESPECIAL       
        Pokemon pokemon = new Normal(nombre, random.nextInt(40) + 60, random.nextInt(40) + 60, random.nextInt(40) + 60,random.nextInt(40) + 60, 160);
        pokemon.addAtaque(new Ataques("MEGATON",15));
        pokemon.addAtaque(new Ataques("CICLON DE HOJAS", 15));
        pokemon.addAtaque(new Ataques("HOJA AFILADA", 15));
        pokemon.addAtaque(new Ataques("RAYO SOLAR", 15));
        return pokemon;
    }
    public static Pokemon crearPokemonPlantaMedio(String nombre) {
        Random random = new Random();
                    // int nivelMdio = random.nextInt(30)+30; //NIVEL ALEATORIO ENTRE 30 Y 59 INCLUYENDO AMBOS.
            //ORDEN DE ESTADISTICAS:-----------------ATAQUE-----------------DEFENSA----------------NIVEL-------------------ESPECIAL       
        Pokemon pokemon = new Planta(nombre, random.nextInt(30) + 30, random.nextInt(30) + 30, random.nextInt(30) + 30,random.nextInt(30) + 30, 150);
        pokemon.addAtaque(new Ataques("LATIGO CEPA",15));
        pokemon.addAtaque(new Ataques("HOJA AFILADA", 15));
        pokemon.addAtaque(new Ataques("RAYO SOLAR", 15));
        pokemon.addAtaque(new Ataques("CICLON DE HOJAS", 15));
        return pokemon;
    }
    public static Pokemon crearPokemonPlantaFlojo(String nombre) {

        Random random = new Random();
                    // int nivelBajo = random.nextInt(25)+5;  //NIVEL ALEATORIO ENTRE 5 Y 29 INCLUYENDO AMBOS.
            //ORDEN DE ESTADISTICAS:-----------------ATAQUE-----------------DEFENSA----------------NIVEL-------------------ESPECIAL       
        Pokemon pokemon = new Planta(nombre, random.nextInt(25) + 5, random.nextInt(25) + 5, random.nextInt(25) + 5,random.nextInt(25) + 5, 140);
        pokemon.addAtaque(new Ataques("ABSORBER",15));
        pokemon.addAtaque(new Ataques("LATIGO CEPA", 15));
        pokemon.addAtaque(new Ataques("ARAÑAZO", 15));
        pokemon.addAtaque(new Ataques("HOJA AFILADA", 15));
        return pokemon;
    }
    public static Pokemon crearPokemonFuegoFuerte(String nombre) {
        Random random = new Random();
                    // int nivelAlto = random.nextInt(40)+60; //NIVEL ALEATORIO ENTRE 60 Y 99 INCLUYENDO AMBOS. 
            //ORDEN DE ESTADISTICAS:-----------------ATAQUE-----------------DEFENSA----------------NIVEL-------------------ESPECIAL       
        Pokemon pokemon = new Fuego (nombre, random.nextInt(40) + 60, random.nextInt(40) + 60, random.nextInt(40) + 60,random.nextInt(40) + 60, 160);
        pokemon.addAtaque(new Ataques("PIROTECNIA", 50));
        pokemon.addAtaque(new Ataques("ANILLO IGNEO",60));
        pokemon.addAtaque(new Ataques("GIROFUEGO", 70));
        pokemon.addAtaque(new Ataques("LANZALLAMAS", 85));
        return pokemon;
    }
    public static Pokemon crearPokemonFuegoMedio(String nombre) {
        Random random = new Random();
                    // int nivelMdio = random.nextInt(30)+30; //NIVEL ALEATORIO ENTRE 30 Y 59 INCLUYENDO AMBOS.
            //ORDEN DE ESTADISTICAS:-----------------ATAQUE-----------------DEFENSA----------------NIVEL-------------------ESPECIAL       
        Pokemon pokemon = new Fuego(nombre, random.nextInt(30) + 30, random.nextInt(30) + 30, random.nextInt(30) + 30,random.nextInt(30) + 30, 150);
        pokemon.addAtaque(new Ataques("RUEDA FUEGO",35));
        pokemon.addAtaque(new Ataques("COLA FUEGO", 40));
        pokemon.addAtaque(new Ataques("PIROTECNIA", 50));
        pokemon.addAtaque(new Ataques("ANILLO IGNEO", 60));
        return pokemon;
    }
    public static Pokemon crearPokemonFuegoFlojo(String nombre) {

        Random random = new Random();
                    // int nivelBajo = random.nextInt(25)+5;  //NIVEL ALEATORIO ENTRE 5 Y 29 INCLUYENDO AMBOS.
            //ORDEN DE ESTADISTICAS:-----------------ATAQUE-----------------DEFENSA----------------NIVEL-------------------ESPECIAL       
        Pokemon pokemon = new Fuego(nombre, random.nextInt(25) + 5, random.nextInt(25) + 5, random.nextInt(25) + 5,random.nextInt(25) + 5, 140);
        pokemon.addAtaque(new Ataques("ARAÑAZO", 15));
        pokemon.addAtaque(new Ataques("ASCUAS",25));
        pokemon.addAtaque(new Ataques("COLA FUEGO", 35));
        pokemon.addAtaque(new Ataques("RUEDA FUEGO", 40));
        return pokemon;
    }
    public static Pokemon crearPokemonAguaFuerte(String nombre) {
        Random random = new Random();
                    // int nivelAlto = random.nextInt(40)+60; //NIVEL ALEATORIO ENTRE 60 Y 99 INCLUYENDO AMBOS. 
            //ORDEN DE ESTADISTICAS:-----------------ATAQUE-----------------DEFENSA----------------NIVEL-------------------ESPECIAL       
        Agua pokemon = new Agua(nombre, random.nextInt(40) + 60, random.nextInt(40) + 60, random.nextInt(40) + 60,random.nextInt(40) + 60, 160);
        pokemon.addAtaque(new Ataques("RAYO BURBUJA",50));
        pokemon.addAtaque(new Ataques("CASCADA", 60));
        pokemon.addAtaque(new Ataques("SURF", 70));
        pokemon.addAtaque(new Ataques("HIDROBOMBA", 85));
        return pokemon;
    }
    public static Pokemon crearPokemonAguaMedio(String nombre) {
        Random random = new Random();
                    // int nivelMdio = random.nextInt(30)+30; //NIVEL ALEATORIO ENTRE 30 Y 59 INCLUYENDO AMBOS.
            //ORDEN DE ESTADISTICAS:-----------------ATAQUE-----------------DEFENSA----------------NIVEL-------------------ESPECIAL       
        Agua pokemon = new Agua (nombre, random.nextInt(30) + 30, random.nextInt(30) + 30, random.nextInt(30) + 30,random.nextInt(30) + 30, 150);
        pokemon.addAtaque(new Ataques("PISTOLA AGUA",35));
        pokemon.addAtaque(new Ataques("HIDROPULSO", 40));
        pokemon.addAtaque(new Ataques("RAYO BURBUJA", 50));
        pokemon.addAtaque(new Ataques("CASCADA", 60));
        return pokemon;
    }
    public static Pokemon crearPokemonAguaFlojo(String nombre) {

        Random random = new Random();
                    // int nivelBajo = random.nextInt(25)+5;  //NIVEL ALEATORIO ENTRE 5 Y 29 INCLUYENDO AMBOS.
            //ORDEN DE ESTADISTICAS:-----------------ATAQUE-----------------DEFENSA----------------NIVEL-------------------ESPECIAL       
        Agua pokemon = new Agua(nombre, random.nextInt(25) + 5, random.nextInt(25) + 5, random.nextInt(25) + 5,random.nextInt(25) + 5, 140);
        pokemon.addAtaque(new Ataques("ARAÑAZO", 15));
        pokemon.addAtaque(new Ataques("BURBUJA", 25));
        pokemon.addAtaque(new Ataques("PISTOLA AGUA",35));
        pokemon.addAtaque(new Ataques("HIDROPULSO", 40));
        return pokemon;
    }
    
    //METODO PARA CREAR POKEMONS
    public static void crearPokemons(ArrayList<Pokemon> pokemons) {
        Random random = new Random();
        pokemons.add(crearPokemonAguaMedio("SQUIRTLE"));
        pokemons.add(crearPokemonAguaFlojo("SQUIRTLE"));
        pokemons.add(crearPokemonAguaFlojo("SQUIRTLE"));
        pokemons.add(crearPokemonAguaMedio("WARTORTLE"));
        pokemons.add(crearPokemonAguaMedio("WARTORTLE"));
        pokemons.add(crearPokemonAguaFuerte("BLASTOISE"));
        pokemons.add(crearPokemonFuegoFlojo("CHARMANDER"));
        pokemons.add(crearPokemonFuegoFlojo("CHARMANDER"));
        pokemons.add(crearPokemonFuegoFlojo("CHARMANDER"));
        pokemons.add(crearPokemonFuegoMedio("CHARMELEON"));
        pokemons.add(crearPokemonFuegoMedio("CHARMELEON"));
        pokemons.add(crearPokemonFuegoFuerte("CHARIZARD"));
        pokemons.add(crearPokemonPlantaFlojo("BULBASAUR"));
        pokemons.add(crearPokemonPlantaFlojo("BULBASAUR"));
        pokemons.add(crearPokemonPlantaMedio("BULBASAUR"));
        pokemons.add(crearPokemonPlantaMedio("IVYSAUR"));
        pokemons.add(crearPokemonPlantaMedio("IVYSAUR"));
        pokemons.add(crearPokemonPlantaFuerte("VENUSAUR"));
        pokemons.add(crearPokemonPlantaFuerte("PIDGEY"));
        pokemons.add(crearPokemonNormalMedio("DITTO"));
        pokemons.add(crearPokemonNormalFuerte("DITTO"));
        pokemons.add(crearPokemonNormalFuerte("SNORLAX"));
        pokemons.add(crearPokemonNormalFuerte("SNORLAX"));
        pokemons.add(crearPokemonNormalFlojo("TAUROS"));
        pokemons.add(crearPokemonNormalMedio("TAUROS"));
        pokemons.add(crearPokemonNormalFuerte("TAUROS"));
        pokemons.add(crearPokemonNormalMedio("CHANSEY"));
        pokemons.add(crearPokemonNormalFuerte("CHANSEY"));
        pokemons.add(crearPokemonAguaFlojo("PSYDUCK"));
        pokemons.add(crearPokemonAguaFlojo("PSYDUCK"));
        pokemons.add(crearPokemonAguaFlojo("PSYDUCK"));
        pokemons.add(crearPokemonAguaMedio("GOLDUCK"));
        pokemons.add(crearPokemonAguaMedio("GOLDUCK"));
        pokemons.add(crearPokemonAguaMedio("GOLDUCK"));
        pokemons.add(crearPokemonFuegoFlojo("GROWLITHE"));
        pokemons.add(crearPokemonFuegoFlojo("GROWLITHE"));
        pokemons.add(crearPokemonFuegoMedio("GROWLITHE"));
        pokemons.add(crearPokemonFuegoMedio("ARCANINE"));
        pokemons.add(crearPokemonFuegoFuerte("ARCANINE"));
        pokemons.add(crearPokemonPlantaFlojo("BELLSPROUT"));
        pokemons.add(crearPokemonPlantaFlojo("BELLSPROUT"));
        pokemons.add(crearPokemonPlantaFlojo("BELLSPROUT"));
        pokemons.add(crearPokemonPlantaMedio("BELLSPROUT"));
        pokemons.add(crearPokemonPlantaMedio("WEEPINBELL"));
        pokemons.add(crearPokemonPlantaMedio("WEEPINBELL"));
        pokemons.add(crearPokemonPlantaFuerte("VICTREEBEL"));
        pokemons.add(crearPokemonNormalFuerte("MEWTWO"));


        }
    //METODO PARA CREAR ENTTRENADORES
        //RELLENANDO ENTRENADOR - (PUEDO AÑADIR MAS DE UN ENTRENADOR CON UN "FOR")
    public static void crearEntrenador(ArrayList<Entrenador> Entrenadores) {
        Scanner scanner = new Scanner(System.in);

        boolean repetir = true;
        for (int i = 0; i < 2; i++) {
            dibujoCrearEntrenador(); 
//            while (repetir) {
//                try {
                    System.out.println("INTRODUCE TU NOMBRE: ");
                    String nombre = scanner.nextLine();

                    System.out.println("ELIGE EL APODO DE TU PERSONAJE: ");
                    String apellidos = scanner.nextLine();
                    imprimirEspaciosLargo();
                    Entrenador entrenador = new Entrenador(nombre, apellidos);
                    Entrenadores.add(entrenador);
                    repetir = false;

//                } catch (NumberFormatException e) {
//                    System.out.println("DATOS INVALIDOS.");
//                    repetir = true;
//                }
            }
        }
    
    public static void crearEntrenador2(ArrayList<Entrenador> Entrenadores){
        Scanner scanner = new Scanner(System.in);
        dibujoCrearEntrenador();
        
       
        System.out.println("INTRODUCE TU NOMBRE: ");
        String nombre = scanner.nextLine();
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
"           |   |   APODO:                                |    |\n" +
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
        System.out.println("ELIGE EL APODO DE TU PERSONAJE: ");
        String apellidos = scanner.nextLine();
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
        Entrenador entrenador = new Entrenador(nombre, apellidos);
        Entrenadores.add(entrenador);
         
        
        
        }
        
        
    //METODO PARA ELEGIR EL ENTRENADOR QUE EMPIEZA A JUGAR.
    public static  Entrenador elegirEntrenador(ArrayList<Entrenador> Entrenadores){
            Scanner scanner = new Scanner(System.in);
            System.out.println("INGRESE EL ENTRENADOR QUE DESEA PARTICIPAR:\n0: ENTRENADOR 1\n1: ENTRENADOR 2");
            int indice = Integer.parseInt(scanner.nextLine());
            imprimirEspacios();
            Entrenador entrenadorElegido = Entrenadores.get(indice);
            System.out.println(entrenadorElegido);
            tiempoEspera();
            return entrenadorElegido;          
        }   
    public static  Entrenador elegirEntrenadorHistoria(ArrayList<Entrenador> Entrenadores){
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("INGRESE EL ENTRENADOR QUE DESEA PARTICIPAR:\n0: ENTRENADOR 1\n1: ENTRENADOR 2");
            int indice = 0;
            
            Entrenador entrenadorElegido = Entrenadores.get(indice);
            System.out.println("TU AVENTURA POKEMON ESTA A PUNTO DE COMENZAR...\n\t\tBUENA SUERTTE.");
            System.out.println(entrenadorElegido);
            System.out.println("ESTOS SON TUS DATOS DE ENTRENADOR: ");
            tiempoEsperaLargo();
            return entrenadorElegido;          
        }   
    //METODO PARA MOSTRAR LA PRESENTACION DEL JUEGO
    private static void presentacionPokemon() {
        
     System.out.println("=====================================================================================");                                           
     System.out.println("|                                         ___                                       |");
     System.out.println("|           _.----.        ____         ,'  _\\   ___    ___     ____    _           |");
     System.out.println("|        ,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  | \\          |");
     System.out.println("|        \\     __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |         |");
     System.out.println("|         \\    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |         |");
     System.out.println("|          \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |         |");
     System.out.println("|           \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |         |");
     System.out.println("|            \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |         |");
     System.out.println("|             \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |         |");
     System.out.println("|              \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |         |");
     System.out.println("|               \\_.-'       |__|    `-._ |              '-.|     '-.| |___|         |");
     System.out.println("|                                                      ___                          |");
     System.out.println("|                                                     /   \\__ _ _ __ ___            |");
     System.out.println("|                                                    / /\\ / _` | '_ ` _ \\           |");
     System.out.println("|                                                   / /_// (_| | | | | | |          |");
     System.out.println("|                                                  /___,' \\__,_|_| |_| |_|          |");
     System.out.println("|                                                                                   |");
     System.out.println("=====================================================================================");  
     tiempoEspera();
     
     System.out.println("\n\t \t\tBIENVENIDO A TU AVENTURA POKEMON.");
     System.out.println("");
     
     tiempoEspera();
     tiempoEspera();
    }
    //TIEMPO DE ESPERA CORTO 0.3 SEGUNDOS
    public static void tiempoEsperaCorto() {
    int tiempo = 1;
    try {
        Thread.sleep(tiempo*200);
    } catch (InterruptedException ex) {
        Logger.getLogger(PokemonDAM.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    //TIEMPO DE ESPERA NORMAL 1 SEGUNDO.
    public static void tiempoEspera() {
    int tiempo = 1;
    try {
        Thread.sleep(tiempo*1000);
    } catch (InterruptedException ex) {
        Logger.getLogger(PokemonDAM.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    //TIEMPO DE ESPERA LARGO 3 SEGUNDOS.
    public static void tiempoEsperaLargo() {
    int tiempo = 3;
    try {
        Thread.sleep(tiempo*1000);
    } catch (InterruptedException ex) {
        Logger.getLogger(PokemonDAM.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    //METODO QUE IMPRIME 15 ESPACIOS. 
    public static void imprimirEspacios() {
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }
    }
    public static void imprimirEspaciosLargo() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }
    //METODO PARA EL MODO COMBATE
    private static void iniciarCombate(ArrayList<Pokemon> pokemons) {
        imprimirEspacios();
        imprimirEspacios();
        Entrenador ash= new Entrenador(); 
        Entrenador gary= new Entrenador(); 
        
        int turnos = 15; 
        int vida_restante = 0; 
        int pokemons_debilitados_ash = 0;
        int pokemons_debilitados_gary = 0;
        
        ArrayList<Pokemon> listaCombateash = new ArrayList<>();
        ArrayList<Pokemon> listaCombategary = new ArrayList<>();
        
        //RELLENO DE POKEMONS RANDOM  A ASH
        for (int i = 0; i < 4; i++) {
            int numeroRandom = new Random().nextInt(pokemons.size());
            listaCombateash.add(pokemons.get(numeroRandom));
            pokemons.remove(numeroRandom);
        }
            ash.setpokemons(listaCombateash);
        
            
        //RELLENO DE POKEMONS RANDOM A GARY
        for (int i = 0; i < 4; i++) {
            int numeroRandom = new Random().nextInt(pokemons.size());
            listaCombategary.add(pokemons.get(numeroRandom));
            pokemons.remove(numeroRandom);
        }
            gary.setpokemons(listaCombategary);
            
            
            System.out.println(listaCombateash.get(0).getListaAtaques());
            System.out.println(listaCombateash.get(0).getListaAtaques());
            
            //AQUI SE COMBATE  
            for (int i = 0; i < turnos; i++) { 
            System.out.println("\n\nTURNO " + (i + 1) + "\n.");
            Scanner scanner = new Scanner(System.in);
            System.out.println("TURNO ENTRENADOR 1");
            System.out.println("POKEMON EN BATALLA: " + listaCombateash.get(0).getNombre());
            System.out.println("PUNTOS DE VIDA: " + listaCombateash.get(0).getVida());
            System.out.println("PUNTOS DE ATAQUE: " + listaCombateash.get(0).getPuntosAtaque());
            System.out.println("1. ATACAR ");
            System.out.println("2. CAMBIAR DE POKEMON ");
            int accionAsh = scanner.nextInt();
            
            if (accionAsh == 1) {
                int randomNumber = (int)(Math.random() * 100 + 1);
                if (randomNumber <= 85) {
                    System.out.println(listaCombateash.get(0).getNombre() + " ATACO\n\n");
                    vida_restante = listaCombategary.get(0).getVida();
                    listaCombategary.get(0).setVida(vida_restante - listaCombateash.get(0).getPuntosAtaque());
                    System.out.println("VIDA DE " + listaCombategary.get(0).getNombre() + "=" + listaCombategary.get(0).getVida()+"\n\n");
                }else{
                    System.out.println("EL ATAQUE DE " + listaCombateash.get(0).getNombre() + " FALLO\n\n");
                }
                
            }else if (accionAsh == 2) {
                if (listaCombateash.size()>1) {
                    
                    cambiarPokemon(listaCombateash);
                    System.out.println("CAMBIASTE DE POKEMON ");
                    
                }else{
                    System.out.println("NO TE QUEDAN MAS POKEMONS.");
                }
                }
            if (listaCombategary.get(0).getVida() <= 0) {
                
                pokemons_debilitados_gary++;
                System.out.println(listaCombategary.get(0).getNombre() + " HA SIDO DEBILITADO");
                listaCombategary.remove(0);
                

                if (listaCombategary.size() == 0) {
                    System.out.println("A GARY NO LE QUEDAN MAS POKEMONS...");
                    break;
                }
            }      
            //=====================================================
            System.out.println("TURNO GARY");
            System.out.println("POKEMON EN BATALLA: " + listaCombategary.get(0).getNombre());
            System.out.println("PUNTOS DE VIDA: " + listaCombategary.get(0).getVida());
            System.out.println("PUNTOS DE ATAQUE: " + listaCombategary.get(0).getPuntosAtaque());
            System.out.println("1. ATACAR");
            System.out.println("2. CAMBIAR DE POKEMON");
            int accionGary = scanner.nextInt();
            
            if (accionGary == 1) {
            System.out.println(listaCombategary.get(0).getNombre() + (" ATACO \n\n\n"));
            vida_restante = listaCombateash.get(0).getVida();
            listaCombateash.get(0).setVida(vida_restante - listaCombategary.get(0).getPuntosAtaque());
            System.out.println("VIDA DE " + listaCombateash.get(0).getNombre() + "=" + listaCombateash.get(0).getVida());
            } 
            else if (accionGary == 2) {
            cambiarPokemon(listaCombategary);
            System.out.println("CAMBIASTE DE POKEMON ");
            }
            
        if (listaCombateash.get(0).getVida() <= 0) {
            pokemons_debilitados_ash++;
            System.out.println(listaCombateash.get(0).getNombre() + " HA SIDO DEBILITADO\n\n");
            listaCombateash.remove(0);
            
            if (listaCombateash.size() == 0) {
                System.out.println("ENTRENADOR 1 HA PERDIDO TODOS SUS POKEMONS");
                break;
            }
        }
    }

        if (pokemons_debilitados_ash > pokemons_debilitados_gary) {
            System.out.println("GARY HA GANADO EL COMBATE");
        } else if (pokemons_debilitados_ash < pokemons_debilitados_gary) {
            System.out.println("ASH HA GANADO EL COMBATE");
        } else {
                System.out.println("NO QUEDAN MAS TURNOS. EL COMBATE TERMINA EMPATE. ");
        }
        
}
    //METODO PARA CAMBIAR DE POKEMON
    private static void cambiarPokemon(ArrayList<Pokemon> listaCombateGeneral) {
    System.out.println("ESCOGE UN POKEMON PARA COMBATIR:");
    for (int i = 0; i < listaCombateGeneral.size(); i++) {
        System.out.println(i + 1 + ". " + listaCombateGeneral.get(i).getNombre());
    }
    Scanner scanner = new Scanner(System.in);
    int opcionElegida = Integer.parseInt(scanner.nextLine());
    Pokemon temporal = listaCombateGeneral.get(opcionElegida - 1);
    
    for (int i = opcionElegida - 1; i > 0; i--) {
        listaCombateGeneral.set(i, listaCombateGeneral.get(i - 1));
    }
    listaCombateGeneral.set(0, temporal);
}
    
    
    
    public static void main(String[] args) throws InterruptedException {
    // LISTAS
    ArrayList<Pokemon> Pokemons = new ArrayList<>();
    ArrayList<Entrenador> Entrenadores = new ArrayList<>();
    
    // METODO PARA INSANTACIAR LOS OBJETOS DE POKEMONS
    crearPokemons(Pokemons);

    //METODO QUE LLAMA AL LOGO DE POKEMON
    presentacionPokemon();
        
    //METODO QUE LLAMA AL MENU PRINCIPAL: 
    menuPrincipal1(Pokemons, Entrenadores);


    }


    public static void menuPrincipal1(ArrayList<Pokemon> Pokemons, ArrayList<Entrenador> Entrenadores) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("                          ELIGE UNA OPCION DE JUEGO:\n");
        System.out.println("1.                              COMBATE RAPIDO");
        System.out.println("2.                               MODO CAPTURA");
        System.out.println("3.                                 HISTORIA");
        System.out.println("0.                                  SALIR");
        int opcion = scanner.nextInt();

        switch (opcion) {

            case 1:
                //MODO DE JUEGO COMBATE
                iniciarCombate(Pokemons);
                break;

            case 2:
                JFrame frame = new JFrame();
                ImageIcon icon = new ImageIcon("C:\\Users\\PC\\Desktop\\DAM\\Programacion\\Practicas\\Java\\PokemonDAM\\Imagenes\\s.jpg");
                JLabel label = new JLabel(icon);
                frame.add(label);
                frame.pack();
                frame.setVisible(true);
                frame.setAlwaysOnTop(true);
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    public void run() {
                        frame.setVisible(false);
                    }
                }, 5000); // 5000  = 5 SEGUNDOS
                
                //METODO PARA CREAR ENTRENADORES.
                crearEntrenador(Entrenadores);
                //METODO QUE DA LA OPCION DE ELEGIR UN ENTRENADOR ENTRE LA LISTA DE ENTRENADORES.
                Entrenador entrenadorElegidoCaptura = elegirEntrenador(Entrenadores);
                entrenadorElegidoCaptura.listapokemons(Pokemons);
                entrenadorElegidoCaptura.iniciarCaptura(Pokemons);
                break;
            case 3:
                JFrame frame1 = new JFrame();
                ImageIcon icon1 = new ImageIcon("C:\\Users\\PC\\Desktop\\DAM\\Programacion\\Practicas\\Java\\PokemonDAM\\Imagenes\\s.jpg");
                JLabel label1 = new JLabel(icon1);
                frame1.add(label1);
                frame1.pack();
                frame1.setVisible(true);
                frame1.setAlwaysOnTop(true);
                Timer timer1 = new Timer();
                timer1.schedule(new TimerTask() {
                    public void run() {
                        frame1.setVisible(false);
                    }
                }, 5000); // 5000  = 5 SEGUNDOS
                dibujoCrearEntrenador(); 
                crearEntrenador2(Entrenadores); //METODO PARA CREAR ENTRENADORES.
                //METODO QUE DA LA OPCION DE ELEGIR UN ENTRENADOR ENTRE LA LISTA DE ENTRENADORES.
                Entrenador entrenadorElegidoHistoria = elegirEntrenadorHistoria(Entrenadores);
                entrenadorElegidoHistoria.listapokemons(Pokemons);
                entrenadorElegidoHistoria.modoHistoria(Pokemons);
                break;

            case 0:
                System.out.println("GRACIAS POR JUGAR, HASTA LA PROXIMA =)");
                return;
            default:
                System.out.println("OPCION INVALIDA. GAME OVER");
                break;
        }
    }

    private static void dibujoCrearEntrenador() {
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
"           |   |   NOMBRE:                               |    |\n" +
"           |   |                                         |    |\n" +
"           |   |   APODO:                                |    |\n" +
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
    }
}
    
    
    
