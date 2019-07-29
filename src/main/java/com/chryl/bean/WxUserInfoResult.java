package com.chryl.bean;

import java.io.Serializable;

/**
 * Created By Chr on 2019/7/29.
 */
public class WxUserInfoResult implements Serializable {
    private static final long serialVersionUID = 7855078812985194188L;

    /**
     此接口用于获取用户个人信息。开发者可通过OpenID来获取用户基本信息。
     特别需要注意的是，如果开发者拥有多个移动应用、网站应用和公众帐号，
     可通过获取用户基本信息中的unionid来区分用户的唯一性，
     因为只要是同一个微信开放平台帐号下的移动应用、网站应用和公众帐号，
     用户的unionid是唯一的。换句话说，同一用户，对同一个微信开放平台下的不同应用，
     unionid是相同的。请注意，在用户修改微信头像后，旧的微信头像URL将会失效，
     因此开发者应该自己在获取用户信息后，将头像图片保存下来，避免微信头像URL失效后的异常情况。
     */

    /**
     {
     "openid":"OPENID",
     "nickname":"NICKNAME",
     "sex":1,
     "province":"PROVINCE",
     "city":"CITY",
     "country":"COUNTRY",
     "headimgurl": "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/0",
     "privilege":[
     "PRIVILEGE1",
     "PRIVILEGE2"
     ],
     "unionid": " o6_bmasdasdsad6_2sgVt7hMZOPfL"

     }
     */
    /**
     * openid	普通用户的标识，对当前开发者帐号唯一
     * nickname	普通用户昵称
     * sex	普通用户性别，1为男性，2为女性
     * province	普通用户个人资料填写的省份
     * city	普通用户个人资料填写的城市
     * country	国家，如中国为CN
     * headimgurl	用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
     * privilege	用户特权信息，json数组，如微信沃卡用户为（chinaunicom）
     * unionid	用户统一标识。针对一个微信开放平台帐号下的应用，同一用户的unionid是唯一的。
     * <p>
     * 建议：
     * 开发者最好保存用户unionID信息，以便以后在不同应用中进行用户信息互通。
     */

    private String openid;
    private String nickname;
    private int sex;
    private String province;
    private String city;
    private String country;
    private String headimgurl;
    private String[] privilege;
    private String unionid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String[] getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String[] privilege) {
        this.privilege = privilege;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
