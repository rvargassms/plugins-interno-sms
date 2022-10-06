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
@XmlRootElement(name = "seguridadPF")
@XmlAccessorType(XmlAccessType.FIELD)
public class PermisosConcretosDTO implements Serializable {

    private static final long serialVersionUID = -7799915605063739732L;

    @XmlElement(name = "Permisos")
    private List<PermisoConcretoDTO> seguridadPFDTO = new ArrayList<PermisoConcretoDTO>();

    public List<PermisoConcretoDTO> getSeguridadPFDTO() {
        return seguridadPFDTO;
    }

    public void setSeguridadPFDTO(List<PermisoConcretoDTO> seguridadPFDTO) {
        this.seguridadPFDTO = seguridadPFDTO;
    }
}