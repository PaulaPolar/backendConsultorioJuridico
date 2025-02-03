package com.java.consultorioJuridico.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.consultorioJuridico.models.Caso;
import com.java.consultorioJuridico.models.Usuario;
import com.java.consultorioJuridico.models.enums.EstadoCasoEnum;
import com.java.consultorioJuridico.repositories.CasoRepository;
import com.java.consultorioJuridico.repositories.UsuarioRepository;

@Service
public class CasoService {
	
	private final CasoRepository casoRepository;
    private final UsuarioRepository usuarioRepository;
    
    public CasoService(CasoRepository casoRepository, UsuarioRepository usuarioRepository) {
        this.casoRepository = casoRepository;
        this.usuarioRepository = usuarioRepository;
    }

	public List<Caso> obtenerPorEstudiante(Long idEstudiante) {
		return casoRepository.findByEstudianteAsignado(idEstudiante);
	}

	@Transactional
    public Caso actualizarCaso(Long idCaso, EstadoCasoEnum nuevoEstado, Long idEstudiante) {
        Optional<Caso> optionalCaso = casoRepository.findById(idCaso);

        if (optionalCaso.isEmpty()) {
            throw new RuntimeException("Caso no encontrado con ID: " + idCaso);
        }

        Caso caso = optionalCaso.get();

        // Si se envió un estado, actualizarlo
        if (nuevoEstado != null) {
            caso.setEstadoCaso(nuevoEstado);
        }

        // Si se envió un ID de estudiante, asignarlo
        if (idEstudiante != null) {
            Usuario estudiante = usuarioRepository.findById(idEstudiante)
                    .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + idEstudiante));
            caso.setEstudianteAsignado(estudiante);
        }

        return casoRepository.save(caso);
    }
	
	@Transactional
    public Caso registrarCaso(Long idUsuario, String tipoCaso, String descripcion) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + idUsuario));

        Caso nuevoCaso = new Caso();
        nuevoCaso.setUsuario(usuario);
        nuevoCaso.setTipoCaso(tipoCaso);
        nuevoCaso.setDescripcion(descripcion);
        nuevoCaso.setEstadoCaso(EstadoCasoEnum.ABIERTO); // Estado inicial
        nuevoCaso.setFechaCreacion(LocalDateTime.now());

        return casoRepository.save(nuevoCaso);
    }
	
}
