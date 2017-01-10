package com.cdkj.loan.bo;

public interface ISmsOutBO {
    /**
     * 发送指定内容短信
     * @param mobile
     * @param content
     * @param bizType
     * @return 
     * @create: 2016年10月17日 下午5:47:45 xieyj
     * @history:
     */
    public void sendSmsOut(String mobile, String content, String bizType);

    /**
     * 发送短信
     * @param tokenId
     * @param userId
     * @param content 
     * @create: 2015年11月17日 下午3:37:54 myb858
     * @history:
     */
    void sentContent(String tokenId, String userId, String content);
}
