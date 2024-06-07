package org.nico.springcloud.msvc_cursos.services;

import org.nico.springcloud.msvc_cursos.models.Usuario;
import org.nico.springcloud.msvc_cursos.models.entity.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {

    List<Curso>listar();
    Optional<Curso> porId(Long id);
    Curso guardar(Curso curso);
    void eliminar(Long id);



    //de aca para arriba tenemos la logica de negocia de percistencia de datos
    // ahhora vamos hacer la logica en donde obtenemos los datos desde otro servicio
    Optional<Usuario>asignarUsuario(Usuario usuario,Long cursoId);
    //este metodo es un usuario que todavia no existe en la BDD entonces desde microservisio cursos
    //le enviamos un nuevo usuario para que lo cree y lo inserte en el microservicio usuario
    Optional<Usuario>crearUsuario(Usuario usuario,Long cursoId);
    //eliminamos el usuario de un curso en particular nada mas.
    Optional<Usuario>eliminarUsuario(Usuario usuario ,Long cursoId);













}
