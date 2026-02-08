public class QuickSort implements IOrdenamiento {

    @Override
    public void sort(Comparable[] datos) {
        // Inicia el proceso recursivo con todo el arreglo
        quickSort(datos, 0, datos.length - 1);
    }

    // Metodo recursivo principal del QuickSort
    private void quickSort(Comparable[] datos, int bajo, int alto) {
        // Verifica si los indices son validos para continuar
        if (bajo < alto) {
            // Obtiene el indice de particion (donde queda el pivote)
            int pi = partition(datos, bajo, alto);

            // Ordena recursivamente los elementos antes de la particion
            quickSort(datos, bajo, pi - 1);
            // Ordena recursivamente los elementos despues de la particion
            quickSort(datos, pi + 1, alto);
        }
    }

    // Metodo que toma el ultimo elemento como pivote y lo coloca en su posicion correcta
    private int partition(Comparable[] datos, int bajo, int alto) {
        // Elige el ultimo elemento como pivote
        Comparable pivote = datos[alto];
        // Indice del elemento mas pequeño
        int i = (bajo - 1); 

        // Recorre los elementos del subarreglo
        for (int j = bajo; j < alto; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (datos[j].compareTo(pivote) <= 0) {
                i++;

                // Intercambia datos[i] y datos[j]
                Comparable temp = datos[i];
                datos[i] = datos[j];
                datos[j] = temp;
            }
        }

        // Intercambia el pivote con el elemento en la posicion i+1
        Comparable temp = datos[i + 1];
        datos[i + 1] = datos[alto];
        datos[alto] = temp;

        // Retorna la posicion final del pivote
        return i + 1;
    }
}