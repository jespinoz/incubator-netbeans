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
package org.netbeans.api.java.source.ui;

import java.net.MalformedURLException;
import java.net.URL;
import junit.framework.TestCase;

/**
 *
 * @author Radim Kubacki
 */
public class HTMLJavadocParserTest extends TestCase {
    
  public HTMLJavadocParserTest(String testName) {
      super(testName);
  }

  /**
   * Test of getJavadocText method ised with HTML produced by standard doclet.
   */
  public void testGetJavadocText() throws MalformedURLException {
    URL url = HTMLJavadocParserTest.class.getResource("HTMLJavadocParser.html");
    String result = HTMLJavadocParser.getJavadocText(url, false);
    assertNotNull(result);

    result = HTMLJavadocParser.getJavadocText(
        new URL(url, "HTMLJavadocParser.html#getJavadocText(java.net.URL, boolean)"), false);
    assertNotNull(result);
  }

  /**
   * Test of getJavadocText method used with javadoc from Android SDK.
   */
  public void testGetAndroidJavadocText() throws MalformedURLException {
    URL url = HTMLJavadocParserTest.class.getResource("Activity.html");
    String result = HTMLJavadocParser.getJavadocText(url, false);
    assertNotNull(result);

    result = HTMLJavadocParser.getJavadocText(
        new URL(url, "Activity.html#dispatchKeyEvent(android.view.KeyEvent)"), false);
    // check that there is begining of javadoc
    assertTrue(result.contains("Called to process key events."));
    // ... and return value documentation too
    assertTrue(result.contains("if this event was consumed."));

    result = HTMLJavadocParser.getJavadocText(
        new URL(url, "Activity.html#onActivityResult%28int%2C%20int%2C%20android.content.Intent%29"), false);
    // check that there is begining of javadoc
    assertTrue(result.contains("Called when an activity"));
    // ... and return value documentation too
    assertTrue(result.contains("See Also"));

  }

  public void test199194() throws MalformedURLException {
    URL url = HTMLJavadocParserTest.class.getResource("JavaApplication1.html");
    String result = HTMLJavadocParser.getJavadocText(url, false);
    assertNotNull(result);

    result = HTMLJavadocParser.getJavadocText(
        new URL(url, "JavaApplication1.html#test(java.lang.Object)"), false);
    assertNotNull(result);
    assertTrue(result.contains("C"));
  }
  
  public void test209707() throws MalformedURLException {
        URL url = HTMLJavadocParserTest.class.getResource("FileChooser.html");
        String result = HTMLJavadocParser.getJavadocText(url, false);
        assertNotNull(result);
        assertTrue(result.contains(" may be restricted "));

        result = HTMLJavadocParser.getJavadocText(
                new URL(url, "FileChooser.html#showSaveDialog(javafx.stage.Window)"), false);
        assertNotNull(result);
        assertTrue(result.contains("the selected file or"));
  }
}
