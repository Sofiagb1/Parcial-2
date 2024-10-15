package cue.edu.co.demo2;

import java.util.List;

public interface LibroRepository {
    void guardarLibro(Libro libro);
    List<Libro> obtenerLibros();
    Libro buscarLibroPorId(int id);
    void eliminarLibro(int id);
}
