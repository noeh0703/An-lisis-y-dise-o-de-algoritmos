package Recursos;

public class Libro 
{
private String isbn;  //codigo del libro
    private String titulo;
    private String autor;
    private String editorial;
    private String categoria;
    private int version;   // número de edición del libro
    private int año;      // año de publicación

    // Constructor
    public Libro(String isbn, String titulo, String autor, String editorial, String categoria, int version, int año) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.categoria = categoria;
        this.version = version;
        this.año = año;
    }

    // Getters y Setters
    public String getIsbn() { 
        return isbn; 
    }
    public void setIsbn(String isbn) { 
        this.isbn = isbn; 
    }

    public String getTitulo() { 
        return titulo; 
    }
    public void setTitulo(String titulo) { 
        this.titulo = titulo; 
    }

    public String getAutor() { 
        return autor; 
    }
    public void setAutor(String autor) { 
        this.autor = autor; 
    }

    public String getEditorial() { 
        return editorial; 
    }
    public void setEditorial(String editorial) { 
        this.editorial = editorial; 
    }

    public String getCategoria() { 
        return categoria; 
    }
    public void setCategoria(String categoria) { 
        this.categoria = categoria; 
    }

    public int getVersion() { 
        return version; 
    }
    public void setVersion(int version) { 
        this.version = version; 
    }

    public int getAño() { 
        return año; 
    }
    public void setAño(int año) { 
        this.año = año; 
    }

    // Mostrar el libro
    @Override
    public String toString() {
        return isbn + " - " + titulo + " (" + autor + ", " + editorial +
               ", " + categoria + ", versión " + version + ", " + año + ")";
    }    
}