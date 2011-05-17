// A simple example of how to use the MiniTemplator class.

import biz.source_code.miniTemplator.MiniTemplator;

public class Example1 {

private static final String templateFileName = "src/examples/example1-template.html";
private static final String outputFileName   = "target/examples-output/example1-output.html";

public static void main (String args[]) throws Exception {
   MiniTemplator t = new MiniTemplator(templateFileName);
   t.setVariable("animal1", "fox");
   t.setVariable("animal2", "dog");
   t.addBlock("block1");
   t.setVariable("animal1", "horse");
   t.setVariable("animal2", "cow");
   t.addBlock("block1");
   t.generateOutput(outputFileName); }

} // end class Example1