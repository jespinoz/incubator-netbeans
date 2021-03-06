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
package org.netbeans.modules.xml.multiview.ui;

import javax.swing.*;
import java.awt.*;

/**
 * @author pfiala
 */
public class BoxPanel extends SectionNodeInnerPanel {

    /**
     * Creates new form BoxPanel
     *
     * @param sectionNodeView
     */
    public BoxPanel(SectionNodeView sectionNodeView) {
        super(sectionNodeView);
        initComponents();
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

    }//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public JComponent getErrorComponent(String errorId) {
        final Component[] components = getComponents();
        for (int i = 0; i < components.length; i++) {
            final Component component = components[i];
            if (component instanceof SectionInnerPanel) {
                SectionInnerPanel panel = (SectionInnerPanel) component;
                final JComponent errorComponent = panel.getErrorComponent(errorId);
                if (errorComponent != null) {
                    return errorComponent;
                }
            }
        }
        return null;
    }

    public void setValue(JComponent source, Object value) {

    }

    public void linkButtonPressed(Object ddBean, String ddProperty) {
        final Component[] components = getComponents();
        for (int i = 0; i < components.length; i++) {
            final Component component = components[i];
            if (component instanceof SectionInnerPanel) {
                SectionInnerPanel panel = (SectionInnerPanel) component;
                panel.linkButtonPressed(ddBean, ddProperty);
            }
        }
    }

    public void setComponents(Component[] components) {
        for (int i = 0; i < components.length; i++) {
            Component component = components[i];
            if (i >= getComponentCount() || component != getComponent(i)) {
                add(component, i);
            }
        }
        int n = components.length;
        while (getComponentCount() > n) {
            remove(n);
        }
    }
    /** This will be called after model is changed from this panel
     */
    protected void signalUIChange() {
    }
}
