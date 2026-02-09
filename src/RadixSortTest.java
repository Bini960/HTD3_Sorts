import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

/**
 * Suite de pruebas para el algoritmo Radix Sort.
 * Verifica el ordenamiento correcto de números en diversos escenarios:
 * - Números positivos
 * - Números negativos y positivos mezclados
 * - Números con diferentes magnitudes (dígitos)
 * - Ceros
 * - Arreglos ya ordenados
 * 
 * @author Franco Paiz
 */
public class RadixSortTest {

    /**
     * Prueba con números positivos desordenados
     */
    @Test
    public void testRadixSortPositive() {
        IOrdenamiento radix = new RadixSort();
        Integer[] input = {170, 45, 75, 90, 2, 8, 70, 3};
        Integer[] expected = {2, 3, 8, 45, 70, 75, 90, 170};

        radix.sort(input);
        assertArrayEquals("Fallo Radix Sort", expected, input);
    }

    /**
     * Prueba con números negativos y positivos mezclados
     */
    @Test
    public void testRadixSortWithNegatives() {
        IOrdenamiento radix = new RadixSort();
        Integer[] input = {64, -34, 25, -12, 22, -11, 90};
        Integer[] expected = {-34, -12, -11, 22, 25, 64, 90};

        radix.sort(input);
        assertArrayEquals("Fallo con negativos", expected, input);
    }

    /**
     * Prueba con números de diferentes magnitudes (1, 2 y 3 dígitos)
     */
    @Test
    public void testRadixSortDifferentMagnitudes() {
        IOrdenamiento radix = new RadixSort();
        Integer[] input = {5, 1000, 8, 2, 999, 100, 44};
        Integer[] expected = {2, 5, 8, 44, 100, 999, 1000};

        radix.sort(input);
        assertArrayEquals("Fallo con magnitudes diferentes", expected, input);
    }

    /**
     * Prueba con ceros incluidos
     */
    @Test
    public void testRadixSortWithZeros() {
        IOrdenamiento radix = new RadixSort();
        Integer[] input = {5, -3, 0, 8, 0, -1, 2};
        Integer[] expected = {-3, -1, 0, 0, 2, 5, 8};

        radix.sort(input);
        assertArrayEquals("Fallo con ceros", expected, input);
    }

    /**
     * Prueba con arreglo ya ordenado
     */
    @Test
    public void testRadixSortAlreadySorted() {
        IOrdenamiento radix = new RadixSort();
        Integer[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        radix.sort(input);
        assertArrayEquals("Arreglo ya estaba ordenado", expected, input);
    }
}
