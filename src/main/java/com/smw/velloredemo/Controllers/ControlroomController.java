package com.smw.velloredemo.Controllers;


import com.smw.velloredemo.Pojo.*;
import com.smw.velloredemo.dao.VehiclReportDao;
import com.smw.velloredemo.dao.WardDao;
import com.smw.velloredemo.dao.ZoneDao;
import com.smw.velloredemo.repository.*;
import com.smw.velloredemo.response.Error;
import com.smw.velloredemo.response.Success;
import com.smw.velloredemo.service.Controlroomdao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@RequestMapping("/controlroom")
@RestController
public class ControlroomController {
    @Autowired
    UserDaoImpl userImp;

    @Autowired
    ZoneRepo zoneRepo;

    @Autowired
    WardRepo wardRepo;

    @Autowired
    MccRepo mccRepo;

    private static final Logger logger = LoggerFactory.getLogger(ControlroomController.class);
    LocalDateTime currentTime = LocalDateTime.now();

    private VehicleReportRepo vehicleReportRepo;

    public ControlroomController(VehicleReportRepo vehicleReportRepo) {
        this.vehicleReportRepo = vehicleReportRepo;
    }

    @GetMapping("/todayreport")
    public ResponseEntity<Object> todayreport() {


        if (!vehicleReportRepo.todayreport().isEmpty()) {
            String[] split = vehicleReportRepo.todayreport().split(",");
            logger.info("split" + split[0]);

            return new ResponseEntity<>(new Success(HttpStatus.OK, getdatastructure(split)), HttpStatus.OK);

        } else
            return new ResponseEntity<>(new Error(HttpStatus.BAD_REQUEST, "No Data Found"), HttpStatus.BAD_REQUEST);

    }


    @GetMapping("/fromandtodatereport")
    public ResponseEntity<Object> fromandtodatereport(@Valid @RequestParam("fromdate") String fromdate, @RequestParam("todate") String todate) {


        if (!vehicleReportRepo.fromandtodate(fromdate, todate).isEmpty()) {

            String[] split = vehicleReportRepo.fromandtodate(fromdate, todate).split(",");
            logger.info("split" + split[0]);

            return new ResponseEntity<>(new Success(HttpStatus.OK, getdatastructure(split)), HttpStatus.OK);

        } else
            return new ResponseEntity<>(new Error(HttpStatus.BAD_REQUEST, "No Data Found"), HttpStatus.BAD_REQUEST);

    }


    @GetMapping("/totaldatareport")
    public ResponseEntity<Object> totaldatareport() {


        if (!vehicleReportRepo.totaldatareport().isEmpty()) {

            String[] split = vehicleReportRepo.totaldatareport().split(",");
            logger.info("split" + split[0]);
            return new ResponseEntity<>(new Success(HttpStatus.OK, getdatastructure(split)), HttpStatus.OK);

        } else
            return new ResponseEntity<>(new Error(HttpStatus.BAD_REQUEST, "No Data Found"), HttpStatus.BAD_REQUEST);

    }


    @GetMapping("/findallZone")
    public ResponseEntity<Object> findallZones() {

        List<ZoneDao> zoneDao = zoneRepo.findAll();

        List<reportpojo> reportpojo1 = new ArrayList<>();

        for (ZoneDao zoneid : zoneDao) {
            String[] split = vehicleReportRepo.chooseIndividualzoneList(Integer.parseInt(String.valueOf(zoneid.getZoneId()))).split(",");
            logger.info("split" + split[0] + "---" + zoneid.getZoneId());
            //  return new ResponseEntity<>(new Success(HttpStatus.OK,  split[0]), HttpStatus.OK);

            reportpojo1.add(getdatastructure(split));
        }
        IndividualZoneReportPojo individualZoneReportPojo = new IndividualZoneReportPojo(zoneDao, reportpojo1);

        if (individualZoneReportPojo.getZone().size() > 0 && individualZoneReportPojo.getZoneReport().size() > 0)
            return new ResponseEntity<>(new Success(HttpStatus.OK, individualZoneReportPojo), HttpStatus.OK);

        else return new ResponseEntity<>(new Success(HttpStatus.NOT_FOUND, "No data Present"), HttpStatus.OK);

    }


