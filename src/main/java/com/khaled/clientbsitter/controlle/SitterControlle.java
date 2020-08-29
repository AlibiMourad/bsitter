/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 * add request parameter, form parameters
 * JSONObject payload = new JSONObject();
 * payload.put("name", "abc");
 * payload.put("address", "123");
 * payload.put("email", "secret@a.com");
 * System.out.println(""+payload.toString());
 * Creating the ObjectMapper object
 
 */
package com.khaled.clientbsitter.controlle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.khaled.clientbsitter.model.Sitter;
import java.util.Arrays;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

public class SitterControlle {

    public String createNewSitter(Sitter sitter) throws JsonProcessingException, Exception {
        HttpClient obj = new HttpClient();
        try {
            System.out.println("Send Http POST request");
            ObjectMapper mapper = new ObjectMapper();
            // Converting the Object to JSONString
            String jsonString = mapper.writeValueAsString(sitter);

            HttpPost request = new HttpPost("http://127.0.0.1:8080/api/sitter/");
            request.addHeader("content-type", "application/json");
            request.addHeader("Accept", "application/json");

            System.out.println(jsonString);
            request.setEntity(new StringEntity(jsonString, ContentType.APPLICATION_JSON));

            obj.sendPost(request);
        } finally {
            obj.close();
        }

        return "OK";
    }

    /*  public List<Sitter> getListSitter() throws JsonProcessingException, Exception {
         HttpClient obj = new HttpClient();
         //obj.sendGet();
       HttpClient obj = new HttpClient();
        try {
            System.out.println("Send Http GET request");
            ObjectMapper mapper = new ObjectMapper();
            // Converting the Object to JSONString
            // String jsonString = mapper.writeValueAsString(sitter);
            
            HttpGet request = new HttpGet("http://127.0.0.1:8080/api/sitter/");
            request.addHeader("content-type", "application/json");
            request.addHeader("Accept", "application/json");

           // System.out.println(jsonString);
            //request.setEntity(new StringEntity(jsonString, ContentType.APPLICATION_JSON));

           // obj.sendPost(request);
        } finally {
            obj.close();
        }
        
        return null;
return null;
    }*/
    public List<Sitter> getAllSitters() throws Exception {
        List<Sitter> listSitters = null;
        HttpClient httpClient = new HttpClient();

        HttpEntity entity = httpClient.sendGet("http://127.0.0.1:8080/api/sitter/");
        if (entity != null) {
            String result = EntityUtils.toString(entity);
            System.out.println("----" + result);
            /* Gson gson = new Gson();
            String json = gson.toJson(result);
            System.out.println("////" + json);
             */
            ObjectMapper mapper = new ObjectMapper();

            // 2. convert JSON array to List of objects
            listSitters = Arrays.asList(mapper.readValue(result, Sitter[].class));
        }
        return listSitters;
    }

    public String updateSitter(Sitter sitter) throws JsonProcessingException, Exception {
        HttpClient obj = new HttpClient();
        try {
            System.out.println("Send Http PUT request");
            ObjectMapper mapper = new ObjectMapper();
            // Converting the Object to JSONString
            String jsonString = mapper.writeValueAsString(sitter);

            HttpPut request = new HttpPut("http://127.0.0.1:8080/api/sitter/" + sitter.getId());
            request.addHeader("content-type", "application/json");
            request.addHeader("Accept", "application/json");

            System.out.println(jsonString);
            request.setEntity(new StringEntity(jsonString, ContentType.APPLICATION_JSON));

            obj.sendPut(request);
        } finally {
            obj.close();
        }

        return "OK";
    }

    public String deleteSitter(Long id) throws Exception {
        HttpClient obj = new HttpClient();
        try {
            System.out.println("Send Http POST request");
            ObjectMapper mapper = new ObjectMapper();
            // Converting the Object to JSONString
//            String jsonString = mapper.writeValueAsString(sitter);

            HttpDelete request = new HttpDelete("http://127.0.0.1:8080/api/sitter/" + id);
            request.addHeader("content-type", "application/json");
            request.addHeader("Accept", "application/json");

//            System.out.println(jsonString);
//            request.setEntity(new StringEntity(jsonString, ContentType.APPLICATION_JSON));

            obj.sendDelete(request);
        } finally {
            obj.close();
        }

        return "OK";
    }

}
