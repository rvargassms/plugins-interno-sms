package com.biblos.services.rest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dotcms.rest.config.RestServiceUtil;

public class OsdeRestServicesLoader extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		this.registrarServicios();
	}
    
    private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.registrarServicios();
	}
    
    public void registrarServicios() {
		this.registrarServicio(PermisosRestService.class);
		this.registrarServicio(HostPermissionsRestService.class);
		this.registrarServicio(ContentRestService.class);
		this.registrarServicio(WorkflowRestService.class);
		this.registrarServicio(ProcesosRestService.class);
		this.registrarServicio(PagesPermissionsRestService.class);
		this.registrarServicio(LoggerRestService.class);
    }
	
	private void registrarServicio(Class<?> clase) {
		RestServiceUtil.addResource(clase);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doAction(request, response);
	}

}
