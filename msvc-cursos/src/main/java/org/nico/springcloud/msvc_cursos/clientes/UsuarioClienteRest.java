package org.nico.springcloud.msvc_cursos.clientes;


import org.nico.springcloud.msvc_cursos.models.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "msvc-usuarios",url="${msvc.usuarios.url}")
public interface UsuarioClienteRest {
    // aca estamos consumiendo los controladores de usuario
    // para usarlo dentro de
    @GetMapping("/{id}")
    //no ponemos public Usuario detalle porq en interface por defecto es public
    Usuario detalle(@PathVariable Long id);

    //estos metodos se coenctar con el controlador de Usuario
    //son el nexo de conexion entre los microservicios
    @PostMapping()
    Usuario crear(@RequestBody Usuario usuario);

    @GetMapping("/usuarios-por-cursos")
    List<Usuario>  obtenerAlumnosPorCurso(@RequestParam Iterable<Long> ids);




}
