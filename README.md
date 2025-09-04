# Biblioteca

SISTEMA DE BIBLIOTECA DIGITAL - ANÁLISIS TÉCNICO


INTRODUCCIÓN:

Este sistema de biblioteca digital permite realizar operaciones básicas de gestión de libros desde una interfaz de consola. Incluye funcionalidades de agregar, eliminar, listar, buscar, prestar, devolver y clasificar libros por categoría.

El desarrollo del sistema se realizó usando Java 8+, aplicando estructuras de datos de Java Collections Framework como `ArrayList`, `LinkedList` y `HashMap`.

 ARQUITECTURA DEL SISTEMA:

- Clase `Libro`: representa un libro con atributos como título, autor, ISBN, categoría y disponibilidad.
- Clase `Biblioteca`: contiene la lógica del sistema y la gestión de estructuras de datos.
- Clase `Menu`: interfaz de texto para interactuar con el usuario.
- Clase `Main`: punto de entrada del programa.

ESTRUCTURAS DE DATOS UTILIZADAS Y JUSTIFICACIÓN:

a) `ArrayList<Libro> libros`  
   - Contiene todos los libros registrados en la biblioteca.
   - Justificación:  
     * `ArrayList` es ideal para almacenar colecciones en las que se necesita acceso rápido a los elementos por índice o recorrer secuencialmente.
     * Es más eficiente que `LinkedList` para búsquedas y operaciones de lectura.
     * La cantidad de libros no se espera que cambie drásticamente de forma constante, por lo que el costo de inserciones/eliminaciones no es crítico.

b) `LinkedList<Libro> librosPrestados`  
   - Contiene únicamente los libros prestados.
   - Justificación:
     * `LinkedList` permite eliminar elementos (libros devueltos) con menor costo si se recorren en orden.
     * Las operaciones de préstamo y devolución no requieren acceso aleatorio, sino recorridos lineales.

c) `HashMap<String, ArrayList<Libro>> categorias`  
   - Organiza los libros por género/categoría.
   - Justificación:
     * `HashMap` permite acceder rápidamente a todos los libros de una categoría específica.
     * Aprovecha la eficiencia de las claves para agrupar y acceder a listas por género.

 COMPARATIVA Y DECISIONES DE DISEÑO:

| Requisito                      | Estructura Usada | Alternativa | Razón de Elección                    |
|-------------------------------|------------------|-------------|--------------------------------------|
| Lista general de libros       | ArrayList        | LinkedList  | Mejor rendimiento en búsquedas       |
| Libros prestados              | LinkedList       | ArrayList   | Mejor en eliminación de elementos    |
| Agrupar por categorías        | HashMap          | TreeMap     | HashMap es más rápido para este caso |

FUNCIONAMIENTO DEL CÓDIGO:

- `agregarLibro`: Añade un libro a `libros` y lo asocia a su categoría en el `HashMap`.
- `buscarLibro`: Recorre `ArrayList` buscando coincidencias por título, autor o ISBN.
- `eliminarLibro`: Usa un iterador para eliminar de la lista principal y del HashMap.
- `prestarLibro`: Marca como no disponible y agrega a la `LinkedList` de prestados.
- `devolverLibro`: Recorre la lista de prestados y actualiza disponibilidad.
- `mostrarPorCategoria`: Accede a `HashMap` con clave de categoría.


