package org.nico.springcloud.msvc_cursos.repositories;

import org.nico.springcloud.msvc_cursos.models.entity.Curso;
import org.springframework.data.repository.CrudRepository;


public interface CursoRepository extends CrudRepository<Curso,Long> {

}
