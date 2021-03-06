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
package org.netbeans.modules.maven.apisupport;

import javax.swing.Icon;
import org.netbeans.modules.maven.api.NbMavenProject;
import org.netbeans.modules.maven.spi.nodes.SpecialIcon;
import org.netbeans.spi.project.ProjectServiceProvider;
import org.openide.util.ImageUtilities;

@ProjectServiceProvider(service = SpecialIcon.class, projectType =
"org-netbeans-modules-maven/" + NbMavenProject.TYPE_NBM)
public class NbmIcons implements SpecialIcon {

    public NbmIcons() {
    }

    @Override
    public Icon getIcon() {

        return ImageUtilities.loadImageIcon("org/netbeans/modules/maven/apisupport/nbmicon.png", true);
    }

    @ProjectServiceProvider(service = SpecialIcon.class, projectType =
    "org-netbeans-modules-maven/" + NbMavenProject.TYPE_NBM_APPLICATION)
    public static class NbmAppIcons implements SpecialIcon {

        public NbmAppIcons() {
        }

        @Override
        public Icon getIcon() {
            return ImageUtilities.loadImageIcon("org/netbeans/modules/maven/apisupport/suiteicon.png", true);
        }
    }
}
