package com.smw.velloredemo.Controllers;


import com.smw.velloredemo.dao.RFIDDao;

import com.smw.velloredemo.dao.VehiclReportDao;
import com.smw.velloredemo.dao.VehicleMasterDao;
import com.smw.velloredemo.exception.UserAlreadyExistsException;
import com.smw.velloredemo.repository.UserDaoImpl;
import com.smw.velloredemo.response.Error;

import com.smw.velloredemo.response.RfidResult;
import com.smw.velloredemo.response.Success;
import com.smw.velloredemo.service.IRFIDQRService;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@RequestMapping("/scan")
@RestController()
public class RFID_QRController {
    private static final Logger logger = LoggerFactory.getLogger(RFID_QRController.class);


    private final IRFIDQRService irfidqrService;
    @Autowired
    UserDaoImpl sqlRepository;

    @Autowired
    public RFID_QRController(IRFIDQRService irfidqrService) {
        this.irfidqrService = irfidqrService;
    }

    @GetMapping("/rfidorqrcheck")
    public ResponseEntity<Object> rfid_qrCheck(@Valid @RequestParam("rfidqr") String rfid_or_qrcode) {

        Success result = null;
        if (rfid_or_qrcode.isEmpty())
            return new ResponseEntity<>(new Error(HttpStatus.OK, "Rfid or QRCode is Empty"), HttpStatus.OK);

        Optional<RFIDDao> rfidDao = irfidqrService.getUserandVehicleDetails(rfid_or_qrcode);

        //    logger.info("Userid " + rfidDao.get().getUserid());


        if (rfidDao.isPresent()) {


            logger.info("Userid " + rfidDao.get().getUserid());

            final String uri = "http://192.168.1.15:8087/user/checkuser/" + rfidDao.get().getUserid() + "";
            logger.info("Userid " + uri);

            RestTemplate restTemplate = new RestTemplate();
            try {

//                 result = restTemplate.getForObject(uri, Object.class);

                result = restTemplate.getForObject(uri, Success.class);

            } catch (Exception e) {

            }

        } else

            return new ResponseEntity<>(new Error(HttpStatus.BAD_REQUEST, "No Data Found"), HttpStatus.BAD_REQUEST);

        if (result == null)
            return new ResponseEntity<>(new Error(HttpStatus.BAD_REQUEST, "No Data Found"), HttpStatus.BAD_REQUEST);

        else {
            Optional<VehicleMasterDao> vehicleMasterDao = irfidqrService.getFindById(Long.parseLong(String.valueOf(rfidDao.get().getVehicleno())));

            return new ResponseEntity<>(new Success(HttpStatus.OK, new RfidResult(rfidDao, result.getResponse(), vehicleMasterDao)), HttpStatus.OK);

        }

    }


    @RequestMapping(value = "/insertvehiclerecords", method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody VehiclReportDao vehiclReportDao) {
        try {


            if (sqlRepository.rfidcheckAlreadyLoggedornotVerify(vehiclReportDao.getUserid()) != null) {

                long vehicleid = Long.parseLong(sqlRepository.rfidcheckAlreadyLoggedornotVerify(vehiclReportDao.getUserid()));
                logger.info("inside" + vehicleid);
               // sendOtp(vehiclReportDao.getMobileno(), "Dear " + vehiclReportDao.getUserid() + ",\n" + "You have logged out in " + LocalDateTime.now());

                return new ResponseEntity<>(new Success(HttpStatus.OK, sqlRepository.rfidupdate(vehicleid, vehiclReportDao.getUserid())), HttpStatus.OK);

            } else {
                irfidqrService.insertReport(vehiclReportDao);

               // sendOtp(vehiclReportDao.getMobileno(), "Dear " + vehiclReportDao.getUserid() + ",\n" + "You have logged in " + LocalDateTime.now());

                logger.info("inserted");

            }
        } catch (ConstraintViolationException e) { // detailed Exception is different by DBMS and JPA implemetation
            throw new UserAlreadyExistsException(e);
        }

        return new ResponseEntity<>(new Success(HttpStatus.OK, "Created Success"), HttpStatus.OK);
    }

    @RequestMapping(value = "/sendOtp", method = RequestMethod.POST)
    public ResponseEntity<Object> sendOtp(@RequestParam("mobileno") String mobileno, String message) {
        final String uri = "http://smsstreet.in/websms/sendsms.aspx?userid=prematix&password=matixpre&sender=ETOWNS&mobileNo=" + mobileno + "&msg=" + message + "";

            RestTemplate restTemplate = new RestTemplate();
      String result = restTemplate.getForObject(uri, String.class);

//
        if (result.contains("Success"))
            return new ResponseEntity<>(new Success(HttpStatus.OK, message), HttpStatus.OK);
        else
            return new ResponseEntity<>(new Success(HttpStatus.BAD_REQUEST, "Otp Not Send to User"), HttpStatus.BAD_REQUEST);


    }

}
