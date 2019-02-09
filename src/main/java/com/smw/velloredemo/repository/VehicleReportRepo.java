package com.smw.velloredemo.repository;


import com.smw.velloredemo.dao.VehiclReportDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface VehicleReportRepo extends JpaRepository<VehiclReportDao, Long> {


    @Query(value = "select sum(wet)  ,sum(dry)  ,sum(dry + wet) , count(distinct(vehicleno))  from vehiclereport   where  DATE(intime) =  DATE(NOW())", nativeQuery = true)
    public String todayreport();


    @Query(value = "select sum(wet) as wetcount ,sum(dry) as drycount ,sum(dry + wet) as totalcount , count(distinct(vehicleno)) as vehiclecount from vehiclereport  WHERE DATE(intime) BETWEEN  CAST(:fromdate AS DATE) AND CAST(:todate AS DATE)", nativeQuery = true)
    public String fromandtodate(String fromdate, String todate);


    @Query(value = "select sum(wet) ,sum(dry)  ,sum(dry + wet) , count(distinct(vehicleno)) from  swm.vehiclereport  where  \n" +
            "Date(intime) Between  CAST(:fromdate AS DATE) and  CAST(:todate AS DATE)  and  zoneid  in (:zoneid)", nativeQuery = true)
    public String getTotalzonefromandtodate(String fromdate, String todate, String[] zoneid);



    @Query(value = "select sum(wet)  ,sum(dry)  ,sum(dry + wet) , count(distinct(vehicleno)) from  swm.vehiclereport  where Date(intime) Between  CAST(:fromdate AS DATE) and  CAST(:todate AS DATE)  and  zoneid  in (:zoneid) and mccid  in (:mccid)", nativeQuery = true)
              public String getTotalzonewithmccfromandtodate(String fromdate, String todate, int[] zoneid,int[] mccid);





    @Query(value = "select sum(wet)  ,sum(dry)  ,sum(dry + wet) , count(distinct(vehicleno)) from  swm.vehiclereport  where  \n" +
            "Date(intime) Between  CAST(:fromdate AS DATE) and  CAST(:todate AS DATE)  and  zoneid  in (:zoneid) and mccid  in (:mccid)\n" +
            " and wardid  in (:wardid);", nativeQuery = true)

    public String getTotalzonewithmccandwardfromandtodate(String fromdate, String todate, int[] zoneid,int[] mccid,int[] wardid);



    @Query(value = "select sum(wet) as wetcount ,sum(dry) as drycount ,sum(dry + wet) as totalcount , count(distinct(vehicleno)) as vehiclecount from vehiclereport", nativeQuery = true)
    public String totaldatareport();


    @Query(value = "select sum(wet)  ,sum(dry)  ,sum(dry + wet) , count(distinct(vehicleno)) from  vehiclereport   where  DATE(intime) =  DATE(NOW())  && zoneid =:zoneid", nativeQuery = true)
    public String chooseIndividualzoneList(int zoneid);

    @Query(value = "select sum(wet)  ,sum(dry)  ,sum(dry + wet) , count(distinct(vehicleno)) from  vehiclereport   where  DATE(intime) =  DATE(NOW())  && zoneid in (:zoneid)", nativeQuery = true)
    public String chooseZone(int[] zoneid);


    @Query(value = "select sum(wet)  ,sum(dry)  ,sum(dry + wet) , count(distinct(vehicleno)) from  vehiclereport  where  DATE(intime) =  DATE(NOW())  && zoneid in (:zoneid) && mccid in (:mccid)", nativeQuery = true)
    public String choosezonewithmcc(int[] zoneid, int[] mccid);


    @Query(value = "select sum(wet)  ,sum(dry)  ,sum(dry + wet) , count(distinct(vehicleno)) from  vehiclereport  where  DATE(intime) =  DATE(NOW())  && zoneid in (:zoneid) && mccid in (:mccid) &&   wardid in (:wardid)", nativeQuery = true)
    public String choosezonewithmccward(int[] zoneid, int[] mccid, int[] wardid);


    @Query(value = "select sum(wet)  ,sum(dry)  ,sum(dry + wet) , count(distinct(vehicleno)) from  vehiclereport   where  DATE(intime) =  DATE(NOW())  && zoneid=:zoneid && mccid=:mcc && wardid=:wardid", nativeQuery = true)
    public String choosezonemccwithward(String zoneid, String mcc, String wardid);


    @Query(value = "select sum(wet)  ,sum(dry)  ,sum(dry + wet) , count(distinct(vehicleno)) from  vehiclereport   where  DATE(intime) =  DATE(NOW())  && wardid =:wardid", nativeQuery = true)
    public String chooseIndividualwardList(int wardid);

    @Query(value = "select sum(wet)  ,sum(dry)  ,sum(dry + wet) , count(distinct(vehicleno)) from  vehiclereport   where  DATE(intime) =  DATE(NOW())  && zoneid =:zoneid", nativeQuery = true)
    public String chooseIndividualMccList(int zoneid);

//
//    select sum(wet)  ,sum(dry)  ,sum(dry + wet) , count(distinct(vehicleno)) from  swm.vehiclereport   where  DATE(intime) =  DATE(NOW())   && mccid='411';
//
//    select sum(wet)  ,sum(dry)  ,sum(dry + wet) , count(distinct(vehicleno)) from  swm.vehiclereport   where  DATE(intime) =  DATE(NOW())   && mccid='411' && wardid='57' ;
//
//
//
//
//    select sum(wet)  ,sum(dry)  ,sum(dry + wet) , count(distinct(vehicleno)) from  swm.vehiclereport   where  DATE(intime) =  DATE(NOW())  && wardid='57' ;
//


//    @Query(value = "select * from vehiclereport where DATE(intime) BETWEEN  CAST(?1 AS DATE) AND CAST(?2 AS DATE) order by vehicleno", nativeQuery = true)
//    public Object reporttotalvehicle(String fromdate , String todate);

    @Query("select h from VehiclReportDao h  where intime BETWEEN '2019-01-24' and '2019-01-24' order by vehicleno")
    public Object reporttotalvehicle();


    @Query(value = "select d from VehiclReportDao  d WHERE vehicleno=:vehicleno  And DATE(intime) BETWEEN  CAST(:fromdate AS DATE) AND CAST(:todate AS DATE)", nativeQuery = true)
    public List<Object> reportvehiclewithfromtodate(String vehicleno, String fromdate, String todate);


    @Query(value = "select j from VehiclReportDao j  WHERE vehicleno=:vehicleno")
    public Optional<List<Object>> vehicleindividualreport(String vehicleno);


    @Query(value = "{call getTodayControlroomreport()}", nativeQuery = true)
    public List<Object> today();

    @Query("select h from VehiclReportDao h")
    List<VehiclReportDao> vehicleallrecords();

    @Query("select distinct (vehicleno) from VehiclReportDao h")
    List<VehiclReportDao> listofvehicleno();


}
