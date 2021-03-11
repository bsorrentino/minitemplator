package org.bsc;

import biz.source_code.miniTemplator.MiniTemplator;
import org.junit.Test;

import java.nio.charset.Charset;

import static org.junit.Assert.assertEquals;

public class ParseTest {

  @Test
  public void example1() throws Exception {
    final String templateFileName = "src/test/resources/example1-template.html";

    final java.io.File f = new java.io.File(templateFileName);

    final MiniTemplator t = MiniTemplator.builder().build(f.toURI().toURL());

    t.setVariable("animal1", "fox");
    t.setVariable("animal2", "dog");
    t.addBlock("block1");
    t.setVariable("animal1", "horse");
    t.setVariable("animal2", "cow");
    t.addBlock("block1");

    final String result = t.generateOutput();

    //System.out.println(result);

    final String expected = "<html>\n" +
        "\n" +
        "<head>\n" +
        " <title>MiniTemplator Example 1</title>\n" +
        "</head>\n" +
        "\n" +
        "<body>\n" +
        "\n" +
        "<h3>MiniTemplator Example 1</h3>\n" +
        "\n" +
        "\n" +
        " <p>The quick brown fox jumps over the lazy dog.</p>\n" +
        "\n" +
        " <p>The quick brown horse jumps over the lazy cow.</p>\n" +
        "\n" +
        "\n" +
        "<p>(The first sentence is a <a href=\"http://www.wikipedia.org/wiki/Pangram\">pangram</a>)</p>\n" +
        "\n" +
        "</body>\n" +
        "</html>";
    assertEquals(expected, result);
  }

