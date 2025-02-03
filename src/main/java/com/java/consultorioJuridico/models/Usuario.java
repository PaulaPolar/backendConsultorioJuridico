package com.java.consultorioJuridico.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.java.consultorioJuridico.models.enums.RolUsuarioEnum;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre_usuario", length = 50)
    private String nombreUsuario;

    @Column(name = "rol_usuario", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private RolUsuarioEnum rolUsuario;

    @Column(name = "correo", length = 50, nullable = false, unique = true)
    private String correo;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public RolUsuarioEnum getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(RolUsuarioEnum rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

