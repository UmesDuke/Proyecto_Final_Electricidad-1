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

import java.text.DecimalFormat;

/**
 * @author wil
 * @author javier
 * @author santos
 */
public class Utils {
    
    public static String doubleFormat(double val) {
        DecimalFormat format = new DecimalFormat("#.00");
        return format.format(val);
    }
    
    public static String floatFormat(float val) {
        return doubleFormat(((Number) val).doubleValue());
    }
}