  @Test
  public void example2() throws Exception {

    final String templateFileName = "src/test/resources/example2-template.html";

    final java.io.File f = new java.io.File(templateFileName);

    final MiniTemplator t = MiniTemplator.builder().build(f.toURI().toURL());
    t.setVariable("year", "2003");
    t.setVariable("month", "April");

    for (int weekOfYear = 14; weekOfYear <= 18; weekOfYear++) {

      for (int dayOfWeek = 0; dayOfWeek < 7; dayOfWeek++) {
        int dayOfMonth = (weekOfYear * 7 + dayOfWeek) - 98;
        if (dayOfMonth >= 1 && dayOfMonth <= 30)
          t.setVariable("dayOfMonth", Integer.toString(dayOfMonth));
        else
          t.setVariable("dayOfMonth", "&nbsp;");
        t.addBlock("day");
      }
      t.setVariable("weekOfYear", Integer.toString(weekOfYear));
      t.addBlock("week");
    }

    final String result = t.generateOutput();

    //System.out.println(result);

    final String expected = "<html>\n" +
        "\n" +
        "<head>\n" +
        "<title>MiniTemplator Example 2 - Calendar Page</title>\n" +
        "</head>\n" +
        "\n" +
        "<body>\n" +
        "\n" +
        "<h3>MiniTemplator Example 2 - Calendar Page</h3>\n" +
        "\n" +
        "<p>\n" +
        "Year:  2003<br>\n" +
        "Month: April</p>\n" +
        "\n" +
        "<table border=\"1\" cellpadding=\"3\" cellspacing=\"0\">\n" +
        "\n" +
        " <tr>\n" +
        "  <td bgcolor=\"#D0D0D0\">Week</td>\n" +
        "  <td bgcolor=\"#D0D0D0\">Mo</td>\n" +
        "  <td bgcolor=\"#D0D0D0\">Tu</td>\n" +
        "  <td bgcolor=\"#D0D0D0\">We</td>\n" +
        "  <td bgcolor=\"#D0D0D0\">Th</td>\n" +
        "  <td bgcolor=\"#D0D0D0\">Fr</td>\n" +
        "  <td bgcolor=\"#D0D0D0\">Sa</td>\n" +
        "  <td bgcolor=\"#D0D0D0\">So</td>\n" +
        " </tr>\n" +
        "\n" +
        " \n" +
        "  <tr>\n" +
        "   <td align=\"center\" bgcolor=\"#F0F0F0\">14</td>\n" +
        "   \n" +
        "    <td align=\"right\">&nbsp;</td>\n" +
        "   \n" +
        "    <td align=\"right\">1</td>\n" +
        "   \n" +
        "    <td align=\"right\">2</td>\n" +
        "   \n" +
        "    <td align=\"right\">3</td>\n" +
        "   \n" +
        "    <td align=\"right\">4</td>\n" +
        "   \n" +
        "    <td align=\"right\">5</td>\n" +
        "   \n" +
        "    <td align=\"right\">6</td>\n" +
        "   \n" +
        "  </tr>\n" +
        " \n" +
        "  <tr>\n" +
        "   <td align=\"center\" bgcolor=\"#F0F0F0\">15</td>\n" +
        "   \n" +
        "    <td align=\"right\">7</td>\n" +
        "   \n" +
        "    <td align=\"right\">8</td>\n" +
        "   \n" +
        "    <td align=\"right\">9</td>\n" +
        "   \n" +
        "    <td align=\"right\">10</td>\n" +
        "   \n" +
        "    <td align=\"right\">11</td>\n" +
        "   \n" +
        "    <td align=\"right\">12</td>\n" +
        "   \n" +
        "    <td align=\"right\">13</td>\n" +
        "   \n" +
        "  </tr>\n" +
        " \n" +
        "  <tr>\n" +
        "   <td align=\"center\" bgcolor=\"#F0F0F0\">16</td>\n" +
        "   \n" +
        "    <td align=\"right\">14</td>\n" +
        "   \n" +
        "    <td align=\"right\">15</td>\n" +
        "   \n" +
        "    <td align=\"right\">16</td>\n" +
        "   \n" +
        "    <td align=\"right\">17</td>\n" +
        "   \n" +
        "    <td align=\"right\">18</td>\n" +
        "   \n" +
        "    <td align=\"right\">19</td>\n" +
        "   \n" +
        "    <td align=\"right\">20</td>\n" +
        "   \n" +
        "  </tr>\n" +
        " \n" +
        "  <tr>\n" +
        "   <td align=\"center\" bgcolor=\"#F0F0F0\">17</td>\n" +
        "   \n" +
        "    <td align=\"right\">21</td>\n" +
        "   \n" +
        "    <td align=\"right\">22</td>\n" +
        "   \n" +
        "    <td align=\"right\">23</td>\n" +
        "   \n" +
        "    <td align=\"right\">24</td>\n" +
        "   \n" +
        "    <td align=\"right\">25</td>\n" +
        "   \n" +
        "    <td align=\"right\">26</td>\n" +
        "   \n" +
        "    <td align=\"right\">27</td>\n" +
        "   \n" +
        "  </tr>\n" +
        " \n" +
        "  <tr>\n" +
        "   <td align=\"center\" bgcolor=\"#F0F0F0\">18</td>\n" +
        "   \n" +
        "    <td align=\"right\">28</td>\n" +
        "   \n" +
        "    <td align=\"right\">29</td>\n" +
        "   \n" +
        "    <td align=\"right\">30</td>\n" +
        "   \n" +
        "    <td align=\"right\">&nbsp;</td>\n" +
        "   \n" +
        "    <td align=\"right\">&nbsp;</td>\n" +
        "   \n" +
        "    <td align=\"right\">&nbsp;</td>\n" +
        "   \n" +
        "    <td align=\"right\">&nbsp;</td>\n" +
        "   \n" +
        "  </tr>\n" +
        " \n" +
        "\n" +
        "</table>\n" +
        "\n" +
        "</body>\n" +
        "</html>";

    assertEquals(expected, result);
  }

  @Test
  public void simpleExample() throws Exception {

    final String templateFileName = "src/test/resources/template.txt";

    final java.io.File f = new java.io.File(templateFileName);

    final MiniTemplator t =
        MiniTemplator.builder()
            .setSkipUndefinedVars(true)
            .build(f.toURI().toURL());

    t.setVariable("var1", "test");

    final String result = t.generateOutput();

    final String expected = "\n" +
        "=====\n" +
        "TEST\n" +
        "=====\n" +
        "\n" +
        "VAR1: test\n" +
        "\n" +
        "\n" +
        "==> ${var2} <==\n";

    assertEquals(expected, result);
  }
}
