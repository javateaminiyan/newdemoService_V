package com.smw.velloredemo.service;

import com.smw.velloredemo.dao.CompliantDao;
import com.smw.velloredemo.dao.CompliantPriorityTypeDao;
import com.smw.velloredemo.dao.CompliantTypeDao;
import com.smw.velloredemo.repository.Compliant_DropDownRepo;
import com.smw.velloredemo.repository.Compliant_PriorityRepo;

import java.util.List;
import java.util.Optional;

public interface ICompliant {


    List<CompliantTypeDao> getCompliantType();

    List<CompliantPriorityTypeDao> getCompliantPriority();


    CompliantDao insertCompliant(CompliantDao compliantTypeDao);

    List<CompliantDao> getfindbyCompliantUserid(String userid);


    void updateraiseCompliant(long compliantid, String statusissuess);
}
