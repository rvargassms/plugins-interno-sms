/**
 * UsuarioHttpBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario;

import javax.xml.soap.SOAPException;

import org.apache.axis.message.SOAPHeaderElement;

public class UsuarioHttpBindingStub extends org.apache.axis.client.Stub implements ar.com.osde.dotcms.cxf.datosPersonales.intranet.usuario.Usuario_PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[14];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUsuarioPorDNI");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "dni"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://common.entities.osde.com.ar", "Usuario"));
        oper.setReturnClass(ar.com.osde.dotcms.cxf.datosPersonales.entities.common.Usuario.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerDatosPersonalesPorClave");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "clave"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Usuario"));
        oper.setReturnClass(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUsuarioPorUsername");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "nombreUsuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://common.entities.osde.com.ar", "Usuario"));
        oper.setReturnClass(ar.com.osde.dotcms.cxf.datosPersonales.entities.common.Usuario.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerDatosPersonales");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "nombreUsuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Usuario"));
        oper.setReturnClass(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerUsuarios1");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "codigoJerarquico"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "porcionNombreApellido"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "ArrayOfUsuario"));
        oper.setReturnClass(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "out"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Usuario"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerUsuarios2");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "codigoFilial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "puestos"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://usuario.intranet.osde/", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "string"));
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "ArrayOfUsuario"));
        oper.setReturnClass(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "out"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Usuario"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Obtener");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "userName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "jerar"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "idModulo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "ArrayOfMenuAplicacion"));
        oper.setReturnClass(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.MenuAplicacion[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "out"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "MenuAplicacion"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerUsuarios3");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "codigoFilial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "puestos"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://usuario.intranet.osde/", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "string"));
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "codigoCap"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "ArrayOfUsuario"));
        oper.setReturnClass(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "out"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Usuario"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerUsuarios4");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "codigoJerarquico"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "porcionNombreApellido"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "numeroPagina"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "cantidadRegistrosPorPagina"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "ArrayOfUsuario"));
        oper.setReturnClass(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "out"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Usuario"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerUsuarios5");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "codigoFilial"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "puestos"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://usuario.intranet.osde/", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "string"));
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "codigoCap"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "filtroNombreyApellido"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "ArrayOfUsuario"));
        oper.setReturnClass(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "out"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Usuario"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUsuarios");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "porcionNombreApellido"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "numeroPagina"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "cantidadRegistrosPorPagina"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://common.entities.osde.com.ar", "ArrayOfUsuario"));
        oper.setReturnClass(ar.com.osde.dotcms.cxf.datosPersonales.entities.common.Usuario[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "out"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://common.entities.osde.com.ar", "Usuario"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerUsuarios");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "puestos"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://usuario.intranet.osde/", "ArrayOfString"), java.lang.String[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "string"));
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "ArrayOfUsuario"));
        oper.setReturnClass(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "out"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Usuario"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ObtenerDatosPersonalesPorDNI");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "dni"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Usuario"));
        oper.setReturnClass(ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "out"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SolicitudPassword");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "email"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

    }

    public UsuarioHttpBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public UsuarioHttpBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public UsuarioHttpBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Aplicacion");
            cachedSerQNames.add(qName);
            cls = ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Aplicacion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "ArrayOfAplicacion");
            cachedSerQNames.add(qName);
            cls = ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Aplicacion[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Aplicacion");
            qName2 = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Aplicacion");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "ArrayOfCap");
            cachedSerQNames.add(qName);
            cls = ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Cap[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Cap");
            qName2 = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Cap");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "ArrayOfMenuAplicacion");
            cachedSerQNames.add(qName);
            cls = ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.MenuAplicacion[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "MenuAplicacion");
            qName2 = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "MenuAplicacion");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "ArrayOfPuesto");
            cachedSerQNames.add(qName);
            cls = ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Puesto[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Puesto");
            qName2 = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Puesto");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "ArrayOfUsuario");
            cachedSerQNames.add(qName);
            cls = ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Usuario");
            qName2 = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Usuario");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Cap");
            cachedSerQNames.add(qName);
            cls = ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Cap.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Direccion");
            cachedSerQNames.add(qName);
            cls = ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Direccion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Edificio");
            cachedSerQNames.add(qName);
            cls = ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Edificio.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Empresa");
            cachedSerQNames.add(qName);
            cls = ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Empresa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Filial");
            cachedSerQNames.add(qName);
            cls = ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Filial.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Localidad");
            cachedSerQNames.add(qName);
            cls = ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Localidad.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "MenuAplicacion");
            cachedSerQNames.add(qName);
            cls = ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.MenuAplicacion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Provincia");
            cachedSerQNames.add(qName);
            cls = ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Provincia.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Puesto");
            cachedSerQNames.add(qName);
            cls = ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Puesto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://bean.model.ws.osde.com.ar", "Usuario");
            cachedSerQNames.add(qName);
            cls = ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://common.entities.osde.com.ar", "ArrayOfUsuario");
            cachedSerQNames.add(qName);
            cls = ar.com.osde.dotcms.cxf.datosPersonales.entities.common.Usuario[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://common.entities.osde.com.ar", "Usuario");
            qName2 = new javax.xml.namespace.QName("http://common.entities.osde.com.ar", "Usuario");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://common.entities.osde.com.ar", "Usuario");
            cachedSerQNames.add(qName);
            cls = ar.com.osde.dotcms.cxf.datosPersonales.entities.common.Usuario.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://usuario.intranet.osde/", "ArrayOfString");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://usuario.intranet.osde/", "string");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public ar.com.osde.dotcms.cxf.datosPersonales.entities.common.Usuario getUsuarioPorDNI(java.lang.String dni) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "getUsuarioPorDNI"));
        SOAPHeaderElement header = new SOAPHeaderElement("service.framework.osde.com.ar","appName","GRGDOTCMS");
        header.setActor(null);
        header.setMustUnderstand(false);
        header.removeNamespaceDeclaration("soapenv");
        _call.addHeader(header);
        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dni});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.osde.dotcms.cxf.datosPersonales.entities.common.Usuario) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.osde.dotcms.cxf.datosPersonales.entities.common.Usuario) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.osde.dotcms.cxf.datosPersonales.entities.common.Usuario.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario obtenerDatosPersonalesPorClave(java.lang.String clave) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "ObtenerDatosPersonalesPorClave"));
        SOAPHeaderElement header = new SOAPHeaderElement("service.framework.osde.com.ar","appName","GRGDOTCMS");
        header.setActor(null);
        header.removeNamespaceDeclaration("soapenv");
        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {clave});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.osde.dotcms.cxf.datosPersonales.entities.common.Usuario getUsuarioPorUsername(java.lang.String nombreUsuario) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "getUsuarioPorUsername"));
        SOAPHeaderElement header = new SOAPHeaderElement("service.framework.osde.com.ar","appName","GRGDOTCMS");
        header.setActor(null);
        header.removeNamespaceDeclaration("soapenv");
        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {nombreUsuario});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.osde.dotcms.cxf.datosPersonales.entities.common.Usuario) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.osde.dotcms.cxf.datosPersonales.entities.common.Usuario) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.osde.dotcms.cxf.datosPersonales.entities.common.Usuario.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario obtenerDatosPersonales(java.lang.String nombreUsuario) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "ObtenerDatosPersonales"));
       SOAPHeaderElement header = new SOAPHeaderElement("service.framework.osde.com.ar","appName","GRGDOTCMS");
       _call.addHeader(header);
        header.setActor(null);
        setRequestHeaders(_call);
        setAttachments(_call);
        
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {nombreUsuario});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[] obtenerUsuarios1(java.lang.String codigoJerarquico, java.lang.String porcionNombreApellido) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "ObtenerUsuarios1"));
        SOAPHeaderElement header = new SOAPHeaderElement("service.framework.osde.com.ar","appName","GRGDOTCMS");
        header.setActor(null);
        _call.addHeader(header);
        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {codigoJerarquico, porcionNombreApellido});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[] obtenerUsuarios2(java.lang.String codigoFilial, java.lang.String[] puestos) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "ObtenerUsuarios2"));
        SOAPHeaderElement header = new SOAPHeaderElement("service.framework.osde.com.ar","appName","GRGDOTCMS");
        header.setActor(null);
        _call.addHeader(header);
        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {codigoFilial, puestos});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.MenuAplicacion[] obtener(java.lang.String userName, java.lang.String jerar, int idModulo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "Obtener"));
        SOAPHeaderElement header = new SOAPHeaderElement("service.framework.osde.com.ar","appName","GRGDOTCMS");
        header.setActor(null);
        _call.addHeader(header);
        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {userName, jerar, new java.lang.Integer(idModulo)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.MenuAplicacion[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.MenuAplicacion[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.MenuAplicacion[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[] obtenerUsuarios3(java.lang.String codigoFilial, java.lang.String[] puestos, java.lang.String codigoCap) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "ObtenerUsuarios3"));
        SOAPHeaderElement header = new SOAPHeaderElement("service.framework.osde.com.ar","appName","GRGDOTCMS");
        header.setActor(null);
        _call.addHeader(header);
        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {codigoFilial, puestos, codigoCap});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[] obtenerUsuarios4(java.lang.String codigoJerarquico, java.lang.String porcionNombreApellido, int numeroPagina, int cantidadRegistrosPorPagina) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "ObtenerUsuarios4"));
        SOAPHeaderElement header = new SOAPHeaderElement("service.framework.osde.com.ar","appName","GRGDOTCMS");
        header.setActor(null);
        _call.addHeader(header);
        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {codigoJerarquico, porcionNombreApellido, new java.lang.Integer(numeroPagina), new java.lang.Integer(cantidadRegistrosPorPagina)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[] obtenerUsuarios5(java.lang.String codigoFilial, java.lang.String[] puestos, java.lang.String codigoCap, java.lang.String filtroNombreyApellido) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "ObtenerUsuarios5"));
        SOAPHeaderElement header = new SOAPHeaderElement("service.framework.osde.com.ar","appName","GRGDOTCMS");
        header.setActor(null);
        _call.addHeader(header);
        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {codigoFilial, puestos, codigoCap, filtroNombreyApellido});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.osde.dotcms.cxf.datosPersonales.entities.common.Usuario[] getUsuarios(java.lang.String porcionNombreApellido, int numeroPagina, int cantidadRegistrosPorPagina) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "getUsuarios"));
        SOAPHeaderElement header = new SOAPHeaderElement("service.framework.osde.com.ar","appName","GRGDOTCMS");
        header.setActor(null);
        _call.addHeader(header);
        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {porcionNombreApellido, new java.lang.Integer(numeroPagina), new java.lang.Integer(cantidadRegistrosPorPagina)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.osde.dotcms.cxf.datosPersonales.entities.common.Usuario[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.osde.dotcms.cxf.datosPersonales.entities.common.Usuario[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.osde.dotcms.cxf.datosPersonales.entities.common.Usuario[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[] obtenerUsuarios(java.lang.String[] puestos) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "ObtenerUsuarios"));
        SOAPHeaderElement header = new SOAPHeaderElement("service.framework.osde.com.ar","appName","GRGDOTCMS");
        header.setActor(null);
        _call.addHeader(header);
        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {puestos});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[]) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario obtenerDatosPersonalesPorDNI(java.lang.String dni) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "ObtenerDatosPersonalesPorDNI"));
        SOAPHeaderElement header = new SOAPHeaderElement("service.framework.osde.com.ar","appName","GRGDOTCMS");
        header.setActor(null);
        _call.addHeader(header);
        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dni});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario) _resp;
            } catch (java.lang.Exception _exception) {
                return (ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario) org.apache.axis.utils.JavaUtils.convert(_resp, ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void solicitudPassword(java.lang.String email) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://usuario.intranet.osde/", "SolicitudPassword"));
        SOAPHeaderElement header = new SOAPHeaderElement("service.framework.osde.com.ar","appName","GRGDOTCMS");
        header.setActor(null);
        _call.addHeader(header);
        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {email});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
