package com.smw.velloredemo.Controllers;


import com.smw.velloredemo.dao.CompliantDao;
import com.smw.velloredemo.dao.DistrictDao;
import com.smw.velloredemo.dao.WardDao;
import com.smw.velloredemo.repository.DistrictRepo;
import com.smw.velloredemo.repository.WardRepo;
import com.smw.velloredemo.response.Success;
import com.smw.velloredemo.service.ICompliant;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RequestMapping("/compliant")
@RestController
public class CompliantController {


    private final ICompliant compliantService;


    @Autowired
    private DistrictRepo districtRepo;


    @Autowired
    private WardRepo wardRepo;

    @Autowired
    public CompliantController(ICompliant compliantService) {
        this.compliantService = compliantService;
    }


    @PostMapping("/insertCompliant")
    public ResponseEntity<Object> insertCompliant(@Valid @RequestBody CompliantDao compliantDao) {
        try {
            compliantDao.setAssignedby("Iniyan");
            compliantService.insertCompliant(compliantDao);


        } catch (ConstraintViolationException e) { // detailed Exception is different by DBMS and JPA implemetation
            throw new IllegalArgumentException("Compliant not Inserted");
        }

        return new ResponseEntity<>(new Success(HttpStatus.CREATED, "New Compliant is created successfully"), HttpStatus.CREATED);
    }


    @GetMapping("/getCompliantType")
    public ResponseEntity<Object> getCompliantType() {

        if (compliantService.getCompliantType().size() > 0)
            return new ResponseEntity<>(new Success(HttpStatus.OK, compliantService.getCompliantType()), HttpStatus.OK);
        else
            return new ResponseEntity<>(new Success(HttpStatus.INTERNAL_SERVER_ERROR, "No Records Found"), HttpStatus.INTERNAL_SERVER_ERROR);


    }

    @GetMapping("/getPriorityType")
    public ResponseEntity<Object> getPriorityType() {

        if (compliantService.getCompliantPriority().size() > 0)
            return new ResponseEntity<>(new Success(HttpStatus.OK, compliantService.getCompliantPriority()), HttpStatus.OK);
        else
            return new ResponseEntity<>(new Success(HttpStatus.INTERNAL_SERVER_ERROR, "No Records Found"), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @GetMapping("/userCompliant/userid/{id}")
    public ResponseEntity<Object> getCompliant(@PathVariable("id") String id) {

        if (compliantService.getfindbyCompliantUserid(id).size() > 0)
            return new ResponseEntity<>(new Success(HttpStatus.OK, compliantService.getfindbyCompliantUserid(id)), HttpStatus.OK);
        else
            return new ResponseEntity<>(new Success(HttpStatus.INTERNAL_SERVER_ERROR, "No Records Found"), HttpStatus.INTERNAL_SERVER_ERROR);

    }


    @GetMapping("/userCompliant/getalldistrict")
    public ResponseEntity<Object> getAllDistrict() {

        return new ResponseEntity<>(new Success(HttpStatus.OK, districtRepo.findAll()), HttpStatus.OK);


    }


    @GetMapping("/userCompliant/getallwardbyid")
    public ResponseEntity<Object> getAllWardNobasedOnId(@RequestParam("districtid") long districtid) {


        return new ResponseEntity<>(new Success(HttpStatus.OK, wardRepo.findDistrictId(districtid)), HttpStatus.OK);


    }

    @PutMapping("/userCompliant/raiseCompliant")
    public ResponseEntity<Object> getRaiseCompliant(
            @RequestParam("compliantid") long compliantid, @RequestParam("statusissues") String statusissuess) {

       compliantService.updateraiseCompliant(compliantid, statusissuess);
        return new ResponseEntity<>(new Success(HttpStatus.OK, "Updated Success"), HttpStatus.OK);


    }


}
