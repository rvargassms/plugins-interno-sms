/**
 * SearchEmpleadosResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.services.administracion.empleado;

public class SearchEmpleadosResponse  implements java.io.Serializable {
    private ar.com.osde.services.administracion.empleado.SearchResult searchResult;

    public SearchEmpleadosResponse() {
    }

    public SearchEmpleadosResponse(
           ar.com.osde.services.administracion.empleado.SearchResult searchResult) {
           this.searchResult = searchResult;
    }


    /**
     * Gets the searchResult value for this SearchEmpleadosResponse.
     * 
     * @return searchResult
     */
    public ar.com.osde.services.administracion.empleado.SearchResult getSearchResult() {
        return searchResult;
    }


    /**
     * Sets the searchResult value for this SearchEmpleadosResponse.
     * 
     * @param searchResult
     */
    public void setSearchResult(ar.com.osde.services.administracion.empleado.SearchResult searchResult) {
        this.searchResult = searchResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchEmpleadosResponse)) return false;
        SearchEmpleadosResponse other = (SearchEmpleadosResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.searchResult==null && other.getSearchResult()==null) || 
             (this.searchResult!=null &&
              this.searchResult.equals(other.getSearchResult())));
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
        if (getSearchResult() != null) {
            _hashCode += getSearchResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchEmpleadosResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "searchEmpleadosResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "SearchResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://osde.com.ar/services/administracion/empleado", "searchResult"));
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
