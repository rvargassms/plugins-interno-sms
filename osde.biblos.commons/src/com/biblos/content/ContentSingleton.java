/*
 * Flux IT Argentina
 * La Plata - Buenos Aires - Argentina
 * http://www.fluxit.com.ar
 * Author: Emanuel Testa
 * Date:  02/03/2015 - 16:54:13
 */
package com.biblos.content;



import com.biblos.content.bo.ContentBO;
import com.biblos.content.bo.ContentBOImpl;


/**
 * @author Emanuel Testa
 *
 */
public class ContentSingleton {
	private static ContentSingleton contentSingleton;
	private ContentBO contentBO = new ContentBOImpl();
	
	
	private ContentSingleton() {
		super();
	}
	
	static synchronized public ContentSingleton instance() {
		if (contentSingleton == null) {
			contentSingleton = new ContentSingleton();
		}
		return contentSingleton;
	}

	public ContentBO getContentBO() {
		return contentBO;
	}

	public void setContentBO(ContentBO contentBO) {
		this.contentBO = contentBO;
	}

}
