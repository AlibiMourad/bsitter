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
import com.google.gson.Gson;
import com.khaled.clientbsitter.model.Parents;
import com.khaled.clientbsitter.model.Sitter;
import java.util.Arrays;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;


public class ParentsControlle {

    public String CreateNewParents(Parents parents) throws JsonProcessingException, Exception  {
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
    
    public List<Parents> getAllParents() throws Exception {
        
        List<Parents> listParents  = null;
        HttpClient httpClient = new HttpClient();
        
        HttpEntity entity = httpClient.sendGet("http://127.0.0.1:8080/api/parents/");
          if (entity != null) {
                //System.out.println("***ifff****");
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println("----" + result);
                Gson gson = new Gson();
                String json = gson.toJson(result);
                System.out.println("////" + json);
                  
                ObjectMapper mapper = new ObjectMapper();

                // 2. convert JSON array to List of objects
                listParents = Arrays.asList(mapper.readValue(result, Parents[].class));

//                System.out.println("......................"+ppl2.size());
//		for(Student st : studentArray) {
//			System.out.println(st.getId() + " " + st.getName());
//		}
            }
          return listParents;
    }

   
}
