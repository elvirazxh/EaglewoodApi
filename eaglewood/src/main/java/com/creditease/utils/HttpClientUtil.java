package com.creditease.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.SocketTimeoutException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @description http工具
 * @Author
 * @Date 18/8/13 15:33
 **/

public class HttpClientUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
    private static final String encoding = "UTF-8";

    private static void closeHttpClient(HttpClient httpClient, HttpResponse response) {
        if (null != httpClient) {
            HttpClientUtils.closeQuietly(httpClient);
        }

        if (null != response) {
            HttpClientUtils.closeQuietly(response);
        }
    }

    /**
     * 发送JSONString的post请求
     *
     * @param url
     * @param reqParams
     * @param timeOut
     * @return
     */
    public static String post(String url, JSONObject reqParams, int timeOut) {

        String respStr = "";
        HttpResponse response = null;
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(timeOut)
                .setConnectTimeout(timeOut)
                .setConnectionRequestTimeout(timeOut)
                .build();
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build();
        try {
            HttpPost post = new HttpPost(url);
            logger.info("请求参数：" + reqParams.toJSONString());
            StringEntity params = new StringEntity(reqParams.toJSONString(), "UTF-8");
            post.addHeader("content-type", "application/json;charset=UTF-8");
            post.setEntity(params);
            response = httpClient.execute(post);
            if (response.getStatusLine().getStatusCode() != 200) {
                logger.info("请求失败：" + response.getStatusLine().getStatusCode());
                logger.info("失败信息：" + response.getEntity());
            }
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                respStr = EntityUtils.toString(httpEntity, "utf-8");
                logger.info("响应信息:" + respStr);
            }
        } catch (SocketTimeoutException e) {
            logger.info("=============请求超时===============");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeHttpClient(httpClient, response);
        }
        return respStr;
    }

    /**
     * 发送Form表单的Post请求
     *
     * @param url
     * @param params
     * @return
     */
    public static String post(String url, Map<String, String> params, int timeOut) {
        String resStr = "";
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(timeOut)
                .setConnectTimeout(timeOut)
                .setConnectionRequestTimeout(timeOut)
                .build();
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(defaultRequestConfig)
                .build();
        HttpPost httppost = new HttpPost(url);
        HttpResponse response = null;

        try {
            // 传递参数
            if (null != params && !params.isEmpty()) {
                List<NameValuePair> formparams = new ArrayList<NameValuePair>();
                for (Entry<String, String> entry : params.entrySet()) {
                    String value = (null == entry.getValue()) ? "" : entry.getValue();
                    formparams.add(new BasicNameValuePair(entry.getKey(), value));
                }
                UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams, encoding);
                httppost.setEntity(uefEntity);
            }
            // 发送请求
            response = httpClient.execute(httppost);
            int status = response.getStatusLine().getStatusCode();
            if (200 != status) {
                throw new IOException("请求错误[StatusCode=" + status + "]");
            }
            HttpEntity entity = response.getEntity();
            if (null != entity) {
                resStr = EntityUtils.toString(entity, encoding);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeHttpClient(httpClient, response);
        }
        return resStr;

    }

    /**
     * 对象转换为map
     *
     * @param obj
     * @return
     */
    public static Map<String, String> objectToMap(Object obj) {
        if (obj == null)
            return null;
        Map<String, String> resMap = new HashMap<String, String>();
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        try {
            for (Field field : declaredFields) {
                field.setAccessible(true);
                // 过滤内容为空的
                if (field.get(obj) == null) {
                    continue;
                }
                String value = "";
                if (field.get(obj) instanceof Double) {
                    DecimalFormat format = new DecimalFormat("0.00");
                    value = format.format(field.get(obj));
                } else {
                    value = field.get(obj).toString();
                }
                resMap.put(field.getName(), value);
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return resMap;
    }


}

