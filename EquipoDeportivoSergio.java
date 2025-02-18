package Equipo;

import java.util.Scanner;

/**
 * Representa un equipo deportivo con jugadores y minutos jugados.
 * Permite añadir jugadores y mostrar la información del equipo.
 *
 * @author Sergio Martínez
 * @version 1.0
 * @since 2025
 */
public class EquipoDeportivoSergio {
    static final int MAXIMO_JUGADORES = 6;
    static final int MINUTOS_JUGABLES = 120;

    private String nombre;
    private final int cantidadJugadores;
    private String[] jugadores;
    private int[] minutosPorJugador;

    /**
     * Constructor de la clase EquipoDeportivoSergio.
     *
     * @param nombre Nombre del equipo.
     * @param cantidadJugadores Número de jugadores en el equipo.
     * @param teclado Scanner para entrada de datos.
     */
    public EquipoDeportivoSergio(String nombre, int cantidadJugadores, Scanner teclado) {
        this.nombre = nombre;

        if (cantidadJugadores <= MAXIMO_JUGADORES && cantidadJugadores >= 1) {
            this.cantidadJugadores = cantidadJugadores;
        } else {
            System.out.println("ERROR: NÚMERO DE JUGADORES INVÁLIDO");
            System.out.println("Escriba un valor válido (1-" + MAXIMO_JUGADORES + "):");
            cantidadJugadores = teclado.nextInt();
            while (cantidadJugadores < 1 || cantidadJugadores > MAXIMO_JUGADORES) {
                System.out.println("Número inválido. Intente de nuevo:");
                cantidadJugadores = teclado.nextInt();
            }
            this.cantidadJugadores = cantidadJugadores;
        }
        this.jugadores = new String[cantidadJugadores];
        this.minutosPorJugador = new int[cantidadJugadores];
    }

    /**
     * Añade un jugador al equipo si hay espacio disponible.
     *
     * @param jugador Nombre del jugador.
     * @param minJugados Minutos jugados por el jugador.
     */
    public void anyadirJugador(String jugador, int minJugados) {
        if (minJugados > MINUTOS_JUGABLES || minJugados < 0) {
            System.out.println("Error: Minutos incorrectos, jugador no añadido.");
            return;
        }
        for (int pos = 0; pos < cantidadJugadores; pos++) {
            if (jugadores[pos] == null) {
                jugadores[pos] = jugador;
                minutosPorJugador[pos] = minJugados;
                System.out.println("Jugador " + jugador + " añadido correctamente.");
                return;
            }
        }
        System.out.println("Error: Lista llena, no se puede añadir más jugadores.");
    }

    /**
     * Muestra los datos del equipo.
     */
    public void mostrarDatosEquipo() {
        System.out.println("**** " + nombre + " ****");
        System.out.println("Total jugadores: " + cantidadJugadores);
        for (int i = 0; i < cantidadJugadores; i++) {
            if (jugadores[i] != null) {
                System.out.println("[" + jugadores[i] + ", " + minutosPorJugador[i] + " minutos]");
            }
        }
    }

    // Getters y Setters
    public void setJugadores(String[] jugadores) { this.jugadores = jugadores; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setMinutosPorJugador(int[] minutosPorJugador) { this.minutosPorJugador = minutosPorJugador; }
    public String[] getJugadores() { return jugadores; }
    public String getNombre() { return nombre; }
    public int[] getMinutosPorJugador() { return minutosPorJugador; }
}
