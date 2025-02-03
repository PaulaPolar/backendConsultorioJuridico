package com.java.consultorioJuridico.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.consultorioJuridico.dto.ComentarioDTO;
import com.java.consultorioJuridico.dto.ComentarioRespuestaDTO;
import com.java.consultorioJuridico.models.Comentario;
import com.java.consultorioJuridico.services.ComentarioService;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

	private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping("/caso")
    public ResponseEntity<Comentario> agregarComentario(@RequestBody ComentarioDTO comentarioDTO) {
        Comentario comentario = comentarioService.agregarComentario(comentarioDTO.getIdCaso(), comentarioDTO.getIdUsuario(), comentarioDTO.getContenido());
        return ResponseEntity.ok(comentario);
    }
    
    @GetMapping("/caso/{casoId}")
    public ResponseEntity<List<ComentarioRespuestaDTO>> obtenerComentariosPorCaso(@PathVariable Long casoId) {
        List<Comentario> comentarios = comentarioService.obtenerComentariosPorCaso(casoId);
        
        // Convertir la lista de Comentario a una lista de ComentarioDTO
        List<ComentarioRespuestaDTO> comentariosDTO = comentarios.stream()
                .map(comentario -> new ComentarioRespuestaDTO(comentario.getContenido()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(comentariosDTO);
    }
    
}
