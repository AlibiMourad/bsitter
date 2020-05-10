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
import com.khaled.clientbsitter.model.Parents;
import com.khaled.clientbsitter.model.Sitter;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;


public class ParentsControlle {

    public String CreateNewParents(Parents parents) throws JsonProcessingException, Exception {
        HttpClient obj = new HttpClient();
        try {
            System.out.println("Send Http POST request");
            ObjectMapper mapper = new ObjectMapper();
            // Converting the Object to JSONString
            String jsonString = mapper.writeValueAsString(parents);
            
            HttpPost request = new HttpPost("http://127.0.0.1:8080/api/parents//");
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
}
