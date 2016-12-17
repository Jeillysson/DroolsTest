package com.sample;

import org.kie.api.KieServices;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

	public static final void main(String[] args) {
    	
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
            Message message = new Message();
            
            message.setMessage("O que você Deseja?");
            message.setStatus(Message.INICIO);
            
            String texto = message.getMessage();
    		
    		// Caminho de que?
    		String path = "C:\\Users\\Jeillysson\\Desktop\\teste2";
    		QRCodeGenerator.gerarComZXing(path, texto, "png");
        
            kSession.insert(message);
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
