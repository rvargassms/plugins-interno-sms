<%@page import="com.dotmarketing.beans.Host"%>
<%@page import="com.dotmarketing.business.web.WebAPILocator"%>
<%@page import="com.dotcms.enterprise.LicenseUtil"%>
<%@page import="com.dotmarketing.util.Config"%>
<%@page import="com.dotmarketing.util.UtilMethods"%>
<%@page import="com.dotmarketing.util.InodeUtils"%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.dotmarketing.filters.CMSUrlUtil"%>
<%@page import="com.dotcms.enterprise.license.LicenseLevel"%>
<% User userb= com.liferay.portal.util.PortalUtil.getUser(request); %>

<% 
String cssPath = Config.getStringProperty("WYSIWYG_CSS", "/application/wysiwyg/wysiwyg.css");
Host host = WebAPILocator.getHostWebAPI().getCurrentHostNoThrow(request);
if(!CMSUrlUtil.getInstance().amISomething(cssPath, host, WebAPILocator.getLanguageWebAPI().getLanguage(request).getId())){
  cssPath=null;
}
%>

var tinymceEdited = false;
var saveFunction = false;
var publishFunction = false;

var tinyMCEProps = 
{	
			theme: "modern",
			selector: "textarea",
    		menubar: true,
    		statusbar: true,
    		resize: "both",
			height: 500,
			 
			object_resizing : ":not(.panel)",
			
			menu: {
				file: { title: 'File', items: 'newdocument restoredraft | preview | print ' },
				edit: { title: 'Edit', items: 'undo redo | cut copy paste | selectall | searchreplace' },
				view: { title: 'View', items: 'code | visualaid visualchars visualblocks | spellchecker | preview fullscreen' },
				insert: { title: 'Insert', items: 'image link media template codesample inserttable | charmap emoticons hr | pagebreak nonbreaking anchor toc | insertdatetime' },
				format: { title: 'Format', items: 'bold italic underline strikethrough superscript subscript codeformat | formats blockformats fontformats fontsizes align | forecolor backcolor | removeformat' },
				table: { title: 'Table', items: 'inserttable | cell row column | tableprops deletetable' },
				tools: { title: 'Tools', items: 'code wordcount spellchecker spellcheckerlanguage clipboard dotimageclipboard cloak Cloak tableCloak highlighter tabla tab' },
				help: { title: 'Help', items: 'help' },
			},

			style_formats: [
				{title: "Formatos OSDE", items: [
					{title: 'Titulo', block: 'h1', 'classes' : 'h1-osde'},
					{title: 'Subtitulo', block: 'h2', 'classes' : 'h2-osde'},
					{title: 'Cuerpo', block: 'p', 'classes' : 'p-osde'},
				]},
				{title: "Headers", items: [
					{title: "Header 1", format: "h1"},
					{title: "Header 2", format: "h2"},
					{title: "Header 3", format: "h3"},
					{title: "Header 4", format: "h4"},
					{title: "Header 5", format: "h5"},
					{title: "Header 6", format: "h6"}
				]},
				{title: "Inline", items: [
					{title: "Bold", icon: "bold", format: "bold"},
					{title: "Italic", icon: "italic", format: "italic"},
					{title: "Underline", icon: "underline", format: "underline"},
					{title: "Strikethrough", icon: "strikethrough", format: "strikethrough"},
					{title: "Superscript", icon: "superscript", format: "superscript"},
					{title: "Subscript", icon: "subscript", format: "subscript"},
					{title: "Code", icon: "code", format: "code"}
				]},
				{title: "Blocks", items: [
					{title: "Paragraph", format: "p"},
					{title: "Blockquote", format: "blockquote"},
					{title: "Div", format: "div"},
					{title: "Pre", format: "pre"}
				]},
				{title: "Alignment", items: [
					{title: "Left", icon: "alignleft", format: "alignleft"},
					{title: "Center", icon: "aligncenter", format: "aligncenter"},
					{title: "Right", icon: "alignright", format: "alignright"},
					{title: "Justify", icon: "alignjustify", format: "alignjustify"}
				]}
			],
			
    		plugins: [
        		"advlist anchor autolink lists link_osde image charmap print preview hr anchor pagebreak",
				"searchreplace wordcount visualblocks visualchars code fullscreen",
				"insertdatetime media nonbreaking save contextmenu directionality",
				"emoticons template paste textcolor spellchecker colorpicker textpattern",
				"validation dotimageclipboard compat3x cloak highlighter tab noneditable", 
				"table"
    		],

            //block_formats: 'Paragraph=p;Header 1=h1;Header 2=h2;Header 3=h3;Header 4=h4;Header 5=h5;Pre=pre;Code=code;Remove Format=removeformat',
			
			block_formats: 'Paragraph=p;Blockquote=blockquote;Pre=pre;Div=div',
			
			content_css: "/html/css/osde-custom-styles.css, /html/css/bootstrap.min.css",
			
			toolbar1: "Cloak tab table-proc | maquetas | styleselect | bold italic underline strikethrough |  alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | image dotimageclipboard  | link_osde unlink | anchor | removeformat | forecolor spellchecker",

			spellchecker_language : "en_US",
			spellchecker_languages : "English=en_US,Español=es_ES",
			spellchecker_rpc_url : "/servlets/jmyspell-spellchecker",
    		paste_auto_cleanup_on_paste : true,
            paste_strip_class_attributes : "all",
            convert_urls : true,
            cleanup : true,
			noneditable_leave_contenteditable: true,
            urlconverter_callback : cmsURLConverter,
            verify_css_classes : false,
            
			
			
			
            trim_span_elements : false,
            apply_source_formatting : true,
            valid_elements : "*[*]",
            relative_urls : true,
			document_base_url : "/",
			plugin_insertdate_dateFormat : "%Y-%m-%d",
            plugin_insertdate_timeFormat : "%H:%M:%S",
            paste_use_dialog : true,
            gecko_spellcheck : true,
    		image_advtab: true,
            browser_spellcheck: true,
            image_caption: true,
    		file_picker_callback: function(callback, value, meta) {
    			cmsFileBrowser(callback, value, meta);
    		},
			
			setup : function(ed) {
				
				ed.on("keydown",function(e) {
					//Prevent tab on .panel
					if (e.keyCode == 9  && jQuery(ed.selection.getNode()).parents('.panel')[0])
						return false;
				});

				ed.addButton('table-proc', {
					title : 'Tabla Procedimiento',
					icon: 'mce-ico mce-i-table',
					onclick : function() {
						ed.focus();
						ed.selection.setContent("<table id='TBL1422528891208' class='confluenceTable' style='font-size: 13.3333330154419px; line-height: 17.3333339691162px; color: #666666; clear: left; margin: 5px 0px; border-collapse: collapse; padding: 0px; font-family: Helvetica, Arial, sans-serif; background-image: none; background-attachment: initial; background-size: initial; background-origin: initial; background-clip: initial; background-position: initial; background-repeat: initial;'><tbody><tr style='font-size: 10pt; line-height: 13pt; background: none;'><th class='confluenceTh' width='10px;&amp;quot;' style='font-size: 10pt; line-height: 13pt; border: 1px solid #dddddd; padding: 5px; vertical-align: top; min-width: 0.6em; color: #003c79; background-color: #f0f0f0;'>&nbsp;</th><th class='confluenceTh' width='220px;&amp;quot;' style='font-size: 10pt; line-height: 13pt; border: 1px solid #dddddd; padding: 5px; vertical-align: top; min-width: 0.6em; color: #003c79; background-color: #f0f0f0;'><div class='' align='center'>Actividad</div></th><th class='confluenceTh' width='500px;&amp;quot;' style='font-size: 10pt; line-height: 13pt; border: 1px solid #dddddd; padding: 5px; vertical-align: top; min-width: 0.6em; color: #003c79; background-color: #f0f0f0;'><div class='' align='center'>Descripci&oacute;n</div></th><th class='confluenceTh' width='150px;&amp;quot;' style='font-size: 10pt; line-height: 13pt; border: 1px solid #dddddd; padding: 5px; vertical-align: top; min-width: 0.6em; color: #003c79; background-color: #f0f0f0;'><div class='' align='center'>Puesto</div></th></tr><tr style='font-size: 10pt; line-height: 13pt; background: none;'><td class='confluenceTd' width='10px;&amp;quot;' style='font-size: 10pt; line-height: 13pt; border: 1px solid #dddddd; padding: 5px; vertical-align: top; min-width: 0.6em; background: none;'><div class='' align='center'>1</div></td><td class='confluenceTd' width='220px;&amp;quot;' style='font-size: 10pt; line-height: 13pt; cursor: pointer; border: 1px solid #dddddd; padding: 5px; vertical-align: top; min-width: 0.6em; background: none;'></td><td class='confluenceTd' width='500px;&amp;quot;' style='font-size: 10pt; line-height: 13pt; border: 1px solid #dddddd; padding: 5px; vertical-align: top; min-width: 0.6em; background: none;'></td><td class='confluenceTd' width='150px;&amp;quot;' style='font-size: 10pt; line-height: 13pt; border: 1px solid #dddddd; padding: 5px; vertical-align: top; min-width: 0.6em; background: none;'></td></tr></tbody></table>");
					}
				});
							
				//Inits cloak button for opening and closing the cloak
				ed.initCloaks = function(e){
				   jQuery(getIframeId("body_ifr")).on("click",".cloakOpen",function(){
						openEditorCloak(this);
				   });
				   jQuery(getIframeId("body_ifr")).on("click",".cloakClose",function(){
						closeEditorCloak(this);
				   });
				   
				   jQuery(getIframeId("body_ifr")).on("click",".table-cloak-open",function(){
						openEditorTableCloak(this);
				   });
				   jQuery(getIframeId("body_ifr")).on("click",".table-cloak-close",function(){
						closeEditorTableCloak(this);
				   });
			   }; 
			   ed.on("init", this.initCloaks);
			   
			   //Inits the delete panel button (cloak & tab)
			   ed.deletePanel = function(e){
				  jQuery(getIframeId("body_ifr")).on("click",".delete-panel",function(a){
						   var panel = jQuery(a.target).parents('.panel')[0];
						   var panelHeading = jQuery(a.target).parents('.panel-heading')[0];
						   tinymce.activeEditor.windowManager.confirm("Desea eliminar el contenedor '"+ jQuery(panelHeading).text() +"' ?", function(bool) {
							   if (bool) jQuery(panel).remove();
							});
						});
				   }  
				ed.on("init", this.deletePanel);
				
				//Inits panels for editing (cloak & tab)
				ed.initPanels = function(e){
					transformationsToEditorView();
				}  
				ed.on("init", this.initPanels);            
			}
		};		

	/** Regular Cloak opening and closing **/

		function closeEditorCloak(imgElement) {
			jQuery(imgElement).hide().siblings().show();
			jQuery(imgElement).parent().addClass("icon-cloak-closed");
			jQuery(imgElement).parent().removeClass("icon-cloak-open");
			jQuery(jQuery(jQuery(imgElement).parents(".cloak")[0]).find(".ocultable")[0])
				.css("background","#F0F0F0")
				.css("color","#555");
		}

		function openEditorCloak(imgElement) {
			jQuery(imgElement).hide().siblings().show();
			jQuery(imgElement).parent().addClass("icon-cloak-open");
			jQuery(imgElement).parent().removeClass("icon-cloak-closed");
			jQuery(jQuery(jQuery(imgElement).parents(".cloak")[0]).find(".ocultable")[0])
				.css("background","none")
				.css("color","black");
		}
	
	/** END - Regular Cloak opening and closing **/

	/** Table Cloak opening and closing **/
	
	function closeEditorTableCloak(imgElement) {
		jQuery(imgElement).hide().siblings().show();
		var imgButton = jQuery(imgElement).parent();
		imgButton.addClass("icon-cloak-closed");
		imgButton.removeClass("icon-cloak-open");
		var nextTd = jQuery(imgElement).parents("td").first().next();
		nextTd.removeClass("table-cloak-body-open"); 
		nextTd.addClass("table-cloak-body-closed"); 
	}

	function openEditorTableCloak(imgElement) {
		jQuery(imgElement).hide().siblings().show();
		var imgButton = jQuery(imgElement).parent();
		imgButton.addClass("icon-cloak-open");
		imgButton.removeClass("icon-cloak-closed");
		var nextTd = jQuery(imgElement).parents("td").first().next();
		nextTd.removeClass("table-cloak-body-closed"); 
		nextTd.addClass("table-cloak-body-open"); 
	}
	
	/** END - Table Cloak opening and closing **/
	
	/** Regular Cloak Transformations **/
	
	//Replaces editor cloak with live view cloak
	function editorCloakToLiveCloak(editorCloak) {
		editorCloak = jQuery(editorCloak);
		//Recursion call
		var cloakBody = editorCloak.find(".cloak-body:first");
	    if (cloakBody.find("table.cloak").length > 0) {
	    	cloakBody.find("table.cloak").each(function(){editorCloakToLiveCloak(this)});
	    }
		    
	    var liveCloak = jQuery("<div>", {class: "wrapColapsable"});
	
		var isCloakClosed = editorCloak.find(".icono:first").hasClass("icon-cloak-closed");
	   //Set icon
	    if (isCloakClosed) 
	    	var icon = jQuery.parseHTML('<div class="icono"><img src="/imagenes/abrir.gif"><img style="display: none" src="/imagenes/cerrar.gif"></div>');
	    else 
	    	var icon = jQuery.parseHTML('<div class="icono"><img style="display: none" src="/imagenes/abrir.gif"><img src="/imagenes/cerrar.gif"></div>');
	    icon = jQuery(icon);
	    
	    //Append title to div
	    var title = editorCloak.find(".cloak-title:first").contents();
	    title.wrapAll('<div class="tituloColapsable"></div>');
	    title = title.parent(); //.tituloColapsable
	    
	    title.find(".pull-right:first").remove();
	    title.find(".editor-space").remove();
	    
	    var hasRightTitle = (title.find(".icono:first").prev().text().trim() == "");
	    if (hasRightTitle) {
	      title.find(".icono:first").prev().remove();
	      title.find(".icono:first").remove();
	      liveCloak.append( title );
	      icon.insertBefore(title)
	    } else {
	      title.find(".icono:first").next().remove();
	      title.find(".icono:first").remove();
	      liveCloak.append( title );
	      icon.insertAfter(title);
	    }
	    	    
	    //Append body to div
	    if (isCloakClosed)
	    	var cloakBody1 = "<div class='ocultable' style='display: none'>"+cloakBody.html()+"</div>";
	    else
	    	var cloakBody1 = "<div class='ocultable'>"+cloakBody.html()+"</div>";
	    liveCloak.append(cloakBody1);
	    
	    //Replace table with div
	    editorCloak.replaceWith(liveCloak);
	}
	
	
	//Replaces live view cloak with editor cloak
	function liveCloakToEditorCloak(liveCloak) {
		liveCloak = jQuery(liveCloak);
		if (liveCloak.find("div.wrapColapsable").length > 0) {
			liveCloak.find("div.wrapColapsable").each(function(){liveCloakToEditorCloak(this)});
		}
		
		var editorCloak = jQuery.parseHTML(['<table class="panel panel-info cloak mce-item-table">',
		                                   		'<tbody>',
		                                   			'<tr>',
		                                   				'<td class="panel-heading panel-heading-info panel-title tituloColapsable cloak-title">',
	                                   						'<span class="icono mceNonEditable" data-mce-contenteditable="true">',
	                                   							'<button title="Cerrar cloak" class="cloakClose" style="background-image: url(\'/html/images/cerrar.gif\'); background-position: 3px; background-repeat: no-repeat; cursor: pointer;" data-mce-style="background-image: url(\'/html/images/cerrar.gif\'); background-position: 3px; background-repeat: no-repeat; cursor: pointer;">&nbsp;</button>',
	                                   							'<button title="Abrir cloak" class="cloakOpen" style="background-image: url(\'/html/images/abrir.gif\'); background-position: 3px; background-repeat: no-repeat; cursor: pointer;" data-mce-style="background-image: url(\'/html/images/abrir.gif\'); background-position: 3px; background-repeat: no-repeat; cursor: pointer; display: none;">&nbsp;</button>',
                                   							'</span>',
                                   							'<span class="pull-right mceNonEditable" data-mce-contenteditable="true">',
                                   								'<span class="glyphicon glyphicon-remove delete-panel" aria-hidden="true"></span>',
                                   							'</span>',
                                   						'</td>',
                                   					'</tr>',
                                   					'<tr>',
                                   						'<td class="panel-body ocultable cloak-body"></td>',
                                   					'</tr>',
                                   				'</tbody>',
                                   			'</table>'].join(''));
	    editorCloak = jQuery(editorCloak);
		
		//Set icon
		var iconDiv = liveCloak.find(".icono:first");
		var iconImg = iconDiv.children().first();
		if (iconImg.attr("src") == "/imagenes/cerrar.gif")
			iconImg = iconImg.next();
		if (iconImg.css('display') != 'none')  //cloak closed
			closeEditorCloak(editorCloak.find(".cloakClose"));
		else  //cloak open
			openEditorCloak(editorCloak.find(".cloakOpen"));
		
		//Set title with icon left or right
		var title = liveCloak.find(".tituloColapsable:first").contents(); 
		if (iconDiv.prev().hasClass("tituloColapsable")) { //icon to the right
			title.insertBefore(editorCloak.find(".icono"));
			jQuery('<span class="editor-space">&nbsp;</span>').insertAfter(editorCloak.find(".icono"));
		} else {  //icon to the left
			title.insertAfter(editorCloak.find(".icono"));
			jQuery('<span class="editor-space">&nbsp;</span>').insertBefore(editorCloak.find(".icono"));
		}
		
		//Set body
		var divBody = liveCloak.find(".ocultable:first").html();
		editorCloak.find(".panel-body").append(divBody);
		
		//Replace
		liveCloak.replaceWith(editorCloak);
	}
	
	/** END - Regular Cloak Transformations **/
	
	
	/** Table Cloak Transformations **/
	
	//Replaces editor table cloak with live view table cloak
	function editorTableCloakToLiveCloak(tdTitle) {
		tdTitle = jQuery(tdTitle);
		
		var tdBody = tdTitle.next();
		tdBody.html("<div class='wrapperCloak'>"+ tdBody.html() +"</div>")
		
		var editorIcon = tdTitle.find(".icono");
		
		if (!editorIcon || editorIcon.length == 0)
			return;
		
	   //Set icon
		var isCloakClosed = editorIcon.hasClass("icon-cloak-closed");
	    if (isCloakClosed) 
	    	var icon = '<img src="/imagenes/abrir.gif" class="cloak">';
	    else 
	    	var icon = '<img src="/imagenes/cerrar.gif" class="cloak cloak-open">';
	    icon = jQuery(jQuery.parseHTML(icon))	;
	    
	    //Set class to td title element
	    tdTitle.attr("class", "confluenceTd cloakToggle")
	    
	    //Set title & transform td title element to live view 
	    tdTitle.find(".editor-space").remove();
	    
	    var hasRightTitle = (editorIcon[0].previousSibling == null); 
	    if (hasRightTitle) { //the icon goes to the left side
	    	editorIcon.prev().remove();
	    	tdTitle.prepend(icon);
	    } else { //the icon goes to the right side
	    	editorIcon.next().remove();
	    	tdTitle.append(icon);
	    }
	    tdTitle.find(".icono").remove();
	     
	    //Set cloak body    
	    if (tdBody.hasClass("table-cloak-body-closed"))
	    	tdBody.find(".wrapperCloak:first").css("display", "none");
	    
	    tdBody.attr("class", "confluenceTd");
	}
	
	//Replaces live view table cloak with editor cloak
	function liveTableCloakToEditorCloak(tdTitle) {		
		tdTitle = jQuery(tdTitle);
		var tdBody = tdTitle.next();

		//Set class
		tdTitle.attr("class", "confluenceTd cloakToggle panel-heading panel-heading-info cloak-title table-cloak-title");
		
		//Set icon
		var editorIcon = jQuery.parseHTML([
											'<span class="icono mceNonEditable icon-cloak-closed">',
												'<button title="Abrir cloak" class="table-cloak-open" style=" background-image: url(\'/html/images/abrir.gif\');background-position: 3px; background-repeat: no-repeat; cursor:pointer;">&nbsp;</button>',
												'<button title="Cerrar cloak" class="table-cloak-close" style=" background-image: url(\'/html/images/cerrar.gif\');background-position: 3px; background-repeat: no-repeat; cursor:pointer; display:none">&nbsp;</button>',
											'</span>'
									].join(''));
		editorIcon = jQuery(editorIcon);
		
		var icon = jQuery(tdTitle.find("img.cloak:first"));
		
		var isClosed = !(icon.hasClass("cloak-open"));
		if (!isClosed)  //cloak open
			openEditorTableCloak(editorIcon.find(".table-cloak-open"));
		
		icon.replaceWith(editorIcon);
		
		//Add space for editing
		if (editorIcon[0].nextSibling == null) 
			jQuery('<span class="editor-space">&nbsp;</span>').insertAfter(editorIcon);
		else if (editorIcon[0].previousSibling == null) 
			jQuery('<span class="editor-space">&nbsp;</span>').insertBefore(editorIcon);
		
		//Set body 
		tdBody.css("display","");
		tdBody.html(tdBody.find(".wrapperCloak").html());
		tdBody.attr("class", "confluenceTd table-cloak-body");
		if (isClosed) 
			tdBody.addClass("table-cloak-body-closed");
		else
			tdBody.addClass("table-cloak-body-open");
	}
	
	/** END - Table Cloak Transformations **/
	
	
	/** Tab Transformations **/
	
	//Replaces editor tab with live view tab
	function editorTabToLiveTab(tableTab, level) {
		//Recursion call
		var tabBody = jQuery(tableTab).find(".tab-body:first");
	    if (tabBody.find(".tab").length > 0) {
	    	tabBody.find(".tab").each(function(){editorTabToLiveTab(this, level+1)});
	    }
		
	    // Get div of the tab level or create one
	    if (jQuery(tableTab).parent().find(".level-"+ level).length > 0) {
	    	var divTab = jQuery(tableTab).parent().find(".level-"+ level).first();
	    } else {
	    	var divTab = jQuery("<div>", {role: "tabpanel", class: "level-"+ level +" div-tab"});
	    	divTab.append('<ul class="nav nav-tabs" role="tablist"></ul><div class="tab-content"></div>'); 
	    	var replace = true;
	    }
	    
	    //Append title to div
	    var title = jQuery(tableTab).find(".tab-title:first").text().trim(); 
	    var numRand = generateGuid();
	    
	    var sinEspacios = title.replace(/ /g,"_");
	    var sinCaracteresRaros = normalizadorDeTexto(sinEspacios);
	    var divId = "tab-"+ sinCaracteresRaros + "-" + numRand;

	    var active = '';
	    if (divTab.find(".nav-tabs:first").find("li").length == 0)
	    	active = 'active in';
	    var disabled = '';
	    var isContentEmpty = jQuery(tabBody).text().replace(/\s/g,"") == "";
	    if (isContentEmpty)
	    	divTab.find(".nav-tabs:first").append('<li role="presentation" class="empty-particularidad disabled"><a href="#'+divId+'" aria-controls="'+divId+'" role="tab">'+ title +'</a></li>');
	    else
		    divTab.find(".nav-tabs:first").append('<li role="presentation" class="'+ active +'"><a href="#'+divId+'" aria-controls="'+divId+'" role="tab" data-toggle="tab">'+ title +'</a></li>');

	    //Append body to div
	    divTab.find(".tab-content:first").append('<div role="tabpanel" class="tab-pane fade '+ active +'" id="'+divId+'">'+tabBody.html()+'</div>');
	    
	    
	    //Replace table with div
	    if (replace)
	    	jQuery(tableTab).replaceWith(divTab);
	    else
	    	jQuery(tableTab).detach();
	}
	
	//Replaces live view tab with editor tab
	function liveTabToEditorTab(divTab) {
		var tabs = jQuery(divTab).find(".tab-content:first").children(".tab-pane");
		for (var i = tabs.length - 1; i >=0 ; i--) {
			var tableTab = jQuery.parseHTML(['<table class="panel panel-success tab mce-item-table">',
			                                 	'<tbody>',
			                                 		'<tr>',
			                                 			'<td class="panel-heading panel-heading-success panel-title tab-title">',
			                                 				'<p>',
			                                 					'<span class="pull-right mceNonEditable" data-mce-contenteditable="true">',
			                                 						'<span class="glyphicon glyphicon-remove delete-panel" aria-hidden="true"></span>',
			                                 					'</span>',
		                                 					'</p>',
                                 						'</td>',
                                 					'</tr>',
                                 					'<tr>',
                                 						'<td class="panel-body tab-body"></td>',
                                 					'</tr>',
                                 				'</tbody>',
                                 			'</table>'].join(''));

			var tabTitle = jQuery(divTab).find('a[href="#'+ tabs.eq(i).attr("id") +'"]').first().text().trim();
			jQuery(tableTab).find(".tab-title:first").find("p").first().prepend(tabTitle);
			
			var tabBody = tabs.eq(i).html();
			jQuery(tableTab).find(".tab-body:first").append(tabBody);
			jQuery(tableTab).insertAfter(divTab);
			jQuery(tableTab).find(".div-tab").each(function(){liveTabToEditorTab(this)});
		}		
		jQuery(divTab).detach();			
	}
	
	/** END - Tab Transformations **/
	
	// Tranforms tab & cloaks from editor view to live view
	function transformationsToLiveView() {
		jQuery(getIframeId("body_ifr")).contents().find("table.cloak").each(function () {editorCloakToLiveCloak(this)});
		jQuery(getIframeId("body_ifr")).contents().find(".tab").each(function () {editorTabToLiveTab(this, 0)});
		jQuery(getIframeId("body_ifr")).contents().find(".table-cloak-title").each(function () {editorTableCloakToLiveCloak(this)});
	}
	
	// Tranforms tab & cloaks from live view to editor view
	function transformationsToEditorView() {
		jQuery(getIframeId("body_ifr")).contents().find("div.wrapColapsable").each(function () {liveCloakToEditorCloak(this)});
        jQuery(getIframeId("body_ifr")).contents().find("td.cloakToggle").each(function () {liveTableCloakToEditorCloak(this)});
        jQuery(getIframeId("body_ifr")).contents().find(".div-tab.level-0").each(function () {liveTabToEditorTab(this)});
	}
	
	
	function getIframeId(id) {
		if (document.querySelector("iframe#" + id )) {
			return document.querySelector("iframe#" + id ).contentDocument || [];
		} else {
			return [];
		}
	}
	
	function generateGuid() {
		function s4() {
			return Math.floor((1 + Math.random()) * 0x10000).toString(16)
					.substring(1);
		}
		return s4() + s4() + '-' + s4() + '-' + s4() + '-' + s4() + '-' + s4()
				+ s4() + s4();
	}
	
	function normalizadorDeTexto(palabra){
		var reemplazo = palabra.replace(/Á/g, "A").replace(/É/g, "E").replace(/Í/g, "I").replace(/Ó/g, "O").replace(/Ú/g, "U").replace(/á/g, "a").replace(/é/g, "e").replace(/í/g, "i").replace(/ó/g, "o").replace(/ú/g, "u").replace(/Ñ/g, "N").replace(/ñ/g, "n").replace(/ü/g, "u");
		reemplazo = reemplazo.replace(/:|\/|&|\(|\)|\?|\%|\#|\!|\$|\.|\,|\;|\<|\>|\+|\*/g, "_");
		
		return reemplazo;
	}
	
	