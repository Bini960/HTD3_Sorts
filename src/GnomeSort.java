/**
 * Implementación del algoritmo de ordenamiento Gnome Sort.
 * Se mueve hacia atrás cuando detecta elementos desordenados,
 * similar a Insertion Sort pero más flexible en su movimiento.
 * 
 * Complejidad: O(n²) en el peor caso, O(n) en el mejor caso
 * @author Franco Paiz
 */
public class GnomeSort implements IOrdenamiento {
    // Algoritmo que se mueve hacia atrás cuando detecta elementos desordenados
    // Similar a Insertion Sort pero más flexible

    /**
     * Ordena un arreglo utilizando el algoritmo Gnome Sort.
     * @param datos arreglo de elementos Comparable a ordenar
     */
    @Override
    public void sort(Comparable[] datos) {
        int n = datos.length;
        int i = 0;

        // Recorre el arreglo, avanza si está ordenado o retrocede si no
        while (i < n) {
            if (i == 0 || datos[i].compareTo(datos[i - 1]) >= 0) {
                i++;
            } else {
                // Intercambia si está desordenado
                Comparable temp = datos[i];
                datos[i] = datos[i - 1];
                datos[i - 1] = temp;
                i--;
            }
        }
    }
}
