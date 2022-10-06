package com.dotmarketing.portlets.workflows.config;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.dotcms.IntegrationTestBase;
import com.dotcms.contenttype.business.ContentTypeAPIImpl;
import com.dotcms.contenttype.business.FieldAPI;
import com.dotcms.util.IntegrationTestInitService;
import com.dotmarketing.beans.Host;
import com.dotmarketing.business.APILocator;
import com.dotmarketing.business.PermissionAPI;
import com.dotmarketing.business.RoleAPI;
import com.dotmarketing.exception.DotDataException;
import com.dotmarketing.exception.DotSecurityException;
import com.dotmarketing.portlets.contentlet.business.ContentletAPI;
import com.dotmarketing.portlets.contentlet.business.HostAPI;
import com.dotmarketing.portlets.hostvariable.bussiness.HostVariableAPI;
import com.dotmarketing.portlets.hostvariable.model.HostVariable;
import com.dotmarketing.portlets.workflows.business.WorkflowAPI;
import com.dotmarketing.portlets.workflows.business.WorkflowCache;
import com.dotmarketing.util.UUIDGenerator;
import com.liferay.portal.model.User;

public class HostVariableTest extends IntegrationTestBase {
    private static User user;
    private static Host defaultHost;
    protected static ContentTypeAPIImpl contentTypeAPI;
    protected static FieldAPI fieldAPI;
    protected static WorkflowAPI workflowAPI;
    protected static RoleAPI roleAPI;
    protected static PermissionAPI permissionAPI;
    protected static ContentletAPI contentletAPI;
    protected static WorkflowCache workflowCache;
    
	protected static HostAPI hostAPI;
	protected static HostVariableAPI hostVariableAPI;
	protected static String enviroment;

	
//	enum HostVariable
//	{
//		FICHAS = Fichas, VERDE, AZUL;
//	}
	
