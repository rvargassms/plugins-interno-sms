<%@page import="com.biblos.bo.PermisosBO"%>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">

function sincronizarUsuarios(){
	jQuery('#sincronizarUsuariosLbl').html("Sincronizando usuarios...");
	jQuery(':button').prop('disabled', true);
	jQuery.ajax({
      xhrFields: { withCredentials: true},
      url : window.location.protocol + '//' + window.location.host + '/api/permisosRestService/ejecutarSincronizarPermisos',
      type : 'POST',
      dataType : 'text',
      success : function(data) {
    	  if(data == "OK") jQuery('#sincronizarUsuariosLbl').html("Se han sincronizado los usuarios");
    	  jQuery(':button').prop('disabled', false)
      },
      error : function(){
    	  jQuery('#sincronizarUsuariosLbl').html("Error al sincronizar los usuarios");
    	  jQuery(':button').prop('disabled', false)
      }
    }); 
}

function sincronizarUsuario(userIntra){
	jQuery('#sincronizarUsuariosLbl2').html("Sincronizando al usuario " + userIntra);
	jQuery(':button').prop('disabled', true);
	jQuery.ajax({
      xhrFields: { withCredentials: true},
      url : window.location.protocol + '//' + window.location.host + '/api/permisosRestService/ejecutarSincronizarUsuario',
      type : 'POST',
      data : jQuery.param({username: userIntra}),
      dataType : 'text',
      success : function(data) {
    	  if(data == "OK") {
	    	  jQuery('#sincronizarUsuariosLbl2').html("Se ha sincronizado al usuario");
	    	  jQuery(':button').prop('disabled', false)
    	  } else {    		  
	    	  jQuery('#sincronizarUsuariosLbl2').html("No se ha podido sincronizar al usuario");
	    	  jQuery(':button').prop('disabled', false)
    	  }
      },
      error : function(){
    	  jQuery('#sincronizarUsuariosLbl2').html("Error al sincronizar al usuario");
    	  jQuery(':button').prop('disabled', false)
      }
    }); 
}

function mostrarEstadoToggle(msg){
	jQuery('#leyendaLBL').html(msg);
	jQuery('#btnLeyenda').prop('disabled', false);
}


function desbloquearContenidos(){
	jQuery('#desbloquearContenidosLbl').html("Desbloqueando...");
	jQuery(':button').prop('disabled', true);
    jQuery.ajax({
      xhrFields: { withCredentials: true},
      url : window.location.protocol + '//' + window.location.host + '/api/procesosRestService/desbloquearContenidos',
      type : 'POST',
      dataType : 'text',
      success : function(data) {
    	  if(data == "OK") jQuery('#desbloquearContenidosLbl').html("Se han desbloqueado las p\u00E1ginas y contenidos");
    	  jQuery(':button').prop('disabled', false);
      },
      error : function(){
    	  jQuery('#desbloquearContenidosLbl').html("Error al desbloquear p\u00E1ginas y contenidos");
    	  jQuery(':button').prop('disabled', false)
      }
    }); 
}
</script>

<style>
.btn-leyenda {
	padding: 3px;
	color: #555555;
    padding: 1px;
    padding-left: 5px;
    padding-right: 5px;
    margin: 2em 2em;
}

.btn-leyenda-on {
	background: linear-gradient(#db5959, #CE3636);
	color: white;
	border-color: #555555;
}
</style>
<div style="margin: 5em;">	
	<ul>		
		<li>
			<div></br></br>
				<h2>Sincronizaci&oacute;n de usuarios y permisos Osde</h3>
				<ol>
					<li>Se sincronizar&aacute;n todos los usuarios que tengan acceso
						a la herramienta dotCMS con sus permisos asociados.</li>
					<li>Este proceso podr&iacute;a demorar unos minutos.</li>
				</ol>
				</br>				
				<button class="btn-leyenda" onclick="sincronizarUsuarios()">Sincronizar</button> <h3 id="sincronizarUsuariosLbl"></h3>					
			</div>
		</li>
		
		<li>
			<div></br></br>
				<h3>Sincronizar a un usuario</h3>
				<ol>
					<li>Se sincronizará el usuario ingresado en el campo de texto</li>
				</ol>
				</br>					
					<label>usuario:
    					<input type='text' name='userIntra' id='userIntra'>
					</label>
					<button class="btn-leyenda" onclick="sincronizarUsuario(document.getElementById('userIntra').value)">Sincronizar</button> <h3 id="sincronizarUsuariosLbl2"></h3>
			</div>
		</li>	
		<li>
			<div></br></br>
				<h3>Desbloqueo de contenidos</h3>
				<ol>
					<li>Desbloquear p&aacute;ginas y contenidos bloqueados</li>
				</ol>
				</br>				
				<button onclick="desbloquearContenidos()">Desbloquear</button><h3 id="desbloquearContenidosLbl"></h3>
			</div>
		</li>	
	</ul>		
</div>
