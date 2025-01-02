package org.nico.springcloud.msvc.usuarios.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="msvc-cursos", url ="${msvc.cursos.url}")
public interface CursoClienteRest {

    // este metodo esta en micro de  Curso el cual usamos para
    // conectarnos desde usuario y eliminar el usuario dentro del curso
    @DeleteMapping("/eliminar-usuarioDeCurso/{id}")
    void eliminarCursoUsuarioPorId(@PathVariable Long id);
}
