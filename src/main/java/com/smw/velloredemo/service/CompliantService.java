package com.smw.velloredemo.service;


import com.smw.velloredemo.dao.CompliantDao;
import com.smw.velloredemo.dao.CompliantPriorityTypeDao;
import com.smw.velloredemo.dao.CompliantTypeDao;
import com.smw.velloredemo.repository.Compliant_DropDownRepo;
import com.smw.velloredemo.repository.Compliant_PriorityRepo;
import com.smw.velloredemo.repository.Compliant_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompliantService implements ICompliant {


   private final Compliant_Repo compliantRepo;


    private  final Compliant_PriorityRepo compliant_priorityRepo;
    private final Compliant_DropDownRepo compliant_dropDownRepo;

    @Autowired
    public CompliantService(Compliant_Repo compliantRepo, Compliant_PriorityRepo compliant_priorityRepo, Compliant_DropDownRepo compliant_dropDownRepo) {
        this.compliantRepo = compliantRepo;
        this.compliant_priorityRepo = compliant_priorityRepo;
        this.compliant_dropDownRepo = compliant_dropDownRepo;
    }

    @Override
    public List<CompliantTypeDao> getCompliantType() {
        return compliant_dropDownRepo.findAll();
    }

    @Override
    public List<CompliantPriorityTypeDao> getCompliantPriority() {
        return compliant_priorityRepo.findAll();
    }

    @Override
    public CompliantDao insertCompliant(CompliantDao compliantDao) {
        return compliantRepo.save(compliantDao);
    }

    @Override
    public List<CompliantDao> getfindbyCompliantUserid(String userid) {
        return compliantRepo.findbyUserId(userid);
    }

    @Override
    public void updateraiseCompliant(long compliantid, String statusissuess) {
        compliantRepo.updatestatusissues(compliantid,statusissuess);
    }
}
