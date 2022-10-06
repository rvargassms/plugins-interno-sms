/**
 * GetUnidadesPrimerNivelJerarquicoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.services.administracion.empleado;

public class GetUnidadesPrimerNivelJerarquicoResponse  implements java.io.Serializable {
    private ar.com.osde.entities.empleado.UnidadOrganizativa[] unidadesOrganizativas;

    public GetUnidadesPrimerNivelJerarquicoResponse() {
    }

    public GetUnidadesPrimerNivelJerarquicoResponse(
           ar.com.osde.entities.empleado.UnidadOrganizativa[] unidadesOrganizativas) {
           this.unidadesOrganizativas = unidadesOrganizativas;
    }


    /**
     * Gets the unidadesOrganizativas value for this GetUnidadesPrimerNivelJerarquicoResponse.
     * 
     * @return unidadesOrganizativas
     */
    public ar.com.osde.entities.empleado.UnidadOrganizativa[] getUnidadesOrganizativas() {
        return unidadesOrganizativas;
    }


    /**
     * Sets the unidadesOrganizativas value for this GetUnidadesPrimerNivelJerarquicoResponse.
     * 
     * @param unidadesOrganizativas
     */
    public void setUnidadesOrganizativas(ar.com.osde.entities.empleado.UnidadOrganizativa[] unidadesOrganizativas) {
        this.unidadesOrganizativas = unidadesOrganizativas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetUnidadesPrimerNivelJerarquicoResponse)) return false;
        GetUnidadesPrimerNivelJerarquicoResponse other = (GetUnidadesPrimerNivelJerarquicoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.unidadesOrganizativas==null && other.getUnidadesOrganizativas()==null) || 
             (this.unidadesOrganizativas!=null &&
              java.util.Arrays.equals(this.unidadesOrganizativas, other.getUnidadesOrganizativas())));
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
        if (getUnidadesOrganizativas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUnidadesOrganizativas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUnidadesOrganizativas(), i);
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
        new org.apache.axis.description.TypeDesc(GetUnidadesPrimerNivelJerarquicoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "getUnidadesPrimerNivelJerarquicoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unidadesOrganizativas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "UnidadesOrganizativas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "unidadOrganizativa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "unidadesOrganizativas"));
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
