/**
 * Filial.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean;

public class Filial  implements java.io.Serializable {
    private java.lang.String baja;

    private ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Cap[] caps;

    private java.lang.String codigo;

    private java.lang.String descripcion;

    private ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Edificio edificio;

    private ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Empresa empresa;

    private java.lang.Integer id;

    private java.lang.String prefijo;

    public Filial() {
    }

    public Filial(
           java.lang.String baja,
           ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Cap[] caps,
           java.lang.String codigo,
           java.lang.String descripcion,
           ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Edificio edificio,
           ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Empresa empresa,
           java.lang.Integer id,
           java.lang.String prefijo) {
           this.baja = baja;
           this.caps = caps;
           this.codigo = codigo;
           this.descripcion = descripcion;
           this.edificio = edificio;
           this.empresa = empresa;
           this.id = id;
           this.prefijo = prefijo;
    }


    /**
     * Gets the baja value for this Filial.
     * 
     * @return baja
     */
    public java.lang.String getBaja() {
        return baja;
    }


    /**
     * Sets the baja value for this Filial.
     * 
     * @param baja
     */
    public void setBaja(java.lang.String baja) {
        this.baja = baja;
    }


    /**
     * Gets the caps value for this Filial.
     * 
     * @return caps
     */
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Cap[] getCaps() {
        return caps;
    }


    /**
     * Sets the caps value for this Filial.
     * 
     * @param caps
     */
    public void setCaps(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Cap[] caps) {
        this.caps = caps;
    }


    /**
     * Gets the codigo value for this Filial.
     * 
     * @return codigo
     */
    public java.lang.String getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this Filial.
     * 
     * @param codigo
     */
    public void setCodigo(java.lang.String codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the descripcion value for this Filial.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this Filial.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the edificio value for this Filial.
     * 
     * @return edificio
     */
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Edificio getEdificio() {
        return edificio;
    }


    /**
     * Sets the edificio value for this Filial.
     * 
     * @param edificio
     */
    public void setEdificio(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Edificio edificio) {
        this.edificio = edificio;
    }


    /**
     * Gets the empresa value for this Filial.
     * 
     * @return empresa
     */
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Empresa getEmpresa() {
        return empresa;
    }


    /**
     * Sets the empresa value for this Filial.
     * 
     * @param empresa
     */
    public void setEmpresa(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Empresa empresa) {
        this.empresa = empresa;
    }


    /**
     * Gets the id value for this Filial.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this Filial.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the prefijo value for this Filial.
     * 
     * @return prefijo
     */
    public java.lang.String getPrefijo() {
        return prefijo;
    }


    /**
     * Sets the prefijo value for this Filial.
     * 
     * @param prefijo
     */
    public void setPrefijo(java.lang.String prefijo) {
        this.prefijo = prefijo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Filial)) return false;
        Filial other = (Filial) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.baja==null && other.getBaja()==null) || 
             (this.baja!=null &&
              this.baja.equals(other.getBaja()))) &&
            ((this.caps==null && other.getCaps()==null) || 
             (this.caps!=null &&
              java.util.Arrays.equals(this.caps, other.getCaps()))) &&
            ((this.codigo==null && other.getCodigo()==null) || 
             (this.codigo!=null &&
              this.codigo.equals(other.getCodigo()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.edificio==null && other.getEdificio()==null) || 
             (this.edificio!=null &&
              this.edificio.equals(other.getEdificio()))) &&
            ((this.empresa==null && other.getEmpresa()==null) || 
             (this.empresa!=null &&
              this.empresa.equals(other.getEmpresa()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.prefijo==null && other.getPrefijo()==null) || 
             (this.prefijo!=null &&
              this.prefijo.equals(other.getPrefijo())));
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
        if (getBaja() != null) {
            _hashCode += getBaja().hashCode();
        }
        if (getCaps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCaps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCaps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCodigo() != null) {
            _hashCode += getCodigo().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getEdificio() != null) {
            _hashCode += getEdificio().hashCode();
        }
        if (getEmpresa() != null) {
            _hashCode += getEmpresa().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getPrefijo() != null) {
            _hashCode += getPrefijo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Filial.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Filial"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("baja");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "baja"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("caps");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "caps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Cap"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Cap"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "codigo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("edificio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "edificio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Edificio"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("empresa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "empresa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Empresa"));
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
        elemField.setFieldName("prefijo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "prefijo"));
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
