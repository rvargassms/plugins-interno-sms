package ar.com.osde.dotcms.frontend;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biblos.adapter.impl.LoginAdapterImpl;
import com.biblos.adapter.impl.UserAdapterImpl;
import com.biblos.bo.impl.LoginBoImpl;
import com.biblos.entities.IngresoEntity;
import com.biblos.reportes.ReporteIngreso;
import com.biblos.utils.CookieUtil;
import com.biblos.utils.LoginUrlUtils;
import com.dotmarketing.util.Logger;

import ar.com.osde.dotcms.cxf.datosPersonales.ws.model.bean.Usuario;
import ar.com.osde.dotcms.external.services.OsdeSecurityExternalService;
import ar.com.osde.dotcms.framework.resources.OsdeFrameworkServices;
import eu.bitwalker.useragentutils.UserAgent;

public class IntranetAutoLoginFilter implements Filter {

	private LoginBoImpl                 loginBo;
	private LoginAdapterImpl            loginBiblosAdapter;
	private OsdeSecurityExternalService osdeSecurityExternalService;
	private UserAdapterImpl             userAdapter;

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		loginBiblosAdapter          = new LoginAdapterImpl();
		osdeSecurityExternalService = OsdeFrameworkServices.OsdeSecurityExternalService();
		userAdapter                 = new UserAdapterImpl();
		loginBo                     = new LoginBoImpl();
		
		LoginUrlUtils.getAllPropertiesLoginOsde(); 
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		
		HttpServletRequest  request  = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		
		response.addHeader( "Access-Control-Allow-Origin"     , "*"                                            );
		response.addHeader( "Access-Control-Allow-Credentials", "true"                                         );
		response.setHeader( "Cache-Control"                   , "private, no-store, no-cache, must-revalidate" );
		response.setHeader( "Pragma"                          , "no-cache"                                     );

		// cuando se intenta acceder a un site y este no tiene permisos para el usuario anónimo, dot reenvía la petición al login del sitio.
		// en lugar tener una página de login implementamos este filtro que usamos para realizar el logueo de la intranet.
		// si se loguea lo reenviamos al recurso solicitado originalmente que viene tal como se muestra debajo.
		
		// ejemplo de request.
		// https://ippd01.intranet.osde:8443/dotCMS/login?referrer=/pages/pre-ipp/pre-ipp-inhibidores-de-la-angiogenesis.html
		
		String  pageRequested = request.getQueryString().substring( 9   );
		Usuario  userESB      = null;
		boolean  logged       = false;
		
	    CookieUtil cookieUtil = new CookieUtil();
	    cookieUtil.obtenerUsernameClave(request);
		
		Enumeration<String> headers = request.getHeaderNames();
		
		Logger.info(IntranetAutoLoginFilter.class, "::: "+ "Contenido Headers" +" :::");
		while (headers.hasMoreElements()) {
			String name = headers.nextElement();
			Logger.info(IntranetAutoLoginFilter.class, "::: "+ name + " = " + request.getHeader(name) +" :::");
		}
		
		Logger.info(IntranetAutoLoginFilter.class, "::: "+ "Cookie en memoria: " + cookieUtil.getCookieName() +" :::");
		
		try {
			
			userESB = osdeSecurityExternalService.getUserIntranet( cookieUtil.getUsername() );
			
			logged  = loginBiblosAdapter.doLogin( userESB, osdeSecurityExternalService.getPermisosDeUsuario( cookieUtil.getUsername() ), request, response, false );
			
			if( logged ) {
				
	 			ReporteIngreso.generarReporteIngreso( this.armarEntityIngreso(cookieUtil.getUsername(), request.getHeader("User-Agent") ) );
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		if( logged ) {
			
			response.sendRedirect( pageRequested );
					
		}else {
			response.sendRedirect( LoginUrlUtils.getREDIRECT_URL_AFLTER_LOGIN_FAILED() );
		}
		
		filterChain.doFilter(request, response);	
	}
	
	private IngresoEntity armarEntityIngreso(String username, String userAgentString) {
		
		//Obtener informacion del browser y dispositivo usado
		UserAgent userAgent = UserAgent.parseUserAgentString(userAgentString);
		
		Logger.info(LoginBoImpl.class, "Se pudo obtener userAgent desde userAgentString");
		
		IngresoEntity ingresoEntity = new IngresoEntity();
		
		ingresoEntity.setUsuarioMT(          username                                                 );
		ingresoEntity.setUsuarioNombre(      userAdapter.getUser(username).getFullName()              );
		ingresoEntity.setNavegador(          userAgent.getBrowser().getGroup().getName()              );
		ingresoEntity.setNavegadorVersion(   userAgent.getBrowserVersion().getVersion()               );
		ingresoEntity.setSistemaOperativo(   userAgent.getOperatingSystem().getName()                 );
		ingresoEntity.setDispositivoIngreso( userAgent.getOperatingSystem().getDeviceType().getName() );
		
		return ingresoEntity;
	}

	@Override
	public void destroy() {
	}
}
