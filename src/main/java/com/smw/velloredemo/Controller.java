package com.smw.velloredemo;

import com.smw.velloredemo.Pojo.UserVo;
import com.smw.velloredemo.dao.LoginDao;
import com.smw.velloredemo.exception.UserAlreadyExistsException;
import com.smw.velloredemo.response.Error;
import com.smw.velloredemo.response.Success;
import com.smw.velloredemo.service.ILogin;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RequestMapping("/user")
@RestController
public class Controller {


    private final ILogin service;


    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    public Controller(ILogin service) {
        this.service = service;
    }


    @RequestMapping(value = "/checkuser/{userid}", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllUsers(@PathVariable("userid") String id) {
        logger.info("success");

        if (!service.findbyId(id).isPresent()) {
            return ResponseEntity.badRequest()
                    .body(new Error(HttpStatus.BAD_REQUEST, "No Record Found"));
        }


//        if (!service.findbyId(id).isPresent())
//            throw new UserNotFoundException("id-" + id);


        Optional<LoginDao> loginDao = service.findbyId(id);


        ArrayList<String> roles = new ArrayList<>();
        roles.clear();


        String[] numarray = loginDao.get().getRole().split(",");
        StringBuilder stringBuilder = new StringBuilder();

        for (String a : numarray) {
            stringBuilder.append(service.findRoles(Integer.parseInt(String.valueOf(a)))).append(",");
        }

        String removefront = stringBuilder.substring(0, stringBuilder.length() - 1).replace("[", "");
        String removeback = removefront.replace("]", "");
        UserVo userVo = new UserVo(loginDao.get().getUsername(), loginDao.get().getPassword(), removeback, loginDao.get().getMobileno(), String.valueOf(loginDao.get().getId()), loginDao.get().getCity(), loginDao.get().getFirebaseid());


        return new ResponseEntity<>(new Success(HttpStatus.OK, userVo), HttpStatus.OK);

    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody LoginDao loginDao) {


        if (service.findbyUsername(loginDao.getUsername()).isPresent()) {
            return ResponseEntity.badRequest()
                    .body(new Error(HttpStatus.BAD_REQUEST, "Username Already Exist"));
        } else if (service.findbyMobileno(loginDao.getMobileno()).isPresent()) {
            return ResponseEntity.badRequest()
                    .body(new Error(HttpStatus.BAD_REQUEST, "Mobile Number Already Exist"));
        }

        try {
            service.insertUser(loginDao);

        } catch (ConstraintViolationException e) { // detailed Exception is different by DBMS and JPA implemetation
            throw new UserAlreadyExistsException(e);
        }

        return new ResponseEntity<>(new Success(HttpStatus.CREATED, "New User is created successfully"), HttpStatus.CREATED);


    }


    @RequestMapping(value = "/forgotpassword/{id}/password/{password}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUser(@PathVariable("id") Integer id, @PathVariable("password") String password) {
        //cmeService.deleteCategory(id);

        String response = service.updatePassword(id, password);
        if (response.equalsIgnoreCase("Failed Update Password")) {
            return new ResponseEntity<>(new Error(HttpStatus.INTERNAL_SERVER_ERROR,"Failed Update Password"), HttpStatus.BAD_REQUEST);

        }

        return new ResponseEntity<>(new Success(HttpStatus.OK, service.updatePassword(id, password)), HttpStatus.OK);
    }

    @RequestMapping(value = "/userid/{userid}/firebaseid/{firebaseid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateFirebaseId(@PathVariable("userid") Integer id, @PathVariable("firebaseid") String firebaseid) {
        //cmeService.deleteCategory(id);
        String response = null;

        List<LoginDao> responsecheck = service.checkalreadyTokenPresent(firebaseid);

        if (responsecheck.size() > 0 && !(responsecheck.equals("Failed Update Token"))) {



            logger.info("inside");
            for (LoginDao loginDao : responsecheck) {

                response = service.updateFirebaseToken(Integer.parseInt(String.valueOf(loginDao.getId())), "null");

                if (response.equalsIgnoreCase("Failed Update Token")) {
                    logger.info("inside failed " + loginDao.getId());
                    return new ResponseEntity<>(new Error(HttpStatus.INTERNAL_SERVER_ERROR, service.updateFirebaseToken(id, firebaseid)), HttpStatus.BAD_REQUEST);


                }
            }
        }

        //   String response = service.updateFirebaseToken(id, firebaseid);

// service.updateFirebaseToken(id, firebaseid)
        logger.info("inside output");
        return new ResponseEntity<>(new Success(HttpStatus.OK, service.updateFirebaseToken(id, firebaseid)), HttpStatus.OK);
    }


    @RequestMapping(value = "/sendOtp", method = RequestMethod.POST)
    public ResponseEntity<Object> sendOtp(@RequestParam("mobileno") String mobileno) {
        Random rnd = new Random();
        int n = 100000 + rnd.nextInt(900000);
        final String uri = "http://smsstreet.in/websms/sendsms.aspx?userid=prematix&password=matixpre&sender=ETOWNS&mobileNo=" + mobileno + "&msg=your otp is " + n + "";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);


        if (result.contains("Success"))
            return new ResponseEntity<>(new Success(HttpStatus.OK, n), HttpStatus.OK);
        else
            return new ResponseEntity<>(new Success(HttpStatus.INTERNAL_SERVER_ERROR, "Otp Not Send to User"), HttpStatus.BAD_REQUEST);

    }


    @RequestMapping("/")
    public class CommonController {

        @GetMapping("/")
        public String Welcome() {
            return "Welcome";
        }

    }
}
