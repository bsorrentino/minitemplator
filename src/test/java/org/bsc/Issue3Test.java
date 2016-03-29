/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bsc;

import biz.source_code.miniTemplator.MiniTemplator;
import java.io.IOException;
import java.nio.charset.Charset;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;
import static java.lang.String.format;
/**
 *
 * @author softphone
 */
public class Issue3Test {
    
    
    @Test
    public void processEscapeChar() throws IOException {
        
        final String templateFileName = "src/test/resources/issue3.txt";

        final java.io.File f = new java.io.File(templateFileName);

        final MiniTemplator t = new MiniTemplator.Builder()
                                 .setSkipUndefinedVars(true)
                                 .build(f.toURI().toURL(), Charset.defaultCharset());
        
        final String path = "/tmp";
        final String java_home = System.getProperty("java.home");
        
        t.setVariableOpt("JAVA_HOME", java_home);
        t.setVariableOpt("PATH", path);


        final String out = t.generateOutput(); 

        int line = 0;
        final String lines[] = out.split("\n");
        Assert.assertThat( lines.length >= 3, Is.is(true));
        Assert.assertThat(lines[line++], IsEqual.equalTo("${JAVA_HOME} - ${PATH}"));
        Assert.assertThat(lines[line++], IsEqual.equalTo(format("path is: %s", path)));
        Assert.assertThat(lines[line++], IsEqual.equalTo(format("JAVA_HOME = %s", java_home)));
        
        

    }
}
