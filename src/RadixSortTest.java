import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class RadixSortTest {

    @Test
    public void testRadixSortPositive() {
        IOrdenamiento radix = new RadixSort();
        Integer[] input = {170, 45, 75, 90, 2, 8, 70, 3};
        Integer[] expected = {2, 3, 8, 45, 70, 75, 90, 170};

        radix.sort(input);
        assertArrayEquals("Fallo Radix Sort", expected, input);
    }

    @Test
    public void testRadixSortWithNegatives() {
        IOrdenamiento radix = new RadixSort();
        Integer[] input = {64, -34, 25, -12, 22, -11, 90};
        Integer[] expected = {-34, -12, -11, 22, 25, 64, 90};

        radix.sort(input);
        assertArrayEquals("Fallo con negativos", expected, input);
    }

    @Test
    public void testRadixSortDifferentMagnitudes() {
        IOrdenamiento radix = new RadixSort();
        Integer[] input = {5, 1000, 8, 2, 999, 100, 44};
        Integer[] expected = {2, 5, 8, 44, 100, 999, 1000};

        radix.sort(input);
        assertArrayEquals("Fallo con magnitudes diferentes", expected, input);
    }

    @Test
    public void testRadixSortWithZeros() {
        IOrdenamiento radix = new RadixSort();
        Integer[] input = {5, -3, 0, 8, 0, -1, 2};
        Integer[] expected = {-3, -1, 0, 0, 2, 5, 8};

        radix.sort(input);
        assertArrayEquals("Fallo con ceros", expected, input);
    }

    @Test
    public void testRadixSortAlreadySorted() {
        IOrdenamiento radix = new RadixSort();
        Integer[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        radix.sort(input);
        assertArrayEquals("Arreglo ya estaba ordenado", expected, input);
    }
}
