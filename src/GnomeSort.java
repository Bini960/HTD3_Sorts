public class GnomeSort implements IOrdenamiento {
    // Algoritmo que se mueve hacia atrás cuando detecta elementos desordenados
    // Similar a Insertion Sort pero más flexible

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
