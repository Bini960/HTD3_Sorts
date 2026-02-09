import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class InsertionSortTest {


//Prueba el escenario base con una lista de números desordenados.
//Verifica que el algoritmo pueda ordenar correctamente de menor a mayor.

    @Test
    public void testInsertionSort() {

        // Instancia la implementación específica del algoritmo que vamos a probar
        IOrdenamiento insertion = new InsertionSort();
        
        // Define un conjunto de datos de entrada desordenado (Caso de prueba)
        Integer[] input = {34, 12, 5, 2, 78, 1};
        
        // Define el resultado exacto que esperamos obtener si el código funciona bien
        Integer[] expected = {1, 2, 5, 12, 34, 78};

        // Llama al método sort() para procesar los datos 'input'
        // Nota: Como el ordenamiento es "in-place", modifica el arreglo 'input' directamente
        insertion.sort(input);

        // Compara el contenido del arreglo procesado (input) contra el esperado (expected).
        // Si hay alguna diferencia en orden o valor, el test fallará automáticamente.
        assertArrayEquals("El arreglo no se ordenó correctamente con Insertion Sort", expected, input);
    }
}