public class InsertionSort implements IOrdenamiento {

    @Override
    public void sort(Comparable[] datos) {
        int n = datos.length;
        
        // Recorre el arreglo desde el segundo elemento hasta el final
        for (int i = 1; i < n; ++i) {
            // Guarda el elemento actual que se va a insertar
            Comparable key = datos[i];
            int j = i - 1;

            // Mueve los elementos del segmento ordenado que son mayores que la llave
            // hacia una posicion adelante de su posicion actual
            while (j >= 0 && datos[j].compareTo(key) > 0) {
                datos[j + 1] = datos[j];
                j = j - 1;
            }
            // Inserta la llave en su posicion correcta
            datos[j + 1] = key;
        }
    }
}