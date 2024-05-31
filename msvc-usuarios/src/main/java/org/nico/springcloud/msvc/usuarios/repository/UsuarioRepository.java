package org.nico.springcloud.msvc.usuarios.repository;

import org.nico.springcloud.msvc.usuarios.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {


}
