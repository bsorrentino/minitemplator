/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bsc;

import biz.source_code.miniTemplator.MiniTemplator;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
                                 .build(f.toURI().toURL());
        
        final String path = "/tmp";
        final String java_home = System.getProperty("java.home");
        
        t.setVariableOpt("JAVA_HOME", java_home);
        t.setVariableOpt("PATH", path);

        final String out = t.generateOutput(); 

        int line = 0;
        final String lines[] = out.split("\n");
        assertTrue( lines.length >= 3 );
        assertEquals(lines[line++], "${JAVA_HOME} - ${PATH}" );
        assertEquals(lines[line++], format("path is: %s", path));
        assertEquals(lines[line++], format("JAVA_HOME = %s", java_home));
        
        

    }
}
