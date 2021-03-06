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

package org.netbeans.core.windows.view.ui.slides;

/*
 * Controller for slide related user actions.
 *
 * @author Dafe Simonek
 */
public interface SlideController {

    /** Called when user toggles auto hide.
     * @param state True if component is being auto-hidden, false otherwise.
     */
    public void userToggledAutoHide(int tabIndex, boolean enabled);

    /**
     * Called when user toggles transparency of slided-in window
     * @param tabIndex Index of the tab to make transparent/opaque
     */
    public void userToggledTransparency(int tabIndex);
}
