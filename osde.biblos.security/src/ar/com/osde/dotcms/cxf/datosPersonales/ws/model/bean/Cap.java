/**
 * Cap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean;

public class Cap  implements java.io.Serializable {
    private java.lang.String baja;

    private ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Cap capReal;

    private java.lang.String codigo;

    private java.lang.String descripcion;

    private ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Edificio edificio;

    private ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Empresa empresa;

    private java.lang.Boolean esReal;

    private ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Filial filial;

    private ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Filial filialReal;

    private java.lang.Integer id;

    public Cap() {
    }

    public Cap(
           java.lang.String baja,
           ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Cap capReal,
           java.lang.String codigo,
           java.lang.String descripcion,
           ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Edificio edificio,
           ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Empresa empresa,
           java.lang.Boolean esReal,
           ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Filial filial,
           ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Filial filialReal,
           java.lang.Integer id) {
           this.baja = baja;
           this.capReal = capReal;
           this.codigo = codigo;
           this.descripcion = descripcion;
           this.edificio = edificio;
           this.empresa = empresa;
           this.esReal = esReal;
           this.filial = filial;
           this.filialReal = filialReal;
           this.id = id;
    }


    /**
     * Gets the baja value for this Cap.
     * 
     * @return baja
     */
    public java.lang.String getBaja() {
        return baja;
    }


    /**
     * Sets the baja value for this Cap.
     * 
     * @param baja
     */
    public void setBaja(java.lang.String baja) {
        this.baja = baja;
    }


    /**
     * Gets the capReal value for this Cap.
     * 
     * @return capReal
     */
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Cap getCapReal() {
        return capReal;
    }


    /**
     * Sets the capReal value for this Cap.
     * 
     * @param capReal
     */
    public void setCapReal(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Cap capReal) {
        this.capReal = capReal;
    }


    /**
     * Gets the codigo value for this Cap.
     * 
     * @return codigo
     */
    public java.lang.String getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this Cap.
     * 
     * @param codigo
     */
    public void setCodigo(java.lang.String codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the descripcion value for this Cap.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this Cap.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the edificio value for this Cap.
     * 
     * @return edificio
     */
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Edificio getEdificio() {
        return edificio;
    }


    /**
     * Sets the edificio value for this Cap.
     * 
     * @param edificio
     */
    public void setEdificio(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Edificio edificio) {
        this.edificio = edificio;
    }


    /**
     * Gets the empresa value for this Cap.
     * 
     * @return empresa
     */
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Empresa getEmpresa() {
        return empresa;
    }


    /**
     * Sets the empresa value for this Cap.
     * 
     * @param empresa
     */
    public void setEmpresa(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Empresa empresa) {
        this.empresa = empresa;
    }


    /**
     * Gets the esReal value for this Cap.
     * 
     * @return esReal
     */
    public java.lang.Boolean getEsReal() {
        return esReal;
    }


    /**
     * Sets the esReal value for this Cap.
     * 
     * @param esReal
     */
    public void setEsReal(java.lang.Boolean esReal) {
        this.esReal = esReal;
    }


    /**
     * Gets the filial value for this Cap.
     * 
     * @return filial
     */
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Filial getFilial() {
        return filial;
    }


    /**
     * Sets the filial value for this Cap.
     * 
     * @param filial
     */
    public void setFilial(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Filial filial) {
        this.filial = filial;
    }


    /**
     * Gets the filialReal value for this Cap.
     * 
     * @return filialReal
     */
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Filial getFilialReal() {
        return filialReal;
    }


    /**
     * Sets the filialReal value for this Cap.
     * 
     * @param filialReal
     */
    public void setFilialReal(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Filial filialReal) {
        this.filialReal = filialReal;
    }


    /**
     * Gets the id value for this Cap.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this Cap.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Cap)) return false;
        Cap other = (Cap) obj;
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
            ((this.capReal==null && other.getCapReal()==null) || 
             (this.capReal!=null &&
              this.capReal.equals(other.getCapReal()))) &&
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
            ((this.esReal==null && other.getEsReal()==null) || 
             (this.esReal!=null &&
              this.esReal.equals(other.getEsReal()))) &&
            ((this.filial==null && other.getFilial()==null) || 
             (this.filial!=null &&
              this.filial.equals(other.getFilial()))) &&
            ((this.filialReal==null && other.getFilialReal()==null) || 
             (this.filialReal!=null &&
              this.filialReal.equals(other.getFilialReal()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId())));
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
        if (getCapReal() != null) {
            _hashCode += getCapReal().hashCode();
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
        if (getEsReal() != null) {
            _hashCode += getEsReal().hashCode();
        }
        if (getFilial() != null) {
            _hashCode += getFilial().hashCode();
        }
        if (getFilialReal() != null) {
            _hashCode += getFilialReal().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Cap.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Cap"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("baja");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "baja"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("capReal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "capReal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Cap"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
        elemField.setFieldName("esReal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "esReal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setFieldName("filialReal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "filialReal"));
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
