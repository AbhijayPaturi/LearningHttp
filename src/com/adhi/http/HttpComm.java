package com.adhi.http;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * Created by abhijaypaturi on 6/17/15.
 */
public class HttpComm {

    CloseableHttpClient httpClient;

    public HttpComm() {
        httpClient = HttpClients.createDefault();
    }

    public String doGet(URI uri) throws IOException {
        StringBuffer result = new StringBuffer();
        HttpGet httpGet = new HttpGet(uri);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);

            System.out.println(response.getStatusLine());

            HttpEntity httpEntity = response.getEntity();
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(httpEntity.getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            response.close();
        }
        return result.toString();
    }

    public String doPost(URI uri, String data, ContentType contentType) throws IOException {
        StringBuffer result = new StringBuffer();
        HttpPost httpPost = new HttpPost(uri);
        httpPost.setEntity(new StringEntity(data, contentType));
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);

            System.out.println(response.getStatusLine());

            HttpEntity httpEntity = response.getEntity();
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(httpEntity.getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            response.close();
        }
        return result.toString();
    }

}
