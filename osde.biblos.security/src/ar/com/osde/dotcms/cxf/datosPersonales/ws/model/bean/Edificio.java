/**
 * Edificio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean;

public class Edificio  implements java.io.Serializable {
    private ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Cap cap;

    private ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Direccion direccion;

    private java.lang.String email;

    private ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Filial filial;

    private java.lang.String horario;

    private java.lang.Integer id;

    private java.lang.String nombre;

    private java.lang.Boolean publicaInternet;

    private java.lang.String telefono;

    private java.lang.String telefonoDirecto;

    public Edificio() {
    }

    public Edificio(
           ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Cap cap,
           ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Direccion direccion,
           java.lang.String email,
           ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Filial filial,
           java.lang.String horario,
           java.lang.Integer id,
           java.lang.String nombre,
           java.lang.Boolean publicaInternet,
           java.lang.String telefono,
           java.lang.String telefonoDirecto) {
           this.cap = cap;
           this.direccion = direccion;
           this.email = email;
           this.filial = filial;
           this.horario = horario;
           this.id = id;
           this.nombre = nombre;
           this.publicaInternet = publicaInternet;
           this.telefono = telefono;
           this.telefonoDirecto = telefonoDirecto;
    }


    /**
     * Gets the cap value for this Edificio.
     * 
     * @return cap
     */
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Cap getCap() {
        return cap;
    }


    /**
     * Sets the cap value for this Edificio.
     * 
     * @param cap
     */
    public void setCap(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Cap cap) {
        this.cap = cap;
    }


    /**
     * Gets the direccion value for this Edificio.
     * 
     * @return direccion
     */
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Direccion getDireccion() {
        return direccion;
    }


    /**
     * Sets the direccion value for this Edificio.
     * 
     * @param direccion
     */
    public void setDireccion(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Direccion direccion) {
        this.direccion = direccion;
    }


    /**
     * Gets the email value for this Edificio.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this Edificio.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the filial value for this Edificio.
     * 
     * @return filial
     */
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Filial getFilial() {
        return filial;
    }


    /**
     * Sets the filial value for this Edificio.
     * 
     * @param filial
     */
    public void setFilial(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Filial filial) {
        this.filial = filial;
    }


    /**
     * Gets the horario value for this Edificio.
     * 
     * @return horario
     */
    public java.lang.String getHorario() {
        return horario;
    }


    /**
     * Sets the horario value for this Edificio.
     * 
     * @param horario
     */
    public void setHorario(java.lang.String horario) {
        this.horario = horario;
    }


    /**
     * Gets the id value for this Edificio.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this Edificio.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the nombre value for this Edificio.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this Edificio.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the publicaInternet value for this Edificio.
     * 
     * @return publicaInternet
     */
    public java.lang.Boolean getPublicaInternet() {
        return publicaInternet;
    }


    /**
     * Sets the publicaInternet value for this Edificio.
     * 
     * @param publicaInternet
     */
    public void setPublicaInternet(java.lang.Boolean publicaInternet) {
        this.publicaInternet = publicaInternet;
    }


    /**
     * Gets the telefono value for this Edificio.
     * 
     * @return telefono
     */
    public java.lang.String getTelefono() {
        return telefono;
    }


    /**
     * Sets the telefono value for this Edificio.
     * 
     * @param telefono
     */
    public void setTelefono(java.lang.String telefono) {
        this.telefono = telefono;
    }


    /**
     * Gets the telefonoDirecto value for this Edificio.
     * 
     * @return telefonoDirecto
     */
    public java.lang.String getTelefonoDirecto() {
        return telefonoDirecto;
    }


    /**
     * Sets the telefonoDirecto value for this Edificio.
     * 
     * @param telefonoDirecto
     */
    public void setTelefonoDirecto(java.lang.String telefonoDirecto) {
        this.telefonoDirecto = telefonoDirecto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Edificio)) return false;
        Edificio other = (Edificio) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cap==null && other.getCap()==null) || 
             (this.cap!=null &&
              this.cap.equals(other.getCap()))) &&
            ((this.direccion==null && other.getDireccion()==null) || 
             (this.direccion!=null &&
              this.direccion.equals(other.getDireccion()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.filial==null && other.getFilial()==null) || 
             (this.filial!=null &&
              this.filial.equals(other.getFilial()))) &&
            ((this.horario==null && other.getHorario()==null) || 
             (this.horario!=null &&
              this.horario.equals(other.getHorario()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.publicaInternet==null && other.getPublicaInternet()==null) || 
             (this.publicaInternet!=null &&
              this.publicaInternet.equals(other.getPublicaInternet()))) &&
            ((this.telefono==null && other.getTelefono()==null) || 
             (this.telefono!=null &&
              this.telefono.equals(other.getTelefono()))) &&
            ((this.telefonoDirecto==null && other.getTelefonoDirecto()==null) || 
             (this.telefonoDirecto!=null &&
              this.telefonoDirecto.equals(other.getTelefonoDirecto())));
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
        if (getCap() != null) {
            _hashCode += getCap().hashCode();
        }
        if (getDireccion() != null) {
            _hashCode += getDireccion().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getFilial() != null) {
            _hashCode += getFilial().hashCode();
        }
        if (getHorario() != null) {
            _hashCode += getHorario().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getPublicaInternet() != null) {
            _hashCode += getPublicaInternet().hashCode();
        }
        if (getTelefono() != null) {
            _hashCode += getTelefono().hashCode();
        }
        if (getTelefonoDirecto() != null) {
            _hashCode += getTelefonoDirecto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Edificio.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Edificio"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cap");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "cap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Cap"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("direccion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "direccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Direccion"));
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
        elemField.setFieldName("horario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "horario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publicaInternet");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "publicaInternet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefono");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "telefono"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefonoDirecto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "telefonoDirecto"));
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
