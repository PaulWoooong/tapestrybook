package de.t5book.test.integration;

import org.apache.tapestry5.test.AbstractIntegrationTestSuite;
import org.testng.annotations.Test;

public class SimpleIntegrationTest extends AbstractIntegrationTestSuite {
	
    @Test
    public void integration_test(){
        open(AbstractIntegrationTestSuite.BASE_URL);
        
        assertTextPresent("Tapestry 5 Test");
    }
    
    @Test
    public void test_link(){
    	start("Zum Login");
        
        assertTextPresent("Login");
    }
    
    @Test
    public void test_login(){
    	start("Zum Login");
        
        type("userName", "Igor");
        
        clickAndWait(SUBMIT);
        
        assertAttribute("//input[@id='userName']/@value", "Igor");
        assertTextPresent("You must provide a value for Password.");
        
        type("password", "falsches-passwort");
        clickAndWait(SUBMIT);
        
        assertFieldValue("userName", "Igor");
        assertTextPresent("Passwort ist falsch.");
        
        type("password", "secret");
        clickAndWait(SUBMIT);
        
        assertTextPresent("Herzlich Willkommen, Igor!");
    }
    
    @Test
    public void test_ajax(){
    	open(AbstractIntegrationTestSuite.BASE_URL+"basicajax");
    	
    	assertTextPresent("0");
    	
    	click("increment");

    	sleep(1000);
    	
    	assertTextPresent("1");
    	
    	click("increment");

    	sleep(1000);
    	
    	assertTextPresent("2");
    	
    	click("reset");

    	sleep(1000);
    	
    	assertTextPresent("0");
    }
    
    private void sleep(long timeout){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException ex){
            
        }
    }
}