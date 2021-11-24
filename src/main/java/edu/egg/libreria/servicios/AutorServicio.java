package edu.egg.libreria.servicios;

import edu.egg.libreria.entidades.Autor;
import edu.egg.libreria.errores.ErrorServicio;
import edu.egg.libreria.repositorios.AutorRepositorio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServicio {

    @Autowired
    private AutorRepositorio autorRepositorio;

    public void crear(String id, String nombre, Boolean alta) throws ErrorServicio {
        validar(id, nombre, alta);
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setAlta(Boolean.TRUE);
        autorRepositorio.save(autor);
    }

    public void modificar(String id, String nombre, Boolean alta) throws ErrorServicio {
        validar(id, nombre, alta);
        Optional<Autor> respuesta = autorRepositorio.findById(id);
        if (respuesta.isPresent())
        {
            Autor autor = respuesta.get();
            autor.setNombre(nombre);
            autor.setAlta(Boolean.TRUE);
            autorRepositorio.save(autor);
        } else
        {
            throw new ErrorServicio("No se encontró el autor solicitado");
        }

    }

    public void baja(String id) throws ErrorServicio{
        Optional<Autor> respuesta = autorRepositorio.findById(id);
        if (respuesta.isPresent())
        {
            Autor autor = respuesta.get();
            autor.setAlta(Boolean.FALSE);
            autorRepositorio.save(autor);
        } else
        {
            throw new ErrorServicio("No se encontró el autor solicitado");
        }
    }
     public void alta(String id) throws ErrorServicio{
        Optional<Autor> respuesta = autorRepositorio.findById(id);
        if (respuesta.isPresent())
        {
            Autor autor = respuesta.get();
            autor.setAlta(Boolean.TRUE);
            autorRepositorio.save(autor);
        } else
        {
            throw new ErrorServicio("No se encontró el autor solicitado");
        }
    }


    public Autor consultarId(String id) {
        return autorRepositorio.findById(id).get();
    }

    private void validar(String id, String nombre, Boolean alta) throws ErrorServicio {
        if (id == null || id.isEmpty())
        {
            throw new ErrorServicio("El id del Autor no puede ser nulo");
        }
        if (nombre == null || nombre.isEmpty())
        {
            throw new ErrorServicio("El nombre del Autor no puede ser nulo");
        }
        if (alta == null || alta)
        {
            throw new ErrorServicio("El alta del Autor no puede ser nulo");
        }
    }

}
