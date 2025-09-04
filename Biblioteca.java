import java.util.*;

public class Biblioteca {
    private ArrayList<Libro> libros = new ArrayList<>();
    private LinkedList<Libro> librosPrestados = new LinkedList<>();
    private HashMap<String, ArrayList<Libro>> categorias = new HashMap<>();

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        categorias.computeIfAbsent(libro.getCategoria(), k -> new ArrayList<>()).add(libro);
        System.out.println("Libro agregado con éxito.");
    }

    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }
        for (Libro l : libros) {
            System.out.println(l);
        }
    }

    public void buscarLibro(String criterio, String valor) {
        boolean encontrado = false;
        for (Libro l : libros) {
            if ((criterio.equals("titulo") && l.getTitulo().equalsIgnoreCase(valor)) ||
                (criterio.equals("autor") && l.getAutor().equalsIgnoreCase(valor)) ||
                (criterio.equals("isbn") && l.getIsbn().equalsIgnoreCase(valor))) {
                System.out.println("Encontrado: " + l);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Libro no encontrado.");
        }
    }

    public void eliminarLibro(String isbn) {
        Iterator<Libro> it = libros.iterator();
        while (it.hasNext()) {
            Libro l = it.next();
            if (l.getIsbn().equalsIgnoreCase(isbn)) {
                it.remove();
                categorias.get(l.getCategoria()).remove(l);
                System.out.println("Libro eliminado.");
                return;
            }
        }
        System.out.println("ISBN no encontrado.");
    }

    public void mostrarPorCategoria(String categoria) {
        ArrayList<Libro> cat = categorias.get(categoria);
        if (cat == null || cat.isEmpty()) {
            System.out.println("No hay libros en esta categoría.");
            return;
        }
        for (Libro l : cat) {
            System.out.println(l);
        }
    }

    public void prestarLibro(String isbn) {
        for (Libro l : libros) {
            if (l.getIsbn().equalsIgnoreCase(isbn) && l.isDisponible()) {
                l.setDisponible(false);
                librosPrestados.add(l);
                System.out.println("Libro prestado.");
                return;
            }
        }
        System.out.println("Libro no disponible o no encontrado.");
    }

    public void devolverLibro(String isbn) {
        Iterator<Libro> it = librosPrestados.iterator();
        while (it.hasNext()) {
            Libro l = it.next();
            if (l.getIsbn().equalsIgnoreCase(isbn)) {
                l.setDisponible(true);
                it.remove();
                System.out.println("Libro devuelto.");
                return;
            }
        }
        System.out.println("Libro no estaba prestado.");
    }

    public Set<String> obtenerCategorias() {
        return categorias.keySet();
    }
}
