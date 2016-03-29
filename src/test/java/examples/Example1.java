// A simple example of how to use the MiniTemplator class.
package examples;

import biz.source_code.miniTemplator.MiniTemplator;
import java.nio.charset.Charset;

public class Example1 {

private static final String templateFileName = "src/test/resources/example1-template.html";
private static final String outputFileName   = "target/example1-output.html";

public static void main (String args[]) throws Exception {
    
   java.io.File f = new java.io.File(templateFileName);
   
   MiniTemplator t = new MiniTemplator.Builder()
                            .build(f.toURI().toURL(), Charset.defaultCharset());
   t.setVariable("animal1", "fox");
   t.setVariable("animal2", "dog");
   t.addBlock("block1");
   t.setVariable("animal1", "horse");
   t.setVariable("animal2", "cow");
   t.addBlock("block1");
   t.generateOutput(outputFileName); }

} // end class Example1