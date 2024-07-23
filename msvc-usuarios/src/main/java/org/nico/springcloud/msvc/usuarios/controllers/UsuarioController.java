package org.nico.springcloud.msvc.usuarios.controllers;


import feign.Response;
import jakarta.validation.Valid;
import org.nico.springcloud.msvc.usuarios.models.entity.Usuario;
import org.nico.springcloud.msvc.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public Map<String ,List<Usuario>> listar() {

        return Collections.singletonMap("usuarios",service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = service.porId(id);
        if (usuarioOptional.isPresent()) {
            return ResponseEntity.ok(usuarioOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crear(@Valid @RequestBody Usuario usuario, BindingResult result) {

        if (result.hasErrors()) {
            return validar(result);
        }
        //!usuario.getEmail().isBlank() si no esta vacio!
        if(!usuario.getEmail().isBlank() && service.existePorEmail(usuario.getEmail())){
            return ResponseEntity.badRequest().body(Collections.singletonMap("mensaje",
                    "Ya, existe un usuario con ese email!"));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Usuario usuario, BindingResult result, @PathVariable Long id) {

        if (result.hasErrors()) {
            return validar(result);
        }

        Optional<Usuario> usuario1 = service.porId(id);
        if (usuario1.isPresent()) {
            Usuario usuarioDb = usuario1.get();
            if(!usuario.getEmail().isBlank() &&
                    !usuario.getEmail().equalsIgnoreCase(usuarioDb.getEmail()) &&
                    service.porEmail(usuario.getEmail()).isPresent() ){
                return ResponseEntity.badRequest().body(Collections.singletonMap("mensaje",
                        "Ya existe un usuario con ese email!"));
            }
            usuarioDb.setNombre(usuario.getNombre());
            usuarioDb.setEmail(usuario.getEmail());
            usuarioDb.setPassword(usuario.getPassword());
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.guardar(usuarioDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Usuario> o = service.porId(id);
        if (o.isPresent()) {
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/usuarios-por-cursos")
    public ResponseEntity<?> obtenerAlumnosPorCurso(@RequestParam List<Long> ids){
        return ResponseEntity.ok(service.listarPorIds(ids));
    }


    private ResponseEntity<Map<String, String>> validar(BindingResult result) {
        //por cada error que haya lo vamos a guardar en un map llave valor para despeus devolverlo
        Map<String, String> errores = new HashMap<>();
//  recorremos el  result que tiene los errores y agregamos esos errores 1 por 1 al map de errores
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), " El campo! " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }


}
