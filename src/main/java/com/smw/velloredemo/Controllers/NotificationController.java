package com.smw.velloredemo.Controllers;


import com.smw.velloredemo.dao.AlertSubscription;
import com.smw.velloredemo.dao.AlertSubscriptionUser;
import com.smw.velloredemo.exception.UserAlreadyExistsException;
import com.smw.velloredemo.repository.AOIRepo;
import com.smw.velloredemo.repository.AlertSubscriptionUserRepo;
import com.smw.velloredemo.repository.NotificationSubscription;
import com.smw.velloredemo.response.*;
import com.smw.velloredemo.response.Error;
import javafx.scene.control.Alert;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/Notification")
public class NotificationController {

    private LocalDateTime now = LocalDateTime.now();

    @Autowired
    AOIRepo aoiRepo;

    private final String TOPIC = "JavaSampleApproach";

    private final AndroidPushNotificationsService androidPushNotificationsService;

    private final NotificationSubscription notificationSubscription;

    private final AlertSubscriptionUserRepo alertSubscriptionUserRepo;


    private List<notificationdata> listofnotificationdata = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(ControlroomController.class);

    @Autowired
    public NotificationController(AndroidPushNotificationsService androidPushNotificationsService, NotificationSubscription notificationSubscription, AlertSubscriptionUserRepo alertSubscriptionUserRepo) {
        this.androidPushNotificationsService = androidPushNotificationsService;
        this.notificationSubscription = notificationSubscription;
        this.alertSubscriptionUserRepo = alertSubscriptionUserRepo;
    }

//    @PostMapping("/sendnotification")
//    public ResponseEntity<Object> firebaseMessagingSendMessageUser(@Valid @RequestBody List<NotificationRequest> reqnotificationdata) {
//        listofnotificationdata.clear();
//        String url = "https://fcm.googleapis.com/fcm/send";
////
////        HttpHeaders responseHeaders = new HttpHeaders();
////        responseHeaders.set("Content-Type", "application/json");
////        responseHeaders.set("project_id", "569624951379");
////        responseHeaders.set("Authorization", "AAAAhKBK-lM:APA91bFtJHUKsyE9D6sHEiq5BDCv4EvyJsTVNP9lHlkHU4iC5I7trwWRY9-ccABhNd4LB8w8ea091TLkK1TP4-MRXVY88c140KjmDwdM_JB7OlgEin3aYmRIHaXF9PcopGTdSaXMlNn9");
////        responseHeaders.set("Accept:", "application/json");
//
//
//        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
//        interceptors.add(new HeaderRequestInterceptor("Accept", MediaType.APPLICATION_JSON_VALUE));
//        interceptors.add(new HeaderRequestInterceptor("Content-Type", MediaType.APPLICATION_JSON_VALUE));
//        interceptors.add(new HeaderRequestInterceptor("Authorization", "key=AAAAQKL7um4:APA91bGBdwzm619qW4IngbUqAfBts23pVOSDURvlLeM5rmFcKA7fn7eEMgvMfKEg6TAStsBipWOZj5DAS854FMJPiNEBDAhQyJbgbFQEMAi0vgQ3Q5xWDSfM_VJZWSblqJ_VUP9Vr3jL"));
//
//
//        //   notificationdata notificationdata = new notificationdata("chVxyimq6Xk:APA91bEc1sRDqMOzk14VF7NztmrzlDTKdbYQHGmiwfauDUVeeZiTG5laZ46duydclD9ZOWxQV7WAM9yuVQYuXSRFMq92oCfCeq1MfqF0A-8KnHashgXT8uHLx2L78FoWZYg442EcKDKh", "Hello", "This is test message.", now);
//        if (reqnotificationdata.size() > 0) {
//
//
//            for (NotificationRequest notificationdata : reqnotificationdata) {
//                logger.info("notificationdata" + notificationdata.getNotification().getBody() + "notification " + notificationdata.getNotification().getTitle() + "date" + notificationdata.getNotification().getJsonobject());
//
//                notificationdata notificationdataitems = new notificationdata(notificationdata.getTo(), notificationdata.getNotification().getBody(), notificationdata.getNotification().getTitle(), notificationdata.getNotification().getJsonobject(), now);
//                listofnotificationdata.add(notificationdataitems);
//            }
//
//        } else
//            return new ResponseEntity<>(new Error(HttpStatus.INTERNAL_SERVER_ERROR, "No Data Present In Body"), HttpStatus.INTERNAL_SERVER_ERROR);
//
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setInterceptors(interceptors);
//
//        restTemplate.setErrorHandler(new ResponseErrorHandler() {
//            @Override
//            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
//                return false;
//            }
//
//            @Override
//            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
//                try {
//                    throw new Exception(clientHttpResponse.getStatusText());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        for (notificationdata notificationdata : listofnotificationdata) {
//
//            logger.info("notificationdata" + notificationdata.getBody() + "notification " + notificationdata.getTitle() + "date" + notificationdata.getDate());
//            ResponseEntity<NotificationResponse> result = restTemplate.postForEntity(url, notificationdata, NotificationResponse.class);
//            if (Objects.requireNonNull(result.getBody()).getSuccess() == 1)
//                return new ResponseEntity<>(new Success(HttpStatus.OK, "Message Send Successfully"), HttpStatus.OK);
//
//            else
//                return new ResponseEntity<>(new Error(HttpStatus.INTERNAL_SERVER_ERROR, "Message not Send"), HttpStatus.INTERNAL_SERVER_ERROR);
//
//        }
//        return null;
//    }
//


