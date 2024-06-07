package org.nico.springcloud.msvc_cursos.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name="curso_usuarios")
    public class CursoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "usuario_id",unique = true)
    private Long usuarioId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this ==obj){
            return true;
        }
        if (!(obj instanceof CursoUsuario)){
            return false;
        }
        CursoUsuario ob= (CursoUsuario) obj;
        return this.usuarioId != null && this.usuarioId.equals(ob.usuarioId);
    }
}
