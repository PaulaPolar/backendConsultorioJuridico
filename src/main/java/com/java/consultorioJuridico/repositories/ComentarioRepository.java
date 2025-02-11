package com.java.consultorioJuridico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.consultorioJuridico.models.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long>{

	List<Comentario> findByCasoIdCaso(Long casoId);
}
