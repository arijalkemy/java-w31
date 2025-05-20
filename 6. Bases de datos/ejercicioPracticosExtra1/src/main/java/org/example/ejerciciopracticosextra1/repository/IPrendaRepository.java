package org.example.ejerciciopracticosextra1.repository;
import org.example.ejerciciopracticosextra1.model.Prenda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IPrendaRepository extends CrudRepository<Prenda, Long> {

    @Query("select p from Prenda p")
    List<Prenda> getAllPrendas();

    @Query("select p from Prenda p where p.codigo like :codigo")
    Prenda getPrendaByCodigo(@Param("codigo") String codigo);

    @Query("select p from Prenda p where p.talla = :talla")
    List<Prenda> getPrendaByTalla(@Param("talla") Prenda.Talla talla);

    @Query("select p from Prenda p where lower(p.nombre) like lower(concat('%', :nombre, '%'))")
    List<Prenda> getPrendaByNombre(@Param("nombre") String nombre);

    void deleteByCodigo(String codigo);

    @Query("select v.prendas from Venta v where v.fecha =: fecha")
    List<Prenda> getPrendasByFecha(Date fecha);

    @Query("select v.prendas from Venta v where v.numero =:numero")
    List<Prenda> getPrendasByNumero(Long numero);
}
