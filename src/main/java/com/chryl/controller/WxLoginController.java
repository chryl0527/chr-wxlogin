package com.chryl.controller;

import com.chryl.bean.WxLoginResult;
import com.chryl.bean.WxRefreshResult;
import com.chryl.bean.WxUserInfoResult;
import com.chryl.util.HttpClientUtil;
import com.chryl.util.JsonUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By Chr on 2019/7/29.
 */
@RestController
@RequestMapping("/wx")
public class WxLoginController {

    //wx 授权登陆
    @RequestMapping("/login")
    public Object show(@RequestParam("code") String code) {
//        https://api.weixin.qq.com/sns/oauth2/access_token?
        // appid=APPID&
        // secret=SECRET&
        // code=CODE&
        // grant_type=authorization_code

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token";
        Map<String, String> params = new HashMap<>();
        params.put("appid", "wx6153699bbd6af4bf");//应用唯一标示
        params.put("secret", "xxx");//自己定义的
        params.put("code", code);//code为前端授权传递
        params.put("grant_type", "authorization_code");//固定

        String wxLoginStrResult = null;
        try {
            wxLoginStrResult = HttpClientUtil.doGet(url, params);
        } catch (Exception e) {
            e.printStackTrace();
            //{"errcode":40029,"errmsg":"invalid code"}
        }
        if (wxLoginStrResult != null) {
            WxLoginResult wxLoginResult = JsonUtil.jsonToPojo(wxLoginStrResult, WxLoginResult.class);
            return wxLoginResult;
        }
        return null;
    }


    //授权时:刷新access_token有效期
    @RequestMapping("/refresh")
    public Object show2(@RequestParam("refreshToken") String refreshToken) {
//        https://api.weixin.qq.com/sns/oauth2/refresh_token?
        // appid=APPID&
        // grant_type=refresh_token&
        // refresh_token=REFRESH_TOKEN
        String url = "https://api.weixin.qq.com/sns/oauth2/refresh_token";
        Map<String, String> params = new HashMap<>();
        params.put("appid", "wx6153699bbd6af4bf");//应用唯一标示
        params.put("grant_type", "refresh_token");//固定
        params.put("refresh_token", refreshToken);//refresh_token是第一次授权登陆返回的(wxLoginResult.refresh_token)
        String wxRefreshStrResult = null;
        try {
            wxRefreshStrResult = HttpClientUtil.doGet(url, params);
        } catch (Exception e) {
            e.printStackTrace();
            //{"errcode":40030,"errmsg":"invalid refresh_token"}
        }
        if (wxRefreshStrResult != null) {
            WxRefreshResult wxRefreshResult = JsonUtil.jsonToPojo(wxRefreshStrResult, WxRefreshResult.class);
            return wxRefreshResult;
        }
        return null;
    }

    //授权后接口调用（UnionID）#####################################################################

    //通过code获取access_token
    public void show3() {
//        https://api.weixin.qq.com/sns/oauth2/access_token?
        // appid=APPID&
        // secret=SECRET&
        // code=CODE&
        // grant_type=authorization_code
    }

    //刷新或续期access_token使用
    public void show4() {
//        https://api.weixin.qq.com/sns/oauth2/refresh_token?
        // appid=APPID&
        // grant_type=refresh_token&
        // refresh_token=REFRESH_TOKEN
    }

    //检验授权凭证（access_token）是否有效
    @RequestMapping("/access")
    public void show5() {
//        https://api.weixin.qq.com/sns/auth?
        // access_token=ACCESS_TOKEN&
        // openid=OPENID
        Map<String, String> params = new HashMap<>();
        params.put("access_token", "");//调用接口凭证
        params.put("openid", "");//普通用户标识，对该公众帐号唯一

    }

    //获取用户个人信息（UnionID机制）
    @RequestMapping("/wx-userinfo")
    public Object show6() {
        /**
         access_token	是	调用凭证
         openid	是	普通用户的标识，对当前开发者帐号唯一
         lang	否	国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语，默认为zh-CN
         */
        /**
         通过code换取access_token	1万/分钟
         刷新access_token	5万/分钟
         获取用户基本信息	5万/分钟
         */
//        https://api.weixin.qq.com/sns/userinfo?
        // access_token=ACCESS_TOKEN&
        // openid=OPENID
        String url = "https://api.weixin.qq.com/sns/userinfo";
        Map<String, String> params = new HashMap<>();
        params.put("access_token", "");//调用凭证
        params.put("openid", "");
        params.put("lang", "zh_CN ");
        String wxUserInfoStrRestlt = null;
        try {
            wxUserInfoStrRestlt = HttpClientUtil.doGet(url, params);
        } catch (Exception e) {
            e.printStackTrace();
            //"errcode":40003,"errmsg":"invalid openid"
        }
        WxUserInfoResult wxUserInfoResult = JsonUtil.jsonToPojo(wxUserInfoStrRestlt, WxUserInfoResult.class);
        return wxUserInfoResult;
    }


}
