/**
 * EmpleadoResumen.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.entities.empleado;

public class EmpleadoResumen  implements java.io.Serializable {
    private java.lang.String idCap;

    private java.lang.String nombreUsuario;

    private int idEmpleado;

    private java.lang.String nombre;

    private int prefijo;

    private ar.com.osde.services.administracion.empleado.SearchResult puestosDeTrabajo;

    private ar.com.osde.entities.empleado.Responsable[] responsables;

    public EmpleadoResumen() {
    }

    public EmpleadoResumen(
           java.lang.String idCap,
           java.lang.String nombreUsuario,
           int idEmpleado,
           java.lang.String nombre,
           int prefijo,
           ar.com.osde.services.administracion.empleado.SearchResult puestosDeTrabajo,
           ar.com.osde.entities.empleado.Responsable[] responsables) {
           this.idCap = idCap;
           this.nombreUsuario = nombreUsuario;
           this.idEmpleado = idEmpleado;
           this.nombre = nombre;
           this.prefijo = prefijo;
           this.puestosDeTrabajo = puestosDeTrabajo;
           this.responsables = responsables;
    }


    /**
     * Gets the idCap value for this EmpleadoResumen.
     * 
     * @return idCap
     */
    public java.lang.String getIdCap() {
        return idCap;
    }


    /**
     * Sets the idCap value for this EmpleadoResumen.
     * 
     * @param idCap
     */
    public void setIdCap(java.lang.String idCap) {
        this.idCap = idCap;
    }


    /**
     * Gets the nombreUsuario value for this EmpleadoResumen.
     * 
     * @return nombreUsuario
     */
    public java.lang.String getNombreUsuario() {
        return nombreUsuario;
    }


    /**
     * Sets the nombreUsuario value for this EmpleadoResumen.
     * 
     * @param nombreUsuario
     */
    public void setNombreUsuario(java.lang.String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }


    /**
     * Gets the idEmpleado value for this EmpleadoResumen.
     * 
     * @return idEmpleado
     */
    public int getIdEmpleado() {
        return idEmpleado;
    }


    /**
     * Sets the idEmpleado value for this EmpleadoResumen.
     * 
     * @param idEmpleado
     */
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }


    /**
     * Gets the nombre value for this EmpleadoResumen.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this EmpleadoResumen.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the prefijo value for this EmpleadoResumen.
     * 
     * @return prefijo
     */
    public int getPrefijo() {
        return prefijo;
    }


    /**
     * Sets the prefijo value for this EmpleadoResumen.
     * 
     * @param prefijo
     */
    public void setPrefijo(int prefijo) {
        this.prefijo = prefijo;
    }


    /**
     * Gets the puestosDeTrabajo value for this EmpleadoResumen.
     * 
     * @return puestosDeTrabajo
     */
    public ar.com.osde.services.administracion.empleado.SearchResult getPuestosDeTrabajo() {
        return puestosDeTrabajo;
    }


    /**
     * Sets the puestosDeTrabajo value for this EmpleadoResumen.
     * 
     * @param puestosDeTrabajo
     */
    public void setPuestosDeTrabajo(ar.com.osde.services.administracion.empleado.SearchResult puestosDeTrabajo) {
        this.puestosDeTrabajo = puestosDeTrabajo;
    }


    /**
     * Gets the responsables value for this EmpleadoResumen.
     * 
     * @return responsables
     */
    public ar.com.osde.entities.empleado.Responsable[] getResponsables() {
        return responsables;
    }


    /**
     * Sets the responsables value for this EmpleadoResumen.
     * 
     * @param responsables
     */
    public void setResponsables(ar.com.osde.entities.empleado.Responsable[] responsables) {
        this.responsables = responsables;
    }

    public ar.com.osde.entities.empleado.Responsable getResponsables(int i) {
        return this.responsables[i];
    }

    public void setResponsables(int i, ar.com.osde.entities.empleado.Responsable _value) {
        this.responsables[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EmpleadoResumen)) return false;
        EmpleadoResumen other = (EmpleadoResumen) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idCap==null && other.getIdCap()==null) || 
             (this.idCap!=null &&
              this.idCap.equals(other.getIdCap()))) &&
            ((this.nombreUsuario==null && other.getNombreUsuario()==null) || 
             (this.nombreUsuario!=null &&
              this.nombreUsuario.equals(other.getNombreUsuario()))) &&
            this.idEmpleado == other.getIdEmpleado() &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            this.prefijo == other.getPrefijo() &&
            ((this.puestosDeTrabajo==null && other.getPuestosDeTrabajo()==null) || 
             (this.puestosDeTrabajo!=null &&
              this.puestosDeTrabajo.equals(other.getPuestosDeTrabajo()))) &&
            ((this.responsables==null && other.getResponsables()==null) || 
             (this.responsables!=null &&
              java.util.Arrays.equals(this.responsables, other.getResponsables())));
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
        if (getIdCap() != null) {
            _hashCode += getIdCap().hashCode();
        }
        if (getNombreUsuario() != null) {
            _hashCode += getNombreUsuario().hashCode();
        }
        _hashCode += getIdEmpleado();
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        _hashCode += getPrefijo();
        if (getPuestosDeTrabajo() != null) {
            _hashCode += getPuestosDeTrabajo().hashCode();
        }
        if (getResponsables() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getResponsables());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getResponsables(), i);
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
        new org.apache.axis.description.TypeDesc(EmpleadoResumen.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "empleadoResumen"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCap");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "idCap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "nombreUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEmpleado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "idEmpleado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prefijo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "prefijo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("puestosDeTrabajo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "puestosDeTrabajo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "searchResult"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responsables");
        elemField.setXmlName(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "responsables"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://empleado.entities.osde.com.ar", "responsable"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
