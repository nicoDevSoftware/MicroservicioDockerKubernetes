package org.nico.springcloud.msvc.usuarios.repository;

import org.nico.springcloud.msvc.usuarios.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {


    //hacemos 2 opciones de buscar por email para tenerlas en cuenta!
    Optional<Usuario> findByEmail(String email);

    // la sentencia preparada ?1 se va remplazar por el email q le pasamos abajo String email
    // si necesitariamos mas paremetros la sentencia seria ?2
    @Query("select u from Usuario u where u.email=?1")
    Optional<Usuario> porEmail(String email);

    boolean existsByEmail(String email);

















}
