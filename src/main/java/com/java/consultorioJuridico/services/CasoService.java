package com.java.consultorioJuridico.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.consultorioJuridico.models.Caso;
import com.java.consultorioJuridico.repositories.CasoRepository;


public class CasoService {
	
	@Autowired
	CasoRepository casoRepository;

	public ArrayList<Caso> obtenerPorEstudiante(Long idEstudiante) {
		return casoRepository.findByEstudianteAsignado(idEstudiante);
	}

	
    
}
