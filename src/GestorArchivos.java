import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GestorArchivos {

    // Metodo para generar los numeros y guardarlos en el .txt
    // Recibe el nombre del archivo y cuantos numeros quiero generar
    public void generarArchivo(String nombreArchivo, int cantidad) {
        try {
            // Escritor para crear el archivo nuevo
            FileWriter writer = new FileWriter(nombreArchivo);
            // Random para sacar numeros al azar
            Random rand = new Random();

            // Ciclo que se repite la cantidad de veces que indique (3000)
            for (int i = 0; i < cantidad; i++) {
                // Numero aleatorio entre 0 y 9999
                int numero = rand.nextInt(10000); 
                // Se escribe en el archivo y realiza un salto de linea
                writer.write(numero + "\n");
            }
            
            // Cerrar el writer para que se guarden los datos
            writer.close();
            // Mensaje para saber que todo salio bien
            System.out.println("Archivo generado con exito: " + cantidad + " numeros.");

        } catch (IOException e) {
            // Excepcion si falla algo al escribir 
            System.out.println("Error al escribir el archivo.");
            e.printStackTrace();
        }
    }

    // Metodo para leer el txt y pasar los datos a un arreglo
    // Devuelve un arreglo de Int para poder ordenarlos despues
    public Integer[] leerArchivo(String nombreArchivo) {
        // ArrayList temporal porque no se sabe cuantos numeros vendran
        ArrayList<Integer> lista = new ArrayList<>();
        
        try {
            // Busca el archivo en la carpeta
            File archivo = new File(nombreArchivo);
            // Scanner para leer el contenido del archivo
            Scanner scanner = new Scanner(archivo);

            // Mientras sigan habiendo lineas en el archivo,sigue leyendo
            while (scanner.hasNextLine()) {
                // Lee la linea completa
                String linea = scanner.nextLine();
                try {
                    // Convierte el texto a numero entero y lo agrega a la lista
                    // trim() para quitar espacios
                    lista.add(Integer.parseInt(linea.trim()));
                } catch (NumberFormatException e) {
                    // Si la linea esta vacia se ignora
                }
            }
            // Cierra el scanner para liberar memoria
            scanner.close();
        } catch (FileNotFoundException e) {
            // Aviso si no encuentra el archivo
            System.out.println("No se encontro el archivo: " + nombreArchivo);
            e.printStackTrace();
        }

        // Paso todo de la lista dinamica a un arreglo estatico y lo devuelve
        return lista.toArray(new Integer[0]);
    }
}