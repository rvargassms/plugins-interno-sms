package ar.com.osde.dotcms.backend.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author ss94848846
 */
@XmlRootElement(name="Usuario")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = -162215569591580233L;
    private String username;
    private String nombre;
    private String apellido;
    private String filial;
    private String codFilial;
    private String cap;
    private String codCap;
    private String empresa;
    private String empresaNro;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public String getCodFilial() {
        return codFilial;
    }

    public void setCodFilial(String codFilial) {
        this.codFilial = codFilial;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getCodCap() {
        return codCap;
    }

    public void setCodCap(String codCap) {
        this.codCap = codCap;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEmpresaNro() {
        return empresaNro;
    }

    public void setEmpresaNro(String empresaNro) {
        this.empresaNro = empresaNro;
    }
}