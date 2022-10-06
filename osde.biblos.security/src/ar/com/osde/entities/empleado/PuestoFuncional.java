/**
 * PuestoFuncional.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.entities.empleado;

public class PuestoFuncional  implements java.io.Serializable {
    private java.lang.Integer numeroEmpresa;

    private java.lang.Integer numeroUnidadOrganizativa;

    private java.lang.Integer numeroPuesto;

    private java.lang.String descripcion;

    private java.lang.String codigoPuesto;

    private java.lang.String rutaCompleta;

    private java.lang.Integer numeroEmpresaPadre;

    private java.lang.Integer numeroUnidadOrganizativaPadre;

    private java.lang.Integer numeroPuestoPadre;

    private java.lang.String campoJerarquico;

    private java.lang.Integer cantidadDependientes;

    private java.lang.Boolean puestoUnico;

    private java.lang.Boolean admiteCAPs;

    private java.lang.Boolean admiteFiliales;

    public PuestoFuncional() {
    }

    public PuestoFuncional(
           java.lang.Integer numeroEmpresa,
           java.lang.Integer numeroUnidadOrganizativa,
           java.lang.Integer numeroPuesto,
           java.lang.String descripcion,
           java.lang.String codigoPuesto,
           java.lang.String rutaCompleta,
           java.lang.Integer numeroEmpresaPadre,
           java.lang.Integer numeroUnidadOrganizativaPadre,
           java.lang.Integer numeroPuestoPadre,
           java.lang.String campoJerarquico,
           java.lang.Integer cantidadDependientes,
           java.lang.Boolean puestoUnico,
           java.lang.Boolean admiteCAPs,
           java.lang.Boolean admiteFiliales) {
           this.numeroEmpresa = numeroEmpresa;
           this.numeroUnidadOrganizativa = numeroUnidadOrganizativa;
           this.numeroPuesto = numeroPuesto;
           this.descripcion = descripcion;
           this.codigoPuesto = codigoPuesto;
           this.rutaCompleta = rutaCompleta;
           this.numeroEmpresaPadre = numeroEmpresaPadre;
           this.numeroUnidadOrganizativaPadre = numeroUnidadOrganizativaPadre;
           this.numeroPuestoPadre = numeroPuestoPadre;
           this.campoJerarquico = campoJerarquico;
           this.cantidadDependientes = cantidadDependientes;
           this.puestoUnico = puestoUnico;
           this.admiteCAPs = admiteCAPs;
           this.admiteFiliales = admiteFiliales;
    }


    /**
     * Gets the numeroEmpresa value for this PuestoFuncional.
     * 
     * @return numeroEmpresa
     */
    public java.lang.Integer getNumeroEmpresa() {
        return numeroEmpresa;
    }


    /**
     * Sets the numeroEmpresa value for this PuestoFuncional.
     * 
     * @param numeroEmpresa
     */
    public void setNumeroEmpresa(java.lang.Integer numeroEmpresa) {
        this.numeroEmpresa = numeroEmpresa;
    }


    /**
     * Gets the numeroUnidadOrganizativa value for this PuestoFuncional.
     * 
     * @return numeroUnidadOrganizativa
     */
    public java.lang.Integer getNumeroUnidadOrganizativa() {
        return numeroUnidadOrganizativa;
    }


    /**
     * Sets the numeroUnidadOrganizativa value for this PuestoFuncional.
     * 
     * @param numeroUnidadOrganizativa
     */
    public void setNumeroUnidadOrganizativa(java.lang.Integer numeroUnidadOrganizativa) {
        this.numeroUnidadOrganizativa = numeroUnidadOrganizativa;
    }


    /**
     * Gets the numeroPuesto value for this PuestoFuncional.
     * 
     * @return numeroPuesto
     */
    public java.lang.Integer getNumeroPuesto() {
        return numeroPuesto;
    }


    /**
     * Sets the numeroPuesto value for this PuestoFuncional.
     * 
     * @param numeroPuesto
     */
    public void setNumeroPuesto(java.lang.Integer numeroPuesto) {
        this.numeroPuesto = numeroPuesto;
    }


    /**
     * Gets the descripcion value for this PuestoFuncional.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this PuestoFuncional.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the codigoPuesto value for this PuestoFuncional.
     * 
     * @return codigoPuesto
     */
    public java.lang.String getCodigoPuesto() {
        return codigoPuesto;
    }


    /**
     * Sets the codigoPuesto value for this PuestoFuncional.
     * 
     * @param codigoPuesto
     */
    public void setCodigoPuesto(java.lang.String codigoPuesto) {
        this.codigoPuesto = codigoPuesto;
    }


    /**
     * Gets the rutaCompleta value for this PuestoFuncional.
     * 
     * @return rutaCompleta
     */
    public java.lang.String getRutaCompleta() {
        return rutaCompleta;
    }


    /**
     * Sets the rutaCompleta value for this PuestoFuncional.
     * 
     * @param rutaCompleta
     */
    public void setRutaCompleta(java.lang.String rutaCompleta) {
        this.rutaCompleta = rutaCompleta;
    }


    /**
     * Gets the numeroEmpresaPadre value for this PuestoFuncional.
     * 
     * @return numeroEmpresaPadre
     */
    public java.lang.Integer getNumeroEmpresaPadre() {
        return numeroEmpresaPadre;
    }


    /**
     * Sets the numeroEmpresaPadre value for this PuestoFuncional.
     * 
     * @param numeroEmpresaPadre
     */
    public void setNumeroEmpresaPadre(java.lang.Integer numeroEmpresaPadre) {
        this.numeroEmpresaPadre = numeroEmpresaPadre;
    }


    /**
     * Gets the numeroUnidadOrganizativaPadre value for this PuestoFuncional.
     * 
     * @return numeroUnidadOrganizativaPadre
     */
    public java.lang.Integer getNumeroUnidadOrganizativaPadre() {
        return numeroUnidadOrganizativaPadre;
    }


    /**
     * Sets the numeroUnidadOrganizativaPadre value for this PuestoFuncional.
     * 
     * @param numeroUnidadOrganizativaPadre
     */
    public void setNumeroUnidadOrganizativaPadre(java.lang.Integer numeroUnidadOrganizativaPadre) {
        this.numeroUnidadOrganizativaPadre = numeroUnidadOrganizativaPadre;
    }


    /**
     * Gets the numeroPuestoPadre value for this PuestoFuncional.
     * 
     * @return numeroPuestoPadre
     */
    public java.lang.Integer getNumeroPuestoPadre() {
        return numeroPuestoPadre;
    }


    /**
     * Sets the numeroPuestoPadre value for this PuestoFuncional.
     * 
     * @param numeroPuestoPadre
     */
    public void setNumeroPuestoPadre(java.lang.Integer numeroPuestoPadre) {
        this.numeroPuestoPadre = numeroPuestoPadre;
    }


    /**
     * Gets the campoJerarquico value for this PuestoFuncional.
     * 
     * @return campoJerarquico
     */
    public java.lang.String getCampoJerarquico() {
        return campoJerarquico;
    }


    /**
     * Sets the campoJerarquico value for this PuestoFuncional.
     * 
     * @param campoJerarquico
     */
    public void setCampoJerarquico(java.lang.String campoJerarquico) {
        this.campoJerarquico = campoJerarquico;
    }


    /**
     * Gets the cantidadDependientes value for this PuestoFuncional.
     * 
     * @return cantidadDependientes
     */
    public java.lang.Integer getCantidadDependientes() {
        return cantidadDependientes;
    }


    /**
     * Sets the cantidadDependientes value for this PuestoFuncional.
     * 
     * @param cantidadDependientes
     */
    public void setCantidadDependientes(java.lang.Integer cantidadDependientes) {
        this.cantidadDependientes = cantidadDependientes;
    }


    /**
     * Gets the puestoUnico value for this PuestoFuncional.
     * 
     * @return puestoUnico
     */
    public java.lang.Boolean getPuestoUnico() {
        return puestoUnico;
    }


    /**
     * Sets the puestoUnico value for this PuestoFuncional.
     * 
     * @param puestoUnico
     */
    public void setPuestoUnico(java.lang.Boolean puestoUnico) {
        this.puestoUnico = puestoUnico;
    }


    /**
     * Gets the admiteCAPs value for this PuestoFuncional.
     * 
     * @return admiteCAPs
     */
    public java.lang.Boolean getAdmiteCAPs() {
        return admiteCAPs;
    }


    /**
     * Sets the admiteCAPs value for this PuestoFuncional.
     * 
     * @param admiteCAPs
     */
    public void setAdmiteCAPs(java.lang.Boolean admiteCAPs) {
        this.admiteCAPs = admiteCAPs;
    }


    /**
     * Gets the admiteFiliales value for this PuestoFuncional.
     * 
     * @return admiteFiliales
     */
    public java.lang.Boolean getAdmiteFiliales() {
        return admiteFiliales;
    }


    /**
     * Sets the admiteFiliales value for this PuestoFuncional.
     * 
     * @param admiteFiliales
     */
    public void setAdmiteFiliales(java.lang.Boolean admiteFiliales) {
        this.admiteFiliales = admiteFiliales;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PuestoFuncional)) return false;
        PuestoFuncional other = (PuestoFuncional) obj;
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
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.codigoPuesto==null && other.getCodigoPuesto()==null) || 
             (this.codigoPuesto!=null &&
              this.codigoPuesto.equals(other.getCodigoPuesto()))) &&
            ((this.rutaCompleta==null && other.getRutaCompleta()==null) || 
             (this.rutaCompleta!=null &&
              this.rutaCompleta.equals(other.getRutaCompleta()))) &&
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
            ((this.cantidadDependientes==null && other.getCantidadDependientes()==null) || 
             (this.cantidadDependientes!=null &&
              this.cantidadDependientes.equals(other.getCantidadDependientes()))) &&
            ((this.puestoUnico==null && other.getPuestoUnico()==null) || 
             (this.puestoUnico!=null &&
              this.puestoUnico.equals(other.getPuestoUnico()))) &&
            ((this.admiteCAPs==null && other.getAdmiteCAPs()==null) || 
             (this.admiteCAPs!=null &&
              this.admiteCAPs.equals(other.getAdmiteCAPs()))) &&
            ((this.admiteFiliales==null && other.getAdmiteFiliales()==null) || 
             (this.admiteFiliales!=null &&
              this.admiteFiliales.equals(other.getAdmiteFiliales())));
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
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getCodigoPuesto() != null) {
            _hashCode += getCodigoPuesto().hashCode();
        }
        if (getRutaCompleta() != null) {
            _hashCode += getRutaCompleta().hashCode();
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
        if (getCantidadDependientes() != null) {
            _hashCode += getCantidadDependientes().hashCode();
        }
        if (getPuestoUnico() != null) {
            _hashCode += getPuestoUnico().hashCode();
        }
        if (getAdmiteCAPs() != null) {
            _hashCode += getAdmiteCAPs().hashCode();
        }
        if (getAdmiteFiliales() != null) {
            _hashCode += getAdmiteFiliales().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PuestoFuncional.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "puestoFuncional"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("numeroPuesto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "numeroPuesto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("codigoPuesto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "codigoPuesto"));
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
        elemField.setFieldName("cantidadDependientes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "cantidadDependientes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("puestoUnico");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "puestoUnico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("admiteCAPs");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "admiteCAPs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("admiteFiliales");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "admiteFiliales"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
