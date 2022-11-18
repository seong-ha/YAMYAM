package com.mandu.yamyam.common;

import org.apache.commons.collections4.map.ListOrderedMap;
import org.springframework.jdbc.support.JdbcUtils;

public class LowerKeyMap extends ListOrderedMap { 
    /** serialVersionUID */
    private static final long serialVersionUID = -7700790403928325865L;
 
    /**
     * key 에 대하여 소문자로 변환하여 super.put
     * (ListOrderedMap) 을 호출한다.
     * @param key
     *        - '_' 가 포함된 변수명
     * @param value
     *        - 명시된 key 에 대한 값 (변경 없음)
     * @return previous value associated with specified
     *         key, or null if there was no mapping for
     *         key
     */
    public Object put(Object key, Object value) {
    	String strKey = JdbcUtils.convertUnderscoreNameToPropertyName((String)key);
    	strKey = strKey.substring(0,1).toLowerCase() + strKey.substring(1);
        return super.put(strKey, value);
    }
}

