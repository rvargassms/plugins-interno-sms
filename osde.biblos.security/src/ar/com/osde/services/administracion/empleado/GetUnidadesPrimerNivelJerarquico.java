/**
 * GetUnidadesPrimerNivelJerarquico.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.services.administracion.empleado;

public class GetUnidadesPrimerNivelJerarquico  implements java.io.Serializable {
    private java.lang.String empreNro;

    private java.lang.String uniNro;

    public GetUnidadesPrimerNivelJerarquico() {
    }

    public GetUnidadesPrimerNivelJerarquico(
           java.lang.String empreNro,
           java.lang.String uniNro) {
           this.empreNro = empreNro;
           this.uniNro = uniNro;
    }


    /**
     * Gets the empreNro value for this GetUnidadesPrimerNivelJerarquico.
     * 
     * @return empreNro
     */
    public java.lang.String getEmpreNro() {
        return empreNro;
    }


    /**
     * Sets the empreNro value for this GetUnidadesPrimerNivelJerarquico.
     * 
     * @param empreNro
     */
    public void setEmpreNro(java.lang.String empreNro) {
        this.empreNro = empreNro;
    }


    /**
     * Gets the uniNro value for this GetUnidadesPrimerNivelJerarquico.
     * 
     * @return uniNro
     */
    public java.lang.String getUniNro() {
        return uniNro;
    }


    /**
     * Sets the uniNro value for this GetUnidadesPrimerNivelJerarquico.
     * 
     * @param uniNro
     */
    public void setUniNro(java.lang.String uniNro) {
        this.uniNro = uniNro;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetUnidadesPrimerNivelJerarquico)) return false;
        GetUnidadesPrimerNivelJerarquico other = (GetUnidadesPrimerNivelJerarquico) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.empreNro==null && other.getEmpreNro()==null) || 
             (this.empreNro!=null &&
              this.empreNro.equals(other.getEmpreNro()))) &&
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
        if (getEmpreNro() != null) {
            _hashCode += getEmpreNro().hashCode();
        }
        if (getUniNro() != null) {
            _hashCode += getUniNro().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetUnidadesPrimerNivelJerarquico.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "getUnidadesPrimerNivelJerarquico"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("empreNro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "empreNro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uniNro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "uniNro"));
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
