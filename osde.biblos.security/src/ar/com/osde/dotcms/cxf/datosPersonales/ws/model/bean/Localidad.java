/**
 * Localidad.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean;

public class Localidad  implements java.io.Serializable {
    private java.lang.String ddn;

    private java.lang.Integer id;

    private java.lang.String nombre;

    private ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Provincia provincia;

    public Localidad() {
    }

    public Localidad(
           java.lang.String ddn,
           java.lang.Integer id,
           java.lang.String nombre,
           ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Provincia provincia) {
           this.ddn = ddn;
           this.id = id;
           this.nombre = nombre;
           this.provincia = provincia;
    }


    /**
     * Gets the ddn value for this Localidad.
     * 
     * @return ddn
     */
    public java.lang.String getDdn() {
        return ddn;
    }


    /**
     * Sets the ddn value for this Localidad.
     * 
     * @param ddn
     */
    public void setDdn(java.lang.String ddn) {
        this.ddn = ddn;
    }


    /**
     * Gets the id value for this Localidad.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this Localidad.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the nombre value for this Localidad.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this Localidad.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the provincia value for this Localidad.
     * 
     * @return provincia
     */
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Provincia getProvincia() {
        return provincia;
    }


    /**
     * Sets the provincia value for this Localidad.
     * 
     * @param provincia
     */
    public void setProvincia(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Provincia provincia) {
        this.provincia = provincia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Localidad)) return false;
        Localidad other = (Localidad) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ddn==null && other.getDdn()==null) || 
             (this.ddn!=null &&
              this.ddn.equals(other.getDdn()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.provincia==null && other.getProvincia()==null) || 
             (this.provincia!=null &&
              this.provincia.equals(other.getProvincia())));
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
        if (getDdn() != null) {
            _hashCode += getDdn().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getProvincia() != null) {
            _hashCode += getProvincia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Localidad.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Localidad"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ddn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "ddn"));
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
        elemField.setFieldName("provincia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "provincia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Provincia"));
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
