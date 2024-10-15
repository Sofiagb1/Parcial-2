package cue.edu.co.demo2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibroRepositoryImpl implements LibroRepository {
    private static final String FILE_PATH = "libros.dat";
    private List<Libro> libros;

    @SuppressWarnings("unchecked")
    public LibroRepositoryImpl() {
        libros = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                libros = (List<Libro>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void guardarLibro(Libro libro) {
        libros.add(libro);
        guardarCambios();
    }

    @Override
    public List<Libro> obtenerLibros() {
        return libros;
    }

    @Override
    public Libro buscarLibroPorId(int id) {
        return libros.stream()
                .filter(libro -> libro.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void eliminarLibro(int id) {
        libros.removeIf(libro -> libro.getId() == id);
        guardarCambios();
    }

    private void guardarCambios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(libros);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
