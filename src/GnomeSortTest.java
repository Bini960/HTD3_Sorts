import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

/**
 * Suite de pruebas para el algoritmo Gnome Sort.
 * Verifica la correctitud del ordenamiento en diferentes casos:
 * - Arreglos desordenados básicos
 * - Números negativos y positivos
 * - Valores duplicados
 * 
 * @author Franco Paiz
 */
public class GnomeSortTest {

    /**
     * Prueba básica del algoritmo con un arreglo desordenado
     */
    @Test
    public void testGnomeSort() {
        IOrdenamiento gnome = new GnomeSort();
        Integer[] input = {64, 34, 25, 12, 22, 11, 90};
        Integer[] expected = {11, 12, 22, 25, 34, 64, 90};

        gnome.sort(input);
        assertArrayEquals("Fallo Gnome Sort", expected, input);
    }

    /**
     * Prueba con números negativos y positivos
     */
    @Test
    public void testGnomeSortWithNegatives() {
        IOrdenamiento gnome = new GnomeSort();
        Integer[] input = {5, -3, 8, -1, 0, 2, -5};
        Integer[] expected = {-5, -3, -1, 0, 2, 5, 8};

        gnome.sort(input);
        assertArrayEquals("Fallo con negativos", expected, input);
    }

    /**
     * Prueba con valores duplicados
     */
    @Test
    public void testGnomeSortWithDuplicates() {
        IOrdenamiento gnome = new GnomeSort();
        Integer[] input = {5, 2, 8, 2, 9, 1, 5, 5};
        Integer[] expected = {1, 2, 2, 5, 5, 5, 8, 9};

        gnome.sort(input);
        assertArrayEquals("Fallo con duplicados", expected, input);
    }
}
