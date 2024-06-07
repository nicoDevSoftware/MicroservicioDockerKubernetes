package org.nico.springcloud.msvc_cursos.clientes;


import org.nico.springcloud.msvc_cursos.models.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "msvc-usuarios",url="localhost:8001")
public interface UsuarioClienteRest {

    @GetMapping("/{id}")
    //no ponemos public Usuario detalle porq en interface por defecto es public
    Usuario detalle(@PathVariable Long id);

    //estos metodos se coenctar con el controlador de Usuario
    //son el nexo de conexion entre los microservicios
    @PostMapping()
    Usuario crear(@RequestBody Usuario usuario);



}
