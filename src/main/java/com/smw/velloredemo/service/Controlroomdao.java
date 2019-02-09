package com.smw.velloredemo.service;

import com.smw.velloredemo.Pojo.vehiclereportpojo;
import com.smw.velloredemo.dao.VehiclReportDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.SimpleDateFormat;
import java.util.List;

@Repository
@Transactional
public class Controlroomdao  {


    @PersistenceContext
    private EntityManager manager;


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    public  List<Object> addPerson() {
        Session session = this.sessionFactory.getCurrentSession();


        List<Object> personsList = session.createNativeQuery("select * from vehiclereport where DATE(intime) BETWEEN  CAST('2019-01-24' AS DATE) AND CAST('2019-01-24' AS DATE) order by vehicleno").list();
return  personsList;

    }
//
//

//
//    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//    String fromDate= format.parse(from_date);
//    String toDate= format.parse(to_date);
//
//
//    Query query = session.createQuery("FROM Order_headers oh WHERE oh.merchant_code = :merchant_code AND oh.branch_code = :branch_code AND oh.order_date BETWEEN fromDate AND toDate");
//
//query.setParameter( "fromDate", fromDate);
//query.setParameter( "toDate", toDate );
//
//    public List<Object> getAllRecords() {
//        List<Object> employees = manager.createNativeQuery("select * from vehiclereport where DATE(intime) BETWEEN  CAST('2019-01-24' AS DATE) AND CAST('2019-01-24' AS DATE) order by vehicleno")
//                .getResultList();
//
//        Query q = em.createNativeQuery("SELECT a.id, a.firstname, a.lastname, count(b.id) as numBooks FROM Author a JOIN BookAuthor ba on a.id = ba.authorid JOIN Book b ON b.id = ba.bookid GROUP BY a.id", "AuthorValueMapping");
//        List<AuthorValue> authors = q.getResultList();
//
//        return employees;
//    }

}
