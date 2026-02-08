public class MergeSort implements IOrdenamiento {

    @Override
    public void sort(Comparable[] datos) {
        // Llama al metodo recursivo inicial con los limites completos
        mergeSort(datos, 0, datos.length - 1);
    }

    // Metodo recursivo que divide el arreglo en mitades
    private void mergeSort(Comparable[] datos, int izquierda, int derecha) {
        // Verifica si aun quedan elementos por dividir
        if (izquierda < derecha) {
            // Calcula el punto medio del subarreglo
            int medio = (izquierda + derecha) / 2;

            // Ordena recursivamente la primera mitad
            mergeSort(datos, izquierda, medio);
            // Ordena recursivamente la segunda mitad
            mergeSort(datos, medio + 1, derecha);

            // Mezcla las dos mitades ordenadas
            merge(datos, izquierda, medio, derecha);
        }
    }

    // Metodo auxiliar para mezclar dos subarreglos ordenados
    private void merge(Comparable[] datos, int izquierda, int medio, int derecha) {
        // Calcula el tamaño de los dos subarreglos temporales
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;

        // Crea arreglos temporales
        Comparable[] izquierdaArr = new Comparable[n1];
        Comparable[] derechaArr = new Comparable[n2];

        // Copia los datos a los arreglos temporales
        for (int i = 0; i < n1; ++i)
            izquierdaArr[i] = datos[izquierda + i];
        for (int j = 0; j < n2; ++j)
            derechaArr[j] = datos[medio + 1 + j];

        // Indices iniciales del primer y segundo subarreglo
        int i = 0, j = 0;
        // Indice inicial del subarreglo mezclado
        int k = izquierda;

        // Mezcla los arreglos temporales de nuevo en el arreglo original
        while (i < n1 && j < n2) {
            // Compara elementos y coloca el menor en el arreglo original
            if (izquierdaArr[i].compareTo(derechaArr[j]) <= 0) {
                datos[k] = izquierdaArr[i];
                i++;
            } else {
                datos[k] = derechaArr[j];
                j++;
            }
            k++;
        }

        // Copia los elementos restantes de izquierdaArr si los hay
        while (i < n1) {
            datos[k] = izquierdaArr[i];
            i++;
            k++;
        }

        // Copia los elementos restantes de derechaArr si los hay
        while (j < n2) {
            datos[k] = derechaArr[j];
            j++;
            k++;
        }
    }
}