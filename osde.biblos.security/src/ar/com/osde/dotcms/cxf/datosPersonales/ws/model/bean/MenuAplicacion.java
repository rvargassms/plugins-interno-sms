/**
 * MenuAplicacion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean;

public class MenuAplicacion  implements java.io.Serializable {
    private ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Aplicacion[] aplicaciones;

    private java.lang.String jerar;

    private java.lang.String navegador;

    private java.lang.String navegador2;

    public MenuAplicacion() {
    }

    public MenuAplicacion(
           ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Aplicacion[] aplicaciones,
           java.lang.String jerar,
           java.lang.String navegador,
           java.lang.String navegador2) {
           this.aplicaciones = aplicaciones;
           this.jerar = jerar;
           this.navegador = navegador;
           this.navegador2 = navegador2;
    }


    /**
     * Gets the aplicaciones value for this MenuAplicacion.
     * 
     * @return aplicaciones
     */
    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Aplicacion[] getAplicaciones() {
        return aplicaciones;
    }


    /**
     * Sets the aplicaciones value for this MenuAplicacion.
     * 
     * @param aplicaciones
     */
    public void setAplicaciones(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Aplicacion[] aplicaciones) {
        this.aplicaciones = aplicaciones;
    }


    /**
     * Gets the jerar value for this MenuAplicacion.
     * 
     * @return jerar
     */
    public java.lang.String getJerar() {
        return jerar;
    }


    /**
     * Sets the jerar value for this MenuAplicacion.
     * 
     * @param jerar
     */
    public void setJerar(java.lang.String jerar) {
        this.jerar = jerar;
    }


    /**
     * Gets the navegador value for this MenuAplicacion.
     * 
     * @return navegador
     */
    public java.lang.String getNavegador() {
        return navegador;
    }


    /**
     * Sets the navegador value for this MenuAplicacion.
     * 
     * @param navegador
     */
    public void setNavegador(java.lang.String navegador) {
        this.navegador = navegador;
    }


    /**
     * Gets the navegador2 value for this MenuAplicacion.
     * 
     * @return navegador2
     */
    public java.lang.String getNavegador2() {
        return navegador2;
    }


    /**
     * Sets the navegador2 value for this MenuAplicacion.
     * 
     * @param navegador2
     */
    public void setNavegador2(java.lang.String navegador2) {
        this.navegador2 = navegador2;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MenuAplicacion)) return false;
        MenuAplicacion other = (MenuAplicacion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.aplicaciones==null && other.getAplicaciones()==null) || 
             (this.aplicaciones!=null &&
              java.util.Arrays.equals(this.aplicaciones, other.getAplicaciones()))) &&
            ((this.jerar==null && other.getJerar()==null) || 
             (this.jerar!=null &&
              this.jerar.equals(other.getJerar()))) &&
            ((this.navegador==null && other.getNavegador()==null) || 
             (this.navegador!=null &&
              this.navegador.equals(other.getNavegador()))) &&
            ((this.navegador2==null && other.getNavegador2()==null) || 
             (this.navegador2!=null &&
              this.navegador2.equals(other.getNavegador2())));
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
        if (getAplicaciones() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAplicaciones());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAplicaciones(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getJerar() != null) {
            _hashCode += getJerar().hashCode();
        }
        if (getNavegador() != null) {
            _hashCode += getNavegador().hashCode();
        }
        if (getNavegador2() != null) {
            _hashCode += getNavegador2().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MenuAplicacion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "MenuAplicacion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aplicaciones");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "aplicaciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Aplicacion"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Aplicacion"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jerar");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "jerar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("navegador");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "navegador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("navegador2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "navegador2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
