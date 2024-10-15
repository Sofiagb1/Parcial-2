package cue.edu.co.demo2;

import java.util.List;

public class LibroServiceImpl implements LibroService {
    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public void agregarLibro(Libro libro) {
        libroRepository.guardarLibro(libro);
    }

    @Override
    public List<Libro> listarLibros() {
        return libroRepository.obtenerLibros();
    }

    @Override
    public Libro obtenerLibroPorId(int id) {
        return libroRepository.buscarLibroPorId(id);
    }

    @Override
    public void eliminarLibro(int id) {
        libroRepository.eliminarLibro(id);
    }
}