	@BeforeClass
    public static void prepare() throws Exception {
        //Setting web app environment
        IntegrationTestInitService.getInstance().init();

        hostAPI = APILocator.getHostAPI();
        hostVariableAPI = APILocator.getHostVariableAPI();
        user = APILocator.getUserAPI().getSystemUser(); 
        enviroment= whoEnviroment();        
        
    }
	
	
	@Test
	public void configAllHostVariable() {

		List<Host> hosts = null;		

		try {
			hosts = hostAPI.findAllFromDB(user, false);
		} catch (DotDataException | DotSecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		

		for (Host host : hosts) {

			List<HostVariable> listHostVariableForHost = null;

			try {
				listHostVariableForHost = hostVariableAPI.getVariablesForHost(host.getStringProperty("identifier"),
						user, false);
			} catch (DotDataException | DotSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			updateHostVariables(listHostVariableForHost);
		}

	}
	
	@Test
    public void configHostVariableBuscador() {
		List<Host> hosts = null;
		String nameHVarBuscador = "buscador";

		try {
			hosts = hostAPI.findAllFromDB(user, false);
		} catch (DotDataException | DotSecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for (Host host:hosts){
			
		List<HostVariable> listHostVariableForHost = null;
		
		try {
			listHostVariableForHost = hostVariableAPI.getVariablesForHost(host.getStringProperty("identifier"),
					user, false);
		} catch (DotDataException | DotSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		if (!existHostVariable(listHostVariableForHost, nameHVarBuscador)) {
			String valueHVarBuscador = HostVariableConstants.SCHEME_HTTPS.concat(HostVariableConstants.BUSCADOR).concat(enviroment).concat(HostVariableConstants.SUB_DOMAIN).concat("/buscador");
			HostVariable hostVariable = new HostVariable();
			hostVariable.setHostId(host.getStringProperty("identifier"));
			hostVariable.setName(nameHVarBuscador);
			hostVariable.setKey("BuscadorAppSearch");
			hostVariable.setValue(valueHVarBuscador);
			hostVariable.setLastModifierId(user.getUserId());
			hostVariable.setLastModDate(new Date());

			try {
				hostVariableAPI.save(hostVariable, user, false);
			} catch (DotDataException | DotSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("No se creo la host_variable " + nameHVarBuscador + " porque ya existe para el host " + host.getStringProperty("description"));
		}			
		
		}
		
	}
    
	
	protected static void updateHostVariables(List<HostVariable> listHostVariableForHost) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map = createMapValueUrl();
		
		for (HostVariable hostVariable : listHostVariableForHost) {			

			switch (hostVariable.getName()) {
			case HostVariableConstants.FICHAS:
				hostVariable.setValue(map.get(HostVariableConstants.FICHAS));
				hostVariable.setLastModDate(new Date());
				break;			
			case HostVariableConstants.MAP:
				hostVariable.setValue(map.get(HostVariableConstants.MAP));
				hostVariable.setLastModDate(new Date());
				break;	
			case HostVariableConstants.SOPORTE:
				hostVariable.setValue(map.get(HostVariableConstants.SOPORTE));
				hostVariable.setLastModDate(new Date());
				break;	
			case HostVariableConstants.URGENCIAS:
				hostVariable.setValue(map.get(HostVariableConstants.URGENCIAS));
				hostVariable.setLastModDate(new Date());
				break;	
			case HostVariableConstants.SHARED:
				hostVariable.setValue(map.get(HostVariableConstants.SHARED));
				hostVariable.setLastModDate(new Date());
				break;	
			case HostVariableConstants.NOVEDADES:
				hostVariable.setValue(map.get(HostVariableConstants.NOVEDADES));
				hostVariable.setLastModDate(new Date());
				break;	
			case HostVariableConstants.IPP:
				hostVariable.setValue(map.get(HostVariableConstants.IPP));
				hostVariable.setLastModDate(new Date());
				break;	
			case HostVariableConstants.CAT:
				hostVariable.setValue(map.get(HostVariableConstants.CAT));
				hostVariable.setLastModDate(new Date());
				break;	
			case HostVariableConstants.PAN:
				hostVariable.setValue(map.get(HostVariableConstants.PAN));
				hostVariable.setLastModDate(new Date());
				break;
			}

			try {
				hostVariableAPI.save(hostVariable, user, false);
			} catch (DotDataException | DotSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	protected static boolean existHostVariable(List<HostVariable> listHostVariableForHost, String nameNewHostVariable) {
		for (HostVariable hostVariable : listHostVariableForHost) {
			if (hostVariable.getName().contentEquals(nameNewHostVariable)) 
				return true;
		}
		return false;
	}
	
	protected static Map<String, String> createMapValueUrl() {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put(HostVariableConstants.FICHAS, HostVariableConstants.SCHEME_HTTPS + "fichas" + enviroment + HostVariableConstants.SUB_DOMAIN);
		map.put(HostVariableConstants.MAP, HostVariableConstants.SCHEME_HTTPS + "csp" + enviroment + HostVariableConstants.SUB_DOMAIN);
		map.put(HostVariableConstants.SOPORTE, HostVariableConstants.SCHEME_HTTPS + "soporte" + enviroment + HostVariableConstants.SUB_DOMAIN);
		map.put(HostVariableConstants.URGENCIAS, HostVariableConstants.SCHEME_HTTPS + "urgencias" + enviroment + HostVariableConstants.SUB_DOMAIN);
		map.put(HostVariableConstants.SHARED, HostVariableConstants.SCHEME_HTTPS + "biblos" + enviroment + HostVariableConstants.SUB_DOMAIN_SHARED);
		map.put(HostVariableConstants.NOVEDADES, HostVariableConstants.SCHEME_HTTPS + "novedades" + enviroment + HostVariableConstants.SUB_DOMAIN);
		map.put(HostVariableConstants.IPP, HostVariableConstants.SCHEME_HTTPS + "ipp" + enviroment + HostVariableConstants.SUB_DOMAIN);
		map.put(HostVariableConstants.CAT, HostVariableConstants.SCHEME_HTTPS + "cds" + enviroment + HostVariableConstants.SUB_DOMAIN);
		map.put(HostVariableConstants.PAN, HostVariableConstants.SCHEME_HTTPS + "pan" + enviroment + HostVariableConstants.SUB_DOMAIN);
		
		return map;
	}
	
    /**
     * This method use host default to know the current enviroment. Extracts the chars beetween biblos and the first point. With this the enviroment is determined.
     * @return the enviroment
     */
	protected static String whoEnviroment() {
		Host hostdefault = null;
		String enviroment = "l";
		String hostDefaultAlias;
		int x, z;

		try {
			hostdefault = hostAPI.findDefaultHost(user, false);
		} catch (DotDataException | DotSecurityException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		hostDefaultAlias = "biblos.intranet.osde";

		if (hostDefaultAlias.indexOf(HostVariableConstants.BIBLOS) != -1
				&& hostDefaultAlias.indexOf(".") != -1) {
			x = hostDefaultAlias.indexOf(HostVariableConstants.BIBLOS) + HostVariableConstants.BIBLOS.length()
					- 1;
			z = hostDefaultAlias.indexOf(".");

			char entorno[] = new char[z - x - 1];
			hostDefaultAlias.getChars(x + 1, z, entorno, 0);

			enviroment = String.valueOf(entorno);

		} else {
			System.out.println("No se pudo determinar el enviroment. Se determino " + enviroment + " por defecto");
		}

		return enviroment;
	}

}
