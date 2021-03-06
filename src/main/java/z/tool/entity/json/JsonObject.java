/**
 * https://github.com/auzll/
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package z.tool.entity.json;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

/**
 * @author auzll
 *
 */
public interface JsonObject {
    boolean containsKey(Object key);

    Object get(Object key);

    JsonObject getJsonObject(String key);

    JsonArray getJsonArray(String key);

    Boolean getBoolean(String key);
    
    boolean getBooleanValue(String key);

    Byte getByte(String key);

    byte getByteValue(String key);

    Short getShort(String key);

    short getShortValue(String key);

    Integer getInteger(String key);

    int getIntValue(String key);

    Long getLong(String key);

    long getLongValue(String key);

    Float getFloat(String key);

    float getFloatValue(String key);

    Double getDouble(String key);

    double getDoubleValue(String key);

    BigDecimal getBigDecimal(String key);

    BigInteger getBigInteger(String key);
    
    String getString(String key);

    Date getDate(String key);

    JsonObject put(String key, Object value);
    
    JsonObject put(String key, Date value);
    
    JsonObject putId(String key, long value);
    
    JsonObject putId(String key, int value);

    Set<String> keySet();
    
    String toJsonString();
}
