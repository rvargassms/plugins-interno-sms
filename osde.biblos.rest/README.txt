Plugin ROOT

Este plugin tiene por objetivo establecer las configuraciones que se requieren en OSDE para biblos.

Ejecutar desde el bin de dotcms_5.x.x:

	1: undeploy-plugins
	2: deploy-plugins

Sólo 2 directorios contienen configuraciones:

/conf

	dotmarketing-config-ext.properties: configuración del path de assets (para dejar de usar links simbólicos).

	/elasticsearch/config:

		elasticsearch-override.yml: configuración del nombre del cluster de elasticsearch.

/ROOT
	/bin
		startup.bat: lo importante en este archivo es la configuración del ambiente.

	/dotserver/tomcat-8.5.32
		
		/conf
			logging.properties: establece la política de rotación de los logs del tomcat.
			server.xml: entre otras configuraciones establece el puerto.
		
		/webapps/ROOT/META-INF
			
			context.xml: configuración del pool de conexiones a la base de datos. en los entornos controlados la clave del usuario de la base la estable el responsable y por ese motivo estará vacía o con basura en esta estructura.
			
	

