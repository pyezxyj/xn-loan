/**
 * @Title XN808400Req.java 
 * @Package com.xnjr.mall.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年12月19日 下午4:30:17 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * @author: haiqingzheng 
 * @since: 2016年12月19日 下午4:30:17 
 * @history:
 */
public class XN808400Req {
    // 编号（必填）
    private String code;

    // 名称（必填）
    private String name;

    // 图片（选填）
    private String pic;

    // 玩法描述（选填）
    private String description;

    // 股本（必填）
    private String capital;

    // 价格（必填）
    private String price;

    // 返还间隔（必填）
    private String backInterval;

    // 返还福利1（必填）
    private String welfare1;

    // 返还福利2（选填）
    private String welfare2;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBackInterval() {
        return backInterval;
    }

    public void setBackInterval(String backInterval) {
        this.backInterval = backInterval;
    }

    public String getWelfare1() {
        return welfare1;
    }

    public void setWelfare1(String welfare1) {
        this.welfare1 = welfare1;
    }

    public String getWelfare2() {
        return welfare2;
    }

    public void setWelfare2(String welfare2) {
        this.welfare2 = welfare2;
    }

}
