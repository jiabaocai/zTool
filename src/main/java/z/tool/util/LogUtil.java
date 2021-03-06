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
package z.tool.util;

import java.util.Arrays;
import java.util.Date;


/**
 * 日志工具类
 */
public final class LogUtil {
    private LogUtil() {}
    
    /**
     * 检查对象是否为空，是则创建新对象返回，否则返回原对象
     */
    private static StringBuilder checkBuff(StringBuilder buff) {
        if (null == buff) {
            buff = new StringBuilder();
        }
        return buff;
    }
    
    public static StringBuilder beginLog(String methodName) {
        return beginLog(null, null, methodName);
    }
    
    public static StringBuilder beginLog(String operatorId, String operatorNick, String methodName) {
        StringBuilder logBuff = new StringBuilder();
        
        if (null != operatorId) {
            appendLog(logBuff, "operatorId", operatorId);
        }
        
        if (null != operatorNick) {
            appendLog(logBuff, "operatorNick", operatorNick);
        }
        
        return appendLog(logBuff, "method", methodName);
    }
    
    public static String finishLog(StringBuilder logBuff) {
        if (null == logBuff || logBuff.length() < 1) {
            return "";
        }
        return StringUtil.deleteEnd(logBuff, ',').toString();
    }
    
    public static StringBuilder appendLog(StringBuilder logBuff, String key, StringBuilder value) {
        if (null == value) {
            return logBuff;
        }
        return checkBuff(logBuff).append(key).append(":").append(value).append(",");
    }
    
    public static StringBuilder appendLog(StringBuilder logBuff, String key, String value) {
        if (null == value) {
            return logBuff;
        }
        return checkBuff(logBuff).append(key).append(":").append(value).append(",");
    }
    
    public static StringBuilder appendLog(StringBuilder logBuff, String key, Object value) {
        if (null == value) {
            return logBuff;
        }
        return checkBuff(logBuff).append(key).append(":").append(value).append(",");
    }
    
    public static StringBuilder appendLog(StringBuilder logBuff, String key, Date value) {
        if (null == value) {
            return logBuff;
        }
        return checkBuff(logBuff).append(key).append(":").append(null != value ? value.getTime() : 0).append(",");
    }
    
    public static StringBuilder appendCurrentThreadId(StringBuilder logBuff) {
        return checkBuff(logBuff).append("threadId").append(":").append(Thread.currentThread().getId()).append(",");
    }
    
    public static StringBuilder appendClassSimpleName(StringBuilder logBuff, String key, Class<?> value) {
        if (null == value) {
            return logBuff;
        }
        return checkBuff(logBuff).append(key).append(":").append(null != value ? value.getSimpleName() : null).append(",");
    }
    
    public static StringBuilder appendLogArrayBegin(StringBuilder logBuff, String key) {
        return checkBuff(logBuff).append(key).append(":[");
    }
    
    public static StringBuilder appendLogArrayFinish(StringBuilder logBuff) {
        return StringUtil.deleteEnd(checkBuff(logBuff), ',').append("]").append(",");
    }
    
    public static StringBuilder appendLogObjectBegin(StringBuilder logBuff, String key) {
        return checkBuff(logBuff).append(key).append(":{");
    }
    
    public static StringBuilder appendLogObjectFinish(StringBuilder logBuff) {
        return StringUtil.deleteEnd(checkBuff(logBuff), ',').append("}").append(",");
    }
    
    public static StringBuilder appendLogClassSimpleNameBegin(StringBuilder logBuff, Class<?> clazz) {
        return checkBuff(logBuff).append(null != clazz ? clazz.getSimpleName() : null).append(":{");
    }
    
    public static StringBuilder appendLogClassSimpleNameFinish(StringBuilder logBuff) {
        return StringUtil.deleteEnd(checkBuff(logBuff), ',').append("}").append(",");
    }
    
    public static StringBuilder appendLog(StringBuilder logBuff, String keyA, Object valueA, String keyB, Object valueB) {
        return checkBuff(logBuff).append("{").append(keyA).append(":")
                .append(valueA).append(",").append(keyB).append(":")
                .append(valueB).append("}").append(",");
    }
    
    public static StringBuilder appendLog(StringBuilder logBuff, String key, Object[] value) {
        if (null == value || 0 == value.length) {
            return logBuff;
        }
        return checkBuff(logBuff).append(key).append(":").append(Arrays.toString(value)).append(",");
    }
    
    public static StringBuilder appendLog(StringBuilder logBuff, String key, int value) {
        return checkBuff(logBuff).append(key).append(":").append(value).append(",");
    }
    
    public static StringBuilder appendIdLog(StringBuilder logBuff, String key, int value) {
        if (value < 1) {
            return logBuff;
        }
        return checkBuff(logBuff).append(key).append(":").append(value).append(",");
    }
    
    public static StringBuilder appendLog(StringBuilder logBuff, String key, int[] values) {
        if (null == values || 0 == values.length) {
            return logBuff;
        }
        logBuff = checkBuff(logBuff).append(key).append(":[");
        for (int i = 0; i < values.length; i++) {
            logBuff.append(values[i]).append(',');
        }
        StringUtil.deleteEnd(logBuff, ',');
        logBuff.append("],");
        return logBuff;
    }
    
    public static StringBuilder appendIdLog(StringBuilder logBuff, String key, long value) {
        if (value < 1) {
            return logBuff;
        }
        return checkBuff(logBuff).append(key).append(":").append(value).append(",");
    }
    
    public static StringBuilder appendLog(StringBuilder logBuff, String key, long value) {
        return checkBuff(logBuff).append(key).append(":").append(value).append(",");
    }
    
    public static StringBuilder appendLog(StringBuilder logBuff, String key, boolean value) {
        return checkBuff(logBuff).append(key).append(":").append(value).append(",");
    }
}
