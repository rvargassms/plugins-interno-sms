/**
 * ObtenerPermisosConEMailResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.services.administracion.empleado;

public class ObtenerPermisosConEMailResponse  implements java.io.Serializable {
    private java.lang.String obtenerPermisosConEMailResponse;

    public ObtenerPermisosConEMailResponse() {
    }

    public ObtenerPermisosConEMailResponse(
           java.lang.String obtenerPermisosConEMailResponse) {
           this.obtenerPermisosConEMailResponse = obtenerPermisosConEMailResponse;
    }


    /**
     * Gets the obtenerPermisosConEMailResponse value for this ObtenerPermisosConEMailResponse.
     * 
     * @return obtenerPermisosConEMailResponse
     */
    public java.lang.String getObtenerPermisosConEMailResponse() {
        return obtenerPermisosConEMailResponse;
    }


    /**
     * Sets the obtenerPermisosConEMailResponse value for this ObtenerPermisosConEMailResponse.
     * 
     * @param obtenerPermisosConEMailResponse
     */
    public void setObtenerPermisosConEMailResponse(java.lang.String obtenerPermisosConEMailResponse) {
        this.obtenerPermisosConEMailResponse = obtenerPermisosConEMailResponse;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObtenerPermisosConEMailResponse)) return false;
        ObtenerPermisosConEMailResponse other = (ObtenerPermisosConEMailResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.obtenerPermisosConEMailResponse==null && other.getObtenerPermisosConEMailResponse()==null) || 
             (this.obtenerPermisosConEMailResponse!=null &&
              this.obtenerPermisosConEMailResponse.equals(other.getObtenerPermisosConEMailResponse())));
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
        if (getObtenerPermisosConEMailResponse() != null) {
            _hashCode += getObtenerPermisosConEMailResponse().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObtenerPermisosConEMailResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "ObtenerPermisosConEMailResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obtenerPermisosConEMailResponse");
        elemField.setXmlName(new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "ObtenerPermisosConEMailResponse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
