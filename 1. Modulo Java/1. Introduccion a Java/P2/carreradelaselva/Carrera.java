package carreradelaselva;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Carrera {

    private String nombre;
    private String descripcion;
    private double distancia;
    private List<Categoria> categorias;
    private Set<Inscripcion> inscriptosTotales;

    public Carrera(String nombre, String descripcion, double distancia) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.distancia = distancia;
        this.categorias = new ArrayList<>();
        this.inscriptosTotales = new HashSet<>();
    }

    public void agregarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    public List<Categoria> getCategorias() {
        return new ArrayList<>(categorias);
    }

    public Categoria getCategoria(Categoria categoria) {
        for (Categoria cat : categorias) {
            if (cat.getNombre().equals(categoria.getNombre())) {
                return cat;
            }
        }
        throw new IllegalArgumentException("Categoría no encontrada");
    }

    public double getMontoRecaudado() {
        return categorias.stream()
                .mapToDouble(Categoria::getDineroRecaudado)
                .sum();
    }

    public void inscribirUsuarioEnCategoria(Inscripcion inscripcion) {
        Categoria categoria = inscripcion.getCategoria();
        if (!categorias.contains(categoria)) {
            throw new IllegalArgumentException("La categoría no pertenece a esta carrera");
        }
        categoria.inscribirUsuario(inscripcion);
        inscriptosTotales.add(inscripcion);
    }

    public int getCantidadInscriptos() {
        return inscriptosTotales.size();
    }

    public void desinscribirUsuario(Inscripcion inscripcion) {
        Categoria categoria = inscripcion.getCategoria();
        if (categorias.contains(categoria)) {
            categoria.desinscribirUsuario(inscripcion);
            inscriptosTotales.remove(inscripcion);
        } else {
            throw new IllegalArgumentException("La categoría no pertenece a esta carrera");
        }
    }

}
