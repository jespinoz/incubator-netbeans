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
package org.netbeans.modules.web.common.ui.api;

import java.awt.Color;
import org.netbeans.modules.csl.api.test.CslTestBase;

/**
 *
 * @author marekfukala
 */
public class WebUIUtilsTest extends CslTestBase {

    public WebUIUtilsTest(String testName) {
        super(testName);
    }

    public void testToHexColorCode() {
        assertEquals("#ff0000", WebUIUtils.toHexCode(Color.RED));
        assertEquals("#2201aa", WebUIUtils.toHexCode(Color.decode("#2201aa")));
    }

}
