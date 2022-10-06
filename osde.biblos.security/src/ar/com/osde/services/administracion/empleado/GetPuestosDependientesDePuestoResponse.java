/**
 * GetPuestosDependientesDePuestoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.services.administracion.empleado;

public class GetPuestosDependientesDePuestoResponse  implements java.io.Serializable {
    private ar.com.osde.entities.empleado.PuestoFuncional[] puestosFuncionales;

    public GetPuestosDependientesDePuestoResponse() {
    }

    public GetPuestosDependientesDePuestoResponse(
           ar.com.osde.entities.empleado.PuestoFuncional[] puestosFuncionales) {
           this.puestosFuncionales = puestosFuncionales;
    }


    /**
     * Gets the puestosFuncionales value for this GetPuestosDependientesDePuestoResponse.
     * 
     * @return puestosFuncionales
     */
    public ar.com.osde.entities.empleado.PuestoFuncional[] getPuestosFuncionales() {
        return puestosFuncionales;
    }


    /**
     * Sets the puestosFuncionales value for this GetPuestosDependientesDePuestoResponse.
     * 
     * @param puestosFuncionales
     */
    public void setPuestosFuncionales(ar.com.osde.entities.empleado.PuestoFuncional[] puestosFuncionales) {
        this.puestosFuncionales = puestosFuncionales;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetPuestosDependientesDePuestoResponse)) return false;
        GetPuestosDependientesDePuestoResponse other = (GetPuestosDependientesDePuestoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.puestosFuncionales==null && other.getPuestosFuncionales()==null) || 
             (this.puestosFuncionales!=null &&
              java.util.Arrays.equals(this.puestosFuncionales, other.getPuestosFuncionales())));
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
        if (getPuestosFuncionales() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPuestosFuncionales());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPuestosFuncionales(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetPuestosDependientesDePuestoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "getPuestosDependientesDePuestoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("puestosFuncionales");
        elemField.setXmlName(new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "PuestosFuncionales"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "puestoFuncional"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "puestosFuncionales"));
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
