package com.chryl.bean;

import java.io.Serializable;

/**
 * 检验授权凭证（access_token）是否有效
 * <p>
 * Created By Chr on 2019/7/29.
 */
public class WxAuthResult implements Serializable {
    private static final long serialVersionUID = 7802118519173900115L;
    /**
     access_token	是	调用接口凭证
     openid	是	普通用户标识，对该公众帐号唯一
     */
    /**
     * {
     * "errcode":0,"errmsg":"ok"
     * }
     */

    private int errcode;
    private String errmsg;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