    @PostMapping("/findallZoneWithDate")
    public ResponseEntity<Object> findallZones(@Valid @RequestBody String[] zoneitem,
                                               @RequestParam("fromdate") String fromdate,
                                               @RequestParam("todate") String todate) {


        if (!vehicleReportRepo.getTotalzonefromandtodate(fromdate, todate, zoneitem).isEmpty()) {

            String[] split = vehicleReportRepo.fromandtodate(fromdate, todate).split(",");
            logger.info("split" + split[0]);

            return new ResponseEntity<>(new Success(HttpStatus.OK, getdatastructure(split)), HttpStatus.OK);

        } else
            return new ResponseEntity<>(new Error(HttpStatus.BAD_REQUEST, "No Data Found"), HttpStatus.BAD_REQUEST);

    }


    @PostMapping("/findallZoneWithmccDate")
    public ResponseEntity<Object> findallzonewithmcc(@Valid @RequestBody ZonewithmccPojo zonewithmccPojo,
                                                     @RequestParam("fromdate") String fromdate,
                                                     @RequestParam("todate") String todate) {


        if (!vehicleReportRepo.getTotalzonewithmccfromandtodate(fromdate, todate, zonewithmccPojo.getZoneidarray(), zonewithmccPojo.getMccidarray()).isEmpty()) {

            String[] split = vehicleReportRepo.getTotalzonewithmccfromandtodate(fromdate, todate, zonewithmccPojo.getZoneidarray(), zonewithmccPojo.getMccidarray()).split(",");
            logger.info("split" + split[0]);

            return new ResponseEntity<>(new Success(HttpStatus.OK, getdatastructure(split)), HttpStatus.OK);

        } else
            return new ResponseEntity<>(new Error(HttpStatus.BAD_REQUEST, "No Data Found"), HttpStatus.BAD_REQUEST);

    }




