package com.java.consultorioJuridico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.consultorioJuridico.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
