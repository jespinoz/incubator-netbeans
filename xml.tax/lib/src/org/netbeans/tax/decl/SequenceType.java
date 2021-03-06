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
package org.netbeans.tax.decl;

import java.util.*;
import org.netbeans.tax.*;

public class SequenceType extends ChildrenType {

    //
    // init
    //

    public SequenceType (Collection types) {
        super (types);
    }

    public SequenceType () {
        super ();
    }

    public SequenceType (SequenceType sequenceType) {
        super (sequenceType);
    }


    //
    // from TreeObject
    //

    /**
     */
    public Object clone () {
        return new SequenceType (this);
    }

    //
    // itself
    //
    
    /**
     */
    public String toString () {
        Iterator it = getTypes ().iterator ();
        StringBuffer sb = new StringBuffer ();
        while (it.hasNext ()) {
            TreeElementDecl.ContentType next = (TreeElementDecl.ContentType) it.next ();
            sb.append (", ").append (next.toString ()); // NOI18N
        }
        if (sb.length () > 0) sb.delete (0,2);
        
        return "( " + sb.toString () + " )" + getMultiplicity (); // NOI18N
    }
    
    /**
     */
    public String getName () {
        return "SEQUENCE" + getMultiplicity(); // NOI18N
    }
    
    /**
     */
    public String getSeparator () {
        return ","; // NOI18N
    }
    
}
