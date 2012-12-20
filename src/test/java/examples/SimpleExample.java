/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import biz.source_code.miniTemplator.MiniTemplator;
import java.io.PrintWriter;

/**
 *
 * @author softphone
 */
public class SimpleExample {
 
private static final String templateFileName = "src/test/resources/template.txt";

public static void main (String args[]) throws Exception {
    
   java.io.File f = new java.io.File(templateFileName);
   
   MiniTemplator.TemplateSpecification spec = new MiniTemplator.TemplateSpecification(f.toURI().toURL());
   spec.skipUndefinedVars = true;
   
   MiniTemplator t = new MiniTemplator(spec);
   t.setVariable("var1", "test");
      
   String txt = t.generateOutput(); 
   
   System.out.println( txt ); 
}

    
}
