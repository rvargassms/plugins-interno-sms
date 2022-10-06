/**
 * GetEmpleadoByUsernameResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.services.administracion.empleado;

public class GetEmpleadoByUsernameResponse  implements java.io.Serializable {
    private ar.com.osde.entities.empleado.Empleado empleado;

    public GetEmpleadoByUsernameResponse() {
    }

    public GetEmpleadoByUsernameResponse(
           ar.com.osde.entities.empleado.Empleado empleado) {
           this.empleado = empleado;
    }


    /**
     * Gets the empleado value for this GetEmpleadoByUsernameResponse.
     * 
     * @return empleado
     */
    public ar.com.osde.entities.empleado.Empleado getEmpleado() {
        return empleado;
    }


    /**
     * Sets the empleado value for this GetEmpleadoByUsernameResponse.
     * 
     * @param empleado
     */
    public void setEmpleado(ar.com.osde.entities.empleado.Empleado empleado) {
        this.empleado = empleado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetEmpleadoByUsernameResponse)) return false;
        GetEmpleadoByUsernameResponse other = (GetEmpleadoByUsernameResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.empleado==null && other.getEmpleado()==null) || 
             (this.empleado!=null &&
              this.empleado.equals(other.getEmpleado())));
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
        if (getEmpleado() != null) {
            _hashCode += getEmpleado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetEmpleadoByUsernameResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "getEmpleadoByUsernameResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("empleado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "Empleado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "empleado"));
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
