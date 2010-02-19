// A more complex example of how to use the MiniTemplator class.

import biz.source_code.miniTemplator.MiniTemplator;

public class Sample2 {

private static final String templateFileName = "src/samples/sample2-template.htm";
private static final String outputFileName   = "target/samples-output/sample2-output.htm";

public static void main (String args[]) throws Exception {
   MiniTemplator t = new MiniTemplator(templateFileName);
   t.setVariable ("year", "2003");
   t.setVariable ("month", "April");
   for (int weekOfYear=14; weekOfYear<=18; weekOfYear++) {
      for (int dayOfWeek=0; dayOfWeek<7; dayOfWeek++) {
         int dayOfMonth = (weekOfYear*7 + dayOfWeek) - 98;
         if (dayOfMonth >= 1 && dayOfMonth <= 30)
            t.setVariable ("dayOfMonth", Integer.toString(dayOfMonth));
          else
            t.setVariable ("dayOfMonth", "&nbsp;");
         t.addBlock ("day"); }
      t.setVariable ("weekOfYear", Integer.toString(weekOfYear));
      t.addBlock ("week"); }
   t.generateOutput (outputFileName); }

} // end class Sample2
