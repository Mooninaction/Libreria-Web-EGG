package edu.egg.libreria.repositorios;

import edu.egg.libreria.entidades.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, String> {

    @Query("select p from Editorial p where p.nombre LIKE :q")
    List<Libro> findAll(@Param("q") String q);
}
