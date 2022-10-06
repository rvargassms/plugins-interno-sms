package ar.com.osde.dotcms.backend.dtos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author ss94848846
 */
@XmlRootElement(name = "permiso")
public class PermisoDTO implements Serializable {

    private static final long serialVersionUID = 7577578431673173808L;
    private String codigo;
    private UsuariosDTO usuariosDTO;

    public String getCodigo() {
        return codigo;
    }

    @XmlElement(name = "codigo")
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public UsuariosDTO getUsuariosDTO() {
        return usuariosDTO;
    }

    @XmlElement(name = "Usuarios")
    public void setUsuariosDTO(UsuariosDTO usuariosDTO) {
        this.usuariosDTO = usuariosDTO;
    }
}