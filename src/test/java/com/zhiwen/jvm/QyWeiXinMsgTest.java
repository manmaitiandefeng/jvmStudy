package com.zhiwen.jvm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhiwen.jvm.util.CastUtil;
import com.zhiwen.jvm.util.HttpClientUtil;
import org.assertj.core.util.Maps;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 企业微信
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QyWeiXinMsgTest {

    private static String QYWX_DOMAIN = "https://qyapi.weixin.qq.com/";

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void getAccessToken(){

        Object o = redisTemplate.opsForValue().get("qywx_wx0d022bd4699839c9");
        if(Objects.nonNull(o)){
            return ;
        }

        //first getAccessToken
        String getAccessTokenUrl =QYWX_DOMAIN.concat("cgi-bin/gettoken?").concat(String.format("corpid=%s&corpsecret=%s", "wx0d022bd4699839c9", "00etYeBM9R8VM10SpqEEAxIx0QZWea4nXoBmKXD1SmU"));
        String respStr = HttpClientUtil.get(getAccessTokenUrl);
        System.out.println("getAccessToken:"+respStr);
        JSONObject respObj = JSON.parseObject(respStr);
        Assert.assertEquals(respObj.getString("errcode"),"0");
        redisTemplate.opsForValue().set(String.format("qywx_%s", "wx0d022bd4699839c9"),
            respObj.getString("access_token"));
        System.out.println("缓存放入成功");
    }

    @Test
    public void getUserList(){

        Object o = redisTemplate.opsForValue().get("qywx_wx0d022bd4699839c9");
        String accessToken = CastUtil.castString(o);
        //first getAccessToken
        String simplelist =QYWX_DOMAIN.concat("cgi-bin/user/simplelist?").concat(String.format("access_token=%s&department_id=%s", accessToken,19));
        String respStr = HttpClientUtil.get(simplelist);
        System.out.println("simplelist:"+respStr);
        JSONObject respObj = JSON.parseObject(respStr);
        Assert.assertEquals(respObj.getString("errcode"),"0");
        JSONArray userlist = respObj.getJSONArray("userlist");
        List<String> userIdList = IntStream.range(0, userlist.size()).mapToObj(userlist::getJSONObject).map(jsonObject -> jsonObject.getString("userid")).collect(Collectors.toList());
        redisTemplate.opsForList().rightPush("userList",userIdList);
        System.out.println("成员数组:"+JSON.toJSONString(userIdList));
    }

    @Test
    public void sendMsg(){

        Object o = redisTemplate.opsForValue().get("qywx_wx0d022bd4699839c9");
        String accessToken = CastUtil.castString(o);
        //first getAccessToken


        Object o1 = redisTemplate.opsForList().leftPop("userList");
        List<String> userList = (List<String>) o1;
        Assert.assertTrue("成员用户为空",!CollectionUtils.isEmpty(userList));

        String simplelist =QYWX_DOMAIN.concat("cgi-bin/message/send?").concat(String.format("access_token=%s", accessToken));

        Map<String,Object> body = new HashMap<>();
        String collect = userList.stream().collect(Collectors.joining("|"));
        body.put("touser",userList.size()==1?userList.get(0):collect);
        body.put("toparty",19);
        body.put("msgtype","text");
        body.put("agentid",1000014);
        body.put("text",Maps.newHashMap("content","开始测试"));

        String respStr = HttpClientUtil.postJson(simplelist, JSON.toJSONString(body));
        System.out.println("send:"+respStr);
        JSONObject respObj = JSON.parseObject(respStr);
        Assert.assertEquals(respObj.getString("errcode"),"0");

        System.out.println("消息id:"+respObj.getString("msgid"));
    }
}
