package ar.com.osde.dotcms.backend.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ss94848846
 */
@XmlRootElement(name="Usuarios")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsuariosDTO implements Serializable {

    private static final long serialVersionUID = -4630505103529059452L;

    @XmlElement(name = "Usuario")
    private List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();

    public List<UsuarioDTO> getUsuarios(){
        return usuarios;
    }

    public void setUsuarios(List<UsuarioDTO> usuarios){
        this.usuarios = usuarios;
    }
}