/**
 * Implementación del algoritmo Radix Sort para números enteros.
 * Ordena números basándose en sus dígitos individuales.
 * Separa negativos y positivos para tratarlos por separado.
 * 
 * Complejidad: O(nk) donde n es el número de elementos y k es el número de dígitos
 * @author Franco Paiz
 */
public class RadixSort implements IOrdenamiento {
    // Ordena por dígitos. Separa negativos y positivos para tratarlos por separado

    /**
     * Ordena un arreglo de números enteros usando Radix Sort.
     * @param datos arreglo de Comparable (números a ordenar)
     */
    @Override
    public void sort(Comparable[] datos) {
        Integer[] intDatos = new Integer[datos.length];
        for (int i = 0; i < datos.length; i++) {
            intDatos[i] = (Integer) datos[i];
        }

        // Partición: negativos a la izquierda, positivos a la derecha
        int left = 0;
        int right = intDatos.length - 1;

        while (left < right) {
            while (left < right && intDatos[left] < 0) {
                left++;
            }
            while (left < right && intDatos[right] >= 0) {
                right--;
            }
            if (left < right) {
                Integer temp = intDatos[left];
                intDatos[left] = intDatos[right];
                intDatos[right] = temp;
                left++;
                right--;
            }
        }

        radixSortNegative(intDatos, 0, left - 1);
        radixSortPositive(intDatos, left, intDatos.length - 1);

        for (int i = 0; i < datos.length; i++) {
            datos[i] = intDatos[i];
        }
    }

    private void radixSortPositive(Integer[] datos, int start, int end) {
        if (start > end) return;
        
        // Encuentra el número máximo para determinar cuántos dígitos tiene
        int max = datos[start];
        for (int i = start; i <= end; i++) {
            if (datos[i] > max) {
                max = datos[i];
            }
        }

        // Aplica counting sort para cada dígito, comenzando por el menos significativo
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortPositive(datos, start, end, exp);
        }
    }

    private void countingSortPositive(Integer[] datos, int start, int end, int exp) {
        // Ordena basándose en un dígito específico (exp)
        int n = end - start + 1;
        Integer[] output = new Integer[n];
        int[] count = new int[10];

        for (int i = start; i <= end; i++) {
            count[(datos[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = end; i >= start; i--) {
            int digit = (datos[i] / exp) % 10;
            output[count[digit] - 1] = datos[i];
            count[digit]--;
        }

        for (int i = 0; i < n; i++) {
            datos[start + i] = output[i];
        }
    }

    private void radixSortNegative(Integer[] datos, int start, int end) {
        if (start > end) return;
        
        // Encuentra el valor absoluto máximo de los negativos
        int max = Math.abs(datos[start]);
        for (int i = start; i <= end; i++) {
            if (Math.abs(datos[i]) > max) {
                max = Math.abs(datos[i]);
            }
        }

        // Aplica counting sort para cada dígito de los negativos
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortNegative(datos, start, end, exp);
        }
    }

    private void countingSortNegative(Integer[] datos, int start, int end, int exp) {
        int n = end - start + 1;
        Integer[] output = new Integer[n];
        int[] count = new int[10];

        for (int i = start; i <= end; i++) {
            count[(Math.abs(datos[i]) / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = start; i <= end; i++) {
            int digit = (Math.abs(datos[i]) / exp) % 10;
            output[n - count[digit]] = datos[i];
            count[digit]--;
        }

        for (int i = 0; i < n; i++) {
            datos[start + i] = output[i];
        }
    }
}
