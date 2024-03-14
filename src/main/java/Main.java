import java.util.Scanner;

public class Main {

    // ===== ATRIBUTOS =====
    private static String[][] coleccionVinilos = new String[3][100];
    private static int contadorVinilos = 0;

    // ===== MÉTODOS =====
    // ----- AGREGAR VINILO -----
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
        System.out.println(" Vinilo agregado a la colección... ");
    }


    // ----- MOSTRAR COLECCIÓN -----
    public static void mostrarColeccion(){
        System.out.println(" ----- COLECCIÓN DE VINILOS ----- ");
        System.out.printf("%-20s %-20s %-20s%n", "Artista", "Disco", "Lanzamiento");

        for (int y = 0; y < coleccionVinilos[0].length; y++) {
            for (int x = 0; x < coleccionVinilos.length; x++) {
                System.out.printf("%-20s ", coleccionVinilos[x][y]);
            }
            System.out.println();
        }
    }


    // ----- BUSCAR VINILO -----
    public static void buscarVinilo(){
        Scanner lector = new Scanner(System.in);

        System.out.println(" ----- BUSCAR VINILO ----- ");
        System.out.print  ("    Disco          : ");
        String disco = lector.nextLine();

        for (int x = 0; x < coleccionVinilos.length ; x++) {
            for (int y = 0; y < coleccionVinilos[x].length ; y++) {
                if(coleccionVinilos[x][y].toLowerCase() == disco.toLowerCase()){
                    int columna = x;
                    int fila    = y;
                    System.out.println(" Vinilo " + disco + " en la columna " + x + " fila " + y );
                } else {
                    System.out.println(" El vinilo" + disco +  " no se encuentra en la colección");
                }
            }
        }
    }


    // ----- CONTADOR VINILOS -----
    public static int contadorVinilos(){
        Scanner lector  = new Scanner(System.in);
        int contador    = 0;

        for (int x = 0; x < coleccionVinilos.length ; x++) {
            for (int y = 0; y < coleccionVinilos[x].length ; y++) {
                while (lector.hasNextLine()){
                    contador = contador + 1;
                }
            }
        }
        return contador;
    }

    // ----- CONTADOR ESPACIOS VACÍOS -----
    public static int contadorEspaciosVacios(){
        int contador = contadorVinilos();
        int contadorEspaciosVacios = 100 - contador;

        return contadorEspaciosVacios;
    }


    // ----- MENU -----
    public static void menu(){
        Scanner lector = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("==========================");
            System.out.println("           MENÚ           ");
            System.out.println("     COLECCIÓN VINILOS    ");
            System.out.println("==========================");
            System.out.println(" [1] Agregar vinilo       ");
            System.out.println(" [2] Mostrar colección    ");
            System.out.println(" [3] Buscar vinilo        ");
            System.out.println(" [4] Salir                ");
            System.out.println("==========================");
            System.out.print  ("    Opción: ");
            opcion = lector.nextInt();
            System.out.println("==========================");

            switch (opcion){
                case 1:
                    agregarVinilo();
                    break;
                case 2:
                    mostrarColeccion();
                    break;
                case 3:
                    buscarVinilo();
                    break;
                case 4:
                    System.out.println(" Hasta luego... ");
                    System.exit(0);
                    break;
                default:
                    System.out.println(" Ingrese una opción válida... ");
            }
        } while ( opcion != 4 );
    }
}
