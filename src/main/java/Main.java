import java.util.Scanner;

public class Main {

    // =============== ATRIBUTOS ===============
    private static String[][]   coleccionVinilos    = new String[3][100];
    private static int          contadorVinilos     = 0;


    // =============== MÉTODOS ===============

    // ----- Main -----
    public static void main(String[] args) {
        menu();
    }


    // ----- Agregar Vinilo -----
    public static void agregarVinilo() {
        Scanner lector = new Scanner(System.in);

        System.out.println(" ----- AGREGAR VINILO ----- ");
        System.out.print  ("    Artista        : ");
        String artista      = lector.nextLine();
        System.out.print  ("    Disco          : ");
        String disco        = lector.nextLine();
        System.out.print  ("    Lanzamiento    : ");
        int lanzamiento     = lector.nextInt();

        coleccionVinilos[0][contadorVinilos] = artista;
        coleccionVinilos[1][contadorVinilos] = disco;
        coleccionVinilos[2][contadorVinilos] = String.valueOf(lanzamiento);
        contadorVinilos = contadorVinilos + 1;
        System.out.println(" Vinilo agregado a la colección... \n");
    }



    // ----- Mostrar Colección -----
    public static void mostrarColeccion() {
        System.out.println("        ----- COLECCIÓN DE VINILOS ----- ");
        System.out.println("    Cantidad de vinilos : " + contadorVinilos());
        System.out.println("    Espacios vacíos     : " + contadorEspaciosVacios());
        System.out.println("\n");
        System.out.printf("%-20s%-20s%-20s\n", "ARTISTA", "DISCO", "LANZAMIENTO");

        for (int y = 0; y < contadorVinilos; y++) {
            for (int x = 0; x < coleccionVinilos.length; x++) {

                String elemento = coleccionVinilos[x][y];
                if (elemento != null) {
                    System.out.printf("%-20s", elemento);
                } else {
                    System.out.printf("%-20s", ""); // Espacio en blanco
                }
            }
            System.out.println();
        }
        System.out.println("\n");
    }



    // ----- Buscar Vinilo -----
    public static void buscarVinilo() {
        Scanner lector = new Scanner(System.in);

        System.out.println(" ----- BUSCAR VINILO ----- ");
        System.out.print("    Disco          : ");
        String disco = lector.nextLine();

        for (int x = 0; x < coleccionVinilos.length; x++) {
            for (int y = 0; y < coleccionVinilos[x].length; y++) {
                String vinilo = coleccionVinilos[x][y];
                if (vinilo != null && vinilo.toLowerCase().equals(disco.toLowerCase())) {
                    System.out.println( " El Vinilo \"" + disco     + "\" se encuentra en la" +
                                        "en la fila "   + y         + ".");
                    return;
                }
            }
        }

        // El vinilo no se encontró en la colección
        System.out.println(" El vinilo \"" + disco + "\" no se encuentra en la colección");
    }



    // ----- Contador Vinilos -----
    public static int contadorVinilos(){
        int contador = 0;

        for (int y = 0; y < coleccionVinilos[0].length; y++) {
            if (coleccionVinilos[0][y] != null) {
                contador++;
            }
        }
        return contador;
    }



    // ----- Contador Espacios Vacíos -----
    public static int contadorEspaciosVacios(){
        int contadorEspaciosVacios  = coleccionVinilos[0].length - contadorVinilos();
        return contadorEspaciosVacios;
    }



    // ----- MENU -----
    public static void menu(){
        Scanner lector = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("============================");
            System.out.println("|           MENÚ           |");
            System.out.println("|     COLECCIÓN VINILOS    |");
            System.out.println("|==========================|");
            System.out.println("| [1] Agregar vinilo       |");
            System.out.println("| [2] Mostrar colección    |");
            System.out.println("| [3] Buscar vinilo        |");
            System.out.println("| [4] Salir                |");
            System.out.println("============================");
            System.out.print  ("    Opción: ");
            opcion = lector.nextInt();
            System.out.println("|==========================|\n");

            switch (opcion){
                case 1 -> agregarVinilo();
                case 2 -> mostrarColeccion();
                case 3 -> buscarVinilo();
                case 4 -> {
                    System.out.println(" Hasta luego... ");
                    System.exit(0);
                }
                default -> System.out.println(" Ingrese una opción válida... ");
            }
        } while ( opcion != 4 );
    }
}
