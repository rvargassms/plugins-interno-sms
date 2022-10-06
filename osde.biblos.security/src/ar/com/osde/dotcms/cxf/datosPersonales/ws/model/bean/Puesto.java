/**
 * Puesto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean;

public class Puesto  implements java.io.Serializable {
    private ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Cap cap;

    private java.lang.String codigo;

    private java.lang.String descripcion;

    private ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Filial filial;

    private java.lang.Integer puestoNro;

    private java.lang.Integer uniNro;

    public Puesto() {
    }

    public Puesto(
           ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Cap cap,
           java.lang.String codigo,
           java.lang.String descripcion,
           ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Filial filial,
           java.lang.Integer puestoNro,
           java.lang.Integer uniNro) {
           this.cap = cap;
           this.codigo = codigo;
           this.descripcion = descripcion;
           this.filial = filial;
           this.puestoNro = puestoNro;
           this.uniNro = uniNro;
    }


    /**
     * Gets the cap value for this Puesto.
     * 
     * @return cap
     */
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Cap getCap() {
        return cap;
    }


    /**
     * Sets the cap value for this Puesto.
     * 
     * @param cap
     */
    public void setCap(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Cap cap) {
        this.cap = cap;
    }


    /**
     * Gets the codigo value for this Puesto.
     * 
     * @return codigo
     */
    public java.lang.String getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this Puesto.
     * 
     * @param codigo
     */
    public void setCodigo(java.lang.String codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the descripcion value for this Puesto.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this Puesto.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the filial value for this Puesto.
     * 
     * @return filial
     */
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Filial getFilial() {
        return filial;
    }


    /**
     * Sets the filial value for this Puesto.
     * 
     * @param filial
     */
    public void setFilial(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Filial filial) {
        this.filial = filial;
    }


    /**
     * Gets the puestoNro value for this Puesto.
     * 
     * @return puestoNro
     */
    public java.lang.Integer getPuestoNro() {
        return puestoNro;
    }


    /**
     * Sets the puestoNro value for this Puesto.
     * 
     * @param puestoNro
     */
    public void setPuestoNro(java.lang.Integer puestoNro) {
        this.puestoNro = puestoNro;
    }


    /**
     * Gets the uniNro value for this Puesto.
     * 
     * @return uniNro
     */
    public java.lang.Integer getUniNro() {
        return uniNro;
    }


    /**
     * Sets the uniNro value for this Puesto.
     * 
     * @param uniNro
     */
    public void setUniNro(java.lang.Integer uniNro) {
        this.uniNro = uniNro;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Puesto)) return false;
        Puesto other = (Puesto) obj;
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
            ((this.codigo==null && other.getCodigo()==null) || 
             (this.codigo!=null &&
              this.codigo.equals(other.getCodigo()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.filial==null && other.getFilial()==null) || 
             (this.filial!=null &&
              this.filial.equals(other.getFilial()))) &&
            ((this.puestoNro==null && other.getPuestoNro()==null) || 
             (this.puestoNro!=null &&
              this.puestoNro.equals(other.getPuestoNro()))) &&
            ((this.uniNro==null && other.getUniNro()==null) || 
             (this.uniNro!=null &&
              this.uniNro.equals(other.getUniNro())));
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
        if (getCodigo() != null) {
            _hashCode += getCodigo().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getFilial() != null) {
            _hashCode += getFilial().hashCode();
        }
        if (getPuestoNro() != null) {
            _hashCode += getPuestoNro().hashCode();
        }
        if (getUniNro() != null) {
            _hashCode += getUniNro().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Puesto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Puesto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cap");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "cap"));
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
        elemField.setFieldName("filial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "filial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Filial"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("puestoNro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "puestoNro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uniNro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "uniNro"));
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
