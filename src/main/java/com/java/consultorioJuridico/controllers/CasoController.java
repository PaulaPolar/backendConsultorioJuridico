package com.java.consultorioJuridico.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.consultorioJuridico.models.Caso;
import com.java.consultorioJuridico.services.CasoService;


@RestController
@RequestMapping("/caso")
public class CasoController {

	@Autowired
    CasoService casoService;

	 @GetMapping("/estudiante/{idEstudiante}")
	    public ArrayList<Caso> obtenerCasosPorEstudiante(@PathVariable Long idEstudiante){
	        return this.casoService.obtenerPorEstudiante(idEstudiante);
	}
	 
}
