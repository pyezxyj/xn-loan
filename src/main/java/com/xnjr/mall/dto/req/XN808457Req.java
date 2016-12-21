/**
 * @Title XN808454Req.java 
 * @Package com.xnjr.mall.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月21日 下午3:40:16 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * 周边汇赚宝列表查询
 * @author: haiqingzheng 
 * @since: 2016年12月21日 下午3:40:16 
 * @history:
 */
public class XN808457Req {
    // 经度
    private String longitude;

    // 纬度
    private String latitude;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

}
