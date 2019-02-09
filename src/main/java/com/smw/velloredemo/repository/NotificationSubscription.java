package com.smw.velloredemo.repository;

import com.smw.velloredemo.dao.AlertSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationSubscription extends JpaRepository<AlertSubscription,Long> {
}
