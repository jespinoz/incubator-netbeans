/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.css.prep.editor;

import java.io.IOException;
import javax.swing.text.BadLocationException;
import org.netbeans.modules.css.lib.CssTestBase;
import org.netbeans.modules.css.lib.TestUtil;
import org.netbeans.modules.css.lib.api.CssParserResult;
import org.netbeans.modules.parsing.spi.ParseException;

/**
 *
 * @author marekfukala
 */
public class SassParsingTest extends CssTestBase {

    public SassParsingTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp(); 
        setScssSource();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown(); 
        setPlainSource();
    }
    
    //http://netbeans.org/bugzilla/show_bug.cgi?id=227676
    //Bug 227676 - Css3Parser causes problems during scanning
    //
    //symptoms: endless parsing of ext-4.2.0.489/packages/ext-theme-neutral/sass/src/form/field/Trigger.scss file    
    public void testIssue227676() throws ParseException, BadLocationException, IOException {
        CssParserResult result = TestUtil.parse(getTestFile("testFiles/testIssue227676.scss"));
        TestUtil.dumpResult(result);
        assertResultOK(result);
    }
}
