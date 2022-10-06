/**
 * EmpleadoFilter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.entities.empleado;

public class EmpleadoFilter  implements java.io.Serializable {
    private int idCap;

    private int idFilial;

    public EmpleadoFilter() {
    }

    public EmpleadoFilter(
           int idCap,
           int idFilial) {
           this.idCap = idCap;
           this.idFilial = idFilial;
    }


    /**
     * Gets the idCap value for this EmpleadoFilter.
     * 
     * @return idCap
     */
    public int getIdCap() {
        return idCap;
    }


    /**
     * Sets the idCap value for this EmpleadoFilter.
     * 
     * @param idCap
     */
    public void setIdCap(int idCap) {
        this.idCap = idCap;
    }


    /**
     * Gets the idFilial value for this EmpleadoFilter.
     * 
     * @return idFilial
     */
    public int getIdFilial() {
        return idFilial;
    }


    /**
     * Sets the idFilial value for this EmpleadoFilter.
     * 
     * @param idFilial
     */
    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EmpleadoFilter)) return false;
        EmpleadoFilter other = (EmpleadoFilter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idCap == other.getIdCap() &&
            this.idFilial == other.getIdFilial();
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
        _hashCode += getIdCap();
        _hashCode += getIdFilial();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EmpleadoFilter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "empleadoFilter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCap");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "idCap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idFilial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "idFilial"));
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
