package ar.com.osde.dotcms.backend.dtos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author ss94848846
 */
@XmlRootElement(name = "permisos")
public class PermisosDTO implements Serializable {

    private static final long serialVersionUID = -15847785531523337L;
    private PermisoDTO permiso;

    public PermisoDTO getPermiso(){
        return permiso;
    }

    @XmlElement
    public void setPermiso(PermisoDTO permiso) {
        this.permiso = permiso;
    }
}