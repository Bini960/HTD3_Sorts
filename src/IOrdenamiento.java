//Interfaz que define el comportamiento de cualquier algoritmo de ordenamiento.

public interface IOrdenamiento {
    
    // Ordena un arreglo de elementos que implementan Comparable
    // Recibe el arreglo de datos a ordenar
    void sort(Comparable[] datos);
}