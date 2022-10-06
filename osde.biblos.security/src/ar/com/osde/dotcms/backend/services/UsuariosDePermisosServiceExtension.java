package ar.com.osde.dotcms.backend.services;

/**
 * @author ss94848846
 */
public interface UsuariosDePermisosServiceExtension{

    public String obtenerUsuarios(String permisos);
    public String obtenerUsuariosv2(String permisos);
    public String obtenerListadoDePermisos(String permiso);
    public String obtenerFilialesDePermiso(String permiso);
    public String obtenerUsuariosFilial(String permisos, String filial);
	public String getFilesUploadPath();
	public void setFilesUploadPath(String filesUploadPath); 
}