    @PutMapping("/SubscribeUpdate")
    public ResponseEntity<Object> insert(
            @Valid @RequestParam("recordid") long userid, @RequestParam("status") String status) {

        alertSubscriptionUserRepo.updateById(status, userid);

        return new ResponseEntity<>(new Success(HttpStatus.OK, "Successfully Updated"), HttpStatus.OK);

    }


    @GetMapping("/notificationSubscription")
    public ResponseEntity<Object> notificationSubscription(@RequestParam("userid") String userid) {


        List<AlertSubscriptionUser> alertSubscriptionUsersList = new ArrayList<>();

        alertSubscriptionUsersList.clear();
        if (alertSubscriptionUserRepo.findbyUserid(userid).size() > 0) {


            return new ResponseEntity<>(new Success(HttpStatus.OK, alertSubscriptionUserRepo.findAll()), HttpStatus.OK);

        } else {

            AlertSubscriptionUser alertSubscriptionUser = new AlertSubscriptionUser();
            List<AlertSubscription> alertSubscriptions = notificationSubscription.findAll();
            for (int i = 0; i < notificationSubscription.findAll().size(); i++) {

                logger.info("Subscribe" + alertSubscriptions.get(i).getSubscriptionname());
                alertSubscriptionUsersList.add(new AlertSubscriptionUser(userid, alertSubscriptions.get(i).getSubscriptionname(), alertSubscriptions.get(i).getEnable()));
            }
            alertSubscriptionUserRepo.saveAll(alertSubscriptionUsersList);

            return new ResponseEntity<>(new Success(HttpStatus.OK, alertSubscriptionUsersList), HttpStatus.OK);

        }

        //return new ResponseEntity<>(new Success(HttpStatus.OK, notificationSubscription.findAll()), HttpStatus.OK);
    }


