package com.java.consultorioJuridico.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.consultorioJuridico.models.Caso;
import com.java.consultorioJuridico.models.Comentario;
import com.java.consultorioJuridico.models.Usuario;
import com.java.consultorioJuridico.repositories.CasoRepository;
import com.java.consultorioJuridico.repositories.ComentarioRepository;
import com.java.consultorioJuridico.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class ComentarioService {

	private final ComentarioRepository comentarioRepository;
	private final UsuarioRepository usuarioRepository;
    private final CasoRepository casoRepository;

    public ComentarioService(ComentarioRepository comentarioRepository, CasoRepository casoRepository, UsuarioRepository usuarioRepository) {
        this.comentarioRepository = comentarioRepository;
        this.casoRepository = casoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Comentario agregarComentario(Long casoId, Long usuarioId, String contenido) {
        Caso caso = casoRepository.findById(casoId)
                .orElseThrow(() -> new RuntimeException("Caso no encontrado"));
        
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Comentario comentario = new Comentario(caso, contenido);
        comentario.setUsuario(usuario);
        comentario.setFechaCreacion(LocalDateTime.now());

        return comentarioRepository.save(comentario);
    }
    
    public List<Comentario> obtenerComentariosPorCaso(Long casoId) {
        return comentarioRepository.findByCasoIdCaso(casoId);
    }
	
}
