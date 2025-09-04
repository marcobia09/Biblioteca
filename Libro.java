public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private String categoria;
    private boolean disponible;

    public Libro(String titulo, String autor, String isbn, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.categoria = categoria;
        this.disponible = true;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getIsbn() { return isbn; }
    public String getCategoria() { return categoria; }
    public boolean isDisponible() { return disponible; }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "[" + (disponible ? "DISPONIBLE" : "PRESTADO") + "] "
             + "Título: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn + ", Categoría: " + categoria;
    }
}