    @RequestMapping(value = "/send", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> send() throws JSONException {

        JSONObject body = new JSONObject();
        body.put("to", "/topics/" + TOPIC);
        body.put("priority", "high");

        JSONObject notification = new JSONObject();
        notification.put("title", "JSA Notification");
        notification.put("body", "Happy Message!");

        JSONObject data = new JSONObject();
        data.put("Key-1", "JSA Data 1");
        data.put("Key-2", "JSA Data 2");

        body.put("notification", notification);
        return getStringResponseEntity(body, data);
    }


    @RequestMapping(value = "/dataNotification", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> simpledataNotification(
            @RequestParam("usertoken") String token,
            @RequestParam("title") String title,
            @RequestParam("message") String message,
            @RequestParam("image") String image

    ) throws JSONException {

        JSONObject body = new JSONObject();
        body.put("to", token);
        return getStringResponseEntity(title, message, image, body);
    }

    private ResponseEntity<String> getStringResponseEntity(@RequestParam("title") String title, @RequestParam("message") String message, @RequestParam("image") String image, JSONObject body) throws JSONException {
        body.put("priority", "high");
        JSONObject data = new JSONObject();
        data.put("title", title);
        data.put("body", message);
        data.put("imageUrl", image);
        data.put("date", now.toString());
        return getStringResponseEntity(body, data);
    }


    @RequestMapping(value = "/topicNotification", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> simpletopicNotification(
            @RequestParam("title") String title,
            @RequestParam("message") String message,
            @RequestParam("image") String image,
            @RequestParam("topics") String topics

    ) throws JSONException {

        JSONObject body = new JSONObject();
        body.put("to", "/topics/" + topics);
        return getStringResponseEntity(title, message, image, body);
    }


    @RequestMapping(value = "/conditionNotification", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> simpleconditionnotification(
            @RequestParam("title") String title,
            @RequestParam("message") String message,
            @RequestParam("image") String image,
            @RequestParam("condition") String condition

    ) throws JSONException {

        JSONObject body = new JSONObject();
        body.put("condition", condition);
        return getStringResponseEntity(title, message, image, body);
    }


    private ResponseEntity<String> getStringResponseEntity(JSONObject body, JSONObject data) throws JSONException {
        body.put("data", data);

        HttpEntity<String> request = new HttpEntity<>(body.toString());

        CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
        CompletableFuture.allOf(pushNotification).join();

        try {
            String firebaseResponse = pushNotification.get();

            return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
    }



    @GetMapping("/getAreaofInterest")
    public ResponseEntity<Object> getAllSkills(){


        return new ResponseEntity<>(aoiRepo.findAll(), HttpStatus.OK);

    }






/*
 *
Simple Notification :


{
   "to": "djoXL7S3JB8:APA91bGPwhIU2eyt8RxEnfy8nEd-14urEDMaRpwKOjeFszYP26_xCGICwJDqd13PmQNuAJr1Z2fExarkdW85rppSuBh4ljRWBPe7WnOjLtXKoOhHwecFIqjrpc7gtwtccK1MnGWqrp-8",
 "notification"  : {
     "body" : "hi iniyan",
     "title": "Title hi iniyan"
 }
   }


Image Notification


{
   "to": "djoXL7S3JB8:APA91bGPwhIU2eyt8RxEnfy8nEd-14urEDMaRpwKOjeFszYP26_xCGICwJDqd13PmQNuAJr1Z2fExarkdW85rppSuBh4ljRWBPe7WnOjLtXKoOhHwecFIqjrpc7gtwtccK1MnGWqrp-8",

"data"  : {

   	 "body" : "This is a Firebase Cloud Messaging Topic Message!",
    "title" : "FCM Message",
"imageUrl":"https://images.pexels.com/photos/380768/pexels-photo-380768.jpeg?auto=compress&cs=tinysrgb&h=650&w=940",
"date":"28/01/19"
 }
   }



Topic Based Notification
{

   "to": "/topics/JavaSampleApproach",


"data"  : {

   	 "body" : "This is a Firebase Cloud Messaging Topic Message!",
    "title" : "FCM Message",
"imageUrl":"https://images.pexels.com/photos/380768/pexels-photo-380768.jpeg?auto=compress&cs=tinysrgb&h=650&w=940",
"date":"28/01/19"
 }

 }





Topic message Condition
 {
  "condition": "'JavaSampleApproach' in topics || 'Do' in topics",
  "priority" : "high",
   "data": {

   	 "body" : "This is a Firebase Cloud Messaging Topic Message!",
    "title" : "FCM Message",
		    "imageUrl":"https://images.pexels.com/photos/380768/pexels-photo-380768.jpeg?auto=compress&cs=tinysrgb&h=650&w=940",
"date":"28/01/19",
"topic":"condition"
		   }
}

  *
  *
  * */

}
