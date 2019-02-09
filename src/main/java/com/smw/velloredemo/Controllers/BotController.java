package com.smw.velloredemo.Controllers;


import com.smw.velloredemo.response.Success;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/bot")
@RestController
public class BotController {


    private String train(String message) {

        String input = message.toLowerCase();


        if (input.contains("hi") || input.startsWith("hello")|| input.startsWith("இனிய"))
            return "Hi ! how can i help you?";
        if (input.contains("collected yet"))
            return "may i know your location address ?(keyword : startwith address ";
        if (input.startsWith("address"))
            return "Okay What do you want me to do? " + "1. Take action by myself? " + " 2. Diplay the municipal number?\n";
        if (input.startsWith("1") || input.contains("take action by myself?"))
            return "Ok your request is being processed. We'll notify you once its done.(Send request to control room about the issue and update the status for the user w.r.t user id).\n";
        if (input.startsWith("2") || input.contains("diplay the municipal number?"))
            return "9494811262(Make call)) " + "\n" + " Was the information useful?(Display Yes and no button)\n";
        if (input.startsWith("yes")) return "Hello Iniyan";
        if (input.startsWith("no"))
            return "Sorry to Hear that Please let me know how can i improve myself.\n";
        if (input.startsWith("description")) return "Thank you we'll consider your kind response.";


        return "Sorry No Data Found";
    }


    @GetMapping("/chat")
    public ResponseEntity<Object> chatbot(@Valid @RequestParam("userid") String userid, @Valid @RequestParam("message") String message) {

        if (userid.isEmpty() && message.isEmpty())
            throw new IllegalArgumentException("{\"error\":\" Enter userid and message  parameter is empty or not supplied\"}");
        return new ResponseEntity<>(new Success(HttpStatus.OK, train(message)), HttpStatus.OK);

    }


}
