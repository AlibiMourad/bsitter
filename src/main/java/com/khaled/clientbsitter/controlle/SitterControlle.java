/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khaled.clientbsitter.controlle;

import com.khaled.clientbsitter.model.Sitter;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

public class SitterControlle {

    public String CreateNewSitter(Sitter sitter) throws Exception {
        HttpClient obj = new HttpClient();
        try {
            System.out.println("Send Http POST request");
            // add request parameter, form parameters
            JSONObject payload = new JSONObject();
            payload.put("name", "abc");
            payload.put("address", "123");
            payload.put("email", "secret@a.com");
            System.out.println(""+payload.toString());
            HttpPost request = new HttpPost("http://127.0.0.1:8080/api/sitter/");

            request.addHeader("content-type", "application/json");
            request.addHeader("Accept", "application/json");

            request.setEntity(new StringEntity(payload.toString(), ContentType.APPLICATION_JSON));

            obj.sendPost(request);
        } finally {
            obj.close();
        }
        return "OK";
    }
}
