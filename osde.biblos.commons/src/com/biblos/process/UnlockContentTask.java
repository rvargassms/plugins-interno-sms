package com.biblos.process;

import com.biblos.content.ContentSingleton;
import com.biblos.content.bo.ContentBO;
import com.biblos.content.bo.ContentBOImpl;

public class UnlockContentTask {

	public void execute(){
		
		ContentSingleton.instance().getContentBO().desbloquearContenido();
	}
}
