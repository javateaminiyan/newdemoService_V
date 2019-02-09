package com.smw.velloredemo.service;

import com.smw.velloredemo.dao.RFIDDao;
import com.smw.velloredemo.dao.VehiclReportDao;
import com.smw.velloredemo.dao.VehicleMasterDao;
import com.smw.velloredemo.repository.RFIDQRRepo;
import com.smw.velloredemo.repository.VehicleMasterRepo;
import com.smw.velloredemo.repository.VehicleReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RFIDQRImplService implements IRFIDQRService {

     final RFIDQRRepo rfidqrRepo;

    final VehicleReportRepo vehicleReportRepo;

    final VehicleMasterRepo vehicleMasterRepo;

    @Autowired
    public RFIDQRImplService(RFIDQRRepo rfidqrRepo, VehicleMasterRepo vehicleMasterRepo, VehicleReportRepo vehicleReportRepo) {
        this.rfidqrRepo = rfidqrRepo;
        this.vehicleMasterRepo = vehicleMasterRepo;
        this.vehicleReportRepo = vehicleReportRepo;
    }

    @Override
    public Optional<RFIDDao> getUserandVehicleDetails(String input) {

        return rfidqrRepo.checkRfidorQR(input);


        //  findUserDetailsFromRfid
    }

    @Override
    public Optional<VehicleMasterDao> getFindById(Long id) {
        return vehicleMasterRepo.findById(id);
    }

    @Override
    public VehiclReportDao insertReport(VehiclReportDao vehiclReportDao) {
        return vehicleReportRepo.save(vehiclReportDao);
    }
}
