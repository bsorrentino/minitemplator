// A more complex example of how to use the MiniTemplator class.
package examples;

import biz.source_code.miniTemplator.MiniTemplator;
import java.nio.charset.Charset;


public class Example2 {

private static final String templateFileName = "src/test/resources/example2-template.html";
private static final String outputFileName   = "target/example2-output.html";

public static void main (String args[]) throws Exception {
   java.io.File f = new java.io.File(templateFileName);
 
   MiniTemplator t = new MiniTemplator.Builder()
                    .build(f.toURI().toURL(), Charset.defaultCharset());
   t.setVariable("year", "2003");
   t.setVariable("month", "April");
   for (int weekOfYear=14; weekOfYear<=18; weekOfYear++) {
      for (int dayOfWeek=0; dayOfWeek<7; dayOfWeek++) {
         int dayOfMonth = (weekOfYear*7 + dayOfWeek) - 98;
         if (dayOfMonth >= 1 && dayOfMonth <= 30)
            t.setVariable("dayOfMonth", Integer.toString(dayOfMonth));
          else
            t.setVariable("dayOfMonth", "&nbsp;");
         t.addBlock("day"); }
      t.setVariable("weekOfYear", Integer.toString(weekOfYear));
      t.addBlock("week"); }
   t.generateOutput(outputFileName); }

} // end class Example2