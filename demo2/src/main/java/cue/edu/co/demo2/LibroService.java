package cue.edu.co.demo2;

import java.util.List;

public interface LibroService {
    void agregarLibro(Libro libro);
    List<Libro> listarLibros();
    Libro obtenerLibroPorId(int id);
    void eliminarLibro(int id);
}
