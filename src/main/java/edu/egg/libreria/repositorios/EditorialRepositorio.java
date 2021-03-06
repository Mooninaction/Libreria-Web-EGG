package edu.egg.libreria.repositorios;

import edu.egg.libreria.entidades.Editorial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, String> {

    @Query("select p from Editorial p where p.nombre LIKE :q")
    List<Editorial> findAll(@Param("q") String q);
}
