import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class QuickSortTest {

    /**
     * Prueba el algoritmo QuickSort.
     * Verifica que el particionamiento y los pivotes funcionen para ordenar la lista.
     */
    @Test
    public void testQuickSort() {

        // Instancia del algoritmo QuickSort
        IOrdenamiento quick = new QuickSort();
        
        // Caso de prueba: Lista inversa (De mayor a menor)
        // Este es un caso interesante porque obliga al algoritmo a hacer muchos intercambios.
        Integer[] input = {6, 5, 4, 3, 2, 1};
        
        // Resultado esperado
        Integer[] expected = {1, 2, 3, 4, 5, 6};


        // Ejecuta el sort. Internamente seleccionará pivotes (el último elemento)
        // y particionará la lista repetidamente.
        quick.sort(input);


        // Valida que la lista inversa haya sido transformada correctamente.
        assertArrayEquals("Quick Sort falló al ordenar una lista inversa", expected, input);
    }
}