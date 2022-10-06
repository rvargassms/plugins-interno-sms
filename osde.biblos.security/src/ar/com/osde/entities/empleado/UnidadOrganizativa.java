/**
 * UnidadOrganizativa.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.entities.empleado;

public class UnidadOrganizativa  implements java.io.Serializable {
    private java.lang.Integer id;

    private java.lang.Integer numeroEmpresa;

    private java.lang.Integer numeroUnidadOrganizativa;

    private java.lang.String codigoUnidadOrganizativa;

    private java.lang.String descripcion;

    private java.lang.Integer numeroEmpresaPadre;

    private java.lang.Integer numeroUnidadOrganizativaPadre;

    private java.lang.Integer numeroPuestoPadre;

    private java.lang.String campoJerarquico;

    private java.lang.String rutaCompleta;

    private java.lang.Integer cantidadDependientes;

    public UnidadOrganizativa() {
    }

    public UnidadOrganizativa(
           java.lang.Integer id,
           java.lang.Integer numeroEmpresa,
           java.lang.Integer numeroUnidadOrganizativa,
           java.lang.String codigoUnidadOrganizativa,
           java.lang.String descripcion,
           java.lang.Integer numeroEmpresaPadre,
           java.lang.Integer numeroUnidadOrganizativaPadre,
           java.lang.Integer numeroPuestoPadre,
           java.lang.String campoJerarquico,
           java.lang.String rutaCompleta,
           java.lang.Integer cantidadDependientes) {
           this.id = id;
           this.numeroEmpresa = numeroEmpresa;
           this.numeroUnidadOrganizativa = numeroUnidadOrganizativa;
           this.codigoUnidadOrganizativa = codigoUnidadOrganizativa;
           this.descripcion = descripcion;
           this.numeroEmpresaPadre = numeroEmpresaPadre;
           this.numeroUnidadOrganizativaPadre = numeroUnidadOrganizativaPadre;
           this.numeroPuestoPadre = numeroPuestoPadre;
           this.campoJerarquico = campoJerarquico;
           this.rutaCompleta = rutaCompleta;
           this.cantidadDependientes = cantidadDependientes;
    }


    /**
     * Gets the id value for this UnidadOrganizativa.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this UnidadOrganizativa.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the numeroEmpresa value for this UnidadOrganizativa.
     * 
     * @return numeroEmpresa
     */
    public java.lang.Integer getNumeroEmpresa() {
        return numeroEmpresa;
    }


    /**
     * Sets the numeroEmpresa value for this UnidadOrganizativa.
     * 
     * @param numeroEmpresa
     */
    public void setNumeroEmpresa(java.lang.Integer numeroEmpresa) {
        this.numeroEmpresa = numeroEmpresa;
    }


    /**
     * Gets the numeroUnidadOrganizativa value for this UnidadOrganizativa.
     * 
     * @return numeroUnidadOrganizativa
     */
    public java.lang.Integer getNumeroUnidadOrganizativa() {
        return numeroUnidadOrganizativa;
    }


    /**
     * Sets the numeroUnidadOrganizativa value for this UnidadOrganizativa.
     * 
     * @param numeroUnidadOrganizativa
     */
    public void setNumeroUnidadOrganizativa(java.lang.Integer numeroUnidadOrganizativa) {
        this.numeroUnidadOrganizativa = numeroUnidadOrganizativa;
    }


    /**
     * Gets the codigoUnidadOrganizativa value for this UnidadOrganizativa.
     * 
     * @return codigoUnidadOrganizativa
     */
    public java.lang.String getCodigoUnidadOrganizativa() {
        return codigoUnidadOrganizativa;
    }


    /**
     * Sets the codigoUnidadOrganizativa value for this UnidadOrganizativa.
     * 
     * @param codigoUnidadOrganizativa
     */
    public void setCodigoUnidadOrganizativa(java.lang.String codigoUnidadOrganizativa) {
        this.codigoUnidadOrganizativa = codigoUnidadOrganizativa;
    }


    /**
     * Gets the descripcion value for this UnidadOrganizativa.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this UnidadOrganizativa.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the numeroEmpresaPadre value for this UnidadOrganizativa.
     * 
     * @return numeroEmpresaPadre
     */
    public java.lang.Integer getNumeroEmpresaPadre() {
        return numeroEmpresaPadre;
    }


    /**
     * Sets the numeroEmpresaPadre value for this UnidadOrganizativa.
     * 
     * @param numeroEmpresaPadre
     */
    public void setNumeroEmpresaPadre(java.lang.Integer numeroEmpresaPadre) {
        this.numeroEmpresaPadre = numeroEmpresaPadre;
    }


    /**
     * Gets the numeroUnidadOrganizativaPadre value for this UnidadOrganizativa.
     * 
     * @return numeroUnidadOrganizativaPadre
     */
    public java.lang.Integer getNumeroUnidadOrganizativaPadre() {
        return numeroUnidadOrganizativaPadre;
    }


    /**
     * Sets the numeroUnidadOrganizativaPadre value for this UnidadOrganizativa.
     * 
     * @param numeroUnidadOrganizativaPadre
     */
    public void setNumeroUnidadOrganizativaPadre(java.lang.Integer numeroUnidadOrganizativaPadre) {
        this.numeroUnidadOrganizativaPadre = numeroUnidadOrganizativaPadre;
    }


    /**
     * Gets the numeroPuestoPadre value for this UnidadOrganizativa.
     * 
     * @return numeroPuestoPadre
     */
    public java.lang.Integer getNumeroPuestoPadre() {
        return numeroPuestoPadre;
    }


    /**
     * Sets the numeroPuestoPadre value for this UnidadOrganizativa.
     * 
     * @param numeroPuestoPadre
     */
    public void setNumeroPuestoPadre(java.lang.Integer numeroPuestoPadre) {
        this.numeroPuestoPadre = numeroPuestoPadre;
    }


    /**
     * Gets the campoJerarquico value for this UnidadOrganizativa.
     * 
     * @return campoJerarquico
     */
    public java.lang.String getCampoJerarquico() {
        return campoJerarquico;
    }


    /**
     * Sets the campoJerarquico value for this UnidadOrganizativa.
     * 
     * @param campoJerarquico
     */
    public void setCampoJerarquico(java.lang.String campoJerarquico) {
        this.campoJerarquico = campoJerarquico;
    }


    /**
     * Gets the rutaCompleta value for this UnidadOrganizativa.
     * 
     * @return rutaCompleta
     */
    public java.lang.String getRutaCompleta() {
        return rutaCompleta;
    }


    /**
     * Sets the rutaCompleta value for this UnidadOrganizativa.
     * 
     * @param rutaCompleta
     */
    public void setRutaCompleta(java.lang.String rutaCompleta) {
        this.rutaCompleta = rutaCompleta;
    }


    /**
     * Gets the cantidadDependientes value for this UnidadOrganizativa.
     * 
     * @return cantidadDependientes
     */
    public java.lang.Integer getCantidadDependientes() {
        return cantidadDependientes;
    }


    /**
     * Sets the cantidadDependientes value for this UnidadOrganizativa.
     * 
     * @param cantidadDependientes
     */
    public void setCantidadDependientes(java.lang.Integer cantidadDependientes) {
        this.cantidadDependientes = cantidadDependientes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UnidadOrganizativa)) return false;
        UnidadOrganizativa other = (UnidadOrganizativa) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.numeroEmpresa==null && other.getNumeroEmpresa()==null) || 
             (this.numeroEmpresa!=null &&
              this.numeroEmpresa.equals(other.getNumeroEmpresa()))) &&
            ((this.numeroUnidadOrganizativa==null && other.getNumeroUnidadOrganizativa()==null) || 
             (this.numeroUnidadOrganizativa!=null &&
              this.numeroUnidadOrganizativa.equals(other.getNumeroUnidadOrganizativa()))) &&
            ((this.codigoUnidadOrganizativa==null && other.getCodigoUnidadOrganizativa()==null) || 
             (this.codigoUnidadOrganizativa!=null &&
              this.codigoUnidadOrganizativa.equals(other.getCodigoUnidadOrganizativa()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.numeroEmpresaPadre==null && other.getNumeroEmpresaPadre()==null) || 
             (this.numeroEmpresaPadre!=null &&
              this.numeroEmpresaPadre.equals(other.getNumeroEmpresaPadre()))) &&
            ((this.numeroUnidadOrganizativaPadre==null && other.getNumeroUnidadOrganizativaPadre()==null) || 
             (this.numeroUnidadOrganizativaPadre!=null &&
              this.numeroUnidadOrganizativaPadre.equals(other.getNumeroUnidadOrganizativaPadre()))) &&
            ((this.numeroPuestoPadre==null && other.getNumeroPuestoPadre()==null) || 
             (this.numeroPuestoPadre!=null &&
              this.numeroPuestoPadre.equals(other.getNumeroPuestoPadre()))) &&
            ((this.campoJerarquico==null && other.getCampoJerarquico()==null) || 
             (this.campoJerarquico!=null &&
              this.campoJerarquico.equals(other.getCampoJerarquico()))) &&
            ((this.rutaCompleta==null && other.getRutaCompleta()==null) || 
             (this.rutaCompleta!=null &&
              this.rutaCompleta.equals(other.getRutaCompleta()))) &&
            ((this.cantidadDependientes==null && other.getCantidadDependientes()==null) || 
             (this.cantidadDependientes!=null &&
              this.cantidadDependientes.equals(other.getCantidadDependientes())));
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getNumeroEmpresa() != null) {
            _hashCode += getNumeroEmpresa().hashCode();
        }
        if (getNumeroUnidadOrganizativa() != null) {
            _hashCode += getNumeroUnidadOrganizativa().hashCode();
        }
        if (getCodigoUnidadOrganizativa() != null) {
            _hashCode += getCodigoUnidadOrganizativa().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getNumeroEmpresaPadre() != null) {
            _hashCode += getNumeroEmpresaPadre().hashCode();
        }
        if (getNumeroUnidadOrganizativaPadre() != null) {
            _hashCode += getNumeroUnidadOrganizativaPadre().hashCode();
        }
        if (getNumeroPuestoPadre() != null) {
            _hashCode += getNumeroPuestoPadre().hashCode();
        }
        if (getCampoJerarquico() != null) {
            _hashCode += getCampoJerarquico().hashCode();
        }
        if (getRutaCompleta() != null) {
            _hashCode += getRutaCompleta().hashCode();
        }
        if (getCantidadDependientes() != null) {
            _hashCode += getCantidadDependientes().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UnidadOrganizativa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "unidadOrganizativa"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroEmpresa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "numeroEmpresa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroUnidadOrganizativa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "numeroUnidadOrganizativa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoUnidadOrganizativa");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "codigoUnidadOrganizativa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroEmpresaPadre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "numeroEmpresaPadre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroUnidadOrganizativaPadre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "numeroUnidadOrganizativaPadre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroPuestoPadre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "numeroPuestoPadre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campoJerarquico");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "campoJerarquico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rutaCompleta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "rutaCompleta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidadDependientes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "cantidadDependientes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
