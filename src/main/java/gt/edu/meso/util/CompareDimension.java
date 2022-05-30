/*
 * Copyright 2022 wil.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gt.edu.meso.util;

import java.awt.Dimension;
import java.util.Comparator;

/**
 * @author wil
 * @author javier
 * @author santos
 */
public class CompareDimension implements Comparator<Dimension> {
    
    public static int doCompare(Dimension a, Dimension b) {
        return new CompareDimension().compare(a, b);
    }
    
    private CompareDimension() {
    }
    
    @Override 
    public int compare(Dimension a, Dimension b) {
        // Width
        if (a.getWidth() != b.getWidth()) {
            return (a.getWidth() > b.getWidth()) ? 1 : -1;
        }
        // Height
        if (a.getHeight() != b.getHeight()) {
            return (a.getHeight() > b.getHeight()) ? 1 : -1;
        }
        // All fields are equal
        return 0;
    }
}
