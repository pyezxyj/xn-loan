/**
 * @Title EDictType.java 
 * @Package com.std.security.enums 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月17日 下午5:15:02 
 * @version V1.0   
 */
package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

/** 
 * @author: haiqingzheng 
 * @since: 2016年4月17日 下午5:15:02 
 * @history:
 */
public enum EAccessLevel {
    YWY("1", "业务员等级"), DCY("1", "调查员等级"), CJGL("5", "超级管理员等级");

    public static Map<String, EAccessLevel> getDictTypeMap() {
        Map<String, EAccessLevel> map = new HashMap<String, EAccessLevel>();
        for (EAccessLevel dictType : EAccessLevel.values()) {
            map.put(dictType.getCode(), dictType);
        }
        return map;
    }

    EAccessLevel(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
