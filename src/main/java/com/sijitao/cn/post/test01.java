package com.sijitao.cn.post;

//import com.sun.deploy.cache.CachedJarFile;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;


import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class test01 {


    /*POST请求*/

    @Rule
    public ContiPerfRule i = new ContiPerfRule();

    @Test
    @PerfTest(invocations = 300, threads = 3)
    public void test01() throws IOException {

        //建立连接请求CloseableHttpClient最新的实现类
        CloseableHttpClient htpclient = HttpClients.createDefault();
        //建立连接
        HttpPost httpPost = new HttpPost("http://localhost:8080/user/useBody");
        //创建参数队列
        List<NameValuePair> nameValuePairList = new ArrayList<>();
        //准备请求参数队列
        nameValuePairList.add(new BasicNameValuePair("userName", "aobama"));
        nameValuePairList.add(new BasicNameValuePair("password", "admin123"));
        nameValuePairList.add(new BasicNameValuePair("nickname", "张三"));
        //设置字符集编码为UTF-8
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairList, "UTF-8");
        //讲实体封装到请求当中
        httpPost.setEntity(urlEncodedFormEntity);
        //发送请求
        CloseableHttpResponse response = htpclient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            System.out.println("接收到的响应信息:--------" + EntityUtils.toString(entity, "UTF-8"));
        }
        //资源释放
        response.close();
        htpclient.close();
    }

    /*json*/
    public void test02() throws IOException {
        //建立连接请求CloseableHttpClient最新的实现类
        CloseableHttpClient htpclient = HttpClients.createDefault();
        //建立连接
        HttpPost httpPost = new HttpPost("http://localhost:8080/user/useBody");
        //创建参数队列
        List<NameValuePair> nameValuePairList = new ArrayList<>();
        //准备请求参数队列
        nameValuePairList.add(new BasicNameValuePair("userName", "aobama"));
        nameValuePairList.add(new BasicNameValuePair("password", "admin123"));
        nameValuePairList.add(new BasicNameValuePair("nickname", "张三"));
        //设置字符集编码为UTF-8
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairList, "UTF-8");
        //讲实体封装到请求当中
        httpPost.setEntity(urlEncodedFormEntity);
        //发送请求
        CloseableHttpResponse response = htpclient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            System.out.println("接收到的响应信息:--------" + EntityUtils.toString(entity, "UTF-8"));
        }
        //资源释放
        response.close();
        htpclient.close();
    }
}