    @PostMapping("/findallZoneWithmccandwardDate")
    public ResponseEntity<Object> findallzonewithmcc(@Valid @RequestBody Zonewithmccward zonewithmccward,
                                                     @RequestParam("fromdate") String fromdate,
                                                     @RequestParam("todate") String todate) {


        if (!vehicleReportRepo.getTotalzonewithmccandwardfromandtodate(fromdate, todate, zonewithmccward.getZoneidarray(), zonewithmccward.getMccidarray(),zonewithmccward.getWardidarray()).isEmpty()) {

            String[] split = vehicleReportRepo.getTotalzonewithmccandwardfromandtodate(fromdate, todate, zonewithmccward.getZoneidarray(), zonewithmccward.getMccidarray(),zonewithmccward.getWardidarray()).split(",");
            logger.info("split" + split[0]);

            return new ResponseEntity<>(new Success(HttpStatus.OK, getdatastructure(split)), HttpStatus.OK);

        } else
            return new ResponseEntity<>(new Error(HttpStatus.BAD_REQUEST, "No Data Found"), HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/findbyzoneid")
    public ResponseEntity<Object> findbyZoneId(


            @Valid @RequestBody long[] zoneidarray

    ) {


        List<ZoneDao> zoneDao = zoneRepo.findByZoneId(zoneidarray);

        List<reportpojo> reportpojo1 = new ArrayList<>();

        for (ZoneDao zoneid : zoneDao) {

            String[] split = vehicleReportRepo.chooseIndividualzoneList(Integer.parseInt(String.valueOf(zoneid.getZoneId()))).split(",");
            logger.info("split" + split[0] + "---" + zoneid.getZoneId());
            //  return new ResponseEntity<>(new Success(HttpStatus.OK,  split[0]), HttpStatus.OK);

            reportpojo1.add(getdatastructure(split));
        }

        IndividualZoneReportPojo individualZoneReportPojo = new IndividualZoneReportPojo(zoneDao, reportpojo1);

        if (individualZoneReportPojo.getZone().size() > 0 && individualZoneReportPojo.getZoneReport().size() > 0)
            return new ResponseEntity<>(new Success(HttpStatus.OK, individualZoneReportPojo), HttpStatus.OK);

        else return new ResponseEntity<>(new Success(HttpStatus.NOT_FOUND, "No data Present"), HttpStatus.OK);

    }


    @PostMapping("/findAllWards")
    public ResponseEntity<Object> findallwards(

            @Valid @RequestBody ZonewithmccPojo zonewithmccPojo

    ) {

        String[] zonearray = new String[]{zonewithmccPojo.getZoneidarray().toString()};


        String[] mccarray = new String[]{zonewithmccPojo.getMccidarray().toString()};
        logger.info("dddddd" + zonearray[0] + "---" + zonewithmccPojo.getMccidarray());

        List<WardDao> wardDaos = wardRepo.findbyzoneandward(zonewithmccPojo.getZoneidarray(), zonewithmccPojo.getMccidarray());

        List<reportpojo> reportpojo1 = new ArrayList<>();

        for (WardDao wardDaoId : wardDaos) {


            String[] split = vehicleReportRepo.chooseIndividualwardList(Integer.parseInt(String.valueOf(wardDaoId.getWardno()))).split(",");
            logger.info("split" + split[0] + "---" + wardDaoId);
            //  return new ResponseEntity<>(new Success(HttpStatus.OK,  split[0]), HttpStatus.OK);

            reportpojo1.add(getdatastructure(split));
        }

        IndividualWardReportPojo individualZoneReportPojo = new IndividualWardReportPojo(wardDaos, reportpojo1);

        if (individualZoneReportPojo.getWard().size() > 0 && individualZoneReportPojo.getWardReport().size() > 0)
            return new ResponseEntity<>(new Success(HttpStatus.OK, individualZoneReportPojo), HttpStatus.OK);

        else return new ResponseEntity<>(new Success(HttpStatus.NOT_FOUND, "No data Present"), HttpStatus.OK);


    }


    @PostMapping("/findallmcc")
    public ResponseEntity<Object> findallwards(
            @Valid @RequestBody String[] zoneidarray

    ) {


        List<MccDao> mccDaoList = mccRepo.findbyzone(zoneidarray);

        List<reportpojo> reportpojo1 = new ArrayList<>();

        for (MccDao mccDao : mccDaoList) {


            String[] split = vehicleReportRepo.chooseIndividualMccList(Integer.parseInt(String.valueOf(mccDao.getZoneid()))).split(",");
            logger.info("split" + split[0] + "---" + mccDao);
            //  return new ResponseEntity<>(new Success(HttpStatus.OK,  split[0]), HttpStatus.OK);

            reportpojo1.add(getdatastructure(split));
        }

        IndividualMccReportPojo individualMccReportPojo = new IndividualMccReportPojo(mccDaoList, reportpojo1);

        if (individualMccReportPojo.getMcc().size() > 0 && individualMccReportPojo.getMcc().size() > 0)
            return new ResponseEntity<>(new Success(HttpStatus.OK, individualMccReportPojo), HttpStatus.OK);

        else return new ResponseEntity<>(new Success(HttpStatus.NOT_FOUND, "No data Present"), HttpStatus.OK);

    }


    @PostMapping("/chooseZone")
    public ResponseEntity<Object> zonedata(@Valid @RequestBody int[] zoneidarray) {


        if (!vehicleReportRepo.chooseZone(zoneidarray).isEmpty()) {

            String[] split = vehicleReportRepo.chooseZone(zoneidarray).split(",");
            logger.info("split" + split[3]);


            return new ResponseEntity<>(new Success(HttpStatus.OK, getdatastructure(split)), HttpStatus.OK);

        } else
            return new ResponseEntity<>(new Error(HttpStatus.BAD_REQUEST, "No Data Found"), HttpStatus.BAD_REQUEST);


    }


    @PostMapping("/chooseZonewithmcc")
    public ResponseEntity<Object> zonewithmcc(@Valid @RequestBody ZonewithmccPojo zonewithmccPojo) {

        if (!vehicleReportRepo.choosezonewithmcc(zonewithmccPojo.getZoneidarray(), zonewithmccPojo.getMccidarray()).isEmpty()) {

            String[] split = vehicleReportRepo.choosezonewithmcc(zonewithmccPojo.getZoneidarray(), zonewithmccPojo.getMccidarray()).split(",");
            logger.info("split" + split[0]);


            return new ResponseEntity<>(new Success(HttpStatus.OK, getdatastructure(split)), HttpStatus.OK);

        } else
            return new ResponseEntity<>(new Error(HttpStatus.BAD_REQUEST, "No Data Found"), HttpStatus.BAD_REQUEST);


    }


    @PostMapping("/chooseZonewithmccandward")
    public ResponseEntity<Object> zonewithmcc(@Valid @RequestBody Zonewithmccward zonewithmccward) {


        if (!vehicleReportRepo.choosezonewithmccward(zonewithmccward.getZoneidarray(), zonewithmccward.getMccidarray(), zonewithmccward.getWardidarray()).isEmpty()) {

            String[] split = vehicleReportRepo.choosezonewithmccward(zonewithmccward.getZoneidarray(), zonewithmccward.getMccidarray(), zonewithmccward.getWardidarray()).split(",");
            logger.info("split" + split[0]);


            return new ResponseEntity<>(new Success(HttpStatus.OK, getdatastructure(split)), HttpStatus.OK);

        } else
            return new ResponseEntity<>(new Error(HttpStatus.BAD_REQUEST, "No Data Found"), HttpStatus.BAD_REQUEST);


    }


    @GetMapping("/reporttotalvehicle")
    public ResponseEntity<Object> reporttotalvehicle(@Valid @RequestParam("fromdate") String fromdate, @RequestParam("todate") String todate) {

        List users = userImp.responseEntity(fromdate, todate);

        if (users.size() > 0)
            return new ResponseEntity<>(new Success(HttpStatus.OK, users), HttpStatus.OK);

        else
            return new ResponseEntity<>(new Error(HttpStatus.BAD_REQUEST, "No Data Found"), HttpStatus.BAD_REQUEST);


    }


    @GetMapping("/vehicleallrecords")
    public ResponseEntity<Object> vehicleallrecords() {

        List<VehiclReportDao> users = vehicleReportRepo.vehicleallrecords();

        if (users.size() > 0)
            return new ResponseEntity<>(new Success(HttpStatus.OK, users), HttpStatus.OK);

        else
            return new ResponseEntity<>(new Error(HttpStatus.BAD_REQUEST, "No Data Found"), HttpStatus.BAD_REQUEST);


    }

    @GetMapping("/listofvehicleno")
    public ResponseEntity<Object> listofvehicleno() {

        List users = vehicleReportRepo.listofvehicleno();

        if (users.size() > 0)
            return new ResponseEntity<>(new Success(HttpStatus.OK, users), HttpStatus.OK);

        else
            return new ResponseEntity<>(new Error(HttpStatus.BAD_REQUEST, "No Data Found"), HttpStatus.BAD_REQUEST);


    }


    @GetMapping("/vehicleindividualreportwithdates")
    public ResponseEntity<Object> vehicleindividualreport(@Valid @RequestParam("fromdate") String fromdate, @RequestParam("todate") String todate, @RequestParam("vehicleno") String vehicleno) {

        List users = userImp.responseEntitywithVehicle(fromdate, todate, vehicleno);

        if (users.size() > 0)
            return new ResponseEntity<>(new Success(HttpStatus.OK, users), HttpStatus.OK);

        else
            return new ResponseEntity<>(new Error(HttpStatus.BAD_REQUEST, "No Data Found"), HttpStatus.BAD_REQUEST);


    }


    @GetMapping("/vehicleindividualreport")
    public ResponseEntity<Object> vehicleindividualreport(@RequestParam("vehicleno") String vehicleno) {


        if (vehicleReportRepo.vehicleindividualreport(vehicleno).isPresent()) {


            return new ResponseEntity<>(new Success(HttpStatus.OK, vehicleReportRepo.vehicleindividualreport(vehicleno)), HttpStatus.OK);

        } else
            return new ResponseEntity<>(new Error(HttpStatus.INTERNAL_SERVER_ERROR, "No Data Found"), HttpStatus.INTERNAL_SERVER_ERROR);

    }


    public reportpojo getdatastructure(String[] split) {

        reportpojo reportpojo = new reportpojo();

        reportpojo.setWetcount(split[0]).setDrycount(split[1]).setTotalcount(split[2]).setVehiclecount(split[3]);
        return reportpojo;
    }

    public vehiclereportpojo getreportdatastructure(String[] split) {


        vehiclereportpojo vehiclereportpojo = new vehiclereportpojo();

        vehiclereportpojo.
                setVehicleid(split[0])
                .setVehiclename(split[1])
                .setVehiclecapacity(split[2])
                .setVehicleinformation(split[3])
                .setUserid(split[4])
                .setMobileno(split[5])
                .setIntime(split[6])
                .setOuttime(split[7])
                .setUpdateby(split[8])
                .setRfid(split[9])
                .setTotalquantity(split[10])
                .setWet(split[11])
                .setDry(split[12])
                .setCreatedon(split[13])
                .setVehicleno(split[14])
                .setEntrytype(split[15]);

        return vehiclereportpojo;
    }


    @GetMapping("/insertuser")
    public void createUser() {
        User savedUser = userImp.create(getUser());
        User userFromDb = userImp.findUserById(savedUser.getId());

    }

    @GetMapping("/findAllUsers")
    public ResponseEntity<Success> findAllUsers() {
        List users = userImp.findAll();


        return new ResponseEntity<>(new Success(HttpStatus.OK, users), HttpStatus.BAD_REQUEST);


    }

    @GetMapping("/findUserById")
    public void findUserById() {
        User user = userImp.findUserById(1);

    }


    private User getUser() {
        User user = new User();
        user.setAddress("Bangalore, Karnataka");
        user.setEmail("johndoe@gmail.com");
        user.setName("John Doe");
        return user;
    }

}
