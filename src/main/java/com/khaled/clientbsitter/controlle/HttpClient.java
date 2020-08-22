/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khaled.clientbsitter.controlle;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import com.google.gson.Gson;
import com.khaled.clientbsitter.model.Parents;
import java.util.Arrays;
import java.util.List;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;

/**
 *
 * @author xfrag
 */
class HttpClient {

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public HttpEntity sendGet(String url) throws Exception {

//        HttpGet request = new HttpGet("http://127.0.0.1:8080/api/parents/");
        HttpGet request = new HttpGet(url);

        // add request headers
        request.addHeader("custom-key", "mkyong");
        request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");

        CloseableHttpResponse response = httpClient.execute(request);

        // Get HttpResponse Status
//            System.out.println("****Get HttpResponse Status****");
        //System.out.println(response.getStatusLine().toString());
        //System.out.println("****Get headers ****");
        HttpEntity entity = response.getEntity();
        //Header headers = (Header) entity.getContentType();
        //System.out.println(headers);

        return entity;

    }

    public void close() throws IOException {
        httpClient.close();
    }

    void sendPost(HttpPost request) throws Exception {

        try (
                CloseableHttpClient httpClient = HttpClients.createDefault();
                CloseableHttpResponse response = httpClient.execute(request)) {

            System.out.println(EntityUtils.toString(response.getEntity()));
        }

    }

    void sendPut(HttpPut request) throws Exception {

        try (
                CloseableHttpClient httpClient = HttpClients.createDefault();
                CloseableHttpResponse response = httpClient.execute(request)) {

//            System.out.println(EntityUtils.toString(response.getEntity()));
        }

    }

    void sendDelete(HttpDelete request) throws Exception {
        try (
                CloseableHttpClient httpClient = HttpClients.createDefault();
                CloseableHttpResponse response = httpClient.execute(request)) {
//            System.out.println(EntityUtils.toString(response.getEntity()));
        }
    }
}
