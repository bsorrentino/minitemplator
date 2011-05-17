// A simple example of how to use the MiniTemplator class.

import biz.source_code.miniTemplator.MiniTemplator;

public class Sample1 {

private static final String templateFileName = "src/samples/sample1-template.htm";
private static final String outputFileName   = "target/samples-output/sample1-output.htm";

public static void main (String args[]) throws Exception {
   MiniTemplator t = new MiniTemplator(templateFileName);
   t.setVariable ("animal1", "fox");
   t.setVariable ("animal2", "dog");
   t.addBlock ("block1");
   t.setVariable ("animal1", "horse");
   t.setVariable ("animal2", "cow");
   t.addBlock ("block1");
   t.generateOutput (outputFileName); }

} // end class Sample1
