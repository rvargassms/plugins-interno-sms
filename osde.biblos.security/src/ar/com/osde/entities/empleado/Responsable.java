/**
 * Responsable.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.entities.empleado;

public class Responsable  implements java.io.Serializable {
    private int idresponsable;

    private java.lang.String nombre;

    private java.lang.String nombrezona;

    private int zona;

    public Responsable() {
    }

    public Responsable(
           int idresponsable,
           java.lang.String nombre,
           java.lang.String nombrezona,
           int zona) {
           this.idresponsable = idresponsable;
           this.nombre = nombre;
           this.nombrezona = nombrezona;
           this.zona = zona;
    }


    /**
     * Gets the idresponsable value for this Responsable.
     * 
     * @return idresponsable
     */
    public int getIdresponsable() {
        return idresponsable;
    }


    /**
     * Sets the idresponsable value for this Responsable.
     * 
     * @param idresponsable
     */
    public void setIdresponsable(int idresponsable) {
        this.idresponsable = idresponsable;
    }


    /**
     * Gets the nombre value for this Responsable.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this Responsable.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the nombrezona value for this Responsable.
     * 
     * @return nombrezona
     */
    public java.lang.String getNombrezona() {
        return nombrezona;
    }


    /**
     * Sets the nombrezona value for this Responsable.
     * 
     * @param nombrezona
     */
    public void setNombrezona(java.lang.String nombrezona) {
        this.nombrezona = nombrezona;
    }


    /**
     * Gets the zona value for this Responsable.
     * 
     * @return zona
     */
    public int getZona() {
        return zona;
    }


    /**
     * Sets the zona value for this Responsable.
     * 
     * @param zona
     */
    public void setZona(int zona) {
        this.zona = zona;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Responsable)) return false;
        Responsable other = (Responsable) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idresponsable == other.getIdresponsable() &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.nombrezona==null && other.getNombrezona()==null) || 
             (this.nombrezona!=null &&
              this.nombrezona.equals(other.getNombrezona()))) &&
            this.zona == other.getZona();
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
        _hashCode += getIdresponsable();
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getNombrezona() != null) {
            _hashCode += getNombrezona().hashCode();
        }
        _hashCode += getZona();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Responsable.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "responsable"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idresponsable");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "idresponsable"));
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
        elemField.setFieldName("nombrezona");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "nombrezona"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zona");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "zona"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
