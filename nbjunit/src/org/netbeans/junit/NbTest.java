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
package org.netbeans.junit;

import junit.framework.Test;

/**
 * NetBeans extension to JUnit Test interface
 */
public interface NbTest extends Test {

    /**
     * Checks if a test isn't filtered out by the active filter.
     * @return true if the test can run
     */
    public abstract boolean canRun();

    /**
     * Sets active filter.
     * @param filter Filter to be set as active for current test, null will reset filtering.
     */
    public abstract void setFilter(Filter filter);

    /**
     * Returns expected fail message.
     * @return expected fail message if it's expected this test fail, null otherwise.
     */
    public abstract String getExpectedFail(); 

}
