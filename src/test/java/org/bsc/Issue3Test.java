/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bsc;

import biz.source_code.miniTemplator.MiniTemplator;
import java.io.IOException;
import java.nio.charset.Charset;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;

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
                                 .build(f.toURI().toURL(), Charset.defaultCharset());
        t.setVariableOpt("test", "test1");


        final String out = t.generateOutput(); 
            
        final String lines[] = out.split("\n");
        Assert.assertThat(lines[0], IsEqual.equalTo("$\\{test}"));
    }
}
