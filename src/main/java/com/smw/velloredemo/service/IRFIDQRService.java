package com.smw.velloredemo.service;

import com.smw.velloredemo.dao.RFIDDao;
import com.smw.velloredemo.dao.VehiclReportDao;
import com.smw.velloredemo.dao.VehicleMasterDao;

import java.util.Optional;

public interface IRFIDQRService {


    Optional<RFIDDao> getUserandVehicleDetails(String input);


    Optional<VehicleMasterDao> getFindById(Long id);



    VehiclReportDao insertReport(VehiclReportDao vehiclReportDao);
}
