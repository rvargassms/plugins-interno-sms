/**
 * GetPuestosDependientesDePuesto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.services.administracion.empleado;

public class GetPuestosDependientesDePuesto  implements java.io.Serializable {
    private java.lang.String numeroEmpresa;

    private java.lang.String numeroUnidadOrganizativa;

    private java.lang.String numeroPuesto;

    private java.lang.String filiales;

    public GetPuestosDependientesDePuesto() {
    }

    public GetPuestosDependientesDePuesto(
           java.lang.String numeroEmpresa,
           java.lang.String numeroUnidadOrganizativa,
           java.lang.String numeroPuesto,
           java.lang.String filiales) {
           this.numeroEmpresa = numeroEmpresa;
           this.numeroUnidadOrganizativa = numeroUnidadOrganizativa;
           this.numeroPuesto = numeroPuesto;
           this.filiales = filiales;
    }


    /**
     * Gets the numeroEmpresa value for this GetPuestosDependientesDePuesto.
     * 
     * @return numeroEmpresa
     */
    public java.lang.String getNumeroEmpresa() {
        return numeroEmpresa;
    }


    /**
     * Sets the numeroEmpresa value for this GetPuestosDependientesDePuesto.
     * 
     * @param numeroEmpresa
     */
    public void setNumeroEmpresa(java.lang.String numeroEmpresa) {
        this.numeroEmpresa = numeroEmpresa;
    }


    /**
     * Gets the numeroUnidadOrganizativa value for this GetPuestosDependientesDePuesto.
     * 
     * @return numeroUnidadOrganizativa
     */
    public java.lang.String getNumeroUnidadOrganizativa() {
        return numeroUnidadOrganizativa;
    }


    /**
     * Sets the numeroUnidadOrganizativa value for this GetPuestosDependientesDePuesto.
     * 
     * @param numeroUnidadOrganizativa
     */
    public void setNumeroUnidadOrganizativa(java.lang.String numeroUnidadOrganizativa) {
        this.numeroUnidadOrganizativa = numeroUnidadOrganizativa;
    }


    /**
     * Gets the numeroPuesto value for this GetPuestosDependientesDePuesto.
     * 
     * @return numeroPuesto
     */
    public java.lang.String getNumeroPuesto() {
        return numeroPuesto;
    }


    /**
     * Sets the numeroPuesto value for this GetPuestosDependientesDePuesto.
     * 
     * @param numeroPuesto
     */
    public void setNumeroPuesto(java.lang.String numeroPuesto) {
        this.numeroPuesto = numeroPuesto;
    }


    /**
     * Gets the filiales value for this GetPuestosDependientesDePuesto.
     * 
     * @return filiales
     */
    public java.lang.String getFiliales() {
        return filiales;
    }


    /**
     * Sets the filiales value for this GetPuestosDependientesDePuesto.
     * 
     * @param filiales
     */
    public void setFiliales(java.lang.String filiales) {
        this.filiales = filiales;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetPuestosDependientesDePuesto)) return false;
        GetPuestosDependientesDePuesto other = (GetPuestosDependientesDePuesto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.numeroEmpresa==null && other.getNumeroEmpresa()==null) || 
             (this.numeroEmpresa!=null &&
              this.numeroEmpresa.equals(other.getNumeroEmpresa()))) &&
            ((this.numeroUnidadOrganizativa==null && other.getNumeroUnidadOrganizativa()==null) || 
             (this.numeroUnidadOrganizativa!=null &&
              this.numeroUnidadOrganizativa.equals(other.getNumeroUnidadOrganizativa()))) &&
            ((this.numeroPuesto==null && other.getNumeroPuesto()==null) || 
             (this.numeroPuesto!=null &&
              this.numeroPuesto.equals(other.getNumeroPuesto()))) &&
            ((this.filiales==null && other.getFiliales()==null) || 
             (this.filiales!=null &&
              this.filiales.equals(other.getFiliales())));
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
        if (getNumeroEmpresa() != null) {
            _hashCode += getNumeroEmpresa().hashCode();
        }
        if (getNumeroUnidadOrganizativa() != null) {
            _hashCode += getNumeroUnidadOrganizativa().hashCode();
        }
        if (getNumeroPuesto() != null) {
            _hashCode += getNumeroPuesto().hashCode();
        }
        if (getFiliales() != null) {
            _hashCode += getFiliales().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetPuestosDependientesDePuesto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "getPuestosDependientesDePuesto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroEmpresa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "numeroEmpresa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroUnidadOrganizativa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "numeroUnidadOrganizativa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroPuesto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "numeroPuesto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filiales");
        elemField.setXmlName(new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "filiales"));
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
