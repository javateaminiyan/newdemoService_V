package com.smw.velloredemo.Controllers;


import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import com.smw.velloredemo.response.HeaderRequestInterceptor;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
@Service
public class AndroidPushNotificationsService {

    private static final String FIREBASE_SERVER_KEY = "AAAAQKL7um4:APA91bGBdwzm619qW4IngbUqAfBts23pVOSDURvlLeM5rmFcKA7fn7eEMgvMfKEg6TAStsBipWOZj5DAS854FMJPiNEBDAhQyJbgbFQEMAi0vgQ3Q5xWDSfM_VJZWSblqJ_VUP9Vr3jL";
    private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";

    @Async
    public CompletableFuture<String> send(HttpEntity<String> entity) {

        RestTemplate restTemplate = new RestTemplate();

        /**
         https://fcm.googleapis.com/fcm/send
         Content-Type:application/json
         Authorization:key=FIREBASE_SERVER_KEY*/

        ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + FIREBASE_SERVER_KEY));
        interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));
        restTemplate.setInterceptors(interceptors);

        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
                try {
                    throw new Exception(clientHttpResponse.getStatusText());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        String firebaseResponse = restTemplate.postForObject(FIREBASE_API_URL, entity, String.class);



        return CompletableFuture.completedFuture(firebaseResponse);
    }
}