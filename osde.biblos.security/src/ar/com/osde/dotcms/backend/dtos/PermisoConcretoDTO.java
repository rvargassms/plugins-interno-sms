package ar.com.osde.dotcms.backend.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author Jhony Vidal
 */
@XmlRootElement(name = "Permisos")
public class PermisoConcretoDTO implements Serializable {

    private static final long serialVersionUID = 9066691201622278118L;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    private String nombre;
    private String descripcion;
    private String permiso;
}