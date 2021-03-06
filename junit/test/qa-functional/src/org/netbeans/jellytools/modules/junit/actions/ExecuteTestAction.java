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

package org.netbeans.jellytools.modules.junit.actions;

import org.netbeans.jellytools.actions.*;
import java.awt.event.KeyEvent;
import org.netbeans.jellytools.Bundle;

/** ExecuteTestAction Class
 * @author dave
 */
public class ExecuteTestAction extends Action {

    public static final String MENU = Bundle.getString("org.netbeans.core.Bundle", "Actions/Tools") + "|" + Bundle.getString("org.netbeans.modules.junit.Bundle", "LBL_Action_Tests") + "|" + Bundle.getString("org.netbeans.modules.junit.Bundle", "LBL_Action_RunTest");

    /** creates new ExecuteTestAction instance */
    public ExecuteTestAction() {
        super(MENU, MENU, new Action.Shortcut(KeyEvent.CTRL_MASK|KeyEvent.ALT_MASK, KeyEvent.VK_L));
    }
}
