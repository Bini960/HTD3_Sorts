import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicializa el gestor de archivos para crear y leer datos
        GestorArchivos gestor = new GestorArchivos();
        String nombreArchivo = "numeros.txt";
        
        // Define las cantidades de datos a probar
        int[] cantidades = {10, 100, 500, 750, 1000, 1250, 1500, 1750, 2000, 2250, 2500, 2750, 3000};
        
        // Lista polimórfica de algoritmos a evaluar
        IOrdenamiento[] algoritmos = {
            new InsertionSort(),
            //new MergeSort(),
            //new QuickSort(),
            //new GnomeSort(),  
            //new RadixSort()   
        };
        
        // Nombres correspondientes para la impresión de resultados
        String[] nombres = {
            "InsertionSort", 
            //"MergeSort", 
            //"QuickSort",
            //"GnomeSort", 
            //"RadixSort"
        };

        // Imprime el encabezado de la tabla para facilitar la copia a Excel
        System.out.println("Algoritmo\tCantidad\tTiempo(ms)\tTipoDatos");

        // Itera sobre cada algoritmo disponible
        for (int i = 0; i < algoritmos.length; i++) {
            
            // Ciclo secundario: Itera sobre cada cantidad de datos (10, 100... 3000)
            for (int n : cantidades) {

                // DATOS DESORDENADOS 
                
                // Genera un archivo nuevo con 'n' números aleatorios
                gestor.generarArchivo(nombreArchivo, n);
                // Lee los datos del archivo a memoria
                Integer[] datos = gestor.leerArchivo(nombreArchivo);
                
                // Toma el tiempo inicial en nanosegundos (alta precisión)
                long inicio = System.nanoTime();
                
                // Ejecuta el ordenamiento
                algoritmos[i].sort(datos);
                
                // Toma el tiempo final
                long fin = System.nanoTime();
                
                // Calcula la duración y convierte a milisegundos con decimales
                double tiempo = (fin - inicio) / 1_000_000.0;
                
                // Imprime el resultado formateado
                System.out.println(nombres[i] + "\t" + n + "\t" + String.format("%.4f", tiempo).replace(',', '.') + "\tDesordenado");


                // DATOS ORDENADOS 
                
                // Reutiliza el arreglo 'datos' que ya fue ordenado en el paso anterior
                
                inicio = System.nanoTime();
                algoritmos[i].sort(datos); // Ordena sobre lo ya ordenado
                fin = System.nanoTime();
                
                tiempo = (fin - inicio) / 1_000_000.0;
                System.out.println(nombres[i] + "\t" + n + "\t" + String.format("%.4f", tiempo).replace(',', '.') + "\tOrdenado");
            }
        }

        // PAUSA PARA PROFILING (VISUALVM / TASK MANAGER)
        
        System.out.println("  PROCESO TERMINADO - ESPERANDO USUARIO");
        System.out.println("  Realice la captura de pantalla de memoria/CPU ahora.");
        System.out.println("  Presione ENTER para finalizar el programa.");

        // Inicializa el scanner para capturar la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        // Detiene el flujo de ejecución hasta recibir un salto de línea (Enter)
        scanner.nextLine();
        // Cierra el scanner para liberar recursos del sistema
        scanner.close();
    }
}