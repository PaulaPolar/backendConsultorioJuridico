package com.java.consultorioJuridico.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.consultorioJuridico.models.Caso;

public interface CasoRepository extends JpaRepository<Caso, Long>{

	ArrayList<Caso> findByEstudianteAsignado(Long idUsuario);

}
