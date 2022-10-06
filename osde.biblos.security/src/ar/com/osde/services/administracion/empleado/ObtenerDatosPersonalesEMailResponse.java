/**
 * ObtenerDatosPersonalesEMailResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.services.administracion.empleado;

public class ObtenerDatosPersonalesEMailResponse  implements java.io.Serializable {
    private java.lang.String obtenerDatosPersonalesEMailResponse;

    public ObtenerDatosPersonalesEMailResponse() {
    }

    public ObtenerDatosPersonalesEMailResponse(
           java.lang.String obtenerDatosPersonalesEMailResponse) {
           this.obtenerDatosPersonalesEMailResponse = obtenerDatosPersonalesEMailResponse;
    }


    /**
     * Gets the obtenerDatosPersonalesEMailResponse value for this ObtenerDatosPersonalesEMailResponse.
     * 
     * @return obtenerDatosPersonalesEMailResponse
     */
    public java.lang.String getObtenerDatosPersonalesEMailResponse() {
        return obtenerDatosPersonalesEMailResponse;
    }


    /**
     * Sets the obtenerDatosPersonalesEMailResponse value for this ObtenerDatosPersonalesEMailResponse.
     * 
     * @param obtenerDatosPersonalesEMailResponse
     */
    public void setObtenerDatosPersonalesEMailResponse(java.lang.String obtenerDatosPersonalesEMailResponse) {
        this.obtenerDatosPersonalesEMailResponse = obtenerDatosPersonalesEMailResponse;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObtenerDatosPersonalesEMailResponse)) return false;
        ObtenerDatosPersonalesEMailResponse other = (ObtenerDatosPersonalesEMailResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.obtenerDatosPersonalesEMailResponse==null && other.getObtenerDatosPersonalesEMailResponse()==null) || 
             (this.obtenerDatosPersonalesEMailResponse!=null &&
              this.obtenerDatosPersonalesEMailResponse.equals(other.getObtenerDatosPersonalesEMailResponse())));
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
        if (getObtenerDatosPersonalesEMailResponse() != null) {
            _hashCode += getObtenerDatosPersonalesEMailResponse().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObtenerDatosPersonalesEMailResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "ObtenerDatosPersonalesEMailResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obtenerDatosPersonalesEMailResponse");
        elemField.setXmlName(new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "ObtenerDatosPersonalesEMailResponse"));
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
