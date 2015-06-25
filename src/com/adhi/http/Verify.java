package com.adhi.http;

import com.sun.xml.internal.xsom.impl.Ref;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.net.HttpCookie;
import java.net.URISyntaxException;

/**
 * Created by abhijaypaturi on 6/17/15.
 */
public class Verify {
    public static void main(String[] args) {
        HttpComm httpComm = new HttpComm();
        URIBuilder uriBuilder = new URIBuilder()
                .setScheme("http")
                .setHost("httpbin.org")
                .setPath("/get");
        try {
            String result = httpComm.doGet(uriBuilder.build());
            System.out.println(result);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        uriBuilder = new URIBuilder()
                .setScheme("http")
                .setHost("httpbin.org")
                .setPath("/post");
        try {
            String result = httpComm.doPost(uriBuilder.build(), "Hello, World", ContentType.TEXT_PLAIN);
            System.out.println(result);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
