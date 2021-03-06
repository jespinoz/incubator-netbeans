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
package org.netbeans.modules.visual.action;

import org.netbeans.api.visual.action.WidgetAction;
import org.netbeans.api.visual.widget.Widget;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author David Kaspar
 */
public class ActionMapAction extends WidgetAction.Adapter {

    private InputMap inputMap;
    private ActionMap actionMap;

    public ActionMapAction (InputMap inputMap, ActionMap actionMap) {
        this.inputMap = inputMap;
        this.actionMap = actionMap;
    }

    public State keyPressed (Widget widget, WidgetKeyEvent event) {
        return handleKeyEvent (widget, event, KeyStroke.getKeyStroke (event.getKeyCode (), event.getModifiers ()));
    }

    public State keyReleased (Widget widget, WidgetKeyEvent event) {
        return handleKeyEvent (widget, event, KeyStroke.getKeyStroke (event.getKeyCode (), event.getModifiers (), true));
    }

    public State keyTyped (Widget widget, WidgetKeyEvent event) {
        return handleKeyEvent (widget, event, KeyStroke.getKeyStroke (event.getKeyCode (), event.getModifiers ()));
    }

    private State handleKeyEvent (Widget widget, WidgetKeyEvent event, KeyStroke keyStroke) {
        if (keyStroke == null)
            return State.REJECTED;
        ActionListener action;
        if (actionMap != null && inputMap != null) {
            Object o = inputMap.get (keyStroke);
            action = o != null ? actionMap.get (o) : null;
        } else {
            JComponent view = widget.getScene ().getView ();
            action = view != null ? view.getActionForKeyStroke (keyStroke) : null;
        }
        if (action != null) {
            action.actionPerformed (new ActionEvent (widget, (int) event.getEventID (), null, event.getWhen (), event.getModifiers ())); // TODO - action-event command
            return State.CONSUMED;
        }
        return State.REJECTED;
    }

}
