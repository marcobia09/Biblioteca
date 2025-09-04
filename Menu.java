import java.util.Scanner;

public class Menu {
    private Biblioteca biblioteca = new Biblioteca();
    private Scanner sc = new Scanner(System.in);

    public void iniciar() {
        int opcion;
        do {
            System.out.println("\nSISTEMA DE BIBLIOTECA DIGITAL");
            System.out.println("1. Agregar libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Buscar libro");
            System.out.println("4. Eliminar libro");
            System.out.println("5. Mostrar por categoría");
            System.out.println("6. Prestar libro");
            System.out.println("7. Devolver libro");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> agregarLibro();
                case 2 -> biblioteca.listarLibros();
                case 3 -> buscarLibro();
                case 4 -> eliminarLibro();
                case 5 -> mostrarPorCategoria();
                case 6 -> prestarLibro();
                case 7 -> devolverLibro();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void agregarLibro() {
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("Categoría: ");
        String categoria = sc.nextLine();

        biblioteca.agregarLibro(new Libro(titulo, autor, isbn, categoria));
    }

    private void buscarLibro() {
        System.out.println("Buscar por: 1. Título  2. Autor  3. ISBN");
        int opcion = Integer.parseInt(sc.nextLine());
        System.out.print("Ingrese el valor de búsqueda: ");
        String valor = sc.nextLine();
        switch (opcion) {
            case 1 -> biblioteca.buscarLibro("titulo", valor);
            case 2 -> biblioteca.buscarLibro("autor", valor);
            case 3 -> biblioteca.buscarLibro("isbn", valor);
            default -> System.out.println("Opción inválida.");
        }
    }

    private void eliminarLibro() {
        System.out.print("ISBN del libro a eliminar: ");
        biblioteca.eliminarLibro(sc.nextLine());
    }

    private void mostrarPorCategoria() {
        System.out.println("Categorías disponibles: " + biblioteca.obtenerCategorias());
        System.out.print("Ingrese la categoría: ");
        biblioteca.mostrarPorCategoria(sc.nextLine());
    }

    private void prestarLibro() {
        System.out.print("ISBN del libro a prestar: ");
        biblioteca.prestarLibro(sc.nextLine());
    }

    private void devolverLibro() {
        System.out.print("ISBN del libro a devolver: ");
        biblioteca.devolverLibro(sc.nextLine());
    }
}
