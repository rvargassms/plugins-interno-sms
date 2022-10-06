/**
 * Usuario.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean;

public class Usuario  implements java.io.Serializable {
    private java.lang.String apellidos;

    private java.lang.Boolean baja;

    private ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Cap cap;

    private java.lang.String email;

    private ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Filial filial;

    private java.lang.Integer id;

    private java.lang.String nombres;

    private java.lang.String piso;

    private ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Puesto[] puestos;

    private java.lang.String telefono;

    private java.lang.String telefonoCelular;

    private java.lang.String telefonoInterno;

    private java.lang.String telefonoOtro;

    private java.lang.Boolean ubicacionActual;

    private java.lang.String username; 

    public Usuario() {
    }

    public Usuario(
           java.lang.String apellidos,
           java.lang.Boolean baja,
           ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Cap cap,
           java.lang.String email,
           ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Filial filial,
           java.lang.Integer id,
           java.lang.String nombres,
           java.lang.String piso,
           ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Puesto[] puestos,
           java.lang.String telefono,
           java.lang.String telefonoCelular,
           java.lang.String telefonoInterno,
           java.lang.String telefonoOtro,
           java.lang.Boolean ubicacionActual,
           java.lang.String username) {
           this.apellidos = apellidos;
           this.baja = baja;
           this.cap = cap;
           this.email = email;
           this.filial = filial;
           this.id = id;
           this.nombres = nombres;
           this.piso = piso;
           this.puestos = puestos;
           this.telefono = telefono;
           this.telefonoCelular = telefonoCelular;
           this.telefonoInterno = telefonoInterno;
           this.telefonoOtro = telefonoOtro;
           this.ubicacionActual = ubicacionActual;
           this.username = username;
    }


    /**
     * Gets the apellidos value for this Usuario.
     * 
     * @return apellidos
     */
    public java.lang.String getApellidos() {
        return apellidos;
    }


    /**
     * Sets the apellidos value for this Usuario.
     * 
     * @param apellidos
     */
    public void setApellidos(java.lang.String apellidos) {
        this.apellidos = apellidos;
    }


    /**
     * Gets the baja value for this Usuario.
     * 
     * @return baja
     */
    public java.lang.Boolean getBaja() {
        return baja;
    }


    /**
     * Sets the baja value for this Usuario.
     * 
     * @param baja
     */
    public void setBaja(java.lang.Boolean baja) {
        this.baja = baja;
    }


    /**
     * Gets the cap value for this Usuario.
     * 
     * @return cap
     */
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Cap getCap() {
        return cap;
    }


    /**
     * Sets the cap value for this Usuario.
     * 
     * @param cap
     */
    public void setCap(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Cap cap) {
        this.cap = cap;
    }


    /**
     * Gets the email value for this Usuario.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this Usuario.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the filial value for this Usuario.
     * 
     * @return filial
     */
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Filial getFilial() {
        return filial;
    }


    /**
     * Sets the filial value for this Usuario.
     * 
     * @param filial
     */
    public void setFilial(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Filial filial) {
        this.filial = filial;
    }


    /**
     * Gets the id value for this Usuario.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this Usuario.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the nombres value for this Usuario.
     * 
     * @return nombres
     */
    public java.lang.String getNombres() {
        return nombres;
    }


    /**
     * Sets the nombres value for this Usuario.
     * 
     * @param nombres
     */
    public void setNombres(java.lang.String nombres) {
        this.nombres = nombres;
    }


    /**
     * Gets the piso value for this Usuario.
     * 
     * @return piso
     */
    public java.lang.String getPiso() {
        return piso;
    }


    /**
     * Sets the piso value for this Usuario.
     * 
     * @param piso
     */
    public void setPiso(java.lang.String piso) {
        this.piso = piso;
    }


    /**
     * Gets the puestos value for this Usuario.
     * 
     * @return puestos
     */
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Puesto[] getPuestos() {
        return puestos;
    }


    /**
     * Sets the puestos value for this Usuario.
     * 
     * @param puestos
     */
    public void setPuestos(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Puesto[] puestos) {
        this.puestos = puestos;
    }


    /**
     * Gets the telefono value for this Usuario.
     * 
     * @return telefono
     */
    public java.lang.String getTelefono() {
        return telefono;
    }


    /**
     * Sets the telefono value for this Usuario.
     * 
     * @param telefono
     */
    public void setTelefono(java.lang.String telefono) {
        this.telefono = telefono;
    }


    /**
     * Gets the telefonoCelular value for this Usuario.
     * 
     * @return telefonoCelular
     */
    public java.lang.String getTelefonoCelular() {
        return telefonoCelular;
    }


    /**
     * Sets the telefonoCelular value for this Usuario.
     * 
     * @param telefonoCelular
     */
    public void setTelefonoCelular(java.lang.String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }


    /**
     * Gets the telefonoInterno value for this Usuario.
     * 
     * @return telefonoInterno
     */
    public java.lang.String getTelefonoInterno() {
        return telefonoInterno;
    }


    /**
     * Sets the telefonoInterno value for this Usuario.
     * 
     * @param telefonoInterno
     */
    public void setTelefonoInterno(java.lang.String telefonoInterno) {
        this.telefonoInterno = telefonoInterno;
    }


    /**
     * Gets the telefonoOtro value for this Usuario.
     * 
     * @return telefonoOtro
     */
    public java.lang.String getTelefonoOtro() {
        return telefonoOtro;
    }


    /**
     * Sets the telefonoOtro value for this Usuario.
     * 
     * @param telefonoOtro
     */
    public void setTelefonoOtro(java.lang.String telefonoOtro) {
        this.telefonoOtro = telefonoOtro;
    }


    /**
     * Gets the ubicacionActual value for this Usuario.
     * 
     * @return ubicacionActual
     */
    public java.lang.Boolean getUbicacionActual() {
        return ubicacionActual;
    }


    /**
     * Sets the ubicacionActual value for this Usuario.
     * 
     * @param ubicacionActual
     */
    public void setUbicacionActual(java.lang.Boolean ubicacionActual) {
        this.ubicacionActual = ubicacionActual;
    }


    /**
     * Gets the username value for this Usuario.
     * 
     * @return username
     */
    public java.lang.String getUsername() {
        return username;
    }


    /**
     * Sets the username value for this Usuario.
     * 
     * @param username
     */
    public void setUsername(java.lang.String username) {
        this.username = username;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Usuario)) return false;
        Usuario other = (Usuario) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.apellidos==null && other.getApellidos()==null) || 
             (this.apellidos!=null &&
              this.apellidos.equals(other.getApellidos()))) &&
            ((this.baja==null && other.getBaja()==null) || 
             (this.baja!=null &&
              this.baja.equals(other.getBaja()))) &&
            ((this.cap==null && other.getCap()==null) || 
             (this.cap!=null &&
              this.cap.equals(other.getCap()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.filial==null && other.getFilial()==null) || 
             (this.filial!=null &&
              this.filial.equals(other.getFilial()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.nombres==null && other.getNombres()==null) || 
             (this.nombres!=null &&
              this.nombres.equals(other.getNombres()))) &&
            ((this.piso==null && other.getPiso()==null) || 
             (this.piso!=null &&
              this.piso.equals(other.getPiso()))) &&
            ((this.puestos==null && other.getPuestos()==null) || 
             (this.puestos!=null &&
              java.util.Arrays.equals(this.puestos, other.getPuestos()))) &&
            ((this.telefono==null && other.getTelefono()==null) || 
             (this.telefono!=null &&
              this.telefono.equals(other.getTelefono()))) &&
            ((this.telefonoCelular==null && other.getTelefonoCelular()==null) || 
             (this.telefonoCelular!=null &&
              this.telefonoCelular.equals(other.getTelefonoCelular()))) &&
            ((this.telefonoInterno==null && other.getTelefonoInterno()==null) || 
             (this.telefonoInterno!=null &&
              this.telefonoInterno.equals(other.getTelefonoInterno()))) &&
            ((this.telefonoOtro==null && other.getTelefonoOtro()==null) || 
             (this.telefonoOtro!=null &&
              this.telefonoOtro.equals(other.getTelefonoOtro()))) &&
            ((this.ubicacionActual==null && other.getUbicacionActual()==null) || 
             (this.ubicacionActual!=null &&
              this.ubicacionActual.equals(other.getUbicacionActual()))) &&
            ((this.username==null && other.getUsername()==null) || 
             (this.username!=null &&
              this.username.equals(other.getUsername())));
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
        if (getApellidos() != null) {
            _hashCode += getApellidos().hashCode();
        }
        if (getBaja() != null) {
            _hashCode += getBaja().hashCode();
        }
        if (getCap() != null) {
            _hashCode += getCap().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getFilial() != null) {
            _hashCode += getFilial().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getNombres() != null) {
            _hashCode += getNombres().hashCode();
        }
        if (getPiso() != null) {
            _hashCode += getPiso().hashCode();
        }
        if (getPuestos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPuestos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPuestos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTelefono() != null) {
            _hashCode += getTelefono().hashCode();
        }
        if (getTelefonoCelular() != null) {
            _hashCode += getTelefonoCelular().hashCode();
        }
        if (getTelefonoInterno() != null) {
            _hashCode += getTelefonoInterno().hashCode();
        }
        if (getTelefonoOtro() != null) {
            _hashCode += getTelefonoOtro().hashCode();
        }
        if (getUbicacionActual() != null) {
            _hashCode += getUbicacionActual().hashCode();
        }
        if (getUsername() != null) {
            _hashCode += getUsername().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Usuario.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Usuario"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apellidos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "apellidos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("baja");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "baja"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cap");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "cap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Cap"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "filial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Filial"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombres");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "nombres"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("piso");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "piso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("puestos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "puestos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Puesto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Puesto"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefono");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "telefono"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefonoCelular");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "telefonoCelular"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefonoInterno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "telefonoInterno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefonoOtro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "telefonoOtro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ubicacionActual");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "ubicacionActual"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("username");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "username"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
