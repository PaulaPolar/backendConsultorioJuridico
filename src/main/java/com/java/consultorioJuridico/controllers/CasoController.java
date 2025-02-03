package com.java.consultorioJuridico.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.consultorioJuridico.dto.CreacionCasoDTO;
import com.java.consultorioJuridico.models.Caso;
import com.java.consultorioJuridico.models.enums.EstadoCasoEnum;
import com.java.consultorioJuridico.services.CasoService;


@RestController
@RequestMapping("/caso")
public class CasoController {

	private final CasoService casoService;

    public CasoController(CasoService casoService) {
        this.casoService = casoService;
    }

    @GetMapping("/estudiante/{idEstudiante}")
    public ResponseEntity<List<Caso>> obtenerCasosPorEstudiante(@PathVariable Long idEstudiante) {
        List<Caso> casos = casoService.obtenerPorEstudiante(idEstudiante);
        return ResponseEntity.ok(casos);
    }
	 
    @PutMapping("/{idCaso}")
    public ResponseEntity<Caso> actualizarCaso(@PathVariable Long idCaso,
                                               @RequestParam(required = false) EstadoCasoEnum estado,
                                               @RequestParam(required = false) Long idEstudiante) {
        Caso casoActualizado = casoService.actualizarCaso(idCaso, estado, idEstudiante);
        return ResponseEntity.ok(casoActualizado);
    }
    
    @PostMapping
    public ResponseEntity<Caso> registrarCaso(@RequestBody CreacionCasoDTO infoCaso) {
        Caso casoRegistrado = casoService.registrarCaso(infoCaso.getIdUsuario(), infoCaso.getTipoCaso(), infoCaso.getDescripcion());
        return ResponseEntity.ok(casoRegistrado);
    }
	 
}
