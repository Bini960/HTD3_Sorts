import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class MergeSortTest {

    /**
     * Prueba el algoritmo MergeSort con una lista que incluye números
     * repetidos y negativos para asegurar robustez.
     */
    @Test
    public void testMergeSort() {

        // Creamos la instancia del algoritmo recursivo
        IOrdenamiento merge = new MergeSort();
        
        // Datos de prueba: Incluimos negativos (-10) y duplicados (20, 20)
        // para verificar que el algoritmo es estable y maneja varios casos.
        Integer[] input = {99, -10, 50, 20, 10, 60, 20};
        
        // El resultado esperado matemáticamente ordenado
        Integer[] expected = {-10, 10, 20, 20, 50, 60, 99};


        // Ejecutamos el algoritmo. 
        // Aquí ocurren las divisiones recursivas y las mezclas.
        merge.sort(input);


        // Verificamos que el arreglo final sea idéntico al esperado.
        // Si falla, mostrará el mensaje de error especificado.
        assertArrayEquals("Fallo en Merge Sort: Los elementos no coinciden", expected, input);
    }
}