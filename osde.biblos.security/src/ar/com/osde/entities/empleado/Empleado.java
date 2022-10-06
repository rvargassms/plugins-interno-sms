/**
 * Empleado.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.entities.empleado;

public class Empleado  implements java.io.Serializable {
    private java.lang.String nombres;

    private java.lang.String apellidos;

    private int baja;

    private java.lang.String sexo;

    private int codFilial;

    private int codCAP;

    private java.lang.String afectacion;

    private java.lang.String celularLaboral;

    private java.lang.String email;

    private java.util.Calendar fechaNacimiento;

    private java.util.Calendar fechaUltimaActualizacion;

    private java.lang.String idEmpleado;

    private int interno;

    private java.lang.String nombre;

    private java.lang.String nombreUsuario;

    private java.lang.String piso;

    private int prefijo;

    private ar.com.osde.services.administracion.empleado.SearchResult puestosDeTrabajo;

    private ar.com.osde.entities.empleado.Responsable[] responsables;

    private java.lang.String telefonoPersonal;

    private java.lang.String descripcionFilial;

    private java.lang.String descripionCAP;

    private java.lang.String direccionCAP;

    private java.lang.String direccionFilial;

    public Empleado() {
    }

    public Empleado(
           java.lang.String nombres,
           java.lang.String apellidos,
           int baja,
           java.lang.String sexo,
           int codFilial,
           int codCAP,
           java.lang.String afectacion,
           java.lang.String celularLaboral,
           java.lang.String email,
           java.util.Calendar fechaNacimiento,
           java.util.Calendar fechaUltimaActualizacion,
           java.lang.String idEmpleado,
           int interno,
           java.lang.String nombre,
           java.lang.String nombreUsuario,
           java.lang.String piso,
           int prefijo,
           ar.com.osde.services.administracion.empleado.SearchResult puestosDeTrabajo,
           ar.com.osde.entities.empleado.Responsable[] responsables,
           java.lang.String telefonoPersonal,
           java.lang.String descripcionFilial,
           java.lang.String descripionCAP,
           java.lang.String direccionCAP,
           java.lang.String direccionFilial) {
           this.nombres = nombres;
           this.apellidos = apellidos;
           this.baja = baja;
           this.sexo = sexo;
           this.codFilial = codFilial;
           this.codCAP = codCAP;
           this.afectacion = afectacion;
           this.celularLaboral = celularLaboral;
           this.email = email;
           this.fechaNacimiento = fechaNacimiento;
           this.fechaUltimaActualizacion = fechaUltimaActualizacion;
           this.idEmpleado = idEmpleado;
           this.interno = interno;
           this.nombre = nombre;
           this.nombreUsuario = nombreUsuario;
           this.piso = piso;
           this.prefijo = prefijo;
           this.puestosDeTrabajo = puestosDeTrabajo;
           this.responsables = responsables;
           this.telefonoPersonal = telefonoPersonal;
           this.descripcionFilial = descripcionFilial;
           this.descripionCAP = descripionCAP;
           this.direccionCAP = direccionCAP;
           this.direccionFilial = direccionFilial;
    }


    /**
     * Gets the nombres value for this Empleado.
     * 
     * @return nombres
     */
    public java.lang.String getNombres() {
        return nombres;
    }


    /**
     * Sets the nombres value for this Empleado.
     * 
     * @param nombres
     */
    public void setNombres(java.lang.String nombres) {
        this.nombres = nombres;
    }


    /**
     * Gets the apellidos value for this Empleado.
     * 
     * @return apellidos
     */
    public java.lang.String getApellidos() {
        return apellidos;
    }


    /**
     * Sets the apellidos value for this Empleado.
     * 
     * @param apellidos
     */
    public void setApellidos(java.lang.String apellidos) {
        this.apellidos = apellidos;
    }


    /**
     * Gets the baja value for this Empleado.
     * 
     * @return baja
     */
    public int getBaja() {
        return baja;
    }


    /**
     * Sets the baja value for this Empleado.
     * 
     * @param baja
     */
    public void setBaja(int baja) {
        this.baja = baja;
    }


    /**
     * Gets the sexo value for this Empleado.
     * 
     * @return sexo
     */
    public java.lang.String getSexo() {
        return sexo;
    }


    /**
     * Sets the sexo value for this Empleado.
     * 
     * @param sexo
     */
    public void setSexo(java.lang.String sexo) {
        this.sexo = sexo;
    }


    /**
     * Gets the codFilial value for this Empleado.
     * 
     * @return codFilial
     */
    public int getCodFilial() {
        return codFilial;
    }


    /**
     * Sets the codFilial value for this Empleado.
     * 
     * @param codFilial
     */
    public void setCodFilial(int codFilial) {
        this.codFilial = codFilial;
    }


    /**
     * Gets the codCAP value for this Empleado.
     * 
     * @return codCAP
     */
    public int getCodCAP() {
        return codCAP;
    }


    /**
     * Sets the codCAP value for this Empleado.
     * 
     * @param codCAP
     */
    public void setCodCAP(int codCAP) {
        this.codCAP = codCAP;
    }


    /**
     * Gets the afectacion value for this Empleado.
     * 
     * @return afectacion
     */
    public java.lang.String getAfectacion() {
        return afectacion;
    }


    /**
     * Sets the afectacion value for this Empleado.
     * 
     * @param afectacion
     */
    public void setAfectacion(java.lang.String afectacion) {
        this.afectacion = afectacion;
    }


    /**
     * Gets the celularLaboral value for this Empleado.
     * 
     * @return celularLaboral
     */
    public java.lang.String getCelularLaboral() {
        return celularLaboral;
    }


    /**
     * Sets the celularLaboral value for this Empleado.
     * 
     * @param celularLaboral
     */
    public void setCelularLaboral(java.lang.String celularLaboral) {
        this.celularLaboral = celularLaboral;
    }


    /**
     * Gets the email value for this Empleado.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this Empleado.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the fechaNacimiento value for this Empleado.
     * 
     * @return fechaNacimiento
     */
    public java.util.Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }


    /**
     * Sets the fechaNacimiento value for this Empleado.
     * 
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(java.util.Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    /**
     * Gets the fechaUltimaActualizacion value for this Empleado.
     * 
     * @return fechaUltimaActualizacion
     */
    public java.util.Calendar getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }


    /**
     * Sets the fechaUltimaActualizacion value for this Empleado.
     * 
     * @param fechaUltimaActualizacion
     */
    public void setFechaUltimaActualizacion(java.util.Calendar fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }


    /**
     * Gets the idEmpleado value for this Empleado.
     * 
     * @return idEmpleado
     */
    public java.lang.String getIdEmpleado() {
        return idEmpleado;
    }


    /**
     * Sets the idEmpleado value for this Empleado.
     * 
     * @param idEmpleado
     */
    public void setIdEmpleado(java.lang.String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }


    /**
     * Gets the interno value for this Empleado.
     * 
     * @return interno
     */
    public int getInterno() {
        return interno;
    }


    /**
     * Sets the interno value for this Empleado.
     * 
     * @param interno
     */
    public void setInterno(int interno) {
        this.interno = interno;
    }


    /**
     * Gets the nombre value for this Empleado.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this Empleado.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the nombreUsuario value for this Empleado.
     * 
     * @return nombreUsuario
     */
    public java.lang.String getNombreUsuario() {
        return nombreUsuario;
    }


    /**
     * Sets the nombreUsuario value for this Empleado.
     * 
     * @param nombreUsuario
     */
    public void setNombreUsuario(java.lang.String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }


    /**
     * Gets the piso value for this Empleado.
     * 
     * @return piso
     */
    public java.lang.String getPiso() {
        return piso;
    }


    /**
     * Sets the piso value for this Empleado.
     * 
     * @param piso
     */
    public void setPiso(java.lang.String piso) {
        this.piso = piso;
    }


    /**
     * Gets the prefijo value for this Empleado.
     * 
     * @return prefijo
     */
    public int getPrefijo() {
        return prefijo;
    }


    /**
     * Sets the prefijo value for this Empleado.
     * 
     * @param prefijo
     */
    public void setPrefijo(int prefijo) {
        this.prefijo = prefijo;
    }


    /**
     * Gets the puestosDeTrabajo value for this Empleado.
     * 
     * @return puestosDeTrabajo
     */
    public ar.com.osde.services.administracion.empleado.SearchResult getPuestosDeTrabajo() {
        return puestosDeTrabajo;
    }


    /**
     * Sets the puestosDeTrabajo value for this Empleado.
     * 
     * @param puestosDeTrabajo
     */
    public void setPuestosDeTrabajo(ar.com.osde.services.administracion.empleado.SearchResult puestosDeTrabajo) {
        this.puestosDeTrabajo = puestosDeTrabajo;
    }


    /**
     * Gets the responsables value for this Empleado.
     * 
     * @return responsables
     */
    public ar.com.osde.entities.empleado.Responsable[] getResponsables() {
        return responsables;
    }


    /**
     * Sets the responsables value for this Empleado.
     * 
     * @param responsables
     */
    public void setResponsables(ar.com.osde.entities.empleado.Responsable[] responsables) {
        this.responsables = responsables;
    }

    public ar.com.osde.entities.empleado.Responsable getResponsables(int i) {
        return this.responsables[i];
    }

    public void setResponsables(int i, ar.com.osde.entities.empleado.Responsable _value) {
        this.responsables[i] = _value;
    }


    /**
     * Gets the telefonoPersonal value for this Empleado.
     * 
     * @return telefonoPersonal
     */
    public java.lang.String getTelefonoPersonal() {
        return telefonoPersonal;
    }


    /**
     * Sets the telefonoPersonal value for this Empleado.
     * 
     * @param telefonoPersonal
     */
    public void setTelefonoPersonal(java.lang.String telefonoPersonal) {
        this.telefonoPersonal = telefonoPersonal;
    }


    /**
     * Gets the descripcionFilial value for this Empleado.
     * 
     * @return descripcionFilial
     */
    public java.lang.String getDescripcionFilial() {
        return descripcionFilial;
    }


    /**
     * Sets the descripcionFilial value for this Empleado.
     * 
     * @param descripcionFilial
     */
    public void setDescripcionFilial(java.lang.String descripcionFilial) {
        this.descripcionFilial = descripcionFilial;
    }


    /**
     * Gets the descripionCAP value for this Empleado.
     * 
     * @return descripionCAP
     */
    public java.lang.String getDescripionCAP() {
        return descripionCAP;
    }


    /**
     * Sets the descripionCAP value for this Empleado.
     * 
     * @param descripionCAP
     */
    public void setDescripionCAP(java.lang.String descripionCAP) {
        this.descripionCAP = descripionCAP;
    }


    /**
     * Gets the direccionCAP value for this Empleado.
     * 
     * @return direccionCAP
     */
    public java.lang.String getDireccionCAP() {
        return direccionCAP;
    }


    /**
     * Sets the direccionCAP value for this Empleado.
     * 
     * @param direccionCAP
     */
    public void setDireccionCAP(java.lang.String direccionCAP) {
        this.direccionCAP = direccionCAP;
    }


    /**
     * Gets the direccionFilial value for this Empleado.
     * 
     * @return direccionFilial
     */
    public java.lang.String getDireccionFilial() {
        return direccionFilial;
    }


    /**
     * Sets the direccionFilial value for this Empleado.
     * 
     * @param direccionFilial
     */
    public void setDireccionFilial(java.lang.String direccionFilial) {
        this.direccionFilial = direccionFilial;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Empleado)) return false;
        Empleado other = (Empleado) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.nombres==null && other.getNombres()==null) || 
             (this.nombres!=null &&
              this.nombres.equals(other.getNombres()))) &&
            ((this.apellidos==null && other.getApellidos()==null) || 
             (this.apellidos!=null &&
              this.apellidos.equals(other.getApellidos()))) &&
            this.baja == other.getBaja() &&
            ((this.sexo==null && other.getSexo()==null) || 
             (this.sexo!=null &&
              this.sexo.equals(other.getSexo()))) &&
            this.codFilial == other.getCodFilial() &&
            this.codCAP == other.getCodCAP() &&
            ((this.afectacion==null && other.getAfectacion()==null) || 
             (this.afectacion!=null &&
              this.afectacion.equals(other.getAfectacion()))) &&
            ((this.celularLaboral==null && other.getCelularLaboral()==null) || 
             (this.celularLaboral!=null &&
              this.celularLaboral.equals(other.getCelularLaboral()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.fechaNacimiento==null && other.getFechaNacimiento()==null) || 
             (this.fechaNacimiento!=null &&
              this.fechaNacimiento.equals(other.getFechaNacimiento()))) &&
            ((this.fechaUltimaActualizacion==null && other.getFechaUltimaActualizacion()==null) || 
             (this.fechaUltimaActualizacion!=null &&
              this.fechaUltimaActualizacion.equals(other.getFechaUltimaActualizacion()))) &&
            ((this.idEmpleado==null && other.getIdEmpleado()==null) || 
             (this.idEmpleado!=null &&
              this.idEmpleado.equals(other.getIdEmpleado()))) &&
            this.interno == other.getInterno() &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.nombreUsuario==null && other.getNombreUsuario()==null) || 
             (this.nombreUsuario!=null &&
              this.nombreUsuario.equals(other.getNombreUsuario()))) &&
            ((this.piso==null && other.getPiso()==null) || 
             (this.piso!=null &&
              this.piso.equals(other.getPiso()))) &&
            this.prefijo == other.getPrefijo() &&
            ((this.puestosDeTrabajo==null && other.getPuestosDeTrabajo()==null) || 
             (this.puestosDeTrabajo!=null &&
              this.puestosDeTrabajo.equals(other.getPuestosDeTrabajo()))) &&
            ((this.responsables==null && other.getResponsables()==null) || 
             (this.responsables!=null &&
              java.util.Arrays.equals(this.responsables, other.getResponsables()))) &&
            ((this.telefonoPersonal==null && other.getTelefonoPersonal()==null) || 
             (this.telefonoPersonal!=null &&
              this.telefonoPersonal.equals(other.getTelefonoPersonal()))) &&
            ((this.descripcionFilial==null && other.getDescripcionFilial()==null) || 
             (this.descripcionFilial!=null &&
              this.descripcionFilial.equals(other.getDescripcionFilial()))) &&
            ((this.descripionCAP==null && other.getDescripionCAP()==null) || 
             (this.descripionCAP!=null &&
              this.descripionCAP.equals(other.getDescripionCAP()))) &&
            ((this.direccionCAP==null && other.getDireccionCAP()==null) || 
             (this.direccionCAP!=null &&
              this.direccionCAP.equals(other.getDireccionCAP()))) &&
            ((this.direccionFilial==null && other.getDireccionFilial()==null) || 
             (this.direccionFilial!=null &&
              this.direccionFilial.equals(other.getDireccionFilial())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getNombres() != null) {
            _hashCode += getNombres().hashCode();
        }
        if (getApellidos() != null) {
            _hashCode += getApellidos().hashCode();
        }
        _hashCode += getBaja();
        if (getSexo() != null) {
            _hashCode += getSexo().hashCode();
        }
        _hashCode += getCodFilial();
        _hashCode += getCodCAP();
        if (getAfectacion() != null) {
            _hashCode += getAfectacion().hashCode();
        }
        if (getCelularLaboral() != null) {
            _hashCode += getCelularLaboral().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getFechaNacimiento() != null) {
            _hashCode += getFechaNacimiento().hashCode();
        }
        if (getFechaUltimaActualizacion() != null) {
            _hashCode += getFechaUltimaActualizacion().hashCode();
        }
        if (getIdEmpleado() != null) {
            _hashCode += getIdEmpleado().hashCode();
        }
        _hashCode += getInterno();
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getNombreUsuario() != null) {
            _hashCode += getNombreUsuario().hashCode();
        }
        if (getPiso() != null) {
            _hashCode += getPiso().hashCode();
        }
        _hashCode += getPrefijo();
        if (getPuestosDeTrabajo() != null) {
            _hashCode += getPuestosDeTrabajo().hashCode();
        }
        if (getResponsables() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getResponsables());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getResponsables(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTelefonoPersonal() != null) {
            _hashCode += getTelefonoPersonal().hashCode();
        }
        if (getDescripcionFilial() != null) {
            _hashCode += getDescripcionFilial().hashCode();
        }
        if (getDescripionCAP() != null) {
            _hashCode += getDescripionCAP().hashCode();
        }
        if (getDireccionCAP() != null) {
            _hashCode += getDireccionCAP().hashCode();
        }
        if (getDireccionFilial() != null) {
            _hashCode += getDireccionFilial().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Empleado.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "empleado"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombres");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "nombres"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apellidos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "apellidos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("baja");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "baja"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sexo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "sexo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codFilial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "CodFilial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codCAP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "CodCAP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("afectacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "afectacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("celularLaboral");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "celularLaboral"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaNacimiento");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "fechaNacimiento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaUltimaActualizacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "fechaUltimaActualizacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEmpleado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "idEmpleado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "interno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "nombreUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("piso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "piso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prefijo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "prefijo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("puestosDeTrabajo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "puestosDeTrabajo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "searchResult"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responsables");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "responsables"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "responsable"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefonoPersonal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "telefonoPersonal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcionFilial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "descripcionFilial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripionCAP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "descripionCAP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("direccionCAP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "direccionCAP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("direccionFilial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "direccionFilial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
