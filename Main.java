package Equipo;

import java.util.Scanner;

/**
 * Clase principal que gestiona la creación de equipos deportivos y permite al usuario buscar información sobre ellos.
 *
 * @author Sergio Martínez
 * @version 1.0
 * @since 2025
 */
public class Main {
    /**
     * Método principal que ejecuta el programa.
     *
     * @param args Argumentos de línea de comandos (no utilizados en este programa).
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Creación de equipos
        EquipoDeportivoSergio RMCF = new EquipoDeportivoSergio("REAL MADRID CLUB DE FUTBOL", 6, teclado);
        RMCF.anyadirJugador("Vinícius Jr.", 85);
        RMCF.anyadirJugador("Jude Bellingham", 90);
        RMCF.anyadirJugador("Rodrygo", 78);
        RMCF.anyadirJugador("Luka Modrić", 65);
        RMCF.anyadirJugador("Toni Kroos", 70);
        RMCF.anyadirJugador("Antonio Rüdiger", 88);

        EquipoDeportivoSergio FCB = new EquipoDeportivoSergio("FUTBOL CLUB BARCELONA", 5, teclado);
        FCB.anyadirJugador("Robert Lewandowski", 90);
        FCB.anyadirJugador("Pedri", 85);
        FCB.anyadirJugador("Gavi", 75);
        FCB.anyadirJugador("Frenkie de Jong", 80);
        FCB.anyadirJugador("Ronald Araújo", 90);

        // Almacenar los equipos en un array
        EquipoDeportivoSergio[] equiposcreados = {RMCF, FCB};

        System.out.println("**EQUIPOS CREADOS**");
        String siglas = "";
        while (!siglas.equals("Salir")) {
            System.out.println("¿Qué equipo quieres buscar? Introduce las siglas (RMCF, FCB) o 'Salir' para terminar:");
            siglas = teclado.nextLine();

            switch (siglas) {
                case "RMCF":
                    RMCF.mostrarDatosEquipo();
                    break;
                case "FCB":
                    FCB.mostrarDatosEquipo();
                    break;
                case "Salir":
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Las siglas indicadas no han sido encontradas en el sistema");
                    break;
            }
        }
    }
}

